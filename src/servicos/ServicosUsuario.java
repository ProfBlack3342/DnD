package servicos;

import dao.FactoryDAOMySQL;
import java.sql.SQLException;
import modelo.UsuarioVO;

public class ServicosUsuario {

    public UsuarioVO login(UsuarioVO uVO, String[] camposWhere) throws SQLException {
        String query = "SELECT * FROM " + UsuarioVO.getNomeTabela() + " WHERE id = ?";
        return FactoryDAOMySQL.getUsuarioDAO().selectWhere(uVO, query, camposWhere)[0];
    }
    
    public void cadastrar(UsuarioVO uVO) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO ").append(UsuarioVO.getNomeTabela()).append(" VALUES (null");
        for(String nomeColuna : UsuarioVO.getNomesColunas()) {
            query.append(", ?");
        }
        query.append(")");
        
        FactoryDAOMySQL.getUsuarioDAO().insert(uVO, query.toString());
    }
    
    public UsuarioVO[] listar() throws SQLException {
        String query = "SELECT * FROM " + UsuarioVO.getNomeTabela();
        return FactoryDAOMySQL.getUsuarioDAO().selectAll(query);
    }
    
    public UsuarioVO[] pesquisar(UsuarioVO uVO, String[] camposWhere) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(UsuarioVO.getNomeTabela()).append(" WHERE ");
        
        int limiteFor = camposWhere.length;
        for(int i = 0; i < limiteFor; i++) {
            if(uVO.getDadoUsuario(camposWhere[i]) != null)
                query.append(camposWhere[i]).append(" = ?");
            else
                query.append(camposWhere[i]).append(" = null");
                
            if(i < limiteFor - 1)
                query.append(" AND ");
        }
        
        return FactoryDAOMySQL.getUsuarioDAO().selectWhere(uVO, query.toString(), camposWhere);
    }
    
    public void atualizar(UsuarioVO uVO) throws SQLException {
        
    }
    
    public void excluir(UsuarioVO uVO) throws SQLException {
        
    }
}
