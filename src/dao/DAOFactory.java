/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class DAOFactory
{
    private static final ImagemUsuarioDAO IMAGEM_DAO = new ImagemUsuarioDAO();
    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    private static final PersonagemDAO PERSONAGEM_DAO = new PersonagemDAO();
    
    /**
     * 
     * @return 
     */
    public static ImagemUsuarioDAO getImagemDAO() {return IMAGEM_DAO;}
    
    /**
     * 
     * @return 
     */
    public static UsuarioDAO getUsuarioDAO() {return USUARIO_DAO;}
    
    /**
     *
     * @return
     */
    public static PersonagemDAO getPersonagemDAO() {return PERSONAGEM_DAO;}
}
