package ni.edu.uam.registroVuelos_API.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo", nullable = false, length = 12, unique = true)
    private String codigo;

    @Column(name = "origen", nullable = false, length = 60)
    private String origen;


    @Column(name = "destino", nullable = false, length = 60)
    private String destino;

    @Column(name = "salida", nullable = false)
    private LocalDateTime salida;


    @Column(name = "llegada", nullable = false)
    private LocalDateTime llegada;


    @Column(name = "asientos_disponibles", nullable = false)
    private int asientosDisponibles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
