/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.NoDataFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ObjetoVO;
import modelo.SubClasseVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700271
 */
public class SubClasseDAO extends ObjetoDAO
{
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubClasseVO[] listar() throws NoDataFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public SubClasseVO[] listar(int idClasse) throws NoDataFoundException, SQLException {
        String sql = "SELECT * FROM " + SubClasseVO.getNomeTabela() + 
                " WHERE " + SubClasseVO.getNomesColunas()[1] + " = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, idClasse);
                
            try (ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<SubClasseVO> listaSubclasses = new ArrayList<>();
                String [] nomesColunas = SubClasseVO.getNomesColunas();

                while(rs.next())
                {
                    SubClasseVO scVO = new SubClasseVO();

                    scVO.setId(rs.getInt(nomesColunas[0]));

                    scVO.setIdClasse(rs.getInt(nomesColunas[1]));
                    scVO.setIdImagem(rs.getInt(nomesColunas[2]));
                    scVO.setNome(rs.getString(nomesColunas[3]));
                    scVO.setDescricao(rs.getString(nomesColunas[4]));
                    scVO.setQuantFeatures(rs.getInt(nomesColunas[5]));

                    scVO.setDataCriacao(rs.getDate(nomesColunas[6]));
                    scVO.setAtivo(rs.getBoolean(nomesColunas[7]));

                    listaSubclasses.add(scVO);
                }
                if(!listaSubclasses.isEmpty())
                    return listaSubclasses.toArray(new SubClasseVO[listaSubclasses.size()]);
                else
                    throw new NoDataFoundException("Erro em SubClasseDAO.listar: Nenhuma subclasse registrada para esta classe!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em SubClasseDAO.listar: " + se.getMessage());
        }
        
    }

    @Override
    public SubClasseVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
