-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
USE dnd;
DELIMITER //
-- ----------------------------------------------------------------------------------------------------
-- Usuario --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE FazerLogin (
    IN nome VARCHAR(50),
    IN senha CHAR(60)
)
BEGIN
	SELECT * FROM Usuario
		WHERE nomeUsuario = nome
        AND senhaUsuario = senha
        LIMIT 1;
END //

CREATE PROCEDURE RegistrarUsuario (
    IN nome VARCHAR(50),
    IN senha CHAR(60),
    IN email VARCHAR(70),
    IN dataAniversario DATE,
    IN descricao VARCHAR(500)
)
BEGIN
	INSERT INTO Usuario
	VALUES
		( null, 1, 2, nome, senha, email, dataAniversario, descricao, 9, 0, CURDATE(), 1 );
END //

CREATE PROCEDURE RegistrarUsuarioGM (
	IN nome VARCHAR(50),
    IN senha CHAR(60),
    IN email VARCHAR(70),
    IN dataAniversario DATE,
    IN descricao VARCHAR(500)
)
BEGIN
	INSERT INTO Usuario
	VALUES
		( null, 1, 3, nome, senha, email, dataAniversario, descricao, 9, 0, CURDATE(), 1 );
END //

CREATE PROCEDURE RegistrarUsuarioAdmin (
	nome VARCHAR(50),
    senha CHAR(60),
    email VARCHAR(70),
    dataAniversario DATE,
    descricao VARCHAR(500)
)
BEGIN
	INSERT INTO Usuario
	VALUES
		( null, 1, 1, nome, senha, email, dataAniversario, descricao, 9, 0, CURDATE(), 1 );
END //

-- ----------------------------------------------------------------------------------------------------
-- Personagem -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarPersonagem (
    IN idUser INT,
    IN idImagem INT,
    IN idSubclasse INT,
    IN idClasse INT,
    IN idSubraca INT,
    IN idRaca INT,
    IN idBackground INT,
    IN valorSTRBase INT,
    IN valorDEXBase INT,
    IN valorCONBase INT,
    IN valorINTBase INT,
    IN valorWISBase INT,
    IN valorCHABase INT,
    IN nome VARCHAR(50),
    IN alinhamento VARCHAR(30),
    IN idade INT,
    IN altura DOUBLE(4, 2),
    IN peso DOUBLE(5, 2),
    IN olhos VARCHAR(20),
    IN pele VARCHAR(30),
    IN cabelo VARCHAR(30),
    IN aparencia VARCHAR(1000),
    IN historia VARCHAR(2000),
    IN personalidade VARCHAR(1200),
    IN ideais VARCHAR(50),
    IN ligacoes VARCHAR(50),
    IN defeitos VARCHAR(50),
    IN aliados VARCHAR(50),
    IN outrasInformacoes VARCHAR(2000),
    IN quantCobre INT,
    IN quantPrata INT,
    IN quantElectrum INT,
    IN quantOuro INT,
    IN quantPlatina INT
)
BEGIN
	INSERT INTO Personagem
	VALUES
		( null, idUser, idImagem, idSubclasse, idClasse, idSubraca, idRaca, idBackground, valorSTRBase, valorDEXBase, valorCONBase, valorINTBase, valorWISBase, valorCHABase, nome, alinhamento, idade, altura, peso, olhos, pele, cabelo, aparencia, historia, personalidade, ideais, ligacoes, defeitos, aliados, outrasInformacoes, quantCobre, quantPrata, quantElectrum, quantOuro, quantPlatina, CURDATE(), 1 );
END //

-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
DELIMITER ;
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------