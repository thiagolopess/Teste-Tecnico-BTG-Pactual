package btg.testetecnico.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController{

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		return ResponseEntity.ok().body(clienteService.getClientes());
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("cpf") String cpfCliente) {
		return ResponseEntity.ok().body(clienteService.getCliente(cpfCliente));
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerCliente(@Valid @RequestBody Cliente cliente) {
		try {
			clienteService.registerCliente(cliente);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Cliente cadastrado com sucesso!");
	}

	@DeleteMapping("/delete/{cpf}")
	public ResponseEntity<String> deleteCliente(@PathVariable("cpf") String cpfCliente) {
		try {
			clienteService.deleteCliente(cpfCliente);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Cliente deletado com sucesso!");
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateCliente(@RequestBody Cliente cliente) {
		try {

			clienteService.updateCliente(cliente);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Cliente atualizado com sucesso!");
	}


}
