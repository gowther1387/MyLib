# MyLib: Sua Biblioteca Pessoal

Cansado de perder o controle sobre sua coleção de livros? Não se lembra mais se já emprestou aquele título para um amigo? O MyLib é a solução perfeita para você. Ele é uma API organizacional de livros projetada para funcionar como sua biblioteca pessoal, oferecendo uma forma prática e eficiente de catalogar, gerenciar e acessar sua coleção.

Com o MyLib, você pode:

Catalogar sua coleção: Adicione cada livro à sua biblioteca digital com detalhes como título, autor e gênero.
Acessar suas informações de qualquer lugar: Como uma API REST, o MyLib armazena seus dados de forma segura, permitindo que você acesse as informações sobre seus livros de qualquer dispositivo, seja no computador ou no celular, usando qualquer aplicação cliente compatível.
Manter a organização em dia: Esqueça as anotações em papel ou planilhas desatualizadas. O MyLib permite que você atualize as informações de um livro de forma rápida e segura, mantendo sua coleção sempre em ordem.
Ter o controle total: Adicione, liste, edite e remova livros de sua biblioteca a qualquer momento, tendo controle total sobre seus dados.
O MyLib foi criado com o objetivo de simplificar a vida dos amantes de livros, oferecendo um serviço que vai além de uma simples lista. É uma ferramenta de gestão que centraliza a sua coleção, garantindo que você nunca mais perca um livro de vista.


Funcionalidades 
Listar Livros: Exibir todos os livros cadastrados.
Adicionar Livro: Cadastrar um novo livro com título, autor e gênero.
Atualizar Livro: Modificar as informações de um livro existente.
Deletar Livro: Remover um livro do banco de dados.
Buscar Livro: Encontrar livros por título ou autor.
Estrutura do projeto
Camada de Controller: É a camada que lida com as requisições HTTP (GET, POST, PUT, DELETE). Ela recebe os dados, chama a camada de serviço e retorna a resposta para o cliente (geralmente em formato JSON).
Camada de Service: Contém a lógica de negócio. É aqui que você implementa as regras para adicionar, atualizar, deletar e buscar livros. O Service se comunica com a camada de Repositório.
Camada de Repository: Responsável pela comunicação com o banco de dados. No Spring Boot, você pode usar o Spring Data JPA para facilitar essa interação, sem precisar escrever muito código SQL.
Camada de Model/Entity: Representa a sua entidade (o objeto Livro). Você usará anotações do JPA para mapear essa classe para uma tabela no banco de dados.
Tecnologias e ferramentas recomendadas
Spring Boot
Maven
Spring Data JPA
H2 Database
Spring Web
Postman 


