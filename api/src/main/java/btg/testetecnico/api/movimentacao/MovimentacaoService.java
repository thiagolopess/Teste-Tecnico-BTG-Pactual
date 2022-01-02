package btg.testetecnico.api.movimentacao;

import btg.testetecnico.api.conta.Conta;
import btg.testetecnico.api.conta.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

	@Autowired
	MovimentacaoRepository movimentacaoRepository;

	@Autowired
	ContaRepository contaRepository;

	public List<Movimentacao> getMovimentacoes(Long numConta) {
		return movimentacaoRepository.findByNumConta(numConta);
	}

	public void registerMovimentacao(Long numConta, MovimentacaoDto movimentacaoDto) {

		if (contaRepository.findById(numConta).isEmpty()) {
			throw new IllegalArgumentException("Conta não encontrada.");
		}

		if (movimentacaoDto.getTipo().equals(TipoMovimentacao.SAQUE)) {
			checkSaldo(numConta, movimentacaoDto.getValor());
		}

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setValor(movimentacaoDto.getValor());
		movimentacao.setTipo(movimentacaoDto.getTipo());

		movimentacao.setConta(contaRepository.findById(numConta).get());

		movimentacaoRepository.save(movimentacao);
	}

	private void checkSaldo(Long numConta, Float valor) {
		Conta conta = contaRepository.findById(numConta).get();

		if (conta.getSaldo() < valor) {
			throw new RuntimeException("Operação cancelada. Saldo insuficiente.");
		}
	}
}
