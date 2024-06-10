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

import exception.NoDataFoundException;
import exception.ForbiddenArgumentTypeException;
import modelo.BackgroundVO;
import modelo.ClasseVO;
import modelo.ImagemVO;
import modelo.ObjetoVO;
import modelo.PersonagemVO;
import modelo.RacaVO;
import modelo.SubRacaVO;
import modelo.SubclasseVO;
import persistencia.ConexaoBanco;
import utilidades.Converter;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class PersonagemDAO extends ObjetoDAO implements IDAO {

    /*
        Tabela Personagem (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            idImagemPersonagem INT NOT NULL,
            idClasse INT NOT NULL,
            idSubclasse INT NOT NULL,
            idRaca INT NOT NULL,
            idSubraca INT NOT NULL,
            idBackground INT NOT NULL,
            nomePersonagem VARCHAR(60) NULL,
            nivelPersonagem INT NOT NULL DEFAULT 1,
            xpPersonagem INT NOT NULL DEFAULT 0,
            inspiracaoPersonagem TINYINT(1) NOT NULL DEFAULT 0,
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */

    @Override
    public void cadastrar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
    }

    @Override
    public PersonagemVO[] listar() throws SQLException, NoDataFoundException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PersonagemVO[] pesquisar(ObjetoVO obVO, String query, int[] indicesDados) throws SQLException, NoDataFoundException
    {
        PersonagemVO pVO = (PersonagemVO) obVO;
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
