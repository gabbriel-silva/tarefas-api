# Tarefas API (Spring Boot + JPA + MySQL)

API RESTful para gerenciamento de tarefas (CRUD), conforme requisitos do trabalho.

## Requisitos
- Java 17+
- Maven 3.9+
- MySQL 8 (ou Docker)

## Subir MySQL via Docker (recomendado)
```bash
docker compose up -d
```
A base `tarefasdb` será criada automaticamente. Credenciais padrão: usuário `tarefas` / senha `tarefas` (configuráveis no `docker-compose.yml` e `application.properties`).

## Rodar a API
```bash
mvn spring-boot:run
```
A API subirá em `http://localhost:8080`.

## Endpoints (REST)
- **POST** `/api/tarefas` — cria tarefa  
  Exemplo de JSON:
  ```json
  {
    "nome": "Desenvolvimento da API",
    "dataEntrega": "2025-12-12",
    "responsavel": "SEU_NOME RU: SEU_RU"
  }
  ```

- **GET** `/api/tarefas` — lista todas

- **GET** `/api/tarefas/{id}` — busca por ID

- **PUT** `/api/tarefas/{id}` — atualiza tarefa
  ```json
  {
    "nome": "Desenvolvimento da API - Atualizado",
    "dataEntrega": "2025-12-12",
    "responsavel": "SEU_NOME RU: SEU_RU"
  }
  ```

- **DELETE** `/api/tarefas/{id}` — remove tarefa

## Postman
Importe a coleção `postman/Tarefas API.postman_collection.json` e (opcionalmente) o ambiente `postman/Tarefas API - Local.postman_environment.json`.
O ambiente possui variáveis:
- `baseUrl` (padrão: `http://localhost:8080`)
- `ALUNO_NOME` e `ALUNO_RU` (preencha com seus dados para os prints exigidos).

## Dica para os PRINTS exigidos
- **Teste 1**: faça 3 POSTs (um deles com `nome: "Desenvolvimento da API"`, `responsavel: "SEU_NOME RU: SEU_RU"`, `dataEntrega: "2025-12-12"`).
- **Teste 2**: faça GET `/api/tarefas` mostrando que a tarefa com seu nome/RU está listada.
- **Teste 3**: faça PUT na tarefa do seu nome/RU e mostre o retorno/GET refletindo a atualização.
- **Teste 4**: faça DELETE da tarefa do seu nome/RU e mostre que ela sumiu da listagem.

## Estrutura
```
src/main/java/com/gabriel/tarefas/...
├── TarefasApiApplication.java
├── api
│   ├── ApiExceptionHandler.java
│   ├── TarefaController.java
│   ├── dto
│   │   ├── TarefaRequest.java
│   │   └── TarefaResponse.java
│   └── mapper
│       └── TarefaMapper.java
├── domain
│   └── Tarefa.java
└── repository
    └── TarefaRepository.java
```
