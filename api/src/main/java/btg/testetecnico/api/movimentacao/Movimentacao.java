package btg.testetecnico.api.movimentacao;

import btg.testetecnico.api.conta.Conta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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

	@Column(columnDefinition = "DECIMAL(10, 2)")
	@NotNull(message = "O valor da movimentação é obrigatório")
	private BigDecimal valor;

	@Column
	private LocalDateTime dtHora = LocalDateTime.now();

	@Column(columnDefinition = "ENUM('DEPOSITO', 'SAQUE')")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo de movimentação é obrigatório")
	private TipoMovimentacao tipo;

	@JsonIgnore
	@JoinColumn(name = "numConta", referencedColumnName = "numConta")
	@ManyToOne
	private Conta conta;
}
