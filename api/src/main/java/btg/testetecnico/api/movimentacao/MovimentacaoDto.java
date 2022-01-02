package btg.testetecnico.api.movimentacao;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class MovimentacaoDto {
	private Long id;
	private BigDecimal valor;
	private LocalDateTime dtHora;
	private TipoMovimentacao tipo;
	private Long numConta;

	public MovimentacaoDto() {
	}
}
