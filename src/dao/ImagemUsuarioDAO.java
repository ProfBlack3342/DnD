/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.ForbiddenArgumentTypeException;
import exception.NoUserFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ImagemVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 181700271
 */
public class ImagemUsuarioDAO extends ObjetoDAO implements IDAO
{

    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImagemVO[] listar() throws SQLException, NoUserFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImagemVO[] pesquisar(String query) throws SQLException, NoUserFoundException {
        String queryInterna = "SELECT * "
                + "FROM imagemUsuario "
                + "WHERE " + query;
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(queryInterna);
                ResultSet rs = pstm.executeQuery();)
        {

            ArrayList<ImagemVO> listaResultados = new ArrayList<>();
            while(rs.next()) {
                ImagemVO iVO = new ImagemVO();
                iVO.setNomeImagem(rs.getString("nomeimagemusuario"));
                iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario"));     
                listaResultados.add(iVO);

            }
            if(!listaResultados.isEmpty())
                return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
            else
                throw new NoUserFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada!");
            
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ImagemUsuarioDAO.pesquisar: " + se.getMessage());
        }
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
