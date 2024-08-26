/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exception.NoDataFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ImagemRacaVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author dudup
 */
public class ImagemRacaDAO extends ObjetoDAO 
{

    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImagemRacaVO[] listar() throws NoDataFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImagemRacaVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        ImagemRacaVO irVO = (ImagemRacaVO) obVO;
        
        int quantCamposFiltragem = indicesCamposFiltragem.length;
        String[] nomesColunas = ImagemRacaVO.getNomesColunas();
        
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(ImagemRacaVO.getNomeTabela())
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
                        pstm.setInt(i, irVO.getId());
                        break;
                    }
                    case 1:
                    {
                        pstm.setString(i, irVO.getCaminhoImagem());
                        break;
                    }
                    case 2:
                    {
                        pstm.setString(i, irVO.getDescricaoImagem());
                        break;
                    }
                    case 3:
                    {
                        pstm.setDate(i, irVO.getDataCriacao());
                        break;
                    }
                    case 4:
                    {
                        pstm.setBoolean(i, irVO.isAtivo());
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Erro em ImagemRacaVO.Pesquisar (IllegalArgumentException): Indice de valor para filtragem inválido!");
                }
            }
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<ImagemRacaVO> listaImagens = new ArrayList<>();
                
                while(rs.next())
                {
                    ImagemRacaVO irVOSaida = new ImagemRacaVO();
                    
                    irVO.setId(rs.getInt(nomesColunas[0]));
                    
                    irVO.setCaminhoImagem(rs.getString(nomesColunas[1]));
                    irVO.setDescricaoImagem(rs.getString(nomesColunas[2]));
                    
                    irVO.setDataCriacao(rs.getDate(nomesColunas[3]));
                    irVO.setAtivo(rs.getBoolean(nomesColunas[4]));
                    
                    listaImagens.add(irVOSaida);
                }
                
                if(!listaImagens.isEmpty())
                    return listaImagens.toArray(new ImagemRacaVO[listaImagens.size()]);
                else
                    throw new NoDataFoundException("Erro em ImagemRacaVO.pesquisar (NoDataFoundException): Nenhuma imagem de raça registrada com esses dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ImagemRacaVO.pesquisar (SQLException): " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em ImagemRacaVO.pesquisar (IllegalArgumentException): " + ie.getMessage());
        }
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
