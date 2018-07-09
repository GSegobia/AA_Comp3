begin;

create table permissao(
	id serial primary key,
	nome varchar not null
);

create table categoria(
	id serial primary key,
	nome varchar(20) not null
);

create table usuario(
	id serial primary key,
	matricula varchar(20) unique not null,
	nome varchar(100) not null,
	senha varchar(50) not null,
	permissao_id int not null references permissao(id) 
);

create table endereco(
	id serial primary key,
	cep varchar(8) not null,
	rua varchar(50) not null,
	numero int not null,
	cidade varchar(30) not null,
	estado varchar(30) not null,
	complemento varchar(100)
);

create table associacao(
	id serial primary key,
	numero_oficio varchar(15) unique not null,
	data_oficio date not null,
	nome varchar(50) unique not null,
	sigla varchar(10) unique not null,
	matricula varchar(20) unique not null,
	endereco_id int not null references endereco(id),
	telefone varchar(15) not null,
	num_comprovante_pgto varchar(15) not null
);

create table atleta(
	id serial primary key,
	matricula varchar(20) unique not null,
	nome varchar(50) not null,
	associacao_id int not null references associacao(id),
	data_nascimento date not null,
	data_entrada_associacao date not null,
	data_oficio date not null,
	categoria_id int not null references categoria(id),
	numero_oficio varchar(15) not null
);

create table classe(
	id serial primary key,
	nome varchar(30) not null
);

create table centro_aquatico(
	id serial primary key,
	nome varchar(50) unique not null,
	endereco_id int not null references endereco(id)
);

create table piscina(
	id serial primary key,
	tamanho int unique not null
);

create table competicao(
	id serial primary key,
	nome varchar(50) not null,
	centro_aquatico_id int not null references centro_aquatico(id),
	data_competicao timestamp not null,
	piscina_id int not null references piscina(id)
);

create table prova(
	id serial primary key,
	nome varchar(30) not null,
	classe_id int not null references classe(id),
	categoria_id int not null references categoria(id),
	competicao_id int not null references competicao(id)
);

create table resultado_provas(
	id serial primary key,
	tempo int not null,
	prova_id int not null references prova(id),
	atleta_id int not null references atleta(id)
);

create table centro_aquatico_piscina(
	id_centro_aquatico int not null references centro_aquatico(id),
	id_piscina int not null references piscina(id)
);

create table prova_atleta(
	id_prova int not null references prova(id),
	id_atleta int not null references atleta(id)
);

commit;