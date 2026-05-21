package ni.edu.uam.registroVuelos_API.Repository;

import ni.edu.uam.registroVuelos_API.Models.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelos, Long> {
}
