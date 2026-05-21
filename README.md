# Flight Track - Sistema de Administración de Vuelos y Pasajeros

## 🏛️ Universidad Americana (UAM)
**Asignatura:** Programación Orientada a Objetos II  
**Examen:** Flight Track (Corte II)  
**Docente:** José Durán  
**Fecha:** 20 de Mayo, 2026  

### 👥 Integrantes del Equipo
* **Allan Raul Valentin Acuña Otero** (CIF: 24010953)
* **Fernando Gabriel Gómez Gazo** (CIF: 23012349)
* **Alvaro Joel Cortez Delgado** (CIF: 24011569)
* **Guillermo José Vegas Vega** (CIF: 24010412)

---

## ✈️ 1. Tema de la Aplicación
**Flight Track** es una solución integral para la administración y control de vuelos y pasajeros. El sistema está diseñado para optimizar los flujos de trabajo de las aerolíneas y el personal de gestión, permitiendo un registro organizado y un seguimiento en tiempo real de los itinerarios de viaje y los usuarios asociados a cada vuelo.

La arquitectura del sistema se divide en dos componentes principales:
1.  **Backend:** Un servidor robusto desarrollado en Java con Spring Boot que expone una API REST.
2.  **Frontend:** Una aplicación móvil nativa desarrollada en Android Studio que consume dicha API y ofrece una navegación fluida entre pantallas.

---

## 🛠️ 2. Tecnologías Utilizadas
El ecosistema tecnológico se seleccionó para garantizar la escalabilidad en el servidor y una experiencia de usuario óptima en el dispositivo móvil. El proyecto se rige bajo una arquitectura **Cliente-Servidor**:

| Componente | Tecnología / Framework | Descripción y Uso |
| :--- | :--- | :--- |
| **Backend (API)** | Java / Spring Boot | Encargado de la lógica de negocio, persistencia de datos y exposición de endpoints REST para la gestión de vuelos y pasajeros. |
| **Mobile Client** | Android Studio | Entorno de desarrollo utilizado para construir la aplicación móvil nativa, gestionar las interfaces de usuario y la navegación bajo la arquitectura **MVVM**. |
| **Base de Datos** | PostgreSQL | Sistema de gestión de bases de datos relacionales donde se almacena de forma permanente y segura la información de los vuelos y los clientes. |
| **Comunicación** | HTTP / JSON | Protocolo e intercambio de datos estándar entre la aplicación Android y la API de Spring Boot. |
| **Herramientas** | Spring Initializr / Postman | **Spring Initializr** para la configuración inicial de dependencias del backend. **Postman** para pruebas de integración, validación de respuestas JSON e inserción de datos de prueba de manera aislada. |

---

## ⚙️ 3. Funcionamiento General del Sistema
El flujo de datos e interacción del sistema sigue el siguiente ciclo:
1. La aplicación móvil (`Android Studio`) realiza peticiones HTTP hacia la API REST (`Spring Boot`).
2. El backend procesa la solicitud (Operaciones CRUD: creación, lectura, actualización o eliminación).
3. El backend interactúa con la base de datos `PostgreSQL` para persistir o consultar la información de manera segura.
4. El servidor retorna una respuesta en formato estándar `JSON` al cliente móvil.
5. La aplicación Android recibe estos datos, actualiza su estado interno y refresca la interfaz gráfica para el usuario de manera inmediata.

---

## 🚀 4. Funcionalidades Principales e Implementadas
* **Gestión de Vuelos:** Permite registrar nuevos vuelos ingresando datos clave (número de vuelo, origen, destino, fecha y hora) y modificar o consultar su disponibilidad.
* **Gestión de Pasajeros:** Registro de usuarios del servicio con sus datos personales e información de contacto.
* **Asignación y Vinculación:** Capacidad de asociar pasajeros específicos a vuelos determinados, manteniendo el estricto control de los manifiestos de abordaje.

---

## 📱 5. Navegación entre Pantallas
La aplicación móvil cuenta con un flujo de navegación estructurado y optimizado que guía al usuario a través de los siguientes módulos:
* `cargaScreen`: Pantalla inicial de bienvenida (Splash Screen) que muestra una animación de carga mientras se preparan los recursos de la app y se verifica la conexión con la API.
* `HomeScreen`: Panel principal o menú de la aplicación desde el cual el usuario puede acceder a los diferentes módulos de gestión.
* **Crear Vuelo:** Formulario optimizado para la inserción de nuevos itinerarios aéreos en el sistema.
* **Crear Pasajero:** Formulario de registro para dar de alta a nuevos clientes en la base de datos.
* **Administrar Vuelo:** Pantalla de visualización y edición donde se pueden listar, filtrar y modificar los detalles de los vuelos existentes.
* **Administrar Pasajero:** Módulo de control para listar los pasajeros registrados, editar su información o desvincularlos de un itinerario.

---

## 🔄 6. Manejo de Estado
El manejo de estado en la aplicación Android asegura que los datos visualizados correspondan a la información real del servidor. Se implementaron mecanismos para conservar la consistencia de los datos durante la navegación entre pantallas y los ciclos de vida de los componentes, garantizando que:
* Los formularios limpien o retengan la información adecuadamente según la acción requerida.
* Las listas de administración se refresquen de forma reactiva tras cada inserción o edición exitosa en la base de datos.

---

## 🔗 Enlaces del Proyecto
* 🎥 **Video Explicativo del Funcionamiento:** [Ver Video en Google Drive](https://drive.google.com/drive/folders/14yL7paJtaaeBvs-IbUbGGKuNLXJOyr6e?usp=sharing)
* 💻 **Repositorio de GitHub:** [allnrvao/examen_Corte2](https://github.com/allnrvao/examen_Corte2.git)
