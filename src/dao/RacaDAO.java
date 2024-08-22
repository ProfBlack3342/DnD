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
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700271
 */
public class RacaDAO extends ObjetoDAO
{
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RacaVO[] listar() throws NoDataFoundException, SQLException {
        String sql = "SELECT * FROM " + RacaVO.getNomeTabela();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            ArrayList<RacaVO> listaRacas = new ArrayList<>();
            String[] nomesColunas = RacaVO.getNomesColunas();
            
            while(rs.next())
            {
                RacaVO rVO = new RacaVO();
                
                rVO.setId(rs.getInt(nomesColunas[0]));
                
                rVO.setIdImagem(rs.getInt(nomesColunas[1]));
                rVO.setNome(rs.getString(nomesColunas[2]));
                rVO.setDescricao(rs.getString(nomesColunas[3]));
                rVO.setValorBuffAtributo(rs.getInt(nomesColunas[4]));
                rVO.setIdAtributoBuffado(rs.getInt(nomesColunas[5]));
                rVO.setIdadeMax(rs.getInt(nomesColunas[6]));
                rVO.setTamanho(rs.getString(nomesColunas[7]));
                rVO.setVelocidade(rs.getInt(nomesColunas[8]));
                rVO.setQuantLinguagens(rs.getInt(nomesColunas[9]));
                rVO.setQuantFeatures(rs.getInt(nomesColunas[10]));
                
                rVO.setDataCriacao(rs.getDate(nomesColunas[11]));
                rVO.setAtivo(rs.getBoolean(nomesColunas[12]));
                
                listaRacas.add(rVO);
            }
            if(!listaRacas.isEmpty())
                return listaRacas.toArray(new RacaVO[listaRacas.size()]);
            else
                throw new NoDataFoundException("Erro em RacaVO.listar: Nenhuma raça registrada!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em RacaDAO.listar: " + se.getMessage());
        }
        
    }

    @Override
    public RacaVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
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
