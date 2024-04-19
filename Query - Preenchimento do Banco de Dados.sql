INSERT INTO imagemusuario
VALUES (null, "Coconut", "C:\\Users\\dudup\\Documents\\NetBeansProjects\\DnD\\src\\img\\coconut.jpg", "Imagem para testes (Hehe coco)");

INSERT INTO tipousuario
VALUES
	(null, "Admin", "Gerenciamento e manutenção de todos os outros usuários."),
	(null, "Game Master", "Pode criar, editar e excluir salas e campanhas."),
    (null, "Jogador", "Pode criar, editar e excluir fichas, entrar em salas e campanhas.");
    
INSERT INTO usuario
VALUES
	(null, 1, 1, "adminTeste", "admin@teste.com", "$2a$12$5v7aVg.vH6ITJpBtg.wZi.ltuu6kGi/QHtPRBxFOgl5pXVG2XY/U6", "1995-06-06", "Teste de Admin. Senha = admin123", 99, 0, '2024-04-12', true),
    (null, 1, 2, "gmTeste","gm@teste.com", "$2a$12$OdWIpJv/K8An3agDEWzFl.JJ28fnP1PisgLQjgMda5qHQAaFrVYMe", "1995-06-06", "Teste de GM. Senha = gm123", 99, 0, '2024-04-12', true),
    (null, 1, 3, "jogadorTeste","usuario@teste.com", "$2a$12$yVKR9Rwm9o8Ho0bSuUhrNeyXVk1.3.7PgWJ.usozPjVew4134YOia", "1995-06-06", "Teste de Jogador. Senha = senha123", 99, 0, '2024-04-12', true);
    
SELECT * FROM imagemusuario;
SELECT * FROM tipousuario;
SELECT * FROM usuario;