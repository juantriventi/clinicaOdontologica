
## 🚀 Proyecto Integrador
Nuestro back-end para una clinica odontologica.


## Autores

- [@JereGomez](https://www.github.com/JereGomez)
- [@juantriventi](https://www.github.com/juantriventi)


## Deploy

Para correr este proyecto

```bash
-   mvn clean install
```


# API JAVA || SPRING BOOT

Una Api para crear usuarios y asignarles roles desde postman con una base de datos h2.
## Pacientes

#### Traer paciente por id

```http
  GET /pacientes/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

No se le pasan parametros.

#### Registrar Paciente

```http
  POST /pacientes/registrar
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`  | `string` | **Required**. |
| `apellido`| `string` | **Required**. |
| `dni`     | `int` | **Required**. |
| `fechaIngreso`  | `LocalDate` | **Required**. |
| `calle`| `string` | **Required**. |
| `numero`     | `int` | **Required**. |
| `localidad`     | `string` | **Required**. |
| `provincia`     | `string` | **Required**. |

ejemplo:
```json
  {
  "nombre": "Jeremias",
  "apellido": "Gomez Giglio",
  "dni": 12345679,
  "fechaIngreso": "2023-11-16",
  "domicilioEntradaDto": {
    "calle": "Billinghurst",
    "numero": 123,
    "localidad": "Springfield",
    "provincia": "Springfield Province"
  }
}
```

## Odontologos


#### Traer odontologo por id

```http
  GET /odontologos/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |


#### Listar Odontologos
```http
  GET /odontologos/listar
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

#### Registrar odontologo

```http
  POST /odontologos/registrar
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `matricula` | `int` | **Required**. |
| `nombre`  | `string` | **Required**. |
| `apellido`| `string` | **Required**. |


ejemplo:
```json
{
  "matricula":1231231233,
  "nombre":"juan cruz",
  "apellido":"triventi"
} 
```
#### Eliminar Odontologo

```http
  DELETE /odontologos/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |


## Turnos

#### Listar turnos

```http
  GET /api/turnos/listar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

#### Registrar turno
```http
  POST /api/turnos/registrar
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fechaYHora` | `DateTime` | **Required**. |
| `odontologo`  
| `id`| `long` | **Required**. |
| `paciente`  
| `id`| `long` | **Required**. |

ejemplo:
```json
{
  "fechaYhora": "2023-11-28T10:00:00",
  "odontologo": {
    "id": 1
  },
  "paciente": {
    "id": 1
  }
}
```