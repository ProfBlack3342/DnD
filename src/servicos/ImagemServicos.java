/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import modelo.ImagemUsuarioVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemServicos {
    
    public ImagemUsuarioVO pesquisarImagemUsuario(int id) throws SQLException, NoDataFoundException, IllegalArgumentException {
        String query = "SELECT * "
                + "FROM " + ImagemUsuarioVO.getNomeTabela() + " "
                + "WHERE " + ImagemUsuarioVO.getNomesColunas()[0] + " = ?";
        
        ImagemUsuarioVO iuVO = new ImagemUsuarioVO();
        iuVO.setId(id);
        
        return DAOFactory.getImagemDAO().pesquisar(iuVO, query, new int[]{0})[0];
    }
    
    public ImagemUsuarioVO[] pesquisarImagemUsuario(ImagemUsuarioVO iuVO, String query, int[] indicesDados) throws SQLException, NoDataFoundException, IllegalArgumentException {
        return DAOFactory.getImagemDAO().pesquisar(iuVO, query, indicesDados);
    }
}
