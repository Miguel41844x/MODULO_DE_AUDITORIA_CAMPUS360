# Arquitectura del Sistema – Modelo 4+1

## Introducción

El módulo de auditoría del sistema Campus360 fue diseñado siguiendo el modelo de arquitectura *4+1*, propuesto por Philippe Kruchten. Este modelo permite describir la arquitectura de un sistema desde diferentes perspectivas, facilitando la comprensión del sistema tanto para desarrolladores como para otros stakeholders.

Las cinco vistas del modelo son:

* Vista lógica
* Vista de procesos
* Vista de desarrollo
* Vista física
* Escenarios (+1)

---

## 1. Vista Lógica

La vista lógica describe la estructura funcional del sistema y cómo se organizan las clases principales que componen el módulo de auditoría.

Las principales clases identificadas son:

* *AuditoriaController*
* *AuditoriaService*
* *EventoAuditoria*
* *Usuario*
* *Entidad*
* *Cambio*

El controlador gestiona las solicitudes del cliente y delega la lógica al servicio de auditoría. El servicio procesa las operaciones relacionadas con eventos de auditoría y utiliza repositorios para acceder a la base de datos.

Esta vista se representa mediante un *diagrama de clases UML* donde se observa la relación entre controladores, servicios, entidades y repositorios.

---

## 2. Vista de Procesos

La vista de procesos describe el comportamiento dinámico del sistema y cómo interactúan los componentes durante la ejecución.

En el módulo de auditoría, los procesos principales incluyen:

* Registro de eventos de auditoría
* Consulta de historial de cambios
* Consulta de eventos por entidad
* Exportación de registros de auditoría

Estas interacciones se representan mediante *diagramas de secuencia*, donde se muestra cómo el cliente envía una solicitud al controlador, el controlador invoca al servicio y el servicio consulta o registra información mediante los repositorios.

---

## 3. Vista de Desarrollo

La vista de desarrollo describe la organización del sistema en módulos o paquetes dentro del código fuente.

El proyecto se estructura en los siguientes módulos principales:

* *controller* → Manejo de solicitudes HTTP
* *service* → Lógica de negocio
* *repository* → Acceso a datos
* *model/entity* → Entidades del sistema
* *dto* → Objetos de transferencia de datos

Esta organización facilita el mantenimiento del sistema, promueve la reutilización de componentes y mejora la claridad del código.

---

## 4. Vista Física

La vista física describe la infraestructura donde se ejecuta el sistema.

El módulo de auditoría se ejecuta dentro de una aplicación backend desarrollada con *Spring Boot*, desplegada en un servidor de aplicaciones. Este backend se conecta a una base de datos relacional donde se almacenan los registros de auditoría.

Los principales componentes de infraestructura incluyen:

* Servidor de aplicaciones
* Backend Spring Boot
* Cliente web o herramientas de prueba como Postman

---

## 5. Escenarios (+1)

Los escenarios representan casos de uso que permiten validar la arquitectura del sistema.

Un ejemplo de escenario es la consulta del historial de auditoría:

1. El usuario solicita ver el historial de auditoría desde el cliente.
2. El cliente envía una solicitud HTTP al *AuditoriaController*.
3. El controlador delega la solicitud al *AuditoriaService*.
4. El servicio consulta los eventos mediante el repositorio.
5. Los resultados se devuelven al cliente para su visualización.

Estos escenarios permiten verificar que las diferentes vistas de la arquitectura funcionan de manera coherente.
