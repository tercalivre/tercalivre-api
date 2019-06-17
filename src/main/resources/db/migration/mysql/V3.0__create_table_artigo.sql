CREATE TABLE artigo (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	descricao TEXT NULL,
	autor_id bigint(20) NOT NULL,
	data_criacao DATETIME NOT NULL,
	data_atualizacao DATETIME NOT NULL,
    PRIMARY KEY (id),
	KEY FK_ARTIGO_AUTOR (autor_id)
);