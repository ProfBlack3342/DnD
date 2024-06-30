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
	( null, "STR", "Força", CURDATE(), 1 ),
    ( null, "DEX", "Destreza", CURDATE(), 1 ),
    ( null, "CON", "Constituição", CURDATE(), 1 ),
    ( null, "INT", "Inteligência", CURDATE(), 1 ),
    ( null, "WIS", "Sabedoria", CURDATE(), 1 ),
    ( null, "CHA", "Carisma", CURDATE(), 1 );

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
    
    ( null, 1, "Adaga", 0, 0, 0, 2, 0, 1, 4, 9, 0.5, 3, CURDATE(), 1 ),
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
    ( null, 1, "Beste Leve", "", 0, 0, 0, 25, 0, 1, 8, 9, 2.5, 4, CURDATE(), 1 ),
    ( null,	1, "Dardo", "", 5, 0, 0, 0, 0, 1, 4, 9, 0.125, 3, CURDATE(),	1 ),
    ( null, 1, "Funda", "", 0, 1, 0, 0, 0, 1, 4, 2, 0.0, 2, CURDATE(), 1 ),
    
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
	( 2, 1, null, null ),
	( 2, 3, 6, 18 ),
    ( 2, 7, null, null ),
    ( idArma, idPropriedadeArma, distancaDesvantagemArma_Propriedade, distanciaFalhaArma_Propriedade );

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
	( null, 1, "Acolchoada", "", 0, 0, 0, 5, 0, 1, 0, 0, 4.0, CURDATE(), 1 ),
    ( null, 1, "Couro", "", 0, 0, 0, 10, 0, 1, 0, 0, 5.0, CURDATE(), 1 ),
    ( null, 1, "Couro Batido", "", 0, 0, 0, 45, 0, 2, 0, 0, 6.5, CURDATE(), 1 ),
    
    ( null, 2, "Gibão de Peles", "", 0, 0, 0, 10, 0, 2, 0, 0, 6.0, CURDATE(), 1 ),
    ( null, 2, "Camisão de Malha", "", 0, 0, 0, 50, 0, 3, 0, 0, 10.0, CURDATE(), 1 ),
    ( null, 2, "Brunea", "", 0, 0, 0, 50, 0, 4, 0, 1, 22.5, CURDATE(), 1 ),
    ( null, 2, "Peitoral de Aço", "", 0, 0, 0, 400, 0, 4, 0, 0, 10.0, CURDATE(), 1 ),
    ( null, 2, "Meia-Armadura", "", 0, 0, 0, 750, 0, 5, 0, 1, 20.0, CURDATE(), 1 ),
    
    ( null, 3, "Cota de Anéis", "", 0, 0, 0, 30, 0, 4, 0, 1, 20.0, CURDATE(), 1 ),
    ( null, 3, "Cota de Malha", "", 0, 0, 0, 75, 0, 6, 13, 1, 22.5, CURDATE(), 1 ),
    ( null, 3, "Cota de Talas", "", 0, 0, 0, 200, 0, 7, 15, 1, 30.0, CURDATE(), 1 ),
    ( null, 3, "Armadura de Placas", "", 0, 0, 0, 1500, 0, 8, 15, 1, 32.5, CURDATE(), 1 ),
    
    ( null, 4, "Escudo", "", 0, 0, 0, 10, 0, 2, 0, 0, 3.0, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Equipamento de Aventura ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO EquipamentoAventura
	( idEquipamentoAventura, nomeEquipamentoAventura, descricaoEquipamentoAventura, precoCobreEquipamentoAventura, precoPrataEquipamentoAventura, precoElectrumEquipamentoAventura, precoOuroEquipamentoAventura, precoPlatinaEquipamentoAventura, pesoEquipamentoAventura, dataCriacaoEquipamentoAventura, equipamentoAventuraAtivo )
VALUES
	(null, "Ábaco", "", 0, 0, 0, 2, 0, 1.0, CURDATE(), 1 ),
    ( null, "Ácido (vidro)", "", 0, 0, 0, 25, 0, 0.5, CURDATE(), 1 ),
    ( null, "", "", precoCobreEquipamentoAventura, precoPrataEquipamentoAventura, precoElectrumEquipamentoAventura, precoOuroEquipamentoAventura, precoPlatinaEquipamentoAventura, pesoEquipamentoAventura, CURDATE(), 1 );

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
    
    ( null, 2, "Conjunto de dados", "", 0, 1, 0, 0, 0, 0.0, CURDATE(), 1 ),
    ( null, 2, "Baralho", "", 0, 5, 0, 0, 0, 0.0, CURDATE(), 1 ),
    
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
	( null, "", "", featureConcedeProficienciaArma, featureConcedeProficienciaArmadura, featureConcedeProficienciaFerramenta, featureConcedeProficienciaLinguagem, featureConcedeProficienciaPericia, featureConcedeProficienciaSaveAtributo, featureConcedeSpell, CURDATE(), 1 ),
	( null, "", "", featureConcedeProficienciaArma, featureConcedeProficienciaArmadura, featureConcedeProficienciaFerramenta, featureConcedeProficienciaLinguagem, featureConcedeProficienciaPericia, featureConcedeProficienciaSaveAtributo, featureConcedeSpell, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Linguagens -----------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Linguagem
	( idLinguagem, nomeLinguagem, descricaoLinguagem, dataCriacaoLinguagem, linguagemAtiva )
VALUES
	( null, nomeLinguagem, descricaoLinguagem, CURDATE(), 1 ),
    ( null, nomeLinguagem, descricaoLinguagem, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Pericias -------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Pericia
	( idPericia, idAtributoPericia, nomePericia, descricaoPericia, dataCriacaoPericia, periciaAtiva )
VALUES
	( null, idAtributoPericia, nomePericia, descricaoPericia, CURDATE(), 1 ),
    ( null, idAtributoPericia, nomePericia, descricaoPericia, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Spells ---------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Spell
	( idSpell, nomeSpell, descricaoSpell, dadoSpell, multiplicadorDadoSpell, spellTemComponenteVerbal, spellTemcomponenteSomatico, spellTemcomponenteMaterial, dataCriacaoSpell, spellAtiva )
VALUES
	( null, nomeSpell, descricaoSpell, dadoSpell, multiplicadorDadoSpell, spellTemComponenteVerbal, spellTemcomponenteSomatico, spellTemcomponenteMaterial, CURDATE(), 1 ),
    ( null, nomeSpell, descricaoSpell, dadoSpell, multiplicadorDadoSpell, spellTemComponenteVerbal, spellTemcomponenteSomatico, spellTemcomponenteMaterial, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Classe ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemClasse
	( idImagemClasse, caminhoImagemClasse, descricaoImagemClasse, dataCriacaoImagemClasse, imagemClasseAtiva )
VALUES
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Classe ---------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Classe
	(idClasse, idImagemClasse, nomeClasse, descricaoClasse, dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva )
VALUES
	(null, 1, "Bárbaro", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Bardo", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Bruxo", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Clérigo", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Druida", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Feiticeiro", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Guardião", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Guerreiro", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Ladino", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Mago", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Monge", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva ),
	( null, 1, "Paladino", "", dadoClasse, classeTemSpells, quantProficienciasArmaduraClasse, quantProficienciasArmasClasse, quantProficienciasFerramentasClasse, quantProficienciasPericiasClasse, quantProficienciasSavesAtributosClasse, quantFeaturesClasse, dataCriacaoClasse, classeAtiva );

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da SubClasse -------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemSubClasse
	( idImagemSubClasse,caminhoImagemSubClasse,descricaoImagemSubClasse,dataCriacaoImagemSubClasse,imagemSubClasseAtiva )
VALUES
	( null,"/img/imagemPadrao.png","Imagem Padrão",CURDATE(),1 );
    
-- ----------------------------------------------------------------------------------------------------
-- SubClasse ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubClasse
	( idSubClasse, idClasse, idImagemSubClasse, nomeSubClasse, descricaoSubClasse, quantFeaturesSubClasse, dataCriacaoSubClasse, subClasseAtiva )
VALUES
	( null, 1, 1, "Alma Divina", "Sua magia inata vem da conexão com uma divindade que lhe escolheu como seu agente.", 5, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da Raça ------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemRaca
	( idImagemRaca, caminhoImagemRaca, descricaoImagemRaca, dataCriacaoImagemRaca, imagemRacaAtiva )
VALUES
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Raca ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Raca
	( idRaca, idImagemRaca, nomeRaca, descricaoRaca, valorBuffAtributoRaca, idadeMaxRaca, tamanhoRaca, velocidadeRaca, quantFeaturesRaca, quantIdiomasRaca, dataCriacaoRaca,racaAtiva )
VALUES
	( null, 1, "Aasimar", "Descendentes de criaturas celestiais, Aasimares parecem humanos gloriosos e heroicos. Aasimares costumam tentar disfarçar sua linhagem para enfrentar o mal sem chamar atenção.", 2, 120, "Médio", 9, 4, 2, CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão da SubRaça ---------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemSubRaca
	( idImagemSubRaca, caminhoImagemSubRaca, descricaoImagemSubRaca, dataCriacaoImagemSubRaca, imagemSubRacaAtiva )
VALUES
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- SubRaca ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO SubRaca
	( idSubRaca, idRaca, idImagemSubRaca, nomeSubRaca, descricaoSubRaca, valorBuffAtributoSubRaca, quantFeaturesSubRaca, dataCriacaoSubRaca, subRacaAtiva )
VALUES
	( null, 1, 1, "Protetor", "", 1, 1, CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Imagem Padrão do Background ------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO ImagemBackground
	( idImagemBackground, caminhoImagemBackground, descricaoImagemBackground, dataCriacaoImagemBackground, imagemBackgroundAtiva )
VALUES
	( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );
    
-- ----------------------------------------------------------------------------------------------------
-- Background ----------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------
INSERT INTO Background
	( idBackground, idImagemBackground, nomeBackground, descricaoBackground, dinheiroInicialBackground, quantEquipamentosIniciaisBackground, quantLinguagensIniciaisBackground, quantProficienciasFerramentasBackground, quantProficienciasPericiasBackground, quantFeaturesBackground, dataCriacaoBackground, BackgroundAtivo )
VALUES
	( null, 1, "Acólito", "Você passou sua vida em serviço de um templo. Você age como um intermediário entre o reino do sagrado e do mundo mortal, fazendo ritos sagrados e oferecendo sacrifícios para guiar os fieis à presença do divino. Acólito e clérigo não são a mesma coisa: Um milagreiro andarilho pode ser respeitado como canalizador do divino, mas não ter nenhuma autoridade na religião.", 15, 5, 2, 0, 2, 1, CURDATE(), 1 );
    

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
VALUES ( null, "/img/imagemPadrao.png", "Imagem Padrão", CURDATE(), 1 );

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
