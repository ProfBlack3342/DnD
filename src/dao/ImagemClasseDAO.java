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
import modelo.ImagemClasseVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author dudup
 */
public class ImagemClasseDAO extends ObjetoDAO 
{

    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImagemClasseVO[] listar() throws NoDataFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ImagemClasseVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        ImagemClasseVO icVO = (ImagemClasseVO) obVO;
        
        int quantCamposFiltragem = indicesCamposFiltragem.length;
        String[] nomesColunas = ImagemClasseVO.getNomesColunas();
        
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(ImagemClasseVO.getNomeTabela())
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
                        pstm.setInt(i, icVO.getId());
                        break;
                    }
                    case 1:
                    {
                        pstm.setString(i, icVO.getCaminhoImagem());
                        break;
                    }
                    case 2:
                    {
                        pstm.setString(i, icVO.getDescricaoImagem());
                        break;
                    }
                    case 3:
                    {
                        pstm.setDate(i, icVO.getDataCriacao());
                        break;
                    }
                    case 4:
                    {
                        pstm.setBoolean(i, icVO.isAtivo());
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Erro em ImagemClasseVO.Pesquisar (IllegalArgumentException): Indice de valor para filtragem inválido!");
                }
            }
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<ImagemClasseVO> listaImagens = new ArrayList<>();
                
                while(rs.next())
                {
                    ImagemClasseVO icVOSaida = new ImagemClasseVO();
                    
                    icVO.setId(rs.getInt(nomesColunas[0]));
                    
                    icVO.setCaminhoImagem(rs.getString(nomesColunas[1]));
                    icVO.setDescricaoImagem(rs.getString(nomesColunas[2]));
                    
                    icVO.setDataCriacao(rs.getDate(nomesColunas[3]));
                    icVO.setAtivo(rs.getBoolean(nomesColunas[4]));
                    
                    listaImagens.add(icVOSaida);
                }
                
                if(!listaImagens.isEmpty())
                    return listaImagens.toArray(new ImagemClasseVO[listaImagens.size()]);
                else
                    throw new NoDataFoundException("Erro em ImagemClasseVO.pesquisar (NoDataFoundException): Nenhuma imagem de classe registrada com esses dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ImagemClasseVO.pesquisar (SQLException): " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em ImagemClasseVO.pesquisar (IllegalArgumentException): " + ie.getMessage());
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
