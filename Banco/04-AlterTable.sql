alter table competicao drop column piscina_id;

drop table centro_aquatico_piscina;
drop table piscina;

alter table competicao add column tamanho_piscina int not null;
alter table centro_aquatico add column tamanho_piscina int not null;