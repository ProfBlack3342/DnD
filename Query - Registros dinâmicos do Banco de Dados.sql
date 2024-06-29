-- ----------------------------------------------------------------------------------------------------
USE dnd;

-- ----------------------------------------------------------------------------------------------------
-- Usuarios Para Teste --------------------------------------------------------------------------------
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
		quantPersonagensTotalUsuario,
		quantPersonagensCriadosUsuario,
		dataCriacaoUsuario,
		usuarioAtivo
	)
VALUES (
		null, 
		1, 
		1, 
		"admin", 
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
		3, 
		"gm",
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
		2, 
		"user",
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