
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
