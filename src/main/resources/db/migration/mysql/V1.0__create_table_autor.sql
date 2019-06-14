CREATE TABLE autor (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	nome varchar(100) NOT NULL,
	data_nascimento datetime NULL,
	biografia MEDIUMTEXT null,
	data_criacao datetime NOT NULL,
	data_atualizacao datetime NOT NULL,
    PRIMARY KEY (id)
);