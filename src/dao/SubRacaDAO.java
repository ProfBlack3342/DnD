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
import modelo.RacaVO;
import modelo.SubRacaVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700271
 */
public class SubRacaDAO extends ObjetoDAO
{
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubRacaVO[] listar() throws NoDataFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public SubRacaVO[] listar(int idRaca) throws NoDataFoundException, SQLException {
        String sql = "SELECT * FROM " + SubRacaVO.getNomeTabela() + 
                " WHERE " + SubRacaVO.getNomesColunas()[1] + " = " + idRaca;
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            ArrayList<SubRacaVO> listaSubracas = new ArrayList<>();
            String[] nomesColunas = SubRacaVO.getNomesColunas();
            
            while(rs.next())
            {
                SubRacaVO srVO = new SubRacaVO();
                
                srVO.setId(rs.getInt(nomesColunas[0]));
                
                srVO.setIdRaca(rs.getInt(nomesColunas[1]));
                srVO.setNome(rs.getString(nomesColunas[2]));
                srVO.setDescricao(rs.getString(nomesColunas[3]));
                srVO.setValorBuffAtributos(rs.getInt(nomesColunas[4]));
                srVO.setIdAtributoBuffado(rs.getInt(nomesColunas[5]));
                srVO.setQuantFeatures(rs.getInt(nomesColunas[6]));
                
                srVO.setDataCriacao(rs.getDate(nomesColunas[7]));
                srVO.setAtivo(rs.getBoolean(nomesColunas[8]));
                
                listaSubracas.add(srVO);
            }
            if(!listaSubracas.isEmpty())
                return listaSubracas.toArray(new SubRacaVO[listaSubracas.size()]);
            else
                throw new NoDataFoundException("Erro em SubRacaVO.listar: Nenhuma subraça registrada para esta raça!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em SubRacaDAO.listar: " + se.getMessage());
        }
    }

    @Override
    public SubRacaVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
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
