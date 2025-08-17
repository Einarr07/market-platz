# 🛒 API Supermercado

API REST desarrollada con **Spring Boot** para la gestión de un supermercado.  
Esta aplicación permite manejar **productos y compras**, con endpoints para creación, consulta y eliminación.

## 📌 Objetivo
Ofrecer un servicio centralizado para la gestión de productos y compras en un supermercado, permitiendo a los usuarios consultar, registrar y administrar la información.

## 🧑🏽‍💻 Entidades
La aplicación maneja las siguientes entidades principales:

- **Product (Producto):** Representa un producto del supermercado con atributos como nombre, precio, categoría e id.  
- **Purchase (Compra):** Representa la compra realizada por un cliente, con detalles de cliente, fecha e id.  

## 🚀 Funcionalidades

### Compra (Purchase Controller)
- `POST /purchase/create` → Guardar una compra  
- `GET /purchase` → Obtener todas las compras  
- `GET /purchase/{clienteId}` → Buscar compras por id de cliente  

---

### Productos (Product Controller)
- `POST /product/create` → Guardar un nuevo producto  
- `GET /product` → Obtener todos los productos  
- `GET /product/{id}` → Buscar producto por id  
- `GET /product/category/{id}` → Buscar productos por categoría  
- `DELETE /product/delete/{id}` → Eliminar producto por id  

---

## ⚙️ Tecnologías utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Maven 
- Docker  
- Swagger (documentación de la API)  

---

## 📂 Estructura del proyecto

```bash
src/main/java/com/supermarket/
├── domain/        # Lógica de dominio (modelos, DTOs, excepciones, repositorios y servicios)
│   ├── repository/ # Interfaces del dominio
│   └── service/   # Servicios de dominio
├── persistence/   # Capa de persistencia
│   ├── crud/      # Interfaces CRUD (JPA)
│   ├── entity/    # Entidades JPA
│   └── mapper/    # Mappers MapStruct
├── web/           # Capa web
│   ├── config/    # Configuraciones (Swagger, seguridad, etc.)
│   ├── controller/# Controladores REST
```

---

## Base de datos
- **MySQL**  

