/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.ObjetoVO;

/**
 *
 * @author 181700271
 */
public class SubRacaDAO extends RacaDAO
{
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjetoVO[] listar() throws NoDataFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjetoVO[] pesquisar(ObjetoVO obVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
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
