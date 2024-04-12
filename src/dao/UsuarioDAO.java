/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exception.NoUserFoundException;
import exception.WrongArgumentTypeException;
import java.util.ArrayList;
import modelo.LoginVO;
import modelo.ObjetoVO;
import modelo.UsuarioVO;
import persistencia.ConexaoBanco;
import utilidades.Converter;
import utilidades.Verificar;

/**
 *
 * @author dudup
 */
public class UsuarioDAO extends ObjetoDAO implements IDAO
{
    /*
        Usuario (
            idUsuario INT NOT NULL,
            idImagemUsuario INT NULL,
            idTipoUsuario INT NOT NULL,
            nomeUsuario VARCHAR(60) NOT NULL UNIQUE,
            senhaUsuario CHAR(60) NOT NULL,
            descricaoUsuario VARCHAR(60) NULL,
            quantPersonagensTotal INT NOT NULL DEFAULT 6,
            quantPersonagensCriados INT NOT NULL DEFAULT 0,
            dataCriacaoUsuario DATE NOT NULL,
            usuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    
    /**
     * 
     * @param lVO
     * @return 
     * @throws SQLException 
     * @throws NoUserFoundException 
     */
    public boolean login(LoginVO lVO) throws SQLException, NoUserFoundException
    {
        String sql = "SELECT * FROM usuario "
                + "WHERE nomeUsuario = ? "
                + "LIMIT 1";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setString(1, lVO.getUsuario());
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                if( (rs.next()) && (rs.getBoolean("usuarioAtivo")) )
                    return Verificar.compararTextoComHash(lVO.getSenha(), rs.getString("senhaUsuario"));
                else
                    throw new NoUserFoundException("Erro em UsuarioDAO.login: Nenhum usuário encontrado!");
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
     * @throws SQLException
     * @throws WrongArgumentTypeException 
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, WrongArgumentTypeException {
        if(obVO instanceof UsuarioVO)
        {
            UsuarioVO uVo = (UsuarioVO) obVO;
            String sql = "INSERT INTO usuario "
                    + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
            {
                pstm.setInt(1, uVo.getIdImagem());
                pstm.setInt(2, uVo.getIdTipo());
                pstm.setString(3, uVo.getNome());
                uVo.setSenha(Converter.converterTextoParaHash(uVo.getSenha()));
                pstm.setString(4, uVo.getSenha());
                pstm.setString(5, uVo.getDescricao());
                pstm.setInt(6, uVo.getQuantPersonagensTotal());
                pstm.setInt(7, uVo.getQuantPersonagensCriados());
                pstm.setDate(8, Converter.converterDiaMesAnoParaSQLDate(uVo.getDiaCriacao(), uVo.getMesCriacao(), uVo.getAnoCriacao()));
                pstm.setBoolean(10, uVo.isAtivo());

                pstm.execute();
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro no cadastro do usuário (UsuarioDAO.cadastrar)! " + se.getMessage());
            }
        }
        else
            throw new WrongArgumentTypeException("Erro em UsuarioDAO.cadastrar: O argumento deve pertencer a classe UsuarioVO!");
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public UsuarioVO[] listar() throws SQLException, NoUserFoundException
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
                uVO.setIdUsuario(rs.getInt("idUsuario"));
                uVO.setIdImagem(rs.getInt("idImagemUsuario"));
                uVO.setIdTipo(rs.getInt("idTipoUsuario"));
                uVO.setNome(rs.getString("nomeUsuario"));
                uVO.setSenha(rs.getString("senhaUsuario"));
                uVO.setDescricao(rs.getString("descricaoUsuario"));
                uVO.setQuantPersonagensTotal(rs.getInt("quantPersonagensTotal"));
                uVO.setQuantPersonagensCriados(rs.getInt("quantPersonagensCriados"));
                String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                uVO.setDiaCriacao(diaMesAno[0]);
                uVO.setMesCriacao(diaMesAno[1]);
                uVO.setAnoCriacao(diaMesAno[2]);
                uVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                
                listaUsuarios.add(uVO);
            }
            
            if(!listaUsuarios.isEmpty())
                return listaUsuarios.toArray(UsuarioVO[]::new);
            else
                throw new NoUserFoundException("Erro em UsuarioDAO.listar: Nenhum usuário registrado!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro na listagem de usuários (UsuarioDAO.listar)! " + se.getMessage());
        }
    }
    
    /**
     * 
     * @param query
     * @return
     * @throws SQLException 
     * @throws NoUserFoundException 
     */
    @Override
    public UsuarioVO[] pesquisar(String query) throws SQLException, NoUserFoundException
    {
        String sql = "SELECT * FROM usuario "
                + "WHERE " + query;
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            while(rs.next())
            {
                UsuarioVO uVO = new UsuarioVO();
                uVO.setIdUsuario(rs.getInt("idUsuario"));
                uVO.setIdImagem(rs.getInt("idImagemUsuario"));
                uVO.setIdTipo(rs.getInt("idTipoUsuario"));
                uVO.setNome(rs.getString("nomeUsuario"));
                uVO.setSenha(rs.getString("senhaUsuario"));
                uVO.setDescricao(rs.getString("descricaoUsuario"));
                uVO.setQuantPersonagensTotal(rs.getInt("quantPersonagensTotal"));
                uVO.setQuantPersonagensCriados(rs.getInt("quantPersonagensCriados"));
                String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                uVO.setDiaCriacao(diaMesAno[0]);
                uVO.setMesCriacao(diaMesAno[1]);
                uVO.setAnoCriacao(diaMesAno[2]);
                uVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                
                listaUsuarios.add(uVO);
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro na pesquisa de usuários (UsuarioDAO.pesquisar)! " + se.getMessage());
        }
        
        if(!listaUsuarios.isEmpty())
            return listaUsuarios.toArray(UsuarioVO[]::new);
        else
            throw new NoUserFoundException("Erro em UsuarioDAO.pesquisar: Nenhum usuário encontrado!");
    }
    
    /**
     * 
     * @param obVO
     * @throws SQLException
     * @throws WrongArgumentTypeException 
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, WrongArgumentTypeException {
        if(obVO instanceof UsuarioVO)
        {
            UsuarioVO uVO = (UsuarioVO) obVO;
            String sql = "UPDATE usuario SET "
                    + "idImagemUsuario = ?, "
                    + "idTipoUsuario = ?, "
                    + "idTipoUsuario = ?, "
                    + "nomeUsuario = ?, "
                    + "senhaUsuario = ?, "
                    + "descricaoUsuario = ?, "
                    + "quantPersonagensTotal = ?, "
                    + "quantPersonagensCriados = ?, "
                    + "usuarioAtivo = ? "
                    + "WHERE idUsuario = " + uVO.getIdUsuario();
            
            try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
            {
                pstm.setInt(1, uVO.getIdImagem());
                pstm.setInt(2, uVO.getIdTipo());
                pstm.setString(3, uVO.getNome());
                uVO.setSenha(Converter.converterTextoParaHash(uVO.getSenha()));
                pstm.setString(4, uVO.getSenha());
                pstm.setString(5, uVO.getDescricao());
                pstm.setInt(6, uVO.getQuantPersonagensTotal());
                pstm.setInt(7, uVO.getQuantPersonagensCriados());
                pstm.setDate(8, Converter.converterDiaMesAnoParaSQLDate(uVO.getDiaCriacao(), uVO.getMesCriacao(), uVO.getAnoCriacao()));
                pstm.setBoolean(10, uVO.isAtivo());

                pstm.executeUpdate();
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro ao alterar usuário (UsuarioDAO.alterar)! " + se.getMessage());
            }
        }
        else
            throw new WrongArgumentTypeException("Erro em UsuarioDAO.alterar: O argumento deve pertencer a classe UsuarioVO!");
    }
    
    /**
     * 
     * @param id
     * @throws SQLException
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
