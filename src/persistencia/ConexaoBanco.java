/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class ConexaoBanco
{
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public Connection getConexao() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/dnd?useTimezone=true&serverTimezone=UTC&user=root&password=@Imlolz3342";
        Connection c;
        try { c = DriverManager.getConnection(url); }
        catch (SQLException se) {
            throw new SQLException("Erro em retornar a conexão com o banco de dados(ConexaoBanco.getConexao)! " + se.getMessage());
        }
        return c;
    }
}
