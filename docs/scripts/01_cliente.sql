CREATE DATABASE IF NOT EXISTS btg_plus;
USE btg_plus;
CREATE TABLE IF NOT EXISTS CLIENTE (
  nome_completo VARCHAR(100) NOT NULL,
  dt_nascimento DATE NOT NULL,
  estado_civil ENUM(
    'solteiro',
    'casado',
    'separado',
    'divorciado',
    'viuvo'
  ) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  email VARCHAR(100) NOT NULL,
  num_telefone VARCHAR(11) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  bairro VARCHAR(200) NOT NULL,
  numero INT NOT NULL,
  complemento VARCHAR(200),
  estado CHAR(2) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  CONSTRAINT CLIENTE_PK PRIMARY KEY(cpf),
  CONSTRAINT email_CLIENTE_UK UNIQUE KEY(email),
  CONSTRAINT num_telefone_CLIENTE_UK UNIQUE KEY(num_telefone)
) engine = innoDB;
