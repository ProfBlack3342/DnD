/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.BackgroundVO;

/**
 *
 * @author 181700271
 */
public class BackgroundServicos {
    public BackgroundVO[] listarBackgrounds() throws NoDataFoundException, SQLException {
        return DAOFactory.getBackgroundDAO().listar();
    }
}
