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

public final class UsuarioDAOMySQL extends DAOMySQL {

    @Override
    public void insert(ObjetoVO oVO, String query) throws SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
            PreparedStatement pstm = con.prepareStatement(query);)
        {
            String[] nomesColunas = UsuarioVO.getNomesColunas();
            
            int limiteFor = nomesColunas.length;
            for(int i = 1; i < limiteFor; i++) {
                switch(i) {
                    case 1:     // ID Imagem
                    case 2:     // ID Tipo
                    case 8:     // Quant Personagens Totais
                    case 9:     // Quant Personagens Criados
                        pstm.setInt(i + 1, (int)uVO.getDadoUsuario(nomesColunas[i]));
                        break;
                    case 3:     // Nome
                    case 4:     // Hash Senha
                    case 5:     // E-mail
                    case 7:     // Descrição
                        pstm.setString(i + 1, (String)uVO.getDadoUsuario(nomesColunas[i]));
                        break;
                    case 6:     // Data de Aniversário
                        pstm.setDate(i + 1, (Date)uVO.getDadoUsuario(nomesColunas[i]));
                        break;
                    case 10:    // Data de Criação
                        pstm.setDate(i + 1, uVO.getDataCadastro());
                        break;
                    case 11:    // Ativo
                        pstm.setBoolean(i + 1, uVO.isAtivo());
                        break;
                }
            }
            
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.insert': " + se.getMessage());
        }
    }

    @Override
    public UsuarioVO[] selectAll(String query) throws NoDataFoundException, SQLException {
        
        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
                PreparedStatement pstm = con.prepareStatement(query);
                ResultSet rs = pstm.executeQuery();)
        {
            String[] nomesColunas = UsuarioVO.getNomesColunas();
            ArrayList<UsuarioVO> listaUsuariosVO = new ArrayList<>();
            while(rs.next()) {
                UsuarioVO uVO = new UsuarioVO();
                
                uVO.setId(rs.getInt(nomesColunas[0]));  // ID
                
                int limiteFor = nomesColunas.length;
                for(int i = 1; i < limiteFor; i++) {
                    switch(i) {
                        case 1:     // ID Imagem
                        case 2:     // ID Tipo
                        case 8:     // Quant Personagens Totais
                        case 9:     // Quant Personagens Criados
                            uVO.putDadoUsuario(nomesColunas[i], rs.getInt(nomesColunas[i]));
                            break;
                        case 3:     // Nome
                        case 4:     // Hash Senha
                        case 5:     // E-mail
                        case 7:     // Descrição
                            uVO.putDadoUsuario(nomesColunas[i], rs.getString(nomesColunas[i]));
                            break;
                        case 6:     // Data de Aniversário
                            uVO.putDadoUsuario(nomesColunas[i], rs.getDate(nomesColunas[i]));
                            break;
                    }
                }
                
                uVO.setDataCadastro(rs.getDate(nomesColunas[10]));  // Data de Criação
                uVO.setAtivo(rs.getBoolean(nomesColunas[11]));      // Ativo
                
                listaUsuariosVO.add(uVO);
            }
            
            if(!listaUsuariosVO.isEmpty())
                return listaUsuariosVO.toArray(new UsuarioVO[listaUsuariosVO.size()]);
            else
                throw new NoDataFoundException("'NoDataFoundException' em 'UsuarioDAOMySQL.selectAll': Nenhuma usuário registrado!");
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.selectAll': " + se.getMessage());
        }
    }

    @Override
    public UsuarioVO[] selectWhere(ObjetoVO oVO, String query, String[] camposWhere) throws IllegalArgumentException, NoDataFoundException, SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
            PreparedStatement pstm = con.prepareStatement(query);)
        {
            String[] nomesColunas = UsuarioVO.getNomesColunas();
            
            int limiteForExt = camposWhere.length;
            int limiteForInt = nomesColunas.length;
            for(int i = 0; i < limiteForExt; i++) {                
                for(int j = 0; j < limiteForInt; j++){
                    if(nomesColunas[j].equals(camposWhere[i])){
                        switch(j){
                            case 0:     // ID
                                pstm.setInt(i + 1, uVO.getId());
                                break;
                            case 1:     // ID Imagem
                            case 2:     // ID Tipo
                            case 8:     // Quant Personagens Totais
                            case 9:     // Quant Personagens Criados
                                pstm.setInt(i + 1, (int)uVO.getDadoUsuario(camposWhere[i]));
                                break;
                            case 3:     // Nome
                            case 5:     // E-mail
                            case 7:     // Descrição
                                pstm.setString(i + 1, (String)uVO.getDadoUsuario(camposWhere[i]));
                                break;
                            case 6:     // Data de Aniversário
                                pstm.setDate(i + 1, (Date)uVO.getDadoUsuario(camposWhere[i]));
                                break;
                            case 10:    // Data de Criação
                                pstm.setDate(i + 1, uVO.getDataCadastro());
                                break;
                            case 11:    // Ativo
                                pstm.setBoolean(i + 1, uVO.isAtivo());
                                break;
                        }
                    }
                }
            }
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<UsuarioVO> listaUsuariosVO = new ArrayList<>();
                while(rs.next()) {
                    UsuarioVO uVOsaida = new UsuarioVO();

                    uVOsaida.setId(rs.getInt(nomesColunas[0]));  // ID

                    int limiteFor = nomesColunas.length;
                    for(int i = 1; i < limiteFor; i++) {
                        switch(i) {
                            case 1:     // ID Imagem
                            case 2:     // ID Tipo
                            case 8:     // Quant Personagens Totais
                            case 9:     // Quant Personagens Criados
                                uVOsaida.putDadoUsuario(nomesColunas[i], rs.getInt(nomesColunas[i]));
                                break;
                            case 3:     // Nome
                            case 4:     // Hash Senha
                            case 5:     // E-mail
                            case 7:     // Descrição
                                uVOsaida.putDadoUsuario(nomesColunas[i], rs.getString(nomesColunas[i]));
                                break;
                            case 6:     // Data de Aniversário
                                uVOsaida.putDadoUsuario(nomesColunas[i], rs.getDate(nomesColunas[i]));
                                break;
                        }
                    }

                    uVOsaida.setDataCadastro(rs.getDate(nomesColunas[10]));  // Data de Criação
                    uVOsaida.setAtivo(rs.getBoolean(nomesColunas[11]));      // Ativo

                    listaUsuariosVO.add(uVOsaida);
                }

                if(!listaUsuariosVO.isEmpty())
                    return listaUsuariosVO.toArray(new UsuarioVO[listaUsuariosVO.size()]);
                else
                    throw new NoDataFoundException("'NoDataFoundException' em 'UsuarioDAOMySQL.selectAll': Nenhuma usuário registrado!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.selectWhere': " + se.getMessage());
        }
    }

    @Override
    public void update(ObjetoVO oVO, String query) throws SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
            PreparedStatement pstm = con.prepareStatement(query);)
        {
            String[] nomesColunas = UsuarioVO.getNomesColunas();
            
            int limiteFor = nomesColunas.length;
            for(int i = 0; i < limiteFor; i++) {
                switch(i) {
                    case 0:     // ID
                        pstm.setInt(i + 1, uVO.getId());
                        break;
                    case 1:     // ID Imagem
                    case 2:     // ID Tipo
                    case 8:     // Quant Personagens Totais
                    case 9:     // Quant Personagens Criados
                        pstm.setInt(i + 1, (int)uVO.getDadoUsuario(nomesColunas[i]));
                        break;
                    case 3:     // Nome
                    case 4:     // Senha
                    case 5:     // E-mail
                    case 7:     // Descrição
                        pstm.setString(i + 1, (String)uVO.getDadoUsuario(nomesColunas[i]));
                        break;
                    case 6:     // Data de Aniversário
                        pstm.setDate(i + 1, (Date)uVO.getDadoUsuario(nomesColunas[i]));
                        break;
                    case 10:    // Data de Criação
                        pstm.setDate(i + 1, uVO.getDataCadastro());
                        break;
                    case 11:    // Ativo
                        pstm.setBoolean(i + 1, uVO.isAtivo());
                        break;
                }
            }
            
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.update': " + se.getMessage());
        }
    }

    @Override
    public void delete(ObjetoVO oVO, String query) throws SQLException {
        UsuarioVO uVO = (UsuarioVO)oVO;

        try(Connection con = new ConexaoBancoMySQL().getConexaoMySQL();
            PreparedStatement pstm = con.prepareStatement(query);)
        {
            pstm.setInt(1, uVO.getId());
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("'SQLException' em 'UsuarioDAOMySQL.delete': " + se.getMessage());
        }
    }
}