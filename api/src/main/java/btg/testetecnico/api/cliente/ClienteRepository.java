package btg.testetecnico.api.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	Optional<Object> findByEmail(String email);

	Optional<Object> findByCelular(String celular);
}
