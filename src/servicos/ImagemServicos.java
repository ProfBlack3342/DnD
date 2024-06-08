/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import modelo.ImagemPersonagemVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemServicos {
    
    public ImagemPersonagemVO pesquisarImagemUsuario(int id) throws SQLException, NoDataFoundException, IllegalArgumentException {
        return DAOFactory.getImagemDAO().pesquisar(id);
    }
    
    public ImagemPersonagemVO[] pesquisarImagemUsuario(ImagemPersonagemVO ipVO) throws SQLException, NoDataFoundException, IllegalArgumentException {
        return DAOFactory.getImagemDAO().pesquisar(ipVO);
    }
}
