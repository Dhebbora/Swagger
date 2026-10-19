# Cafeteria API

API REST desenvolvida com Java e Spring Boot para o gerenciamento de produtos de uma cafeteria. O projeto permite realizar operações de cadastro,
consulta, atualização e exclusão de produtos, seguindo os princípios de comunicação de uma API REST.
A documentação dos endpoints é disponibilizada por meio do Swagger UI, facilitando a visualização e a execução das requisições HTTP.

### Tecnologias utilizadas

Java: linguagem de programação. </br>
Spring Boot: framework para desenvolvimento da aplicação.</br>
Spring Web: criação dos endpoints REST.</br>
Swagger / OpenAPI: documentação e exploração interativa da API.</br>
Maven:gerenciamento de dependências e build do projeto.

### Funcionalidades

Cadastro de produtos.
Listagem de todos os produtos cadastrados.
Busca de produto por ID.
Atualização de produtos existentes.
Exclusão de produtos pelo ID.
Documentação dos endpoints com Swagger/OpenAPI.
Tratamento de respostas HTTP para operações bem-sucedidas e produtos não encontrados.

### Documentação da API

Após iniciar a aplicação, acesse o Swagger UI para visualizar e testar os endpoints:
http://localhost:8080/swagger-ui/index.html
A interface permite consultar os endpoints, visualizar os parâmetros e enviar requisições diretamente pelo navegador.

### Como executar o projeto

#### Pré-requisitos:

Java JDK compatível com a versão configurada no projeto.
Maven, caso não utilize o Maven Wrapper incluído no repositório.
Git para clonar o repositório.
  1. Clone o repositório
    git clone URL_DO_SEU_REPOSITORIO
  2. Entre na pasta do projeto
    cd cafeteria-api
  3. Execute a aplicação
    Se o projeto possuir Maven Wrapper no Windows:
      mvnw.cmd spring-boot:run
    Em Linux ou macOS:
      ./mvnw spring-boot:run
  Alternativamente, com o Maven instalado:
      mvn spring-boot:run
  4. Acesse a documentação
    Com a aplicação em execução, abra:
      http://localhost:8080/swagger-ui/index.html

### Objetivo do projeto

Projeto de estudo voltado à prática de desenvolvimento backend com Java e Spring Boot, criação de APIs REST e documentação de serviços com Swagger/OpenAPI.
