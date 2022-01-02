package btg.testetecnico.api.movimentacao;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovimentacaoDto {
	private Long id;
	private Float valor;
	private LocalDateTime dtHora;
	private TipoMovimentacao tipo;
	private Long numConta;

	public MovimentacaoDto(Long id, Float valor, LocalDateTime dtHora, TipoMovimentacao tipo, Long numConta) {
		this.id = id;
		this.valor = valor;
		this.dtHora = dtHora;
		this.tipo = tipo;
		this.numConta = numConta;
	}
}
