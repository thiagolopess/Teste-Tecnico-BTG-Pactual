package btg.testetecnico.api.movimentacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movimentacao")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService movimentacaoService;

	@GetMapping("/{numConta}")
	public ResponseEntity<List<Movimentacao>> getMovimentacoes(@PathVariable("numConta") Long numConta) {
		return ResponseEntity.ok(movimentacaoService.getMovimentacoes(numConta));
	}

	@PostMapping("/register/{numConta}")
	public ResponseEntity<String> registerMovimentacao(@PathVariable("numConta") Long numConta,
	                                                   @RequestBody MovimentacaoDto movimentacaoDto) {
		try {
			movimentacaoService.registerMovimentacao(numConta, movimentacaoDto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Movimentação registrada com sucesso!");
	}
}
