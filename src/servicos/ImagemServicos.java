/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.ImagemUsuarioDAO;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.ImagemVO;

/**
 *
 * @author 181700271
 */
public class ImagemServicos {
    
    public ImagemVO[] pesquisarImagemUsuario(int opcao, String dado) throws SQLException, NoDataFoundException {
        ImagemUsuarioDAO iuDAO = DAOFactory.getImagemDAO();
        return iuDAO.pesquisar(opcao, dado);
    }
    
}
