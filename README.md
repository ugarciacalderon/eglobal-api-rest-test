# API Rest para EGLOBAL

El api rest contiene dos endpoints
- crear usuario:  http://localhost:8090/createUser
- consultar usuario: http://localhost:8090/consultaUsuario?username=ulises.garciac

La base de datos es MySQL y esta montada en AWS, y los accesos son lo siguientes:
- usuario: admin
- contraseña: adminadmin
- url: jdbc:mysql://eglobal.c7kaekmmqyel.us-east-2.rds.amazonaws.com/users

Docker Images:
- api rest: docker push octomagiccode/api-rest-eglobal:tagname
- server eureka: docker push octomagiccode/eureka-server-eglobal:tagname
- gateway server: docker push octomagiccode/gatewayserver-eglobal:tagname
- config server: docker push octomagiccode/configserver-eglobal:tagname

Ejecutar el proyecto
- posiocionarse en la ruta
  eglobal-api-rest-test/docker-compose/default
- ejecutar
  - docker compose up -d
- hay ocasiones en donde el gateway server no se inicia por si solo
  - iniciarlo con docker run -p 8071:8071 octomagiccode/gatewayserver-ms-eglobal:v1


# Rutas
- gateway server: http://localhost:8072/actuator/gateway/routes
- eureka server: http://localhost:8070/
- config server_ contiene la configuración de eureka server y config server
