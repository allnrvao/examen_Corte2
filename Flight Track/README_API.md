# Flight Track - Adaptación a Consumo de API

## Descripción de Cambios

La aplicación ha sido completamente adaptada para consumir datos desde una API REST usando Retrofit. Se ha implementado una arquitectura moderna con ViewModels y StateFlow para manejo reactivo del estado.

## Estructura del Proyecto

### ViewModels (Lógica de Negocio)
- **VuelosViewModel.kt**: Maneja todas las operaciones relacionadas con vuelos
  - `loadVuelos()`: Carga la lista de vuelos desde la API
  - `createVuelo()`: Crea un nuevo vuelo
  - `deleteVuelo()`: Elimina un vuelo
  - `updateVuelo()`: Actualiza un vuelo existente

- **ClientesViewModel.kt**: Maneja todas las operaciones relacionadas con clientes
  - `loadClientes()`: Carga la lista de clientes desde la API
  - `createCliente()`: Crea un nuevo cliente
  - `deleteCliente()`: Elimina un cliente
  - `updateCliente()`: Actualiza un cliente existente

### Vistas (UI - Compose)
- **HomeScreen.kt**: Pantalla principal con navegación
- **CrearClienteScreen.kt**: Formulario para crear clientes
- **CrearVueloScreen.kt**: Formulario para crear vuelos (requiere seleccionar cliente)
- **AdministrarClientesScreen.kt**: Lista y gestión de clientes
- **AdministrarVuelosScreen.kt**: Lista y gestión de vuelos
- **CargaScreen.kt**: Pantalla de carga (splash)

### Navegación
- **Navegacion.kt**: Configuración de rutas y navegación con NavController

## Flujo de Datos

```
UI (Composable) 
    ↓ (recolecta StateFlow)
ViewModel 
    ↓ (llama métodos API)
Retrofit / ClienteApi / VuelosApi
    ↓ (HTTP Request)
Backend API (http://192.168.56.1:8080/)
    ↓ (JSON Response)
Retrofit (deserializa con Gson)
    ↓ (emite resultado)
ViewModel (actualiza StateFlow)
    ↓ (dispara recomposición)
UI (se actualiza automáticamente)
```

## Estados Disponibles

Cada ViewModel mantiene tres StateFlow principales:
- **isLoading**: Boolean - Indica si hay una operación en progreso
- **errorMessage**: String - Contiene mensaje de error (vacío si no hay error)
- **vuelos/clientes**: List - Datos actualizados de la API

## Permisos Necesarios

Se ha agregado en AndroidManifest.xml:
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Dependencias Utilizadas

- **Retrofit**: Para hacer llamadas HTTP
- **Gson**: Para deserialización JSON
- **Jetpack Compose**: Para UI reactiva
- **Jetpack Navigation**: Para navegación entre pantallas
- **Jetpack ViewModel**: Para gestión del ciclo de vida
- **Jetpack Lifecycle**: Para StateFlow

## Configuración de la API

El URL base está configurado en `RetrofitCliente.kt`:
```kotlin
private const val BASE_URL = "http://192.168.56.1:8080/"
```

Asegúrate de que tu servidor backend esté ejecutándose en esa dirección.

## Endpoints Utilizados

### Clientes
- `GET /clientes` - Obtener todos los clientes
- `GET /clientes/{id}` - Obtener cliente por ID
- `POST /clientes` - Crear nuevo cliente
- `PUT /clientes/{id}` - Actualizar cliente
- `DELETE /clientes/{id}` - Eliminar cliente

### Vuelos
- `GET /vuelos` - Obtener todos los vuelos
- `GET /vuelos/{id}` - Obtener vuelo por ID
- `POST /vuelos` - Crear nuevo vuelo
- `PUT /vuelos/{id}` - Actualizar vuelo
- `DELETE /vuelos/{id}` - Eliminar vuelo

## Manejo de Errores

- Los errores de red se capturan automáticamente
- Se muestran mensajes de error al usuario en Cards rojos
- Los indicadores de carga se desactivan durante errores
- Los botones se deshabilitan mientras hay operaciones en progreso

## Características Implementadas

✅ Carga asíncrona de datos
✅ Indicadores de progreso visual
✅ Manejo de errores con feedback al usuario
✅ Validación de campos en formularios
✅ CRUD completo para clientes y vuelos
✅ Interfaz receptiva con Material Design 3
✅ Scroll automático en formularios largos
✅ Estados reactivos con StateFlow

## Próximas Mejoras (Opcional)

- Agregar búsqueda/filtrado de datos
- Implementar paginación para listas grandes
- Agregar más validaciones en formularios
- Implementar caché local con Room
- Agregar pull-to-refresh
- Mejorar animaciones de transición

