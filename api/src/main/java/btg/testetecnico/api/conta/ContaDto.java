package btg.testetecnico.api.conta;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ContaDto {
	public ContaDto() {
	}

	private Long numConta;
	private int agencia;
	private BigDecimal saldo;
	private LocalDate dtAbertura;
	private String cpfCliente;

	public static ContaDto convertToDto(Conta conta) {
		ContaDto dtoConta = new ContaDto();

		dtoConta.setNumConta(conta.getNumConta());
		dtoConta.setAgencia(conta.getAgencia());
		dtoConta.setSaldo(conta.getSaldo());
		dtoConta.setDtAbertura(conta.getDtAbertura());
		dtoConta.setCpfCliente(conta.getCliente().getCpf());

		return dtoConta;
	}
}
