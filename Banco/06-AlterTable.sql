ALTER TABLE resultado_provas
ADD tempo TYPE varchar(20);
ALTER TABLE resultado_provas
ALTER COLUMN pontuacao TYPE varchar(20);
ALTER TABLE atleta
ADD num_comprovante_pgto VARCHAR(15) NOT NULL;
