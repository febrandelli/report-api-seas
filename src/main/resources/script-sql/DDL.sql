CREATE TABLE usuario
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(75) NOT NULL,
    senha VARCHAR(75) NOT NULL,
    email VARCHAR(75) NOT NULL,
    nome_completo VARCHAR(75) NOT NULL
);

CREATE TABLE perfil
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hierarquia VARCHAR(75) DEFAULT NULL
);

CREATE TABLE motivos
(
    id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(75) DEFAULT NULL
);

CREATE TABLE cor
(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(75) DEFAULT NULL
);

CREATE TABLE sexo
(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(75) DEFAULT NULL
);

CREATE TABLE estados
(
    id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(75) DEFAULT NULL,
    uf   VARCHAR(5)  DEFAULT NULL
);

CREATE TABLE cidades
(
    id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(120) DEFAULT NULL,
    id_estado INT          DEFAULT NULL
);

create table usuario_perfil
(
    id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    perfil_id  INT NOT NULL
);

create table cidadao_motivo
(
    id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cidadao_id INT NOT NULL,
    motivo_id  INT NOT NULL
);

CREATE TABLE cidadao_beneficio
(
    id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cidadao_id   int not null,
    beneficio_id int not null
);

CREATE TABLE cidadao_caso_especial
(
    id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cidadao_id       INT NOT NULL,
    caso_especial_id INT NOT NULL
);

create table cidadao
(
    id                 INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome               VARCHAR(255) NOT NULL,
    data_nascimento    DATE         NOT NULL,
    id_sexo            INT          NOT NULL,
    id_cor             INT          NOT NULL,
    id_cidade          INT          NOT NULL,
    id_principal_renda INT          NOT NULL,
    deseja_sair_rua       BOOL         NOT NULL,
    precisa_para_sair_rua TEXT      NOT NULL
);

CREATE TABLE beneficio
(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(75)
);

CREATE TABLE casos_especiais
(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(75)
);

CREATE TABLE fonte_renda
(
    id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(75)
);

CREATE TABLE questionario
(
    id               INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dt_insert        TIMESTAMP    NOT NULL,
    dt_update        TIMESTAMP,
    local            VARCHAR(255) NOT NULL,
    id_cidadao       INT          NOT NULL,
    id_cidade_origem INT          NOT NULL,
    motivo_abordagem VARCHAR(50),
    numero_chamado INT,
    tempo_jundiai    INT,
    tempo_situacao_de_rua   INT,
    observacao TEXT,
    qt_pessoas_abordadas INT,
    orientacao TEXT,
    encaminhamento TEXT
);

CREATE TABLE servico
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeclatura VARCHAR(255) NOT NULL,
);

CREATE TABLE questionario_servico
(
    id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    questionario_id INT NOT NULL,
    servico_id      INT NOT NULL
);

CREATE TABLE questionario_usuario
(
    id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    questionario_id INT NOT NULL,
    usuario_id      INT NOT NULL
);


ALTER TABLE cidades
    ADD FOREIGN KEY (id_estado)
        REFERENCES estados (id);

ALTER TABLE cidadao_motivo
    ADD FOREIGN KEY (motivo_id)
        REFERENCES motivos (id);

ALTER TABLE cidadao
    ADD FOREIGN KEY (id_sexo)
        REFERENCES sexo (id);

ALTER TABLE cidadao
    ADD FOREIGN KEY (id_cor)
        REFERENCES cor (id);

ALTER TABLE cidadao
    ADD FOREIGN KEY (id_cidade)
        REFERENCES cidades (id);

ALTER TABLE cidadao
    ADD FOREIGN KEY (id_principal_renda)
        REFERENCES fonte_renda (id);

ALTER TABLE questionario
    ADD FOREIGN KEY (id_cidade_origem)
        REFERENCES cidades (id);

ALTER TABLE questionario
    ADD FOREIGN KEY (id_cidadao)
        REFERENCES cidadao (id);