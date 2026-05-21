package ni.edu.uam.flighttrack.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.flighttrack.viewmodel.VuelosViewModel
import ni.edu.uam.flighttrack.viewmodel.ClientesViewModel
import androidx.compose.material3.MenuAnchorType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearVueloScreen(
    vuelosViewModel: VuelosViewModel,
    clientesViewModel: ClientesViewModel,
    onDone: () -> Unit
) {
    var codigo by remember { mutableStateOf("") }
    var origen by remember { mutableStateOf("") }
    var destino by remember { mutableStateOf("") }
    var salida by remember { mutableStateOf("") }
    var llegada by remember { mutableStateOf("") }
    var asientosStr by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    var clienteExpandido by remember { mutableStateOf(false) }
    var clienteSeleccionado by remember { mutableStateOf<Int>(-1) }

    val isLoading by vuelosViewModel.isLoading.collectAsState()
    val errorMessage by vuelosViewModel.errorMessage.collectAsState()
    val clientes by clientesViewModel.clientes.collectAsState()

    LaunchedEffect(errorMessage) {
        if (errorMessage.isNotEmpty()) {
            mensaje = errorMessage
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        OutlinedButton(
            onClick = onDone,
            modifier = Modifier.padding(bottom = 16.dp),
            enabled = !isLoading
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Volver")
        }

        Text(
            text = "Crear Vuelo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = codigo,
            onValueChange = { codigo = it },
            label = { Text("Código de vuelo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = origen,
            onValueChange = { origen = it },
            label = { Text("Origen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = destino,
            onValueChange = { destino = it },
            label = { Text("Destino") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = salida,
            onValueChange = { salida = it },
            label = { Text("Hora de salida") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = llegada,
            onValueChange = { llegada = it },
            label = { Text("Hora de llegada") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = asientosStr,
            onValueChange = { asientosStr = it },
            label = { Text("Asientos disponibles") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        ExposedDropdownMenuBox(
            expanded = clienteExpandido,
            onExpandedChange = { clienteExpandido = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            OutlinedTextField(
                value = if (clienteSeleccionado >= 0 && clientes.size > clienteSeleccionado) 
                    "${clientes[clienteSeleccionado].nombres} ${clientes[clienteSeleccionado].apellidos}" 
                    else "Seleccione un cliente",
                onValueChange = {},
                readOnly = true,
                label = { Text("Cliente") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = clienteExpandido) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                enabled = !isLoading
            )
            ExposedDropdownMenu(
                expanded = clienteExpandido,
                onDismissRequest = { clienteExpandido = false }
            ) {
                clientes.forEachIndexed { index, cliente ->
                    DropdownMenuItem(
                        text = { Text("${cliente.nombres} ${cliente.apellidos}") },
                        onClick = {
                            clienteSeleccionado = index
                            clienteExpandido = false
                        }
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ElevatedButton(
                onClick = {
                    if (codigo.isNotBlank() && origen.isNotBlank() && destino.isNotBlank() && 
                        salida.isNotBlank() && llegada.isNotBlank() && asientosStr.isNotBlank() &&
                        clienteSeleccionado >= 0) {
                        val asientos = asientosStr.toIntOrNull() ?: 0
                        vuelosViewModel.createVuelo(
                            cliente = clientes[clienteSeleccionado],
                            codigo = codigo,
                            origen = origen,
                            destino = destino,
                            salida = salida,
                            llegada = llegada,
                            asientosDisponibles = asientos
                        )
                        mensaje = "Vuelo creado exitosamente"
                        codigo = ""
                        origen = ""
                        destino = ""
                        salida = ""
                        llegada = ""
                        asientosStr = ""
                        clienteSeleccionado = -1
                    } else {
                        mensaje = "Complete todos los campos y seleccione un cliente"
                    }
                },
                modifier = Modifier.weight(1f),
                enabled = !isLoading
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Crear Vuelo",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Crear Vuelo")
            }
        }

        if (mensaje.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = if (errorMessage.isEmpty()) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Text(
                    text = mensaje,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        if (isLoading) {
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
    }
}