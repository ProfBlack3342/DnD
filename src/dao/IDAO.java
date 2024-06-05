/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;

import exception.NoDataFoundException;
import exception.ForbiddenArgumentTypeException;
import modelo.ObjetoVO;

/**
 *
 * @author 181700271
 */
public interface IDAO
{
    /**
     * 
     * @param obVO
     * @throws SQLException
     * @throws ForbiddenArgumentTypeException 
     */
    void cadastrar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException;
    
    /**
     * 
     * @return
     * @throws SQLException 
     * @throws NoDataFoundException 
     */
    ObjetoVO[] listar() throws SQLException, NoDataFoundException;
    
    /**
     * 
     * @param opcao
     * @param dado
     * @return
     * @throws SQLException 
     * @throws NoDataFoundException 
     */
    ObjetoVO[] pesquisar(int opcao, String dado) throws SQLException, NoDataFoundException;
    
    /**
     * 
     * @param obVO
     * @throws SQLException
     * @throws ForbiddenArgumentTypeException 
     */
    void alterar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException;
    
    /**
     * 
     * @param id
     * @throws SQLException  
     */
    void excluir(int id)throws SQLException;
}
