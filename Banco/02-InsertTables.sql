begin;

insert into piscina (tamanho)
values (25),
	   (50);

insert into categoria (nome)
values ('Feminino'),
	   ('Masculino');

insert into permissao (nome)
values ('Diretor T�cnico'),
	   ('T�cnico Associa��o'),
	   ('Secret�rio');

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
	   ('S�nior'),
	   ('Master');

INSERT INTO usuario(matricula, nome, senha, permissao_id)
	VALUES ('teste', 'Sr. Diretor Técnico', 'teste', 1);

INSERT INTO public.associacao(
	numero_oficio, data_oficio, nome, sigla, matricula, endereco, telefone, num_comprovante_pgto)
	VALUES ('n_oficio_teste', now(), 'nome teste', 'sigla', '12838128', 'Rua Da Puta Que Te Pariu', '99999-9999', '546455646');

insert into public.atleta(
	matricula,nome,associacao_id,data_nascimento,data_entrada_associacao,data_oficio,categoria_id,numero_oficio)
	values ('matricula','Atleta da Silva',1,'01-01-1955',now(),'06-06-2012',2,'123456789012345');
commit;
