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
	VALUES (1, 'teste', 'Sr. Diretor Técnico', 'teste', 1);

INSERT INTO public.endereco(
	cep, rua, numero, cidade, estado, complemento)
	VALUES ('teste', 'Rua teste', 2392, 'Cidade Teste', 'AC', 'Complemento teste');

INSERT INTO public.associacao(
	id, numero_oficio, data_oficio, nome, sigla, matricula, endereco_id, telefone, num_comprovante_pgto)
	VALUES (1, 'n_oficio_teste', now(), 'nome teste', 'sigla', '12838128', 1, '99999-9999', '546455646');

insert into public.atleta(
	matricula,nome,associacao_id,data_nascimento,data_entrada_associacao,data_oficio,categoria_id,numero_oficio)
	values (1,'Atleta da Silva',1,'01-01-1955',now(),'06-06-2012',2,'123456789012345');
commit;
