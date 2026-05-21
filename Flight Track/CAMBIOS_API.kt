// RESUMEN DE CAMBIOS REALIZADOS PARA INTEGRAR LA API
// ===================================================

/*
CAMBIOS PRINCIPALES:

1. CREADOS VIEWMODELS:
   - VuelosViewModel.kt: Maneja la lógica de llamadas API para vuelos
   - ClientesViewModel.kt: Maneja la lógica de llamadas API para clientes
   
   Ambos ViewModels contienen:
   - StateFlow para datos (vuelos/clientes)
   - StateFlow para isLoading (indica si hay operación en progreso)
   - StateFlow para errorMessage (mensajes de error)
   - Métodos para loadData(), create(), delete(), update()

2. ACTUALIZADAS VISTAS:
   - HomeScreen.kt: Ahora usa NavController para navegación
   - CrearVueloScreen.kt: Integrada con VuelosViewModel y ClientesViewModel
   - Navegacion.kt: Actualizada para pasar ViewModels a las vistas
   
3. NUEVAS VISTAS CREADAS:
   - CrearClienteScreen.kt: Para crear clientes por API
   - AdministrarVuelosScreen.kt: Para listar y eliminar vuelos por API
   - AdministrarClientesScreen.kt: Para listar y eliminar clientes por API

4. ARCHIVOS DE CONFIGURACIÓN:
   - AndroidManifest.xml: Agregado permiso INTERNET
   - build.gradle.kts: Dependencias ya estaban presentes

5. MODELOS UTILIZADOS (Existentes):
   - Cliente.kt: Modelo de cliente de la API
   - Vuelos.kt: Modelo de vuelo de la API
   - ClienteApi.kt: Interfaz Retrofit para clientes
   - VuelosApi.kt: Interfaz Retrofit para vuelos
   - RetrofitCliente.kt: Configuración de Retrofit

VISTAS ANTIGUAS (Aún presentes pero no usadas):
   - CrearPasajeroScreen.kt: Deprecated (usada la estructura de clientes)
   - AdministrarPasajeroScreen.kt: Deprecated
   - AdministrarVueloScreen.kt: Reemplazada por AdministrarVuelosScreen.kt
   - CargaScreen.kt: Arreglada (tenía errores de sintaxis)

FLUJO DE DATOS:
1. MainActivity -> Navegacion -> NavController + ViewModels
2. ViewModels hacen llamadas HTTP usando Retrofit
3. StateFlow notifica cambios a las vistas
4. Las vistas se actualizan reactivamente

CARACTERÍSTICAS IMPLEMENTADAS:
- Carga asíncrona de datos desde la API
- Indicadores de carga (LinearProgressIndicator)
- Manejo de errores con mensajes al usuario
- CRUD completo para clientes y vuelos
- Interfaz responsive con Compose Material 3
*/

