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

	@GetMapping("/{numConta}")
	public ResponseEntity<Conta> getConta(@PathVariable("numConta") Long numConta) {
		return ResponseEntity.ok(contaService.getConta(numConta));
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerConta(@RequestBody ContaDto conta) {
		try {
			return ResponseEntity.ok(contaService.registerConta(conta));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar conta: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete/{numConta}")
	public ResponseEntity<String> deleteConta(@PathVariable("numConta") Long numConta) {
		try {
			contaService.deleteConta(numConta);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao deletar conta: " + e.getMessage());
		}
		return ResponseEntity.ok("Conta deletada com sucesso!");
	}
}
