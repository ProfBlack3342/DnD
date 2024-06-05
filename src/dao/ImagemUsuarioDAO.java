/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.ForbiddenArgumentTypeException;
import exception.NoDataFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ImagemVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;
import utilidades.Converter;

/**
 *
 * @author 181700271
 */
public class ImagemUsuarioDAO extends ObjetoDAO implements IDAO
{
    /*
        Tabela ImagemUsuario (
            idImagemUsuario INT NOT NULL,
            caminhoImagemUsuario VARCHAR(260) NOT NULL,
            descricaoImagemUsuario VARCHAR(60) NULL,
            dataCriacaoUsuario DATE NOT NULL,
            usuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */

    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImagemVO[] listar() throws SQLException, NoDataFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImagemVO[] pesquisar(int opcao, String dado) throws SQLException, NoDataFoundException {
        if(dado == null || dado.isEmpty() || dado.isBlank())
            throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhum dado informado!");
        else
        {
            String sql;
            ArrayList<ImagemVO> listaResultados = new ArrayList<>();
            
            try(Connection con = new ConexaoBanco().getConexao();)
            {
                switch(opcao)
                {
                    case 1: // idImagemUsuario
                    {
                        sql = "SELECT * "
                                + "FROM imagemUsuario "
                                + "WHERE idImagemUsuario = ? "
                                + "LIMIT 1";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            pstm.setInt(1, Integer.parseInt(dado));
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    ImagemVO iVO = new ImagemVO();
                                    
                                    iVO.setId(rs.getInt("idImagemUsuario"));
                                    iVO.setNomeImagem(rs.getString("nomeimagemusuario"));
                                    iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                                    iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario"));
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                                    iVO.setDiaCriacao(diaMesAno[0]);
                                    iVO.setMesCriacao(diaMesAno[1]);
                                    iVO.setAnoCriacao(diaMesAno[2]);
                                    iVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                                    
                                    listaResultados.add(iVO);
                                }
                                if(!listaResultados.isEmpty())
                                    return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                                else
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com esses dados!");
                            }
                        }
                    }
                    
                    case 2: // caminhoImagem
                    {
                        sql = "SELECT * "
                                + "FROM imagemUsuario "
                                + "WHERE caminhoImagemUsuario = ?";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            pstm.setString(1, dado);
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    ImagemVO iVO = new ImagemVO();
                                    
                                    iVO.setId(rs.getInt("idImagemUsuario"));
                                    iVO.setNomeImagem(rs.getString("nomeimagemusuario"));
                                    iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                                    iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario")); 
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                                    iVO.setDiaCriacao(diaMesAno[0]);
                                    iVO.setMesCriacao(diaMesAno[1]);
                                    iVO.setAnoCriacao(diaMesAno[2]);
                                    iVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                                    
                                    listaResultados.add(iVO);
                                }
                                if(!listaResultados.isEmpty())
                                    return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                                else
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com esses dados!");
                            }
                        }
                    }
                
                    case 3: // descricaoImagem
                    {
                        sql = "SELECT * "
                                + "FROM imagemUsuario "
                                + "WHERE descricaoImagemUsuario = ?";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            pstm.setString(1, dado);
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    ImagemVO iVO = new ImagemVO();
                                    
                                    iVO.setId(rs.getInt("idImagemUsuario"));
                                    iVO.setNomeImagem(rs.getString("nomeimagemusuario"));
                                    iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                                    iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario"));    
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                                    iVO.setDiaCriacao(diaMesAno[0]);
                                    iVO.setMesCriacao(diaMesAno[1]);
                                    iVO.setAnoCriacao(diaMesAno[2]);
                                    iVO.setAtivo(rs.getBoolean("usuarioAtivo"));
                                    
                                    listaResultados.add(iVO);
                                }
                                if(!listaResultados.isEmpty())
                                    return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                                else
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com esses dados!");
                            }
                        }
                    }
                    
                    default:
                        throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Opção de pesquisa inválida!");
                }
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro em ImagemUsuarioDAO.pesquisar: " + se.getMessage());
            }
        }
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
