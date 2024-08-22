/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import modelo.PersonagemVO;

/**
 *
 * @author 181700271
 */
public class PersonagemServicos
{
    /**
     *
     * @param pVO
     * @throws SQLException
     */
    public void cadastrarPersonagem(PersonagemVO pVO) throws SQLException {
        DAOFactory.getPersonagemDAO().cadastrar(pVO);
    }
    
    /**
     *
     * @return
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public PersonagemVO[] listarPersonagens() throws NoDataFoundException, SQLException {
        return DAOFactory.getPersonagemDAO().listar();
    }
    
    public PersonagemVO pesquisarPersonagem(int idPersonagem, int idUsuario) throws IllegalArgumentException, NoDataFoundException, SQLException {
        
        PersonagemVO pVO = new PersonagemVO();
        pVO.setId(idPersonagem);
        pVO.setIdUsuario(idUsuario);
        
        return DAOFactory.getPersonagemDAO().pesquisar(pVO, new int[]{0, 1})[0];
    }
    
    /**
     *
     * @param pVO
     * @param indicesCamposFiltragem
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public PersonagemVO[] pesquisarPersonagens(PersonagemVO pVO, int[] indicesCamposFiltragem) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getPersonagemDAO().pesquisar(pVO, indicesCamposFiltragem);
    }
    
    /**
     *
     * @param pVO
     * @throws SQLException
     */
    public void alterarPersonagem(PersonagemVO pVO) throws SQLException {
        DAOFactory.getPersonagemDAO().alterar(pVO);
    }
    
    /**
     *
     * @param pVO
     * @throws SQLException
     */
    public void excluirPersonagem(PersonagemVO pVO) throws SQLException {
        DAOFactory.getPersonagemDAO().excluir(pVO);
    }
    
}
