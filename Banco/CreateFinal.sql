begin;

create table categoria(
	id serial primary key,
	nome varchar(20) not null
);  
	  
create table associacao(
	id serial primary key,
	nome varchar(50) unique not null,
	sigla varchar(10) unique not null,
	matricula varchar(20) unique not null,
	senha varchar(50) not null,
	endereco varchar(100) not null,
	telefone varchar(15) not null,
	numero_oficio varchar(15) unique not null,
	data_oficio date not null,
	num_comprovante_pgto varchar(15) not null
);

create table atleta(
	id serial primary key,
	nome varchar(50) not null,
	data_nascimento date not null,
	matricula varchar(20) unique not null,
	associacao_id int not null references associacao(id),
	data_entrada_associacao date not null,
	categoria_id int not null references categoria(id),
	numero_oficio varchar(15) not null,
	data_oficio date not null
);

create table classe(
	id serial primary key,
	nome varchar(30) not null
);
	  
create table centro_aquatico(
	id serial primary key,
	nome varchar(50) unique not null,
	endereco varchar(100) not null,
	tamanho_piscina int not null
);

create table competicao(
	id serial primary key,
	nome varchar(50) not null,
	centro_aquatico_id int not null references centro_aquatico(id),
	data_competicao timestamp not null,
	tamanho_piscina int not null
);

create table prova(
	id serial primary key,
	nome varchar(30) not null,
	classe_id int not null references classe(id),
	categoria_id int not null references categoria(id)
);

create table competicao_prova(
	id serial primary key,
	id_prova int not null references competicao(id),
	id_atleta int not null references prova(id)
);

create table resultado_provas(
	id serial primary key,
	tempo int not null,
	prova_id int not null references competicao_prova(id),
	atleta_id int not null references atleta(id)
);

create table prova_atleta(
	id serial primary key,
	id_prova int not null references competicao_prova(id),
	id_atleta int not null references atleta(id)
);

insert into categoria (nome)
values ('Feminino'),
	   ('Masculino');

insert into classe(nome)
values ('Mirim'),
	   ('Mirim I'),
	   ('Mirim II'),
	   ('Petiz I'),
	   ('Petiz II'),
	   ('Infantil I'),
	   ('Infantil II'),
	   ('Juvenil I'),
	   ('Juvenil II'),
	   ('Junior I'),
	   ('Junior II'),
	   ('Senior'),
	   ('Master');
	  
INSERT INTO public.associacao(
	nome, sigla, matricula, senha, endereco, telefone, numero_oficio, data_oficio, num_comprovante_pgto)
	VALUES ('Associação Principal', 'AP', 'teste', '123456', 'Rua 3', '999999999', '000000001', now(), '000000001');
	  
end;