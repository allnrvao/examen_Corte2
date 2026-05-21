/*
RESUMEN EJECUTIVO - CAMBIOS PARA CONSUMO DE API
================================================

✅ ARCHIVOS CREADOS:
   1. viewmodel/VuelosViewModel.kt - 88 líneas
   2. viewmodel/ClientesViewModel.kt - 77 líneas
   3. vistas/CrearClienteScreen.kt - 163 líneas
   4. vistas/AdministrarVuelosScreen.kt - 137 líneas
   5. vistas/AdministrarClientesScreen.kt - 131 líneas

✅ ARCHIVOS MODIFICADOS:
   1. Navegacion.kt - Actualizada para ViewModels
   2. HomeScreen.kt - Actualizada para NavController
   3. CrearVueloScreen.kt - Integrada con API
   4. CargaScreen.kt - Corregida sintaxis
   5. AndroidManifest.xml - Agregado permiso INTERNET
   6. build.gradle.kts - Ya tiene dependencias necesarias

❌ ARCHIVOS DEPRECADOS (Aún presentes):
   - CrearPasajeroScreen.kt (no se usa en navegación)
   - AdministrarPasajeroScreen.kt (no se usa en navegación)
   - AdministrarVueloScreen.kt (reemplazada por AdministrarVuelosScreen.kt)

📱 FUNCIONALIDADES DISPONIBLES:

   HomeScreen
   ├── → Crear Cliente → CrearClienteScreen
   ├── → Crear Vuelo → CrearVueloScreen
   ├── → Administrar Clientes → AdministrarClientesScreen
   └── → Administrar Vuelos → AdministrarVuelosScreen

   Cada pantalla tiene:
   ✓ Carga asíncrona
   ✓ Indicadores de progreso
   ✓ Manejo de errores
   ✓ Validación de datos
   ✓ Botones inteligentes (se deshabilitan al cargar)

🔌 INTEGRACIÓN API:

   Base URL: http://192.168.56.1:8080/
   
   Endpoints Clientes:
   • GET /clientes
   • GET /clientes/{id}
   • POST /clientes
   • PUT /clientes/{id}
   • DELETE /clientes/{id}
   
   Endpoints Vuelos:
   • GET /vuelos
   • GET /vuelos/{id}
   • POST /vuelos
   • PUT /vuelos/{id}
   • DELETE /vuelos/{id}

🏗️ ARQUITECTURA FINAL:

   MainActivity
   └── Navegacion()
       ├── ViewModels (creados automáticamente)
       │   ├── VuelosViewModel
       │   └── ClientesViewModel
       └── NavController
           ├── HomeScreen
           ├── CrearClienteScreen
           ├── CrearVueloScreen
           ├── AdministrarClientesScreen
           └── AdministrarVuelosScreen

⚙️ COMPONENTES CLAVE:

   1. ViewModel + StateFlow
      • Maneja estado de UI
      • Comunica con API
      • Sobrevive reconfiguración de pantalla
   
   2. Coroutines + viewModelScope
      • Operaciones asincrónicas
      • Gestión automática de ciclo de vida
      • No hay memory leaks
   
   3. Compose + collectAsState()
      • UI reactiva
      • Recomposición automática
      • Material Design 3

📋 CHECKLIST PRE-COMPILACIÓN:

   ☑ Permiso INTERNET en AndroidManifest.xml
   ☑ Dependencias retrofit y gson en build.gradle.kts
   ☑ ViewModels creados en paquete viewmodel/
   ☑ Nuevas vistas creadas en paquete vistas/
   ☑ Navegacion.kt actualizada con viewModels
   ☑ Imports correctos en todas las vistas
   ☑ No hay referencias a paquete "ni.edu.uam.administracion.modelo"
   ☑ Datos modelos usan paquete correcto de API

🚀 PRÓXIMOS PASOS:

   1. Compilar el proyecto
   2. Verificar que no hay errores de imports
   3. Ejecutar en emulador/dispositivo
   4. Verificar que la API es accesible
   5. Probar flujo completo:
      - Crear cliente
      - Crear vuelo (seleccionar cliente)
      - Ver lista de vuelos
      - Eliminar vuelo

💡 TIPS IMPORTANTES:

   • Si no conecta a API, verifica:
     - Servidor backend está ejecutándose
     - URL base es correcta
     - Emulador puede alcanzar 192.168.56.1
   
   • Si hay errores de parsing JSON:
     - Verifica que Response API coincida con modelos
     - Usa modelo correcto de api/remote/
   
   • Para debug, agrega en Retrofit:
     - .addInterceptor(HttpLoggingInterceptor())
     - Ver en LogCat las peticiones HTTP

*/

