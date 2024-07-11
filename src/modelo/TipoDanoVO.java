/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class TipoDanoVO extends ObjetoVO
{
//    TipoDano (
//    idTipoDano INT NOT NULL,
//    
//    nomeTipoDano VARCHAR(50) NOT NULL UNIQUE,
//    abreviacaoNomeTipoDano VARCHAR(2) NOT NULL UNIQUE,
//    descricaoTipoDano VARCHAR(400) NOT NULL,
//    
//    dataCriacaoTipoDano DATE NOT NULL,
//    tipoDanoAtivo TINYINT(1) NOT NULL DEFAULT 1
//    )
    private static final String NOME_TABELA = "tipodano";
    
    private static final String[] NOMES_COLUNAS = new String[]{
        "idTipoDano",
        "nomeTipoDano",
        "abreviacaoNomeTipoDano",
        "descricaoTipoDano",
        "dataCriacaoTipoDano",
        "tipoDanoAtivo"
    };
}
