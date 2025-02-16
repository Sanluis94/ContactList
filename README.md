API REST PARA CONTROLE DE CONTATOS


*Descrição do Projeto*


Esta é uma API REST desenvolvida em Java com Spring Boot para gerenciar o cadastro de Pessoas e seus Contatos. A API permite realizar operações CRUD em ambas as entidades.


*Funcionalidades*


* Pessoa:

Criar Pessoa (POST /api/pessoas)

Obter Pessoa por ID (GET /api/pessoas/{id})

Obter Pessoa para Mala Direta (GET /api/pessoas/maladireta/{id})

Listar Pessoas (GET /api/pessoas)

Atualizar Pessoa (PUT /api/pessoas/{id})

Deletar Pessoa (DELETE /api/pessoas/{id})

* Contato:

Adicionar Contato (POST /api/contatos/)

Obter Contato (GET /api/contatos/{id})

Listar Contatos de uma Pessoa (GET /api/contatos/pessoa/{idPessoa})

Atualizar Contato (PUT /api/contatos/{id})

Deletar Contato (DELETE /api/contatos/{id})


*Tecnologias Utilizadas*


*Java 21

*Spring Boot 3.4.2

*Spring Data JPA (Hibernate)

*Banco de Dados: H2

*Swagger OpenAPI para Documentação


*Instalação e Execução*


1. Clonar o Repositório

git clone https://github.com/seuusuario/seurepositorio.git
cd seurepositorio

2. Configurar o Banco de Dados

No arquivo application.properties, configure os dados do banco:

spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Rodar a Aplicação

mvn spring-boot:run

A API estará disponível em http://localhost:8080.

Documentação da API (Swagger)

A documentação pode ser acessada em:

http://localhost:8080/swagger-ui.html

Testes Automatizados

Para executar os testes:
