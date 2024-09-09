package modelo;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public final class UsuarioVO extends ObjetoVO {
    // Nomes da tabela e suas colunas no banco de dados
    private static final String NOME_TABELA = "Usuario";
    private static final String[] NOMES_COLUNAS = new String[]{
        
    };

    // Atributos
    private final HashMap<String, Object> dadosUsuario;

    // Construtores
    public UsuarioVO() {
        super();
        this.dadosUsuario = new HashMap<>();
        inicializarDadosUsuario();
    }
    public UsuarioVO(int id, Date dataCadastro, boolean ativo, HashMap<String, Object> dadosUsuario) throws IllegalArgumentException, NullPointerException {
        super(id, dataCadastro, ativo);
        this.dadosUsuario = new HashMap<>();
        inicializarDadosUsuario();
        try {
            setDadosUsuario(dadosUsuario);
        }
        catch(IllegalArgumentException ae) {
            throw new IllegalArgumentException("'IllegalArgumentException' no construtor de 'UsuarioVO': " + ae.getMessage());
        }
        catch(NullPointerException ne) {
            throw new NullPointerException("'NullPointerException' no construtor de 'UsuarioVO': " + ne.getMessage());
        }
    }
    
    // Getters e Setters
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    
    public HashMap<String, Object> getDadosUsuario() {
        return this.dadosUsuario;
    }
    public void setDadosUsuario(HashMap<String, Object> dadosUsuario) throws IllegalArgumentException, NullPointerException {
        try {
            if(verificarSeDadosUsuarioValido(dadosUsuario)) 
                this.dadosUsuario.putAll(dadosUsuario);
            else
                throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.setDadosUsuario': Os dados informados contém um nome de coluna que não existe no banco de dados!");
        }
        catch(IllegalArgumentException ae) {
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.setDadosUsuario': " + ae.getMessage());
        }
        catch(NullPointerException ne) {
            throw new NullPointerException("'NullPointerException' em 'UsuarioVO.setDadosUsuario': " + ne.getMessage());
        }
    }

    // Métodos privados
    private void inicializarDadosUsuario() {
        for(String nomeColuna : NOMES_COLUNAS){
            this.dadosUsuario.put(nomeColuna, null);
        }
    }
    
    private boolean verificarSeNomeColunaValido(String nomeCandidato) {
        for(String nomeColuna : NOMES_COLUNAS) {
            if(nomeColuna.equals(nomeCandidato)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verificarSeDadosUsuarioValido(HashMap<String, Object> dadosCandidatos) throws IllegalArgumentException, NullPointerException {
        if(dadosCandidatos != null) {
            if(dadosCandidatos.size() <= NOMES_COLUNAS.length) {
                for(Map.Entry<String, Object> linha : dadosUsuario.entrySet()) {
                    if(!verificarSeNomeColunaValido(linha.getKey()))
                        return false;
                }
                return true;
            }
            else
                throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.verificarSeDadosUsuarioValido': Os dados informados possuem mais colunas do que existem na tabela do banco de dados!");
        }
        else
            throw new NullPointerException("'NullPointerException' em 'UsuarioVO.verificarSeDadosUsuarioValido': Dados informados possuem valor nulo!");
    }
    
    // Métodos Públicos
    public Object getDadoUsuario(String nomeColuna) throws IllegalArgumentException {
        if(verificarSeNomeColunaValido(nomeColuna)) {
            return this.dadosUsuario.get(nomeColuna);
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.getDadoUsuario': Nome de coluna não corresponde a nenhuma no banco de dados!"); 
    }
    
    public void putDadoUsuario(String nomeColuna, Object dado) throws IllegalArgumentException {
        if(verificarSeNomeColunaValido(nomeColuna))
            this.dadosUsuario.put(nomeColuna, dado);
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.setDadoUsuario': Nome de coluna não corresponde a nenhuma no banco de dados!");
    }
}
