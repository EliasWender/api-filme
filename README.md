# 🎬 API de Filmes

Esta é uma API REST desenvolvida com Spring Boot para gerenciamento de um catálogo de filmes.

A aplicação permite realizar operações de CRUD (Create, Read, Update e Delete), simulando um sistema real de catálogo de filmes.

---

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de dados (MySQL ou H2)
- Maven

---

## 📌 Funcionalidades

- Cadastrar filmes
- Listar todos os filmes
- Buscar filme por ID
- Atualizar informações de um filme
- Deletar filme

---

## 📂 Exemplo de JSON

```json
{
  "id": 1,
  "titulo": "Interestelar",
  "genero": "Ficção científica",
  "ano": 2014
}
```

▶️ Como executar o projeto
# clonar o repositório
git clone https://github.com/EliasWender/api-filme.git

# entrar na pasta
cd api-filme

# rodar o projeto
./mvnw spring-boot:run
