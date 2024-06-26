/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.DescricaoPersonagemVO;

/**
 *
 * @author 181700271
 */
public class DescricaoPersonagemServicos
{
    public void cadastrarDescricaoPersonagem(DescricaoPersonagemVO dpVO) throws SQLException {
        DAOFactory.getDescricaoPersonagemDAO().cadastrar(dpVO);
    }
    
    public DescricaoPersonagemVO[] listarDescricoesPersonagem () throws NoDataFoundException, SQLException {
        return DAOFactory.getDescricaoPersonagemDAO().listar();
    }
}
