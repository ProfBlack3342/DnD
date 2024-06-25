/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.SubClasseVO;

/**
 *
 * @author 181700271
 */
public class SubClasseServicos {
    public SubClasseVO[] listarSubClasses() throws NoDataFoundException, SQLException {
        return DAOFactory.getSubClasseDAO().listar();
    }
    
    public SubClasseVO[] listarSubClassesDeClasse(int idClasse) throws NoDataFoundException, SQLException {
        return DAOFactory.getSubClasseDAO().listar(idClasse);
    }
}
