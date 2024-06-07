/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.UsuarioDAO;
import exception.NoDataFoundException;
import exception.ForbiddenArgumentTypeException;
import objetosFront.DadosLogin;
import modelo.UsuarioVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class UsuarioServicos
{
    /**
     * 
     * @param lVO
     * @return
     * @throws SQLException 
     * @throws NoDataFoundException 
     */
    public UsuarioVO loginUsuario(DadosLogin lVO) throws SQLException, NoDataFoundException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.login(lVO);
    }
    
    /**
     * 
     * @param uVO
     * @throws SQLException
     * @throws ForbiddenArgumentTypeException 
     */
    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException, ForbiddenArgumentTypeException 
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.cadastrar(uVO);
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     * @throws NoDataFoundException 
     */
    public UsuarioVO[] listarUsuarios() throws SQLException, NoDataFoundException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.listar();
    }
    
    public UsuarioVO[] pesquisarUsuario(boolean[] filtros, String[] dados) throws SQLException, NoDataFoundException
    {
        
    }
    
    /**
     * 
     * @param filtros
     * @param dados
     * @return
     * @throws SQLException 
     * @throws NoDataFoundException 
     */
    public UsuarioVO[] pesquisarUsuario(boolean[] filtros, String[] dados) throws SQLException, NoDataFoundException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.pesquisar(filtros, dados);
    }
    
    /**
     * 
     * @param uVO
     * @throws SQLException
     * @throws ForbiddenArgumentTypeException 
     */
    public void alterarUsuario(UsuarioVO uVO) throws SQLException, ForbiddenArgumentTypeException 
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.alterar(uVO);
    }
    
    /**
     * 
     * @param idUsuario
     * @throws SQLException 
     */
    public void excluirUsuario(int idUsuario) throws SQLException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.excluir(idUsuario);
    }
}
