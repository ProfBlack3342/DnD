-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
DROP SCHEMA IF EXISTS dnd;
CREATE SCHEMA IF NOT EXISTS dnd;
USE dnd;

-- ----------------------------------------------------------------------------------------------------
-- Arma -----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Arma (
    idArma INT NOT NULL,
    
    nomeArma VARCHAR(50) NOT NULL,
    descricaoArma VARCHAR(400) NOT NULL,
    dadoArma INT NULL,
    multiplicadorDadoArma INT NOT NULL DEFAULT 1,
    
    dataCriacaoArma DATE NOT NULL,
    ArmaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Arma ADD CONSTRAINT PK_ARMA PRIMARY KEY(idArma);
ALTER TABLE Arma CHANGE COLUMN idArma idArma INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Armadura -------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Armadura (
    idArmadura INT NOT NULL,
    
    nomeArmadura VARCHAR(50) NOT NULL,
    descricaoArmadura VARCHAR(400) NOT NULL,
    dadoArmadura INT NULL,
    multiplicadorDadoArmadura INT NOT NULL DEFAULT 1,
    
    dataCriacaoArmadura DATE NOT NULL,
    ArmaduraAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Armadura ADD CONSTRAINT PK_ARMADURA PRIMARY KEY(idArmadura);
ALTER TABLE Armadura CHANGE COLUMN idArmadura idArmadura INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Atributo -------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Atributo (
    idAtributo INT NOT NULL,
    
    nomeAtributo VARCHAR(50) NOT NULL,
    descricaoAtributo VARCHAR(400) NOT NULL,
    
    dataCriacaoAtributo DATE NOT NULL,
    atributoAtivo TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Atributo ADD CONSTRAINT PK_ATRIBUTO PRIMARY KEY(idAtributo);
ALTER TABLE Atributo CHANGE COLUMN idAtributo idAtributo INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Feature --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature (
    idFeature INT NOT NULL,
    
    nomeFeature VARCHAR(50) NOT NULL,
    descricaoFeature VARCHAR(400) NOT NULL,
    featureConcedeProficienciaArma TINYINT(1) NOT NULL,
    featureConcedeProficienciaArmadura TINYINT(1) NOT NULL,
    featureConcedeProficienciaFerramenta TINYINT(1) NOT NULL,
    featureConcedeProficienciaLinguagem TINYINT(1) NOT NULL,
    featureConcedeProficienciaPericia TINYINT(1) NOT NULL,
    featureConcedeProficienciaSaveAtributo TINYINT(1) NOT NULL,
    featureConcedeSpell TINYINT(1) NOT NULL,
    
    dataCriacaoFeature DATE NOT NULL,
    featureAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Feature ADD CONSTRAINT PK_FEATURE PRIMARY KEY(idFeature);
ALTER TABLE Feature CHANGE COLUMN idFeature idFeature INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Ferramenta -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Ferramenta (
    idFerramenta INT NOT NULL,
    
    nomeFerramenta VARCHAR(50) NOT NULL,
    descricaoFerramenta VARCHAR(400) NOT NULL,
    
    dataCriacaoFerramenta DATE NOT NULL,
    ferramentaAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Ferramenta ADD CONSTRAINT PK_FERRAMENTA PRIMARY KEY(idFerramenta);
ALTER TABLE Ferramenta CHANGE COLUMN idFerramenta idFerramenta INT NOT NULL AUTO_INCREMENT;

-- ----------------------------------------------------------------------------------------------------
-- Linguagem ------------------------------------------------------------------------------------------
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
-- Pericia --------------------------------------------------------------------------------------------
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
ALTER TABLE Pericia ADD CONSTRAINT PK_PERICIA PRIMARY KEY(idPericia, idAtributoPericia);
ALTER TABLE Pericia CHANGE COLUMN idPericia idPericia INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE Pericia ADD CONSTRAINT FK_PERICIA_ATRIBUTO FOREIGN KEY(idAtributoPericia) REFERENCES Atributo(idAtributo);

-- ----------------------------------------------------------------------------------------------------
-- Spell ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Spell (
    idSpell INT NOT NULL,
    
    nomeSpell VARCHAR(30) NOT NULL,
    descricaoSpell VARCHAR(400) NOT NULL,
    dadoSpell INT NULL,
    multiplicadorDadoSpell INT NOT NULL DEFAULT 1,
    spellTemComponenteVerbal TINYINT(1) NOT NULL,
    spellTemcomponenteSomatico TINYINT(1) NOT NULL,
    spellTemcomponenteMaterial TINYINT(1) NOT NULL,
    
    dataCriacaoSpell DATE NOT NULL,
    spellAtiva TINYINT(1) NOT NULL DEFAULT 1
);
-- PK
ALTER TABLE Spell ADD CONSTRAINT PK_SPELL PRIMARY KEY(idSpell);
ALTER TABLE Spell CHANGE COLUMN idSpell idSpell INT NOT NULL AUTO_INCREMENT;

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
ALTER TABLE SubClasse ADD CONSTRAINT PK_SUBCLASSE PRIMARY KEY(idSubClasse, idClasse);
ALTER TABLE SubClasse CHANGE COLUMN idSubClasse idSubClasse INT NOT NULL AUTO_INCREMENT;
-- FK
ALTER TABLE SubClasse ADD CONSTRAINT FK_SUBCLASSE_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE SubClasse ADD CONSTRAINT FK_SUBCLASSE_IMAGEMSUBCLASSE FOREIGN KEY(idImagemSubClasse) REFERENCES ImagemSubClasse(idImagemSubClasse);

-- ----------------------------------------------------------------------------------------------------
-- Imagem de Raça -------------------------------------------------------------------------------------
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
-- Imagem de SubRaça ----------------------------------------------------------------------------------
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
-- SubRaça --------------------------------------------------------------------------------------------
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
-- Imagem de Background -------------------------------------------------------------------------------
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
    dinheiroInicialBackground INT NULL,
    quantEquipamentosIniciaisBackground INT NOT NULL,
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
-- Imagem de Usuario ----------------------------------------------------------------------------------
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
    idSubclassePersonagem INT NOT NULL,
    idClassePersonagem INT NOT NULL,
    idSubracaPersonagem INT NOT NULL,
    idRacaPersonagem INT NOT NULL,
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
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_SUBCLASSE FOREIGN KEY(idSubclassePersonagem, idClassePersonagem) REFERENCES SubClasse(idSubClasse, idClasse);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_SUBRACA_RACA FOREIGN KEY(idSubracaPersonagem, idRacaPersonagem) REFERENCES SubRaca(idSubRaca, idRaca);
ALTER TABLE Personagem ADD CONSTRAINT FK_PERSONAGEM_BACKGROUND FOREIGN KEY(idBackgroundPersonagem) REFERENCES Background(idBackground);

-- ----------------------------------------------------------------------------------------------------
-- Background_Armadura --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background_Armadura (
	idBackground INT NOT NULL,
    idArmadura INT NOT NULL
);
-- PK
ALTER TABLE Background_Armadura ADD CONSTRAINT PK_BACKGROUND_ARMADURA PRIMARY KEY(idBackground, idArmadura);
-- FK
ALTER TABLE Background_Armadura ADD CONSTRAINT FK_BACKGROUND_ARMADURA_BACKGROUND FOREIGN KEY(idBackground) REFERENCES Background(idBackground);
ALTER TABLE Background_Armadura ADD CONSTRAINT FK_BACKGROUND_ARMADURA_ARMADURA FOREIGN KEY(idArmadura) REFERENCES Armadura(idArmadura);

-- ----------------------------------------------------------------------------------------------------
-- Background_Feature ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background_Feature (
	idBackground INT NOT NULL,
    idFeature INT NOT NULL
);
-- PK
ALTER TABLE Background_Feature ADD CONSTRAINT PK_BACKGROUND_FEATURE PRIMARY KEY(idBackground, idFeature);
-- FK
ALTER TABLE Background_Feature ADD CONSTRAINT FK_BACKGROUND_FEATURE_BACKGROUND FOREIGN KEY(idBackground) REFERENCES Background(idBackground);
ALTER TABLE Background_Feature ADD CONSTRAINT FK_BACKGROUND_FEATURE_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);

-- ----------------------------------------------------------------------------------------------------
-- Background_Ferramenta ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background_Ferramenta (
	idBackground INT NOT NULL,
    idFerramenta INT NOT NULL
);
-- PK
ALTER TABLE Background_Ferramenta ADD CONSTRAINT PK_BACKGROUND_FERRAMENTA PRIMARY KEY(idBackground, idFerramenta);
-- FK
ALTER TABLE Background_Ferramenta ADD CONSTRAINT FK_BACKGROUND_FERRAMENTA_BACKGROUND FOREIGN KEY(idBackground) REFERENCES Background(idBackground);
ALTER TABLE Background_Ferramenta ADD CONSTRAINT FK_BACKGROUND_FERRAMENTA_FERRAMENTA FOREIGN KEY(idFerramenta) REFERENCES Ferramenta(idFerramenta);

-- ----------------------------------------------------------------------------------------------------
-- Background_Linguagem -------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background_Linguagem (
	idBackground INT NOT NULL,
    idLinguagem INT NOT NULL
);
-- PK
ALTER TABLE Background_Linguagem ADD CONSTRAINT PK_BACKGROUND_LINGUAGEM PRIMARY KEY(idBackground, idLinguagem);
-- FK
ALTER TABLE Background_Linguagem ADD CONSTRAINT FK_BACKGROUND_LINGUAGEM_BACKGROUND FOREIGN KEY(idBackground) REFERENCES Background(idBackground);
ALTER TABLE Background_Linguagem ADD CONSTRAINT FK_BACKGROUND_LINGUAGEM_LINGUAGEM FOREIGN KEY(idLinguagem) REFERENCES Linguagem(idLinguagem);

-- ----------------------------------------------------------------------------------------------------
-- Background_Pericia ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Background_Pericia (
	idBackground INT NOT NULL,
    idPericia INT NOT NULL
);
-- PK
ALTER TABLE Background_Pericia ADD CONSTRAINT PK_BACKGROUND_PERICIA PRIMARY KEY(idBackground, idPericia);
-- FK
ALTER TABLE Background_Pericia ADD CONSTRAINT FK_BACKGROUND_PERICIA_BACKGROUND FOREIGN KEY(idBackground) REFERENCES Background(idBackground);
ALTER TABLE Background_Pericia ADD CONSTRAINT FK_BACKGROUND_PERICIA_PERICIA FOREIGN KEY(idPericia) REFERENCES Pericia(idPericia);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Arma ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Arma (
	idClasse INT NOT NULL,
    idArma INT NOT NULL
);
-- PK
ALTER TABLE Classe_Arma ADD CONSTRAINT PK_CLASSE_ARMA PRIMARY KEY(idClasse, idArma);
-- FK
ALTER TABLE Classe_Arma ADD CONSTRAINT FK_CLASSE_ARMA_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Arma ADD CONSTRAINT FK_CLASSE_ARMA_ARMA FOREIGN KEY(idArma) REFERENCES Arma(idArma);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Armadura ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Armadura (
	idClasse INT NOT NULL,
    idArmadura INT NOT NULL
);
-- PK
ALTER TABLE Classe_Armadura ADD CONSTRAINT PK_CLASSE_ARMADURA PRIMARY KEY(idClasse, idArmadura);
-- FK
ALTER TABLE Classe_Armadura ADD CONSTRAINT FK_CLASSE_ARMADURA_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Armadura ADD CONSTRAINT FK_CLASSE_ARMADURA_ARMADURA FOREIGN KEY(idArmadura) REFERENCES Armadura(idArmadura);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Atributo ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Atributo (
	idClasse INT NOT NULL,
    idAtributo INT NOT NULL
);
-- PK
ALTER TABLE Classe_Atributo ADD CONSTRAINT PK_CLASSE_ATRIBUTO PRIMARY KEY(idClasse, idAtributo);
-- FK
ALTER TABLE Classe_Atributo ADD CONSTRAINT FK_CLASSE_ATRIBUTO_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Atributo ADD CONSTRAINT FK_CLASSE_ATRIBUTO_ATRIBUTO FOREIGN KEY(idAtributo) REFERENCES Atributo(idAtributo);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Feature -------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Feature (
	idClasse INT NOT NULL,
    idFeature INT NOT NULL
);
-- PK
ALTER TABLE Classe_Feature ADD CONSTRAINT PK_CLASSE_FEATURE PRIMARY KEY(idClasse, idFeature);
-- FK
ALTER TABLE Classe_Feature ADD CONSTRAINT FK_CLASSE_FEATURE_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Feature ADD CONSTRAINT FK_CLASSE_FEATURE_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Ferramenta ----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Ferramenta (
	idClasse INT NOT NULL,
    idFerramenta INT NOT NULL
);
-- PK
ALTER TABLE Classe_Ferramenta ADD CONSTRAINT PK_CLASSE_FERRAMENTA PRIMARY KEY(idClasse, idFerramenta);
-- FK
ALTER TABLE Classe_Ferramenta ADD CONSTRAINT FK_CLASSE_FERRAMENTA_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Ferramenta ADD CONSTRAINT FK_CLASSE_FERRAMENTA_FERRAMENTA FOREIGN KEY(idFerramenta) REFERENCES Ferramenta(idFerramenta);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Pericia -------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Pericia (
	idClasse INT NOT NULL,
    idPericia INT NOT NULL
);
-- PK
ALTER TABLE Classe_Pericia ADD CONSTRAINT PK_CLASSE_PERICIA PRIMARY KEY(idClasse, idPericia);
-- FK
ALTER TABLE Classe_Pericia ADD CONSTRAINT FK_CLASSE_PERICIA_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Pericia ADD CONSTRAINT FK_CLASSE_PERICIA_PERICIA FOREIGN KEY(idPericia) REFERENCES Pericia(idPericia);

-- ----------------------------------------------------------------------------------------------------
-- Classe_Spell ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Classe_Spell (
	idClasse INT NOT NULL,
    idSpell INT NOT NULL
);
-- PK
ALTER TABLE Classe_Spell ADD CONSTRAINT PK_CLASSE_SPELL PRIMARY KEY(idClasse, idSpell);
-- FK
ALTER TABLE Classe_Spell ADD CONSTRAINT FK_CLASSE_SPELL_CLASSE FOREIGN KEY(idClasse) REFERENCES Classe(idClasse);
ALTER TABLE Classe_Spell ADD CONSTRAINT FK_CLASSE_SPELL_SPELL FOREIGN KEY(idSpell) REFERENCES Spell(idSpell);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Arma ---------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Arma (
	idFeature INT NOT NULL,
    idArma INT NOT NULL
);
-- PK
ALTER TABLE Feature_Arma ADD CONSTRAINT PK_FEATURE_ARMA PRIMARY KEY(idFeature, idArma);
-- FK
ALTER TABLE Feature_Arma ADD CONSTRAINT FK_FEATURE_ARMA_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Arma ADD CONSTRAINT FK_FEATURE_ARMA_ARMA FOREIGN KEY(idArma) REFERENCES Arma(idArma);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Armadura -----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Armadura (
	idFeature INT NOT NULL,
    idArmadura INT NOT NULL
);
-- PK
ALTER TABLE Feature_Armadura ADD CONSTRAINT PK_FEATURE_ARMADURA PRIMARY KEY(idFeature, idArmadura);
-- FK
ALTER TABLE Feature_Armadura ADD CONSTRAINT FK_FEATURE_ARMADURA_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Armadura ADD CONSTRAINT FK_FEATURE_ARMADURA_ARMADURA FOREIGN KEY(idArmadura) REFERENCES Armadura(idArmadura);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Atributo -----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Atributo (
	idFeature INT NOT NULL,
    idAtributo INT NOT NULL
);
-- PK
ALTER TABLE Feature_Atributo ADD CONSTRAINT PK_FEATURE_ATRIBUTO PRIMARY KEY(idFeature, idAtributo);
-- FK
ALTER TABLE Feature_Atributo ADD CONSTRAINT FK_FEATURE_ATRIBUTO_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Atributo ADD CONSTRAINT FK_FEATURE_ATRIBUTO_ATRIBUTO FOREIGN KEY(idAtributo) REFERENCES Atributo(idAtributo);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Ferramenta ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Ferramenta (
	idFeature INT NOT NULL,
    idFerramenta INT NOT NULL
);
-- PK
ALTER TABLE Feature_Ferramenta ADD CONSTRAINT PK_FEATURE_FERRAMENTA PRIMARY KEY(idFeature, idFerramenta);
-- FK
ALTER TABLE Feature_Ferramenta ADD CONSTRAINT FK_FEATURE_FERRAMENTA_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Ferramenta ADD CONSTRAINT FK_FEATURE_FERRAMENTA_FERRAMENTA FOREIGN KEY(idFerramenta) REFERENCES Ferramenta(idFerramenta);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Linguagem ----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Linguagem (
	idFeature INT NOT NULL,
    idLinguagem INT NOT NULL
);
-- PK
ALTER TABLE Feature_Linguagem ADD CONSTRAINT PK_FEATURE_LINGUAGEM PRIMARY KEY(idFeature, idLinguagem);
-- FK
ALTER TABLE Feature_Linguagem ADD CONSTRAINT FK_FEATURE_LINGUAGEM_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Linguagem ADD CONSTRAINT FK_FEATURE_LINGUAGEM_LINGUAGEM FOREIGN KEY(idLinguagem) REFERENCES Linguagem(idLinguagem);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Pericia ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Pericia (
	idFeature INT NOT NULL,
    idPericia INT NOT NULL
);
-- PK
ALTER TABLE Feature_Pericia ADD CONSTRAINT PK_FEATURE_PERICIA PRIMARY KEY(idFeature, idPericia);
-- FK
ALTER TABLE Feature_Pericia ADD CONSTRAINT FK_FEATURE_PERICIA_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Pericia ADD CONSTRAINT FK_FEATURE_PERICIA_PERICIA FOREIGN KEY(idPericia) REFERENCES Pericia(idPericia);

-- ----------------------------------------------------------------------------------------------------
-- Feature_Spell --------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Feature_Spell (
	idFeature INT NOT NULL,
    idSpell INT NOT NULL
);
-- PK
ALTER TABLE Feature_Spell ADD CONSTRAINT PK_FEATURE_SPELL PRIMARY KEY(idFeature, idSpell);
-- FK
ALTER TABLE Feature_Spell ADD CONSTRAINT FK_FEATURE_SPELL_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);
ALTER TABLE Feature_Spell ADD CONSTRAINT FK_FEATURE_SPELL_SPELL FOREIGN KEY(idSpell) REFERENCES Spell(idSpell);

-- ----------------------------------------------------------------------------------------------------
-- Raça_Atributo --------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Raca_Atributo (
	idRaca INT NOT NULL,
    idAtributo INT NOT NULL
);
-- PK
ALTER TABLE Raca_Atributo ADD CONSTRAINT PK_RACA_ATRIBUTO PRIMARY KEY(idRaca, idAtributo);
-- FK
ALTER TABLE Raca_Atributo ADD CONSTRAINT FK_RACA_ATRIBUTO_RACA FOREIGN KEY(idRaca) REFERENCES Raca(idRaca);
ALTER TABLE Raca_Atributo ADD CONSTRAINT FK_RACA_ATRIBUTO_ATRIBUTO FOREIGN KEY(idAtributo) REFERENCES Atributo(idAtributo);

-- ----------------------------------------------------------------------------------------------------
-- Raça_Feature ---------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS Raca_Feature (
	idRaca INT NOT NULL,
    idFeature INT NOT NULL
);
-- PK
ALTER TABLE Raca_Feature ADD CONSTRAINT PK_RACA_FEATURE PRIMARY KEY(idRaca, idFeature);
-- FK
ALTER TABLE Raca_Feature ADD CONSTRAINT FK_RACA_FEATURE_RACA FOREIGN KEY(idRaca) REFERENCES Raca(idRaca);
ALTER TABLE Raca_Feature ADD CONSTRAINT FK_RACA_FEATURE_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);

-- ----------------------------------------------------------------------------------------------------
-- SubClasse_Feature ----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubClasse_Feature (
	idSubClasse INT NOT NULL,
	idClasse INT NOT NULL,
    idFeature INT NOT NULL
);
-- PK
ALTER TABLE SubClasse_Feature ADD CONSTRAINT PK_SUBCLASSE_FEATURE PRIMARY KEY(idSubClasse, idClasse, idFeature);
-- FK
ALTER TABLE SubClasse_Feature ADD CONSTRAINT FK_SUBCLASSE_FEATURE_SUBCLASSE FOREIGN KEY(idSubClasse, idClasse) REFERENCES SubClasse(idSubClasse, idClasse);
ALTER TABLE SubClasse_Feature ADD CONSTRAINT FK_SUBCLASSE_FEATURE_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);

-- ----------------------------------------------------------------------------------------------------
-- SubRaça_Atributo --------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubRaca_Atributo (
	idSubRaca INT NOT NULL,
	idRaca INT NOT NULL,
    idAtributo INT NOT NULL
);
-- PK
ALTER TABLE SubRaca_Atributo ADD CONSTRAINT PK_SUBRACA_ATRIBUTO PRIMARY KEY(idSubRaca, idRaca, idAtributo);
-- FK
ALTER TABLE SubRaca_Atributo ADD CONSTRAINT FK_SUBRACA_ATRIBUTO_RACA FOREIGN KEY(idSubRaca, idRaca) REFERENCES SubRaca(idSubRaca, idRaca);
ALTER TABLE SubRaca_Atributo ADD CONSTRAINT FK_SUBRACA_ATRIBUTO_ATRIBUTO FOREIGN KEY(idAtributo) REFERENCES Atributo(idAtributo);

-- ----------------------------------------------------------------------------------------------------
-- SubRaça_Feature ---------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS SubRaca_Feature (
	idSubRaca INT NOT NULL,
	idRaca INT NOT NULL,
    idFeature INT NOT NULL
);
-- PK
ALTER TABLE SubRaca_Feature ADD CONSTRAINT PK_SUBRACA_FEATURE PRIMARY KEY(idSubRaca, idRaca, idFeature);
-- FK
ALTER TABLE SubRaca_Feature ADD CONSTRAINT FK_SUBRACA_FEATURE_RACA FOREIGN KEY(idSubRaca, idRaca) REFERENCES SubRaca(idSubRaca, idRaca);
ALTER TABLE SubRaca_Feature ADD CONSTRAINT FK_SUBRACA_FEATURE_FEATURE FOREIGN KEY(idFeature) REFERENCES Feature(idFeature);

-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------