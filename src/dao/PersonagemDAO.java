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
import modelo.BackgroundVO;
import modelo.ClasseVO;
import modelo.ObjetoVO;
import modelo.PersonagemVO;
import modelo.RacaVO;
import modelo.SubRacaVO;
import modelo.SubclasseVO;
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
            
            pstm.execute();
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
            throw new SQLException("Erro na listagem de Personagens (PersonagemVO.listar)! " + se.getMessage());
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
        
        throw new UnsupportedOperationException("Not supported yet.");
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
            
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro ao alterar personagem (PersonagemVO.alterar)! " + se.getMessage());
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
            pstm.execute();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro ao excluir personagem (PersonagemVO.excluir)! " + se.getMessage());
        }
    }
    
}
