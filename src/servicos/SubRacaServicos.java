/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.RacaVO;
import modelo.SubRacaVO;

/**
 *
 * @author 181700271
 */
public class SubRacaServicos {
    public SubRacaVO[] listarSubRacas() throws NoDataFoundException, SQLException {
        return DAOFactory.getSubRacaDAO().listar();
    }
    
    public SubRacaVO[] listarSubRacasDeRaca(int idRaca) throws NoDataFoundException, SQLException {
        return DAOFactory.getSubRacaDAO().listar(idRaca);
    }
}
