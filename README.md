# 🛰️ SWAPI App - Star Wars REST Client

Aplicación desarrollada en Java 8 con Spring Boot que consume la API pública de Star Wars ([SWAPI.tech](https://www.swapi.tech/)).

---

## 🚀 Tecnologías utilizadas

- Java 8
- Spring Boot 2.7.18
- Maven
- Spring Web + RestTemplate
- Spring Security (autenticación básica)
- Swagger / OpenAPI 3 (documentación)
- Lombok

---

## 📚 Funcionalidades

La aplicación permite:

- Listar y buscar por ID o nombre los siguientes recursos:
  - People
  - Films
  - Starships
  - Vehicles
- Manejo de excepciones centralizado
- Validaciones personalizadas
- Documentación interactiva con Swagger UI

---

## ▶️ Ejecución local

1. Clonar el repositorio:

```bash
git clone https://github.com/usuario/swapi-app.git
cd swapi-app

```

## 🔐 Seguridad
Esta API está protegida con autenticación HTTP Basic.

- Usuario: admin

- Contraseña: admin123
## 📘 Documentación Swagger
Una vez levantada la app, accedé a la documentación interactiva en:
- 🔗 http://localhost:8080/swagger-ui/index.html

Desde ahí podés probar cada endpoint, ver los parámetros requeridos, la respuesta esperada y más.


📌 Endpoints disponibles
Todos los endpoints expuestos están bajo el prefijo /api:

## People
- GET /api/people → Listado paginado de personas

- GET /api/people/{id} → Buscar persona por ID

- GET /api/people/search?name= → Buscar por nombre

## Films

- GET /api/films → Listado de películas

- GET /api/films/{id} → Buscar película por ID

## Starships
- GET /api/starships → Listado de naves

- GET /api/starships/{id} → Buscar nave por ID

## Vehicles
- GET /api/vehicles → Listado de vehículos

- GET /api/vehicles/{id} → Buscar vehículo por ID