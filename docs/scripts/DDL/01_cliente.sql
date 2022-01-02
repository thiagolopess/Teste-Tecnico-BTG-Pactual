
-- Cria tabela `cliente` (DDL)
CREATE TABLE cliente (
  nome_completo VARCHAR(255) NOT NULL,
  dt_nascimento DATE NOT NULL,
  sexo ENUM('MASCULINO', 'FEMININO') NOT NULL,
  estado_civil ENUM('SOLTEIRO', 'CASADO', 'DIVORCIADO', 'VIUVO') NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  email VARCHAR(255) NOT NULL,
  celular VARCHAR(11) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  logradouro VARCHAR(255) NOT NULL,
  bairro VARCHAR(255) NOT NULL,
  numero INT NOT NULL,
  complemento VARCHAR(255),
  estado VARCHAR(2) NOT NULL,
  cidade VARCHAR(255) NOT NULL,
  CONSTRAINT CLIENTE_PK PRIMARY KEY(cpf),
  CONSTRAINT email_CLIENTE_UK UNIQUE KEY(email),
  CONSTRAINT celular_CLIENTE_UK UNIQUE KEY(celular)
) engine = innoDB;
