/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.NoUserFoundException;
import exception.WrongArgumentTypeException;
import java.sql.SQLException;
import modelo.ObjetoVO;

/**
 *
 * @author 181700271
 */
public final class PersonagemDAO extends ObjetoDAO implements IDAO {

    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, WrongArgumentTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjetoVO[] listar() throws SQLException, NoUserFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjetoVO[] pesquisar(String query) throws SQLException, NoUserFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, WrongArgumentTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}