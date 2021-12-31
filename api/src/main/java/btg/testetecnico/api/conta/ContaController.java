package btg.testetecnico.api.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping
	public ResponseEntity<List<Conta>> getContas() {
		return ResponseEntity.ok(contaService.getContas());
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<ContaDto> getContaByCpf(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(contaService.getConta(cpf));
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerConta(@RequestBody Conta conta) {
		try {
			return ResponseEntity.ok(contaService.registerConta(conta));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar conta: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete/{cpf}")
	public ResponseEntity<String> deleteContaByCpf(@PathVariable("cpf") String cpf) {
		try {
			contaService.deleteContaByCpf(cpf);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Conta deletada com sucesso!");
	}


}
