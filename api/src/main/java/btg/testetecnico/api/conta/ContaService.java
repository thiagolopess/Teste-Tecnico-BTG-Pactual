package btg.testetecnico.api.conta;

import btg.testetecnico.api.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public List<ContaDto> getContas() {
		List<Conta> contas = contaRepository.findAll();
		List<ContaDto> dtoContas = new ArrayList<>();
		for (Conta conta : contas) {
			dtoContas.add(ContaDto.convertToDto(conta));
		}

		return dtoContas;
	}

	public Conta getConta(Long numConta) {
		return contaRepository.findById(numConta).isPresent() ? contaRepository.findById(numConta).get() : null;
	}

	public String registerConta(ContaDto dtoConta) {
		if (clienteRepository.findById(dtoConta.getCpfCliente()).isEmpty()) {
			throw new IllegalArgumentException("Não existe cliente com o CPF " + dtoConta.getCpfCliente() + ".");
		}

		Conta conta = new Conta();

		conta.setAgencia(dtoConta.getAgencia());
		conta.setDtAbertura(dtoConta.getDtAbertura());
		conta.setCliente(clienteRepository.findById(dtoConta.getCpfCliente()).get());

		contaRepository.save(conta);

		return "Conta registrada com sucesso!";
	}

	public void deleteConta(Long numConta) {
		Conta conta = contaRepository.findById(numConta).isPresent() ? contaRepository.findById(numConta).get() : null;

		if (conta == null) {
			throw new IllegalArgumentException("Conta " + numConta + " não encontrada.");
		}

		contaRepository.delete(conta);
 	}
}
