alter table competicao drop column piscina_id;

drop table centro_aquatico_piscina;
drop table piscina;

alter table competicao add column tamanho_piscina int not null;
alter table centro_aquatico add column tamanho_piscina int not null;

alter table atleta add column num_comprovante_pgto varchar(20);

create table competicao_prova(
	id serial primary key,
	id_prova int not null references competicao(id),
	id_atleta int not null references prova(id)
);

alter table prova_atleta add column id serial primary key;

