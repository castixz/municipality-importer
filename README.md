# Municipality Importer

## Technology used:
- Java (21)
- Spring Boot (3.3.2)
- PostgreSQL (latest image from DockerHub)
- Hibernate for ORM
- Flyway for database migrations

## Prerequisites
Before you start please ensure that you have following tools installed:
- Java (21)
- Maven
- Docker
## Getting started
-  turn on Docker Daemon
-  place .env file to root directory with values for POSTGRES_USER and POSTGRES_PASSWORD:

example:
POSTGRES_USER=myuser
POSTGRES_PASSWORD=secret


## Run
You need to run the program with env variable TASK_TYPE equals to MUNICIPALITY_IMPORT which is currently the only available job

## Tasks 
- MUNICIPALITY_IMPORT - loads a XML file from some currently hard-coded URL and parse it using DOM parser, afterwards saves the results of found municipalities and municipality parts to DB. Because it's just demo task DB is being cleaned up before new task since the file is always the same

## Technical debts
- Currently no unit nor intergration tests are being implemented






