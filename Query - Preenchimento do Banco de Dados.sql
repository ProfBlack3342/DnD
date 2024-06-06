USE dnd;
-- ----------------------------------------------------------------------------------------------------
-- Pré-Registrados No Banco ---------------------------------------------------------------------------
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
        "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Classe",
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
        "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Subclasse",
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
        "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Raça",
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
        "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Subraça",
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
        "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Background",
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
		"C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Usuario",
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
		"Gerenciamento e manutenção de todos os outros usuários.",
        '2024-04-12', 
		true
	), (
		null, 
		"Game Master", 
		"Pode criar, editar e excluir salas e campanhas.",
        '2024-04-12', 
		true
    ), (
		null, 
		"Jogador", 
		"Pode criar, editar e excluir fichas, entrar em salas e campanhas.",
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
        "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg",
        "Imagem Default Personagem",
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
-- Modificados Pelo Programa --------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Usuario (
		idUsuario, 
		idImagemUsuario, 
		idTipoUsuario, 
		nomeUsuario, 
		senhaUsuario, 
		emailUsuario, 
        dataAniversarioUsuario,
		descricaoUsuario, 
		quantPersonagensTotal, 
		quantPersonagensCriados, 
		dataCriacaoUsuario, 
		usuarioAtivo
	)
VALUES (
		null, 
		1, 
		1, 
		"adminTeste", 
		"$2a$12$5v7aVg.vH6ITJpBtg.wZi.ltuu6kGi/QHtPRBxFOgl5pXVG2XY/U6", 
        "admin@teste.com",
		"1995-06-06", 
		"Teste de Admin. Senha = admin123", 
		99,
		0, 
		'2024-04-12', 
		true
	), (
		null, 
		1, 
		2, 
		"gmTeste",
		"$2a$12$OdWIpJv/K8An3agDEWzFl.JJ28fnP1PisgLQjgMda5qHQAaFrVYMe", 
        "gm@teste.com", 
		"1995-06-06", 
		"Teste de GM. Senha = gm123", 
		99, 
		0, 
		'2024-04-12', 
		true
	), (
		null, 
		1, 
		3, 
		"jogadorTeste",
		"$2a$12$yVKR9Rwm9o8Ho0bSuUhrNeyXVk1.3.7PgWJ.usozPjVew4134YOia", 
        "usuario@teste.com", 
		"1995-06-06", 
		"Teste de Jogador. Senha = senha123", 
		99, 
		0, 
		'2024-04-12', 
		true
	);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
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
        nivelPersonagem,
        xpPersonagem,
        inspiracaoPersonagem,
        dataCriacaoPersonagem,
        personagemAtivo
	)
VALUES (
		
	);
-- ----------------------------------------------------------------------------------------------------
INSERT INTO HabilidadesPersonagem (
		idHabilidadesPersonagem,
        idPersonagem,
        idUsuario,
        valorSTRBase,
        proficienteSaveSTR,
        valorDEXBase,
        proficienteSaveDEX,
        valorCONBase,
        proficienteSaveCON,
        valorINTBase,
        proficienteSaveINT,
        valorWISBase,
        proficienteSaveWIS,
        valorCHABase,
        proficienteSaveCHA
	)
VALUES (
		
	);
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ProficienciasSkillPersonagem (
		idProficienciasSkillPersonagem,
        idPersonagem,
        idUsuario,
        proficienteAtletismo,
        proficienteAcrobacia,
        proficienteFurtividade,
        proficientePrestidigitacao,
        proficienteArcanismo,
        proficienteHistoria,
        proficienteInvestigacao,
        proficienteNatureza,
        proficienteReligiao,
        proficienteAdestrarAnimais,
        proficienteIntuicao,
        proficienteMedicina,
        proficientePercepcao,
        proficienteSobrevivencia,
        proficienteAtuacao,
        proficienteEnganacao,
        proficienteIntimidacao,
        proficientePersuasao
	)
VALUES (
		
	);
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------