ALTER TABLE resultado_provas
ALTER COLUMN tempo TYPE varchar(20);
ALTER TABLE resultado_provas
ADD pontuacao varchar(20) NOT NULL;
ALTER TABLE atleta
ADD num_comprovante_pgto VARCHAR(15) NOT NULL;
