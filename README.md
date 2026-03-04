# Campus360 – Módulo de Auditoría

## Descripción del proyecto

El presente proyecto implementa un módulo de auditoría para el sistema Campus360. Este módulo permite registrar, consultar y exportar eventos de auditoría generados por las acciones realizadas dentro del sistema por los distintos usuarios.

El objetivo principal es proporcionar trazabilidad de las operaciones realizadas en el sistema, permitiendo identificar qué cambios se realizaron, quién los realizó y en qué momento ocurrieron. De esta manera se facilita el monitoreo, control y análisis de las actividades dentro de la plataforma.

El sistema fue desarrollado siguiendo una arquitectura en capas utilizando el framework Spring Boot para el backend, aplicando buenas prácticas de diseño de software y principios SOLID para mejorar la mantenibilidad y escalabilidad del sistema.

---

## Tecnologías utilizadas

Backend

* Java
* Spring Boot
* Spring Data JPA
* Maven

Frontend

* HTML
* CSS
* JavaScript

Herramientas

* Git
* Postman
* Visual Studio Code / IntelliJ IDEA

---

## Funcionalidades del módulo de auditoría

* Registro de eventos de auditoría generados por acciones del sistema.
* Consulta de eventos de auditoría por entidad.
* Consulta del historial de cambios realizados.
* Visualización de detalles de cada evento de auditoría.
* Exportación de reportes de auditoría.

---

## Arquitectura del sistema

El módulo de auditoría sigue una arquitectura en capas compuesta por:

* **Controladores (Controllers):** gestionan las solicitudes HTTP provenientes del cliente.
* **Servicios (Services):** contienen la lógica de negocio del sistema.
* **Repositorios (Repositories):** se encargan del acceso y persistencia de datos en la base de datos.
* **Entidades (Entities):** representan los modelos de datos del sistema.
* **DTOs:** objetos utilizados para transferir datos entre capas del sistema.

Esta estructura permite mantener una separación clara de responsabilidades, facilitando el mantenimiento y evolución del sistema.

---

## Estructura del proyecto

CAMPUS360-AUDITORIA/

backend/
Código fuente del backend desarrollado con Spring Boot.

frontend/
Código del cliente web desarrollado con HTML, CSS y JavaScript.

docs/
Documentación del proyecto y entregables académicos.

docs/PE1/
Avance del proyecto que incluye diagramas UML y documentación inicial.

docs/PE2/
Informe final del proyecto.

docs/Arquitectura_4+1.md
Documento que describe la arquitectura del sistema utilizando el modelo 4+1.

API_Contract.md
Documento que describe los endpoints REST del sistema.

---

## Ejecución del proyecto

Para ejecutar el sistema se deben seguir los siguientes pasos:

1. Clonar el repositorio del proyecto.
2. Abrir la carpeta **backend** en un entorno de desarrollo como IntelliJ IDEA o Visual Studio Code.
3. Configurar la conexión a la base de datos en el archivo `application.properties`.
4. Ejecutar la aplicación Spring Boot.
5. Utilizar Postman o el frontend para consumir los endpoints del sistema.

---

## Autoría

Proyecto desarrollado como parte del curso de Arquitectura de Software.

Grupo 09
