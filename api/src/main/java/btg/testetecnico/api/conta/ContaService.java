package btg.testetecnico.api.conta;

import btg.testetecnico.api.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public List<Conta> getContas() {
		return contaRepository.findAll();
	}

	public ContaDto getConta(String cpf) {
		Conta conta = contaRepository.findByCpf(cpf);
		ContaDto dtoConta = new ContaDto();

		dtoConta.setNumConta(conta.getNumConta());
		dtoConta.setAgencia(conta.getAgencia());
		dtoConta.setSaldo(conta.getSaldo());
		dtoConta.setDtAbertura(conta.getDtAbertura());
		dtoConta.setCpfCliente(conta.getCliente().getCpf());

		return dtoConta;
	}

	public String registerConta(Conta conta) {
		if (contaRepository.findByCpf(conta.getCliente().getCpf()) != null) {
			throw new IllegalArgumentException("");
		}
		contaRepository.save(conta);

		return "Conta registrada com sucesso!";
	}

	public void deleteContaByCpf(String cpf) {
		Conta conta = contaRepository.findByCpf(cpf);
		if (conta == null) {
			throw new IllegalArgumentException("Conta com cliente de CPF " + cpf + " Não encontrada.");
		}
		contaRepository.delete(conta);
 	}
}
