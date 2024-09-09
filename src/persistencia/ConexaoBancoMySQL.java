import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class ConexaoBancoMySQL
{
    // Dados do banco de dados alvo
    public static final String NOME_BANCO = "dnd";
    private static final String USUARIO_BANCO = "root";
    private static final String SENHA_BANCO = "";

    /** GetConexaoMySQL
     * Quando é chamada, esta função tenta recuperar e retornar uma conexão com o banco de dados especificado no código.
     * @return - A conexão com o banco de dados especificado.
     * @throws SQLException - Se a conexão não existir ou não for detectada.
     */
    public Connection getConexaoMySQL() throws SQLException {
        // URL da conexão a ser recuperada
        String url = "jdbc:mysql://localhost:3306/" + NOME_BANCO + "?useTimezone=true&serverTimezone=UTC&user=" + USUARIO_BANCO + "&password=" + SENHA_BANCO;
        Connection c;

        try
        {
            c = DriverManager.getConnection(url);
            return c;
        }
        catch (SQLException se)
        {
            throw new SQLException("'SQLException' em 'ConexaoBancoMySQL.getConexaoMySQL': " + se.getMessage());
        }
        
    }
}
