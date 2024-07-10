# API Java Spring Boot Security

### Estudo pessoal de Spring Boot Security com JWT

Tenlogias usadas:
- Java 17
- Spring Security
- Spring Web
- Spring Data Jpa
- JJWT
- H2 Database
- Lombok

<hr>

A aplicação permite realizar requests via API para cadastrar um usuário através de um username, email, password e roles de permissão (USER ou ADMIN).

Ao cadastrar, a senha é criptografa por BCrypt e armazenada no banco em memória, H2 Database (pode ser usado qualquer outro banco no lugar). 

Com o usuário cadastrado, ao acessar o endpoint ```/user/login``` deve-se passar o username e a senha no body da request (JSON), para então um Bearer Token ser retornado.

Com o token, o usuário poderá fazer as requisições que possui acesso (definido através das roles que foram passadas no cadastro).

#### Endpoints e roles necessárias:
- GET      ```/admin```     (ADMIN)
- DELETE   ```/user/**```   (ADMIN)
- GET      ```/user/**```   (ADMIN, USER)
- GET      ```/user```      (ADMIN, USER)
- POST     ```/user```      (ALL)
- POST     ```/login```     (ALL)
