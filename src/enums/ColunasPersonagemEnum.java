/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum ColunasPersonagemEnum
{
    /*
        Tabela Personagem (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            idImagemPersonagem INT NOT NULL,
            idClasse INT NOT NULL,
            idSubclasse INT NOT NULL,
            idRaca INT NOT NULL,
            idSubraca INT NOT NULL,
            idBackground INT NOT NULL,
            nomePersonagem VARCHAR(60) NULL,
            nivelPersonagem INT NOT NULL DEFAULT 1,
            xpPersonagem INT NOT NULL DEFAULT 0,
            inspiracaoPersonagem TINYINT(1) NOT NULL DEFAULT 0,
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    
    ID_PERSONAGEM("", TiposDadosBancoEnum.INT, false),
    ID_USUARIO("", TiposDadosBancoEnum.INT, false),
    ID_IMAGEM_PERSONAGEM("", TiposDadosBancoEnum.INT, false),
    ID_CLASSE("", TiposDadosBancoEnum.INT, false),
    ID_SUBCLASSE("", TiposDadosBancoEnum.INT, false),
    ID_RACA("", TiposDadosBancoEnum.INT, false),
    ID_SUBRACA("", TiposDadosBancoEnum.INT, false),
    ID_BACKGROUND("", TiposDadosBancoEnum.INT, false),
    NOME_PERSONAGEM("", TiposDadosBancoEnum.VARCHAR, true),
    NIVEL_PERSONAGEM("", TiposDadosBancoEnum.INT, false),
    XP_PERSONAGEM("", TiposDadosBancoEnum.INT, false),
    INSPIRACAO_PERSONAGEM("", TiposDadosBancoEnum.TINYINT, false),
    DATA_CRIACAO_PERSONAGEM("", TiposDadosBancoEnum.DATE, false),
    PERSONAGEM_ATIVO("", TiposDadosBancoEnum.TINYINT, false);
    
    private final String nome;
    private final TiposDadosBancoEnum tipoDado;
    private final boolean possivelNulo;

    private ColunasPersonagemEnum(String nome, TiposDadosBancoEnum tipoDado, boolean possivelNulo) {
        this.nome = nome;
        this.tipoDado = tipoDado;
        this.possivelNulo = possivelNulo;
    }

    public String getNome() {return nome;}
    public TiposDadosBancoEnum getTipoDado() {return tipoDado;}
    public boolean isPossivelNulo() {return possivelNulo;}
    
    public static int getQuantColunas() {return values().length;}
}
