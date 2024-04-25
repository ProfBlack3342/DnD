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
    public ObjetoVO[] listar() throws SQLException, NoUserFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ImagemVO pesquisar(int id) throws SQLException {
        String query = "SELECT * "
                + "FROM imagemUsuario "
                + "WHERE idimagemusuario = ?";
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(query);)
        {
            pstm.setInt(1, id);
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                if(rs.next()) {
                    ImagemVO iVO = new ImagemVO(
                            rs.getString("nomeimagemusuario"),
                            rs.getString("caminhoimagemusuario"),
                            rs.getString("descricaoimagemusuario")
                    );
                    return iVO;
                }
                else
                    return null;
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ImagemUsuarioDAO.pesquisar: " + se.getMessage());
        }
    }

    @Override
    public ObjetoVO[] pesquisar(String query) throws SQLException, NoUserFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
