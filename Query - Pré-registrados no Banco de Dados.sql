-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
USE dnd;
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Atributos ------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Atributo 
	( idAtributo, nomeAtributo, descricaoAtributo, dataCriacaoAtributo, atributoAtivo )
VALUES
	( null, "STR", "A Força mede a potência física, treinamento atlético, e a extensão da força bruta que você pode exercer. Um teste de Força representa qualquer tentativa de levantar, empurrar, puxar ou quebrar alguma coisa, forçar seu corpo através de um espaço ou outra forma de aplicar a força bruta para resolver uma situação.", CURDATE(), 1 ),
    ( null, "DEX", "A Destreza mede a agilidade, os reflexos e o equilíbrio. Um teste de Destreza representa a tentativa de se mover com agilidade, rapidez ou em silêncio, ou para evitar cair quando você andar por uma estrada traiçoeira.", CURDATE(), 1 ),
    ( null, "CON", "A Constituição mede a saúde, a resistência e a força vital. Testes de Constituição são incomuns e nenhuma perícia se aplica a eles, porque a resistência representada por essa habilidade é, em grande parte, passiva em vez de envolver um esforço específico por parte de um personagem ou monstro. No entanto, um teste de constituição pode representar uma tentativa de você ir além dos limites normais.", CURDATE(), 1 ),
    ( null, "INT", "A Inteligência mede a acuidade mental, precisão da memória e a habilidade de raciocinar. Um teste de Inteligência entra em jogo quando você precisa usar a lógica, estudo, memória ou raciocínio dedutivo.", CURDATE(), 1 ),
    ( null, "WIS", "A Sabedoria reflete como você está em sintonia com o mundo ao seu redor e representa percepção e intuição. Um teste de Sabedoria pode refletir um esforço para ler a linguagem corporal, entender os sentimentos de alguém, perceber coisas sobre o meio ambiente ou cuidar de uma pessoa ferida", CURDATE(), 1 ),
    ( null, "CHA", "O Carisma mede a capacidade de interagir eficazmente com os outros. Ele inclui fatores como confiança e eloquência, e pode representar uma personalidade encantadora ou dominadora.", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Pericias -------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Pericia
	( idPericia, idAtributoPericia, nomePericia, descricaoPericia, dataCriacaoPericia, periciaAtiva )
VALUES
	( null, 1, "Atletismo", "Um teste de Atletismo é feito para realizar situações difíceis que você encontra ao escalar, saltar ou nadar.", CURDATE(), 1 ),
    
    ( null, 2, "Acrobacia", "Um teste de Acrobacia é feito ao tentar permanecer de pé em uma situação complicada, como tentar correr sobre uma camada de gelo, equilibrar-se na corda bamba ou ficar de pé no convés de um navio que balança. O Mestre também pode pedir um teste para ver se você é capaz de realizar acrobacias, como cambalhotas e saltos mortais.", CURDATE(), 1 ),
    ( null, 2, "Furtividade", "Um teste de Furtividade é realizado para tentar esconder-se de inimigos, esgueirar-se por guardas, escapar sem ser notado, ou aproximar-se de alguém sem ser visto ou ouvido.", CURDATE(), 1 ),
    ( null, 2, "Prestidigitação", "Um teste de Prestidigitação é realizado sempre que você tentar realizar um ato de prestidigitação ou de trapaça manual.", CURDATE(), 1 ),
    
    ( null, 4, "Arcanismo", "Um teste de Arcanismo é feito para medir o conhecimento sobre magias, itens mágicos, símbolos sobrenaturais, tradições mágicas, os planos de existência e os habitantes desses planos.", CURDATE(), 1 ),
    ( null, 4, "História", "Um teste de História é feito para medir o conhecimento sobre eventos históricos, pessoas lendárias, reinos antigos, disputas passadas, guerras recentes e civilizações perdidas.", CURDATE(), 1 ),
    ( null, 4, "Investigação", "Um teste de Investigação é feito quando você olha ao redor em busca de pistas e faz deduções com base nesses indícios. Você pode deduzir a localização de um objeto escondido, discernir, a partir da aparência de um ferimento, que tipo de arma o causou, ou determinar o ponto mais fraco em um túnel que poderia causar o seu colapso. Debruçar-se sobre pergaminhos antigos em busca de um fragmento escondido de conhecimento também pode necessitar um teste.", CURDATE(), 1 ),
    ( null, 4, "Natureza", "Um teste de Natureza é feito para medir o conhecimento sobre terreno, plantas e animais, clima e ciclos naturais.", CURDATE(), 1 ),
    ( null, 4, "Religião", "Um teste de Religião é feito para medir o conhecimento de lendas sobre divindades, rituais e orações, hierarquias religiosas, símbolos sagrados e práticas de cultos secretos.", CURDATE(), 1 ),
    
    ( null, 5, "Adestrar Animais", "Um teste de Adestrar Animais é feito quando houver a necessidade de saber se você pode acalmar um animal domesticado, impedir uma montaria de se assustar, ou intuir as intenções de um animal. Você também realiza um teste para controlar sua montaria ao tentar uma manobra arriscada.", CURDATE(), 1 ),
    ( null, 5, "Intuição", "Um teste de Intuição é feito para determinar as verdadeiras intenções de uma criatura, perceber uma mentira ou prever o próximo movimento de alguém. Fazer isso envolve recolher pistas a partir da linguagem corporal, os hábitos da fala e as mudanças nos maneirismos.", CURDATE(), 1 ),
    ( null, 5, "Medicina", "Um teste de Medicina é feito ao tentar estabilizar um companheiro que está morrendo ou diagnosticar uma doença.", CURDATE(), 1 ),
    ( null, 5, "Percepção", "Um teste de Percepção é feito para observar, ouvir ou detectar a presença de alguma coisa de outra forma. A percepção mede a consciência geral do que está acontecendo ao seu redor e a acuidade de seus sentidos. Por exemplo, você pode tentar ouvir uma conversa através de uma porta fechada, bisbilhotar sob uma janela aberta ou ouvir monstros movendo-se furtivamente na floresta. Ou você pode tentar detectar coisas que são obscurecidas ou que normalmente passariam despercebidas, desde uma emboscada de orcs em uma estrada, bandidos escondidos nas sombras de um beco ou uma porta secreta fechada somente com a luz de velas.", CURDATE(), 1 ),
    ( null, 5, "Sobrevivência", "Um teste de Sobrevivência é feito para seguir rastros, caçar, orientar o grupo através de terras congeladas, identificar sinais de que ursos-coruja vivem nas proximidades, prever o tempo, ou evitar areia movediça e outros perigos naturais.", CURDATE(), 1 ),
    
    ( null, 6, "Atuação", "Um teste de Atuação é feito para determinar o quão bem você pode entreter uma plateia com música, dança, atuação, contando histórias ou alguma outra forma de entretenimento.", CURDATE(), 1 ),
    ( null, 6, "Enganação", "Um teste de Enganação é feito para determinar se você pode esconder a verdade de forma convincente, verbalmente ou através de suas ações. Esse engano pode abranger tudo, como iludir os outros através de uma mentira cheia de ambiguidade. Situações típicas incluem tentar ludibriar um guarda, iludir um comerciante, ganhar dinheiro através de jogos de azar, usar um disfarce, amenizar as suspeitas de alguém com falsas garantias ou manter uma cara séria ao contar uma mentira descarada.", CURDATE(), 1 ),
    ( null, 6, "Intimidação", "Um teste de Intimidação é feito para tentar influenciar alguém através de ameaças abertas, ações hostis e violência física. Exemplos incluem tentar arrancar informações de um prisioneiro, convencer bandidos de rua a recuar de um confronto ou usar uma garrafa quebrada para convencer um vizir sarcástico a reconsiderar uma decisão.", CURDATE(), 1 ),
    ( null, 6, "Persuasão", "Um teste de Persuasão é feito quando você tenta influenciar alguém ou um grupo de pessoas com tato, delicadeza ou boa índole. Normalmente, você usa a Persuasão quando está agindo de boa-fé, para promover amizades, fazer pedidos cordiais ou exibir a etiqueta apropriada. Exemplos de persuadir os outros incluem convencer um mordomo a deixar seu grupo ver o rei, negociar a paz entre duas tribos em conflito ou inspirar uma multidão de pessoas da cidade.", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Dano ---------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO TipoDano
	( idTipoDano, nomeTipoDano, abreviacaoNomeTipoDano, descricaoTipoDano, dataCriacaoTipoDano, tipoDanoAtivo )
VALUES
	( null, "Ácido", "Ac", "O jato ácido do sopro de um dragão negro adulto e as enzimas digestivas secretadas por um pudim negro, corroem a matéria, causando dano ácido.", CURDATE(), 1 ),
	( null, "Contundente", "Ct", "Ataques de força e impacto — martelos, quedas, constrição e similares — causam dano contundente.", CURDATE(), 1 ),
	( null, "Cortante", "Cr", "Espadas, machados e garras de monstros causam dano cortante.", CURDATE(), 1 ),
	( null, "Elétrico", "El", "A magia relâmpago e o sopro de um dragão azul jovem causam dano elétrico.", CURDATE(), 1 ),
	( null, "Energético", "En", "Também chamado de Força, a pura energia mágica, canalizada para causar dano. A maioria dos efeitos que causam dano energético são mágicos, incluindo mísseis mágicos e arma espiritual.", CURDATE(), true ),
	( null, "Gélido", "Gl", "O calafrio infernal que emana da lança de um diabo do gelo ou a explosão congelante do sopro de um dragão branco jovem, causam dano gélido.", CURDATE(), 1 ),
	( null, "Ígneo", "Ig", "O sopro de fogo de um dragão vermelho ancião e magias que invocam calor ou chamas, causam dano ígneo.", CURDATE(), 1 ),
	( null, "Necrótico", "Nc", "O dano necrótico, causado por certos mortos-vivos e por magias como toque chocante, definha a matéria viva e até mesmo a alma.", CURDATE(), 1 ),
	( null, "Perfurante", "Pr", "Ataques com objetos pontudos, como lanças e mordidas de monstros, causam dano perfurante.", CURDATE(), 1 ),
	( null, "Psíquico", "Ps", "Habilidades mentais, tais como rajada psiônica, causam dano psíquico.", CURDATE(), 1 ),
	( null, "Radiante", "Rd", "O dano radiante, causado pela magia coluna de chamas de um clérigo ou pela arma de um anjo, queima a carne como fogo e sobrecarrega o espírito com poder.", CURDATE(), true ),
	( null, "Trovejante", "Tr", "Uma explosão massiva de som, como o efeito da magia onda trovejante, causa dano trovejante.", CURDATE(), 1 ),
	( null, "Venenoso", "Vn", "Picadas venenosas e os gases tóxicos do sopro de um dragão verde adulto causam dano venenoso.", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Arma ---------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO TipoArma
	( idTipoArma, nomeTipoArma, descricaoTipoArma, dataCriacaoTipoArma, tipoArmaAtivo )
VALUES 
	( null, "Simples", "", CURDATE(), 1 ),
	( null, "Marcial", "", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Propriedade de Arma --------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO PropriedadeArma
	( idPropriedadeArma, nomePropriedadeArma, descricaoPropriedadeArma, dataCriacaoPropriedadeArma, propriedadeArmaAtiva )
VALUES
	( null, "Ágil", "Pode usar DEX no lugar de STR para ataque e dano.", CURDATE(), 1 ),
	( null, "Alcance", "+1,5m de alcance quando a usa para atacar.", CURDATE(), 1 ),
	( null, "Arremesso", "Pode ser usada à distância com o mesmo atributo usado para corpo-a-corpo.", CURDATE(), 1 ),
	( null, "Distância", "Distância são dois valores; ataque além do primeiro valor recebem Desvantagem, além do segundo são impossíveis.", CURDATE(), 1 ),
	( null, "Duas Mãos", "A arma precisa ser usada com as duas mãos.", CURDATE(), 1 ),
    ( null, "Especial", "Possui regras únicas.", CURDATE(), 1 ),
    ( null, "Leve", "Pode ser usada para Lutar com Duas Armas.", CURDATE(), 1 ),
    ( null, "Munição", "Arma de projétil. Ao fim do encontro pode recuperar metade da munição disparada.", CURDATE(), 1 ),
    ( null, "Pesada", "Criaturas Pequenas tem Desvantagem com essa arma.", CURDATE(), 1 ),
    ( null, "Recarga", "Só pode fazer um ataque com essa arma por ação, independente do número de ataques que possua.", CURDATE(), 1 ),
    ( null, "Versátil", "Pode ser usada com uma ou duas mãos. O valor entre parênteses é com duas mãos.", CURDATE(), 1 ),
    ( null, "Lança de Montaria", "Recebe Desvantagem para atacar oponentes adjacentes. Deve ser usada com duas mãos quando não estiver montado.", CURDATE(), 1 ),
	( null, "Rede", "Criatura Grande ou menor acertada é Presa. Com uma ação a criatura pode fazer um CD de STR 10 para livrar-se de sua rede.", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Armas ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Arma
	( idArma, idTipoArma, nomeArma, descricaoArma, precoCobreArma, precoPrataArma, precoElectrumArma, precoOuroArma, precoPlatinaArma, multiplicadorDadoArma, dadoArma,
    idTipoDano, pesoArma, quantPropriedadesArma, dataCriacaoArma, armaAtiva )
VALUES
	( null, 1, "Desarmado", "", 0, 0, 0, 0, 0, 1, 1, 2, 0.0, 0, CURDATE(), 1 ),
    
    -- Simples
    ( null, 1, "Adaga", "", 0, 0, 0, 2, 0, 1, 4, 9, 0.5, 3, CURDATE(), 1 ),
    ( null, 1, "Azagaia", "", 0, 5, 0, 0, 0, 1, 6, 9, 1.0, 1, CURDATE(), 1 ),
    ( null, 1, "Cajado", "", 0, 2, 0, 0, 0, 1, 6, 2, 2.0, 1, CURDATE(), 1 ),
    ( null, 1, "Clava Grande", "", 0, 2, 0, 0, 0, 1, 8, 2, 5.0, 1, CURDATE(), 1 ),
    ( null, 1, "Foice Curta", "", 0, 0, 0, 1, 0, 1, 4, 3, 1.0, 1, CURDATE(), 1 ),
    ( null, 1, "Lança", "", 0, 0, 0, 1, 0, 1, 6, 9, 1.5, 2, CURDATE(), 1 ),
    ( null, 1, "Maça", "", 0, 0, 0, 5, 0, 1, 6, 2, 2.0, 0, CURDATE(), 1 ),
    ( null, 1, "Machadinha", "", 0, 0, 0, 5, 0, 1, 6, 3, 1.0, 2, CURDATE(), 1 ),
    ( null, 1, "Martelo Leve", "", 0, 0, 0, 2, 0, 1, 4, 2, 1.0, 2, CURDATE(), 1 ),
    ( null, 1, "Porrete", "", 0, 1, 0, 0, 0, 1, 4, 2, 1.0, 1, CURDATE(), 1 ),
    
    ( null, 1, "Arco Curto", "", 0, 0, 0, 25, 0, 1, 6, 9, 1.0, 3, CURDATE(), 1 ),
    ( null, 1, "Besta Leve", "", 0, 0, 0, 25, 0, 1, 8, 9, 2.5, 4, CURDATE(), 1 ),
    ( null,	1, "Dardo", "", 5, 0, 0, 0, 0, 1, 4, 9, 0.125, 3, CURDATE(),	1 ),
    ( null, 1, "Funda", "", 0, 1, 0, 0, 0, 1, 4, 2, 0.0, 2, CURDATE(), 1 ),
    
    -- Marciais
    ( null, 2, "Machado", "", 0, 0, 0, 10, 0, 1, 8, 3, 2.0, 1, CURDATE(), 1 ),
    ( null, 2, "Mangual", "", 0, 0, 0, 10, 0, 1, 8, 2, 1.0, 0, CURDATE(), 1 ),
    ( null, 2, "Glaive", "", 0, 0, 0, 20, 0, 1, 10, 3, 3.0, 3, CURDATE(), 1 ),
    ( null, 2, "Machado Grande", "", 0, 0, 0, 30, 0, 1, 12, 3, 3.5, 2, CURDATE(), 1 ),
    ( null, 2, "Espada Duas Mãos", "", 0, 0, 0, 50, 0, 2, 6, 3, 3.0, 2, CURDATE(), 1 ),
    ( null, 2, "Alabarda", "", 0, 0, 0, 20, 0, 1, 10, 3, 3.0, 3, CURDATE(), 1 ),
    ( null, 2, "Lança de Montaria", "", 0, 0, 0, 10, 0, 1, 12, 9, 3.0, 2, CURDATE(), 1 ),
    ( null, 2, "Espada Longa", "", 0, 0, 0, 15, 0, 1, 8, 3, 1.5, 1, CURDATE(), 1 ),
    ( null, 2, "Marreta", "", 0, 0, 0, 10, 0, 2, 6, 2, 5.0, 2, CURDATE(), 1 ),
    ( null, 2, "Maça Estrela", "", 0, 0, 0, 15, 0, 1, 8, 9, 2.0, 0, CURDATE(), 1 ),
    ( null, 2, "Pique", "", 0, 0, 0, 5, 0, 1, 10, 9, 9.0, 3, CURDATE(), 1 ),
    ( null, 2, "Florete", "", 0, 0, 0, 25, 0, 1, 8, 9, 1.0, 1, CURDATE(), 1 ),
    ( null, 2, "Cimitarra", "", 0, 0, 0, 25, 0, 1, 6, 3, 1.5, 2, CURDATE(), 1 ),
    ( null, 2, "Espada Curta", "", 0, 0, 0, 10, 0, 1, 6, 9, 1.0, 2, CURDATE(), 1 ),
    ( null, 2, "Tridente", "", 0, 0, 0, 5, 0, 1, 6, 9, 2.0, 2, CURDATE(), 1 ),
    ( null, 2, "Picareta de Guerra", "", 0, 0, 0, 5, 0, 1, 8, 9, 1.0, 0, CURDATE(), 1 ),
    ( null, 2, "Martelo de Guerra", "", 0, 0, 0, 15, 0, 1, 4, 2, 1.0, 1, CURDATE(), 1 ),
    ( null, 2, "Chicote", "", 0, 0, 0, 2, 0, 1, 4, 3, 1.5, 2, CURDATE(),1 ),
    
    ( null, 2, "Zarabatana", "", 0, 0, 0, 10, 0, 1, 1, 9, 0.5, 3, CURDATE(), 1 ),
	( null, 2, "Besta de Mão", "", 0, 0, 0, 75, 0, 1, 6, 9, 1.5, 4, CURDATE(), 1 ),
    ( null,	2, "Besta Pesada", "", 0, 0, 0, 50, 0, 1, 10, 9, 9.0, 5, CURDATE(), 1 ),
    ( null, 2, "Arco Longo","", 0, 0, 0, 50, 0, 1, 8, 9, 1.0, 4, CURDATE(), 1 ),
    ( null, 2, "Rede" ,"" , 0, 0, 0, 1, 0, 0, 0, null, 1.5, 3, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Relação Arma_Propriedade ---------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Arma_Propriedade
	( idArma, idPropriedadeArma, distancaDesvantagemArma_Propriedade, distanciaFalhaArma_Propriedade )
VALUES 
	-- Adaga
	( 2, 1, null, null ),
	( 2, 3, 6, 18 ),
    ( 2, 7, null, null );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Armadura -----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO TipoArmadura
	( idTipoArmadura, nomeTipoArmadura, descricaoTipoArmadura, dataCriacaoTipoArmadura, tipoArmaduraAtiva )
VALUES
	( null, "Leve", "", CURDATE(), 1 ),
    ( null, "Média", "", CURDATE(), 1 ),
    ( null, "Pesada", "", CURDATE(), 1 ),
    ( null, "Escudo", "", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Armaduras ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Armadura
	( idArmadura, idTipoArmadura, nomeArmadura, descricaoArmadura, precoCobreArmadura, precoPrataArmadura, precoElectrumArmadura, precoOuroArmadura, precoPlatinaArmadura, ValorCaArmadura, RequisitoStrArmadura, armaduraTemDesvantagemFurtividade, pesoArmadura, dataCriacaoArmadura, ArmaduraAtiva )
VALUES
	-- Leves
	( null, 1, "Acolchoada", "", 0, 0, 0, 5, 0, 1, 0, 0, 4.0, CURDATE(), 1 ),
    ( null, 1, "Couro", "", 0, 0, 0, 10, 0, 1, 0, 0, 5.0, CURDATE(), 1 ),
    ( null, 1, "Couro Batido", "", 0, 0, 0, 45, 0, 2, 0, 0, 6.5, CURDATE(), 1 ),
    
    -- Medias
    ( null, 2, "Gibão de Peles", "", 0, 0, 0, 10, 0, 2, 0, 0, 6.0, CURDATE(), 1 ),
    ( null, 2, "Camisão de Malha", "", 0, 0, 0, 50, 0, 3, 0, 0, 10.0, CURDATE(), 1 ),
    ( null, 2, "Brunea", "", 0, 0, 0, 50, 0, 4, 0, 1, 22.5, CURDATE(), 1 ),
    ( null, 2, "Peitoral de Aço", "", 0, 0, 0, 400, 0, 4, 0, 0, 10.0, CURDATE(), 1 ),
    ( null, 2, "Meia-Armadura", "", 0, 0, 0, 750, 0, 5, 0, 1, 20.0, CURDATE(), 1 ),
    
    -- Pesada
    ( null, 3, "Cota de Anéis", "", 0, 0, 0, 30, 0, 4, 0, 1, 20.0, CURDATE(), 1 ),
    ( null, 3, "Cota de Malha", "", 0, 0, 0, 75, 0, 6, 13, 1, 22.5, CURDATE(), 1 ),
    ( null, 3, "Cota de Talas", "", 0, 0, 0, 200, 0, 7, 15, 1, 30.0, CURDATE(), 1 ),
    ( null, 3, "Armadura de Placas", "", 0, 0, 0, 1500, 0, 8, 15, 1, 32.5, CURDATE(), 1 ),
    
    -- Escudo
    ( null, 4, "Escudo", "", 0, 0, 0, 10, 0, 2, 0, 0, 3.0, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Equipamento de Aventura ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO EquipamentoAventura
	( idEquipamentoAventura, nomeEquipamentoAventura, descricaoEquipamentoAventura, precoCobreEquipamentoAventura, precoPrataEquipamentoAventura, precoElectrumEquipamentoAventura, precoOuroEquipamentoAventura, precoPlatinaEquipamentoAventura, pesoEquipamentoAventura, dataCriacaoEquipamentoAventura, equipamentoAventuraAtivo )
VALUES
	( null, "Peça de Cobre", "", 1, 0.1, 0.02, 0.01, 0.001, 0, CURDATE(), 1 ),	-- 1
    ( null, "Peça de Prata", "", 10, 1, 0.2, 0.1, 0.01, 0, CURDATE(), 1 ),		-- 2
    ( null, "Peça de Electrum", "", 50, 5, 1, 0.5, 0.05, 0, CURDATE(), 1 ),		-- 3
    ( null, "Peça de Ouro", "", 100, 10, 2, 1, 0.1, 0, CURDATE(), 1 ),			-- 4
    ( null, "Peça de Platina", "", 1000, 100, 50, 10, 1, 0, CURDATE(), 1 ),		-- 5
    
	( null, "Ábaco", "", 0, 0, 0, 2, 0, 1.0, CURDATE(), 1 ),					-- 6
    ( null, "Ácido (vidro)", "", 0, 0, 0, 25, 0, 0.5, CURDATE(), 1 ),			-- 7
    
	-- Temporarios para Teste
    ( null, "Bolsa de Componentes", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),		-- 8
    ( null, "Foco Arcano", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),				-- 9
    ( null, "Pacote do Explorador", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),		-- 10
    ( null, "Pacote de Masmorra", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),			-- 11
    ( null, "Símbolo Sagrado", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),			-- 12
    ( null, "Livro de Oração", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),			-- 13
    ( null, "Bastão de Incenso", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),			-- 14
    ( null, "Vestimenta", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),					-- 15
    ( null, "Roupa Comum", "", 0, 0, 0, 0, 0, 0, CURDATE(), 1 );				-- 16

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Tipo de Ferramenta ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO TipoFerramenta
	( idTipoFerramenta, nomeTipoFerramenta, descricaoTipoFerramenta, dataCriacaoTipoFerramenta, tipoFerramentaAtivo )
VALUES
	( null, "Ferramenta de Artesão", "", CURDATE(), 1 ),
    ( null, "Kit de jogos", "", CURDATE(), 1 ),
    ( null, "Instrumento musical", "", CURDATE(), 1 ),
    ( null, "Veículo (terra ou água)", "", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Ferramentas ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Ferramenta
	( idFerramenta, idTipoFerramenta, nomeFerramenta, descricaoFerramenta, precoCobreFerramenta, precoPrataFerramenta, precoElectrumFerramenta, precoOuroFerramenta, precoPlatinaFerramenta, pesoFerramenta, dataCriacaoFerramenta, ferramentaAtiva )
VALUES
	-- Ferramentas de Artesão
	( null, 1, "Ferramentas de cartógrafo", "", 0, 0, 0, 15, 0, 3.0, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de coureiro", "", 0, 0, 0, 5, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas/utensílios de cozinheiro", "", 0, 0, 0, 1, 0, 4, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de entalhador", "", 0, 0, 0, 1, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de ferreiro", "", 0, 0, 0, 20, 0, 4.0, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de funileiro", "", 0, 0, 0, 50, 0, 5.0, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de joalheiro", "", 0, 0, 0, 25, 0, 1.0, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de oleiro", "", 0, 0, 0, 10, 0, 1.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de pedreiro/construtor", "", 0, 0, 0, 10, 0, 4.0, CURDATE(), 1 ),
    ( null, 1, "Ferramentas/suprimentos de pintor", "", 0, 0, 0, 10, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de sapateiro", "", 0, 0, 0, 5, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de tecelão", "", 0, 0, 0, 1, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de vidreiro", "", 0, 0, 0, 30, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de ladrão", "", 0, 0, 0, 25, 0, 0.5, CURDATE(), 1 ),
    ( null, 1, "Ferramentas de navegador", "", 0, 0, 0, 25, 0, 1.5, CURDATE(), 1 ),
    ( null, 1, "Kit de disfarce", "", 0, 0, 0, 25, 0, 1.5, CURDATE(), 1 ),
    ( null, 1, "Kit de falsificação", "", 0, 0, 0, 15, 0, 2.5, CURDATE(), 1 ),
    ( null, 1, "Kit de herbalismo", "", 0, 0, 0, 5, 0, 1.5, CURDATE(), 1 ),
    ( null, 1, "Kit de veneno", "", 0, 0, 0, 50, 0, 1.0, CURDATE(), 1 ),
    
    -- Kits de jogos
    ( null, 2, "Conjunto de dados", "", 0, 1, 0, 0, 0, 0.0, CURDATE(), 1 ),
    ( null, 2, "Baralho", "", 0, 5, 0, 0, 0, 0.0, CURDATE(), 1 ),
    
    -- Instrumentos musicais
    ( null, 3, "Alaúde", "", 0, 0, 0, 35, 0, 1.0, CURDATE(), 1 ),
    ( null, 3, "Flauta", "", 0, 0, 0, 2, 0, 0.5, CURDATE(), 1 ),
    ( null, 3, "Flauta de Pan", "", 0, 0, 0, 12, 0, 1.0, CURDATE(), 1 ),
    ( null, 3, "Gaita de foles", "", 0, 0, 0, 30, 0, 3.0, CURDATE(), 1 ),
    ( null, 3, "Lira", "", 0, 0, 0, 30, 0, 1.0, CURDATE(), 1 ),
    ( null, 3, "Oboé", "", 0, 0, 0, 2, 0, 0.5, CURDATE(), 1 ),
    ( null, 3, "Tambor", "", 0, 0, 0, 6, 0, 1.5, CURDATE(), 1 ),
    ( null, 3, "Trombeta", "", 0, 0, 0, 3, 0, 1.0, CURDATE(), 1 ),
    ( null, 3, "Violino", "", 0, 0, 0, 30, 0, 0.5, CURDATE(), 1 ),
    ( null, 3, "Xilofone", "", 0, 0, 0, 25, 0, 5.0, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Feature --------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Feature
	( idFeature, nomeFeature, descricaoFeature, featureConcedeProficienciaArma, featureConcedeProficienciaArmadura, featureConcedeProficienciaFerramenta, featureConcedeProficienciaLinguagem, featureConcedeProficienciaPericia, featureConcedeProficienciaSaveAtributo, featureConcedeSpell, dataCriacaoFeature, featureAtiva )
VALUES
	-- Classe
		-- Feiticeiro
	( null, "Conjuração", "O Feiticeiro conjura magia usando a tabela padrão, baseada em CAR, inclusive rituais. Ele conhece um número de magias indicado na tabela, e a cada nível ele pode trocar uma magia conhecida por outra de nível que possa conjurar. Ele pode usar um foco arcano como Foco de Conjuração.\nCD das Magias = 8 + Bônus de Proficiência + Modificador de Carisma\nModificador de Ataque de Magia = Bônus de Proficiência + Modificador de Carisma\nO Feiticeiro começa o jogo com 4 Truques, e aprende um novo aos níveis 4 e 10.", 0, 0, 0, 0, 0, 0, 1, CURDATE(), 1 ),
    ( null, "Fonte de Magia", "O Feiticeiro tem um fonte de magia que é representada por seus de Pontos de Feitiçaria (PF na Tabela). Ele possui uma quantidade deles igual a seu nível, que são usados para ativar algumas de suas habilidades. Ele nunca pode ter mais do que os mostrados na tabela e recupera todos os pontos gastos com um descanso longo.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Conjuração Flexível", "Com uma Ação Bônus o Feiticeiro pode transformar magias diárias em Pontos de Feitiçaria e Vice-Versa. Magias diárias garantem Pontos de Feitiçaria à taxa de 1-1. Pontos de Feitiçaria geram magias diárias à taxa de Nível +1 para nível de magia 1 e 2, e Nível +2 para nível 3 a 5. É impossível criar magias diárias de nível 6 ou maior.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Restauração Feiticeira", "O Feiticeiro recupera 4 Pontos de Feitiçaria com um Descanso Curto.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
	( null, "Metamagia", "O Feiticeiro é capaz de distorcer a magia para funcionar como ele deseja. Ele aprende duas opções da lista de metamagias, com adição de mais uma aos níveis 10 e 17. Por via de regra uma magia só pode ser afetada por uma única Metamagia por vez, exceto quando houver uma descrição indicando o contrário. Cada uso gasta 1 Ponto de Feitiçaria.", 0, 0, 0, 0, 0, 0, 1, CURDATE(), 1 ),
    
    -- SubClasse
		-- Feiticeiro - Alma Divina
    ( null, "Magia Divina", "Sempre que sua habilidade de conjuração permitir trocar uma magia conhecida por outra de mesmo nível, você pode escolher da lista de Feiticeiro ou Clérigo. Adicionalmente escolha uma tendência de afinidade; você adiciona a mais associada a sua lista de magias conhecidas. Caso mais tarde substitua essa magia, deve fazê-lo por uma magia de Clérigo.", 0, 0, 0, 0, 0, 0, 1, CURDATE(), 1 ),
    ( null, "Favorecido pelos Deuses", "Uma vez por descanso curto, quando falha em um teste de resistência ou erra um ataque, pode adicionar +2d4 ao resultado.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Cura Aprimorada", "Uma vez por turno quando você ou aliado adjacente rola dados de magia de cura, com uma reação pode gastar 1 Ponto de Feitiçaria para re-rolar qualquer quantidade desses dados.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Asas Divinas", "Com uma ação bônus você pode criar ou dispensar asas que lhe garantem deslocamento de voo 9m.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Recuperação Sobrenatural", "Uma vez por dia, quando está com metade dos seus PA ou menos, com ação bônus recupera metade do seu máximo.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    
    -- Raça
    ( null, "Visão no Escuro", "Trata luz baixa como luz normal e escuridão como luz baixa, ambos a até 18m.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
		-- Aasimar
    ( null, "Mãos que Curam", "Uma vez por dia com uma ação cura alvo tocado PA igual à seu nível.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Portador da Luz", "Conhece o Truque Luz.", 0, 0, 0, 0, 0, 0, 1, CURDATE(), 1 ),
    ( null, "Resistência Celestial", "Resistência à dano Necrótico e Radiante.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    
    
    -- SubRaça
		-- Aasimar Protetor
    ( null, "Alma Radiante", "A partir do nível 3, uma vez por dia pode libertar energia celestial por 1 minuto ou até terminar o efeito com ação bônus. Durante o efeito recebe deslocamento de vôo 9m, e uma vez por turno causa +nível dano radiante em um de seus ataques ou magias.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 ),
    
    -- Background
		-- Acólito
	( null, "Abrigo dos Fiéis", "Você tem o respeito de outros de sua fé, e pode fazer as cerimônias religiosas de sua divindade. Você e seus companheiros podem esperar cura e cuidado grátis em um templo de sua fé, apesar de precisar pagar componentes caros. Sua religião e doações lhe sustentam em um estilo de vida Modesto. Você também pode ter Vínculos com um templo em particular, seja onde morou ou onde mora agora, e enquanto próximo dele você tem assistência garantida de seus sacerdotes, desde que não seja algo perigoso.", 0, 0, 0, 0, 0, 0, 0, CURDATE(), 1 );
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Linguagens -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Linguagem
	( idLinguagem, nomeLinguagem, descricaoLinguagem, dataCriacaoLinguagem, linguagemAtiva )
VALUES
	( null, "Comum", "", CURDATE(), 1 ),
    ( null, "Celestial", "", CURDATE(), 1 );



-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Spells ---------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Spell
	( idSpell, nomeSpell, descricaoSpell, dadoSpell, multiplicadorDadoSpell, spellTemComponenteVerbal, spellTemcomponenteSomatico, spellTemcomponenteMaterial, dataCriacaoSpell, spellAtiva )
VALUES
	( null, "Curar Ferimentos", "", 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Perdição", "", 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Infligir Ferimentos", "", 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Proteção contra Bem e Mal", "", 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Benção", "", 0, 0, 0, 0, 0, CURDATE(), 1 ),
    ( null, "Luz", "Você toca um objeto que não tenha mais 3 metros [10 feet] em qualquer dimensão. Até a magia acabar, o objeto emite luz plena num raio de 6 metros [20 feet] e penumbra por 6 metros [20 feet] adicionais. Cobrir o objeto completamente com alguma coisa opaca bloqueará a luz. A magia termina se você conjura-la novamente ou dissipa-la com uma ação.\nSe você tentar afetar um objeto segurado ou vestido por uma criatura hostil, a criatura deve ser bem sucedida num teste de Destreza para evitar a magia.", 0, 0, 1, 0, 1, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Classe ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemClasse
	( idImagemClasse, caminhoImagemClasse, descricaoImagemClasse, dataCriacaoImagemClasse, imagemClasseAtiva )
VALUES
	-- Imagem Padrão
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 ),
    -- Imagens Classes
    ( null, "/img/iconeClasseBarbaro.jpg", "Imagem Bárbaro", CURDATE(), 1 ),
    ( null, "/img/iconeClasseBardo.jpg", "Imagem Bardo", CURDATE(), 1 ),
    ( null, "/img/iconeClasseBruxo.jpg", "Imagem Bruxo", CURDATE(), 1 ),
    ( null, "/img/iconeClasseClerigo.jpg", "Imagem Clérigo", CURDATE(), 1 ),
    ( null, "/img/iconeClasseDruida.jpg", "Imagem Druida", CURDATE(), 1 ),
    ( null, "/img/iconeFeiticeiro.jpg", "Imagem Feiticeiro", CURDATE(), 1 ),
    ( null, "/img/iconeClasseGuardiao.jpg", "Imagem Guardião", CURDATE(), 1 ),
    ( null, "/img/iconeClasseGuerreiro.jpg", "Imagem Guerreiro", CURDATE(), 1 ),
    ( null, "/img/iconeClasseLadino.jpg", "Imagem Ladino", CURDATE(), 1 ),
    ( null, "/img/iconeClasseMago.jpg", "Imagem Mago", CURDATE(), 1 ),
    ( null, "/img/iconeClasseMonge.jpg", "Imagem Monge", CURDATE(), 1 ),
    ( null, "/img/iconeClassePaladino.jpg", "Imagem Paladino", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Classe ---------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe
	( idClasse, idImagemClasse, nomeClasse, descricaoClasse, bonusProficienciaInicialClasse, dadoClasse, quantProficienciasArmasClasse, quantProficienciasArmaduraClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantEquipamentosIniciaisClasse, quantFeaturesClasse, classeTemSpells, idAtributoSpells, dataCriacaoClasse, classeAtiva )
VALUES
	( null, 2, "Bárbaro", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 3, "Bardo", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 4, "Bruxo", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 5, "Clérigo", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 6, "Druida", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 7, "Feiticeiro", "Feiticeiros carregam uma herança mágica, dada a eles por virtude de uma linhagem exótica, influência sobrenatural ou exposição à uma força cósmica. É impossível estudar feitiçaria assim como é impossível aprender a viver uma vida lendária: Ninguém escolhe feitiçaria, o poder escolhe o feiticeiro.", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 8, "Guardião", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 9, "Guerreiro", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 10, "Ladino", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 11, "Mago", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 12, "Monge", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 ),
	( null, 13, "Paladino", "", 2, 6, 5, 0, 0, 2, 2, 3, 4, 1, 6, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Classe_Arma ----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe_Arma
	( idClasse, idArma )
VALUES
	( 6, 2 ),
    ( 6, 4 ),
    ( 6, 13 ),
    ( 6, 15 );
    
-- ----------------------------------------------------------------------------------------------------
-- Classe_Atributo ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe_Atributo
	( idClasse, idAtributo )
VALUES
	( 6, 3 ),
    ( 6, 6 );
    
-- ----------------------------------------------------------------------------------------------------
-- Classe_Pericia -------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe_Pericia
	( idClasse, idPericia )
VALUES
	( 6, 5 ),
    ( 6, 9 ),
    ( 6, 11 ),
    ( 6, 16 ),
    ( 6, 17 ),
    ( 6, 18 );
    
-- ----------------------------------------------------------------------------------------------------
-- Opção de Equipamentos Iniciais ---------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO OpcaoEquipamentosIniciais
	( idOpcaoEquipamentosIniciais, dataCriacaoOpcaoEquipamentoInicial, OpcaoEquipamentoInicialAtiva )
VALUES
	-- Classe
		-- Feiticeiro
	( null, CURDATE(), 1 ),	-- 1
    ( null, CURDATE(), 1 ),	-- 2
    ( null, CURDATE(), 1 ),	-- 3
    ( null, CURDATE(), 1 ),	-- 4
    ( null, CURDATE(), 1 ),	-- 5
    ( null, CURDATE(), 1 ),	-- 6
    ( null, CURDATE(), 1 ),	-- 7
    
    -- Background
		-- Acólito
    ( null, CURDATE(), 1 );	-- 8
    
-- ----------------------------------------------------------------------------------------------------
-- OpcaoEquipamentosIniciais_Arma ---------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO OpcaoEquipamentosIniciais_Arma
	( idOpcaoEquipamentosIniciais, idArma )
VALUES
	-- Feiticeiro
	( 1, 13 ),
    ( 1, 2 ),
    
    ( 2, 2 ),
    
    ( 3, 13 ),
    ( 3, 2 ),
    
    ( 4, 13 ),
    ( 4, 2 ),
    
    ( 5, 2 ),
    
    ( 6, 13 ),
    ( 6, 2 ),
    
    ( 7, 2 );

-- ----------------------------------------------------------------------------------------------------
-- OpcaoEquipamentosIniciais_EquipamentoAventura ------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO OpcaoEquipamentosIniciais_EquipamentoAventura
	( idOpcaoEquipamentosIniciais, idEquipamentoAventura )
VALUES
    ( 1, 8 ),
    ( 1, 11 ),
    
    ( 2, 8 ),
    ( 2, 11 ),
    
    ( 3, 9 ),
    ( 3, 11 ),
    
    ( 4, 8 ),
    ( 4, 10 ),
    
    ( 5, 9 ),
    ( 5, 11 ),
    
    ( 6, 9 ),
    ( 6, 10 ),
    
    ( 7, 9 ),
    ( 7, 10 );
    
-- ----------------------------------------------------------------------------------------------------
-- Classe_OpcaoEquipamentosIniciais -------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe_OpcaoEquipamentosIniciais
	( idClasse, idOpcaoEquipamentosIniciais )
VALUES
	( 6, 1 ),
    ( 6, 2 ),
    ( 6, 3 ),
    ( 6, 4 ),
    ( 6, 5 ),
    ( 6, 6 ),
    ( 6, 7 );

-- ----------------------------------------------------------------------------------------------------
-- Classe_Feature -------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe_Feature
	( idClasse, idFeature )
VALUES
	( 6, 1 ),
    ( 6, 2 ),
    ( 6, 3 ),
    ( 6, 4 ),
    ( 6, 5 );

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da SubClasse -------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemSubClasse
	( idImagemSubClasse,caminhoImagemSubClasse,descricaoImagemSubClasse,dataCriacaoImagemSubClasse,imagemSubClasseAtiva )
VALUES
	-- Imagem Padrão
	( null,"/img/icone","Imagem Padrão",CURDATE(), 1 ),
    
	-- Imagens Subclasses Bárbaro
	( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Bardo
    ( null,"/img/icone","Imagem ", CURDATE(), 1 ),
    
    -- Imagens Subclasses Bruxo
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Clérigo
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Druida
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Feiticeiro
    ( null,"/img/iconeFeiticeiroAlmaDivina.jpg","Imagem Feiticeiro - Alma Divina",CURDATE(), 1 ),
    
    -- Imagens Subclasses Guardião
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Guerreiro
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Ladino
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Mago
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Monge
    ( null,"/img/icone","Imagem ",CURDATE(), 1 ),
    
    -- Imagens Subclasses Paladino
    ( null,"/img/icone","Imagem ",CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- SubClasse ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubClasse
	( idSubClasse, idClasse, idImagemSubClasse, nomeSubClasse, descricaoSubClasse, quantFeaturesSubClasse, dataCriacaoSubClasse, subClasseAtiva )
VALUES
	-- SubClasses Feiticeiro
	( null, 6, 7, "Alma Divina", "A sua magia inata vem da conexão com uma divindade, que lhe escolheu como seu agente.", 5, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- SubClasse_Feature ----------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubClasse_Feature
	( idSubClasse, idClasse, idFeature )
VALUES
	( 1, 6, 6 ),
    ( 1, 6, 7 ),
    ( 1, 6, 8 ),
    ( 1, 6, 9 ),
    ( 1, 6, 10 );
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Raça ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemRaca
	( idImagemRaca, caminhoImagemRaca, descricaoImagemRaca, dataCriacaoImagemRaca, imagemRacaAtiva )
VALUES
	-- Imagem Padrão
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 ),
    
    -- Imagens Raças
    ( null, "/img/aasimarIcon.jpg", "Imagem Aasimar", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Raca ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Raca
	( idRaca, idImagemRaca, nomeRaca, descricaoRaca, valorBuffAtributoRaca, idAtributoBuffadoRaca, idadeMaxRaca, tamanhoRaca, velocidadeRaca, quantLinguagensRaca, quantFeaturesRaca, dataCriacaoRaca, racaAtiva )
VALUES
	( null, 2, "Aasimar", "Descendentes de criaturas celestiais, Aasimares parecem humanos gloriosos e heroicos. Aasimares costumam tentar disfarçar sua linhagem para enfrentar o mal sem chamar atenção.", 2, 6, 120, "Médio", 9, 2, 4, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Raça_Linguagem -------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Raca_Linguagem
	( idRaca, idLinguagem )
VALUES
	(1, 1),
    (1, 2);

-- ----------------------------------------------------------------------------------------------------
-- Raça_Feature ---------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Raca_Feature
	( idRaca, idFeature )
VALUES
	(1, 11),
    (1, 12),
    (1, 13),
    (1, 14);
    
-- ----------------------------------------------------------------------------------------------------
-- SubRaca ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubRaca
	( idSubRaca, idRaca, nomeSubRaca, descricaoSubRaca, valorBuffAtributoSubRaca, idAtributoBuffadoSubRaca, quantFeaturesSubRaca, dataCriacaoSubRaca, subRacaAtiva )
VALUES
	( null, 1, "Protetor", "", 1, 5, 1, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- SubRaça_Feature ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubRaca_Feature
	( idSubRaca, idRaca, idFeature )
VALUES
	(1, 1, 15);
    
-- ----------------------------------------------------------------------------------------------------
-- Background ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Background
	( idBackground, nomeBackground, descricaoBackground, ouroInicialBackground, quantOpcoesEquipamentosIniciaisBackground, quantLinguagensIniciaisBackground, quantProficienciasFerramentasBackground, quantProficienciasPericiasBackground, quantFeaturesBackground, dataCriacaoBackground, BackgroundAtivo )
VALUES
	( null, "Acólito", "Você passou sua vida em serviço de um templo. Você age como um intermediário entre o reino do sagrado e do mundo mortal, fazendo ritos sagrados e oferecendo sacrifícios para guiar os fieis à presença do divino. Acólito e clérigo não são a mesma coisa: Um milagreiro andarilho pode ser respeitado como canalizador do divino, mas não ter nenhuma autoridade na religião.", 15, 5, 2, 0, 2, 1, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Background_Pericia ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Background_Pericia
	( idBackground, idPericia )
VALUES
	( 1, 9 ),
    ( 1, 11 );
-- ----------------------------------------------------------------------------------------------------
-- Background_Feature ---------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
    
INSERT INTO Background_Feature
	( idBackground, idFeature )
VALUES
	( 1, 16 );
    
-- ----------------------------------------------------------------------------------------------------
-- OpcaoEquipamentosIniciais_EquipamentoAventura ------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO OpcaoEquipamentosIniciais_EquipamentoAventura
	( idOpcaoEquipamentosIniciais,idEquipamentoAventura )
VALUES
	( 8, 4 ),
    ( 8, 5 ),
    ( 8, 12 ),
    ( 8, 13 ),
    ( 8, 14 ),
    ( 8, 15 ),
    ( 8, 16 );

-- ----------------------------------------------------------------------------------------------------
-- Background_OpcaoEquipamentosIniciais ------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Background_OpcaoEquipamentosIniciais
	( idBackground, idOpcaoEquipamentosIniciais )
VALUE
	( 1, 8 );
    
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão do Usuario ---------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemUsuario
	( idImagemUsuario, caminhoImagemUsuario, descricaoImagemUsuario, dataCriacaoImagemUsuario, imagemUsuarioAtiva )
VALUES
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Tipos de Usuario ------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO TipoUsuario
	( idTipoUsuario, nomeTipoUsuario, descricaoTipoUsuario, dataCriacaoTipoUsuario, tipoUsuarioAtivo )
VALUES
	( null, "Admin", "Gerenciamento e manutenção", CURDATE(), 1 ),
	( null, "Jogador", "Fichas, entrar em salas e campanhas.", CURDATE(), 1 ),
	( null, "Game Master", "Salas e campanhas", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão do Personagem ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemPersonagem
	( idImagemPersonagem, caminhoImagemPersonagem, descricaoImagemPersonagem, dataCriacaoImagemPersonagem, imagemPersonagemAtiva )
VALUES
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------