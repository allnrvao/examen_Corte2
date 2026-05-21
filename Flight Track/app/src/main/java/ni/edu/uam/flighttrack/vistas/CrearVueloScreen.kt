package ni.edu.uam.flighttrack.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
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
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.ui.platform.LocalContext
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import java.util.Calendar
import androidx.compose.material.icons.filled.Schedule

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
    @Suppress("UNUSED_VARIABLE")
    var salidaDate by remember { mutableStateOf<Date?>(null) }
    @Suppress("UNUSED_VARIABLE")
    var llegadaDate by remember { mutableStateOf<Date?>(null) }
    var asientosStr by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    var clienteExpandido by remember { mutableStateOf(false) }
    var clienteSeleccionado by remember { mutableStateOf<Int>(-1) }

    val isLoading by vuelosViewModel.isLoading.collectAsState()
    val errorMessage by vuelosViewModel.errorMessage.collectAsState()
    val clientes by clientesViewModel.clientes.collectAsState()

    // Si la lista de clientes cambia y no hay selección, seleccionar el primero
    LaunchedEffect(clientes) {
        if (clientes.isNotEmpty() && clienteSeleccionado < 0) {
            clienteSeleccionado = 0
        }
    }

    // Formato de fecha esperado: 2026-05-21T14:30 (yyyy-MM-dd'T'HH:mm)
    val dateFormatter = remember { SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US) }
    @Suppress("UNUSED_VARIABLE")
    val displayFormatter = remember { SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US) }
    val context = LocalContext.current

    // Al entrar en la pantalla, cargar clientes (asegura que la lista esté actualizada)
    LaunchedEffect(Unit) {
        clientesViewModel.loadClientes()
    }

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
            onValueChange = { salida = it; salidaDate = null },
            label = { Text("Hora de salida (YYYY-MM-DDThh:mm)") },
            trailingIcon = {
                IconButton(onClick = {
                    val cal = Calendar.getInstance()
                    DatePickerDialog(context, { _, year, month, dayOfMonth ->
                        TimePickerDialog(context, { _, hourOfDay, minute ->
                            val c = Calendar.getInstance().apply {
                                set(year, month, dayOfMonth, hourOfDay, minute, 0)
                            }
                            val dt: Date = c.time
                            salidaDate = dt
                            salida = dateFormatter.format(dt)
                        }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
                    }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
                }) {
                    Icon(Icons.Filled.Schedule, contentDescription = "Elegir fecha/hora")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = llegada,
            onValueChange = { llegada = it; llegadaDate = null },
            label = { Text("Hora de llegada (YYYY-MM-DDThh:mm)") },
            trailingIcon = {
                IconButton(onClick = {
                    val cal = Calendar.getInstance()
                    DatePickerDialog(context, { _, year, month, dayOfMonth ->
                        TimePickerDialog(context, { _, hourOfDay, minute ->
                            val c = Calendar.getInstance().apply {
                                set(year, month, dayOfMonth, hourOfDay, minute, 0)
                            }
                            val dt: Date = c.time
                            llegadaDate = dt
                            llegada = dateFormatter.format(dt)
                        }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
                    }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
                }) {
                    Icon(Icons.Filled.Schedule, contentDescription = "Elegir fecha/hora")
                }
            },
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
            Row(modifier = Modifier.fillMaxWidth()) {
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
                    .weight(1f)
                    .clickable { clienteExpandido = true },
                enabled = !isLoading
            )
                IconButton(onClick = { clientesViewModel.loadClientes() }, modifier = Modifier.align(Alignment.CenterVertically)) {
                    Icon(Icons.Filled.Check, contentDescription = "Refrescar clientes")
                }
            }
            ExposedDropdownMenu(
                expanded = clienteExpandido,
                onDismissRequest = { clienteExpandido = false }
            ) {
                if (clientes.isEmpty()) {
                    DropdownMenuItem(text = { Text("No hay clientes. Cree uno primero.") }, onClick = { clienteExpandido = false }, enabled = false)
                } else {
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
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val parsedSalida = remember(salida) {
                try {
                    dateFormatter.parse(salida)
                } catch (@Suppress("UNUSED_VARIABLE") e: ParseException) {
                    null
                }
            }
            val parsedLlegada = remember(llegada) {
                try {
                    dateFormatter.parse(llegada)
                } catch (@Suppress("UNUSED_VARIABLE") e: ParseException) {
                    null
                }
            }

            val asientos = asientosStr.toIntOrNull() ?: 0
            val camposLlenos = codigo.isNotBlank() && origen.isNotBlank() && destino.isNotBlank() && salida.isNotBlank() && llegada.isNotBlank() && asientosStr.isNotBlank() && clienteSeleccionado >= 0
            val fechasValidas = parsedSalida != null && parsedLlegada != null && (parsedSalida.time <= parsedLlegada.time)
            val puedeCrear = !isLoading && camposLlenos && fechasValidas && asientos > 0

            ElevatedButton(
                onClick = {
                    if (!camposLlenos) {
                        mensaje = "Complete todos los campos y seleccione un cliente"
                        return@ElevatedButton
                    }

                    if (parsedSalida == null || parsedLlegada == null) {
                        mensaje = "Formato de fecha inválido. Use YYYY-MM-DDThh:mm"
                        return@ElevatedButton
                    }

                    if (parsedSalida.time > parsedLlegada.time) {
                        mensaje = "La hora de salida no puede ser posterior a la de llegada"
                        return@ElevatedButton
                    }

                    if (asientos <= 0) {
                        mensaje = "Ingrese un número válido de asientos"
                        return@ElevatedButton
                    }

                    // Formatear a ISO antes de enviar (sin segundos)
                    val salidaStr = dateFormatter.format(parsedSalida)
                    val llegadaStr = dateFormatter.format(parsedLlegada)

                    vuelosViewModel.createVuelo(
                        cliente = clientes[clienteSeleccionado],
                        codigo = codigo,
                        origen = origen,
                        destino = destino,
                        salida = salidaStr,
                        llegada = llegadaStr,
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
                },
                modifier = Modifier.weight(1f),
                enabled = puedeCrear
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