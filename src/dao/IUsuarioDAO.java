/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import exception.NoDataFoundException;
import java.sql.SQLException;
import modelo.UsuarioVO;

/**
 *
 * @author dudup
 */
public interface IUsuarioDAO extends IDAO {
    UsuarioVO login(String nomeUsuario, String senhaCandidata) throws NoDataFoundException, SQLException;
}
