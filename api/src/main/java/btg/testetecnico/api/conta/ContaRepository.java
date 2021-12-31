package btg.testetecnico.api.conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	@Query("select c from Conta c where c.cliente.cpf = ?1")
	Conta findByCpf(String cpf);
}
