/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.NoDataFoundException;
import exception.ForbiddenArgumentTypeException;
import modelo.ObjetoVO;
import modelo.UsuarioVO;
import objetosFront.DadosLogin;
import persistencia.ConexaoBanco;
import utilidades.Converter;
import utilidades.Verificar;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class UsuarioDAO extends ObjetoDAO implements IDAO
{
    /*
        Usuario (
            idUsuario INT NOT NULL,
            idImagemUsuario INT NULL,
            idTipoUsuario INT NOT NULL,
            nomeUsuario VARCHAR(60) NOT NULL UNIQUE,
            senhaUsuario CHAR(60) NOT NULL,
            emailUsuario VARCHAR(60) NOT NULL,
            dataAniversarioUsuario DATE NOT NULL,
            descricaoUsuario VARCHAR(60) NULL,
            quantPersonagensTotal INT NOT NULL DEFAULT 6,
            quantPersonagensCriados INT NOT NULL DEFAULT 0,
            dataCriacaoUsuario DATE NOT NULL,
            usuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    
    /**
     * Realiza a verificação de dados para o login de um usuário
     * @param dadosLogin Objeto que contém os dados necessários para o login
     * @return O UsuarioVO correspondende aos dados informados, se corretos. Senão retorna null.
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     * @throws NoDataFoundException Se os dados informados não corresponderem a nenhum usuário do banco de dados
     */
    public UsuarioVO login(DadosLogin dadosLogin) throws SQLException, NoDataFoundException
    {
        String sql = "SELECT * FROM usuario "
                + "WHERE nomeUsuario = ? "
                + "LIMIT 1";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setString(1, dadosLogin.getUsuario());
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                if( (rs.next()) && (rs.getBoolean("usuarioAtivo")) )
                {
                    String hash = rs.getString("senhaUsuario");
                    if(Verificar.compararTextoComHash(dadosLogin.getSenha(), hash))
                    {
                        UsuarioVO uVO = new UsuarioVO();
                        
                        uVO.setId(rs.getInt("idUsuario"));
                        
                        uVO.setIdImagem(rs.getInt("idImagemUsuario"));
                        uVO.setIdTipo(rs.getInt("idTipoUsuario"));
                        uVO.setNome(rs.getString("nomeUsuario"));
                        uVO.setSenha(rs.getString("senhaUsuario"));
                        uVO.setEmail(rs.getString("emailUsuario"));
                        String[] diaMesAnoAniversario = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataAniversarioUsuario"));
                        uVO.setDiaAniversario(diaMesAnoAniversario[0]);
                        uVO.setMesAniversario(diaMesAnoAniversario[1]);
                        uVO.setAnoAniversario(diaMesAnoAniversario[2]);
                        uVO.setDescricao(rs.getString("descricaoUsuario"));
                        uVO.setQuantPersonagensMaxima(rs.getInt("quantPersonagensTotal"));
                        uVO.setQuantPersonagensExistentes(rs.getInt("quantPersonagensCriados"));
                        
                        String[] diaMesAnoCriacao = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                        uVO.setDiaCriacao(diaMesAnoCriacao[0]);
                        uVO.setMesCriacao(diaMesAnoCriacao[1]);
                        uVO.setAnoCriacao(diaMesAnoCriacao[2]);
                        uVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                        
                        return uVO;
                    }
                    else
                        return null;
                }
                else
                    throw new NoDataFoundException("Erro em UsuarioDAO.login: Usuário e/ou Senha inválidos!");
            }
        }
        catch(SQLException SE)
        {
            throw new SQLException("Erro em UsuarioDAO.login: " + SE.getMessage());
        }
    }
    
    /**
     * 
     * @param obVO
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     * @throws ForbiddenArgumentTypeException Se obVO não pertencer a classe UsuarioVO
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        if(!(obVO instanceof UsuarioVO))
            throw new ForbiddenArgumentTypeException("Erro em UsuarioDAO.cadastrar: O argumento deve pertencer a classe UsuarioVO!");
        else
        {
            UsuarioVO uVO = (UsuarioVO) obVO;
            String sql = "INSERT INTO usuario "
                    + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try(Connection con = new ConexaoBanco().getConexao();
                    PreparedStatement pstm = con.prepareStatement(sql);)
            {
                pstm.setInt(1, uVO.getIdImagem());
                pstm.setInt(2, uVO.getIdTipo());
                pstm.setString(3, uVO.getNome());
                uVO.setSenha(Converter.converterTextoParaHash(uVO.getSenha()));
                pstm.setString(4, uVO.getSenha());
                pstm.setString(5, uVO.getEmail());
                pstm.setDate(6, Converter.converterDiaMesAnoParaSQLDate(uVO.getDiaAniversario(), uVO.getMesAniversario(), uVO.getAnoAniversario()));
                pstm.setString(7, uVO.getDescricao());
                pstm.setInt(8, uVO.getQuantPersonagensMaxima());
                pstm.setInt(9, uVO.getQuantPersonagensExistentes());
                
                pstm.setDate(10, Converter.converterDiaMesAnoParaSQLDate(uVO.getDiaCriacao(), uVO.getMesCriacao(), uVO.getAnoCriacao()));
                pstm.setBoolean(11, true);

                pstm.execute();
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro no cadastro do usuário (UsuarioDAO.cadastrar)! " + se.getMessage());
            }
        }
    }
    
    /**
     * 
     * @return
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     */
    @Override
    public UsuarioVO[] listar() throws SQLException, NoDataFoundException
    {
        String sql = "SELECT * FROM usuario";
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            while(rs.next())
            {
                UsuarioVO uVO = new UsuarioVO();
                        
                uVO.setId(rs.getInt("idUsuario"));

                uVO.setIdImagem(rs.getInt("idImagemUsuario"));
                uVO.setIdTipo(rs.getInt("idTipoUsuario"));
                uVO.setNome(rs.getString("nomeUsuario"));
                uVO.setSenha(rs.getString("senhaUsuario"));
                uVO.setEmail(rs.getString("emailUsuario"));
                String[] diaMesAnoAniversario = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataAniversarioUsuario"));
                uVO.setDiaAniversario(diaMesAnoAniversario[0]);
                uVO.setMesAniversario(diaMesAnoAniversario[1]);
                uVO.setAnoAniversario(diaMesAnoAniversario[2]);
                uVO.setDescricao(rs.getString("descricaoUsuario"));
                uVO.setQuantPersonagensMaxima(rs.getInt("quantPersonagensTotal"));
                uVO.setQuantPersonagensExistentes(rs.getInt("quantPersonagensCriados"));

                String[] diaMesAnoCriacao = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                uVO.setDiaCriacao(diaMesAnoCriacao[0]);
                uVO.setMesCriacao(diaMesAnoCriacao[1]);
                uVO.setAnoCriacao(diaMesAnoCriacao[2]);
                uVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                
                listaUsuarios.add(uVO);
            }
            
            if(!listaUsuarios.isEmpty())
                return listaUsuarios.toArray(new UsuarioVO[listaUsuarios.size()]);
            else
                throw new NoDataFoundException("Erro em UsuarioDAO.listar: Nenhum usuário registrado!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro na listagem de usuários (UsuarioDAO.listar)! " + se.getMessage());
        }
    }
    
    /**
     * 
     * @param opcao
     * @param dado
     * @return
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     * @throws NoDataFoundException Se os dados informados não corresponderem a nenhum usuário do banco de dados
     */
    @Override
    public UsuarioVO[] pesquisar(int opcao, String dado) throws SQLException, NoDataFoundException
    {
        if(dado == null || dado.isEmpty() || dado.isBlank())
            throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Nenhum dado informado!");
        else
        {
            String sql;
            ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
            
            try(Connection con = new ConexaoBanco().getConexao();)
            {
                switch(opcao)
                {
                    case 1: // idUsuario
                    {
                        sql = "SELECT * "
                                + "FROM usuario "
                                + "WHERE idUsuario = ? "
                                + "LIMIT 1";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            pstm.setInt(1, Integer.parseInt(dado));
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    UsuarioVO uVO = new UsuarioVO();
                        
                                    uVO.setId(rs.getInt("idUsuario"));

                                    uVO.setIdImagem(rs.getInt("idImagemUsuario"));
                                    uVO.setIdTipo(rs.getInt("idTipoUsuario"));
                                    uVO.setNome(rs.getString("nomeUsuario"));
                                    uVO.setSenha(rs.getString("senhaUsuario"));
                                    uVO.setEmail(rs.getString("emailUsuario"));
                                    String[] diaMesAnoAniversario = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataAniversarioUsuario"));
                                    uVO.setDiaAniversario(diaMesAnoAniversario[0]);
                                    uVO.setMesAniversario(diaMesAnoAniversario[1]);
                                    uVO.setAnoAniversario(diaMesAnoAniversario[2]);
                                    uVO.setDescricao(rs.getString("descricaoUsuario"));
                                    uVO.setQuantPersonagensMaxima(rs.getInt("quantPersonagensTotal"));
                                    uVO.setQuantPersonagensExistentes(rs.getInt("quantPersonagensCriados"));

                                    String[] diaMesAnoCriacao = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                                    uVO.setDiaCriacao(diaMesAnoCriacao[0]);
                                    uVO.setMesCriacao(diaMesAnoCriacao[1]);
                                    uVO.setAnoCriacao(diaMesAnoCriacao[2]);
                                    uVO.setAtivo(rs.getBoolean("usuarioAtivo"));

                                    listaUsuarios.add(uVO);
                                }
                                if(!listaUsuarios.isEmpty())
                                    return listaUsuarios.toArray(new UsuarioVO[listaUsuarios.size()]);
                                else
                                    throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Nenhum usuário encontrado com os dados informados!");
                            }
                        }
                    }
                    
                    case 2: // 
                    {
                        
                    }
                    
                    
                    default:
                        throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Opção de pesquisa inválida!");
                }
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro na pesquisa de usuários (UsuarioDAO.pesquisar)! " + se.getMessage());
            }
        }
    }
    
    /**
     * 
     * @param obVO
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     * @throws ForbiddenArgumentTypeException Se obVO não pertencer a classe UsuarioVO
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        if(obVO instanceof UsuarioVO)
        {
            UsuarioVO uVO = (UsuarioVO) obVO;
            String sql = "UPDATE usuario SET "
                    + "idImagemUsuario = ?, "
                    + "idTipoUsuario = ?, "
                    + "nomeUsuario = ?, "
                    + "senhaUsuario = ?, "
                    + "emailUsuario = ?, "
                    + "dataAniversarioUsuario = ?"
                    + "descricaoUsuario = ?, "
                    + "quantPersonagensTotal = ?, "
                    + "quantPersonagensCriados = ?, "
                    + "usuarioAtivo = ? "
                    + "WHERE idUsuario = ?";
            
            try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
            {
                pstm.setInt(1, uVO.getIdImagem());
                pstm.setInt(2, uVO.getIdTipo());
                pstm.setString(3, uVO.getNome());
                uVO.setSenha(Converter.converterTextoParaHash(uVO.getSenha()));
                pstm.setString(4, uVO.getSenha());
                pstm.setString(5, uVO.getEmail());
                pstm.setDate(6, Converter.converterDiaMesAnoParaSQLDate(uVO.getDiaAniversario(), uVO.getMesAniversario(), uVO.getAnoAniversario()));
                pstm.setString(7, uVO.getDescricao());
                pstm.setInt(8, uVO.getQuantPersonagensMaxima());
                pstm.setInt(9, uVO.getQuantPersonagensExistentes());
                
                pstm.setBoolean(10, true);
                pstm.setInt(11, uVO.getId());

                pstm.executeUpdate();
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro ao alterar usuário (UsuarioDAO.alterar)! " + se.getMessage());
            }
        }
        else
            throw new ForbiddenArgumentTypeException("Erro em UsuarioDAO.alterar: O argumento deve pertencer a classe UsuarioVO!");
    }
    
    /**
     * 
     * @param id
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     */
    @Override
    public void excluir(int id) throws SQLException{
        String sql = "DELETE FROM usuario "
                + "WHERE idusuario = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, id);
            pstm.execute();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro ao excluir usuário (UsuarioDAO.excluirUsuario)! " + se.getMessage());
        }
    }
}
