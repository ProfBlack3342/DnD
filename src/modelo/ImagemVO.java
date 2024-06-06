/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemVO extends ObjetoVO
{
    private String caminhoImagem, descricaoImagem;

    public String getCaminhoImagem() {return caminhoImagem;}
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getDescricaoImagem() {return descricaoImagem;}
    public void setDescricaoImagem(String descricaoImagem) {
        this.descricaoImagem = descricaoImagem;
    }
}
