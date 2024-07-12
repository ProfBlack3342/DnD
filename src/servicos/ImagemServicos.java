/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import modelo.ClasseVO;
import modelo.ImagemClasseVO;
import modelo.ImagemPersonagemVO;
import modelo.ImagemRacaVO;
import modelo.ImagemSubClasseVO;
import modelo.ImagemUsuarioVO;
import modelo.PersonagemVO;
import modelo.RacaVO;

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
        String query = "SELECT * "
                + "FROM " + ImagemClasseVO.getNomeTabela() + " "
                + "WHERE " + ImagemClasseVO.getNomesColunas()[0] + " = ?"
                + " LIMIT 1";
        
        ImagemClasseVO icVO = new ImagemClasseVO();
        icVO.setId(id);
        
        return pesquisarImagemClasse(icVO, query, new int[]{0})[0];
    }

    /**
     *
     * @param icVO
     * @param query
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemClasseVO[] pesquisarImagemClasse(ImagemClasseVO icVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemClasseDAO().pesquisar(iuVO, query, indicesDados);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemPersonagemVO pesquisarImagemPersonagem(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        String query = "SELECT * "
                + "FROM " + ImagemPersonagemVO.getNomeTabela() + " "
                + "WHERE " + ImagemPersonagemVO.getNomesColunas()[0] + " = ?"
                + " LIMIT 1";
        
        ImagemPersonagemVO ipVO = new ImagemPersonagemVO();
        ipVO.setId(id);
        
        return pesquisarImagemPersonagem(ipVO, query, new int[]{0})[0];
    }

    /**
     *
     * @param ipVO
     * @param query
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemPersonagemVO[] pesquisarImagemPersonagem(ImagemPersonagemVO ipVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemPersonagemDAO().pesquisar(iuVO, query, indicesDados);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemRacaVO pesquisarImagemRaca(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        String query = "SELECT * "
                + "FROM " + ImagemRacaVO.getNomeTabela() + " "
                + "WHERE " + ImagemRacaVO.getNomesColunas()[0] + " = ?"
                + " LIMIT 1";
        
        ImagemRacaVO irVO = new ImagemRacaVO();
        irVO.setId(id);
        
        return pesquisarImagemRaca(irVO, query, new int[]{0})[0];
    }

    /**
     *
     * @param irVO
     * @param query
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemRacaVO[] pesquisarImagemRaca(ImagemRacaVO irVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemRacaDAO().pesquisar(iuVO, query, indicesDados);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemSubClasseVO pesquisarImagemSubClasse(int id) throws IllegalArgumentException, NoDataFoundException, SQLException {
        String query = "SELECT * "
                + "FROM " + ImagemSubClasseVO.getNomeTabela() + " "
                + "WHERE " + ImagemSubClasseVO.getNomesColunas()[0] + " = ?"
                + " LIMIT 1";
        
        ImagemSubClasseVO iscVO = new ImagemSubClasseVO();
        iscVO.setId(id);
        
        return pesquisarImagemSubClasse(iscVO, query, new int[]{0})[0];
    }

    /**
     *
     * @param iscVO
     * @param query
     * @return
     * @throws exception.NoDataFoundException
     * @throws java.sql.SQLException
     */
    public ImagemSubClasseVO[] pesquisarImagemSubClasse(ImagemSubClasseVO iscVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getImagemSubClasseDAO().pesquisar(iuVO, query, indicesDados);
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
        
        return DAOFactory.getImagemUsuarioDAO().pesquisar(iuVO, query, new int[]{0})[0];
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
        return DAOFactory.getImagemUsuarioDAO().pesquisar(iuVO, query, indicesDados);
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
