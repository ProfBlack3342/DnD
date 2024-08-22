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
import modelo.ClasseVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700271
 */
public class ClasseDAO extends ObjetoDAO
{
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClasseVO[] listar() throws NoDataFoundException, SQLException {
        String sql = "SELECT * FROM " + ClasseVO.getNomeTabela();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
             ArrayList<ClasseVO> listaClasses = new ArrayList<>();
             String[] nomesColunas = ClasseVO.getNomesColunas();
             
             while(rs.next())
             {
                 ClasseVO cVO = new ClasseVO();
                 
                 cVO.setId(rs.getInt(nomesColunas[0]));
                 
                 cVO.setIdImagem(rs.getInt(nomesColunas[1]));
                 cVO.setNome(rs.getString(nomesColunas[2]));
                 cVO.setDescricao(rs.getString(nomesColunas[3]));
                 cVO.setBonusProficienciaInicial(rs.getInt(nomesColunas[4]));
                 cVO.setDado(rs.getInt(nomesColunas[5]));
                 cVO.setQuantProficienciasArmas(rs.getInt(nomesColunas[6]));
                 cVO.setQuantProficienciasArmaduras(rs.getInt(nomesColunas[7]));
                 cVO.setQuantProficienciasFerramentas(rs.getInt(nomesColunas[8]));
                 cVO.setQuantProficienciasPericias(rs.getInt(nomesColunas[9]));
                 cVO.setQuantProficienciasSavesAtributos(rs.getInt(nomesColunas[10]));
                 cVO.setQuantEquipamentosIniciais(rs.getInt(nomesColunas[11]));
                 cVO.setQuantFeatures(rs.getInt(nomesColunas[12]));
                 cVO.setTemSpells(rs.getBoolean(nomesColunas[13]));
                 cVO.setIdAtributoSpell(rs.getInt(nomesColunas[14]));
                 
                 cVO.setDataCriacao(rs.getDate(nomesColunas[15]));
                 cVO.setAtivo(rs.getBoolean(nomesColunas[16]));
                 
                 listaClasses.add(cVO);
             }
             
             if(!listaClasses.isEmpty())
                 return listaClasses.toArray(new ClasseVO[listaClasses.size()]);
             else
                 throw new NoDataFoundException("Erro em ClasseDAO.listar: Nenhuma classe registrada!");
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ClasseDAO.listar: " + se.getMessage());
        }
    }

    @Override
    public ClasseVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
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
