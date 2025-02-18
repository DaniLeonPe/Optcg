<div align="justify">

# <img src=images/spring-logo.png width="40">

<div align="center">
   <img src=images/logo.png width="400">
</div>

## <img src=images/crud.png width="40"> CRUD de Usuarios en Java y Spring Boot

Este proyecto implementa una API RESTful utilizando **Java** y **Spring Boot** para gestionar la api de OnePiece TCG. El objetivo es permitir la creación, lectura, actualización y eliminación de registros de usuarios,roles,cartas,expansiones,colecciones mediante los siguientes endpoints:

## Arranque/parada del servicio

Para arrancarlo debemos de ejecutar:

```console
mvn clean spring-boot:run
```

### Arrancar con modo debug activado

Para arrancar spring-boot para debug en remote debemos hacerlo de la siguiente manera

```console
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
```

## Gestión de Usuarios

### Rest CRUD

#### V2

- **Leer usuario**: `GET /api/v2/user/{id}`
- **Leer todos los usuario**: `GET /api/v2/users/`

### V3
- **Crear usuario**: `POST /api/v3/add/user/`
- **Actualizar usuario**: `PUT /api/v3/user/{id}`
- **Eliminar usuario**: `DELETE /api/v3/user/{id}`
- **Leer usuario**: `GET /api/v3/user/{id}`
- **Leer todos los usuario**: `GET /api/v3/users/`

## Gestión de Roles

### Rest CRUD

#### V2

- **Leer rol**: `GET /api/v2/role/{id}`
- **Leer todos los roles**: `GET /api/v2/roles/`

### V3
- **Crear rol**: `POST /api/v3/add/role/`
- **Actualizar rol**: `PUT /api/v3/role/{id}`
- **Eliminar rol**: `DELETE /api/v3/role/{id}`
- **Leer rol**: `GET /api/v3/role/{id}`
- **Leer todos los roles**: `GET /api/v3/roles/`

## Gestión de Cartas

### Rest CRUD

#### V2

- **Leer carta**: `GET /api/v2/carta/{id}`
- **Leer todas las cartas**: `GET /api/v2/cartas/`

### V3
- **Crear carta**: `POST /api/v3/add/carta/`
- **Actualizar carta**: `PUT /api/v3/carta/{id}`
- **Eliminar carta**: `DELETE /api/v3/carta/{id}`
- **Leer carta**: `GET /api/v3/carta/{id}`
- **Leer todas las cartas**: `GET /api/v3/cartas/`

---

## Gestión de Colecciones

### Rest CRUD

#### V2

- **Leer coleccion**: `GET /api/v2/coleccion/{id}`
- **Leer todas las colecciones**: `GET /api/v2/colecciones/`

### V3
- **Crear coleccion**: `POST /api/v3/add/coleccion/`
- **Actualizar coleccion**: `PUT /api/v3/coleccion/{id}`
- **Eliminar coleccion**: `DELETE /api/v3/coleccion/{id}`
- **Leer coleccion**: `GET /api/v3/coleccion/{id}`
- **Leer todas las colecciones**: `GET /api/v3/colecciones/`

---

## Gestión de Expansiones

### Rest CRUD

#### V2

- **Leer expansion**: `GET /api/v2/expansion/{id}`
- **Leer todas las expansiones**: `GET /api/v2/expansiones/`

### V3
- **Crear expansion**: `POST /api/v3/add/expansion/`
- **Actualizar expansion**: `PUT /api/v3/expansion/{id}`
- **Eliminar expansion**: `DELETE /api/v3/expansion/{id}`
- **Leer expansion**: `GET /api/v3/expansion/{id}`
- **Leer todas las expansiones**: `GET /api/v3/expansiones/`


## Gestión de Mazos

### Rest CRUD

#### V2

- **Leer mazo**: `GET /api/v2/mazo/{id}`
- **Leer todos los mazos**: `GET /api/v2/mazos/`

### V3
- **Crear mazo**: `POST /api/v3/add/mazo/`
- **Actualizar mazo**: `PUT /api/v3/mazo/{id}`
- **Eliminar mazo**: `DELETE /api/v3/mazo/{id}`
- **Leer mazo**: `GET /api/v3/mazo/{id}`
- **Leer todos los mazos**: `GET /api/v3/mazos/`


### Servicio Soap (CXF) de usuarios

- **Obtener todos los usuario**: `getAllUsers()`
- **Obtener un usuario por id**: `getUserById()`

El servicio **soap** quedara expuesto en la url [http://localhost:8080/services](http://localhost:8080/services).

- <img src=images/services.PNG width="400">

Si queremos ver todos los servicios **cxf** expuestos debemos de visitar la siguiente [url](http://localhost:8080/services).


## Documentación OpenAPI Rest (Swagger UI)

- **URL**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

> En el siguiente [enlace](https://github.com/jpexposito/code-learn/tree/main/segundo/pgv/5-red-servicos) se encuentra la documentación de creación y documentación de servicios en [Spring](https://spring.io/). El cliente para el consumo del servicio de forma programática se encuentra en el siguiente [enlace](https://github.com/jpexposito/spring-boot-persistence-h2-client).



</div>