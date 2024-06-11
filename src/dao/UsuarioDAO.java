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
public final class UsuarioDAO extends ObjetoDAO
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
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public UsuarioVO login(DadosLogin dadosLogin) throws NoDataFoundException, SQLException
    {
        String[] nomesColunas = UsuarioVO.getNomesColunas();
        
        String sql = "SELECT * "
                + "FROM " + UsuarioVO.getNomeTabela() + " "
                + "WHERE " + nomesColunas[3] + " = ? "
                + "LIMIT 1";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setString(1, dadosLogin.getUsuario());
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                if( (rs.next()) && (rs.getBoolean(nomesColunas[11])) )
                {
                    String hash = rs.getString(nomesColunas[4]);
                    if(Verificar.compararTextoComHash(dadosLogin.getHashSenha(), hash))
                    {
                        UsuarioVO uVO = new UsuarioVO();
                        
                        uVO.setId(rs.getInt(nomesColunas[0]));
                        
                        uVO.setIdImagem(rs.getInt(nomesColunas[1]));
                        uVO.setIdTipo(rs.getInt(nomesColunas[2]));
                        uVO.setNomeUsuario(rs.getString(nomesColunas[3]));
                        uVO.setSenhaUsuario(hash);
                        uVO.setEmailUsuario(rs.getString(nomesColunas[5]));
                        uVO.setDataAniversarioUsuario(rs.getDate(nomesColunas[6]));
                        
                        uVO.setDescricaoUsuario(rs.getString(nomesColunas[7]));
                        uVO.setQuantPersonagensTotal(rs.getInt(nomesColunas[8]));
                        uVO.setQuantPersonagensCriados(rs.getInt(nomesColunas[9]));
                        
                        uVO.setDataCriacao(rs.getDate(nomesColunas[10]));
                        uVO.setAtivo(rs.getBoolean(nomesColunas[11]));
                        
                        return uVO;
                    }
                    else
                        throw new NoDataFoundException("Erro em UsuarioDAO.login: Senha inválida!");
                }
                else
                    throw new NoDataFoundException("Erro em UsuarioDAO.login: Usuário não encontrado!");
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
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException
    {
        UsuarioVO uVO = (UsuarioVO) obVO;
        String sql = "INSERT INTO " + UsuarioVO.getNomeTabela() + " "
                + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, uVO.getIdImagem());
            pstm.setInt(2, uVO.getIdTipo());
            pstm.setString(3, uVO.getNomeUsuario());
            pstm.setString(4, Converter.converterTextoParaHash(uVO.getSenhaUsuario()));
            pstm.setString(5, uVO.getEmailUsuario());
            pstm.setDate(6, uVO.getDataAniversarioUsuario());
            pstm.setString(7, uVO.getDescricaoUsuario());
            pstm.setInt(8, uVO.getQuantPersonagensTotal());
            pstm.setInt(9, uVO.getQuantPersonagensCriados());

            pstm.setDate(10, uVO.getDataCriacao());
            pstm.setBoolean(11, uVO.isAtivo());

            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em UsuarioDAO.cadastrar: " + se.getMessage());
        }
    }
    
    /**
     * 
     * @return
     * @throws NoDataFoundException
     * @throws SQLException
     */
    @Override
    public UsuarioVO[] listar() throws NoDataFoundException, SQLException
    {
        String sql = "SELECT * FROM " + UsuarioVO.getNomeTabela();

        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
            String[] nomesColunas = UsuarioVO.getNomesColunas();
            
            while(rs.next())
            {
                UsuarioVO uVO = new UsuarioVO();
                        
                uVO.setId(rs.getInt(nomesColunas[0]));

                uVO.setIdImagem(rs.getInt(nomesColunas[1]));
                uVO.setIdTipo(rs.getInt(nomesColunas[2]));
                uVO.setNomeUsuario(rs.getString(nomesColunas[3]));
                uVO.setSenhaUsuario(rs.getString(nomesColunas[4]));
                uVO.setEmailUsuario(rs.getString(nomesColunas[5]));
                uVO.setDataAniversarioUsuario(rs.getDate(nomesColunas[6]));

                uVO.setDescricaoUsuario(rs.getString(nomesColunas[7]));
                uVO.setQuantPersonagensTotal(rs.getInt(nomesColunas[8]));
                uVO.setQuantPersonagensCriados(rs.getInt(nomesColunas[9]));

                uVO.setDataCriacao(rs.getDate(nomesColunas[10]));
                uVO.setAtivo(rs.getBoolean(nomesColunas[11]));
                
                listaUsuarios.add(uVO);
            }
            
            if(!listaUsuarios.isEmpty())
                return listaUsuarios.toArray(new UsuarioVO[listaUsuarios.size()]);
            else
                throw new NoDataFoundException("Erro em UsuarioDAO.listar: Nenhum usuário registrado!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em UsuarioDAO.listar: " + se.getMessage());
        }
    }
    
    /**
     * 
     * @param oVO
     * @param query
     * @param indicesDados
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    @Override
    public UsuarioVO[] pesquisar(ObjetoVO oVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException
    {
        UsuarioVO uVO = (UsuarioVO) oVO;
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(query);)
        {
            
            for(int i = 1; i <= indicesDados.length; i++) {
                switch(indicesDados[i - 1])
                {
                    case 0:
                        pstm.setInt(i, uVO.getId());
                        break;
                    case 1:
                        pstm.setInt(i, uVO.getIdImagem());
                        break;
                    case 2:
                        pstm.setInt(i, uVO.getIdTipo());
                        break;
                    case 3:
                        pstm.setString(i, uVO.getNomeUsuario());
                        break;
                    case 4:
                        pstm.setString(i, uVO.getSenhaUsuario());
                        break;
                    case 5:
                        pstm.setString(i, uVO.getEmailUsuario());
                        break;
                    case 6:
                        pstm.setDate(i, uVO.getDataAniversarioUsuario());
                        break;
                    case 7:
                        pstm.setString(i, uVO.getDescricaoUsuario());
                        break;
                    case 8:
                        pstm.setInt(i, uVO.getQuantPersonagensTotal());
                        break;
                    case 9:
                        pstm.setInt(i, uVO.getQuantPersonagensCriados());
                        break;
                    case 10:
                        pstm.setDate(i, uVO.getDataCriacao());
                        break;
                    case 11:
                        pstm.setBoolean(i, uVO.isAtivo());
                        break;
                    default:
                        throw new IllegalArgumentException("Erro em UsuarioDAO.pesquisar: Indice de dados não corresponde a nenhum em UsuarioVO!");
                }
            }
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<UsuarioVO> listaResultados = new ArrayList<>();
                String[] nomesColunas = UsuarioVO.getNomesColunas();
            
                while(rs.next())
                {
                    UsuarioVO uVOsaida = new UsuarioVO();
                    
                    uVOsaida.setId(rs.getInt(nomesColunas[0]));
                    uVOsaida.setIdImagem(rs.getInt(nomesColunas[1]));
                    uVOsaida.setIdTipo(rs.getInt(nomesColunas[2]));
                    uVOsaida.setNomeUsuario(rs.getString(nomesColunas[3]));
                    uVOsaida.setSenhaUsuario(nomesColunas[4]);
                    uVOsaida.setEmailUsuario(nomesColunas[5]);
                    uVOsaida.setDataAniversarioUsuario(rs.getDate(nomesColunas[6]));
                    uVOsaida.setDescricaoUsuario(nomesColunas[7]);
                    uVOsaida.setQuantPersonagensTotal(rs.getInt(nomesColunas[8]));
                    uVOsaida.setQuantPersonagensCriados(rs.getInt(nomesColunas[9]));
                    uVOsaida.setDataCriacao(rs.getDate(nomesColunas[10]));
                    uVOsaida.setAtivo(rs.getBoolean(nomesColunas[11]));

                    listaResultados.add(uVOsaida);
                }
                if(!listaResultados.isEmpty())
                    return listaResultados.toArray(new UsuarioVO[listaResultados.size()]);
                else
                    throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Nenhum usuário registrado com esses dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em UsuarioDAO.pesquisar: " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em UsuarioDAO.pesquisar: " + ie.getMessage());
        }
    }
    
    /**
     * 
     * @param obVO
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     * @throws IllegalArgumentException
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException
    {
        UsuarioVO uVO = (UsuarioVO) obVO;
        String[] nomesColunas = UsuarioVO.getNomesColunas();
        
        String sql = "UPDATE " + UsuarioVO.getNomeTabela() + " SET "
                + nomesColunas[1] + " = ?, "
                + nomesColunas[2] + " = ?, "
                + nomesColunas[3] + " = ?, "
                + nomesColunas[4] + " = ?, "
                + nomesColunas[5] + " = ?, "
                + nomesColunas[6] + " = ?, "
                + nomesColunas[7] + " = ?, "
                + nomesColunas[8] + " = ?, "
                + nomesColunas[9] + " = ?, "
                + nomesColunas[10] + " = ?, "
                + nomesColunas[11] + " = ? "
                + "WHERE " + nomesColunas[0] + " = ?";
        
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, uVO.getIdImagem());
            pstm.setInt(2, uVO.getIdTipo());
            pstm.setString(3, uVO.getNomeUsuario());
            pstm.setString(4, Converter.converterTextoParaHash(uVO.getSenhaUsuario()));
            pstm.setString(5, uVO.getEmailUsuario());
            pstm.setDate(6, uVO.getDataAniversarioUsuario());
            pstm.setString(7, uVO.getDescricaoUsuario());
            pstm.setInt(8, uVO.getQuantPersonagensTotal());
            pstm.setInt(9, uVO.getQuantPersonagensCriados());
            
            pstm.setDate(10, uVO.getDataCriacao());
            pstm.setBoolean(11, uVO.isAtivo());
            
            pstm.setInt(12, uVO.getId());

            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em UsuarioDAO.alterar: " + se.getMessage());
        }
    }
    
    /**
     * 
     * @param obVO
     * @throws SQLException Se houver algum erro na comunicação com o banco de dados
     */
    @Override
    public void excluir(ObjetoVO obVO) throws SQLException
    {
        UsuarioVO uVO = (UsuarioVO) obVO;
        
        String sql = "DELETE FROM " + UsuarioVO.getNomeTabela() + " "
                + "WHERE " + UsuarioVO.getNomesColunas()[0] + " = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, uVO.getId());
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em UsuarioDAO.excluir: " + se.getMessage());
        }
    }
}
