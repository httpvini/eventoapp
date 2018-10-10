# eventoapp

Aplicação para gerenciar agenda de eventos.

## Getting Started

Clone este repositório. Dentro do diretório em que se encontra o arquivo pom.xml, execute o comando: *mvn clean install*
Altere o profile de "prod" para "dev" no arquivo application.properties no diretórtio *Resources*.

Após a resolução das dependências, basta executar a classe: *EventoappApplication*

### Pré-requisitos

É necessário ter o jdk (Java 8) e o maven instalado. 
É necessário ter o MySql ou Postgres instalado. 

Obs: Basta criar o banco *eventoapp* que as tabelas são criadas automaticamente ao subir o projeto.
Esta configuração pode ser vista e alterada na classe *DataConfigurationMySql* para o profile de dev.


## Desenvolvido com

* [Spring Boot](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/) - Framework de inversão de controle e MVC utilizado.
* [Maven](https://maven.apache.org/) - Gerenciamento de Dependências.

