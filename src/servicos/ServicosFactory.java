/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

/**
 *
 * @author dudup
 */
public class ServicosFactory
{
    private static final UsuarioServicos usuarioSV = new UsuarioServicos();
    
    /**
     * 
     * @return 
     */
    public static UsuarioServicos getUsuarioServicos() {return usuarioSV;}
}
