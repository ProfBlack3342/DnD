/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.NoDataFoundException;
import modelo.ObjetoVO;
import modelo.PersonagemVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class PersonagemDAO extends ObjetoDAO
{
    /*
        Tabela Personagem (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            idImagemPersonagem INT NOT NULL,
            idClasse INT NOT NULL,
            idSubclasse INT NOT NULL,
            idRaca INT NOT NULL,
            idSubraca INT NOT NULL,
            idBackground INT NOT NULL,
            nomePersonagem VARCHAR(50) NULL,
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        String sql = "INSERT INTO " + PersonagemVO.getNomeTabela() + " "
                + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, pVO.getIdUsuario());
            pstm.setInt(2, pVO.getIdImagem());
            pstm.setInt(3, pVO.getIdClasse());
            pstm.setInt(4, pVO.getIdSubclasse());
            pstm.setInt(5, pVO.getIdRaca());
            pstm.setInt(6, pVO.getIdSubraca());
            pstm.setInt(7, pVO.getIdBackground());
            pstm.setString(8, pVO.getNome());
            pstm.setDate(9, pVO.getDataCriacao());
            pstm.setBoolean(10, pVO.isAtivo());
            
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro no cadastro do personagem (PersonagemDAO.cadastrar)! " + se.getMessage());
        }
    }

    /**
     *
     * @return
     * @throws NoDataFoundException
     * @throws SQLException
     */
    @Override
    public PersonagemVO[] listar() throws NoDataFoundException, SQLException
    {
        String query = "SELECT * FROM " + PersonagemVO.getNomeTabela();
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();)
        {
            ArrayList<PersonagemVO> listaPersonagens = new ArrayList<>();
            String[] nomesColunas = PersonagemVO.getNomesColunas();
            
            while(rs.next())
            {
                PersonagemVO pVO = new PersonagemVO();
                
                pVO.setId(rs.getInt(nomesColunas[0]));
                
                pVO.setIdUsuario(rs.getInt(nomesColunas[1]));
                pVO.setIdImagem(rs.getInt(nomesColunas[2]));
                pVO.setIdClasse(rs.getInt(nomesColunas[3]));
                pVO.setIdSubclasse(rs.getInt(nomesColunas[4]));
                pVO.setIdRaca(rs.getInt(nomesColunas[5]));
                pVO.setIdSubraca(rs.getInt(nomesColunas[6]));
                pVO.setIdBackground(rs.getInt(nomesColunas[7]));
                pVO.setNome(rs.getString(nomesColunas[8]));
                
                pVO.setDataCriacao(rs.getDate(nomesColunas[9]));
                pVO.setAtivo(rs.getBoolean(nomesColunas[10]));
                
                listaPersonagens.add(pVO);
            }
            
            if(listaPersonagens.isEmpty())
                return null;
            else
                return listaPersonagens.toArray(new PersonagemVO[listaPersonagens.size()]);
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemVO.listar: " + se.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @param indicesCamposFiltragem
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    @Override
    public PersonagemVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        int quantCamposFiltragem = indicesCamposFiltragem.length;
        String[] nomesColunas = PersonagemVO.getNomesColunas();
        
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(PersonagemVO.getNomeTabela())
                .append(" WHERE ").append(nomesColunas[indicesCamposFiltragem[0]]).append(" = ?");
        
        for(int i = 1; i < quantCamposFiltragem; i++) {
            query.append(" AND ").append(nomesColunas[indicesCamposFiltragem[i]]).append(" = ?");
        }
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(query.toString());)
        {
            for(int i = 1; i <= quantCamposFiltragem; i++) {
                switch(indicesCamposFiltragem[i - 1])
                {
                    case 0:
                    {
                        pstm.setInt(i, pVO.getId());
                        break;
                    }
                    case 1:
                    {
                        pstm.setInt(i, pVO.getIdUsuario());
                        break;
                    }
                    case 2:
                    {
                        pstm.setInt(i, pVO.getIdImagem());
                        break;
                    }
                    case 3:
                    {
                        pstm.setInt(i, pVO.getIdSubclasse());
                        break;
                    }
                    case 4:
                    {
                        pstm.setInt(i, pVO.getIdClasse());
                        break;
                    }
                    case 5:
                    {
                        pstm.setInt(i, pVO.getIdSubraca());
                        break;
                    }
                    case 6:
                    {
                        pstm.setInt(i, pVO.getIdRaca());
                        break;
                    }
                    case 7:
                    {
                        pstm.setInt(i, pVO.getIdBackground());
                        break;
                    }
                    case 8:
                    {
                        pstm.setInt(i, pVO.getValorSTRBase());
                        break;
                    }
                    case 9:
                    {
                        pstm.setInt(i, pVO.getValorDEXBase());
                        break;
                    }
                    case 10:
                    {
                        pstm.setInt(i, pVO.getValorCONBase());
                        break;
                    }
                    case 11:
                    {
                        pstm.setInt(i, pVO.getValorINTBase());
                        break;
                    }
                    case 12:
                    {
                        pstm.setInt(i, pVO.getValorWISBase());
                        break;
                    }
                    case 13:
                    {
                        pstm.setInt(i, pVO.getValorCHABase());
                        break;
                    }
                    case 14:
                    {
                        pstm.setString(i, pVO.getNome());
                        break;
                    }
                    case 15:
                    {
                        pstm.setString(i, pVO.getAlinhamento());
                        break;
                    }
                    case 16:
                    {
                        pstm.setInt(i, pVO.getIdade());
                        break;
                    }
                    case 17:
                    {
                        pstm.setInt(i, pVO.getAltura());
                        break;
                    }
                    case 18:
                    {
                        pstm.setDouble(i, pVO.getPeso());
                        break;
                    }
                    case 19:
                    {
                        pstm.setString(i, pVO.getOlhos());
                        break;
                    }
                    case 20:
                    {
                        pstm.setString(i, pVO.getPele());
                        break;
                    }
                    case 21:
                    {
                        pstm.setString(i, pVO.getCabelo());
                        break;
                    }
                    case 22:
                    {
                        pstm.setString(i, pVO.getAparencia());
                        break;
                    }
                    case 23:
                    {
                        pstm.setString(i, pVO.getHistoria());
                        break;
                    }
                    case 24:
                    {
                        pstm.setString(i, pVO.getPersonalidade());
                        break;
                    }
                    case 25:
                    {
                        pstm.setString(i, pVO.getIdeais());
                        break;
                    }
                    case 26:
                    {
                        pstm.setString(i, pVO.getLigacoes());
                        break;
                    }
                    case 27:
                    {
                        pstm.setString(i, pVO.getDefeitos());
                        break;
                    }
                    case 28:
                    {
                        pstm.setString(i, pVO.getAliados());
                        break;
                    }
                    case 29:
                    {
                        pstm.setString(i, pVO.getOutrasInformacoes());
                        break;
                    }
                    case 30:
                    {
                        pstm.setInt(i, pVO.getQuantCobre());
                        break;
                    }
                    case 31:
                    {
                        pstm.setInt(i, pVO.getQuantPrata());
                        break;
                    }
                    case 32:
                    {
                        pstm.setInt(i, pVO.getQuantElectrum());
                        break;
                    }
                    case 33:
                    {
                        pstm.setInt(i, pVO.getQuantOuro());
                        break;
                    }
                    case 34:
                    {
                        pstm.setInt(i, pVO.getQuantPlatina());
                        break;
                    }
                    case 35:
                    {
                        pstm.setDate(i, pVO.getDataCriacao());
                        break;
                    }
                    case 36:
                    {
                        pstm.setBoolean(i, pVO.isAtivo());
                        break;
                    }
                    default:
                    {
                        throw new IllegalArgumentException("Erro em PersonagemVO.Pesquisar: Indice de valor para filtragem inválido!");
                    }
                }
            }
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<PersonagemVO> listaPersonagens = new ArrayList<>();
                
                while(rs.next())
                {
                    PersonagemVO pVOSaida = new PersonagemVO();
                    
                    pVOSaida.setId(rs.getInt(nomesColunas[0]));
                    
                    pVOSaida.setIdUsuario(rs.getInt(nomesColunas[1]));
                    pVOSaida.setIdImagem(rs.getInt(nomesColunas[2]));
                    pVOSaida.setIdSubclasse(rs.getInt(nomesColunas[3]));
                    pVOSaida.setIdClasse(rs.getInt(nomesColunas[4]));
                    pVOSaida.setIdSubraca(rs.getInt(nomesColunas[5]));
                    pVOSaida.setIdRaca(rs.getInt(nomesColunas[6]));
                    pVOSaida.setIdBackground(rs.getInt(nomesColunas[7]));
                    pVOSaida.setValorSTRBase(rs.getInt(nomesColunas[8]));
                    pVOSaida.setValorDEXBase(rs.getInt(nomesColunas[9]));
                    pVOSaida.setValorCONBase(rs.getInt(nomesColunas[10]));
                    pVOSaida.setValorINTBase(rs.getInt(nomesColunas[11]));
                    pVOSaida.setValorWISBase(rs.getInt(nomesColunas[12]));
                    pVOSaida.setValorCHABase(rs.getInt(nomesColunas[13]));
                    pVOSaida.setNome(rs.getString(nomesColunas[14]));
                    pVOSaida.setAlinhamento(rs.getString(nomesColunas[15]));
                    pVOSaida.setIdade(rs.getInt(nomesColunas[16]));
                    pVOSaida.setAltura(rs.getInt(nomesColunas[17]));
                    pVOSaida.setPeso(rs.getDouble(nomesColunas[18]));
                    pVOSaida.setOlhos(rs.getString(nomesColunas[19]));
                    pVOSaida.setPele(rs.getString(nomesColunas[20]));
                    pVOSaida.setCabelo(rs.getString(nomesColunas[21]));
                    pVOSaida.setAparencia(rs.getString(nomesColunas[22]));
                    pVOSaida.setHistoria(rs.getString(nomesColunas[23]));
                    pVOSaida.setPersonalidade(rs.getString(nomesColunas[24]));
                    pVOSaida.setIdeais(rs.getString(nomesColunas[25]));
                    pVOSaida.setLigacoes(rs.getString(nomesColunas[26]));
                    pVOSaida.setDefeitos(rs.getString(nomesColunas[27]));
                    pVOSaida.setAliados(rs.getString(nomesColunas[28]));
                    pVOSaida.setOutrasInformacoes(rs.getString(nomesColunas[29]));
                    pVOSaida.setQuantCobre(rs.getInt(nomesColunas[30]));
                    pVOSaida.setQuantPrata(rs.getInt(nomesColunas[31]));
                    pVOSaida.setQuantElectrum(rs.getInt(nomesColunas[32]));
                    pVOSaida.setQuantOuro(rs.getInt(nomesColunas[33]));
                    pVOSaida.setQuantPlatina(rs.getInt(nomesColunas[34]));
                    
                    pVOSaida.setDataCriacao(rs.getDate(nomesColunas[35]));
                    pVOSaida.setAtivo(rs.getBoolean(nomesColunas[36]));
                    
                    listaPersonagens.add(pVOSaida);
                }
                
                if(!listaPersonagens.isEmpty())
                    return listaPersonagens.toArray(new PersonagemVO[listaPersonagens.size()]);
                else
                    throw new NoDataFoundException("Erro em PersonagemVO.pesquisar: Nenhum personagem registrado com esses dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemDAO.pesquisar: " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em PersonagemDAO.pesquisar: " + ie.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        String[] nomesColunas = PersonagemVO.getNomesColunas();
        
        String sql = "UPDATE " + PersonagemVO.getNomeTabela() + " SET "
                + nomesColunas[1] + " = ?, "
                + nomesColunas[2] + " = ?, "
                + nomesColunas[3] + " = ?, "
                + nomesColunas[4] + " = ?, "
                + nomesColunas[5] + " = ?, "
                + nomesColunas[6] + " = ?, "
                + nomesColunas[7] + " = ?, "
                + nomesColunas[8] + " = ?, "
                + nomesColunas[9] + " = ?, "
                + nomesColunas[10] + " = ?, "
                + "WHERE" + nomesColunas[0] + " = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, pVO.getIdUsuario());
            pstm.setInt(2, pVO.getIdImagem());
            pstm.setInt(3, pVO.getIdClasse());
            pstm.setInt(4, pVO.getIdSubclasse());
            pstm.setInt(5, pVO.getIdRaca());
            pstm.setInt(6, pVO.getIdSubraca());
            pstm.setInt(7, pVO.getIdBackground());
            pstm.setString(8, pVO.getNome());
            
            pstm.setDate(9, pVO.getDataCriacao());
            pstm.setBoolean(10, pVO.isAtivo());
            
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemVO.alterar: " + se.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void excluir(ObjetoVO obVO) throws SQLException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        String sql = "DELETE FROM " + PersonagemVO.getNomeTabela() + " "
                + "WHERE " + PersonagemVO.getNomesColunas()[0] + " = ?";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);)
        {
            pstm.setInt(1, pVO.getId());
            pstm.executeUpdate();
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em PersonagemVO.excluir: " + se.getMessage());
        }
    }
    
}
