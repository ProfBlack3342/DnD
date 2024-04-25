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
    private final String nomeImagem, caminhoImagem, descricaoImagem;

    public ImagemVO(String nomeImagem, String caminhoImagem, String descricaoImagem) {
        this.nomeImagem = nomeImagem;
        this.caminhoImagem = caminhoImagem;
        this.descricaoImagem = descricaoImagem;
    }

    public String getCaminhoImagem() {return caminhoImagem;}
    public String getNomeImagem() {return nomeImagem;}
    public String getDescricaoImagem() {return descricaoImagem;}
}
