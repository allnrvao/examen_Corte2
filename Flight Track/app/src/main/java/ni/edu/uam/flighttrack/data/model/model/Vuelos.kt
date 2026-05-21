package ni.edu.uam.flighttrack.data.model.model

data class Vuelos(
    val id: Long? = null,
    val codigo: String,
    val origen: String,
    val destino: String,
    val salida: String,
    val llegada: String,
    val asientosDisponibles: Int,
    val cliente: Cliente
)