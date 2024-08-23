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
import modelo.ImagemUsuarioVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemUsuarioDAO extends ObjetoDAO
{
    /*
        ImagemUsuario (
            idImagemUsuario INT NOT NULL,
            caminhoImagemUsuario VARCHAR(260) NOT NULL,
            descricaoImagemUsuario VARCHAR(60) NULL,
            dataCriacaoImagemUsuario DATE NOT NULL,
            imagemUsuarioAtiva TINYINT(1) NOT NULL DEFAULT 1
        )
    */

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws NoDataFoundException
     */
    @Override
    public ImagemUsuarioVO[] listar() throws SQLException, NoDataFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ImagemUsuarioVO[] pesquisar(ObjetoVO obVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException
    {
        ImagemUsuarioVO iuVO = (ImagemUsuarioVO) obVO;
        
        int quantCamposFiltragem = indicesCamposFiltragem.length;
        String[] nomesColunas = ImagemUsuarioVO.getNomesColunas();
        
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(ImagemUsuarioVO.getNomeTabela())
                .append(" WHERE ").append(nomesColunas[indicesCamposFiltragem[0]]).append(" = ?");
        
        for(int i = 1; i < quantCamposFiltragem; i++) {
            query.append(" AND ").append(nomesColunas[indicesCamposFiltragem[i]]).append(" = ?");
        }
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(query.toString());)
        {
            for(int i = 0; i < quantCamposFiltragem; i++) {
                switch(indicesCamposFiltragem[i])
                {
                    case 0:
                    {
                        pstm.setInt(i, iuVO.getId());
                        break;
                    }
                    case 1:
                    {
                        pstm.setString(i, iuVO.getCaminhoImagem());
                        break;
                    }
                    case 2:
                    {
                        pstm.setString(i, iuVO.getDescricaoImagem());
                        break;
                    }
                    case 3:
                    {
                        pstm.setDate(i, iuVO.getDataCriacao());
                        break;
                    }
                    case 4:
                    {
                        pstm.setBoolean(i, iuVO.isAtivo());
                        break;
                    }
                    default:
                    {
                        throw new IllegalArgumentException("Erro em ImagemUsuarioVO.Pesquisar: Indice de valor para filtragem inválido!");
                    }
                }
            }
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                ArrayList<ImagemUsuarioVO> listaImagens = new ArrayList<>();
                
                while(rs.next())
                {
                    ImagemUsuarioVO iuVOSaida = new ImagemUsuarioVO();
                    
                    iuVOSaida.setId(rs.getInt(nomesColunas[0]));
                    
                    iuVOSaida.setCaminhoImagem(rs.getString(nomesColunas[1]));
                    iuVOSaida.setDescricaoImagem(rs.getString(nomesColunas[2]));
                    
                    iuVOSaida.setDataCriacao(rs.getDate(nomesColunas[3]));
                    iuVOSaida.setAtivo(rs.getBoolean(nomesColunas[4]));
                    
                    listaImagens.add(iuVOSaida);
                }
                
                if(!listaImagens.isEmpty())
                    return listaImagens.toArray(new ImagemUsuarioVO[listaImagens.size()]);
                else
                    throw new NoDataFoundException("Erro em ImagemUsuarioVO.pesquisar: Nenhuma imagem de usuário registrada com esses dados!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ImagemUsuarioDAO.pesquisar: " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em ImagemUsuarioDAO.pesquisar: " + ie.getMessage());
        }
    }

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void alterar(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param obVO
     * @throws SQLException
     */
    @Override
    public void excluir(ObjetoVO obVO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
