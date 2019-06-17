CREATE TABLE tags (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	artigo_id bigint(20),
	descricao varchar(100) NOT NULL,
	data_criacao DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
    PRIMARY KEY (id)
);