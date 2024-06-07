/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.ImagemUsuarioDAO;
import exception.NoDataFoundException;
import modelo.ImagemVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemServicos {
    
    public ImagemVO pesquisarImagemUsuario(int idImagem) throws SQLException, NoDataFoundException {
       return pesquisarImagemUsuario(
               new boolean[0],
               new String[]{Integer.toString(idImagem)}
       )[0];
    }
    
    public ImagemVO[] pesquisarImagemUsuario(boolean[] filtros, String[] dados) throws SQLException, NoDataFoundException {
        ImagemUsuarioDAO iuDAO = DAOFactory.getImagemDAO();
        return iuDAO.pesquisar(filtros, dados);
    }
    
}
