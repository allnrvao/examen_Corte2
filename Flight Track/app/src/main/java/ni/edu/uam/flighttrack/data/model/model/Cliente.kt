package ni.edu.uam.flighttrack.data.model.model

data class Cliente(
    val id: Long? = null,
    val nombres: String,
    val apellidos: String,
    val email: String,
    val telefono: String,
    val documento: String
)