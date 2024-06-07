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

import enums.QuantColunasBanco;
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
    public ImagemVO[] pesquisar(boolean[] filtros, String[] dados) throws SQLException, NoDataFoundException {
        
        int tamanhoArray = QuantColunasBanco.IMAGEM_USUARIO.getQuantColunas();
        
        if(filtros == null || dados == null)
            throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Filtro ou Dados não informados!");
        else if(filtros.length != tamanhoArray || dados.length != tamanhoArray)
            throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Quantidade de dados/filtros inválida!");
        else
        {
            StringBuffer sql = new StringBuffer("SELECT * FROM imagemUsuario WHERE");
            ArrayList<ImagemVO> listaResultados = new ArrayList<>();
            
            try(Connection con = new ConexaoBanco().getConexao();)
            {
                boolean flagAnd = false;
                for(int i = 0; i < tamanhoArray; i++)
                {
                    if(filtros[i])
                    {
                        switch(i)
                        {
                            case 0:
                            {
                                sql.append(" idImagemUsuario = ?");
                                flagAnd = true;
                                
                                break;
                            }
                            case 1:
                            {
                                if(flagAnd)
                                    sql.append(" AND caminhoImagemUsuario = ?");
                                else
                                {
                                    sql.append(" caminhoImagemUsuario = ?");
                                    flagAnd = true;
                                }
                                
                                break;
                            }
                            case 2:
                            {
                                if(flagAnd)
                                    sql.append(" AND descricaoImagemUsuario = ?");
                                else
                                {
                                    sql.append(" descricaoImagemUsuario = ?");
                                    flagAnd = true;
                                }
                                
                                break;
                            }
                            case 3:
                            {
                                if(flagAnd)
                                    sql.append(" AND dataCriacaoImagemUsuario = ?");
                                else
                                {
                                    sql.append(" dataCriacaoImagemUsuario = ?");
                                    flagAnd = true;
                                }
                                
                                break;
                            }
                            case 4:
                            {
                                if(flagAnd)
                                    sql.append(" AND usuarioAtivo = ?");
                                else
                                {
                                    sql.append(" usuarioAtivo = ?");
                                    flagAnd = true;
                                }
                                
                                break;
                            }
                        }
                    }
                }
                
                try(PreparedStatement pstm = con.prepareStatement(sql.toString());)
                {
                    int cont = 1;
                    for(int i = 0; i < tamanhoArray; i++) {
                        if(filtros[i])
                        {
                            switch(i)
                            {
                                case 0: //idImagemUsuario
                                {
                                    pstm.setInt(cont, Integer.parseInt(dados[i]));
                                    cont++;
                                    break;
                                }
                                case 1: //caminhoImagemUsuario
                                {
                                    pstm.setString(cont, dados[i]);
                                    cont++;
                                    break;
                                }
                                case 2: //descricaoImagemUsuario
                                {
                                    pstm.setString(cont, dados[i]);
                                    cont++;
                                    break;
                                }
                                case 3: //dataCriacaoImagemUsuario
                                {
                                    pstm.setDate(cont, java.sql.Date.valueOf(dados[i]));
                                    cont++;
                                    break;
                                }
                                case 4: //usuarioAtivo
                                {
                                    if(dados[i].toLowerCase().equals("falso"))
                                        pstm.setBoolean(cont, false);
                                    else
                                        pstm.setBoolean(cont, true);
                                    
                                    break;
                                }
                            }
                        }
                    }
                    
                    
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
                            iVO.setAtivo(rs.getBoolean("imagemUsuarioAtiva"));

                            listaResultados.add(iVO);
                        }
                        if(!listaResultados.isEmpty())
                            return listaResultados.toArray(new ImagemVO[listaResultados.size()]);
                        else
                            throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com esse id!");
                    }
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
