package btg.testetecnico.api.movimentacao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
	@Query("SELECT m FROM Movimentacao m WHERE m.conta.numConta = ?1")
	List<Movimentacao> findByNumConta(Long numConta);
}
