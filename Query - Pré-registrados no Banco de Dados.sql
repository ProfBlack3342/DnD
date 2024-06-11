USE dnd;
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
        "/img/coconut.jpg",
        "Coco",
        '2024-06-05',
        true
	);
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
        "/img/coconut.jpg",
        "Coco",
        '2024-06-05',
        true
	);
-- ----------------------------------------------------------------------------------------------------
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
        "/img/coconut.jpg",
        "Coco",
        '2024-06-05',
        true
	);
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
        "/img/coconut.jpg",
        "Coco",
        '2024-06-05',
        true
	);
-- ----------------------------------------------------------------------------------------------------
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
        "/img/coconut.jpg",
        "Coco",
        '2024-06-05',
        true
	);
-- ----------------------------------------------------------------------------------------------------
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
		"/img/coconut.jpg",
        "Coco",
        '2024-04-12',
		true
	);
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
        '2024-04-12', 
		true
	), (
		null, 
		"Game Master", 
		"Salas e campanhas",
        '2024-04-12', 
		true
    ), (
		null, 
		"Jogador", 
		"Fichas, entrar em salas e campanhas.",
        '2024-04-12', 
		true
    );
-- ----------------------------------------------------------------------------------------------------
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
        "/img/coconut.jpg",
        "Coco",
        '2024-06-05',
        true
	);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe (
		idClasse,
        idImagemClasse,
        
        dataCriacaoClasse,
        classeAtiva
	)
VALUES (
		null,
        1,
        
        '2024-06-05',
        true
	);
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
-- ----------------------------------------------------------------------------------------------------