-- ----------------------------------------------------------------------------------------------------
DROP SCHEMA IF EXISTS dnd;
CREATE SCHEMA IF NOT EXISTS dnd;
USE dnd;

-- ----------------------------------------------------------------------------------------------------
-- Atributo -------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Atributo (
    idAtributo INT NOT NULL,
    
    nomeAtributo ENUM(""),
    descricaoAtributo VARCHAR(400) NOT NULL,
    
    dataCriacaoAtributo DATE NOT NULL,
    atributoAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Atributo ADD CONSTRAINT PK_ATRIBUTO PRIMARY KEY(idAtributo);
ALTER TABLE Atributo CHANGE COLUMN idAtributo idAtributo INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Equipamento --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoEquipamento (
    idTipoEquipamento INT NOT NULL,
    
    nomeTipoEquipamento VARCHAR(50) NOT NULL,
    descricaoTipoEquipamento VARCHAR(200) NULL,
    
    dataCriacaoTipoEquipamento DATE NOT NULL,
    tipoEquipamentoAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE TipoEquipamento ADD CONSTRAINT PK_TIPOEQUIPAMENTO PRIMARY KEY(idTipoEquipamento);
ALTER TABLE TipoEquipamento CHANGE COLUMN idTipoEquipamento idTipoEquipamento INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Equipamento ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Equipamento (
    idEquipamento INT NOT NULL,
    
    idTipoEquipamento INT NOT NULL,
    nomeEquipamento VARCHAR(50) NOT NULL,
    descricaoEquipamento VARCHAR(400) NOT NULL,
    dadoDano INT NULL,
    multiplicadorDado INT NOT NULL DEFAULT 1,
    
    dataCriacaoEquipamento DATE NOT NULL,
    equipamentoAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Equipamento ADD CONSTRAINT PK_EQUIPAMENTO PRIMARY KEY(idEquipamento);
ALTER TABLE Equipamento CHANGE COLUMN idEquipamento idEquipamento INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Equipamento ADD CONSTRAINT FK_EQUIPAMENTO_TIPOEQUIPAMENTO FOREIGN KEY(idTipoEquipamento) REFERENCES TipoEquipamento(idTipoEquipamento);

-- ----------------------------------------------------------------------------------------------------
-- Feature --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature (
    idFeature INT NOT NULL,
    
    nomeFeature VARCHAR(50) NOT NULL,
    descricaoFeature VARCHAR(400) NOT NULL,
    
    dataCriacaoFeature DATE NOT NULL,
    featureAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Feature ADD CONSTRAINT PK_FEATURE PRIMARY KEY(idFeature);
ALTER TABLE Feature CHANGE COLUMN idFeature idFeature INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Linguagem --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Linguagem (
    idLinguagem INT NOT NULL,
    
    nomeLinguagem VARCHAR(40) NOT NULL,
    descricaoLinguagem VARCHAR(400) NOT NULL,
    
    dataCriacaoLinguagem DATE NOT NULL,
    linguagemAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Linguagem ADD CONSTRAINT PK_LINGUAGEM PRIMARY KEY(idLinguagem);
ALTER TABLE Linguagem CHANGE COLUMN idLinguagem idLinguagem INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Pericia -------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Pericia (
    idPericia INT NOT NULL,
    idAtributoPericia INT NOT NULL,
    
    nomePericia VARCHAR(30) NOT NULL,
    descricaoPericia VARCHAR(400) NOT NULL,
    
    dataCriacaoPericia DATE NOT NULL,
    periciaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Pericia ADD CONSTRAINT PK_PERICIA PRIMARY KEY(idPericia);
ALTER TABLE Pericia CHANGE COLUMN idPericia idPericia INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Pericia ADD CONSTRAINT FK_PERICIA_ATRIBUTO FOREIGN KEY(idAtributoModificador) REFERENCES Atributo(idAtributo);

-- ----------------------------------------------------------------------------------------------------
-- Imagem do Background -------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemBackground (
    idImagemBackground INT NOT NULL,
    
    caminhoImagemBackground VARCHAR(260) NOT NULL,
    descricaoImagemBackground VARCHAR(400) NULL,
    
    dataCriacaoImagemBackground DATE NOT NULL,
    imagemBackgroundAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemBackground ADD CONSTRAINT PK_IMAGEMBACKGROUND PRIMARY KEY(idImagemBackground);
ALTER TABLE ImagemBackground CHANGE COLUMN idImagemBackground idImagemBackground INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Background -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background (
    idBackground INT NOT NULL,
    idImagemBackground INT NOT NULL,
    
    nomeBackground VARCHAR(50) NOT NULL UNIQUE,
    descricaoBackground VARCHAR(400) NOT NULL,
    quantArmadurasIniciaisBackground INT NOT NULL,
    quantLinguagensIniciaisBackground INT NOT NULL,
    quantProficienciasFerramentasBackground INT NOT NULL,
    quantProficienciasPericiasBackground INT NOT NULL,
    quantFeaturesBackground INT NOT NULL,
    
    dataCriacaoBackground DATE NOT NULL,
    BackgroundAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Background ADD CONSTRAINT PK_BACKGROUND PRIMARY KEY(idBackground);
ALTER TABLE Background CHANGE COLUMN idBackground idBackground INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Background ADD CONSTRAINT FK_BACKGROUND_IMAGEMBACKGROUND FOREIGN KEY(idImagemBackground) REFERENCES ImagemBackground(idImagemBackground);

-- ----------------------------------------------------------------------------------------------------
-- Background_Equipamento -----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Background_Feature ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Background_Linguagem -------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Background_Pericia ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Background_ProficienciaFerramenta ------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Imagem de Classe -----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemClasse (
    idImagemClasse INT NOT NULL,
    
    caminhoImagemClasse VARCHAR(260) NOT NULL,
    descricaoImagemClasse VARCHAR(400) NULL,
    
    dataCriacaoImagemClasse DATE NOT NULL,
    imagemClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemClasse ADD CONSTRAINT PK_IMAGEMCLASSE PRIMARY KEY(idImagemClasse);
ALTER TABLE ImagemClasse CHANGE COLUMN idImagemClasse idImagemClasse INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Classe ---------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe (
    idClasse INT NOT NULL,
    
    idImagemClasse INT NOT NULL,
    nomeClasse VARCHAR(50) NOT NULL UNIQUE,
    descricaoClasse VARCHAR(400) NOT NULL,
    dadoClasse INT NOT NULL,
    classeTemSpells TINYINT(1) NOT NULL,
    quantProficienciasArmaduraClasse INT NOT NULL,
    quantProficienciasArmasClasse INT NOT NULL,
    quantProficienciasFerramentasClasse INT NOT NULL,
    quantProficienciasPericiasClasse INT NOT NULL,
    quantProficienciasSavesAtributosClasse INT NOT NULL,
    quantFeaturesClasse INT NOT NULL,
    
    dataCriacaoClasse DATE NOT NULL,
    classeAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Classe ADD CONSTRAINT PK_CLASSE PRIMARY KEY(idClasse);
ALTER TABLE Classe CHANGE COLUMN idClasse idClasse INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Classe ADD CONSTRAINT FK_CLASSE_IMAGEMCLASSE FOREIGN KEY(idImagemClasse) REFERENCES ImagemClasse(idImagemClasse);

-- ----------------------------------------------------------------------------------------------------
-- Imagem de SubClasse --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemSubClasse (
    idImagemSubClasse INT NOT NULL,
    
    caminhoImagemSubClasse VARCHAR(260) NOT NULL,
    descricaoImagemSubClasse VARCHAR(400) NULL,
    
    dataCriacaoImagemSubClasse DATE NOT NULL,
    imagemSubClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemSubClasse ADD CONSTRAINT PK_IMAGEMSUBCLASSE PRIMARY KEY(idImagemSubClasse);
ALTER TABLE ImagemSubClasse CHANGE COLUMN idImagemSubClasse idImagemSubClasse INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- SubClasse ------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubClasse (
    idSubClasse INT NOT NULL,
	idClasse INT NOT NULL,
    
    idImagemSubClasse INT NOT NULL,
    nomeSubClasse VARCHAR(50) NOT NULL UNIQUE,
    descricaoSubClasse VARCHAR(400) NOT NULL,
    quantFeaturesSubClasse INT NOT NULL,
    
    dataCriacaoSubClasse DATE NOT NULL,
    subClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE SubClasse ADD CONSTRAINT PK_SUBCLASSE PRIMARY KEY(idSubClasse);
ALTER TABLE SubClasse CHANGE COLUMN idSubClasse idSubClasse INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE SubClasse ADD CONSTRAINT FK_SUBCLASSE_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE SubClasse ADD CONSTRAINT FK_SUBCLASSE_IMAGEMSUBCLASSE FOREIGN KEY(idImagemSubClasse) REFERENCES ImagemSubClasse(idImagemSubClasse);

-- ----------------------------------------------------------------------------------------------------
-- Imagem de Raça -----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemRaca (
    idImagemRaca INT NOT NULL,
    
    caminhoImagemRaca VARCHAR(260) NOT NULL,
    descricaoImagemRaca VARCHAR(400) NULL,
    
    dataCriacaoImagemRaca DATE NOT NULL,
    imagemRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemRaca ADD CONSTRAINT PK_IMAGEMRACA PRIMARY KEY(idImagemRaca);
ALTER TABLE ImagemRaca CHANGE COLUMN idImagemRaca idImagemRaca INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Raça -----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Raca (
    idRaca INT NOT NULL,
    
    idImagemRaca INT NOT NULL,
    nomeRaca VARCHAR(50) NOT NULL UNIQUE,
    descricaoRaca VARCHAR(400) NOT NULL,
    valorBuffAtributoRaca INT NOT NULL,
    idadeMaxRaca INT NOT NULL,
    tamanhoRaca VARCHAR(20) NOT NULL,
    velocidadeRaca INT NOT NULL,
    quantFeaturesRaca INT NOT NULL,
    
    dataCriacaoRaca DATE NOT NULL,
    racaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Raca ADD CONSTRAINT PK_RACA PRIMARY KEY(idRaca);
ALTER TABLE Raca CHANGE COLUMN idRaca idRaca INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Raca ADD CONSTRAINT FK_RACA_IMAGEMRACA FOREIGN KEY(idImagemRaca) REFERENCES ImagemRaca(idImagemRaca);

-- ----------------------------------------------------------------------------------------------------
-- Imagem de SubRaça -----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemSubRaca (
    idImagemSubRaca INT NOT NULL,
    
    caminhoImagemSubRaca VARCHAR(260) NOT NULL,
    descricaoImagemSubRaca VARCHAR(400) NULL,
    
    dataCriacaoImagemSubRaca DATE NOT NULL,
    imagemSubRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemSubRaca ADD CONSTRAINT PK_IMAGEMSUBRACA PRIMARY KEY(idImagemSubRaca);
ALTER TABLE ImagemSubRaca CHANGE COLUMN idImagemSubRaca idImagemSubRaca INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- SubRaça -----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubRaca (
    idSubRaca INT NOT NULL,
    idRaca INT NULL,
    
    idImagemSubRaca INT NOT NULL,
    nomeSubRaca VARCHAR(50) NOT NULL UNIQUE,
    descricaoSubRaca VARCHAR(400) NOT NULL,
    valorBuffAtributoSubRaca INT NOT NULL,
    quantFeaturesSubRaca INT NOT NULL,
    
    dataCriacaoSubRaca DATE NOT NULL,
    subRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE SubRaca ADD CONSTRAINT PK_SUBRACA PRIMARY KEY(idSubRaca, idRaca);
ALTER TABLE SubRaca CHANGE COLUMN idSubRaca idSubRaca INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE SubRaca ADD CONSTRAINT FK_SUBRACA_RACA FOREIGN KEY(idRaca) REFERENCES Raca(idRaca);
ALTER TABLE SubRaca ADD CONSTRAINT FK_SUBRACA_IMAGEMSUBRACA FOREIGN KEY(idImagemSubRaca) REFERENCES ImagemSubRaca(idImagemSubRaca);

-- ----------------------------------------------------------------------------------------------------
-- Imagem de Usuario --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemUsuario (
    idImagemUsuario INT NOT NULL,
    
    caminhoImagemUsuario VARCHAR(260) NOT NULL,
    descricaoImagemUsuario VARCHAR(400) NULL,
    
    dataCriacaoImagemUsuario DATE NOT NULL,
    imagemUsuarioAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemUsuario ADD CONSTRAINT PK_IMAGEMUSUARIO PRIMARY KEY(idImagemUsuario);
ALTER TABLE ImagemUsuario CHANGE COLUMN idImagemUsuario idImagemUsuario INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Usuario --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoUsuario (
    idTipoUsuario INT NOT NULL,
    
    nomeTipoUsuario VARCHAR(50) NOT NULL UNIQUE,
    descricaoTipoUsuario VARCHAR(400) NULL,
    
    dataCriacaoTipoUsuario DATE NOT NULL,
    tipoUsuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE TipoUsuario ADD CONSTRAINT PK_TIPOUSUARIO PRIMARY KEY(idTipoUsuario);
ALTER TABLE TipoUsuario CHANGE COLUMN idTipoUsuario idTipoUsuario INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Usuario --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT NOT NULL,
    
    idImagemUsuario INT NULL,
    idTipoUsuario INT NOT NULL,
    
    nomeUsuario VARCHAR(50) NOT NULL UNIQUE,
    senhaUsuario CHAR(60) NOT NULL,
    emailUsuario VARCHAR(70) NOT NULL,
    dataAniversarioUsuario DATE NOT NULL,
    descricaoUsuario VARCHAR(400) NULL,
    quantPersonagensTotalUsuario INT NOT NULL DEFAULT 6,
    quantPersonagensCriadosUsuario INT NOT NULL DEFAULT 0,
    
    dataCriacaoUsuario DATE NOT NULL,
    usuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Usuario ADD CONSTRAINT PK_USUARIO PRIMARY KEY(idUsuario);
ALTER TABLE Usuario CHANGE COLUMN idUsuario idUsuario INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Usuario ADD CONSTRAINT FK_USUARIO_IMAGEMUSUARIO FOREIGN KEY(idImagemUsuario) REFERENCES ImagemUsuario(idImagemUsuario);
ALTER TABLE Usuario ADD CONSTRAINT FK_USUARIO_TIPOUSUARIO FOREIGN KEY(idTipoUsuario) REFERENCES TipoUsuario(idTipoUsuario);

-- ----------------------------------------------------------------------------------------------------
-- Imagem do Personagem -------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemPersonagem (
    idImagemPersonagem INT NOT NULL,
    
    caminhoImagemPersonagem VARCHAR(260) NOT NULL,
    descricaoImagemPersonagem VARCHAR(400) NULL,
    
    dataCriacaoImagemPersonagem DATE NOT NULL,
    imagemPersonagemAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemPersonagem ADD CONSTRAINT PK_IMAGEMPERSONAGEM PRIMARY KEY(idImagemPersonagem);
ALTER TABLE ImagemPersonagem CHANGE COLUMN idImagemPersonagem idImagemPersonagem INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Personagem -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Personagem (
    idPersonagem INT NOT NULL,
    idUsuario INT NOT NULL,
    
    idImagemPersonagem INT NOT NULL,
    idClassePersonagem INT NOT NULL,
    idSubclassePersonagem INT NOT NULL,
    idRacaPersonagem INT NOT NULL,
    idSubracaPersonagem INT NOT NULL,
    idBackgroundPersonagem INT NOT NULL,
    
    nomePersonagem VARCHAR(50) NULL,
    alinhamentoPersonagem VARCHAR(30) NULL,
    idadePersonagem INT NULL,
    alturaPersonagem DOUBLE(4, 2) NULL,
    pesoPersonagem DOUBLE(5, 2) NULL,
    olhosPersonagem VARCHAR(20) NULL,
    pelePersonagem VARCHAR(30) NULL,
    cabeloPersonagem VARCHAR(30) NULL,
    aparenciaPersonagem VARCHAR(400) NULL,
    historiaPersonagem VARCHAR(2000) NULL,
    personalidadePersonagem VARCHAR(1200) NULL,
    ideaisPersonagem VARCHAR(50) NULL,
    ligacoesPersonagem VARCHAR(50) NULL,
    defeitosPersonagem VARCHAR(50) NULL,
    aliadosPersonagem VARCHAR(50) NULL,
    outrasInformacoesPersonagem VARCHAR(2000) NULL,
    
    dataCriacaoPersonagem DATE NOT NULL,
    personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Personagem ADD CONSTRAINT PK_PERSONAGEM PRIMARY KEY(idPersonagem, idUsuario);
ALTER TABLE Personagem CHANGE COLUMN idPersonagem idPersonagem INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_USUARIO FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_IMAGEMPERSONAGEM FOREIGN KEY(idImagemPersonagem) REFERENCES ImagemPersonagem(idImagemPersonagem);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_SUBCLASSE_CLASSE FOREIGN KEY(idClasse) REFERENCES SubClasse(idClasse);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_SUBCLASSE FOREIGN KEY(idSubclasse) REFERENCES SubClasse(idSubclasse);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_SUBRACA_RACA FOREIGN KEY(idRaca) REFERENCES SubRaca(idRaca);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_SUBRACA FOREIGN KEY(idSubraca) REFERENCES SubRaca(idSubraca);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_BACKGROUND FOREIGN KEY(idBackground) REFERENCES Background(idBackground);

-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------