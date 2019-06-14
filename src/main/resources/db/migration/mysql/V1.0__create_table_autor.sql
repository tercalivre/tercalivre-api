CREATE TABLE autor (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	nome varchar(100) NOT NULL,
	data_nascimento DATETIME NULL,
	biografia TEXT NULL,
	data_criacao DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
    PRIMARY KEY (id)
);