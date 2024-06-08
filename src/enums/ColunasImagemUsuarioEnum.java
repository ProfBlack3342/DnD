/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum ColunasImagemUsuarioEnum
{
    /*
        ImagemUsuario (
            idImagemUsuario INT NOT NULL,
            caminhoImagemUsuario VARCHAR(260) NOT NULL,
            descricaoImagemUsuario VARCHAR(60) NULL,
            dataCriacaoImagemUsuario DATE NOT NULL,
            imagemUsuarioAtiva TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    
    ID_IMAGEM_USUARIO("idImagemUsuario", TiposDadosBancoEnum.INT, false),
    CAMINHO_IMAGEM_USUARIO("caminhoImagemUsuario", TiposDadosBancoEnum.VARCHAR, false),
    DESCRICAO_IMAGEM_USUARIO("descricaoImagemUsuario", TiposDadosBancoEnum.VARCHAR, true),
    DATA_CRIACAO_IMAGEM_USUARIO("dataCriacaoImagemUsuario", TiposDadosBancoEnum.DATE, false),
    IMAGEM_USUARIO_ATIVA("imagemUsuarioAtiva", TiposDadosBancoEnum.TINYINT, false);
    
    private final String nome;
    private final TiposDadosBancoEnum tipo;
    private final boolean possivelNulo;

    private ColunasImagemUsuarioEnum(String nome, TiposDadosBancoEnum tipo, boolean possivelNulo) {
        this.nome = nome;
        this.tipo = tipo;
        this.possivelNulo = possivelNulo;
    }

    public String getNome() {return nome;}
    public TiposDadosBancoEnum getTipo() {return tipo;}
    public boolean isPossivelNulo() {return possivelNulo;}
    
    public static int getQuantColunas() {return values().length;}
}
