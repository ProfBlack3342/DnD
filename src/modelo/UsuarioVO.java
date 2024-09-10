package modelo;

import enums.TiposDadosObjetosVO;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public final class UsuarioVO extends ObjetoVO {
    // Nomes da tabela e suas colunas no banco de dados
    private static final String NOME_TABELA = "Usuario";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idUsuario",
        
        "idImagemUsuario",
        "idTipoUsuario",
        "nomeUsuario",
        "senhaUsuario",
        "emailUsuario",
        "dataAniversarioUsuario",
        "descricaoUsuario",
        "quantPersonagensTotalUsuario",
        "quantPersonagensCriadosUsuario",
        
        "dataCriacaoUsuario",
        "usuarioAtivo"
    };

    // Atributos
    private final HashMap<String, TiposDadosObjetosVO> tiposDadosUsuario;
    private final HashMap<String, Object> valoresDadosUsuario;

    // Construtores
    public UsuarioVO() {
        super();
        this.tiposDadosUsuario = new HashMap<>();
        this.valoresDadosUsuario = new HashMap<>();
        inicializarDadosUsuario();
    }
    public UsuarioVO(int id, Date dataCadastro, boolean ativo, HashMap<String, Object> dadosUsuario) throws IllegalArgumentException, NullPointerException {
        super(id, dataCadastro, ativo);
        this.tiposDadosUsuario = new HashMap<>();
        this.valoresDadosUsuario = new HashMap<>();
        inicializarDadosUsuario();
        try {
            setValoresDadosUsuario(dadosUsuario);
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
    
    @Override public void setId(int id) {
        super.setId(id);
        putValorDadoUsuario(NOMES_COLUNAS[0], id);
    }
    
    @Override public void setDataCadastro(Date dataCadastro) {
        super.setDataCadastro(dataCadastro);
        putValorDadoUsuario(NOMES_COLUNAS[10], dataCadastro);
    }
    @Override public void setDiaCadastro(int diaCadastro) {
        super.setDiaCadastro(diaCadastro);
        putValorDadoUsuario(NOMES_COLUNAS[10], getDataCadastro());
    }
    @Override public void setMesCadastro(int mesCadastro) {
        super.setMesCadastro(mesCadastro);
        putValorDadoUsuario(NOMES_COLUNAS[10], getDataCadastro());
    }
    @Override public void setAnoCadastro(int anoCadastro) {
        super.setAnoCadastro(anoCadastro);
        putValorDadoUsuario(NOMES_COLUNAS[10], getDataCadastro());
    }
    
    @Override public void setAtivo(boolean ativo) {
        super.setAtivo(ativo);
        putValorDadoUsuario(NOMES_COLUNAS[11], ativo);
    }
    
    public HashMap<String, TiposDadosObjetosVO> getTiposDadosUsuario() {
        return this.tiposDadosUsuario;
    }
    
    public HashMap<String, Object> getValoresDadosUsuario() {
        return this.valoresDadosUsuario;
    }
    public void setValoresDadosUsuario(HashMap<String, Object> valoresDadosUsuario) throws IllegalArgumentException, NullPointerException {
        try {
            if(verificarSeValoresDadosUsuarioValido(valoresDadosUsuario)) 
                this.valoresDadosUsuario.putAll(valoresDadosUsuario);
            else
                throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.setValoresDadosUsuario': Os dados informados contém um nome de coluna que não existe no banco de dados!");
        }
        catch(IllegalArgumentException ae) {
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.setValoresDadosUsuario': " + ae.getMessage());
        }
        catch(NullPointerException ne) {
            throw new NullPointerException("'NullPointerException' em 'UsuarioVO.setValoresDadosUsuario': " + ne.getMessage());
        }
    }

    // Métodos privados
    private void inicializarDadosUsuario() {
        for(int i = 0; i < NOMES_COLUNAS.length; i++){
            // Inicializando Tipos dos Dados do Usuário
            switch(i) {
                case 0:     // ID Usuário
                case 1:     // ID Imagem Usuário
                case 2:     // ID Tipo Usuário
                case 8:     // Quant Personagens Total Usuário
                case 9:     // Quant Personagens Criados Usuário
                   this.tiposDadosUsuario.put(NOMES_COLUNAS[i], TiposDadosObjetosVO.INT);
                   break;
                case 3:     // Nome Usuário
                case 4:     // Senha/Hash Usuário
                case 5:     // E-mail Usuário
                case 7:
                    this.tiposDadosUsuario.put(NOMES_COLUNAS[i], TiposDadosObjetosVO.STRING);
                    break;
                case 6:     // Data Aniversário Usuário
                case 10:    // Data Criação Usuário
                    this.tiposDadosUsuario.put(NOMES_COLUNAS[i], TiposDadosObjetosVO.DATE);
                    break;
                case 11:    // Usuário Ativo
                    this.tiposDadosUsuario.put(NOMES_COLUNAS[i], TiposDadosObjetosVO.BOOLEAN);
                    break;
            }
            // Inicializando Valores dos Dados do Usuário
            this.valoresDadosUsuario.put(NOMES_COLUNAS[i], null);
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
    
    private boolean verificarSeValoresDadosUsuarioValido(HashMap<String, Object> dadosCandidatos) throws IllegalArgumentException, NullPointerException {
        if(dadosCandidatos != null) {
            if(dadosCandidatos.size() <= NOMES_COLUNAS.length) {
                for(Map.Entry<String, Object> linha : valoresDadosUsuario.entrySet()) {
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
    public TiposDadosObjetosVO getTipoDadoUsuario(String nomeColuna) throws IllegalArgumentException {
        if(verificarSeNomeColunaValido(nomeColuna)) {
            return this.tiposDadosUsuario.get(nomeColuna);
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.getTipoDadoUsuario': Nome de coluna não corresponde a nenhuma no banco de dados!");
    }
    
    public Object getValorDadoUsuario(String nomeColuna) throws IllegalArgumentException {
        if(verificarSeNomeColunaValido(nomeColuna)) {
            return this.valoresDadosUsuario.get(nomeColuna);
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.getValorDadoUsuario': Nome de coluna não corresponde a nenhuma no banco de dados!"); 
    }
    public void putValorDadoUsuario(String nomeColuna, Object dado) throws IllegalArgumentException {
        if(verificarSeNomeColunaValido(nomeColuna)) {
            this.valoresDadosUsuario.put(nomeColuna, dado);
            
            if(nomeColuna.equals(NOMES_COLUNAS[0])) 
                setId((int)dado);
            else if(nomeColuna.equals(NOMES_COLUNAS[10]))
                setDataCadastro((Date)dado);
            else if(nomeColuna.equals(NOMES_COLUNAS[11]))
                setAtivo((boolean)dado);
        }
        else
            throw new IllegalArgumentException("'IllegalArgumentException' em 'UsuarioVO.putValorDadoUsuario': Nome de coluna não corresponde a nenhuma no banco de dados!");
    }
}
