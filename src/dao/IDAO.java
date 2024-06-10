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
 * @author Eduardo Pereira Moreira
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
     * @param obVO
     * @param query
     * @param indicesDados
     * @return
     * @throws SQLException 
     * @throws NoDataFoundException 
     */
    ObjetoVO[] pesquisar(ObjetoVO obVO, String query, int[] indicesDados) throws SQLException, NoDataFoundException;
    
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
