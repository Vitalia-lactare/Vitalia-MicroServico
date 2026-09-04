# Portal do Doador Lactare — API

API REST do Portal do Doador Lactare: cadastro de doadoras, triagem, encaminhamento a pontos de coleta, doações e pesquisa de satisfação.

## Pré-requisitos

Para executar o projeto localmente, você precisará ter instalado:

- Java 17
- Maven (ou use o Maven Wrapper incluso: `mvnw` / `mvnw.cmd`)
- MySQL 8
- Docker (opcional)

---

## Execução local — ordem dos comandos

### 1. Subir o MySQL

Terminal: **PowerShell ou Git Bash**.

```sh
docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -p 3306:3306 \
    mysql
```

Aguarde alguns segundos até o banco aceitar conexões.

### 2. Configurar as variáveis de ambiente

Terminal: **use o mesmo terminal do passo 3.**

Windows PowerShell:

```powershell
$env:DB_SERVER_URL="localhost"
$env:DB_SERVER_PORT="3306"
$env:DB_SCHEMA="lactare"
$env:DB_USER="root"
$env:DB_PWD="root_pwd"
$env:SPRING_PROFILES_ACTIVE="dev"
```

Linux / macOS / Git Bash:

```sh
export DB_SERVER_URL=localhost
export DB_SERVER_PORT=3306
export DB_SCHEMA=lactare
export DB_USER=root
export DB_PWD=root_pwd
export SPRING_PROFILES_ACTIVE=dev
```

### 3. Executar a aplicação

Terminal: **PowerShell** — recomendado no Windows. O Maven Wrapper baixa o Maven sozinho na primeira execução, e esse download pode falhar no Git Bash dependendo do `wget` disponível no PATH.

```powershell
.\mvnw.cmd spring-boot:run
```

Se tiver o Maven instalado globalmente, o comando abaixo funciona em qualquer terminal:

```sh
mvn spring-boot:run
```

### 4. Acessar

```
http://localhost:8080
```

A raiz da aplicação já é o Swagger UI, só testar.

---

## Executando com Docker

### 1. Criar a imagem

```sh
docker build -t lactare-doador-api:0.1.0 .
```

### 2. Subir o MySQL (se ainda não tiver um)

```sh
docker network create lactare-net
docker run -d \
    --name mysql \
    --rm \
    --network lactare-net \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -p 3306:3306 \
    mysql
```

### 3. Executar o container

```sh
docker run -d --name lactare-api --network lactare-net \
  -p 8080:8080 \
  -e DB_SERVER_URL=mysql \
  -e DB_SERVER_PORT=3306 \
  -e DB_SCHEMA=lactare \
  -e DB_USER=root \
  -e DB_PWD=root_pwd \
  -e SPRING_PROFILES_ACTIVE=dev \
  lactare-doador-api:0.1.0
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

> **Nota:** se o MySQL estiver rodando direto na máquina host (fora de um container), use `host.docker.internal` como `DB_SERVER_URL` em vez do nome do container.

---

## Profiles do Spring Boot

O profile ativo da aplicação é definido através da variável de ambiente:

```
SPRING_PROFILES_ACTIVE
```

### Desenvolvimento

Para executar utilizando o profile `dev`:

```sh
export SPRING_PROFILES_ACTIVE=dev
```

O schema e as tabelas são criados/atualizados automaticamente.

### Produção

Para executar utilizando o profile `prd`:

```sh
export SPRING_PROFILES_ACTIVE=prd
```

O schema e as tabelas **não** são criados automaticamente — execute antes o script `src/main/resources/migration-2026-09-03.sql`.

---

## Variáveis de ambiente

| Variável | Descrição | Exemplo |
|---|---|---|
| `DB_SERVER_URL` | Endereço do servidor do banco de dados | `localhost` |
| `DB_SERVER_PORT` | Porta do banco de dados | `3306` |
| `DB_SCHEMA` | Nome do schema | `lactare` |
| `DB_USER` | Usuário do banco de dados | `root` |
| `DB_PWD` | Senha do banco de dados | `root_pwd` |
| `SPRING_PROFILES_ACTIVE` | Profile ativo do Spring Boot | `dev` |

---

## Docker — comandos úteis

### Criar a imagem

```sh
docker build -t lactare-doador-api:0.1.0 .
```

### Listar containers em execução

```sh
docker ps
```

### Listar todos os containers

```sh
docker ps -a
```

### Parar um container

```sh
docker stop <container_id>
```

### Remover um container

```sh
docker rm <container_id>
```

### Listar imagens

```sh
docker images
```

### Remover uma imagem

```sh
docker rmi lactare-doador-api:0.1.0
```