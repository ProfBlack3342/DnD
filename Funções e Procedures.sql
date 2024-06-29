-- ----------------------------------------------------------------------------------------------------
USE dnd;
DELIMITER //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Atributo -------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarAtributo(
	IN nome VARCHAR(20),
    IN descricao VARCHAR(400),
    IN valor INT
)
BEGIN
	INSERT INTO Atributo (
		idAtributo,
        nomeAtributo,
        descricaoAtributo,
        valorAtributo,
        dataCriacaoAtributo,
        atributoAtivo
	)
VALUES (
		null,
        nome,
        descricao,
        valor,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Background -----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarBackground(
	IN nome VARCHAR(50),
    IN descricao VARCHAR(400)
)
BEGIN
	INSERT INTO Background (
		idBackground,
        idImagemBackground,
        nomeBackground,
        descricaoBackground,
        dataCriacaoBackground,
        BackgroundAtivo
	)
VALUES (
		null,
        1,
        nome,
        descricao,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Classe ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarClasse(
    IN nome VARCHAR(50),
    IN descricaoClasse VARCHAR(400),
    IN dado INT
)
BEGIN
	INSERT INTO  Classe(
		idClasse,
		idImagemClasse,
		nomeClasse,
		descricaoClasse,
		dadoHp,
		dataCriacaoClasse,
		classeAtiva
	)
VALUES (
		null,
		1,
		nome,
		descricao,
		dado,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Equipamento ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarEquipamento(
    idTipo INT,
    nome VARCHAR(50),
    descricao VARCHAR(400),
    dado INT,
    multiplicador INT
)
BEGIN
	INSERT INTO Equipamento (
		idEquipamento,
		idTipoEquipamento,
		nomeEquipamento,
		descricaoEquipamento,
		dadoDano,
		multiplicadorDado,
		dataCriacaoEquipamento,
		equipamentoAtivo
	)
VALUES (
		null,
		idTipo,
		nome,
		descricao,
		dado,
		multiplicador,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Feature --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarFeature(
    nome VARCHAR(50),
    descricao VARCHAR(400)
)
BEGIN
	INSERT INTO Feature (
		idFeature,
		nomeFeature,
		descricaoFeature,
		dataCriacaoFeature,
		featureAtiva
	)
VALUES (
		null,
		nome,
		descricao,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Background -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemBackground(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemBackground (
		idImagemBackground,
        caminhoImagemBackground,
        descricaoImagemBackground,
        dataCriacaoImagemBackground,
        imagemBackgroundAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Classe -----------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemClasse(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemClasse (
		idImagemClasse,
        caminhoImagemClasse,
        descricaoImagemClasse,
        dataCriacaoImagemClasse,
        imagemClasseAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Raca -------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemRaca(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemRaca (
		idImagemRaca,
        caminhoImagemRaca,
        descricaoImagemRaca,
        dataCriacaoImagemRaca,
        imagemRacaAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de SubClasse --------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemSubClasse(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemSubClasse (
		idImagemSubClasse,
        caminhoImagemSubClasse,
        descricaoImagemSubClasse,
        dataCriacaoImagemSubClasse,
        imagemSubClasseAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de SubRaca ----------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemSubRaca(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemSubRaca (
		idImagemSubRaca,
        caminhoImagemSubRaca,
        descricaoImagemSubRaca,
        dataCriacaoImagemSubRaca,
        imagemSubRacaAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Usuario ----------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemUsuario(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemUsuario (
		idImagemUsuario,
        caminhoImagemUsuario,
        descricaoImagemUsuario,
        dataCriacaoImagemUsuario,
        imagemUsuarioAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Personagem -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemPersonagem(
	IN caminhoImagem VARCHAR(260),
    IN descricaoImagem VARCHAR(400)
)
BEGIN
	INSERT INTO ImagemPersonagem (
		idImagemPersonagem,
        caminhoImagemPersonagem,
        descricaoImagemPersonagem,
        dataCriacaoImagemPersonagem,
        imagemPersonagemAtiva
	)
VALUES (
		null,
        caminhoImagem,
        descricaoImagem,
        CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Linguagem ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarLinguagem(
	nome VARCHAR(40),
    descricao VARCHAR(400)
)
BEGIN
	INSERT INTO Linguagem (
		idLinguagem,
		nomeLinguagem,
		descricaoLinguagem,
		dataCriacaoLinguagem,
		linguagemAtiva
	)
VALUES (
		null,
		nome,
		descricao,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Pericia --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarPericia(
    idAtributo INT,
    nome VARCHAR(30),
    descricao VARCHAR(400)
)
BEGIN
	INSERT INTO Pericia (
		idPericia,
		idAtributoModificador,
		nomePericia,
		descricaoPericia,
		dataCriacaoPericia,
		periciaAtiva
	)
VALUES (
		null,
		idAtributo,
		nome,
		descricao,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Personagem -----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarPersonagem(
	idU INT,
	idC INT,
	idSubC INT,
	idR INT,
	idSubR INT,
	idB INT,
	nome VARCHAR(50),
	alinhamento VARCHAR(30),
	idade INT,
	altura DOUBLE(4, 2),
	peso DOUBLE(5, 2),
	olhos VARCHAR(20),
	pele VARCHAR(30),
	cabelo VARCHAR(30),
	aparencia VARCHAR(400),
	historia VARCHAR(2000),
	personalidade VARCHAR(1200),
	ideais VARCHAR(50),
	ligacoes VARCHAR(50),
	defeitos VARCHAR(50),
	aliados VARCHAR(50),
	outrasInformacoes VARCHAR(2000)
)
BEGIN
	INSERT INTO Personagem (
		idPersonagem,
		idUsuario,
		idImagemPersonagem,
		idClasse,
		idSubclasse,
		idRaca,
		idSubraca,
		idBackground,
		nomePersonagem,
		alinhamentoPersonagem,
		idadePersonagem,
		alturaPersonagem,
		pesoPersonagem,
		olhosPersonagem,
		pelePersonagem,
		cabeloPersonagem,
		aparenciaPersonagem,
		historiaPersonagem,
		personalidadePersonagem,
		ideaisPersonagem,
		ligacoesPersonagem,
		defeitosPersonagem,
		aliadosPersonagem,
		outrasInformacoesPersonagem,
		dataCriacaoPersonagem,
		personagemAtivo
	)
VALUES (
		null,
        idU,
		1,
		idC,
		idSubC,
		idR,
		idSubR,
		idB,
		nome,
		alinhamento,
		idade,
		altura,
		peso,
		olhos,
		pele,
		cabelo,
		aparencia,
		historia,
		personalidade,
		ideais,
		ligacoes,
		defeitos,
		aliados,
		outrasInformacoes,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Raca -----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRaca(
	nome VARCHAR(50),
	descricao VARCHAR(400),
	idadeMax INT,
	tamanho VARCHAR(20),
	velocidade INT
)
BEGIN
	INSERT INTO Raca (
		idRaca,
		idImagemRaca,
		nomeRaca,
		descricaoRaca,
		idadeMaxRaca,
		tamanhoRaca,
		velocidadeRaca,
		dataCriacaoRaca,
		racaAtiva
	)
VALUES (
		null,
		1,
		nome,
		descricao,
		idadeMax,
		tamanho,
		velocidade,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de SubClasse ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarSubClasse(
	idC INT,
	nome VARCHAR(50),
	descricao VARCHAR(400)
)
BEGIN
	INSERT INTO SubClasse (
		idSubClasse,
		idClasse,
		idImagemSubClasse,
		nomeSubClasse,
		descricaoSubClasse,
		dataCriacaoSubClasse,
		subClasseAtiva
	)
VALUES (
		null,
		idC,
		1,
		nome,
		descricao,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de SubRaca --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarSubRaca(
	idR INT,
	nome VARCHAR(50),
	descricao VARCHAR(400)
)
BEGIN
	INSERT INTO SubRaca (
		idSubRaca,
		idRaca,
		idImagemSubRaca,
		nomeSubRaca,
		descricaoSubRaca,
		dataCriacaoSubRaca,
		subRacaAtiva
	)
VALUES (
		null,
		idR,
		1,
		nome,
		descricao,
		CAST(GETDATE() AS Date),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Usuario --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarUsuario(
	nome VARCHAR(50),
	senha CHAR(60),
	email VARCHAR(70),
	dataAniversario DATE,
	descricao VARCHAR(400),
	quantPersonagensTotal INT,
	quantPersonagensCriados INT
)
BEGIN
	INSERT INTO Usuario (
		idUsuario,
		idImagemUsuario,
		idTipoUsuario,
		nomeUsuario,
		senhaUsuario,
		emailUsuario,
		dataAniversarioUsuario,
		descricaoUsuario,
		quantPersonagensTotalUsuario,
		quantPersonagensCriadosUsuario,
		dataCriacaoUsuario,
		usuarioAtivo
	)
VALUES (
		null,
		1,
		2,
		nome,
		senha,
		email,
		dataAniversario,
		descricao,
		quantPersonagensTotal,
		quantPersonagensCriados,
		CAST(GETDATE() AS Date),
        true
	);
END //

DELIMITER ;

-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------