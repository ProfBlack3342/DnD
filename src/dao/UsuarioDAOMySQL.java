package dao;

import exception.NoDataFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ObjetoVO;
import modelo.UsuarioVO;
import persistencia.ConexaoBancoMySQL;
import utilidades.Utils;

public final class UsuarioDAOMySQL implements IUsuarioDAO {

    private String nomeTabelaUsuario = UsuarioVO.getNomeTabela();
    private String[] nomesColunasUsuario = UsuarioVO.getNomesColunas();
    
    @Override
    public UsuarioVO login(String nomeUsuario, String senhaCandidata) throws NoDataFoundException, SQLException {
        String query = "SELECT * FROM " + nomeTabelaUsuario + 
                " WHERE " + nomesColunasUsuario[3] + " = ? LIMIT 1";
        
        try (Connection c = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement ps = c.prepareStatement(query);)
        {
            ps.setString(1, nomeUsuario);
            
            try(ResultSet rs = ps.executeQuery();)
            {
                ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
                
                while(rs.next()){
                    String hashSenha = rs.getString(nomesColunasUsuario[4]);
                    if(Utils.compararTextoComHash(senhaCandidata, hashSenha)){
                        UsuarioVO uVOSaida = new UsuarioVO();

                        uVOSaida.setId(rs.getInt(nomesColunasUsuario[0]));

                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[1], rs.getInt(nomesColunasUsuario[1]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[2], rs.getInt(nomesColunasUsuario[2]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[3], rs.getString(nomesColunasUsuario[3]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[4], hashSenha);
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[5], rs.getString(nomesColunasUsuario[5]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[6], rs.getDate(nomesColunasUsuario[6]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[7], rs.getString(nomesColunasUsuario[7]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[8], rs.getInt(nomesColunasUsuario[8]));
                        uVOSaida.putValorDadoUsuario(nomesColunasUsuario[9], rs.getInt(nomesColunasUsuario[9]));

                        uVOSaida.setDataCadastro(rs.getDate(nomesColunasUsuario[10]));
                        uVOSaida.setAtivo(rs.getBoolean(nomesColunasUsuario[11]));

                        listaUsuarios.add(uVOSaida);
                    }
                    else
                        throw new NoDataFoundException("'NoDataFoundException' em 'UsuarioDAOMySQL.selectAll': Senha incorreta!");
                }
                
                if(!listaUsuarios.isEmpty())
                    return listaUsuarios.toArray(new UsuarioVO[listaUsuarios.size()])[0];
                else
                    throw new NoDataFoundException("'NoDataFoundException' em 'UsuarioDAOMySQL.selectAll': Nenhum usuário registrado com este nome!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.login': " + se.getMessage());
        }
    }

    @Override
    public void insert(ObjetoVO oVO) throws SQLException {
        UsuarioVO uVOEntrada = (UsuarioVO) oVO;
        StringBuilder query = new StringBuilder("INSERT INTO ").append(nomeTabelaUsuario).append(" VALUES (null, ");
        
        int limiteFor = nomesColunasUsuario.length;
        for(int i = 0; i < limiteFor; i++) {
            if(i < (limiteFor - 1))
                query.append("?, ");
            else
                query.append("?");
        }
        
        try (Connection c = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement ps = c.prepareStatement(query.toString());)
        {
            for(int i = 1; i < limiteFor; i++) {
                switch(uVOEntrada.getTipoDadoUsuario(nomesColunasUsuario[i])){
                    case INT:
                        ps.setInt(i, (int)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                    case STRING:
                        ps.setString(i, (String)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                    case DATE:
                        ps.setDate(i, (Date)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                    case BOOLEAN:
                        ps.setBoolean(i, (boolean)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                }
            }
            
            ps.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.insert': " + se.getMessage());
        }
    }

    @Override
    public UsuarioVO[] selectAll() throws NoDataFoundException, SQLException {
        String query = "SELECT * FROM " + UsuarioVO.getNomeTabela();
        
        try (Connection c = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement ps = c.prepareStatement(query);
                ResultSet rs = ps.executeQuery();)
        {
            ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
            
            while(rs.next()) {
                UsuarioVO uVOSaida = new UsuarioVO();
                
                uVOSaida.setId(rs.getInt(nomesColunasUsuario[0]));
                
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[1], rs.getInt(nomesColunasUsuario[1]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[2], rs.getInt(nomesColunasUsuario[2]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[3], rs.getString(nomesColunasUsuario[3]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[4], rs.getString(nomesColunasUsuario[4]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[5], rs.getString(nomesColunasUsuario[5]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[6], rs.getDate(nomesColunasUsuario[6]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[7], rs.getString(nomesColunasUsuario[7]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[8], rs.getInt(nomesColunasUsuario[8]));
                uVOSaida.putValorDadoUsuario(nomesColunasUsuario[9], rs.getInt(nomesColunasUsuario[9]));
                
                uVOSaida.setDataCadastro(rs.getDate(nomesColunasUsuario[10]));
                uVOSaida.setAtivo(rs.getBoolean(nomesColunasUsuario[11]));
                
                listaUsuarios.add(uVOSaida);
            }
            
            if(!listaUsuarios.isEmpty())
                return listaUsuarios.toArray(new UsuarioVO[listaUsuarios.size()]);
            else
                throw new NoDataFoundException("'NoDataFoundException' em 'UsuarioDAOMySQL.selectAll': Nenhum usuário registrado!");
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.selectAll': " + se.getMessage());
        }
    }

    @Override
    public UsuarioVO[] selectWhere(ObjetoVO oVO) throws IllegalArgumentException, NoDataFoundException, SQLException {
        UsuarioVO uVOEntrada = (UsuarioVO) oVO;
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(nomeTabelaUsuario).append(" WHERE ");
        
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 0; i < nomesColunasUsuario.length; i++) {
            if(uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]) != null)
                indices.add(i);
        }
        
        for(int i = 0; i < indices.size(); i++) {
            if(i < indices.size() - 1)
                query.append(nomesColunasUsuario[indices.get(i)]).append(" = ?, ");
            else
                query.append(nomesColunasUsuario[indices.get(i)]).append(" = ?");
        }
        
        try (Connection c = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement ps = c.prepareStatement(query.toString());)
        {
            for(int i = 0; i < indices.size(); i++) {
                switch(uVOEntrada.getTipoDadoUsuario(nomesColunasUsuario[indices.get(i)])) {
                    case INT:
                        ps.setInt(i + 1, (int)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[indices.get(i)]));
                        break;
                    case STRING:
                        ps.setString(i + 1, (String)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[indices.get(i)]));
                        break;
                    case DATE:
                        ps.setDate(i + 1, (Date)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[indices.get(i)]));
                        break;
                    case BOOLEAN:
                        ps.setBoolean(i + 1, (boolean)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[indices.get(i)]));
                        break;
                }
            }
            try(ResultSet rs = ps.executeQuery();)
            {
                ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
            
                while(rs.next()) {
                    UsuarioVO uVOSaida = new UsuarioVO();
                    
                    uVOSaida.setId(rs.getInt(nomesColunasUsuario[0]));
                
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[1], rs.getInt(nomesColunasUsuario[1]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[2], rs.getInt(nomesColunasUsuario[2]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[3], rs.getString(nomesColunasUsuario[3]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[4], rs.getString(nomesColunasUsuario[4]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[5], rs.getString(nomesColunasUsuario[5]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[6], rs.getDate(nomesColunasUsuario[6]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[7], rs.getString(nomesColunasUsuario[7]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[8], rs.getInt(nomesColunasUsuario[8]));
                    uVOSaida.putValorDadoUsuario(nomesColunasUsuario[9], rs.getInt(nomesColunasUsuario[9]));

                    uVOSaida.setDataCadastro(rs.getDate(nomesColunasUsuario[10]));
                    uVOSaida.setAtivo(rs.getBoolean(nomesColunasUsuario[11]));

                    listaUsuarios.add(uVOSaida);
                }

                if(!listaUsuarios.isEmpty())
                    return listaUsuarios.toArray(new UsuarioVO[listaUsuarios.size()]);
                else
                    throw new NoDataFoundException("'NoDataFoundException' em 'UsuarioDAOMySQL.selectWhere': Nenhum usuário registrado com estes dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.selectWhere': " + se.getMessage());
        }
    }

    @Override
    public void update(ObjetoVO oVO) throws SQLException {
        UsuarioVO uVOEntrada = (UsuarioVO) oVO;
        StringBuilder query = new StringBuilder("UPDATE ").append(nomeTabelaUsuario).append(" SET ");
        
        int limiteFor = nomesColunasUsuario.length;
        for(int i = 1; i < limiteFor; i++) {
            if(i < (limiteFor - 1))
                query.append(nomesColunasUsuario[i]).append(" = ?, ");
            else
                query.append(nomesColunasUsuario[i]).append(" = ?");
        }
        query.append(" WHERE ").append(nomesColunasUsuario[0]).append(" = ").append((int)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[0]));
        
        try (Connection c = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement ps = c.prepareStatement(query.toString());)
        {
            for(int i = 1; i < limiteFor; i++) {
                switch(uVOEntrada.getTipoDadoUsuario(nomesColunasUsuario[i])) {
                    case INT:
                        ps.setInt(i, (int)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                    case STRING:
                        ps.setString(i, (String)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                    case DATE:
                        ps.setDate(i, (Date)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                    case BOOLEAN:
                        ps.setBoolean(i, (boolean)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[i]));
                        break;
                }
            }
            
            ps.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.update': " + se.getMessage());
        }
        
    }

    @Override
    public void delete(ObjetoVO oVO) throws SQLException {
        UsuarioVO uVOEntrada = (UsuarioVO) oVO;
        StringBuilder query = new StringBuilder("DELETE FROM ").append(nomeTabelaUsuario).
                append(" WHERE ").append(nomesColunasUsuario[0]).append(" = ?");
        
        try (Connection c = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement ps = c.prepareStatement(query.toString());)
        {
            ps.setInt(1, (int)uVOEntrada.getValorDadoUsuario(nomesColunasUsuario[0]));
            ps.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.delete': " + se.getMessage());
        }
    }
}