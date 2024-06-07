/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.ImagemUsuarioDAO;
import enums.ColunasImagemUsuarioEnum;
import exception.NoDataFoundException;
import java.util.ArrayList;
import modelo.ImagemPersonagemVO;
import modelo.ImagemVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemServicos {
    
    public ImagemVO pesquisarImagemUsuario(int idImagem) throws SQLException, NoDataFoundException, IllegalArgumentException {
        
        if(idImagem <= 0)
            throw new IllegalArgumentException("Erro em ImagemServicos.pesquisarImagemUsuario: Valor de idImagem inválido!");
        else
        {
            int tamanhoArray = ColunasImagemUsuarioEnum.getQuantColunas();
        
            boolean[] filtros = new boolean[tamanhoArray];
            filtros[0] = true;

            String[] dados = new String[tamanhoArray];
            dados[0] = Integer.toString(idImagem);

            int quantDados = 1;

            String query = "SELECT * FROM imagemUsuario WHERE " + ColunasImagemUsuarioEnum.ID_IMAGEM_USUARIO.getNome() + " = ? LIMIT 1";

            return DAOFactory.getImagemDAO().pesquisar(filtros, dados, quantDados, query)[0];
        }
    }
    
    public ImagemVO[] pesquisarImagemUsuario(ImagemPersonagemVO ipVO) throws SQLException, NoDataFoundException, IllegalArgumentException {

        StringBuilder query = new StringBuilder("SELECT * FROM imagemUsuario WHERE");
        ColunasImagemUsuarioEnum[] colunas = ColunasImagemUsuarioEnum.values();
        ArrayList<Object> valores = new ArrayList<>();
        boolean temValor = false;
        boolean flagAnd = false;
        
        for (ColunasImagemUsuarioEnum coluna : colunas)
        {
            String valor = ipVO.getValorColuna(coluna);
            if (valor != null)
            {
                if(!temValor)
                    temValor = true;
                
                if (flagAnd)
                    query.append(" AND ").append(coluna.getNome()).append(" = ?");
                else
                {
                    query.append(" ").append(coluna.getNome()).append(" = ?");
                    flagAnd = true;
                }
            }
        }
        
        if(filtros == null || dados == null)
            throw new IllegalArgumentException("Erro em ImagemServicos.pesquisarImagemUsuario: Filtro ou Dados não informados!");
        else if(filtros.length != tamanhoArray || dados.length != tamanhoArray)
            throw new IllegalArgumentException("Erro em ImagemServicos.pesquisarImagemUsuario: Quantidade de dados/filtros inválida!");
        else
        {
            StringBuilder query = new StringBuilder("SELECT * FROM imagemUsuario WHERE");
            boolean flagAnd = false;
            int quantDados = 0;
            
            for(int i = 0; i < tamanhoArray; i++)
            {
                if(filtros[i])
                {
                    switch(i)
                    {
                        case 0:
                        {
                            query.append(" ").append(ColunasImagemUsuarioEnum.ID_IMAGEM_USUARIO.getNome()).append(" = ?");
                            flagAnd = true;
                            
                            quantDados++;
                            break;
                        }
                        case 1:
                        {
                            if(flagAnd)
                                query.append(" AND ").append(ColunasImagemUsuarioEnum.CAMINHO_IMAGEM_USUARIO.getNome()).append(" = ?");
                            else
                            {
                                query.append(" ").append(ColunasImagemUsuarioEnum.CAMINHO_IMAGEM_USUARIO.getNome()).append(" = ?");
                                flagAnd = true;
                            }

                            quantDados++;
                            break;
                        }
                        case 2:
                        {
                            if(flagAnd)
                                query.append(" AND ").append(ColunasImagemUsuarioEnum.DESCRICAO_IMAGEM_USUARIO.getNome()).append(" = ?");
                            else
                            {
                                query.append(" ").append(ColunasImagemUsuarioEnum.DESCRICAO_IMAGEM_USUARIO.getNome()).append(" = ?");
                                flagAnd = true;
                            }

                            quantDados++;
                            break;
                        }
                        case 3:
                        {
                            if(flagAnd)
                                query.append(" AND ").append(ColunasImagemUsuarioEnum.DATA_CRIACAO_IMAGEM_USUARIO.getNome()).append(" = ?");
                            else
                            {
                                query.append(" ").append(ColunasImagemUsuarioEnum.DATA_CRIACAO_IMAGEM_USUARIO.getNome()).append(" = ?");
                                flagAnd = true;
                            }

                            quantDados++;
                            break;
                        }
                        case 4:
                        {
                            if(flagAnd)
                                query.append(" AND ").append(ColunasImagemUsuarioEnum.IMAGEM_USUARIO_ATIVA.getNome()).append(" = ?");
                            else
                                query.append(" ").append(ColunasImagemUsuarioEnum.IMAGEM_USUARIO_ATIVA.getNome()).append(" = ?");

                            quantDados++;
                            break;
                        }
                    }
                }
            }
            
            if(quantDados != 0)
                return DAOFactory.getImagemDAO().pesquisar(filtros, dados, quantDados, query.toString());
            else
                throw new IllegalArgumentException("Erro em ImagemServicos.pesquisarImagemUsuario: Quantidade de dados/filtros inválida!");
        }
    }
    
}
