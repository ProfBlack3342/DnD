/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import utilidades.Converter;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public abstract class ObjetoVO
{
    /*
        Tabela (
            id INT NOT NULL,
            ... ,
            dataCriacaoImagemUsuario DATE NOT NULL,
            imagemUsuarioAtiva TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    
    private int id;
    private int diaCriacao;
    private int mesCriacao;
    private int anoCriacao;
    private Date dataCriacao;
    private boolean ativo;

    public ObjetoVO()
    {
        this.id = 0;
        this.diaCriacao = 0;
        this.mesCriacao = 0;
        this.anoCriacao = 0;
        this.dataCriacao = null;
        this.ativo = true;
    }
    public ObjetoVO(int id, Date dataCriacao)
    {
        this.id = id;
        this.dataCriacao = dataCriacao;
        setDiaMesAno(this.dataCriacao);
        this.ativo = true;
    }
    public ObjetoVO(int id, int diaCriacao, int mesCriacao, int anoCriacao)
    {
        this.id = id;
        this.diaCriacao = diaCriacao;
        this.mesCriacao = mesCriacao;
        this.anoCriacao = anoCriacao;
        setDataCriacao(this.diaCriacao, this.mesCriacao, this.anoCriacao);
        this.ativo = true;
    }
    
    private void setDataCriacao(int dia, int mes, int ano) {
        dataCriacao = Converter.converterDiaMesAnoParaSQLDate(
                Integer.toString(dia),
                Integer.toString(mes),
                Integer.toString(ano)
        );
    }
    private void setDiaMesAno(Date dataCriacao) {
        String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(dataCriacao);
        diaCriacao = Integer.parseInt(diaMesAno[0]);
        mesCriacao = Integer.parseInt(diaMesAno[1]);
        anoCriacao = Integer.parseInt(diaMesAno[2]);
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getDiaCriacao() {return diaCriacao;}
    public void setDiaCriacao(int diaCriacao)
    {
        this.diaCriacao = diaCriacao;
        if(mesCriacao > 0 && anoCriacao > 0)
            setDataCriacao(this.diaCriacao, mesCriacao, anoCriacao);
    }

    public int getMesCriacao() {return mesCriacao;}
    public void setMesCriacao(int mesCriacao)
    {
        this.mesCriacao = mesCriacao;
        if(diaCriacao > 0 && anoCriacao > 0)
            setDataCriacao(diaCriacao, this.mesCriacao, anoCriacao);
    }

    public int getAnoCriacao() {return anoCriacao;}
    public void setAnoCriacao(int anoCriacao)
    {
        this.anoCriacao = anoCriacao;
        if(diaCriacao > 0 && mesCriacao > 0)
            setDataCriacao(diaCriacao, mesCriacao, this.anoCriacao);
    }

    public Date getDataCriacao() {return dataCriacao;}
    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
        if(this.dataCriacao != null)
            setDiaMesAno(this.dataCriacao);
        else
        {
            diaCriacao = 0;
            mesCriacao = 0;
            anoCriacao = 0;
        }
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
