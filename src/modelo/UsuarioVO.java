import java.sql.Date;
import java.util.HashMap;

public final class UsuarioVO extends ObjetoVO {
    // Nomes da tabela e suas colunas no banco de dados
    private static final String NOME_TABELA = NomesTabelas.USUARIO.getNomeTabela();
    private static final String[] NOMES_COLUNAS = receberNomesColunas();

    // Atributos
    private final int quantColunas = NOMES_COLUNAS.length;
    private final HashMap<String, Object> dadosUsuario = new HashMap<>();

    // Construtores
    public UsuarioVO() {
        super();
        inicializarDadosUsuario();
    }
    public UsuarioVO(int id, Date dataCadastro, boolean ativo, Object[] dadosUsuario) {
        super(id, dataCadastro, ativo);
        inicializarDadosUsuario(dadosUsuario);
    }
    
    // Getters e Setters
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}



    // Métodos privados
    private void inicializarDadosUsuario() {
        for (String nomeColuna : NOMES_COLUNAS) {
            this.dadosUsuario.put(nomeColuna, null);
        }
    }
    private void inicializarDadosUsuario(Object[] dadosUsuario) {
        if(dadosUsuario.length == quantColunas) {
            for (int i = 0; i < quantColunas; i++) {
                this.dadosUsuario.put(NOMES_COLUNAS[i], dadosUsuario[i]);
            }
        }
        else
            inicializarDadosUsuario();
    }
    private static String[] receberNomesColunas() {

    }

    // Métodos públicos
}
