CREATE TABLE IF NOT EXISTS conta (
  num_conta BIGINT NOT NULL AUTO_INCREMENT,
  agencia INT NOT NULL,
  saldo DECIMAL(10, 2) NOT NULL DEFAULT 0,
  dt_abertura DATE NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  CONSTRAINT conta_pk PRIMARY KEY(num_conta),
  CONSTRAINT conta_cliente_fk FOREIGN KEY(cpf) REFERENCES cliente(cpf)
) engine = innoDB AUTO_INCREMENT = 1;
