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

import exception.ForbiddenArgumentTypeException;
import exception.NoDataFoundException;
import modelo.ImagemVO;
import modelo.ObjetoVO;
import persistencia.ConexaoBanco;
import utilidades.Converter;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemUsuarioDAO extends ObjetoDAO implements IDAO
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
        if(dado == null || dado.isEmpty())
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
                                    
                                    iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                                    iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario"));
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoImagemUsuario"));
                                    iVO.setDiaCriacao(diaMesAno[0]);
                                    iVO.setMesCriacao(diaMesAno[1]);
                                    iVO.setAnoCriacao(diaMesAno[2]);
                                    iVO.setAtivo(rs.getBoolean("imagemUsuarioAtivo"));
                                    
                                    listaResultados.add(iVO);
                                }
                                if(!listaResultados.isEmpty())
                                    return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                                else
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com esse id!");
                            }
                        }
                    }
                    
                    case 2: // dataCriacaoImagemUsuario
                    {
                        sql = "SELECT * "
                                + "FROM imagemUsuario "
                                + "WHERE dataCriacaoImagemUsuario = ?";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            pstm.setDate(1, java.sql.Date.valueOf(dado));
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    ImagemVO iVO = new ImagemVO();
                                    
                                    iVO.setId(rs.getInt("idImagemUsuario"));
                                    
                                    iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                                    iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario")); 
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoImagemUsuario"));
                                    iVO.setDiaCriacao(diaMesAno[0]);
                                    iVO.setMesCriacao(diaMesAno[1]);
                                    iVO.setAnoCriacao(diaMesAno[2]);
                                    iVO.setAtivo(rs.getBoolean("imagemUsuarioAtivo"));
                                    
                                    listaResultados.add(iVO);
                                }
                                if(!listaResultados.isEmpty())
                                    return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                                else
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com criação nessa data!");
                            }
                        }
                    }
                
                    case 3: // usuarioAtivo
                    {
                        sql = "SELECT * "
                                + "FROM imagemUsuario "
                                + "WHERE imagemUsuarioAtivo = ?";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            boolean ativa;
                            switch (dado.toLowerCase())
                            {
                                case "verdadeiro":
                                case "sim":
                                    ativa = true;
                                    break;
                                case "falso":
                                case "não":
                                    ativa = false;
                                    break;
                                default:
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Dado informado é inválido!");
                            }
                            
                            pstm.setBoolean(1, ativa);
                            
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    ImagemVO iVO = new ImagemVO();
                                    
                                    iVO.setId(rs.getInt("idImagemUsuario"));
                                    
                                    iVO.setCaminhoImagem(rs.getString("caminhoimagemusuario"));
                                    iVO.setDescricaoImagem(rs.getString("descricaoimagemusuario"));    
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoImagemUsuario"));
                                    iVO.setDiaCriacao(diaMesAno[0]);
                                    iVO.setMesCriacao(diaMesAno[1]);
                                    iVO.setAnoCriacao(diaMesAno[2]);
                                    iVO.setAtivo(rs.getBoolean("imagemUsuarioAtivo"));
                                    
                                    listaResultados.add(iVO);
                                }
                                if(!listaResultados.isEmpty())
                                    return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                                else
                                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada está ativa!");
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
            catch(IllegalArgumentException ie)
            {
                throw new NoDataFoundException("Erro em ImagemUsuarioDAO.pesquisar: Formato da data informada é inválido (Deve ser Ano-Mês-Dia)!");
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
