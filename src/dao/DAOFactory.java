/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class DAOFactory
{
    private static final LoginDAO LOGIN_DAO = new LoginDAO();
    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    
    /**
     * 
     * @return 
     */
    public static LoginDAO getLoginDAO() {
        return LOGIN_DAO;
    }
    
    /**
     * 
     * @return 
     */
    public static UsuarioDAO getUsuarioDAO() {
        return USUARIO_DAO;
    }
}
