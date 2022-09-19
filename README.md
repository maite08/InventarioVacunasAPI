# InventarioVacunacion
Aplicación para llevar un registro del inventario del estado de vacunación de los empleados, realizada con SpringBoot java 8.

Se utilizó JWT para crear tokens de autenticacion dependiendo los permisos

Esta aplicacion consta de dos roles: Administrador y Empleado.

El administrador cuenta con los permisos de: ingresar al sistema, registrar a un empleado, editar, listar y eliminar a los empleados.
El empleado cuenta con los permisos de: ingresar al sistema y actualizar su información.


Para iniciar la aplicacion se debe seguir los siguientes pasos:
1)El administrador se debe autenticar al sistema con sus credenciales: (POST)
URL: localhost:8080/authenticate
{
    "username":"0831021028",
    "password":"admin@pass"
}
Una vez ingresado se le asignará un token de autenticacion el cual nos va a servir para utilizar los demas endPoints.
El mismo proceso tendra que realizar el empleado una vez que el administrador lo haya registrado.

2)END-POINT REGISTRAR (SOLO ADMIN): (POST)
Con el Token de admin creado, procedemos a llenar la cabecera con el Authorization: Bearer
URL: localhost:8080/registrar
{
    "username":"098745120",
    "nombres": "EMPLEADO 1",
    "apellidos": "APELLIDO 2",
    "correo": "EMPLEADO@gmail.com"
}
Enviamos la peticion y la cual nos va a responder true o false dependiendo si fue exitoso o no y un mensaje donde vendrá el usuario que por defecto es la cedula y una contraseña temporal generada automaticamente.
![image](https://user-images.githubusercontent.com/25499031/191106586-1f4c9a78-463c-4828-8dcc-91bca360a1e0.png)

3)END-POINT EDITAR/ACTUALIZAR (POST)
Este end-Point lo puede utilizar tanto el administrador como los empleados, con el token respectivo llenamos la cabecera y los siguientes campos en el body:
URL: localhost:8080/actualizarEmpleado
{
    "username":"CEDULA",
    "nombres": "NOMBRES",
    "apellidos": "APELLIDOS",
    "correo": "CORRREO@gmail.com",
    "fechaNacimiento":"24/12/1986",
    "direccion": "DIRECCION",
    "telefono": "0986965655",
    "estadoVacuna": true O false, (si es true, el cliente debe de llenar los siguientes campos)
    "tipoVacuna": "2",
    "numeroDosis": 1,
    "fechaVacunacion":"05/08/2021"
}
![image](https://user-images.githubusercontent.com/25499031/191107441-2e3f347b-2e57-4431-9001-9016de584922.png)

4) END-POINT LISTAR POR ESTADO DE VACUNACION (SOLO ADMIN):(GET)
Con el token de admin valido y creado se realiza la peticion get donde le mandamos en el body un boolean true si quiero recibir los empleados que estan vacunados un false si quiero los empleados no vacunados.
URL: localhost:8080/listarEstadoVacunacion
false/true
![image](https://user-images.githubusercontent.com/25499031/191108832-3f26850b-653f-4136-a565-f3256d6d66d8.png)

5) END-POINT LISTAR POR TIPO DE VACUNA (SOLO ADMIN): (GET)
Con el token de admin valido y creado se realiza la peticion get donde le mandamos en el body un integer que hace referencia al id de las vacunas, aqui nos va a devolver a los empleados con sus tipos de vacuna:
id: 1 Sputnik
id: 2 AstraZeneca
id: 3 Pfizer
id: 4 Jhonson&Jhonson
URL: localhost:8080/listarTipoVacuna
parametro: id de vacuna
![image](https://user-images.githubusercontent.com/25499031/191109575-d332eef6-23d1-4641-8fd8-bf1ec3abdb6d.png)

6)END-POINT LISTAR POR RANGO DE VACUNACION (SOLO ADMIN): (GET)
Con el token de admin valido y creado, realizamos una peticion get donde le mandamos como parametro el rango de fecha que deseamos.
parametros: dateInicio dateFin
URL:localhost:8080/listarRangoVacunacion?dateInicio=2021-08-08&dateFin=2021-08-10
![image](https://user-images.githubusercontent.com/25499031/191109968-6c9c9efd-0974-4d7d-b0d7-0146b2cd659c.png)

7) END-POINT ELIMINAR (SOLO ADMIN): (DELETE)
Con el token de admin valido y creado, realizamos una peticion get y enviamos como path de variable el numero de cedula (username) del empleado que deseamos eliminar.
URL: localhost:8080/eliminarEmpleado/0931021022
![image](https://user-images.githubusercontent.com/25499031/191110385-49a08a8b-bdc3-42d1-bf1a-9b21b769903a.png)

8)CONFIGURACIONES DE SWAGGER:
http://localhost:8080/v3/api-docs/
http://localhost:8080/swagger-ui/index.html#/ 
![image](https://user-images.githubusercontent.com/25499031/191110874-4a0159eb-28af-4379-bd47-57acfabd8566.png)


