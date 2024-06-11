/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.sql.SQLException;

import dao.DAOFactory;
import exception.NoDataFoundException;
import objetosFront.DadosLogin;
import modelo.UsuarioVO;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class UsuarioServicos
{
    /**
     * 
     * @param lVO
     * @return
     * @throws NoDataFoundException
     * @throws SQLException 
     */
    public UsuarioVO loginUsuario(DadosLogin lVO) throws NoDataFoundException, SQLException {
        return DAOFactory.getUsuarioDAO().login(lVO);
    }
    
    /**
     * 
     * @param uVO
     * @throws SQLException
     */
    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException {
        DAOFactory.getUsuarioDAO().cadastrar(uVO);
    }
    
    /**
     * 
     * @return
     * @throws NoDataFoundException 
     * @throws SQLException 
     */
    public UsuarioVO[] listarUsuarios() throws NoDataFoundException, SQLException {
        return DAOFactory.getUsuarioDAO().listar();
    }
    
    /**
     *
     * @param idUsuario
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public UsuarioVO pesquisarUsuario(int idUsuario) throws IllegalArgumentException, NoDataFoundException, SQLException {
        String query = "SELECT * "
                + "FROM " + UsuarioVO.getNomeTabela() + " "
                + "WHERE " + UsuarioVO.getNomesColunas()[0] + " = ? "
                + "LIMIT 1";
        
        UsuarioVO uVO = new UsuarioVO();
        uVO.setId(idUsuario);
        
        return DAOFactory.getUsuarioDAO().pesquisar(uVO, query, new int[]{0})[0];
    }
    
    /**
     *
     * @param uVO
     * @param query
     * @param indicesDados
     * @return
     * @throws IllegalArgumentException
     * @throws NoDataFoundException
     * @throws SQLException
     */
    public UsuarioVO[] pesquisarUsuarios(UsuarioVO uVO, String query, int[] indicesDados) throws IllegalArgumentException, NoDataFoundException, SQLException {
        return DAOFactory.getUsuarioDAO().pesquisar(uVO, query, indicesDados);
    }
    
    /**
     * 
     * @param uVO
     * @throws SQLException
     */
    public void alterarUsuario(UsuarioVO uVO) throws SQLException {
        DAOFactory.getUsuarioDAO().alterar(uVO);
    }
    
    /**
     * 
     * @param uVO
     * @throws SQLException 
     */
    public void excluirUsuario(UsuarioVO uVO) throws SQLException {
        DAOFactory.getUsuarioDAO().excluir(uVO);
    }
}
