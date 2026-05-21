package ni.edu.uam.flighttrack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ni.edu.uam.flighttrack.data.model.model.Cliente
import ni.edu.uam.flighttrack.data.model.remote.RetrofitCliente

class ClientesViewModel : ViewModel() {
    private val _clientes = MutableStateFlow<List<Cliente>>(emptyList())
    val clientes: StateFlow<List<Cliente>> = _clientes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    init {
        loadClientes()
    }

    fun loadClientes() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                val clientesList = RetrofitCliente.api.getClientes()
                _clientes.value = clientesList
            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar clientes: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun createCliente(nombres: String, apellidos: String, email: String, telefono: String, documento: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                val nuevoCliente = Cliente(
                    id = null,
                    nombres = nombres,
                    apellidos = apellidos,
                    email = email,
                    telefono = telefono,
                    documento = documento
                )
                val clienteCreado = RetrofitCliente.api.createCliente(nuevoCliente)
                _clientes.value = _clientes.value + clienteCreado
            } catch (e: Exception) {
                _errorMessage.value = "Error al crear cliente: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteCliente(id: Long) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                RetrofitCliente.api.deleteCliente(id)
                _clientes.value = _clientes.value.filter { it.id != id }
            } catch (e: Exception) {
                _errorMessage.value = "Error al eliminar cliente: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updateCliente(id: Long, cliente: Cliente) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = ""
            try {
                val clienteActualizado = RetrofitCliente.api.updateCliente(id, cliente)
                _clientes.value = _clientes.value.map { if (it.id == id) clienteActualizado else it }
            } catch (e: Exception) {
                _errorMessage.value = "Error al actualizar cliente: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

