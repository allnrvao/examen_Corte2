package ni.edu.uam.registroVuelos_API.Repository;

import ni.edu.uam.registroVuelos_API.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
