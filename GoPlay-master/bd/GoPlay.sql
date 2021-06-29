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

Create database GoPlay;

use GoPlay;

/************************************************************
*  Lista de Entidades Informaconais Primarias
************************************************************/


create table TipoJogo (
	TP_ID int not null,
    TP_Nome varchar(50),
    primary key (TP_ID)
);


create table Arbitro (
	Arb_ID int not null auto_increment,
    Arb_Nome varchar(60) not null,
    Arb_Pontos int not null,
    Arb_JogoArbitrado boolean not null,
    Arb_TornArbitrado boolean not null,
    Arb_TornOrganizado boolean not null,
    Arb_Foto varbinary (1024),
    Arb_DataNasc date not null,
    primary key (Arb_ID) 
);


/************************************************************
*  Lista de Entidades Informaconais com FK
************************************************************/


create table Torneio (
	Torn_ID int not null auto_increment,
    Torn_Data date not null,
    Torn_ArbID int not null,
    Torn_Jogadores int not null,
    Torn_TipoJogo varchar(6) not null,
    Torn_TP_ID int not null,
    primary key (Torn_ID),
    CONSTRAINT FK_Arb_Torn FOREIGN KEY (Torn_ArbID) REFERENCES Arbitro(Arb_ID),
	CONSTRAINT FK_TP_Torn FOREIGN KEY (Torn_TP_ID) REFERENCES TipoJogo(TP_ID)
    ON DELETE NO ACTION
);


create table Jogador (
	Jog_ID int not null auto_increment,
    Jog_TornID int not null,
    Jog_ArbID int not null,
    Jog_NomeP varchar(60) not null,
    Jog_NomeA varchar(60) not null,
    Jog_Username varchar(60) not null,
    Jog_Password varchar(100) not null,
    Jog_Genero char(1) not null,
    Jog_DataNasc date not null,
    Jog_Contacto varchar(12),
    Jog_Pontos int not null,
    Jog_Vitoria boolean not null,
    Jog_Empate boolean not null,
    Jog_Derrota boolean not null,
    primary key (Jog_ID),
    CONSTRAINT FK_Torn_Jog FOREIGN KEY (Jog_TornID) REFERENCES Torneio(Torn_ID),
    CONSTRAINT FK_Arb_Jog FOREIGN KEY (Jog_ArbID) REFERENCES Arbitro(Arb_ID),
    CHECK (length(Jog_Contacto) >= 9)
);

create table Jogo (
	Jogo_ID int not null auto_increment,
    Jogo_TipoID int not null,
    Jogo_Data date not null,
    Jogo_JogID int not null,
    Jogo_Adversario varchar(60),
    Jogo_ArbID int not null,
    primary key (Jogo_ID),
    CONSTRAINT FK_Jog_JogoNome FOREIGN KEY (Jogo_JogID) REFERENCES Jogador(Jog_ID),
    CONSTRAINT Fk_Arb_JogoNomeArb FOREIGN KEY (Jogo_ArbID) REFERENCES Arbitro(Arb_ID),
    CONSTRAINT FK_TP_JogoTipo FOREIGN KEY (Jogo_TipoID) REFERENCES TipoJogo(TP_ID)
    ON DELETE NO ACTION
);


create table CodPostal (
	CP_ID int not null auto_increment,
    CP_4D char(4) not null,
    CP_3D char(3) not null,
    CP_Quart varchar(50) not null,
    CP_Freguesia varchar(40) not null,
    CP_JogID int not null,
    CP_JogoID int not null,
    CP_TornID int not null,
    primary key (CP_ID),
    CONSTRAINT FK_Jog_CP FOREIGN KEY (CP_JogID) REFERENCES Jogador(Jog_ID),
    CONSTRAINT FK_Jogo_CP FOREIGN KEY (CP_JogoID) REFERENCES Jogo(Jogo_ID),
    CONSTRAINT FK_Torn_CP FOREIGN KEY (CP_TornID) REFERENCES Torneio(Torn_ID)
    ON DELETE NO ACTION
);


create table MensagemPriv (
	Msg_ID int not null auto_increment,
    Msg_JogID int not null,
    Msg_Destinatario varchar(60) not null,
    Msg_Texto varchar(300) not null,
    primary key (Msg_ID),
    CONSTRAINT FK_Jog_Msg FOREIGN KEY (Msg_JogID) REFERENCES Jogador(Jog_ID)
    ON DELETE NO ACTION
);


create table Ticket (
	Tic_ID int not null auto_increment,
    Tic_JogID int not null,
    Tic_Data date not null,
	Tic_Pergunta varchar(80),
    Tic_Resposta varchar(200),
    Tic_Responsavel varchar(60) not null,
    primary key (Tic_ID),
    CONSTRAINT FK_Jog_Tic FOREIGN KEY (Tic_JogID) REFERENCES Jogador(Jog_ID)
    ON DELETE NO ACTION
);


create table Classificacao (
	Class_ID int not null auto_increment,
    Class_JogID int not null,
    Class_Torn int not null,
    Class_Pontos int default 0,
    primary key (Class_ID),
    CONSTRAINT FK_Jog_Class FOREIGN KEY (Class_JogID) REFERENCES Jogador(Jog_ID),
    CONSTRAINT FK_Torn_Class FOREIGN KEY (Class_Torn) REFERENCES Torneio(Torn_ID)
    ON DELETE NO ACTION
);


create table Ranking (
	Rank_ID int not null auto_increment,
    Rank_JogID int not null,
    Rank_Pontos int not null,
    Rank_Posicao char(7) not null,
    primary key (Rank_ID),
    CONSTRAINT FK_Jog_RankNome FOREIGN KEY (Rank_JogID) REFERENCES Jogador(Jog_ID)
    ON DELETE NO ACTION
);


create table RankingArb (
	RA_ID int not null auto_increment,
    RA_ArbID int not null,
    RA_Posicao varchar(7) not null,
    RA_PontosArb int not null,
    RA_TotalJogos int not null,
    primary key (RA_ID),
    CONSTRAINT FK_Arb_RANome FOREIGN KEY (RA_ArbID) REFERENCES Arbitro(Arb_ID)
    ON DELETE NO ACTION
);


/************************************************************
*  Lista de Entidades de Associacao 
************************************************************/


create table EnviarMsgPriv (
	EMP_ID int not null auto_increment,
    EMP_JogID int not null,
    EMP_MsgID int not null,
    EMP_Data date not null,
    primary key (EMP_ID),
    CONSTRAINT FK_EMP_JogID FOREIGN KEY (EMP_JogID) REFERENCES Jogador(Jog_ID), 
    CONSTRAINT FK_EMP_MsgID FOREIGN KEY (EMP_MsgID) REFERENCES MensagemPriv(Msg_ID)
    ON DELETE NO ACTION
);

create table Inscricao(
	Insc_Id int not null auto_increment,
    Insc_Nome varchar(60) not null,
    Insc_Apelido varchar(60) not null,
    Insc_Data date not null,
    Insc_Torneio int not null,
    primary key(Insc_Id),
	CONSTRAINT FK_Insc_Torn FOREIGN KEY (Insc_Torneio) REFERENCES Torneio(Torn_ID)); 
    



/************************************************************
*  Insert/Select/Alter/Update 
************************************************************/

INSERT INTO TipoJogo VALUES
	(1, "Sueca"),
	(2, "Xadrez"),
	(3, "Domino");

INSERT INTO Arbitro VALUES
	(NULL, "José", 0, true, false, true, NULL, "1960/06/27"),
	(NULL, "Afonso", 0, false, true, true, NULL, "1970/02/03"),
	(NULL, "Joana", 0, false, true, false, NULL, "2000/10/29"),
	(NULL, "Alexandre", 0, true, true, true, NULL, "1950/03/28"),
	(NULL, "Manuel", 0, false, false, true, NULL, "1962/02/12"),
	(NULL, "Marta", 0, true, false, true, NULL, "1943/10/18"),
    (NULL, "Gonçalo", 0, true, true, true, NULL, "2001/10/18"),
    (NULL, "Mark", 0, true, false, true, NULL, "2000/10/18"),
    (NULL, "Francisco", 0, true, false, false, NULL, "2001/10/11"),
    (NULL, "Alexandra", 0, false, false, true, NULL, "1950/10/20");

INSERT INTO Torneio VALUES 
	(NULL, "2021/04/29", 1, 10, "Sueca",1),
	(NULL, "2021/10/12", 1, 12,"Sueca",2),
	(NULL, "2021/09/14", 1, 30,"Sueca",3),
	(NULL, "2021/06/14", 2, 15,"Domino",3),
	(NULL, "2021/02/15", 2, 20,"Domino",3),
	(NULL, "2021/03/16", 2, 10,"Xadrez",2),
	(NULL, "2021/04/16", 1, 16,"Xadrez",2),
    (NULL, "2021/10/06", 3, 10,"Domino",3),
    (NULL, "2021/07/06", 1, 16,"Xadrez",2),
    (NULL, "2021/04/16", 4, 15,"Sueca",1);

INSERT INTO Jogador VALUES 
	(NULL, 1, 1, "Gonçalo", "Oliveira", "GoncOliv10", "goncaloliveira10", "M", "2001/10/20", "935600315",0, true, true, false),
	(NULL, 2, 2, "Mark", "Leite", "MarkLeite", "MarkLeite1", "M", "2002/11/20", "917496647",0, false, false, true),
	(NULL, 3, 3, "Francisco", "Cabreiro", "FranciscoCabreiro", "FranciscoCabreiro1", "M", "2002/10/10", "965727283",0, false, true, false),
	(NULL, 4, 4, "Joao", "Santos", "JoaoSantos", "JoaoSantos1", "M", "2001/08/16", "967536726",0, true, false, false),
	(NULL, 5, 5, "Alexandre", "Carlos", "Alex.Carlos", "Alexandre123", "M", "1999/02/27", "968275726",0, false, false, true),
    (NULL, 6, 6, "Joana", "Santos", "Joana.Santos", "Joana123", "F", "1940/12/07", "913765296",0, true, false, true),
    (NULL, 7, 7, "Manel", "Carlos", "Manel.Carlos", "MAnel123", "M", "1948/09/16", "968275726",0, false, true, false),
    (NULL, 8, 8, "Claudia", "Dias", "Claudia.Dias", "CladiaDias123", "F", "1960/11/17", "972638654",0, True, false, false),
    (NULL, 9, 9, "Mariana", "Oliveira", "Mariana.Oliveira", "Mariana12345", "F", "1999/02/07", "917537625",0, false, true, true),
    (NULL, 10, 10, "Alexandra", "Cardoso", "AlexandraCardoso3", "Alexandra123", "F", "1930/06/07", "968275726",0, false, false, true);

INSERT INTO Jogo VALUES
	(NULL, 1, "2021/05/15", 1, "markleite20", 1),
	(NULL, 2, "2021/06/12", 2, "FrnaciscoCabreiro1",2), 
	(NULL, 1, "2021/10/14", 3, "GoncaloOliveira",1),
	(NULL, 2, "2021/08/12", 4, "",2),
	(NULL, 3, "2021/12/05", 5, "Alexandre",3), 
	(NULL, 2, "2021/09/18", 6, "JoaoSantos",2), 
	(NULL, 3, "2021/11/08", 7, "",3), 
    (NULL, 1, "2021/10/18", 8, "",3),
    (NULL, 3, "2021/08/08", 9, "Joana",1),
    (NULL, 2, "2021/05/18", 10, "Mariana",2);

INSERT INTO CodPostal VALUES 
	(NULL, "1300", "372", "Segundo", "Vila Nova de Gaia", 1, 1, 1),
	(NULL, "1750", "405", "Alta de Lisboa", "Lisboa", 2, 1, 2),
	(NULL, "8000", "430", "Faro", "Faro", 3, 1, 3),
	(NULL, "2753", "836", "Leiria", "Leiria", 4, 2, 4),
	(NULL, "8373", "826", "Faro", "Faro", 5, 3, 3),
	(NULL, "2936", "272", "Portalegre", "Portalegre", 6, 2, 5),
	(NULL, "4003", "836", "Porto", "Porto", 7, 3, 6),
    (NULL, "1973", "923", "Faro", "Faro", 8, 3, 3),
    (NULL, "4003", "836", "Porto", "Porto", 9, 3, 6),
    (NULL, "2930", "136", "Braga", "Braga", 10, 3, 7);

INSERT INTO MensagemPriv VALUES
	(NULL, 1, "markleite20", "Mensagem de Teste"),
	(NULL, 2, "GoncaloOliveira", "Ola, tudo bem?"),
	(NULL, 3, "MarkLeite", "Ta tudo e contigo?"),
	(NULL, 4, "FranciscoCabreiro", "Temos aula onde?"),
	(NULL, 5, "Alexandre", "Tou a gostar bue desta materia"),
	(NULL, 6, "Joana", "Ja tou farto disto");

INSERT INTO Ticket VALUES 
	(NULL, 1, "2021/05/10", "Pergunta", "Resposta", "goncaloliveira10"),
	(NULL, 1, "2021/04/30", "Como faço para poder marcar um jogo?", "Boa tarde, so precisa de ir a funcionalidades de Jogador->Marcar Jogo. Obrigado por utilizar a Go Play.", "Goncalo Oliveira"),
	(NULL, 1, "2021/04/30", "Boa tarde gostaria de me canditar a arbitro, como faço?", "Boa tarde, tem de enviar a candidatura para nos conseguirmos validar se esta apto ou nao. Obrigado por usar a Go Play.", "Marl Leite"),
	(NULL, 2, "2021/04/30", "Estou a adorar a aplicacao, esta incrivel!!", "Muito obrigado pelo feedback mas esta funcionalidade serve para fazer questoes ou duvidas que tenha sobre a aplicacao. Muito obrigado por usar a go Play", "Francisco Cabreiro");

INSERT INTO Classificacao VALUES 
	(NULL, 1, 1,default),
	(NULL, 2, 2,default),
	(NULL, 3, 3,default),
	(NULL, 4, 2,default),
	(NULL, 5, 4,default),
	(NULL, 6, 2,default),
    (NULL, 7, 7,default),
    (NULL, 8, 10,default),
    (NULL, 9, 8,default),
    (NULL, 10, 1,default); 

INSERT INTO Ranking VALUES 
	(NULL, 1, 10, 1500),
	(NULL, 2, 3, 560),
	(NULL, 3, 6, 1300),
	(NULL, 4, 30, 56),
	(NULL, 5, 29, 58),
	(NULL, 6, 15, 82),
    (NULL, 7, 10, 13),
    (NULL, 8, 5, 40),
    (NULL, 9, 27, 18),
    (NULL, 10, 21, 23);
    

INSERT INTO RankingArb VALUES 
	(NULL, 1, "5", 700, 70),
	(NULL, 1, "2", 1800, 100),
	(NULL, 2, "10", 400, 15),
	(NULL, 2, "6", 600, 50),
	(NULL, 3, "1", 3000, 150),
	(NULL, 3, "3", 1400, 96),
    (NULL, 3, "5", 140, 16),
    (NULL, 3, "7", 192, 26),
    (NULL, 3, "5", 14, 2),
    (NULL, 3, "10", 12, 1);

INSERT INTO EnviarMsgPriv VALUES 
	(NULL, 1, 1, "2021/05/10"),
	(NULL, 1, 1, "2021/04/30"),
	(NULL, 2, 2, "2021/05/12"),
	(NULL, 2, 2, "2021/06/05"),
	(NULL, 3, 3, "2021/07/26"),
	(NULL, 3, 3, "2021/08/30"),
    (NULL, 4, 4, "2021/10/28"),
    (NULL, 4, 4, "2021/07/08"),
    (NULL, 5, 5, "2021/11/02"),
    (NULL, 5, 5, "2021/12/31");


INSERT INTO Inscricao VALUES
	(null, "Goncalo", "Oliveira", "2021/06/28", 1);

INSERT INTO Inscricao (Insc_Id,  Insc_Nome, Insc_Apelido, Insc_Data) 
VALUES (null, Goncalo, Oliveira, '2021/06/28');


SELECT TP_ID  as ID, TP_Nome as Tipo_Jogo FROM TipoJogo;
SELECT Arb_ID as ID, Arb_Nome as Nome, Arb_Pontos as Pontos, Arb_JogoArbitrado as Jogos_Arbitrados, Arb_TornArbitrado as Torneio_Arbitrados, Arb_TornOrganizado as Torneios_organizados, Arb_Foto as Foto, Arb_DataNasc as Data_Nascimento FROM Arbitro;
SELECT Torn_Id as ID, Torn_Data as Data, Torn_ArbID as IDArbitro, Torn_Jogadores as Jogadores, Torn_Tipojogo as TipoJogo FROM Torneio;
SELECT Jog_Id as ID, Jog_TornID as IDTorneio, Jog_ArbID as IDArbitro, Jog_NomeP as Nome_Proprio, Jog_NomeA as Apelido, Jog_Username as Username, Jog_Password as Password, Jog_Genero as Genero, Jog_DataNasc as Data_Nascimento, Jog_Contacto as Contacto, Jog_Pontos as Pontos FROM Jogador;
SELECT Jogo_ID as ID,Jogo_TipoID as IDTipo,Jogo_Data as DataJogo,Jogo_JogID as IDJogador,Jogo_Adversario as Adversario,Jogo_ArbID as ArbitroJogo FROM Jogo;
SELECT CP_ID as ID, CP_4D as 4_Digitos, CP_3D as 3_Digitos, CP_Quart as Quarteirao, CP_Freguesia as Freguesia, CP_JogID as IDJogador, CP_JogoID as IDJogo, CP_TornID as IDTorneio FROM codpostal;
SELECT Msg_ID as ID, Msg_JogID as IDJogador, Msg_Destinatario as Destintario, Msg_Texto as Texto FROM mensagempriv;
SELECT Tic_ID as ID, Tic_JogID as IDJogador, Tic_Data as Data, Tic_Pergunta as Pergunta, Tic_Resposta as Resposta, Tic_Responsavel as Responsavel FROM ticket;
SELECT Class_ID as ID, Class_JogID as IDJogador, Class_Torn as Torneio_Classificacao, Class_Pontos as Pontos FROM classificacao;
SELECT Rank_ID as ID, Rank_JogID as IDJogador, Rank_Posicao as Posicao, Rank_Pontos as Pontos_Jogador FROM ranking;
SELECT RA_ID as ID, RA_ArbID as IDArbitro, RA_Posicao as Posicao, RA_PontosArb as Pontos_Arbitro, RA_TotalJogos as Total_Jogos FROM rankingarb;
SELECT EMP_ID as ID, EMP_JogID IDJogador, EMP_MsgID as IDMensagem, EMP_Data as Data FROM enviarmsgpriv;


DROP DATABASE goplay;