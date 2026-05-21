/*
╔════════════════════════════════════════════════════════════════╗
║         PANTALLAS FINALES - INTERFACE USUARIO (UI)            ║
╚════════════════════════════════════════════════════════════════╝

═══════════════════════════════════════════════════════════════════

PANTALLA 1: HOME SCREEN (Menú Principal)
═════════════════════════════════════════

Visualmente se ve así:

┌──────────────────────────────────────────┐
│                                          │
│      Administración de Vuelos            │
│                                          │
│  ┌────────────────────────────────────┐  │
│  │  ✈️ Crear Vuelo                   │  │
│  └────────────────────────────────────┘  │
│                                          │
│  ┌────────────────────────────────────┐  │
│  │  👤 Crear Cliente                 │  │
│  └────────────────────────────────────┘  │
│                                          │
│  ┌────────────────────────────────────┐  │
│  │  📋 Administrar Vuelos            │  │
│  └────────────────────────────────────┘  │
│                                          │
│  ┌────────────────────────────────────┐  │
│  │  👥 Administrar Clientes          │  │
│  └────────────────────────────────────┘  │
│                                          │
└──────────────────────────────────────────┘

Interacción:
• Toca cualquier card para navegar
• Cada tarjeta tiene elevación (shadow)
• Las tarjetas tienen fondo ligeramente más claro
• Iconos coloridos a la izquierda
• Texto descriptivo a la derecha

═══════════════════════════════════════════════════════════════════

PANTALLA 2: ADMINISTRAR VUELOS (Nueva y Mejorada)
═════════════════════════════════════════════════

Cuando está CARGANDO:

┌──────────────────────────────────────────┐
│ ← Volver                                 │
│                                          │
│ Administrar Vuelos                       │
│                                          │
│                                          │
│           ⏳ Cargando...                 │
│         (CircularProgressIndicator)     │
│                                          │
│                                          │
└──────────────────────────────────────────┘

Cuando está VACÍO:

┌──────────────────────────────────────────┐
│ ← Volver                                 │
│                                          │
│ Administrar Vuelos                       │
│                                          │
│ ┌────────────────────────────────────┐   │
│ │  No hay vuelos                    │   │
│ │  (Card gris)                       │   │
│ └────────────────────────────────────┘   │
│                                          │
└──────────────────────────────────────────┘

Cuando hay ERROR:

┌──────────────────────────────────────────┐
│ ← Volver                                 │
│                                          │
│ Administrar Vuelos                       │
│                                          │
│ ┌────────────────────────────────────┐   │
│ │ ❌ Error: Connection refused       │   │
│ │ (Card roja)                        │   │
│ └────────────────────────────────────┘   │
│                                          │
└──────────────────────────────────────────┘

Cuando hay DATOS (La pantalla principal):

┌──────────────────────────────────────────┐
│ ← Volver                                 │
│                                          │
│ Administrar Vuelos                       │
│                                          │
│ ┌────────────────────────────────────┐   │
│ │ Vuelo: AA-200                     │   │
│ │                                    │   │
│ │ Origen: New York                   │   │
│ │ Destino: Los Angeles               │   │
│ │                                    │   │
│ │ Salida: 08:00                      │   │
│ │ Llegada: 11:30                     │   │
│ │                                    │   │
│ │ Asientos disponibles: 150          │   │
│ │ Cliente: Juan Pérez                │   │
│ │                                    │   │
│ │ [Eliminar] (botón rojo)           │   │
│ └────────────────────────────────────┘   │
│                                          │
│ ┌────────────────────────────────────┐   │
│ │ Vuelo: DL-100                     │   │
│ │                                    │   │
│ │ Origen: Miami                      │   │
│ │ Destino: Cancún                    │   │
│ │                                    │   │
│ │ Salida: 10:15                      │   │
│ │ Llegada: 11:45                     │   │
│ │                                    │   │
│ │ Asientos disponibles: 200          │   │
│ │ Cliente: Carlos Ruiz               │   │
│ │                                    │   │
│ │ [Eliminar] (botón rojo)           │   │
│ └────────────────────────────────────┘   │
│                                          │
│ ┌────────────────────────────────────┐   │
│ │ Vuelo: UA-55                      │   │
│ │ ... más vuelos (scroll)            │   │
│ └────────────────────────────────────┘   │
│                                          │
└──────────────────────────────────────────┘

Interacciones:
• ← Volver: Regresa a HomeScreen
• [Eliminar]: Elimina vuelo de la API y actualiza lista
  - Durante eliminación: botón deshabilitado, indicador de carga
  - Si éxito: vuelo desaparece de la lista
  - Si error: muestra mensaje en card roja

Scroll:
• La lista es scrolleable (LazyColumn)
• Si hay muchos vuelos, puedes deslizar hacia abajo
• Performance optimizado (solo renderiza lo visible)

═══════════════════════════════════════════════════════════════════

DETALLES DE CADA VUELO (Card):

┌─────────────────────────────────────────┐
│ Vuelo: AA-200         ← Título principal│
│                                         │
│ Origen: New York      ← Campo primario  │
│ Destino: Los Angeles  ← Campo primario  │
│                                         │
│ Salida: 08:00         ← Detalles        │
│ Llegada: 11:30        ← Detalles        │
│                                         │
│ Asientos disponibles: 150  ← Información│
│ Cliente: Juan Pérez        ← Información│
│                                         │
│ [Eliminar]            ← Acción (rojo)  │
└─────────────────────────────────────────┘

Colores y estilos:
• Fondo: Card con elevación (shadow)
• Título: Color primario, tamaño grande
• Campos: Colores neutros
• Botón: Rojo (color de error/destrucción)
• Espaciado: 8-16dp entre elementos

═══════════════════════════════════════════════════════════════════

BOTÓN "VOLVER" SUPERIOR:

Antes de clickear:
┌─────────────────────────────────────────┐
│ ← Volver                                │
└─────────────────────────────────────────┘
(Habilitado, texto gris, icono visible)

Mientras se carga algo:
┌─────────────────────────────────────────┐
│ ← Volver  (deshabilitado)               │
└─────────────────────────────────────────┘
(Botón atenuado, no responde a clicks)

═══════════════════════════════════════════════════════════════════

ANIMACIONES:

1. Carga inicial:
   CircularProgressIndicator gira
   Dura hasta que se reciban los datos

2. Eliminación:
   - Botón muestra indicador de progreso
   - Botón se deshabilita
   - Cuando se completa → Vuelo desaparece con fade

3. Transiciones:
   - Al entrar: Slide + Fade suave
   - Al salir: Fade hacia atrás

═══════════════════════════════════════════════════════════════════

ESTADOS POSIBLES DE LA PANTALLA:

1. LOADING (Cargando datos)
   ✓ Se muestra CircularProgressIndicator
   ✓ Todos los botones deshabilitados
   ✓ Mensaje "Cargando..."

2. VACIO (No hay datos)
   ✓ Se muestra card gris
   ✓ Mensaje "No hay vuelos"
   ✓ Botón volver disponible

3. ERROR (Conexión o servidor)
   ✓ Se muestra card roja
   ✓ Mensaje de error detallado
   ✓ Botón volver disponible

4. EXITOSO (Datos cargados)
   ✓ Se muestran todas las tarjetas
   ✓ LazyColumn scrolleable
   ✓ Botones "Eliminar" funcionales

5. ELIMINANDO (Borrando un vuelo)
   ✓ Card se deshabilita temporalmente
   ✓ Indicador de carga en el botón
   ✓ Otros botones aún funcionales

═══════════════════════════════════════════════════════════════════

EXPERIENCIA DEL USUARIO:

Flujo completo:
1. Usuario abre app
2. Ve menú (HomeScreen)
3. Toca "Administrar Vuelos"
4. Navega a AdministrarVuelosScreen
5. Indicador de carga aparece brevemente
6. Lista de vuelos se muestra
7. Usuario ve todos los detalles de cada vuelo
8. Puede tocar "Eliminar" en cualquier vuelo
9. Vuelo se borra de la lista automáticamente
10. Puede volver al menú con botón "Volver"

Todo sucede sin necesidad de refrescar manualmente.
La UI siempre está sincronizada con el servidor.

═══════════════════════════════════════════════════════════════════

INFORMACIÓN MOSTRADA POR VUELO:

1. Código del vuelo (ej: AA-200)
   → Identificador único del vuelo

2. Origen (ej: New York)
   → De dónde sale el vuelo

3. Destino (ej: Los Angeles)
   → A dónde va el vuelo

4. Hora de salida (ej: 08:00)
   → A qué hora despega

5. Hora de llegada (ej: 11:30)
   → A qué hora aterriza

6. Asientos disponibles (ej: 150)
   → Cuántos asientos hay

7. Nombre del cliente (ej: Juan Pérez)
   → Quién es el responsable del vuelo

═══════════════════════════════════════════════════════════════════

ESTILOS Y COLORES UTILIZADOS:

Azul (Material 3 Primary):
• Títulos principales
• Botones primarios
• Iconos de navegación

Gris (Material 3 Secondary):
• Campos secundarios
• Fondos alternativos
• Botón "Volver"

Rojo (Material 3 Error):
• Botón "Eliminar"
• Mensajes de error
• Cards de error

Verde (Material 3 Success):
• (Podría usarse para confirmaciones)

Blanco/Claro:
• Fondos principales
• Cards

═══════════════════════════════════════════════════════════════════

TIPOGRAFÍA:

Título principal: "Administrar Vuelos"
├── Font: Headline Medium (24sp)
├── Color: Primary
└── Peso: Bold

Código de vuelo: "Vuelo: AA-200"
├── Font: Title Medium (16sp)
├── Color: Primary
└── Peso: Medium

Campos: "Origen: New York"
├── Font: Body Medium (14sp)
├── Color: On Surface
└── Peso: Normal

Detalles: "Salida: 08:00"
├── Font: Body Small (12sp)
├── Color: On Surface Variant
└── Peso: Normal

═══════════════════════════════════════════════════════════════════

ESPACIADO (dp):

Entre pantalla y contenido: 16dp
Entre cards: 16dp
Dentro de card: 16dp
Entre campos en card: 8dp
Altura de botones: 40dp

═══════════════════════════════════════════════════════════════════

Este es el resultado visual final que verás en la pantalla.

Todas las pantallas siguen Material Design 3 guidelines.
La interfaz es intuitiva, responsiva y accesible.

*/

