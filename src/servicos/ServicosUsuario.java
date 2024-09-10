package servicos;

import dao.FactoryDAOMySQL;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.UsuarioVO;

public class ServicosUsuario {

    public UsuarioVO login(String nomeUsuario, String senhaCandidata) throws NoDataFoundException, SQLException {
        return FactoryDAOMySQL.getUsuarioDAO().login(nomeUsuario, senhaCandidata);
    }
    
    public void cadastrar(UsuarioVO uVO) throws SQLException {
        FactoryDAOMySQL.getUsuarioDAO().insert(uVO);
    }
    
    public UsuarioVO[] listar() throws NoDataFoundException, SQLException {
        return FactoryDAOMySQL.getUsuarioDAO().selectAll();
    }
    
    public UsuarioVO[] pesquisar(UsuarioVO uVO) throws NoDataFoundException, SQLException {
        return FactoryDAOMySQL.getUsuarioDAO().selectWhere(uVO);
    }
    
    public void atualizar(UsuarioVO uVO) throws SQLException {
        FactoryDAOMySQL.getUsuarioDAO().update(uVO);
    }
    
    public void excluir(UsuarioVO uVO) throws SQLException {
        FactoryDAOMySQL.getUsuarioDAO().delete(uVO);
    }
}
