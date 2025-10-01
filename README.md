# 🏛️ MyLib API

API REST desenvolvida com Spring Boot para organizar bibliotecas, autores, livros e usuários. O projeto segue o estilo arquitetural do repositório [danieltidus/todolist](https://github.com/danieltidus/todolist) e contempla camadas de **controladores**, **serviços**, **modelos**, **DTOs**, **validações**, **tratamento de exceções**, **autenticação JWT** e **documentação via Swagger**.

## ✨ Funcionalidades

- Cadastro, consulta, atualização e remoção de autores, livros, bibliotecas e usuários.
- Associação de livros e usuários a bibliotecas.
- Filtros de busca utilizando **query params** (título, autor, categoria e data de lançamento).
- Autenticação e autorização com JWT utilizando Spring Security.
- Documentação automática da API com SpringDoc (Swagger UI).

## 🧱 Arquitetura

```
com.example.mylib
├── configuracao      # Segurança e configuração do Swagger
├── controladores     # REST controllers (camada de exposição)
├── dtos              # Objetos de transferência de dados com validações
├── excecoes          # Exceções de domínio e handler global
├── modelos           # Entidades JPA e enums
├── repositorios      # Interfaces Spring Data JPA
├── seguranca         # Serviços auxiliares do fluxo JWT
└── servicos          # Regras de negócio e orquestração
```

## 🚀 Requisitos

- Java 21+
- Maven 3.9+

## ▶️ Como executar

```bash
cd MYLIB
./mvnw spring-boot:run
```

A aplicação utiliza banco de dados em memória **H2**. Ao subir o projeto você pode acessar o console em `http://localhost:8080/h2-ui` (usuário `sa`, senha em branco).

## 🔐 Autenticação

1. Cadastre um usuário via `POST /api/usuarios` informando nome, e-mail e senha.
2. Gere um token com `POST /api/autenticacao/login` enviando `email` e `senha`.
3. Utilize o token no header `Authorization: Bearer <token>` para acessar os demais endpoints protegidos.

## 📘 Documentação Swagger

Após iniciar a aplicação, acesse `http://localhost:8080/swagger-ui.html` para visualizar e testar todos os recursos expostos.

## 📡 Endpoints principais

### Autenticação

| Método | Caminho | Descrição |
|--------|--------|-----------|
| `POST` | `/api/usuarios` | Cadastro de usuário (não requer token) |
| `POST` | `/api/autenticacao/login` | Autentica e retorna JWT |

### Autores

| Método | Caminho | Descrição |
|--------|--------|-----------|
| `GET` | `/api/autores` | Lista todos os autores |
| `GET` | `/api/autores/{id}` | Recupera autor por ID |
| `POST` | `/api/autores` | Cadastra autor |
| `PUT` | `/api/autores/{id}` | Atualiza autor |
| `DELETE` | `/api/autores/{id}` | Remove autor |

### Livros

| Método | Caminho | Descrição |
|--------|--------|-----------|
| `GET` | `/api/livros` | Lista livros com filtros (`titulo`, `autorId`, `categoria`, `dataLancamento`) |
| `GET` | `/api/livros/{id}` | Recupera livro por ID |
| `POST` | `/api/livros` | Cadastra livro |
| `PUT` | `/api/livros/{id}` | Atualiza livro |
| `DELETE` | `/api/livros/{id}` | Remove livro |

### Bibliotecas

| Método | Caminho | Descrição |
|--------|--------|-----------|
| `GET` | `/api/bibliotecas` | Lista bibliotecas |
| `GET` | `/api/bibliotecas/{id}` | Recupera biblioteca por ID |
| `POST` | `/api/bibliotecas` | Cadastra biblioteca |
| `PUT` | `/api/bibliotecas/{id}` | Atualiza biblioteca |
| `DELETE` | `/api/bibliotecas/{id}` | Remove biblioteca |
| `POST` | `/api/bibliotecas/{id}/livros/{livroId}` | Relaciona livro à biblioteca |
| `POST` | `/api/bibliotecas/{id}/usuarios/{usuarioId}` | Relaciona usuário à biblioteca |

### Usuários

| Método | Caminho | Descrição |
|--------|--------|-----------|
| `GET` | `/api/usuarios` | Lista usuários |
| `GET` | `/api/usuarios/{id}` | Recupera usuário por ID |
| `PUT` | `/api/usuarios/{id}` | Atualiza usuário |
| `DELETE` | `/api/usuarios/{id}` | Remove usuário |

## ✅ Boas práticas aplicadas

- DTOs com validação (`jakarta.validation`).
- Tratamento centralizado de exceções com mensagens padronizadas.
- Camada de serviço responsável pelas regras de negócio.
- Repositórios Spring Data com consultas derivadas.
- Métodos e classes nomeados em português, conforme solicitado.
- Token JWT assinado com `HS256` e validade configurável.

## 🧪 Execução de testes

Nenhum teste automatizado acompanha o projeto, mas o comando abaixo executa a suíte padrão do Spring Boot:

```bash
./mvnw test
```

## 📄 Licença

Projeto criado para fins de estudo.
