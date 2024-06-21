/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class ServicosFactory
{
    private static final BackgroundServicos BACKGROUND_SERVICOS = new BackgroundServicos();
    private static final ClasseServicos CLASSE_SERVICOS = new ClasseServicos();
    private static final ImagemServicos IMAGEM_SERVICOS = new ImagemServicos();
    private static final PersonagemServicos PERSONAGEM_SERVICOS = new PersonagemServicos();
    private static final RacaServicos RACA_SERVICOS = new RacaServicos();
    private static final SubClasseServicos SUBCLASSE_SERVICOS = new SubClasseServicos();
    private static final SubRacaServicos SUBRACA_SERVICOS = new SubRacaServicos();
    private static final UsuarioServicos USUARIO_SERVICOS = new UsuarioServicos();
    
    /**
     *
     * @return
     */
    public static BackgroundServicos getBackgroundServicos() {return BACKGROUND_SERVICOS;}

    /**
     *
     * @return
     */
    public static ClasseServicos getClasseServicos() {return CLASSE_SERVICOS;}
    
    /**
     * 
     * @return 
     */
    public static ImagemServicos getImagemServicos() {return IMAGEM_SERVICOS;}
    
    /**
     *
     * @return
     */
    public static PersonagemServicos getPersonagemServicos() {return PERSONAGEM_SERVICOS;}

    /**
     *
     * @return
     */
    public static RacaServicos getRacaServicos() {return RACA_SERVICOS;}

    /**
     *
     * @return
     */
    public static SubClasseServicos getSubClasseServicos() {return SUBCLASSE_SERVICOS;}

    /**
     *
     * @return
     */
    public static SubRacaServicos getSubRacaServicos() {return SUBRACA_SERVICOS;}
    
    /**
     * 
     * @return 
     */
    public static UsuarioServicos getUsuarioServicos() {return USUARIO_SERVICOS;}
    
    
}
