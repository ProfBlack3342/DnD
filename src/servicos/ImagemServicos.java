/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import modelo.ImagemClasseVO;
import modelo.ImagemPersonagemVO;
import modelo.ImagemRacaVO;
import modelo.ImagemSubClasseVO;
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
        DAOFactory.getImagemUsuarioDAO().cadastrar(iuVO);
    }
    
    /**
     *
     * @return
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public ImagemUsuarioVO[] listarImagensUsuario() throws NoDataFoundException, SQLException {
        return DAOFactory.getImagemUsuarioDAO().listar();
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemClasseVO pesquisarImagemClasse(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        
        ImagemClasseVO icVO = new ImagemClasseVO();
        icVO.setId(id);
        
        return pesquisarImagemClasse(icVO, new int[]{0})[0];
    }

    /**
     *
     * @param icVO
     * @param indicesCamposFiltragem
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemClasseVO[] pesquisarImagemClasse(ImagemClasseVO icVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemClasseDAO().pesquisar(icVO, indicesCamposFiltragem);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemPersonagemVO pesquisarImagemPersonagem(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        
        ImagemPersonagemVO ipVO = new ImagemPersonagemVO();
        ipVO.setId(id);
        
        return pesquisarImagemPersonagem(ipVO, new int[]{0})[0];
    }

    /**
     *
     * @param ipVO
     * @param indicesCamposFiltragem
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemPersonagemVO[] pesquisarImagemPersonagem(ImagemPersonagemVO ipVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemPersonagemDAO().pesquisar(ipVO, indicesCamposFiltragem);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemRacaVO pesquisarImagemRaca(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        
        ImagemRacaVO irVO = new ImagemRacaVO();
        irVO.setId(id);
        
        return pesquisarImagemRaca(irVO, new int[]{0})[0];
    }

    /**
     *
     * @param irVO
     * @param indicesCamposFiltragem
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemRacaVO[] pesquisarImagemRaca(ImagemRacaVO irVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemRacaDAO().pesquisar(irVO, indicesCamposFiltragem);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemSubClasseVO pesquisarImagemSubClasse(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        
        ImagemSubClasseVO iscVO = new ImagemSubClasseVO();
        iscVO.setId(id);
        
        return pesquisarImagemSubClasse(iscVO, new int[]{0})[0];
    }

    /**
     *
     * @param iscVO
     * @param indicesCamposFiltragem
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemSubClasseVO[] pesquisarImagemSubClasse(ImagemSubClasseVO iscVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemSubClasseDAO().pesquisar(iscVO, indicesCamposFiltragem);
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
        
        ImagemUsuarioVO iuVO = new ImagemUsuarioVO();
        iuVO.setId(id);
        
        return DAOFactory.getImagemUsuarioDAO().pesquisar(iuVO, new int[]{0})[0];
    }
    
    /**
     *
     * @param iuVO
     * @param indicesCamposFiltragem
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public ImagemUsuarioVO[] pesquisarImagensUsuario(ImagemUsuarioVO iuVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemUsuarioDAO().pesquisar(iuVO, indicesCamposFiltragem);
    }
    
    /**
     *
     * @param iuVO
     * @throws SQLException
     */
    public void alterarImagemUsuario(ImagemUsuarioVO iuVO) throws SQLException {
        DAOFactory.getImagemUsuarioDAO().alterar(iuVO);
    }
    
    /**
     *
     * @param iuVO
     * @throws SQLException
     */
    public void excluirImagemUsuario(ImagemUsuarioVO iuVO) throws SQLException {
        DAOFactory.getImagemUsuarioDAO().excluir(iuVO);
    }
}
