-- ----------------------------------------------------------------------------------------------------
DROP SCHEMA IF EXISTS dnd;
CREATE SCHEMA IF NOT EXISTS dnd;
USE dnd;
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemUsuario (
    idImagemUsuario INT NOT NULL,
    caminhoImagemUsuario VARCHAR(260) NOT NULL,
    descricaoImagemUsuario VARCHAR(60) NULL,
    dataCriacaoImagemUsuario DATE NOT NULL,
    imagemUsuarioAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemUsuario ADD CONSTRAINT PK_IMAGEMUSUARIO PRIMARY KEY(idImagemUsuario);
ALTER TABLE ImagemUsuario CHANGE COLUMN idImagemUsuario idImagemUsuario INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS TipoUsuario (
    idTipoUsuario INT NOT NULL,
    nomeTipoUsuario VARCHAR(20) NOT NULL UNIQUE,
    descricaoTipoUsuario VARCHAR(60) NULL,
    dataCriacaoTipoUsuario DATE NOT NULL,
    tipoUsuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE TipoUsuario ADD CONSTRAINT PK_TIPOUSUARIO PRIMARY KEY(idTipoUsuario);
ALTER TABLE TipoUsuario CHANGE COLUMN idTipoUsuario idTipoUsuario INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT NOT NULL,
    idImagemUsuario INT NULL,
    idTipoUsuario INT NOT NULL,
    nomeUsuario VARCHAR(60) NOT NULL UNIQUE,
    senhaUsuario CHAR(60) NOT NULL,
    emailUsuario VARCHAR(60) NOT NULL,
    dataAniversarioUsuario DATE NOT NULL,
    descricaoUsuario VARCHAR(60) NULL,
    quantPersonagensTotal INT NOT NULL DEFAULT 6,
    quantPersonagensCriados INT NOT NULL DEFAULT 0,
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
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemClasse (
    idImagemClasse INT NOT NULL,
    caminhoImagemClasse VARCHAR(260) NOT NULL,
    descricaoImagemClasse VARCHAR(60) NULL,
    dataCriacaoImagemClasse DATE NOT NULL,
    imagemClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemClasse ADD CONSTRAINT PK_IMAGEMCLASSE PRIMARY KEY(idImagemClasse);
ALTER TABLE ImagemClasse CHANGE COLUMN idImagemClasse idImagemClasse INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe (
    idClasse INT NOT NULL,
    idImagemClasse INT NOT NULL,
    
    dataCriacaoClasse DATE NOT NULL,
    classeAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Classe ADD CONSTRAINT PK_CLASSE PRIMARY KEY(idClasse);
ALTER TABLE Classe CHANGE COLUMN idClasse idClasse INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Classe ADD CONSTRAINT FK_CLASSE_IMAGEMCLASSE FOREIGN KEY(idImagemClasse) REFERENCES ImagemClasse(idImagemClasse);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemSubClasse (
    idImagemSubClasse INT NOT NULL,
    caminhoImagemSubClasse VARCHAR(260) NOT NULL,
    descricaoImagemSubClasse VARCHAR(60) NULL,
    dataCriacaoImagemSubClasse DATE NOT NULL,
    imagemSubClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemSubClasse ADD CONSTRAINT PK_IMAGEMSUBCLASSE PRIMARY KEY(idImagemSubClasse);
ALTER TABLE ImagemSubClasse CHANGE COLUMN idImagemSubClasse idImagemSubClasse INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubClasse (
    idSubClasse INT NOT NULL,
	idClasse INT NOT NULL,
    idImagemSubClasse INT NOT NULL,
    
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
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemRaca (
    idImagemRaca INT NOT NULL,
    caminhoImagemRaca VARCHAR(260) NOT NULL,
    descricaoImagemRaca VARCHAR(60) NULL,
    dataCriacaoImagemRaca DATE NOT NULL,
    imagemRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemRaca ADD CONSTRAINT PK_IMAGEMRACA PRIMARY KEY(idImagemRaca);
ALTER TABLE ImagemRaca CHANGE COLUMN idImagemRaca idImagemRaca INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Raca (
    idRaca INT NOT NULL,
    idImagemRaca INT NOT NULL,
    
    dataCriacaoRaca DATE NOT NULL,
    racaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Raca ADD CONSTRAINT PK_RACA PRIMARY KEY(idRaca);
ALTER TABLE Raca CHANGE COLUMN idRaca idRaca INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Raca ADD CONSTRAINT FK_RACA_IMAGEMRACA FOREIGN KEY(idImagemRaca) REFERENCES ImagemRaca(idImagemRaca);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemSubRaca (
    idImagemSubRaca INT NOT NULL,
    caminhoImagemSubRaca VARCHAR(260) NOT NULL,
    descricaoImagemSubRaca VARCHAR(60) NULL,
    dataCriacaoImagemSubRaca DATE NOT NULL,
    imagemSubRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemSubRaca ADD CONSTRAINT PK_IMAGEMSUBRACA PRIMARY KEY(idImagemSubRaca);
ALTER TABLE ImagemSubRaca CHANGE COLUMN idImagemSubRaca idImagemSubRaca INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubRaca (
    idSubRaca INT NOT NULL,
    idRaca INT NULL,
    idImagemSubRaca INT NOT NULL,
    
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
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemBackground (
    idImagemBackground INT NOT NULL,
    caminhoImagemBackground VARCHAR(260) NOT NULL,
    descricaoImagemBackground VARCHAR(60) NULL,
    dataCriacaoImagemBackground DATE NOT NULL,
    imagemBackgroundAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemBackground ADD CONSTRAINT PK_IMAGEMBACKGROUND PRIMARY KEY(idImagemBackground);
ALTER TABLE ImagemBackground CHANGE COLUMN idImagemBackground idImagemBackground INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background (
    idBackground INT NOT NULL,
    idImagemBackground INT NOT NULL,
    
    dataCriacaoBackground DATE NOT NULL,
    BackgroundAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Background ADD CONSTRAINT PK_BACKGROUND PRIMARY KEY(idBackground);
ALTER TABLE Background CHANGE COLUMN idBackground idBackground INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Background ADD CONSTRAINT FK_BACKGROUND_IMAGEMBACKGROUND FOREIGN KEY(idImagemBackground) REFERENCES ImagemBackground(idImagemBackground);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ImagemPersonagem (
    idImagemPersonagem INT NOT NULL,
    caminhoImagemPersonagem VARCHAR(260) NOT NULL,
    descricaoImagemPersonagem VARCHAR(60) NULL,
    dataCriacaoImagemPersonagem DATE NOT NULL,
    imagemPersonagemAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE ImagemPersonagem ADD CONSTRAINT PK_IMAGEMPERSONAGEM PRIMARY KEY(idImagemPersonagem);
ALTER TABLE ImagemPersonagem CHANGE COLUMN idImagemPersonagem idImagemPersonagem INT NOT NULL AUTO_INCREMENT;
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Personagem (
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
);
-- PK
ALTER TABLE Personagem ADD CONSTRAINT PK_PERSONAGEM PRIMARY KEY(idPersonagem, idUsuario);
ALTER TABLE Personagem CHANGE COLUMN idPersonagem idPersonagem INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_USUARIO FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_IMAGEMPERSONAGEM FOREIGN KEY(idImagemPersonagem) REFERENCES ImagemPersonagem(idImagemPersonagem);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_RACA FOREIGN KEY(idRaca) REFERENCES Raca(idRaca);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS HabilidadesPersonagem (
    idHabilidadesPersonagem INT NOT NULL,
    idPersonagem INT NOT NULL,
    idUsuario INT NOT NULL,
    valorSTRBase INT NOT NULL DEFAULT 8,
    proficienteSaveSTR TINYINT(1) NOT NULL DEFAULT 0,
    valorDEXBase INT NOT NULL DEFAULT 8,
    proficienteSaveDEX TINYINT(1) NOT NULL DEFAULT 0,
    valorCONBase INT NOT NULL DEFAULT 8,
    proficienteSaveCON TINYINT(1) NOT NULL DEFAULT 0,
    valorINTBase INT NOT NULL DEFAULT 8,
    proficienteSaveINT TINYINT(1) NOT NULL DEFAULT 0,
    valorWISBase INT NOT NULL DEFAULT 8,
    proficienteSaveWIS TINYINT(1) NOT NULL DEFAULT 0,
    valorCHABase INT NOT NULL DEFAULT 8,
    proficienteSaveCHA TINYINT(1) NOT NULL DEFAULT 0
);
-- PK
ALTER TABLE HabilidadesPersonagem ADD CONSTRAINT PK_HABILIDADESPERSONAGEM PRIMARY KEY(idHabilidadesPersonagem, idPersonagem, idUsuario);
ALTER TABLE HabilidadesPersonagem CHANGE COLUMN idHabilidadesPersonagem idHabilidadesPersonagem INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE HabilidadesPersonagem ADD CONSTRAINT FK_HABILIDADESPERSONAGEM_PERSONAGEM FOREIGN KEY(idPersonagem, idUsuario) REFERENCES Personagem(idPersonagem, idUsuario);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS ProficienciasSkillPersonagem (
    idProficienciasSkillPersonagem INT NOT NULL,
    idPersonagem INT NOT NULL,
    idUsuario INT NOT NULL,
    proficienteAtletismo TINYINT(1) NOT NULL DEFAULT 0,
    proficienteAcrobacia TINYINT(1) NOT NULL DEFAULT 0,
    proficienteFurtividade TINYINT(1) NOT NULL DEFAULT 0,
    proficientePrestidigitacao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteArcanismo TINYINT(1) NOT NULL DEFAULT 0,
    proficienteHistoria TINYINT(1) NOT NULL DEFAULT 0,
    proficienteInvestigacao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteNatureza TINYINT(1) NOT NULL DEFAULT 0,
    proficienteReligiao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteAdestrarAnimais TINYINT(1) NOT NULL DEFAULT 0,
    proficienteIntuicao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteMedicina TINYINT(1) NOT NULL DEFAULT 0,
    proficientePercepcao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteSobrevivencia TINYINT(1) NOT NULL DEFAULT 0,
    proficienteAtuacao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteEnganacao TINYINT(1) NOT NULL DEFAULT 0,
    proficienteIntimidacao TINYINT(1) NOT NULL DEFAULT 0,
    proficientePersuasao TINYINT(1) NOT NULL DEFAULT 0
);
-- PK
ALTER TABLE ProficienciasSkillPersonagem ADD CONSTRAINT PK_PROFICIENCIASSKILLPERSONAGEM PRIMARY KEY(idProficienciasSkillPersonagem, idPersonagem, idUsuario);
ALTER TABLE ProficienciasSkillPersonagem CHANGE COLUMN idProficienciasSkillPersonagem idProficienciasSkillPersonagem INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE ProficienciasSkillPersonagem ADD CONSTRAINT FK_PROFICIENCIASSKILLPERSONAGEM_PERSONAGEM FOREIGN KEY(idPersonagem, idUsuario) REFERENCES Personagem(idPersonagem, idUsuario);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------