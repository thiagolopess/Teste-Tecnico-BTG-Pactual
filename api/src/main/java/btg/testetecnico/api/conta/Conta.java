package btg.testetecnico.api.conta;

import btg.testetecnico.api.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Conta {
	public Conta() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numConta;

	@Column
	@NotNull(message = "A agência é obrigatória")
	private int agencia;

	@Column
	private Float saldo = 0f;

	@Column
	@NotNull(message = "A data de abertura da conta é obrigatória")
	private LocalDate dtAbertura = LocalDate.now();

	@OneToOne
	@JoinColumn(name = "cpf", referencedColumnName = "cpf")
	private Cliente cliente;

}

