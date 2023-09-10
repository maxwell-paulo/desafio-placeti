# Desafio 1 - Place Tecnologia

## Introdução

Neste desafio, você deve desenvolver um webservice em Java com Spring que execute operações básicas (GET, PUT, POST e DELETE) em uma entidade chamada "Curso." Esta documentação fornecerá instruções passo a passo para testar o webservice e realizar operações CRUD na entidade Curso.

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte:

-   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) instalado em seu sistema.
-   [Maven](https://maven.apache.org/download.cgi) instalado em seu sistema.
-   [Docker](https://www.docker.com/get-started) instalado em seu sistema.

## Configuração do Projeto

1.  Clone este repositório em seu ambiente de desenvolvimento:

bashCopy code

`git clone <URL_DO_SEU_REPOSITORIO>` 

2.  Navegue até o diretório do projeto:

bashCopy code

`cd <NOME_DO_DIRETORIO_DO_PROJETO>` 

3.  Compile o projeto usando o Maven:

bashCopy code

`mvn clean install` 

## Executando o Webservice

Agora que o projeto está configurado, você pode executar o webservice.

1.  Inicie o container Docker para o banco de dados H2 (banco de dados em memória usado neste exemplo):

bashCopy code

`docker run -d -p 8080:8080 --name h2-database -e "DATABASE_NAME=testdb" -e "DATABASE_USER=testuser" -e "DATABASE_PASSWORD=testpassword" -e "DATABASE_PORT=8080" -e "DATABASE_H2=true" rastasheep/h2database` 

2.  Inicie o aplicativo Spring Boot:

bashCopy code

`mvn spring-boot:run` 

## Testando o Webservice

Agora que o webservice está em execução, você pode testá-lo usando uma ferramenta de API, como o Postman ou o Insomnia.

### Exemplos de Endpoints

-   **Listar Cursos (GET):**
    
    bashCopy code
    
    `GET http://localhost:8080/api/cursos` 
    
-   **Criar um Curso (POST):**
    
    bashCopy code
    
    `POST http://localhost:8080/api/cursos
    Body JSON:
    {
      "nome": "Curso de Exemplo",
      "quantidadeAlunos": 20,
      "nivelCurso": "Intermediário"
    }` 
    
-   **Atualizar um Curso (PUT):**
    
    bashCopy code
    
    `PUT http://localhost:8080/api/cursos/{id}
    Body JSON:
    {
      "nome": "Curso Atualizado",
      "quantidadeAlunos": 25,
      "nivelCurso": "Avançado"
    }` 
    
-   **Excluir um Curso (DELETE):**
    
    bashCopy code
    
    `DELETE http://localhost:8080/api/cursos/{id}` 
    

Lembre-se de substituir `{id}` pelo ID real do curso que deseja atualizar ou excluir.

## Contribuição

Se você quiser contribuir com melhorias neste projeto ou relatar problemas, sinta-se à vontade para abrir uma issue ou criar um pull request.

## Recursos Adicionais

-   [Spring Framework](https://spring.io/)
-   [Documentação do Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
-   [Documentação do Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
-   [Postman](https://www.postman.com/downloads/)

Este é um guia básico para testar o seu webservice Java com Spring. Certifique-se de ajustar as informações e os endpoints de acordo com a estrutura do seu projeto e das suas necessidades.