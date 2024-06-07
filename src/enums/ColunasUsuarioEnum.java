/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum ColunasUsuarioEnum
{
    /*
        Usuario (
            idUsuario INT NOT NULL,
            idImagemUsuario INT NULL,
            idTipoUsuario INT NOT NULL,
            nomeUsuario VARCHAR(60) NOT NULL UNIQUE,
            senhaUsuario CHAR(60) NOT NULL,
            emailUsuario VARCHAR(60) NOT NULL,
            dataAniversarioUsuario DATE NOT NULL,
            descricaoUsuario VARCHAR(60) NULL,
            quantPersonagensTotal INT NOT NULL DEFAULT 6,
            quantPersonagensCriados INT NOT NULL DEFAULT 0,
            dataCriacaoUsuario DATE NOT NULL,
            usuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    
    ID_USUARIO("idUsuario", TiposDadosBancoEnum.INT, false),
    ID_IMAGEM_USUARIO("idImagemUsuario", TiposDadosBancoEnum.INT, true),
    ID_TIPO_USUARIO("idTipoUsuario", TiposDadosBancoEnum.INT, false),
    NOME_USUARIO("nomeUsuario", TiposDadosBancoEnum.VARCHAR, false),
    SENHA_USUARIO("senhaUsuario", TiposDadosBancoEnum.CHAR, false),
    EMAIL_USUARIO("emailUsuario", TiposDadosBancoEnum.VARCHAR, false),
    DATA_ANIVERSARIO_USUARIO("dataAniversarioUsuario", TiposDadosBancoEnum.DATE, false),
    DESCRICAO_USUARIO("descricaoUsuario", TiposDadosBancoEnum.VARCHAR, true),
    QUANT_PERSONAGENS_TOTAL("quantPersonagensTotal", TiposDadosBancoEnum.INT, false),
    QUANT_PERSONAGENS_CRIADOS("quantPersonagensCriados", TiposDadosBancoEnum.INT, false),
    DATA_CRIACAO_USUARIO("dataCriacaoUsuario", TiposDadosBancoEnum.DATE, false),
    USUARIO_ATIVO("usuarioAtivo", TiposDadosBancoEnum.TINYINT, false);
    
    private final String nome;
    private final TiposDadosBancoEnum tipoDado;
    private final boolean possivelNulo;

    private ColunasUsuarioEnum(String nome, TiposDadosBancoEnum tipoDado, boolean possivelNulo) {
        this.nome = nome;
        this.tipoDado = tipoDado;
        this.possivelNulo = possivelNulo;
    }

    public String getNome() {return nome;}
    public TiposDadosBancoEnum getTipoDado() {return tipoDado;}
    public boolean isPossivelNulo() {return possivelNulo;}
    
    public static int getQuantColunas() {return values().length;}
}
