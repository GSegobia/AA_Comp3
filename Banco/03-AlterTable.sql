alter table associacao drop column endereco_id;
alter table centro_aquatico drop column endereco_id;

drop table endereco;

alter table associacao add column endereco varchar(100) not null;
alter table centro_aquatico add column endereco varchar(100) not null;
