package btg.testetecnico.api.conta;

import btg.testetecnico.api.cliente.Cliente;
import btg.testetecnico.api.movimentacao.Movimentacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cpf", referencedColumnName = "cpf")
	private Cliente cliente;

	@JsonIgnore
	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
	private List<Movimentacao> movimentacoes;
}
