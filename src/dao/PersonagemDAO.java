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
    public void cadastrar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        if(!(obVO instanceof PersonagemVO))
            throw new ForbiddenArgumentTypeException("Erro em PersonagemVO.cadastrar: O argumento deve pertencer a classe PersonagemVO!");
        else
        {
            PersonagemVO pVO = (PersonagemVO) obVO;
            String sql = "INSERT INTO personagem "
                    + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
            {
                pstm.setInt(1, pVO.getIdUsuario());
                pstm.setInt(2, pVO.getImagemPersonagem().getId());
                pstm.setInt(3, pVO.getClasse().getId());
                pstm.setInt(4, pVO.getSubclasse().getId());
                pstm.setInt(5, pVO.getRaca().getId());
                pstm.setInt(6, pVO.getSubraca().getId());
                pstm.setInt(7, pVO.getBackground().getId());
                pstm.setString(8, pVO.getNome());
                pstm.setInt(9, pVO.getNivel());
                pstm.setInt(10, pVO.getXp());
                pstm.setBoolean(11, pVO.isInspirado());
                
                pstm.setDate(12, Converter.converterDiaMesAnoParaSQLDate(pVO.getDiaCriacao(), pVO.getMesCriacao(), pVO.getAnoCriacao()));
                pstm.setBoolean(13, true);
                
                pstm.execute();
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro no cadastro do personagem (PersonagemDAO.cadastrar)! " + se.getMessage());
            }
            
        }
    }

    @Override
    public PersonagemVO[] listar() throws SQLException, NoDataFoundException {
        ArrayList<PersonagemVO> listaPersonagens = new ArrayList<>();
        String sql = "SELECT * FROM personagem";
        
        try(Connection con = new ConexaoBanco().getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();)
        {
            while(rs.next())
            {
                PersonagemVO pVO = new PersonagemVO();
                pVO.setId(rs.getInt("idpersonagem"));
                pVO.setIdUsuario(rs.getInt("idusuario"));
                
                ImagemVO iVO = new ImagemVO();
                iVO.setId(rs.getInt("idimagempersonagem"));
                pVO.setImagemPersonagem(iVO);
                
                ClasseVO cVO = new ClasseVO();
                cVO.setId(rs.getInt("idclasse"));
                pVO.setClasse(cVO);
                
                SubclasseVO scVO = new SubclasseVO(cVO.getId());
                scVO.setId(rs.getInt("idsubclasse"));
                pVO.setSubclasse(scVO);
                
                RacaVO rVO = new RacaVO();
                rVO.setId(rs.getInt("idraca"));
                pVO.setRaca(rVO);
                
                SubRacaVO srVO = new SubRacaVO(rVO.getId());
                srVO.setId(rs.getInt("idsubraca"));
                pVO.setSubraca(srVO);
                
                BackgroundVO bVO = new BackgroundVO();
                bVO.setId(rs.getInt("idbackground"));
                pVO.setBackground(bVO);
                
                pVO.setNome(rs.getString("nomepersonagem"));
                pVO.setNivel(rs.getInt("nivelpersonagem"));
                pVO.setXp(rs.getInt("xppersonagem"));
                pVO.setInspirado(rs.getBoolean("inspiracaopersonagem"));
                
                String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("datacriacaopersonagem"));
                pVO.setDiaCriacao(diaMesAno[0]);
                pVO.setMesCriacao(diaMesAno[1]);
                pVO.setAnoCriacao(diaMesAno[2]);
                pVO.setAtivo(rs.getBoolean("Personagemativo"));
                
                listaPersonagens.add(pVO);
            }
            if(listaPersonagens.isEmpty())
                return null;
            else
                return listaPersonagens.toArray(new PersonagemVO[listaPersonagens.size()]);
        }
        catch(SQLException se)
        {
            throw new SQLException("Erro na listagem de personagens (PersonagemDAO.listar)! " + se.getMessage());
        }
    }

    @Override
    public PersonagemVO[] pesquisar(int opcao, String dado) throws SQLException, NoDataFoundException {
        if(dado == null || dado.isEmpty())
            throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Nenhum dado informado!");
        else
        {
            String sql;
            ArrayList<PersonagemVO> listaPersonagens = new ArrayList<>();
            
            try(Connection con = new ConexaoBanco().getConexao();)
            {
                switch(opcao)
                {
                    case 1: // idPersonagem
                    {
                        sql = "SELECT * "
                                + "FROM personagem "
                                + "WHERE idPersonagem = ? "
                                + "LIMIT 1";
                        
                        try(PreparedStatement pstm = con.prepareStatement(sql);)
                        {
                            pstm.setInt(1, Integer.parseInt(dado));
                            try(ResultSet rs = pstm.executeQuery();)
                            {
                                while(rs.next())
                                {
                                    PersonagemVO pVO = new PersonagemVO();
                                    
                                    pVO.setId(rs.getInt("idPersonagem"));
                                    
                                    
                                    
                                    String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(rs.getDate("dataCriacaoUsuario"));
                                    pVO.setDiaCriacao(diaMesAno[0]);
                                    pVO.setMesCriacao(diaMesAno[1]);
                                    pVO.setAnoCriacao(diaMesAno[2]);
                                    pVO.setAtivo(rs.getBoolean("usuarioAtivo"));

                                    listaPersonagens.add(pVO);
                                }
                                if(!listaPersonagens.isEmpty())
                                    return listaPersonagens.toArray(new PersonagemVO[listaPersonagens.size()]);
                                else
                                    throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Nenhum usuário encontrado com os dados informados!");
                            }
                        }
                    }
                    
                    default:
                        throw new NoDataFoundException("Erro em UsuarioDAO.pesquisar: Opção de pesquisa inválida!");
                }
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro na pesquisa de usuários (UsuarioDAO.pesquisar)! " + se.getMessage());
            }
        }
    }

    @Override
    public void alterar(ObjetoVO obVO) throws SQLException, ForbiddenArgumentTypeException {
        if(!(obVO instanceof PersonagemVO))
            throw new ForbiddenArgumentTypeException("Erro em PersonagemDAO.alterar: O argumento deve pertencer a classe PersonagemVO!");
        else
        {
            PersonagemVO pVO = (PersonagemVO) obVO;
            String sql = "UPDATE personagem SET"
                    + "idimagempersonagem = ?"
                    + "idclasse = ?"
                    + "idsubclasse = ?"
                    + "idraca = ?"
                    + "idsubraca = ?"
                    + "idbackground = ?"
                    + "nomepersonagem = ?"
                    + "nivelpersonagem = ?"
                    + "xppersonagem = ?"
                    + "inspiracaopersonagem = ?"
                    + "datacriacaopersonagem = ?"
                    + "personagemativo = ?"
                    + "WHERE idpersonagem = ? AND idusuario = ?";
            
            try(Connection con = new ConexaoBanco().getConexao();
                PreparedStatement pstm = con.prepareStatement(sql);)
            {
                pstm.setInt(1, pVO.getImagemPersonagem().getId());
                pstm.setInt(2, pVO.getClasse().getId());
                pstm.setInt(3, pVO.getSubclasse().getId());
                pstm.setInt(4, pVO.getRaca().getId());
                pstm.setInt(5, pVO.getSubraca().getId());
                pstm.setInt(6, pVO.getBackground().getId());
                pstm.setString(7, pVO.getNome());
                pstm.setInt(8, pVO.getNivel());
                pstm.setInt(9, pVO.getXp());
                pstm.setBoolean(10, pVO.isInspirado());
                
                pstm.setDate(11, Converter.converterDiaMesAnoParaSQLDate(pVO.getDiaCriacao(), pVO.getMesCriacao(), pVO.getAnoCriacao()));
                pstm.setBoolean(12, true);
                
                pstm.setInt(13, pVO.getId());
                pstm.setInt(14, pVO.getIdUsuario());
                
                pstm.executeUpdate();
            }
            catch(SQLException se)
            {
                throw new SQLException("Erro no cadastro do personagem (PersonagemVO.cadastrar)! " + se.getMessage());
            }
            
            
        }
    }

    @Override
    public void excluir(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
