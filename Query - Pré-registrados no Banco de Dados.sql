-- ----------------------------------------------------------------------------------------------------
USE dnd;

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
        CAST(GETDATE() AS Date),
        true
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
        CAST(GETDATE() AS Date),
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
        CAST(GETDATE() AS Date),
        true
	);

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Raca ------------------------------------------------------------------------------
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
        CAST(GETDATE() AS Date),
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
        CAST(GETDATE() AS Date),
        true
	);

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da SubRaca ---------------------------------------------------------------------------
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
        CAST(GETDATE() AS Date),
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
        CAST(GETDATE() AS Date),
		true
	);

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Usuario ------------------------------------------------------------------------------------
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
        CAST(GETDATE() AS Date), 
		true
	), (
		null, 
		"Jogador", 
		"Fichas, entrar em salas e campanhas.",
        CAST(GETDATE() AS Date), 
		true
    ), (
		null, 
		"Game Master", 
		"Salas e campanhas",
        CAST(GETDATE() AS Date), 
		true
    );
    
-- ----------------------------------------------------------------------------------------------------
-- Classes --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe (
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
        
        CAST(GETDATE() AS Date),
        true
	);
    
-- ----------------------------------------------------------------------------------------------------
-- SubClasses -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubClasse (
		idSubClasse,
        idClasse,
        idImagemSubClasse,
        
        dataCriacaoSubClasse,
        subClasseAtiva
	)
VALUES (
		
	);
    
-- ----------------------------------------------------------------------------------------------------
-- Racas ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Raca (
		idRaca,
        idImagemRaca,
        
        dataCriacaoRaca,
        racaAtiva
	)
VALUES (
		
	);
    
-- ----------------------------------------------------------------------------------------------------
-- SubRacas --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubRaca (
		idSubRaca,
        idRaca,
        idImagemSubRaca,
        
        dataCriacaoSubRaca,
        subRacaAtiva
	)
VALUES (
		
	);
    
-- ----------------------------------------------------------------------------------------------------
-- Backgrounds ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Background (
		idBackground,
        idImagemBackground,
        
        dataCriacaoBackground,
        BackgroundAtivo
	)
VALUES (
		
	);

-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------