# Frontend – Módulo de Auditoría Campus360

Este proyecto corresponde al frontend del **Módulo de Auditoría Campus360**, desarrollado con React y Vite.  
Permite visualizar, registrar y exportar eventos de auditoría mediante una interfaz web conectada a una API REST desarrollada en Spring Boot.

El frontend consume los servicios del backend para mostrar la información de auditoría y permitir la interacción con el sistema.

---

# Requisitos Previos

Antes de ejecutar el proyecto, es necesario tener instalado:

- Node.js (versión 18 o superior recomendada)
- npm (incluido con Node.js)
- Backend del proyecto en ejecución

Puedes verificar si tienes Node instalado ejecutando:

```bash
node -v

Y para npm:

npm -v
Instalación del Proyecto

Primero debes instalar todas las dependencias necesarias.

Ubícate en la carpeta del frontend:

cd frontend

Luego ejecuta:

npm install

Este comando instalará todas las librerías necesarias para que el proyecto funcione correctamente.

Ejecución del Proyecto

Para iniciar el proyecto en modo desarrollo, ejecuta:

npm run dev

Esto iniciará el servidor de desarrollo de Vite.

Normalmente el proyecto se ejecutará en:

http://localhost:5173

Abre esa dirección en tu navegador para ver la aplicación.

Importante: Ejecutar el Backend Primero

Este frontend depende del backend para funcionar correctamente.

Debes iniciar primero el backend en:

http://localhost:8080

Si el backend no está ejecutándose, el frontend no podrá obtener los datos de auditoría.

Conexión con la API

El frontend se conecta al backend mediante endpoints REST como:

GET http://localhost:8080/api/auditoria
GET http://localhost:8080/api/auditoria/historial/{id}
POST http://localhost:8080/api/auditoria
GET http://localhost:8080/api/auditoria/exportar
Estructura del Proyecto
src
 ├── components
 ├── pages
 ├── services
 ├── App.jsx
 └── main.jsx
Descripción
components

Contiene los componentes reutilizables de React.

pages

Contiene las pantallas principales del sistema.

services

Contiene las funciones que consumen la API.

App.jsx

Componente principal de la aplicación.

main.jsx

Punto de entrada de React.

Scripts Disponibles
Instalar dependencias
npm install
Ejecutar proyecto
npm run dev
Construir para producción
npm run build
Vista previa de producción
npm run preview
Solución de Problemas

Si el proyecto no inicia:

Verifica que Node esté instalado

Ejecuta nuevamente:

npm install

Verifica que el backend esté corriendo

Revisa que el puerto 5173 no esté ocupado

Puertos Utilizados
Frontend
5173
Backend
8080
Dependencias Principales

El proyecto utiliza:

React

Vite

Axios

React Router