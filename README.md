# API de Consulta de Cidades

Essa API retorna o nome de todos os países do mundo, e de todos os estados e cidades do Brasil. Foi desenvolvida com base no Curso **Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção** pelo professor <a href="https://www.linkedin.com/in/andreluisgomes/" target="_blank">André Gomes</a> na plataforma **Digital Innovation One** no Bootcamp TQI Java Developer da <a href="https://www.linkedin.com/company/tqi-it/" target="_blank">**TQI**</a>.

## Tecnologias utilizadas

- Windows (WSL com Ubuntu)
- Eclipse Enterprise
- Java 8
- Git
- Docker
- PostgreSQL
- Heroku CLI

## Spring Boot

- [SpringBoot - Start Spring Io](https://start.spring.io/)

* Java 8
* Jar
* Maven Project
* Spring Web
* Spring Data JPA
* PostgreSQL Driver

## DataBase

### Postgres

- [Postgres Docker Hub](https://hub.docker.com/_/postgres)
- Comando para baixar e criar o container do Postgres para o projeto:

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Configuração e importação das querys dentro do container Postgres:

Agradecimento à Chinnon Santos pela disponibilização dos dados SQL para as tabelas da API

- [Dados SQL para popular as tabelas](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
git clone https://github.com/chinnonsantos/sql-paises-estados-cidades.git

cd sql-paises-estados-cidades/PostgreSQL

docker start cities-db

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube;
CREATE EXTENSION earthdistance;
```

## Utilizando a API no Postman ou diretamente no Browser

- Para utilizar e acessar os dados da API no Postman ou no browser, utilize os seguintes endereços:

  - Países do mundo: [https://cities-api-dio-pesterenan.herokuapp.com/countries](https://cities-api-dio-pesterenan.herokuapp.com/countries) <br>
  - Estados do Brasil: [https://cities-api-dio-pesterenan.herokuapp.com/states](https://cities-api-dio-pesterenan.herokuapp.com/states) <br>
  - Cidades do Brasil: [https://cities-api-dio-pesterenan.herokuapp.com/cities](https://cities-api-dio-pesterenan.herokuapp.com/cities) <br>
  - Distância em metros entre cidades: [https://cities-api-dio-pesterenan.herokuapp.com/distances/by-cube?from=568&to=785](https://cities-api-dio-pesterenan.herokuapp.com/distances/by-cube?from=568&to=785)