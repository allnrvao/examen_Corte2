/*
╔════════════════════════════════════════════════════════════════╗
║              🚀 QUICK START GUIDE - FLIGHT TRACK               ║
╚════════════════════════════════════════════════════════════════╝

✅ ADAPTACIÓN COMPLETADA

La aplicación ha sido completamente adaptada para consumir datos
desde una API REST. Todo está listo para compilar y ejecutar.

═══════════════════════════════════════════════════════════════════

📋 PASOS PARA EJECUTAR:

1. COMPILAR
   ────────
   Terminal → ./gradlew build
   
   ✓ Esperado: BUILD SUCCESSFUL

2. CONECTAR DISPOSITIVO/EMULADOR
   ──────────────────────────────
   Asegúrate que esté conectado a Android Studio

3. VERIFICAR SERVIDOR API
   ──────────────────────
   • Backend debe estar corriendo en: http://192.168.56.1:8080/
   • Endpoints disponibles:
     - GET  http://192.168.56.1:8080/clientes
     - GET  http://192.168.56.1:8080/vuelos
   
   Si necesitas cambiar la URL, edita:
   app/src/main/java/ni/edu/uam/flighttrack/
                     data/model/remote/RetrofitCliente.kt
   
   Línea: private const val BASE_URL = "http://TU_IP:8080/"

4. EJECUTAR
   ────────
   Android Studio → Run → Run 'app'
   
   O terminal → adb install app/build/outputs/apk/debug/app-debug.apk

5. USAR LA APP
   ──────────
   Menú Principal:
   
   ✓ Crear Cliente
     - Llena todos los campos
     - Clic "Crear Cliente"
     - Se guardará en la API
   
   ✓ Crear Vuelo
     - Selecciona un cliente primero
     - Llena datos del vuelo
     - Clic "Crear Vuelo"
     - Verás el vuelo creado en la lista
   
   ✓ Administrar Clientes
     - Ver lista de todos los clientes
     - Eliminar cliente (botón rojo)
   
   ✓ Administrar Vuelos
     - Ver lista de todos los vuelos
     - Eliminar vuelo (botón rojo)

═══════════════════════════════════════════════════════════════════

🔧 CAMBIOS PRINCIPALES REALIZADOS:

✅ Creados ViewModels:
   • VuelosViewModel.kt
   • ClientesViewModel.kt

✅ Nuevas Vistas:
   • CrearClienteScreen.kt
   • AdministrarVuelosScreen.kt
   • AdministrarClientesScreen.kt

✅ Vistas Adaptadas:
   • HomeScreen.kt
   • CrearVueloScreen.kt
   • CrearPasajeroScreen.kt
   • AdministrarPasajeroScreen.kt
   • CargaScreen.kt

✅ Configuración:
   • Navegacion.kt actualizada
   • AndroidManifest.xml (permiso INTERNET)
   • build.gradle.kts (dependencias)

═══════════════════════════════════════════════════════════════════

🎯 CARACTERÍSTICAS IMPLEMENTADAS:

✓ Carga asíncrona de datos
✓ Indicadores de progreso visual
✓ Manejo de errores automático
✓ Validación de formularios
✓ CRUD completo para clientes y vuelos
✓ UI reactiva con Material Design 3
✓ Navegación fluida
✓ Integración Retrofit completamente funcional

═══════════════════════════════════════════════════════════════════

⚠️ POSIBLES PROBLEMAS Y SOLUCIONES:

Problema: "Connection refused"
→ Verifica que el servidor backend esté corriendo
→ Prueba: curl http://192.168.56.1:8080/clientes

Problema: "Json parsing error"
→ Verifica que la respuesta del backend coincide con los modelos
→ Revisa: data/model/model/Cliente.kt y Vuelos.kt

Problema: "No aparecen datos"
→ Verifica que hay datos en la API
→ Usa Postman para probar: http://192.168.56.1:8080/clientes

Problema: "Botones no funcionan"
→ Verifica que la API URL es correcta en RetrofitCliente.kt
→ Revisa los logs en Android Studio Logcat

Problema: "Error de compilación con imports"
→ Sincroniza proyecto: File → Sync Now
→ Invalida caché: File → Invalidate Caches

═══════════════════════════════════════════════════════════════════

📚 DOCUMENTACIÓN DISPONIBLE:

Dentro del proyecto encontrarás:

1. CAMBIOS_API.kt
   → Resumen de todos los cambios realizados

2. README_API.md
   → Documentación completa sobre la integración

3. GUIA_INTEGRACION.kt
   → Guía paso a paso de la arquitectura

4. ARQUITECTURA_VISUAL.kt
   → Diagramas y flujos de datos

5. CHECKLIST_FINAL.kt
   → Verificación completa de implementación

6. FINAL_RESUMEN.kt
   → Resumen ejecutivo de lo realizado

═══════════════════════════════════════════════════════════════════

✨ TIPS IMPORTANTES:

1. ViewModels se crean automáticamente en Navegacion()
   → No necesitas crear instancias manualmente

2. Los datos se cargan automáticamente al iniciar
   → loadClientes() y loadVuelos() se llaman en init {}

3. Los indicadores de carga aparecen automáticamente
   → La UI responde a cambios en isLoading

4. Los errores se muestran en Cards rojas
   → Sin necesidad de gestionar manualmente

5. Puedes reintentar operaciones fallidas
   → La UI permite reintentos automáticos

═══════════════════════════════════════════════════════════════════

🧪 PRUEBAS RECOMENDADAS:

Test 1: Crear Cliente
☐ App abierta → Menú principal
☐ Toca "Crear Cliente"
☐ Llena nombre, apellido, email, teléfono, documento
☐ Toca "Crear Cliente"
☐ Debe aparecer indicador de carga
☐ Debe mostrar "Cliente creado exitosamente"

Test 2: Crear Vuelo
☐ App abierta → Menú principal
☐ Toca "Crear Vuelo"
☐ Selecciona cliente creado anteriormente
☐ Llena código, origen, destino, horarios, asientos
☐ Toca "Crear Vuelo"
☐ Debe mostrar éxito
☐ Vuelo debe aparecer en "Administrar Vuelos"

Test 3: Listar Datos
☐ Toca "Administrar Clientes"
☐ Debe ver lista de clientes
☐ Toca "Administrar Vuelos"
☐ Debe ver lista de vuelos con detalles

Test 4: Eliminar
☐ En lista de clientes, toca botón rojo
☐ Cliente se elimina de la API
☐ Lista se actualiza automáticamente
☐ Repetir para vuelos

═══════════════════════════════════════════════════════════════════

🎓 PARA APRENDER MÁS:

Sobre ViewModels:
→ developer.android.com/guide/fragments/lifecycle

Sobre Compose:
→ developer.android.com/jetpack/compose

Sobre Retrofit:
→ square.github.io/retrofit/

Sobre Navigation:
→ developer.android.com/guide/navigation

Sobre Coroutines:
→ developer.android.com/kotlin/coroutines

═══════════════════════════════════════════════════════════════════

📞 SOPORTE:

Si encuentras problemas:
1. Revisa los logs en Logcat
2. Verifica que el servidor backend esté activo
3. Consulta la documentación en los archivos .kt
4. Prueba endpoints manualmente con curl/Postman

═══════════════════════════════════════════════════════════════════

✅ ¡LISTO PARA COMPILAR Y EJECUTAR! 🚀

Ejecuta: ./gradlew build

La aplicación está completamente adaptada para consumir la API.
Todos los ViewModels, vistas y configuración están en su lugar.

¡Que disfrutes usando Flight Track! ✈️

*/

