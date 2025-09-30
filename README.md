🏛️ MyLib — API de Biblioteca

API REST em Java + Spring Boot para gerenciar bibliotecas, incluindo cadastro de usuários, empréstimos de livros, controle de estoque, e mais.

🚀 Funcionalidades

Usuários

Cadastro e autenticação de usuários

Visualizar perfil e histórico de empréstimos

Livros

Listar livros disponíveis para empréstimo

Adicionar novos livros ao estoque

Atualizar informações de livros

Remover livros do catálogo

Empréstimos

Registrar empréstimos de livros para usuários

Controlar prazo de devolução

Registrar devoluções de livros

🏗️ Arquitetura

Controller → Controla os endpoints da API REST

Service → Contém as regras de negócio (empréstimos, validação de usuários, etc.)

Repository → Acesso ao banco de dados via Spring Data JPA

Model/Entity → Entidades que representam o banco de dados (Usuário, Livro, Empréstimo)

Exception Handler → Tratamento de erros de forma padronizada (recurso não encontrado, validações, etc.)

