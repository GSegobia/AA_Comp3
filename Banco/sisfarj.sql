create table permissao (
	id SERIAL primary key,
	nome text not null
);

insert into permissao (nome) values ('Diretor Tecnico');
insert into permissao (nome) values ('Tecnico Associacao');
insert into permissao (nome) values ('Secretario');

create table genero (
	id serial primary key,
	nome text not null
);

insert into genero (nome) values ('Masculino');
insert into genero (nome) values ('Feminino');

create table usuario (
	id SERIAL primary key,
	nome text not null,
	email text not null,
	senha text not null,
	permissao_id integer references permissao
);

insert into usuario (nome,email,senha,permissao_id) values ('Diretor Padrão','diretor@sisfarj.com','123456',1);
insert into usuario (nome,email,senha,permissao_id) values ('Tecnico Associacao RJ','tecnico-rj@sisfarj.com','123456',2);
insert into usuario (nome,email,senha,permissao_id) values ('Tecnico Associacao SP','tecnico-sp@sisfarj.com','123456',2);
insert into usuario (nome,email,senha,permissao_id) values ('Secretario Padrão','secretario@sisfarj.com','123456',3);

create table classe_atleta (
	id serial primary key,
	nome text not null
);

insert into classe_atleta (nome) values ('Mirim');
insert into classe_atleta (nome) values ('Mirim I/II');
insert into classe_atleta (nome) values ('Petiz I-II');
insert into classe_atleta (nome) values ('Infantil I-II');
insert into classe_atleta (nome) values ('Juvenil I-II');
insert into classe_atleta (nome) values ('Junior I/II');
insert into classe_atleta (nome) values ('Sênior');
insert into classe_atleta (nome) values ('Master');

create table associacao (
	id serial primary key,
	data_criacao date default now(),
	nome text not null,
	sigla text not null,
	endereco text not null,
	telefone text not null,
	numero_comprovante_pag text not null,
	tecnico_id integer references usuario
);

insert into associacao(nome,sigla,endereco,telefone,numero_comprovante_pag,tecnico_id) values (
	'Fundacao de Natacao do Rio de Janeiro',
	'FNRJ',
	'Rua das Couves, 18',
	'21998744578',
	'55555555',
	2
);

insert into associacao(nome,sigla,endereco,telefone,numero_comprovante_pag,tecnico_id) values (
	'Fundacao de Natacao de São Paulo',
	'FNSP',
	'Rua de Sampa, 18',
	'21998744578',
	'66666666',
	1
);

create table atleta (
	id SERIAL primary key,
	matricula text not null,
	sexo_atleta integer references genero not null,
	nome text not null,
	data_nascimento date not null,
	classe_atleta_id integer references classe_atleta,
	atleta_associacao_id integer references associacao
);

create table atleta_associacao (
	id serial primary key,
	associacao_id integer references associacao,
	atleta_id integer references atleta,
	data_oficio date,
	data_entrada_associacao date,
	matricula_associacao text,
	numero_comprovante_pagamento text
);

