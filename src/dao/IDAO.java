/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;

import exception.NoDataFoundException;
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
     */
    void cadastrar(ObjetoVO obVO) throws SQLException;
    
    /**
     * 
     * @return
     * @throws NoDataFoundException 
     * @throws SQLException 
     */
    ObjetoVO[] listar() throws NoDataFoundException, SQLException;
    
    /**
     * 
     * @param obVO
     * @param query
     * @param indicesDados
     * @return
     * @throws IllegalArgumentException
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    ObjetoVO[] pesquisar(ObjetoVO obVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException;
    
    /**
     * 
     * @param obVO
     * @throws SQLException
     */
    void alterar(ObjetoVO obVO) throws SQLException;
    
    /**
     * 
     * @param obVO
     * @throws SQLException  
     */
    void excluir(ObjetoVO obVO)throws SQLException;
}
