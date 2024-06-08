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

import enums.ColunasImagemUsuarioEnum;
import exception.ForbiddenArgumentTypeException;
import exception.NoDataFoundException;
import java.util.HashMap;
import modelo.ImagemPersonagemVO;
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
    public ImagemPersonagemVO[] listar() throws SQLException, NoDataFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImagemPersonagemVO[] pesquisar(ObjetoVO imagemPersonagem) throws SQLException, NoDataFoundException
    {
        ImagemPersonagemVO ipVO = (ImagemPersonagemVO) imagemPersonagem;
        
        final StringBuilder query = new StringBuilder("SELECT * FROM imagemUsuario WHERE");
        ColunasImagemUsuarioEnum[] colunas = ColunasImagemUsuarioEnum.values();
        ArrayList<ColunasImagemUsuarioEnum> colunasModificadas = new ArrayList<>();
        
        boolean temValor = false;
        boolean flagAnd = false;
        for(ColunasImagemUsuarioEnum coluna : colunas)
        {
            Object valor = ipVO.getValorColuna(coluna);
            if(valor != null)
            {
                if(!temValor)
                    temValor = true;
                
                if (flagAnd)
                {
                    query.append(" AND ").append(coluna.getNome()).append(" = ?");
                    colunasModificadas.add(coluna);
                }
                else
                {
                    query.append(" ").append(coluna.getNome()).append(" = ?");
                    colunasModificadas.add(coluna);
                    flagAnd = true;
                }
            }
        }
        
        
        try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(query.toString());)
        {
            
            
            for(int i = 0; i < colunasModificadas.size(); i++)
            {
                switch(colunasModificadas.get(i))
                {
                    case ID_IMAGEM_USUARIO:
                    {
                        int idImagem = (Integer)ipVO.getValorColuna(ColunasImagemUsuarioEnum.ID_IMAGEM_USUARIO);
                        pstm.setInt(i + 1, idImagem);
                        break;
                    }
                    case CAMINHO_IMAGEM_USUARIO:
                    {
                        String caminhoImagem = (String)ipVO.getValorColuna(ColunasImagemUsuarioEnum.CAMINHO_IMAGEM_USUARIO);
                        pstm.setString(i + 1, caminhoImagem);
                        break;
                    }
                    case DESCRICAO_IMAGEM_USUARIO:
                    {
                        String descricaoImagem = (String)ipVO.getValorColuna(ColunasImagemUsuarioEnum.DESCRICAO_IMAGEM_USUARIO);
                        pstm.setString(i + 1, descricaoImagem);
                        break;
                    }
                    case DATA_CRIACAO_IMAGEM_USUARIO:
                    {
                        String dataCriacaoImagem = (String) ipVO.getValorColuna(ColunasImagemUsuarioEnum.DATA_CRIACAO_IMAGEM_USUARIO);
                        pstm.setDate(i + 1, java.sql.Date.valueOf(dataCriacaoImagem));
                        break;
                    }
                    case IMAGEM_USUARIO_ATIVA:
                    {
                        String imagemAtivaString = (String) ipVO.getValorColuna(ColunasImagemUsuarioEnum.IMAGEM_USUARIO_ATIVA);
                        boolean imagemAtiva;
                        switch (imagemAtivaString)
                        {
                            case "verdadeiro":
                            case "true":
                            {
                                imagemAtiva = true;
                                break;
                            }
                            case "falso":
                            case "false":
                            {
                                imagemAtiva = false;
                                break;
                            }
                            default:
                                throw new NoDataFoundException("Erro em ImagemUsuarioDAO.pesquisar: Valor de IMAGEM_USUARIO_ATIVA não é válido!");
                        }
                        
                        pstm.setBoolean(i + 1, imagemAtiva);
                        break;
                    }
                }
            }

            ArrayList<ImagemPersonagemVO> listaResultados = new ArrayList<>();
            
            
            try(ResultSet rs = pstm.executeQuery();)
            {
                while(rs.next())
                {
                    ImagemPersonagemVO ipVOsaida = new ImagemPersonagemVO();
                    
                    ipVOsaida.setValorColuna(
                            ColunasImagemUsuarioEnum.ID_IMAGEM_USUARIO,
                            rs.getInt(ColunasImagemUsuarioEnum.ID_IMAGEM_USUARIO.getNome()));
                    ipVOsaida.setValorColuna(
                            ColunasImagemUsuarioEnum.CAMINHO_IMAGEM_USUARIO,
                            rs.getString(ColunasImagemUsuarioEnum.CAMINHO_IMAGEM_USUARIO.getNome()));
                    ipVOsaida.setValorColuna(
                            ColunasImagemUsuarioEnum.DESCRICAO_IMAGEM_USUARIO,
                            rs.getString(ColunasImagemUsuarioEnum.DESCRICAO_IMAGEM_USUARIO.getNome()));
                    ipVOsaida.setValorColuna(
                            ColunasImagemUsuarioEnum.DATA_CRIACAO_IMAGEM_USUARIO,
                            Converter.converterSQLDateParaDiaMesAno(rs.getDate(ColunasImagemUsuarioEnum.DATA_CRIACAO_IMAGEM_USUARIO.getNome())));
                    ipVOsaida.setValorColuna(
                            ColunasImagemUsuarioEnum.IMAGEM_USUARIO_ATIVA,
                            rs.getBoolean(ColunasImagemUsuarioEnum.IMAGEM_USUARIO_ATIVA.getNome()));

                    listaResultados.add(ipVOsaida);
                }
                if(!listaResultados.isEmpty())
                    return listaResultados.toArray(new ImagemPersonagemVO[listaResultados.size()]);
                else
                    throw new NoDataFoundException("Erro em ImagemDAO.pesquisar: Nenhuma imagem registrada com esse id!");
            }
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro em ImagemUsuarioDAO.pesquisar: " + se.getMessage());
        }
        catch(IllegalArgumentException ie)
        {
            throw new IllegalArgumentException("Erro em ImagemUsuarioDAO.pesquisar: Formato da data informada é inválido (Deve ser Ano-Mês-Dia)!");
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
