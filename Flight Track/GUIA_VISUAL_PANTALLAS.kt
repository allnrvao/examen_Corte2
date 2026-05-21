/*
╔════════════════════════════════════════════════════════════════╗
║           📱 GUÍA VISUAL DE PANTALLAS - FLIGHT TRACK          ║
╚════════════════════════════════════════════════════════════════╝

PANTALLA 1: HOME SCREEN (Menú Principal)
═════════════════════════════════════════

┌─────────────────────────────────┐
│   Administración de Vuelos       │
│                                 │
│ ┌───────────────────────────────┐│
│ │ ✈️ Crear Vuelo               ││
│ └───────────────────────────────┘│
│                                 │
│ ┌───────────────────────────────┐│
│ │ 👤 Crear Cliente              ││
│ └───────────────────────────────┘│
│                                 │
│ ┌───────────────────────────────┐│
│ │ 📋 Administrar Vuelos         ││
│ └───────────────────────────────┘│
│                                 │
│ ┌───────────────────────────────┐│
│ │ 👥 Administrar Clientes       ││
│ └───────────────────────────────┘│
│                                 │
└─────────────────────────────────┘

Acciones: Toca cualquier card para navegar

═════════════════════════════════════════════════════════════════

PANTALLA 2: CREAR CLIENTE
═════════════════════════

┌─────────────────────────────────┐
│ ← Volver | Crear Cliente        │
│                                 │
│ Nombres                         │
│ [________________________]       │
│                                 │
│ Apellidos                       │
│ [________________________]       │
│                                 │
│ Email                           │
│ [________________________]       │
│                                 │
│ Teléfono                        │
│ [________________________]       │
│                                 │
│ Documento                       │
│ [________________________]       │
│                                 │
│ [Crear Cliente]                 │
│                                 │
│ ✅ Cliente creado exitosamente  │
│    (mensaje verde)              │
│                                 │
│ ⏳ (indicador de carga)         │
│                                 │
└─────────────────────────────────┘

Validaciones:
• Todos los campos requeridos
• Muestra errores si faltan datos

═════════════════════════════════════════════════════════════════

PANTALLA 3: CREAR VUELO
═══════════════════════

┌─────────────────────────────────┐
│ ← Volver | Crear Vuelo          │
│                                 │
│ Código de vuelo                 │
│ [________________________]       │
│                                 │
│ Origen                          │
│ [________________________]       │
│                                 │
│ Destino                         │
│ [________________________]       │
│                                 │
│ Hora de salida                  │
│ [________________________]       │
│                                 │
│ Hora de llegada                 │
│ [________________________]       │
│                                 │
│ Asientos disponibles            │
│ [________________________]       │
│                                 │
│ Cliente                         │
│ [Seleccione un cliente ▼]       │
│ (Dropdown muestra: Juan Pérez)  │
│ (Dropdown muestra: Carlos Ruiz) │
│                                 │
│ [Crear Vuelo]                   │
│                                 │
│ ✅ Vuelo creado exitosamente    │
│                                 │
└─────────────────────────────────┘

Validaciones:
• Todos los campos requeridos
• Cliente debe seleccionarse
• Asientos debe ser número válido

═════════════════════════════════════════════════════════════════

PANTALLA 4: ADMINISTRAR CLIENTES
═══════════════════════════════

┌─────────────────────────────────┐
│ ← Volver | Administrar Clientes │
│                                 │
│ ┌───────────────────────────────┐│
│ │ Juan Pérez                    ││
│ │ Email: juan@example.com       ││
│ │ Tel: 1234567890              ││
│ │ Doc: 12345678                ││
│ │ [Eliminar]                    ││
│ └───────────────────────────────┘│
│                                 │
│ ┌───────────────────────────────┐│
│ │ Carlos Ruiz                   ││
│ │ Email: carlos@example.com     ││
│ │ Tel: 9876543210              ││
│ │ Doc: 87654321                ││
│ │ [Eliminar]                    ││
│ └───────────────────────────────┘│
│                                 │
│ ┌───────────────────────────────┐│
│ │ María González                ││
│ │ Email: maria@example.com      ││
│ │ Tel: 5555555555              ││
│ │ Doc: 11111111                ││
│ │ [Eliminar]                    ││
│ └───────────────────────────────┘│
│                                 │
│ (scroll si hay más)             │
│                                 │
│ ⏳ Cargando...                  │
│                                 │
└─────────────────────────────────┘

Acciones:
• Ver lista de todos los clientes
• Toca "Eliminar" para borrar
• Se actualiza automáticamente
• Indicador de carga durante operaciones

═════════════════════════════════════════════════════════════════

PANTALLA 5: ADMINISTRAR VUELOS
══════════════════════════════

┌─────────────────────────────────┐
│ ← Volver | Administrar Vuelos   │
│                                 │
│ ┌───────────────────────────────┐│
│ │ Vuelo: AA-200                 ││
│ │ Origen: New York              ││
│ │ Destino: Los Angeles          ││
│ │ Salida: 08:00                 ││
│ │ Llegada: 11:30                ││
│ │ Asientos: 150                 ││
│ │ Cliente: Juan Pérez           ││
│ │ [Eliminar]                    ││
│ └───────────────────────────────┘│
│                                 │
│ ┌───────────────────────────────┐│
│ │ Vuelo: DL-100                 ││
│ │ Origen: Miami                 ││
│ │ Destino: Cancún               ││
│ │ Salida: 10:15                 ││
│ │ Llegada: 11:45                ││
│ │ Asientos: 200                 ││
│ │ Cliente: Carlos Ruiz          ││
│ │ [Eliminar]                    ││
│ └───────────────────────────────┘│
│                                 │
│ (scroll si hay más)             │
│                                 │
│ ⏳ Cargando lista...            │
│                                 │
└─────────────────────────────────┘

Acciones:
• Ver lista de todos los vuelos
• Información completa de cada vuelo
• Toca "Eliminar" para borrar
• Se actualiza automáticamente

═════════════════════════════════════════════════════════════════

ESTADOS ESPECIALES:

ESTADO: Cargando
┌─────────────────────────────────┐
│                                 │
│     ⏳ Cargando...              │
│     ████░░░░░░░░░░░░░░░         │
│                                 │
└─────────────────────────────────┘

ESTADO: Lista Vacía
┌─────────────────────────────────┐
│                                 │
│    No hay clientes               │
│                                 │
│  (Card gris con mensaje)        │
│                                 │
└─────────────────────────────────┘

ESTADO: Error
┌─────────────────────────────────┐
│                                 │
│    ❌ Error: Conexión negada    │
│                                 │
│    (Card roja con error)        │
│                                 │
└─────────────────────────────────┘

ESTADO: Éxito
┌─────────────────────────────────┐
│                                 │
│    ✅ Cliente creado            │
│       exitosamente              │
│                                 │
│    (Card verde con confirmación)│
│                                 │
└─────────────────────────────────┘

═════════════════════════════════════════════════════════════════

ELEMENTOS INTERACTIVOS:

Botones Primarios (Azul):
┌─────────────────────────────────┐
│          [Crear Cliente]        │
└─────────────────────────────────┘
Acción: Guardar/Crear elemento

Botones Secundarios (Gris):
┌─────────────────────────────────┐
│          ← Volver              │
└─────────────────────────────────┘
Acción: Ir atrás en navegación

Botones Destructivos (Rojo):
┌─────────────────────────────────┐
│          [Eliminar]            │
└─────────────────────────────────┘
Acción: Eliminar elemento

Campos de Texto:
┌─────────────────────────────────┐
│ Nombres                         │
│ [________________________]       │
│                                 │
└─────────────────────────────────┘
Entrada: Texto libre

Selectores (Dropdown):
┌─────────────────────────────────┐
│ Cliente                         │
│ [Seleccione un cliente ▼]       │
│  ✓ Juan Pérez                   │
│  - Carlos Ruiz                  │
│  - María González               │
└─────────────────────────────────┘
Entrada: Selección de opciones

═════════════════════════════════════════════════════════════════

FLUJOS DE USUARIO:

FLUJO 1: Crear Cliente
─────────────────
Home → Crear Cliente → Llenar datos → Crear → 
✅ Confirmación → Home

FLUJO 2: Crear Vuelo
────────────────
Home → Crear Vuelo → Seleccionar cliente → 
Llenar datos → Crear → ✅ Confirmación → Home

FLUJO 3: Ver Clientes
──────────────────
Home → Administrar Clientes → 
Ver lista → (optional) Eliminar → Home

FLUJO 4: Ver Vuelos
──────────────────
Home → Administrar Vuelos → 
Ver lista → (optional) Eliminar → Home

═════════════════════════════════════════════════════════════════

COLORES UTILIZADOS:

🔵 Azul (Primario)      - Botones principales, selecciones
⚫ Gris (Secundario)    - Botones secundarios, fondos
🔴 Rojo (Error/Destroy) - Botones destructivos, errores
🟢 Verde (Éxito)        - Confirmaciones, éxito
⚪ Blanco (Fondo)       - Fondos principales
🟤 Gris Claro (Secundario bg) - Fondos alternativos

═════════════════════════════════════════════════════════════════

TIPOGRAFÍA:

Títulos:         Headline Medium (24sp)
Subtítulos:      Title Medium (16sp)
Contenido:       Body Medium (14sp)
Etiquetas:       Body Small (12sp)

═════════════════════════════════════════════════════════════════

ESPACIADO:

Entre elementos:  16dp
Dentro de cards:  16dp
Entre campos:     24dp
Top/Bottom:       16dp
Left/Right:       16dp

═════════════════════════════════════════════════════════════════

ANIMACIONES:

Indicador de carga:    Rotación circular
Progress bar:          Animate width
Transition:            Fade + Slide
Card elevation:        Cambio en hover/click

═════════════════════════════════════════════════════════════════

Esta es la experiencia visual esperada después de compilar exitosamente.

*/

