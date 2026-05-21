package ni.edu.uam.flighttrack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ni.edu.uam.flighttrack.data.model.model.Vuelos
import ni.edu.uam.flighttrack.data.model.model.Cliente
import ni.edu.uam.flighttrack.data.model.remote.RetrofitCliente

class VuelosViewModel : ViewModel() {
    private val _vuelos = MutableStateFlow<List<Vuelos>>(emptyList())
    val vuelos: StateFlow<List<Vuelos>> = _vuelos

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    init {
        loadVuelos()
    }

    fun loadVuelos() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                val vuelosList = RetrofitCliente.apiVuelos.getVuelos()
                _vuelos.value = vuelosList
            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar vuelos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun createVuelo(cliente: Cliente, codigo: String, origen: String, destino: String, salida: String, llegada: String, asientosDisponibles: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                val nuevoVuelo = Vuelos(
                    id = 0,
                    codigo = codigo,
                    origen = origen,
                    destino = destino,
                    salida = salida,
                    llegada = llegada,
                    asientosDisponibles = asientosDisponibles,
                    cliente = cliente
                )
                val vueloCreado = RetrofitCliente.apiVuelos.createVuelo(nuevoVuelo)
                _vuelos.value = _vuelos.value + vueloCreado
            } catch (e: Exception) {
                _errorMessage.value = "Error al crear vuelo: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteVuelo(id: Long) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                RetrofitCliente.apiVuelos.deleteVuelo(id)
                _vuelos.value = _vuelos.value.filter { it.id != id }
            } catch (e: Exception) {
                _errorMessage.value = "Error al eliminar vuelo: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updateVuelo(id: Long, vuelo: Vuelos) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                val vueloActualizado = RetrofitCliente.apiVuelos.updateVuelo(id, vuelo)
                _vuelos.value = _vuelos.value.map { if (it.id == id) vueloActualizado else it }
            } catch (e: Exception) {
                _errorMessage.value = "Error al actualizar vuelo: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

