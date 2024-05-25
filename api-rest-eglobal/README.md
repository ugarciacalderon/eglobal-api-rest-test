# API Rest para EGLOBAL

El api rest contiene dos endpoints
- crear usuario:  http://localhost:8090/createUser
- consultar usuario: http://localhost:8090/consultaUsuario?username=ulises.garciac

La base de datos es MySQL y esta montada en AWS, y los accesos son lo siguientes:
- usuario: admin
- contraseña: adminadmin
- url: jdbc:mysql://eglobal.c7kaekmmqyel.us-east-2.rds.amazonaws.com/users

Docker Containers:
- api rest:
- server eureka: 
