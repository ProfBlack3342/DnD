package servicos;

import dao.FactoryDAOMySQL;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.UsuarioVO;
import utilidades.Utils;

public class ServicosUsuario {

    public UsuarioVO login(UsuarioVO uVO) throws NoDataFoundException, SQLException {
        String[] nomesColunas = UsuarioVO.getNomesColunas();
        
        UsuarioVO uVOCandidato = pesquisar(uVO, new String[]{nomesColunas[3]})[0];
        
        String senhaCandidata = (String)uVO.getValorDadoUsuario(nomesColunas[4]);
        String hashSenha = (String)uVOCandidato.getValorDadoUsuario(nomesColunas[4]);
        
        return Utils.compararTextoComHash(senhaCandidata, hashSenha) ? uVOCandidato : null;
    }
    
    public void cadastrar(UsuarioVO uVO) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO ").append(UsuarioVO.getNomeTabela()).append(" VALUES (null");
        
        for(String nomeColuna : UsuarioVO.getNomesColunas()) {
            query.append(", ?");
        }
        query.append(")");
        
        FactoryDAOMySQL.getUsuarioDAO().insert(uVO, query.toString());
    }
    
    public UsuarioVO[] listar() throws NoDataFoundException, SQLException {
        String query = "SELECT * FROM " + UsuarioVO.getNomeTabela();
        
        return FactoryDAOMySQL.getUsuarioDAO().selectAll(query);
    }
    
    public UsuarioVO[] pesquisar(UsuarioVO uVO, String[] camposWhere) throws NoDataFoundException, SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(UsuarioVO.getNomeTabela()).append(" WHERE ");
        
        int limiteFor = camposWhere.length;
        for(int i = 0; i < limiteFor; i++) {
            if(uVO.getValorDadoUsuario(camposWhere[i]) != null)
                query.append(camposWhere[i]).append(" = ?");
            else
                query.append(camposWhere[i]).append(" = null");
                
            if(i < (limiteFor - 1))
                query.append(" AND ");
        }
        
        return FactoryDAOMySQL.getUsuarioDAO().selectWhere(uVO, query.toString(), camposWhere);
    }
    
    public void atualizar(UsuarioVO uVO) throws SQLException {
        String[] nomesColunas = UsuarioVO.getNomesColunas();
        
        StringBuilder query = new StringBuilder("UPDATE ").append(UsuarioVO.getNomeTabela()).append(" SET ");
        
        int limiteFor = nomesColunas.length;
        for(int i = 1; i < limiteFor; i++) {
            if(uVO.getValorDadoUsuario(nomesColunas[i]) != null)
                query.append(nomesColunas[i]).append(" = ?");
            else
                query.append(nomesColunas[i]).append(" = null");
            
            if(i < (limiteFor - 1))
                query.append(", ");
        }
        query.append(" WHERE ").append(nomesColunas[0]).append(" = ?");
        
        FactoryDAOMySQL.getUsuarioDAO().update(uVO, query.toString());
    }
    
    public void excluir(UsuarioVO uVO) throws SQLException {
        String query = "DELETE FROM " + UsuarioVO.getNomeTabela() + 
                " WHERE " + UsuarioVO.getNomesColunas()[0] + " = ?";
        
        FactoryDAOMySQL.getUsuarioDAO().delete(uVO, query);
    }
}
