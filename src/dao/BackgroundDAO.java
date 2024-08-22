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
import modelo.BackgroundVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700271
 */
public class BackgroundDAO extends ObjetoDAO
{
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BackgroundVO[] listar() throws NoDataFoundException, SQLException {
        String sql = "SELECT * FROM " + BackgroundVO.getNomeTabela();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            ArrayList<BackgroundVO> listaBackgrounds = new ArrayList<>();
            String[] nomesColunas = BackgroundVO.getNomesColunas();
            
            while(rs.next())
            {
                BackgroundVO bVO = new BackgroundVO();
                
                bVO.setId(rs.getInt(nomesColunas[0]));
                
                bVO.setNome(rs.getString(nomesColunas[1]));
                bVO.setDescricao(rs.getString(nomesColunas[2]));
                bVO.setOuroInicial(rs.getInt(nomesColunas[3]));
                bVO.setQuantOpcoesEquipamentosIniciais(rs.getInt(nomesColunas[4]));
                bVO.setQuantLinguagensIniciais(rs.getInt(nomesColunas[5]));
                bVO.setQuantProficienciasFerramentas(rs.getInt(nomesColunas[6]));
                bVO.setQuantProficienciasPericias(rs.getInt(nomesColunas[7]));
                bVO.setQuantFeatures(rs.getInt(nomesColunas[8]));
                
                bVO.setDataCriacao(rs.getDate(nomesColunas[9]));
                bVO.setAtivo(rs.getBoolean(nomesColunas[10]));
                
                listaBackgrounds.add(bVO);
            }
            
            if(!listaBackgrounds.isEmpty())
                return listaBackgrounds.toArray(new BackgroundVO[listaBackgrounds.size()]);
            else
                throw new NoDataFoundException("Erro em BackgroundVO.listar: Nenhuma background registrado!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em BackgroundVO.listar: " + se.getMessage());
        }
    }

    @Override
    public BackgroundVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
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
