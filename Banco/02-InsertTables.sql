begin;

insert into piscina (tamanho)
values (25),
	   (50);

insert into categoria (nome)
values ('Feminino'),
	   ('Masculino');

insert into permissao (nome)
values ('Diretor Técnico'),
	   ('Técnico Associação'),
	   ('Secretário');

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
	   ('Sênior'),
	   ('Master');

INSERT INTO usuario(id, matricula, nome, senha, permissao_id)
	VALUES (1, 'teste', 'Sr. Diretor TÃ©cnico', 'teste', 1);

commit;