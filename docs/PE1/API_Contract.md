# API Contract – Módulo de Auditoría

## Introducción

Este documento describe los endpoints REST disponibles en el módulo de auditoría del sistema Campus360. Estos endpoints permiten registrar, consultar y exportar eventos de auditoría generados por las acciones realizadas dentro del sistema.

La API sigue los principios de arquitectura REST y utiliza respuestas en formato JSON.

---

## Base URL

/api/auditoria

---

## 1. Listar eventos de auditoría

Obtiene la lista completa de eventos de auditoría registrados en el sistema.

Endpoint

GET /api/auditoria/eventos

Respuesta esperada

[
{
"idEvento": 1,
"fecha": "2025-06-10T12:30:00",
"accion": "UPDATE",
"descripcion": "Actualización de datos del estudiante"
}
]

---

## 2. Consultar historial de una entidad

Permite obtener todos los eventos de auditoría asociados a una entidad específica.

Endpoint

GET /api/auditoria/historial/{id}

Parámetros

id → identificador de la entidad

Ejemplo

GET /api/auditoria/historial/10

Respuesta

[
{
"idEvento": 5,
"accion": "UPDATE",
"fecha": "2025-06-10T15:00:00"
}
]

---

## 3. Ver detalle de un evento

Permite consultar el detalle de un evento específico de auditoría.

Endpoint

GET /api/auditoria/evento/{id}

Ejemplo

GET /api/auditoria/evento/5

Respuesta

{
"idEvento": 5,
"fecha": "2025-06-10T15:00:00",
"accion": "UPDATE",
"descripcion": "Cambio en datos del usuario",
"cambios": [
{
"campo": "nombre",
"valorAnterior": "Juan",
"valorNuevo": "Juan Carlos"
}
]
}

---

## 4. Exportar registros de auditoría

Permite exportar los eventos de auditoría en formato de archivo.

Endpoint

GET /api/auditoria/exportar

Respuesta

Archivo descargable con el reporte de auditoría.

---

## Códigos de respuesta

200 → Solicitud exitosa
404 → Recurso no encontrado
500 → Error interno del servidor
