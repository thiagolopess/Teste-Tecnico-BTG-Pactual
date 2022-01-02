CREATE TABLE IF NOT EXISTS movimentacao (
  id BIGINT NOT NULL AUTO_INCREMENT,
  valor DECIMAL(10, 2) NOT NULL,
  dt_hora DATETIME NOT NULL,
  tipo ENUM('SAQUE', 'DEPOSITO') NOT NULL,
  num_conta BIGINT NOT NULL,
  CONSTRAINT MOVIMENTACAO_PK PRIMARY KEY(id),
  CONSTRAINT MOVIMENTACAO_CONTA FOREIGN KEY(num_conta) REFERENCES conta(num_conta)
) engine = innoDB AUTO_INCREMENT = 1;

DELIMITER $$

CREATE TRIGGER before_movimentacao_insert
BEFORE INSERT
ON movimentacao FOR EACH ROW
BEGIN
    DECLARE saldo DECIMAL(10, 2);

    SELECT c.saldo
    INTO saldo
    FROM conta c
    WHERE c.num_conta = NEW.num_conta;


    IF NEW.tipo = 'DEPOSITO' THEN
        UPDATE conta
        SET saldo = saldo + NEW.valor
        WHERE num_conta = NEW.num_conta;
    ELSEIF NEW.tipo = 'SAQUE' THEN
        IF saldo < NEW.valor THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Saldo insuficiente';
        ELSE
            UPDATE conta
            SET saldo = saldo - NEW.valor
            WHERE num_conta = NEW.num_conta;
        END IF;
    END IF;

END $$

DELIMITER;
