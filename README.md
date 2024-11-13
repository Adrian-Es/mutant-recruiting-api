# Descripción de la API Mutant Challenge
Esta API, construida en Java 17 con Spring Boot y Maven, permite verificar si una secuencia de ADN pertenece a un mutante o no. Utiliza una conexión a una base de datos PostgreSQL para almacenar las secuencias procesadas.

# Requisitos
**Java 17**

**Maven**: Para compilar y ejecutar el proyecto.

**PostgreSQL:** Se necesita una base de datos con un esquema llamado test.

# Configuración de Variables de Entorno
Configurar dentro del archivo

> src/main/resources/application.properties

Las siguientes variables de entorno

|Variable | Valor |
| ------------- |:-------------:|
| enviroment.db.host.url      | URL donde está alojada la base de datos  |
| enviroment.db.host.port    | Puerto donde está accesible la base de datos     |
| enviroment.db.host.databasename      | Nombre de la base de datos a utilizar en PostgreSQL |
| enviroment.db.host.username      | Nombre de usuario de PostgreSQL     |
| enviroment.db.host.password      | Contraseña del usuario de PostgreSQL     |

# Ejecución de la API
Hay que navegar a la raíz del proyecto y ejecutar el siguiente comando:

```
mvn spring-boot:run
```

El proyecto se ejecuta por defecto en

> http://localhost:8080

Por lo que es indispensable que el puerto esté disponible.

# Endpoints Principales
## **POST:** /mutant

**Descripción**: Verifica si una secuencia de ADN es mutante.

**Request Body**: JSON con un array de strings que representa la secuencia de ADN.

```
[
    "ATGCGC",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
]
```


**Respuestas**:
* **200 OK:** Si el ADN es mutante.
* **403 FORBIDDEN:** Si el ADN no es mutante.
* **400 BAD REQUEST:** Si el formato de ADN es inválido.

## **GET:** /stats

**Descripción:** Devuelve todas las secuencias de ADN procesadas.

**Respuesta:** JSON con las estadísticas de ADN almacenadas.


# Pruebas Unitarias
Para ejecutar las pruebas unitarias, utiliza:
```
mvn test
```
Las pruebas ya están configuradas para usar una base de datos en memoria (H2), por lo que no es necesario tener una instancia de PostgreSQL para ejecutarlas.
