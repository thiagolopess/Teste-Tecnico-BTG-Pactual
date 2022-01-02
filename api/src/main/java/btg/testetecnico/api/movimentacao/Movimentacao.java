package btg.testetecnico.api.movimentacao;

import btg.testetecnico.api.conta.Conta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
public class Movimentacao {

	public Movimentacao()  {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull(message = "O valor da movimentação é obrigatório")
	private Float valor;

	@Column
	private LocalDateTime dtHora = LocalDateTime.now();

	@Column(columnDefinition = "ENUM('DEPOSITO', 'SAQUE')")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo de movimentação é obrigatório")
	private TipoMovimentacao tipo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "numConta")
	private Conta conta;
}
