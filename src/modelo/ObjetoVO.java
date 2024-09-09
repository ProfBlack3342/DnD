package modelo;

import java.sql.Date;
import utilidades.Utilidades;

public abstract class ObjetoVO {
    // Atributos
    private int id;
    private Date dataCadastro;
    private int diaCadastro, mesCadastro, anoCadastro;
    private boolean ativo;

    // Construtores
    public ObjetoVO() {
        this.id = 0;
        this.dataCadastro = new Date(System.currentTimeMillis());
        atualizarDiaMesAnoPelaData();
        this.ativo = true;
    }
    public ObjetoVO(int id, Date dataCadastro, boolean ativo) throws IllegalArgumentException {
        if(dataCadastro != null && Utilidades.verificarSeDataValida(dataCadastro)) {
            this.id = id;
            this.dataCadastro = dataCadastro;
            atualizarDiaMesAnoPelaData();
            this.ativo = ativo;
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' no construtor de 'ObjetoVO': A data informada é inválida!");
        
    }

    // Getters e Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Date getDataCadastro() {return dataCadastro;}
    public void setDataCadastro(Date dataCadastro) throws IllegalArgumentException {
        if(Utilidades.verificarSeDataValida(dataCadastro)){
            this.dataCadastro = dataCadastro;
            atualizarDiaMesAnoPelaData();
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'ObjetoVO.setDataCadastro': A data informada é inválida!");
    }

    public int getDiaCadastro() {return diaCadastro;}
    public void setDiaCadastro(int diaCadastro) throws IllegalArgumentException {
        if(Utilidades.verificarSeDiaValido(diaCadastro, this.mesCadastro, this.anoCadastro)) {
            this.diaCadastro = diaCadastro;
            atualizarDataPeloDiaMesAno();
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'ObjetoVO.setDiaCadastro': O dia informado é inválido!");
    }
    public int getMesCadastro() {return mesCadastro;}
    public void setMesCadastro(int mesCadastro) throws IllegalArgumentException {
        if(Utilidades.verificarSeMesValido(mesCadastro, this.anoCadastro)) {
            this.mesCadastro = mesCadastro;
            atualizarDataPeloDiaMesAno();
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'ObjetoVO.setMesCadastro': O mês informado é inválido!");
    }
    public int getAnoCadastro() {return anoCadastro;}
    public void setAnoCadastro(int anoCadastro) throws IllegalArgumentException {
        if(Utilidades.verificarSeAnoValido(anoCadastro)) {
            this.anoCadastro = anoCadastro;
            atualizarDataPeloDiaMesAno();
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'ObjetoVO.setAnoCadastro': O ano informado é inválido!");
    }
    public boolean isAtivo() {return ativo;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}

    // Métodos privados/internos
    private void atualizarDiaMesAnoPelaData() {
        String[] diaMesAno = Utilidades.converterSQLDateParaDiaMesAno(this.dataCadastro);
        this.diaCadastro = Integer.parseInt(diaMesAno[0]);
        this.mesCadastro = Integer.parseInt(diaMesAno[1]);
        this.anoCadastro = Integer.parseInt(diaMesAno[2]);
    }
    private void atualizarDataPeloDiaMesAno() {
        this.dataCadastro = Utilidades.converterDiaMesAnoParaSQLDate(
            ( (this.diaCadastro < 10) ?  ("0" + this.diaCadastro) : (Integer.toString(this.diaCadastro)) ),
            ( (this.mesCadastro < 10) ?  ("0" + this.mesCadastro) : (Integer.toString(this.mesCadastro)) ),
            ( Integer.toString(this.anoCadastro) )
        );
    }
}
