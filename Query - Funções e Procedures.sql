-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
USE dnd;
DELIMITER //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Arma ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarArma (
    nome VARCHAR(50),
    descricao VARCHAR(400),
    dado INT,
    multiplicadorDado INT
)
BEGIN
	INSERT INTO Arma (
		idArma,
		nomeArma,
		descricaoArma,
		dadoDano,
		multiplicadorDado,
		dataCriacaoArma,
		ArmaAtiva
	)
VALUES (
		null,
        nomeArma,
        nome,
		descricao,
		dado,
		multiplicadorDado,
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Armadura ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarArmadura (
    nome VARCHAR(50),
    descricao VARCHAR(400),
    dado INT,
    multiplicadorDado INT
)
BEGIN
	INSERT INTO Armadura (
		idArmadura,
		nomeArmadura,
		descricaoArmadura,
		dadoAcArmadura,
		multiplicadorAcArmadura,
		dataCriacaoArmadura,
		ArmaduraAtiva
	)
VALUES (
		null,
        nome,
		descricao,
		dado,
		multiplicadorDado,
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Feature --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarFeature (
    nome VARCHAR(50),
    descricao VARCHAR(400),
    concedeProficienciaArma TINYINT(1),
    concedeProficienciaArmadura TINYINT(1),
    concedeProficienciaFerramenta TINYINT(1),
    concedeProficienciaLinguagem TINYINT(1),
    concedeProficienciaPericia TINYINT(1),
    concedeProficienciaSaveAtributo TINYINT(1),
    concedeSpell TINYINT(1)
)
BEGIN
	INSERT INTO Feature (
		idFeature,
		nomeFeature,
		descricaoFeature,
		featureConcedeProficienciaArma,
		featureConcedeProficienciaArmadura,
		featureConcedeProficienciaFerramenta,
		featureConcedeProficienciaLinguagem,
		featureConcedeProficienciaPericia,
		featureConcedeProficienciaSaveAtributo,
		featureConcedeSpell,
		dataCriacaoFeature,
		featureAtiva
	)
VALUES (
		null,
		nome,
		descricao,
		concedeProficienciaArma,
		concedeProficienciaArmadura,
		concedeProficienciaFerramenta,
		concedeProficienciaLinguagem,
		concedeProficienciaPericia,
		concedeProficienciaSaveAtributo,
		concedeSpell,
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Ferramenta ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarFerramenta (
    nomeFerramenta VARCHAR(50),
    descricaoFerramenta VARCHAR(400)
)
BEGIN
	INSERT INTO Ferramenta (
		idFerramenta,
		nomeFerramenta,
		descricaoFerramenta,
		dataCriacaoFerramenta,
		ferramentaAtiva
	)
VALUES (
		null,
        nomeFerramenta,
		descricaoFerramenta,
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Linguagem ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarLinguagem (
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
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Pericia --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarPericia (
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
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Spell ----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarSpell (
	nome VARCHAR(30),
    descricao VARCHAR(400),
    dado INT,
    multiplicadorDado INT,
    temComponenteVerbal TINYINT(1),
    temcomponenteSomatico TINYINT(1),
    temcomponenteMaterial TINYINT(1)
)
BEGIN
	INSERT INTO Spell (
		idSpell,
		nomeSpell,
		descricaoSpell,
		dadoSpell,
		multiplicadorDadoSpell,
		spellTemComponenteVerbal,
		spellTemcomponenteSomatico,
		spellTemcomponenteMaterial,
		dataCriacaoSpell,
		spellAtiva
    )
    VALUES (
		null,
		nome,
		descricao,
		dado,
		multiplicadorDado,
		temComponenteVerbal,
		temcomponenteSomatico,
		temcomponenteMaterial,
		CURDATE(),
        true
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Background -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemBackground (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Background -----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarBackground (
	nome VARCHAR(50),
    descricao VARCHAR(400),
    dinheiroInicial INT,
    quantEquipamentosIniciais INT,
    quantLinguagensIniciais INT,
    quantProficienciasFerramentas INT,
    quantProficienciasPericias INT,
    quantFeatures INT
)
BEGIN
	INSERT INTO Background (
		idBackground,
        idImagemBackground,
        nomeBackground,
		descricaoBackground,
        dinheiroInicialBackground,
		quantEquipamentosIniciaisBackground,
		quantLinguagensIniciaisBackground,
		quantProficienciasFerramentasBackground,
		quantProficienciasPericiasBackground,
		quantFeaturesBackground,
        dataCriacaoBackground,
        BackgroundAtivo
	)
VALUES (
		null,
        1,
        nome,
		descricao,
        dinheiroInicial,
		quantEquipamentosIniciais,
		quantLinguagensIniciais,
		quantProficienciasFerramentas,
		quantProficienciasPericias,
		quantFeatures,
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Classe -----------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemClasse (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Classe ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarClasse (
    idImagem INT,
    nome VARCHAR(50),
    descricao VARCHAR(400),
    dado INT,
    TemSpells TINYINT(1),
    quantProficienciasArmadura INT,
    quantProficienciasArmas INT,
    quantProficienciasFerramentas INT,
    quantProficienciasPericias INT,
    quantProficienciasSavesAtributos INT,
    quantFeatures INT
)
BEGIN
	INSERT INTO Classe (
		idClasse,
		idImagemClasse,
		nomeClasse,
		descricaoClasse,
		dadoClasse,
		classeTemSpells,
		quantProficienciasArmaduraClasse,
		quantProficienciasArmasClasse,
		quantProficienciasFerramentasClasse,
		quantProficienciasPericiasClasse,
		quantProficienciasSavesAtributosClasse,
		quantFeaturesClasse,
		dataCriacaoClasse,
		classeAtiva
	)
VALUES (
		null,
		1,
		nome,
		descricao,
		dado,
		TemSpells,
		quantProficienciasArmadura,
		quantProficienciasArmas,
		quantProficienciasFerramentas,
		quantProficienciasPericias,
		quantProficienciasSavesAtributos,
		quantFeatures,
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de SubClasse --------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemSubClasse (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de SubClasse ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarSubClasse (
	idC INT,
    nome VARCHAR(50),
    descricao VARCHAR(400),
    quantFeatures INT
)
BEGIN
	INSERT INTO SubClasse (
		idSubClasse,
		idClasse,
		idImagemSubClasse,
		nomeSubClasse,
		descricaoSubClasse,
		quantFeaturesSubClasse,
		dataCriacaoSubClasse,
		subClasseAtiva
	)
VALUES (
		null,
		idC,
		1,
		nome,
		descricao,
        quantFeatures,
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Raca -------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemRaca (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Raca -----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRaca (
    nome VARCHAR(50),
    descricao VARCHAR(400),
    valorBuffAtributo INT,
    idadeMax INT,
    tamanho VARCHAR(20),
    velocidade INT,
    quantFeatures INT
)
BEGIN
	INSERT INTO Raca (
		idRaca,
		idImagemRaca,
		nomeRaca,
		descricaoRaca,
		valorBuffAtributoRaca,
		idadeMaxRaca,
		tamanhoRaca,
		velocidadeRaca,
		quantFeaturesRaca,
		dataCriacaoRaca,
		racaAtiva
	)
VALUES (
		null,
		1,
		nome,
		descricao,
		valorBuffAtributo,
		idadeMax,
		tamanho,
		velocidade,
		quantFeatures,
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de SubRaca ----------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemSubRaca (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de SubRaca --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarSubRaca (
    nome VARCHAR(50),
    descricao VARCHAR(400),
    valorBuffAtributo INT,
    quantFeatures INT
)
BEGIN
	INSERT INTO SubRaca (
		idSubRaca,
		idRaca,
		idImagemSubRaca,
		nomeSubRaca,
		descricaoSubRaca,
		valorBuffAtributoSubRaca,
		quantFeaturesSubRaca,
		dataCriacaoSubRaca,
		subRacaAtiva
	)
VALUES (
		null,
		idR,
		1,
		nome,
		descricao,
		valorBuffAtributo,
		quantFeatures,
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Usuario ----------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemUsuario (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Usuario --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarUsuario (
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
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Imagem de Personagem -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarImagemPersonagem (
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
        CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Personagem -----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarPersonagem (
	idSubclasse INT,
    idClasse INT,
    idSubraca INT,
    idRaca INT,
    idBackground INT,
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
        idSubclassePersonagem,
		idClassePersonagem,
		idSubracaPersonagem,
		idRacaPersonagem,
		idBackgroundPersonagem,
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
        idSubclasse,
		idClasse,
		idSubraca,
		idRaca,
		idBackground,
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
		CURDATE(),
        true
	);
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Background_Armadura ------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoBackgroundArmadura (
	idB INT,
    idA INT
)
BEGIN
	INSERT INTO Background_Armadura (
		idBackground,
		idArmadura
    )
    VALUES (
		idB,
        idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Background_Feature -------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoBackgroundFeature (
	idB INT,
    idF INT
)
BEGIN
	INSERT INTO Background_Feature (
		idBackground,
		idFeature
    )
    VALUES (
		idB,
		idF
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Background_Ferramenta ----------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoBackgroundFerramenta (
	idB INT,
    idF INT
)
BEGIN
	INSERT INTO Background_Ferramenta (
		idBackground,
		idFerramenta
    )
    VALUES (
		idB,
		idF
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Background_Linguagem -----------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoBackgroundLinguagem (
	idB INT,
    idL INT
)
BEGIN
	INSERT INTO Background_Linguagem (
		idBackground,
		idLinguagem
    )
    VALUES (
		idB,
		idL
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Background_Pericia -------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoBackgroundPericia (
	idB INT,
    idP INT
)
BEGIN
	INSERT INTO Background_Pericia (
		idBackground,
		idPericia
    )
    VALUES (
		idB,
		idP
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Arma --------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClasseArma (
	idC INT,
	idA INT
)
BEGIN
	INSERT INTO Classe_Arma (
		idClasse,
		idArma
    )
    VALUES (
		idC,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Armadura ----------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClasseArmadura (
	idC INT,
	idA INT
)
BEGIN
	INSERT INTO Classe_Armadura (
		idClasse,
		idArmadura
    )
    VALUES (
		idC,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Atributo ----------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClasseAtributo (
	idC INT,
	idA INT
)
BEGIN
	INSERT INTO Classe_Atributo (
		idClasse,
		idAtributo
    )
    VALUES (
		idC,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Feature -----------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClasseFeature (
	idC INT,
	idF INT
)
BEGIN
	INSERT INTO Classe_Feature (
		idClasse,
		idFeature
    )
    VALUES (
		idC,
		idF
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Ferramenta --------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClasseFerramenta (
	idC INT,
	idF INT
)
BEGIN
	INSERT INTO Classe_Ferramenta (
		idClasse,
		idFerramenta
    )
    VALUES (
		idC,
		idF
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Pericia -----------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClassePericia (
	idC INT,
	idP INT
)
BEGIN
	INSERT INTO Classe_Pericia (
		idClasse,
		idPericia
    )
    VALUES (
		idC,
		idP
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Classe_Spell -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoClasseSpell (
	idC INT,
	idS INT
)
BEGIN
	INSERT INTO Classe_Spell (
		idClasse,
		idSpell
    )
    VALUES (
		idC,
		idS
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Arma -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeatureArma (
	idF INT,
	idA INT
)
BEGIN
	INSERT INTO Feature_Arma (
		idFeature,
		idArma
    )
    VALUES (
		idF,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Armadura ---------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeatureArmadura (
	idF INT,
	idA INT
)
BEGIN
	INSERT INTO Feature_Armadura (
		idFeature,
		idArmadura
    )
    VALUES (
		idF,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Atributo ---------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeatureAtributo (
	idF INT,
	idA INT
)
BEGIN
	INSERT INTO Feature_Atributo (
		idFeature,
		idAtributo
    )
    VALUES (
		idF,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Ferramenta -------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeatureFerramenta (
	idFeat INT,
	idFerr INT
)
BEGIN
	INSERT INTO Feature_Ferramenta (
		idFeature,
		idFerramenta
    )
    VALUES (
		idFeat,
		idFerr
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Linguagem --------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeatureLinguagem (
	idF INT,
	idL INT
)
BEGIN
	INSERT INTO Feature_Linguagem (
		idFeature,
		idLinguagem
    )
    VALUES (
		idF,
		idL
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Pericia ----------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeaturePericia (
	idF INT,
	idP INT
)
BEGIN
	INSERT INTO Feature_Pericia (
		idFeature,
		idPericia
    )
    VALUES (
		idF,
		idP
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Feature_Spell ------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoFeatureSpell (
	idF INT,
	idS INT
)
BEGIN
	INSERT INTO Feature_Spell (
		idFeature,
		idSpell
    )
    VALUES (
		idF,
		idS
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Raça_Atributo ------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoRacaAtributo (
	idR INT,
    idA INT
)
BEGIN
	INSERT INTO Raca_Atributo (
		idRaca,
		idAtributo
    )
    VALUES (
		idR,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação Raça_Feature -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoRacaFeature (
    idR INT,
    idF INT
)
BEGIN
	INSERT INTO Raca_Feature (
		idRaca,
		idFeature
    )
    VALUES (
		idR,
		idF
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação SubClasse_Feature --------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoSubClasseFeature (
	idSC INT,
    idC INT,
    idF INT
)
BEGIN
	INSERT INTO SubClasse_Feature (
		idSubClasse,
		idClasse,
		idFeature
    )
    VALUES (
		idSC,
		idC,
		idF
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação SubRaça_Atributo ---------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoSubRacaAtributo (
	idSR INT,
    idR INT,
    idA INT
)
BEGIN
	INSERT INTO SubRaca_Atributo (
		idSubRaca,
		idRaca,
		idAtributo
    )
    VALUES (
		idSR,
		idR,
		idA
    );
END //

-- ----------------------------------------------------------------------------------------------------
-- Registro de Relação SubRaça_Feature ----------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRelacaoSubRacaFeature (
	idSR INT,
    idR INT,
    idF INT
)
BEGIN
	INSERT INTO SubRaca_Feature (
		idSubRaca,
		idRaca,
		idFeature
    )
    VALUES (
		idSR,
		idR,
		idF
    );
END //

DELIMITER ;
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------