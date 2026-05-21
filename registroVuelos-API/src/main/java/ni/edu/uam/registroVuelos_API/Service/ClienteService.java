package ni.edu.uam.registroVuelos_API.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ni.edu.uam.registroVuelos_API.Models.Cliente;
import ni.edu.uam.registroVuelos_API.Repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }

    @Transactional
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente actualizar(Long id, Cliente cliente) {
        Cliente actual = obtenerPorId(id);
        actual.setNombres(cliente.getNombres());
        actual.setApellidos(cliente.getApellidos());
        actual.setEmail(cliente.getEmail());
        actual.setTelefono(cliente.getTelefono());
        actual.setDocumento(cliente.getDocumento());
        return clienteRepository.save(actual);
    }

    @Transactional
    public void eliminar(Long id) {
        Cliente actual = obtenerPorId(id);
        clienteRepository.delete(actual);
    }
}
