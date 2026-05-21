package ni.edu.uam.registroVuelos_API.Controllers;

import lombok.RequiredArgsConstructor;
import ni.edu.uam.registroVuelos_API.Models.Vuelos;
import ni.edu.uam.registroVuelos_API.Service.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
@RequiredArgsConstructor
public class VueloController {
    private final VueloService vueloService;

    @GetMapping
    public List<Vuelos> listar() {
        return vueloService.listar();
    }

    @GetMapping("/{id}")
    public Vuelos obtenerPorId(@PathVariable Long id) {
        return vueloService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vuelos crear( @RequestBody Vuelos vuelo) {
        return vueloService.crear(vuelo);
    }

    @PutMapping("/{id}")
    public Vuelos actualizar(@PathVariable Long id, @RequestBody Vuelos vuelo) {
        return vueloService.actualizar(id, vuelo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        vueloService.eliminar(id);
    }
}
