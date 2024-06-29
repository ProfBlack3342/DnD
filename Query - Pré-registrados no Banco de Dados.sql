-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
USE dnd;

-- ----------------------------------------------------------------------------------------------------
-- Armas ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
	"nome",
	"descricao",
	dado,
	multiplicadorDado,
	CURDATE(),
	true
);

-- ----------------------------------------------------------------------------------------------------
-- Armaduras ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
	"nome",
	"descricao",
	dado,
	multiplicadorDado,
	CURDATE(),
	true
);

-- ----------------------------------------------------------------------------------------------------
-- Atributos ------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Atributo (
	idAtributo,
    nomeAtributo,
    descricaoAtributo,
    dataCriacaoAtributo,
    atributoAtivo
)
VALUES (
	null,
    "STR",
    "Força",
	CURDATE(),
	true
), (
	null,
    "DEX",
    "Destreza",
	CURDATE(),
	true
), (
	null,
    "CON",
    "Constituição",
	CURDATE(),
	true
), (
	null,
    "INT",
    "Inteligência",
	CURDATE(),
	true
), (
	null,
    "WIS",
    "Sabedoria",
	CURDATE(),
	true
), (
	null,
    "CHA",
    "Carisma",
	CURDATE(),
	true
);

-- ----------------------------------------------------------------------------------------------------
-- Ferramentas ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Ferramenta (
	
)
VALUES (
	
);

-- ----------------------------------------------------------------------------------------------------
-- Linguagens ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Linguagem (
	
)
VALUES (
	
);

-- ----------------------------------------------------------------------------------------------------
-- Pericias ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Pericia (
	
)
VALUES (
	
);

-- ----------------------------------------------------------------------------------------------------
-- Spells ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Spell (
	
)
VALUES (
	
);

-- ----------------------------------------------------------------------------------------------------
-- Features ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Feature (
	
)
VALUES (
	
);

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Classe ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemClasse (
	idImagemClasse,
	caminhoImagemClasse,
	descricaoImagemClasse,
	dataCriacaoImagemClasse,
	imagemClasseAtiva
)
VALUES (
	null,
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Classe ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
    "Feiticeiro",
    "Feiticeiros carregam uma herança mágica, dada a eles por virtude de uma linhagem exótica, influência sobrenatural ou exposição à uma força cósmica. É impossível estudar feitiçaria assim como é impossível aprender a viver uma vida lendária: Ninguém escolhe feitiçaria, o poder escolhe o feiticeiro.",
    6,
    1,
    0,
    5,
    0,
    2,
    2,
    6,
    CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da SubClasse -------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemSubClasse (
	idImagemSubClasse,
	caminhoImagemSubClasse,
	descricaoImagemSubClasse,
	dataCriacaoImagemSubClasse,
	imagemSubClasseAtiva
)
VALUES (
	null,
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- SubClasse ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
    1,
    1,
    "Alma Divina",
    "Sua magia inata vem da conexão com uma divindade que lhe escolheu como seu agente.",
    5,
    CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Raça ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemRaca (
	idImagemRaca,
	caminhoImagemRaca,
	descricaoImagemRaca,
	dataCriacaoImagemRaca,
	imagemRacaAtiva
)
VALUES (
	null,
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Raca ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
    quantIdiomasRaca,
    dataCriacaoRaca,
    racaAtiva
)
VALUES (
	null,
    1,
    "Aasimar",
    "Descendentes de criaturas celestiais, Aasimares parecem humanos gloriosos e heroicos. Aasimares costumam tentar disfarçar sua linhagem para enfrentar o mal sem chamar atenção.",
    2,
    120,
    "Médio",
    9,
    4,
    2,
    CURDATE(),
	true
);

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da SubRaça ---------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemSubRaca (
	idImagemSubRaca,
	caminhoImagemSubRaca,
	descricaoImagemSubRaca,
	dataCriacaoImagemSubRaca,
	imagemSubRacaAtiva
)
VALUES (
	null,
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- SubRaca ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
    1,
    1,
    "Protetor",
    "Protector aasimar are charged by the powers of good to guard the weak, to strike at evil wherever it arises, and to stand vigilant against the darkness. From a young age, a protector aasimar receives advice and directives that urge to stand against evil.",
    1,
    1,
    CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão do Background ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemBackground (
	idImagemBackground,
	caminhoImagemBackground,
	descricaoImagemBackground,
	dataCriacaoImagemBackground,
	imagemBackgroundAtiva
)
VALUES (
	null,
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Background ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
    "Acólito",
    "Você passou sua vida em serviço de um templo. Você age como um intermediário entre o reino do sagrado e do mundo mortal, fazendo ritos sagrados e oferecendo sacrifícios para guiar os fieis à presença do divino. Acólito e clérigo não são a mesma coisa: Um milagreiro andarilho pode ser respeitado como canalizador do divino, mas não ter nenhuma autoridade na religião.",
    15,
    5,
    2,
    0,
    2,
    1,
    CURDATE(),
	true
);
    

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão do Usuario ---------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemUsuario (
	idImagemUsuario, 
	caminhoImagemUsuario, 
	descricaoImagemUsuario, 
	dataCriacaoImagemUsuario, 
	imagemUsuarioAtiva
)
VALUES (
	null, 
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);

-- ----------------------------------------------------------------------------------------------------
-- Tipos de Usuario ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO TipoUsuario (
	idTipoUsuario, 
	nomeTipoUsuario, 
	descricaoTipoUsuario, 
	dataCriacaoTipoUsuario, 
	tipoUsuarioAtivo
)
VALUES (
	null, 
	"Admin", 
	"Gerenciamento e manutenção",
	CURDATE(), 
	true
), (
	null, 
	"Jogador", 
	"Fichas, entrar em salas e campanhas.",
	CURDATE(), 
	true
), (
	null, 
	"Game Master", 
	"Salas e campanhas",
	CURDATE(), 
	true
);
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão do Personagem ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemPersonagem (
	idImagemPersonagem,
	caminhoImagemPersonagem,
	descricaoImagemPersonagem,
	dataCriacaoImagemPersonagem,
	imagemPersonagemAtiva
)
VALUES (
	null,
	"/img/imagemPadrao.png",
	"Imagem Padrão",
	CURDATE(),
	true
);