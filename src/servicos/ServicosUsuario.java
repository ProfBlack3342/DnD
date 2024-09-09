import java.sql.SQLException;

public class ServicosUsuario {

    public UsuarioVO login(UsuarioVO uVO) throws SQLException {
        String query = "SELECT * FROM " + UsuarioVO.getNomeTabela() + " WHERE id = ?";
        return FactoryDAOMySQL.getUsuarioDAO().selectWhere(uVO, query)[0];
    }
}
