create table competicao_prova(
	id serial primary key,
	id_prova int not null references competicao(id),
	id_atleta int not null references prova(id)
);

alter table prova_atleta add column id serial primary key;
