/*
╔════════════════════════════════════════════════════════════════╗
║         ARQUITECTURA VISUAL - FLIGHT TRACK APP                ║
╚════════════════════════════════════════════════════════════════╝

┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE PRESENTACIÓN (UI)                │
│                      (Jetpack Compose)                       │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  HomeScreen ─┬─→ CrearClienteScreen                         │
│              │                                               │
│              ├─→ CrearVueloScreen                            │
│              │                                               │
│              ├─→ AdministrarClientesScreen                   │
│              │                                               │
│              └─→ AdministrarVuelosScreen                     │
│              │                                               │
│              └─→ CrearPasajeroScreen (referencia)            │
│              │                                               │
│              └─→ AdministrarPasajeroScreen (referencia)      │
│                                                              │
└─────────────────────────────────────────────────────────────┘
                         ↓
                  collectAsState()
                         ↓
┌─────────────────────────────────────────────────────────────┐
│           CAPA DE LÓGICA DE NEGOCIO (ViewModel)             │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │  VuelosViewModel                                   │    │
│  │  ─────────────────────                             │    │
│  │  StateFlow:                                        │    │
│  │   • vuelos: List<Vuelos>                           │    │
│  │   • isLoading: Boolean                             │    │
│  │   • errorMessage: String                           │    │
│  │                                                    │    │
│  │  Methods:                                          │    │
│  │   • loadVuelos()                                   │    │
│  │   • createVuelo(...)                               │    │
│  │   • deleteVuelo(id)                                │    │
│  │   • updateVuelo(id, vuelo)                         │    │
│  └─────────────────────────────────────────────────────┘    │
│                                                              │
│  ┌─────────────────────────────────────────────────────┐    │
│  │  ClientesViewModel                                 │    │
│  │  ──────────────────                                │    │
│  │  StateFlow:                                        │    │
│  │   • clientes: List<Cliente>                        │    │
│  │   • isLoading: Boolean                             │    │
│  │   • errorMessage: String                           │    │
│  │                                                    │    │
│  │  Methods:                                          │    │
│  │   • loadClientes()                                 │    │
│  │   • createCliente(...)                             │    │
│  │   • deleteCliente(id)                              │    │
│  │   • updateCliente(id, cliente)                     │    │
│  └─────────────────────────────────────────────────────┘    │
│                                                              │
└─────────────────────────────────────────────────────────────┘
                         ↓
               viewModelScope.launch
                (Coroutines)
                         ↓
┌─────────────────────────────────────────────────────────────┐
│         CAPA DE ACCESO A DATOS (Retrofit/API)               │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  ┌──────────────────────────┐  ┌──────────────────────────┐ │
│  │  ClienteApi              │  │  VuelosApi               │ │
│  │  (Retrofit Interface)    │  │  (Retrofit Interface)    │ │
│  ├──────────────────────────┤  ├──────────────────────────┤ │
│  │ @GET /clientes           │  │ @GET /vuelos            │ │
│  │ @GET /clientes/{id}      │  │ @GET /vuelos/{id}       │ │
│  │ @POST /clientes          │  │ @POST /vuelos           │ │
│  │ @PUT /clientes/{id}      │  │ @PUT /vuelos/{id}       │ │
│  │ @DELETE /clientes/{id}   │  │ @DELETE /vuelos/{id}    │ │
│  └──────────────────────────┘  └──────────────────────────┘ │
│           ↓ (ambas usan)                                     │
│  ┌──────────────────────────────────────────────────────┐   │
│  │  RetrofitCliente (Singleton)                        │   │
│  │  ────────────────────────────────                   │   │
│  │  BASE_URL = "http://192.168.56.1:8080/"             │   │
│  │                                                     │   │
│  │  GsonConverterFactory:                              │   │
│  │   • Deserializa JSON → Kotlin objects               │   │
│  │   • Serializa Kotlin objects → JSON                 │   │
│  └──────────────────────────────────────────────────────┘   │
│                                                              │
└─────────────────────────────────────────────────────────────┘
                         ↓
                    HTTP Requests
                         ↓
┌─────────────────────────────────────────────────────────────┐
│                      BACKEND API                            │
│                   (Spring Boot / REST)                      │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│  http://192.168.56.1:8080/                                  │
│  ├── /clientes (CRUD de clientes)                           │
│  └── /vuelos (CRUD de vuelos)                               │
│                                                              │
└─────────────────────────────────────────────────────────────┘

╔════════════════════════════════════════════════════════════════╗
║                   FLUJO DE DATOS (Ejemplo)                    ║
╚════════════════════════════════════════════════════════════════╝

1️⃣ Usuario toca botón "Crear Cliente"
   ↓
2️⃣ CrearClienteScreen.createCliente() es llamado
   ↓
3️⃣ clientesViewModel.createCliente(nombre, apellidos, email, tel, doc)
   ↓
4️⃣ ViewModel emite:
   • isLoading.value = true
   ↓
5️⃣ UI muestra:
   • LinearProgressIndicator()
   • Botones deshabilitados
   ↓
6️⃣ ViewModel ejecuta en coroutine:
   val cliente = Cliente(id=0, nombres, apellidos, email, telefono, documento)
   val clienteCreado = RetrofitCliente.api.createCliente(cliente)
   ↓
7️⃣ Retrofit construye HTTP POST request
   POST /clientes
   Content-Type: application/json
   Body: {
     "id": 0,
     "nombres": "Juan",
     "apellidos": "Pérez",
     "email": "juan@example.com",
     "telefono": "1234567890",
     "documento": "12345678"
   }
   ↓
8️⃣ Gson serializa automáticamente
   ↓
9️⃣ Enviado al servidor en 192.168.56.1:8080/clientes
   ↓
🔟 Backend procesa y responde:
   HTTP 201 Created
   Body: {
     "id": 1,
     "nombres": "Juan",
     "apellidos": "Pérez",
     "email": "juan@example.com",
     "telefono": "1234567890",
     "documento": "12345678"
   }
   ↓
1️⃣1️⃣ Gson deserializa respuesta → objeto Cliente(id=1, ...)
   ↓
1️⃣2️⃣ ViewModel actualiza:
   • clientes.value = clientes.value + clienteCreado
   • isLoading.value = false
   • errorMessage.value = ""
   ↓
1️⃣3️⃣ StateFlow emite nuevos valores
   ↓
1️⃣4️⃣ Composable recolecta con collectAsState()
   ↓
1️⃣5️⃣ UI se recompone automáticamente:
   • LinearProgressIndicator desaparece
   • Botones habilitados
   • Card verde con "Cliente creado exitosamente"
   • Lista se actualiza en AdministrarClientesScreen
   ↓
1️⃣6️⃣ Usuario ve resultado inmediatamente

╔════════════════════════════════════════════════════════════════╗
║                    MODELOS DE DATOS                           ║
╚════════════════════════════════════════════════════════════════╝

data class Cliente(
    val id: Long,
    val nombres: String,
    val apellidos: String,
    val email: String,
    val telefono: String,
    val documento: String
)

data class Vuelos(
    val id: Long,
    val codigo: String,
    val origen: String,
    val destino: String,
    val salida: String,           // ej: "14:30"
    val llegada: String,          // ej: "16:45"
    val asientosDisponibles: Int, // ej: 150
    val cliente: Cliente           // Objeto anidado
)

╔════════════════════════════════════════════════════════════════╗
║                   RECOMPOSICIONES                             ║
╚════════════════════════════════════════════════════════════════╝

Cuando cambia StateFlow:
• isLoading → UI actualiza indicador
• errorMessage → UI muestra error
• clientes/vuelos → UI redibuja listas

Recomposición INTELIGENTE:
✓ Solo se redibuja lo que cambió
✓ El resto de la UI permanece igual
✓ Sin flickering
✓ Sin memory leaks

═══════════════════════════════════════════════════════════════════

CICLO DE VIDA:
MainActivity → Navegacion() → NavController + ViewModels
                              ↓ (persisten)
                              ↓ (activos mientras existe NavController)
                              ↓ (se destruyen al cerrar app)

ViewModels sobreviven:
✓ Cambios de orientación
✓ Cambios de tema
✓ Recomposiciones

═══════════════════════════════════════════════════════════════════
*/

