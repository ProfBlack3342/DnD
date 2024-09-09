package dao;

import java.sql.SQLException;
import modelo.ObjetoVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public interface IDAOMySQL
{
    /**
     * Método para registrar dados novos em uma tabela no banco
     * @param oVO - Um objeto contendo os dados a serem registrados.
     * @throws SQLException
     */
    void insert(ObjetoVO oVO, String query) throws SQLException;

    /**
     * Método para listar todos os registros em uma tabela no banco
     * @return - Um vetor de objetos com os dados de cada registro na tabela
     * @throws SQLException
     */
    ObjetoVO[] selectAll(String query) throws SQLException;

    /**
     * Método para listar os registros em uma tabela no banco, cujos dados corresponderem aos dados de filtragem informados
     * @param oVO - Um objeto contendo os dados de filtragem 
     * @return - Um vetor de objetos com os dados de cada registro da tabela
     * @throws IllegalArgumentException
     * @throws SQLException
     */
    ObjetoVO[] selectWhere(ObjetoVO oVO, String query, String[] camposWhere) throws IllegalArgumentException, SQLException;

    /**
     * Método para atualizar um registro de uma tabela no banco
     * @param oVO - 
     * @throws SQLException
     */
    void update(ObjetoVO oVO, String query) throws SQLException;

    /**
     * Método para excluir um registro de uma tabela no banco
     * @param oVO - 
     * @throws SQLException
     */
    void delete(ObjetoVO oVO, String query)throws SQLException;
}