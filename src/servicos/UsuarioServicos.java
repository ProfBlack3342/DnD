/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.UsuarioDAO;
import exception.WrongArgumentTypeException;
import modelo.UsuarioVO;

/**
 *
 * @author dudup
 */
public class UsuarioServicos
{
    /**
     * 
     * @param uVO
     * @throws SQLException
     * @throws WrongArgumentTypeException 
     */
    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException, WrongArgumentTypeException 
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.cadastrar(uVO);
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public UsuarioVO[] listarUsuarios() throws SQLException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.listar();
    }
    
    /**
     * 
     * @param pesquisa
     * @return
     * @throws SQLException 
     */
    public UsuarioVO[] pesquisarUsuario(String pesquisa) throws SQLException
    {
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.pesquisar(pesquisa);
    }
    
    /**
     * 
     * @param uVO
     * @throws SQLException
     * @throws WrongArgumentTypeException 
     */
    public void alterarUsuario(UsuarioVO uVO) throws SQLException, WrongArgumentTypeException 
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
