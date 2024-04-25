/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.UsuarioDAO;
import exception.NoUserFoundException;
import exception.ForbiddenArgumentTypeException;
import objetosFront.Login;
import modelo.UsuarioVO;

/**
 *
 * @author dudup
 */
public final class UsuarioServicos
{
    /**
     * 
     * @param lVO
     * @return
     * @throws SQLException 
     * @throws NoUserFoundException 
     */
    public UsuarioVO loginUsuario(Login lVO) throws SQLException, NoUserFoundException
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
     * @throws NoUserFoundException 
     */
    public UsuarioVO[] listarUsuarios() throws SQLException, NoUserFoundException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.listar();
    }
    
    /**
     * 
     * @param pesquisa
     * @return
     * @throws SQLException 
     * @throws NoUserFoundException 
     */
    public UsuarioVO[] pesquisarUsuario(String pesquisa) throws SQLException, NoUserFoundException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.pesquisar(pesquisa);
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
