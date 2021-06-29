/************************************************************
*	Grupo: 4    |  Curso: «Informática de Gestão»
*  	UC: «Bases de Dados»
*
*	Pojeto: «Go Play»
*
*  	Nome: «Francisco Cabreiro» (20200538)
*  	Nome: «Gonçalo Oliveira» (20201007)
*	Nome: «Márk Leite» (20200825)
*
************************************************************/



-- Mostra a classificacao de um jogador num torneio
SELECT class_Torn AS Classificacao, CONCAT(Jog_NomeP, '  ' , Jog_NomeA) AS 'Nome', CP_Freguesia AS 'Local'
FROM Classificacao INNER JOIN Jogador ON Class_id=Jog_id
				   INNER JOIN CodPostal ON Class_Id=CP_Id;


-- Jogadores com pontos entre 0 e 20
SELECT  CP_Freguesia AS 'Local', CONCAT(Jog_NomeP, '  ' , Jog_NomeA) AS 'Nome', Rank_Pontos AS 'Pontos'
FROM Jogador INNER JOIN CodPostal ON Jog_ID=CP_JogID
			 INNER JOIN Ranking ON Jog_Id=Rank_JogId
WHERE Rank_Pontos > 0 AND Rank_Pontos <= 20;

-- Torneios realizados so em Lisboa
SELECT Torn_Data AS 'Data Torneio', Arb_Nome AS 'Nome do Arbitro', TP_nome AS 'Tipo de Jogo', CP_Freguesia AS 'Local'
FROM TipoJogo INNER JOIN Arbitro ON TP_ID=Arb_ID
			  RIGHT JOIN Torneio ON TP_ID=Torn_ID
              LEFT JOIN CodPostal ON Torn_ID=CP_ID
WHERE CP_Freguesia = 'Lisboa';

-- O jogador com mais pontos na aplicacao
SELECT Rank_Pontos AS 'Pontos', CONCAT(Jog_NomeP, '  ' , Jog_NomeA) AS 'Nome'
FROM Jogador INNER JOIN Ranking ON Jog_ID=Rank_JogID
WHERE Rank_Pontos = (SELECT MAX(Rank_Pontos) FROM Ranking);


-- O local com mais torneios 
SELECT  CP_Freguesia AS 'Local', TP_Nome AS 'Tipo Jogo'
FROM Tipojogo INNER JOIN Torneio ON TP_Id=Torn_ID
			 INNER JOIN CodPostal ON Torn_ID=CP_TornID
WHERE CP_ID in (
	SELECT CP_TornID
	FROM CodPostal
    GROUP BY CP_TornID 
    HAVING COUNT(*) = (SELECT MAX(Total) 
						FROM (SELECT COUNT(*) AS Total FROM CodPostal GROUP BY CP_TornID) A));
             
-- O torneio com mais particpantes                        
SELECT  CP_Freguesia AS 'Local', Torn_Data AS 'Data', MAX(Torn_Jogadores) AS 'Numero de jogadores', TP_Nome AS 'Tipo de jogo'
FROM Torneio INNER JOIN TipoJogo ON Torn_TP_ID=TP_ID
			 INNER JOIN CodPostal ON Torn_ID=CP_ID;
             
-- Adiciona uma Coluna temporaria de teste a tabela tipoJogo          
ALTER TABLE TipoJogo
ADD Coluna_Temp varchar(255);

-- Altera o tipo de dados na coluna temporaria criada anteriormente
ALTER TABLE TipoJogo
MODIFY COLUMN Coluna_Temp int;

-- Remove a coluna temporaria
ALTER TABLE TipoJogo
DROP COLUMN Coluna_Temp;

-- Estes 4 Updates Validao a nossa RI07
UPDATE classificacao 
set Class_Pontos = class_pontos + 10
where Class_Torn= 1;

UPDATE classificacao 
set Class_Pontos = class_pontos + 5
where Class_Torn= 2;

UPDATE classificacao 
set Class_Pontos = class_pontos + 3
where Class_Torn= 3;

UPDATE classificacao 
set Class_Pontos = class_pontos + 1;

-- Este select serve para mostrar o que foi atualizado com os ultmios 4 updates
select Class_Torn as 'Classsificacao no torneio', Class_Pontos as Pontos, Torn_Data as 'Data torneio', Torn_TipoJogo as 'Tipo Jogo', CP_Freguesia as 'Local' 
from Torneio inner join classificacao on Torn_Id=Class_Id
             inner join CodPostal on Torn_Id=CP_JogID;


-- Estes 3 updates servem para validar a nossa RI06
UPDATE Jogador 
set Jog_Pontos = Jog_pontos + 3
where Jog_Vitoria = true;

UPDATE Jogador 
set Jog_Pontos = Jog_pontos + 2
where Jog_Empate = true;

UPDATE Jogador 
set Jog_Pontos = Jog_pontos + 1
where Jog_Derrota = true;

-- Este select serve para mostrar o que foi atualizado com os ultmios 3 updates
SELECT Jog_Id AS 'Numero do Jogador', CONCAT(Jog_NomeP, '  ' , Jog_NomeA) AS 'Nome', timestampdiff(YEAR, Jog_DataNasc, CURDATE()) AS Idade, Jog_Genero AS Genero, Jog_Pontos AS Pontos, Jog_Vitoria AS Vitorias, Jog_Empate AS Empates, Jog_Derrota AS Derrotas
FROM Jogador;


-- Estes 3 updates servem para validar a nossa RI05
UPDATE Arbitro 
set Arb_Pontos = Arb_pontos + 3
where Arb_JogoArbitrado = true;

UPDATE Arbitro 
set Arb_Pontos = Arb_pontos + 5
where Arb_TornArbitrado = true;

UPDATE Arbitro 
set Arb_Pontos = Arb_pontos + 10
where Arb_TornOrganizado = true;

-- Este select serve para mostrar o que foi atualizado com os ultmios 3 updates
SELECT Arb_ID AS 'Numero do Arbitro', Arb_Nome AS Nome, Arb_Pontos AS Pontos, Arb_JogoArbitrado AS 'Jogos Arbitrados', Arb_TornArbitrado AS 'Torneios Arbitrados', Arb_TornOrganizado AS 'Torneios Organizados' 
FROM Arbitro;

-- Esta view mostra o jogador e a mensagem que enviou
CREATE VIEW V_Msg_Priv AS 
	SELECT CONCAT(Jog_NomeP, '  ' , Jog_NomeA) AS 'Nome', Msg_Texto as Mensagem
	FROM Jogador J INNER JOIN MensagemPriv M ON J.Jog_Id=M.Msg_id;
select * from V_Msg_Priv;

-- Esta view mostra o jogador e a sua classificacao num torneio com a data e local do mesmo
CREATE VIEW V_Jog_Class_Torn AS 
	SELECT CONCAT(Jog_NomeP, '  ' , Jog_NomeA) AS 'Nome', Class_Torn AS 'Classificacao no torneio', Torn_Data AS 'Data do torneio', CP_Freguesia AS 'Local'
	FROM Jogador J INNER JOIN Classificacao C ON J.Jog_Id=C.Class_Id
				   INNER JOIN Torneio T ON J.Jog_Id=T.Torn_Id
				   INNER JOIN CodPostal CP ON J.Jog_Id=CP.CP_Id;
select * from V_Jog_Class_Torn;
             
             
             
select Jog_Id  AS id, Jog_NomeP as Nome, Jog_NomeA as Apelido, Jog_Pontos as pontos
FROM Jogador
Order by Jog_Pontos desc;


SELECT Torn_Data AS 'Data Torneio', Torn_TipoJogo AS 'Tipo de Jogo', CP_Freguesia AS 'Local', Arb_Nome as nome, Torn_Jogadores as 'Numero Jogadores'
FROM Torneio inner JOIN CodPostal ON Torn_ID=CP_Id
			 inner JOIN Arbitro ON Torn_ID=Arb_Id
              
WHERE timestampdiff(day, Torn_Data, CURDATE()) < 0
AND Torn_Jogadores < 30;


    INSERT INTO Jogo VALUES
	(NULL, 1, "2021/09/15", 1, "", 1);
    

SELECT Jogo_Id as id, Jogo_Data as "data", Jogo_Adversario as Adversario, CP_Freguesia as 'Local'
FROM Jogo INNER JOIN CodPostal ON Jogo_Id=CP_Id

WHERE timestampdiff(day, Jogo_Data, CURDATE()) < 0
AND Jogo_Adversario= '';
             
             