public enum NomesTabelas {
    PERSONAGEM("Personagem"),
    USUARIO("Usuario");

    private final String nomeTabela;

    private NomesTabelas(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public String getNomeTabela() {return this.nomeTabela;}
}
