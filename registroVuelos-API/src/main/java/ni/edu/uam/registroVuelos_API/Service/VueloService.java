package ni.edu.uam.registroVuelos_API.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ni.edu.uam.registroVuelos_API.Models.Vuelos;
import ni.edu.uam.registroVuelos_API.Repository.VueloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VueloService {
    private final VueloRepository vueloRepository;

    @Transactional(readOnly = true)
    public List<Vuelos> listar() {
        return vueloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Vuelos obtenerPorId(Long id) {
        return vueloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vuelo no encontrado"));
    }

    @Transactional
    public Vuelos crear(Vuelos vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Transactional
    public Vuelos actualizar(Long id, Vuelos vuelo) {
        Vuelos actual = obtenerPorId(id);
        actual.setCodigo(vuelo.getCodigo());
        actual.setOrigen(vuelo.getOrigen());
        actual.setDestino(vuelo.getDestino());
        actual.setSalida(vuelo.getSalida());
        actual.setLlegada(vuelo.getLlegada());
        actual.setAsientosDisponibles(vuelo.getAsientosDisponibles());
        actual.setCliente(vuelo.getCliente());
        return vueloRepository.save(actual);
    }

    @Transactional
    public void eliminar(Long id) {
        Vuelos actual = obtenerPorId(id);
        vueloRepository.delete(actual);
    }
}
