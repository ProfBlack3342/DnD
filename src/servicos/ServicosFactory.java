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
    private static final ImagemServicos IMAGEM_SERVICOS = new ImagemServicos();
    private static final UsuarioServicos USUARIO_SERVICOS = new UsuarioServicos();
    private static final PersonagemServicos PERSONAGEM_SERVICOS = new PersonagemServicos();
    
    /**
     * 
     * @return 
     */
    public static ImagemServicos getImagemServicos() {return IMAGEM_SERVICOS;}
    
    /**
     * 
     * @return 
     */
    public static UsuarioServicos getUsuarioServicos() {return USUARIO_SERVICOS;}
    
    /**
     *
     * @return
     */
    public static PersonagemServicos getPersonagemServicos() {return PERSONAGEM_SERVICOS;}
}
