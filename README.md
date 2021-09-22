## Parking Cloud

O objetivo desta aplicação **API Parking Cloud** é disponibilizar uma API para cadastro de veículos em um estacionamento.

### Tecnologias utilizadas:
- Java 11 (ou versões superiores);
- Maven 3.6.3 ou versões superiores;
- Spring Data JPA;
- Spring Web;
- Spring Boot;
- Spring Security;
- H2 (banco em memória);
- Heroku;
- Swagger 2 (Documentaçao).
___

##### Para executar o projeto no terminal, digite o seguinte comando:
```
mvn spring-boot:run
```
##### Para abrir a documentação (disponibilizada através do Swagger 2) de todas as operações implementadas com o padrão arquitetural REST, acesse o seguinte link abaixo:

```
http://localhost:8080/swagger-ui.html
```

#### Abaixo, segue o link do projeto implantado no Heroku:
```
 https://parking-cloud.herokuapp.com/swagger-ui.html
```
##### Autenticação para fazer uso dos endpoints:
```
Login: parking
Password: p@rking123
```
___
#### Endpoints:
- createParking: **POST** /parking
- findById: **GET** /parking
- findAll: **GET** /parking/{id}
- updateParking: **PUT** /parking/{id}
- deleteParking: **DELETE** /parking/{id}
- checkout: **POST** /parking/{id}/exit
