# Projeto para Rinha de Backend, Segunda Edição: 2024/Q1 - Controle de Concorrência

O objetivo desse projeto é colocar em prática todos os meus conhecimentos.

### Stack
- [Nginx](https://www.nginx.com)
- [Java](https://www.java.com/pt-BR/)
- [Maven](https://www.maven.org/)
- [Spring](https://spring.io/)
- [MySQL](https://www.mysql.org)

# Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java
- Spring Boot
- MySQL
- Docker
- Docker Compose

# Construção e Execução

1- Construir a aplicação com Maven:
 
 -> mvn clean install

 Este comando irá limpar o projeto, compilar o código-fonte, executar os testes e empacotar o aplicativo em um arquivo JAR.


2- Construir a imagem docker

 -> docker-compose build nome-da-imagem

 Este comando irá construir a imagem Docker para a sua aplicação, utilizando o Dockerfile presente no diretório do projeto.

3- Inicie os containers:

 -> docker-compose up -d

 Isso iniciará os containers com base nas definições no arquivo docker-compose.yml. Certifique-se de que todos os serviços necessários, como bancos de dados, estejam configurados corretamente no arquivo docker-compose.yml.

# Acesso à Aplicação
Acesse a aplicação em http://mysqldb:9999