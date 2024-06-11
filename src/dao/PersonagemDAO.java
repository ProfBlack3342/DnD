/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.NoDataFoundException;
import modelo.ObjetoVO;
import modelo.PersonagemVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class PersonagemDAO extends ObjetoDAO implements IDAO
{
    /*
        Tabela Personagem (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            idImagemPersonagem INT NOT NULL,
            idClasse INT NOT NULL,
            idSubclasse INT NOT NULL,
            idRaca INT NOT NULL,
            idSubraca INT NOT NULL,
            idBackground INT NOT NULL,
            nomePersonagem VARCHAR(60) NULL,
            nivelPersonagem INT NOT NULL DEFAULT 1,
            xpPersonagem INT NOT NULL DEFAULT 0,
            inspiracaoPersonagem TINYINT(1) NOT NULL DEFAULT 0,
            descricaoPersonagem VARCHAR(2000) NULL,
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        String sql = "INSERT INTO " + PersonagemVO.getNomeTabela() + " "
                + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, pVO.getIdUsuario());
            pstm.setInt(2, pVO.getIdImagemPersonagem());
            pstm.setInt(3, pVO.getIdClasse());
            pstm.setInt(4, pVO.getIdSubclasse());
            pstm.setInt(5, pVO.getIdRaca());
            pstm.setInt(6, pVO.getIdSubraca());
            pstm.setInt(7, pVO.getIdBackground());
            pstm.setString(8, pVO.getNomePersonagem());
            pstm.setInt(9, pVO.getNivelPersonagem());
            pstm.setInt(10, pVO.getXpPersonagem());
            pstm.setBoolean(11, pVO.isInspirado());
            pstm.setString(12, pVO.getDescricaoPersonagem());
            pstm.setDate(13, pVO.getDataCriacao());
            pstm.setBoolean(14, pVO.isAtivo());
            
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro no cadastro do personagem (PersonagemDAO.cadastrar)! " + se.getMessage());
        }
    }

    /**
     *
     * @return
     * @throws NoDataFoundException
     * @throws SQLException
     */
    @Override
    public PersonagemVO[] listar() throws NoDataFoundException, SQLException
    {
        String query = "SELECT * FROM " + PersonagemVO.getNomeTabela();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();)
        {
            ArrayList<PersonagemVO> listaPersonagens = new ArrayList<>();
            String[] nomesColunas = PersonagemVO.getNomesColunas();
            
            while(rs.next())
            {
                PersonagemVO pVO = new PersonagemVO();
                
                pVO.setId(rs.getInt(nomesColunas[0]));
                
                pVO.setIdUsuario(rs.getInt(nomesColunas[1]));
                pVO.setIdImagemPersonagem(rs.getInt(nomesColunas[2]));
                pVO.setIdClasse(rs.getInt(nomesColunas[3]));
                pVO.setIdSubclasse(rs.getInt(nomesColunas[4]));
                pVO.setIdRaca(rs.getInt(nomesColunas[5]));
                pVO.setIdSubraca(rs.getInt(nomesColunas[6]));
                pVO.setIdBackground(rs.getInt(nomesColunas[7]));
                pVO.setNomePersonagem(rs.getString(nomesColunas[8]));
                pVO.setNivelPersonagem(rs.getInt(nomesColunas[9]));
                pVO.setXpPersonagem(rs.getInt(nomesColunas[10]));
                pVO.setInspirado(rs.getBoolean(nomesColunas[11]));
                pVO.setDescricaoPersonagem(rs.getString(nomesColunas[12]));
                
                pVO.setDataCriacao(rs.getDate(nomesColunas[13]));
                pVO.setAtivo(rs.getBoolean(nomesColunas[14]));
                
                listaPersonagens.add(pVO);
            }
            
            if(listaPersonagens.isEmpty())
                return null;
            else
                return listaPersonagens.toArray(new PersonagemVO[listaPersonagens.size()]);
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemVO.listar: " + se.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @param query
     * @param indicesDados
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    @Override
    public PersonagemVO[] pesquisar(ObjetoVO obVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(query);)
        {
            for(int i = 1; i <= indicesDados.length; i++) {
                switch(indicesDados[i - 1])
                {
                     case 0:
                        pstm.setInt(i, pVO.getId());
                        break;
                     case 1:
                         pstm.setInt(i, pVO.getIdUsuario());
                         break;
                     case 2:
                         pstm.setInt(i, pVO.getIdImagemPersonagem());
                         break;
                     case 3:
                         pstm.setInt(i, pVO.getIdClasse());
                         break;
                     case 4:
                         pstm.setInt(i, pVO.getIdSubclasse());
                         break;
                     case 5:
                         pstm.setInt(i, pVO.getIdRaca());
                         break;
                     case 6:
                         pstm.setInt(i, pVO.getIdSubraca());
                         break;
                     case 7:
                         pstm.setInt(i, pVO.getIdBackground());
                         break;
                     case 8:
                         pstm.setString(i, pVO.getNomePersonagem());
                         break;
                     case 9:
                         pstm.setInt(i, pVO.getNivelPersonagem());
                         break;
                     case 10:
                         pstm.setInt(i, pVO.getXpPersonagem());
                         break;
                     case 11:
                         pstm.setBoolean(i, pVO.isInspirado());
                         break;
                     case 12:
                         pstm.setString(i, pVO.getDescricaoPersonagem());
                         break;
                     case 13:
                         pstm.setDate(i, pVO.getDataCriacao());
                         break;
                     case 14:
                         pstm.setBoolean(i, pVO.isAtivo());
                         break;
                     default:
                         throw new IllegalArgumentException("Erro em PersonagemDAO.pesquisar: Indice de dados não corresponde a nenhum em PersonagemVO!");
                }
            }
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<PersonagemVO> listaResultados = new ArrayList<>();
                String[] nomesColunas = PersonagemVO.getNomesColunas();
                
                while(rs.next())
                {
                    PersonagemVO pVOsaida = new PersonagemVO();
                    
                    pVOsaida.setId(rs.getInt(nomesColunas[0]));
                    pVOsaida.setIdUsuario(rs.getInt(nomesColunas[1]));
                    pVOsaida.setIdImagemPersonagem(rs.getInt(nomesColunas[2]));
                    pVOsaida.setIdClasse(rs.getInt(nomesColunas[3]));
                    pVOsaida.setIdSubclasse(rs.getInt(nomesColunas[4]));
                    pVOsaida.setIdRaca(rs.getInt(nomesColunas[5]));
                    pVOsaida.setIdSubraca(rs.getInt(nomesColunas[6]));
                    pVOsaida.setIdBackground(rs.getInt(nomesColunas[7]));
                    pVOsaida.setNomePersonagem(rs.getString(nomesColunas[8]));
                    pVOsaida.setNivelPersonagem(rs.getInt(nomesColunas[9]));
                    pVOsaida.setXpPersonagem(rs.getInt(nomesColunas[10]));
                    pVOsaida.setInspirado(rs.getBoolean(nomesColunas[11]));
                    pVOsaida.setDescricaoPersonagem(rs.getString(nomesColunas[12]));
                    
                    pVOsaida.setDataCriacao(rs.getDate(nomesColunas[13]));
                    pVOsaida.setAtivo(rs.getBoolean(nomesColunas[14]));
                    
                    listaResultados.add(pVOsaida);
                }
                if(!listaResultados.isEmpty())
                    return listaResultados.toArray(new PersonagemVO[listaResultados.size()]);
                else
                    throw new NoDataFoundException("Erro em PersonagemDAO.pesquisar: Nenhum personagem registrado com esses dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemDAO.pesquisar: " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em PersonagemDAO.pesquisar: " + ie.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        String[] nomesColunas = PersonagemVO.getNomesColunas();
        
        String sql = "UPDATE " + PersonagemVO.getNomeTabela() + " SET "
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
                + nomesColunas[11] + " = ?, "
                + nomesColunas[12] + " = ?, "
                + nomesColunas[13] + " = ?, "
                + nomesColunas[14] + " = ? "
                + "WHERE" + nomesColunas[0] + " = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, pVO.getIdUsuario());
            pstm.setInt(2, pVO.getIdImagemPersonagem());
            pstm.setInt(3, pVO.getIdClasse());
            pstm.setInt(4, pVO.getIdSubclasse());
            pstm.setInt(5, pVO.getIdRaca());
            pstm.setInt(6, pVO.getIdSubraca());
            pstm.setInt(7, pVO.getIdBackground());
            pstm.setString(8, pVO.getNomePersonagem());
            pstm.setInt(9, pVO.getNivelPersonagem());
            pstm.setInt(10, pVO.getXpPersonagem());
            pstm.setBoolean(11, pVO.isInspirado());
            pstm.setString(12, pVO.getDescricaoPersonagem());
            pstm.setDate(13, pVO.getDataCriacao());
            pstm.setBoolean(14, pVO.isAtivo());
            
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemVO.alterar: " + se.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void excluir(ObjetoVO obVO) throws SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        String sql = "DELETE FROM " + PersonagemVO.getNomeTabela() + " "
                + "WHERE " + PersonagemVO.getNomesColunas()[0] + " = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, pVO.getId());
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemVO.excluir: " + se.getMessage());
        }
    }
    
}
