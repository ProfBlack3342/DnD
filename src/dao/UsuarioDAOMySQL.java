import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class UsuarioDAOMySQL extends DAOMySQL {

    @Override
    public void insert(ObjetoVO oVO, String query) throws SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
            PreparedStatement pstm = con.prepareStatement(query);)
        {

        }
    }

    @Override
    public UsuarioVO[] selectAll(String query) throws SQLException {


    }

    @Override
    public UsuarioVO[] selectWhere(ObjetoVO oVO, String query) throws IllegalArgumentException, SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
            PreparedStatement pstm = con.prepareStatement(query);)
        {
            pstm.setInt(1, uVO.getDadoColunaTabela(""));
        }
    }

    @Override
    public void update(ObjetoVO oVO, String query) throws SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

    }

    @Override
    public void delete(ObjetoVO oVO, String query) throws SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

    }
}