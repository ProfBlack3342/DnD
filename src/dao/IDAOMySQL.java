package dao;

import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.ObjetoVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public interface IDAOMySQL
{
    void insert(ObjetoVO oVO, String query) throws SQLException;

    ObjetoVO[] selectAll(String query) throws NoDataFoundException, SQLException;

    ObjetoVO[] selectWhere(ObjetoVO oVO, String query, String[] camposWhere) throws IllegalArgumentException, NoDataFoundException, SQLException;

    void update(ObjetoVO oVO, String query) throws SQLException;

    void delete(ObjetoVO oVO, String query)throws SQLException;
}