
CREATE TABLE local (
  id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  predio varchar(45) NOT NULL,
  sala varchar(45) NOT NULL,
  capacidade varchar(45) NOT NULL
);

CREATE TABLE palestra (
id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  titulo varchar(45) NOT NULL,
  dataHora date NOT NULL,
  duracao int(11) NOT NULL,
  local_id int(11) NOT NULL,
CONSTRAINT fk_palestra_local FOREIGN KEY(local_id) REFERENCES local(id)
); 


CREATE TABLE palestrante (
  id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nome varchar(45) NOT NULL,
  miniBio varchar(45) NOT NULL,
  palestra_id int(11) NOT NULL,
  CONSTRAINT fk_palestrante_palestra FOREIGN KEY (palestra_id) REFERENCES palestra (id) 
  ON DELETE NO ACTION 
  ON UPDATE NO ACTION
) 