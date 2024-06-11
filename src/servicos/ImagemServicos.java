/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import modelo.ImagemUsuarioVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ImagemServicos
{
    /**
     *
     * @param iuVO
     * @throws IllegalArgumentException
     * @throws SQLException
     */
    public void cadastrarImagemUsuario(ImagemUsuarioVO iuVO) throws SQLException {
        DAOFactory.getImagemDAO().cadastrar(iuVO);
    }
    
    /**
     *
     * @return
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public ImagemUsuarioVO[] listarImagensUsuario() throws NoDataFoundException, SQLException {
        return DAOFactory.getImagemDAO().listar();
    }
    
    /**
     *
     * @param id
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public ImagemUsuarioVO pesquisarImagemUsuario(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        String query = "SELECT * "
                + "FROM " + ImagemUsuarioVO.getNomeTabela() + " "
                + "WHERE " + ImagemUsuarioVO.getNomesColunas()[0] + " = ? "
                + "LIMIT 1";
        
        ImagemUsuarioVO iuVO = new ImagemUsuarioVO();
        iuVO.setId(id);
        
        return DAOFactory.getImagemDAO().pesquisar(iuVO, query, new int[]{0})[0];
    }
    
    /**
     *
     * @param iuVO
     * @param query
     * @param indicesDados
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public ImagemUsuarioVO[] pesquisarImagensUsuario(ImagemUsuarioVO iuVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemDAO().pesquisar(iuVO, query, indicesDados);
    }
    
    /**
     *
     * @param iuVO
     * @throws SQLException
     */
    public void alterarImagemUsuario(ImagemUsuarioVO iuVO) throws SQLException {
        DAOFactory.getImagemDAO().alterar(iuVO);
    }
    
    /**
     *
     * @param iuVO
     * @throws SQLException
     */
    public void excluirImagemUsuario(ImagemUsuarioVO iuVO) throws SQLException {
        DAOFactory.getImagemDAO().excluir(iuVO);
    }
}
