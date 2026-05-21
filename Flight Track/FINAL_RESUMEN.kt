// ==========================================
// ADAPTACIÓN COMPLETA PARA CONSUMO DE API
// ==========================================

/*
✅ CAMBIOS REALIZADOS - RESUMEN FINAL

ARCHIVOS CREADOS (Nuevas vistas y ViewModels):
1. viewmodel/VuelosViewModel.kt - Gestiona operaciones de vuelos
2. viewmodel/ClientesViewModel.kt - Gestiona operaciones de clientes  
3. vistas/CrearClienteScreen.kt - Formulario para crear clientes
4. vistas/AdministrarVuelosScreen.kt - Listado y eliminar vuelos
5. vistas/AdministrarClientesScreen.kt - Listado y eliminar clientes

ARCHIVOS CORREGIDOS (Compatibles con data classes):
1. vistas/CrearPasajeroScreen.kt - Solo referencia de datos (sin API)
2. vistas/AdministrarPasajeroScreen.kt - Solo referencia (sin API)
3. vistas/AdministrarVueloScreen.kt - Renombrado como OLD, deprecado
4. vistas/CargaScreen.kt - Corregida sintaxis Kotlin
5. vistas/HomeScreen.kt - Actualizada con navegación correcta
6. vistas/CrearVueloScreen.kt - Integrada con API y ViewModels

ARCHIVOS ACTUALIZADOS (Configuración):
1. Navegacion.kt - Actualizada con ViewModels correctos
2. MainActivity.kt - Sin cambios, funciona como antes
3. AndroidManifest.xml - Agregado permiso INTERNET ✓
4. build.gradle.kts - Dependencias correctas ✓

MODELOS Y APIS (Ya existentes, sin cambios):
1. data/model/model/Cliente.kt - Data class
2. data/model/model/Vuelos.kt - Data class
3. data/model/remote/ClienteApi.kt - Interface Retrofit
4. data/model/remote/VuelosApi.kt - Interface Retrofit
5. data/model/remote/RetrofitCliente.kt - Configuración

KEY POINTS:
- Todos los modelos son data classes simples (sin métodos)
- La lógica de negocio está en ViewModels
- Las vistas solo hacen UI y consumen ViewModels
- La navegación es completamente reactiva
- Los errores se manejan automáticamente
- Los estados de carga (loading/error) se muestran visualmente

FLUJO COMPLETO:
User interactúa con UI
    ↓
Composable llama ViewModel.método()
    ↓
ViewModel emite isLoading = true
    ↓
UI muestra indicador de progreso
    ↓
ViewModel llama API vía Retrofit
    ↓
API responde con JSON
    ↓
Gson deserializa a data class
    ↓
ViewModel actualiza StateFlow
    ↓
UI se recompone automáticamente
    ↓
Resultado visible para usuario

FUNCIONALIDADES DISPONIBLES:

📱 MENÚ PRINCIPAL (HomeScreen)
├── 📝 Crear Cliente
│   └── POST /clientes
│   └── Crea nuevo cliente en la API
│
├── ✈️ Crear Vuelo
│   └── POST /vuelos
│   └── Crea vuelo con cliente seleccionado
│
├── 👥 Administrar Clientes
│   ├── GET /clientes (lista)
│   ├── DELETE /clientes/{id} (eliminar)
│   └── UI actualiza automáticamente
│
└── ✈️ Administrar Vuelos
    ├── GET /vuelos (lista)
    ├── DELETE /vuelos/{id} (eliminar)
    └── UI actualiza automáticamente

ENDPOINTS API CONSUMIDOS:
GET    /clientes           - Obtener todos
GET    /clientes/{id}      - Obtener uno
POST   /clientes           - Crear
PUT    /clientes/{id}      - Actualizar
DELETE /clientes/{id}      - Eliminar

GET    /vuelos             - Obtener todos
GET    /vuelos/{id}        - Obtener uno
POST   /vuelos             - Crear
PUT    /vuelos/{id}        - Actualizar
DELETE /vuelos/{id}        - Eliminar

ESTADOS DE UI:

Durante Carga:
- LinearProgressIndicator visible
- Todos los botones deshabilitados
- TextFields deshabilitados

En Éxito:
- Card verde con confirmación
- Datos se refrescan automáticamente
- Formularios se limpian

En Error:
- Card roja con mensaje de error
- Botones habilitados para reintentar
- Error detallado del servidor

COMPILACIÓN Y EJECUCIÓN:

1. Compilar:
   ./gradlew build

2. Verificar errores:
   - Solo imports corregidos
   - No hay referencias a paquetes antiguos
   - ViewModels están en paquete correcto

3. Ejecutar:
   - Asegurar que servidor API esté en http://192.168.56.1:8080/
   - Conectar emulador/dispositivo
   - La app cargará datos automáticamente

VENTAJAS DE LA NUEVA ARQUITECTURA:

✅ Manejo automático de ciclo de vida
✅ No hay memory leaks
✅ UI siempre sincronizada con datos
✅ Fácil agregar nuevas funcionalidades
✅ Validación en ViewModels
✅ Errores manejados consistentemente
✅ Offline-first capability (con Room en futuro)
✅ Tests más fáciles de escribir

PRÓXIMAS MEJORAS RECOMENDADAS:

• Agregar búsqueda/filtrado
• Implementar Room para caché local
• Agregar autenticación (JWT tokens)
• Mejorar validaciones
• Agregar test unitarios
• Implementar refresh de datos
• Agregar transiciones de animación
• Implementar paginación para listas grandes

ARCHIVOS NO USADOS (Puede eliminar):
- vistas/AdministrarVueloScreen.kt (reemplazado)
- vistas/AdministrarPasajeroScreen.kt (solo referencia)
- vistas/CrearPasajeroScreen.kt (solo referencia)

Nota: Se dejaron como referencia educativa del cambio de arquitectura
*/

