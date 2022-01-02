package btg.testetecnico.api.conta;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContaDto {
	public ContaDto() {
	}

	private Long numConta;
	private int agencia;
	private Float saldo;
	private LocalDate dtAbertura;
	private String cpfCliente;
}
