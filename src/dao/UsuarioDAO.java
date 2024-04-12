/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;

import exception.WrongArgumentTypeException;
import modelo.ObjetoVO;
import modelo.UsuarioVO;

/**
 *
 * @author dudup
 */
public class UsuarioDAO extends ObjetoDAO implements IDAO
{
    /**
     * 
     * @param obVO
     * @throws SQLException
     * @throws WrongArgumentTypeException 
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, WrongArgumentTypeException {
        if(obVO instanceof UsuarioVO)
        {
            UsuarioVO uVo = (UsuarioVO) obVO;
            throw new UnsupportedOperationException("Not supported yet.");
        }
        else
            throw new WrongArgumentTypeException("Erro em UsuarioDAO.cadastrar: O argumento deve pertencer a classe UsuarioVO!");
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    @Override
    public UsuarioVO[] listar() throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * 
     * @param query
     * @return
     * @throws SQLException 
     */
    @Override
    public UsuarioVO[] pesquisar(String query) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * 
     * @param obVO
     * @throws SQLException
     * @throws WrongArgumentTypeException 
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, WrongArgumentTypeException {
        if(obVO instanceof UsuarioVO)
        {
            UsuarioVO uVo = (UsuarioVO) obVO;
            throw new UnsupportedOperationException("Not supported yet.");
        }
        else
            throw new WrongArgumentTypeException("Erro em UsuarioDAO.alterar: O primeiro argumento deve pertencer a classe UsuarioVO!");
    }
    
    /**
     * 
     * @param id
     * @throws SQLException 
     */
    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
