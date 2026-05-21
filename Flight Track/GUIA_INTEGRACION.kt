// GUÍA COMPLETA DE INTEGRACIÓN CON API
// ====================================

/*
1. CONFIGURACIÓN INICIAL
   - AndroidManifest.xml tiene el permiso de INTERNET ✓
   - build.gradle.kts tiene las dependencias necesarias ✓
   - RetrofitCliente.kt tiene el URL base configurado ✓

2. ARQUITECTURA IMPLEMENTADA
   
   LAYER 1 - Modelos de Datos (data/model/model/)
   ├── Cliente.kt - Datos de cliente
   └── Vuelos.kt - Datos de vuelo
   
   LAYER 2 - APIs Retrofit (data/model/remote/)
   ├── ClienteApi.kt - Interfaz de operaciones cliente
   ├── VuelosApi.kt - Interfaz de operaciones vuelos
   └── RetrofitCliente.kt - Configuración Retrofit
   
   LAYER 3 - ViewModels (viewmodel/)
   ├── ClientesViewModel.kt - Lógica clientes
   └── VuelosViewModel.kt - Lógica vuelos
   
   LAYER 4 - Vistas/UI (vistas/)
   ├── HomeScreen.kt - Menú principal
   ├── CrearClienteScreen.kt - Crear cliente
   ├── CrearVueloScreen.kt - Crear vuelo
   ├── AdministrarClientesScreen.kt - Gestionar clientes
   └── AdministrarVuelosScreen.kt - Gestionar vuelos
   
   LAYER 5 - Navegación
   ├── Navegacion.kt - Rutas
   └── MainActivity.kt - Punto de entrada

3. FLUJO DE UNA OPERACIÓN (Ejemplo: Crear Cliente)
   
   Usuario toca botón "Crear Cliente"
            ↓
   CrearClienteScreen valida datos
            ↓
   clientesViewModel.createCliente() es llamado
            ↓
   ViewModel emite isLoading = true
            ↓
   UI muestra indicador de progreso
            ↓
   RetrofitCliente.api.createCliente() hace POST
            ↓
   Backend responde con JSON
            ↓
   Gson deserializa a objeto Cliente
            ↓
   ViewModel actualiza StateFlow de clientes
            ↓
   UI se recompone automáticamente
            ↓
   Nueva lista se muestra en pantalla

4. MANEJO DE ESTADOS EN CADA VISTA

   Durante Carga:
   - LinearProgressIndicator visible
   - Botones deshabilitados
   - TextField deshabilitados
   
   En Caso de Error:
   - Card roja con mensaje de error
   - Botones habilitados nuevamente
   - Usuario puede reintentar
   
   Éxito:
   - Card verde con confirmación
   - Datos se limpian
   - Lista se actualiza

5. COMPONENTES PRINCIPALES

   StateFlow en ViewModels:
   - Observables reactivos
   - Emiten cambios automáticamente
   - Las vistas se suscriben con collectAsState()
   
   Coroutines en ViewModel:
   - Operaciones en hilo de fondo
   - viewModelScope gestiona el ciclo de vida
   - Evita memory leaks
   
   LaunchedEffect en Vistas:
   - Ejecuta código cuando cambian dependencias
   - Usado para mostrar mensajes de error
   - Se limpia automáticamente

6. RUTAS DE NAVEGACIÓN

   "home" → HomeScreen
   "crearCliente" → CrearClienteScreen
   "crearVuelo" → CrearVueloScreen
   "administrarClientes" → AdministrarClientesScreen
   "administrarVuelos" → AdministrarVuelosScreen

7. MODELOS DE DATOS (Lo que espera la API)

   Cliente {
     id: Long
     nombres: String
     apellidos: String
     email: String
     telefono: String
     documento: String
   }
   
   Vuelos {
     id: Long
     codigo: String
     origen: String
     destino: String
     salida: String (formato hora)
     llegada: String (formato hora)
     asientosDisponibles: Int
     cliente: Cliente (objeto anidado)
   }

8. VALIDACIONES IMPLEMENTADAS

   CrearClienteScreen:
   ✓ Todos los campos requeridos
   ✓ No permite campos vacíos
   
   CrearVueloScreen:
   ✓ Código de vuelo requerido
   ✓ Origen y destino requeridos
   ✓ Horarios requeridos
   ✓ Asientos número válido
   ✓ Cliente debe ser seleccionado
   
   General:
   ✓ Deshabilita operaciones durante carga
   ✓ Muestra errores de red claros
   ✓ Valida respuestas HTTP

9. DEPENDENCIAS CRÍTICAS

   build.gradle.kts:
   - implementation(libs.retrofit) → HTTP client
   - implementation(libs.converter.gson) → JSON serialization
   - implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
     → ViewModel en Compose

10. CÓMO AGREGAR NUEVA FUNCIONALIDAD

    Paso 1: Agregar método en API interface
    interface NuevaApi {
        @GET("nueva")
        suspend fun getNueva(): List<Nueva>
    }
    
    Paso 2: Crear ViewModel
    class NuevaViewModel : ViewModel() {
        private val _nuevos = MutableStateFlow<List<Nueva>>(emptyList())
        val nuevos: StateFlow<List<Nueva>> = _nuevos
        // ... métodos CRUD
    }
    
    Paso 3: Crear Composable
    @Composable
    fun NuevaScreen(viewModel: NuevaViewModel) {
        val data by viewModel.nuevos.collectAsState()
        // ... UI
    }
    
    Paso 4: Agregar ruta en Navegacion.kt
    composable("nueva") {
        NuevaScreen(viewModel = viewModel())
    }

11. DEBUGGING Y TESTING

    Para ver logs de Retrofit:
    - Inspeccionar LogCat en Android Studio
    - Agregar interceptor de logs a RetrofitCliente
    
    Para probar API:
    - Usar Postman: http://192.168.56.1:8080/clientes
    - Verificar que el servidor esté corriendo
    - Revisar respuestas JSON
    
    Errores Comunes:
    - 404: Endpoint no encontrado
    - 500: Error en servidor
    - Connection refused: Servidor no corre
    - JSON parsing error: Modelo no coincide

12. MEJORAS FUTURAS RECOMENDADAS

    ✓ Agregar Room para caché local
    ✓ Implementar Paging para listas grandes
    ✓ Agregar búsqueda y filtrado
    ✓ Implementar pull-to-refresh
    ✓ Agregar push notifications
    ✓ Mejorar seguridad (tokens JWT)
    ✓ Agregar logging más detallado
    ✓ Implementar tests unitarios
*/

