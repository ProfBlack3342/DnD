package dao;

import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.ObjetoVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public interface IDAO
{
    void insert(ObjetoVO oVO) throws SQLException;

    ObjetoVO[] selectAll() throws NoDataFoundException, SQLException;

    ObjetoVO[] selectWhere(ObjetoVO oVO) throws IllegalArgumentException, NoDataFoundException, SQLException;

    void update(ObjetoVO oVO) throws SQLException;

    void delete(ObjetoVO oVO)throws SQLException;
}