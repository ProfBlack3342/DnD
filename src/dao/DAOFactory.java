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
    private static final BackgroundDAO BACKGROUND_DAO = new BackgroundDAO();
    private static final ClasseDAO CLASSE_DAO = new ClasseDAO();
    private static final DescricaoPersonagemDAO DESCRICAO_PERSONAGEM_DAO = new DescricaoPersonagemDAO();
    private static final ImagemUsuarioDAO IMAGEM_DAO = new ImagemUsuarioDAO();
    private static final PersonagemDAO PERSONAGEM_DAO = new PersonagemDAO();
    private static final RacaDAO RACA_DAO = new RacaDAO();
    private static final SubClasseDAO SUBCLASSE_DAO = new SubClasseDAO();
    private static final SubRacaDAO SUBRACA_DAO = new SubRacaDAO();
    private static final UsuarioDAO USUARIO_DAO = new UsuarioDAO();
    
    /**
     *
     * @return
     */
    public static BackgroundDAO getBackgroundDAO() {return BACKGROUND_DAO;}

    /**
     *
     * @return
     */
    public static ClasseDAO getClasseDAO() {return CLASSE_DAO;}
    
    /**
     *
     * @return
     */
    public static DescricaoPersonagemDAO getDescricaoPersonagemDAO() {return DESCRICAO_PERSONAGEM_DAO;}
    
    /**
     * 
     * @return 
     */
    public static ImagemUsuarioDAO getImagemDAO() {return IMAGEM_DAO;}
    
    /**
     *
     * @return
     */
    public static PersonagemDAO getPersonagemDAO() {return PERSONAGEM_DAO;}

    /**
     *
     * @return
     */
    public static RacaDAO getRacaDAO() {return RACA_DAO;}

    /**
     *
     * @return
     */
    public static SubClasseDAO getSubClasseDAO() {return SUBCLASSE_DAO;}

    /**
     *
     * @return
     */
    public static SubRacaDAO getSubRacaDAO() {return SUBRACA_DAO;}
    
    /**
     * 
     * @return 
     */
    public static UsuarioDAO getUsuarioDAO() {return USUARIO_DAO;}
}
