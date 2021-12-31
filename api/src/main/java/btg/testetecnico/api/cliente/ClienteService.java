package btg.testetecnico.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	public void registerCliente(Cliente cliente) {
		validateRegisterCliente(cliente);
		clienteRepository.save(cliente);
	}

	public void updateCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public void deleteCliente(String cpf) {
		Cliente cliente = clienteRepository.findById(cpf).isPresent() ? clienteRepository.findById(cpf).get() : null;
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente de CPF " + cpf + " não encontrado.");
		}
		clienteRepository.delete(cliente);
	}

	public Cliente getCliente(String cpf) {
		return clienteRepository.findById(cpf).isPresent() ? clienteRepository.findById(cpf).get() : null;
	}

	private void validateRegisterCliente(Cliente cliente) {
		validateCpf(cliente.getCpf());
		validateCelular(cliente.getCelular());
		validateEmail(cliente.getEmail());
	}

	private void validateCpf(String cpf) {
		if (clienteRepository.findById(cpf).isPresent()) {
			throw new IllegalArgumentException("Número de CPF já cadastrado, verifique seu cadastro.");
		}
	}

	private void validateEmail(String email) {
		if (clienteRepository.findByEmail(email).isPresent()) {
			throw new IllegalArgumentException("Endereço de Email já cadastrado no sistema.");
		}
	}

	private void validateCelular(String celular) {
		if (clienteRepository.findByCelular(celular).isPresent()) {
			throw new IllegalArgumentException("Número de celular já cadastrado no sistema.");
		}
	}

}
