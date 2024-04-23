/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class ImagemVO extends ObjetoVO
{
    private String caminhoImagem;

    public ImagemVO(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
    
    public String getCaminhoImagem() {return caminhoImagem;}
}
