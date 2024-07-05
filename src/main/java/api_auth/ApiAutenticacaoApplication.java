package api_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 	Estudo de API para autenticação de usuários.
 * 	Projeto inicializado com Spring Initializr.
 * 		Dependências usadas:
 * 		- Spring Web,
 * 		- H2 Database,
 * 		- PostgreSQL Driver,
 * 		- Spring Security,
 * 		- Spring Data JPA
 *
 * @author --> QziuL (Github)
 */

@SpringBootApplication
public class ApiAutenticacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAutenticacaoApplication.class, args);
	}

}
