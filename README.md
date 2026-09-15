# 📞 Cadastro de Contatos API

Uma API REST completa, desenvolvida em **Java** e **Spring Boot**, projetada para gerenciar um cadastro de contatos de forma eficiente, segura e padronizada. O projeto aplica conceitos modernos de arquitetura, como isolamento de camadas, DTOs (`records`), validações de dados rigorosas e tratamento global de exceções.

---

## 🚀 Tecnologias Utilizadas

* **Java 21** (Uso de recursos modernos da linguagem, como Records estáveis e melhorias de performance)
* **Spring Boot 4.1.1** (Aproveitando as últimas atualizações de performance e segurança do ecossistema)
* **Spring Data JPA** (Persistência e comunicação simplificada com o banco de dados)
* **Jakarta Validation / Hibernate Validator** (Garantia de integridade dos dados de entrada)
* **Lombok** (Produtividade e redução de código boilerplate)
* **MySQL** (Banco de dados relacional para persistência de dados de forma robusta e segura)

---

## 🛠️ Funcionalidades e Diferenciais Técnicos

* **CRUD Completo de Contatos**: Criação, listagem geral, busca por ID, atualização e deleção.
* **Busca Customizada**: Endpoint para busca de contatos por nome (`/search?name=...`) usando consultas dinâmicas derivadas do Spring Data JPA.
* **Isolamento com DTOs**: Uso de Java `records` para desacoplar as entidades de banco de dados (`Contact`) das requisições (`ContactRequestDto`) e respostas (`ContactResponseDto`).
* **Tratamento Global de Erros**: Captura centralizada de exceções (`@RestControllerAdvice`) para garantir que o cliente da API receba respostas limpas e padronizadas em caso de falhas (como dados inválidos ou recursos não encontrados).
* **Valivações Avançadas**: Uso de `@NotBlank`, `@Email` e validações de integridade de dados (como bloqueio de e-mails duplicados com status HTTP `409 Conflict`).

---

## 🗺️ Endpoints da API (V1)

### Contatos

| Método | Endpoint | Descrição | Status Sucesso |
| :--- | :--- | :--- | :--- |
| `POST` | `/v1/contacts` | Cria um novo contato | `201 Created` |
| `GET` | `/v1/contacts` | Lista todos os contatos | `200 OK` |
| `GET` | `/v1/contacts/{id}` | Busca um contato pelo ID | `200 OK` |
| `GET` | `/v1/contacts/search?name=...` | Busca contatos por parte do nome | `200 OK` |
| `PUT` | `/v1/contacts/{id}` | Atualiza os dados de um contato | `200 OK` |
| `DELETE` | `/v1/contacts/{id}` | Exclui um contato do sistema | `204 No Content` |

---

## 📋 Exemplo de Payload (JSON)

### Criar Contato (`POST /v1/contacts`)

**Corpo da Requisição (Request Body):**
```json
{
  "name": "Ewerton Bruno",
  "email": "ewerton@exemplo.com",
  "phone": "11999999999",
  "address": "Rua Exemplo, 123 - São Paulo"
}
```

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* Ter o **MySQL Server** instalado e rodando localmente.
* Ter criado um schema/banco de dados com o nome configurado em seu projeto.

### Passos para execução
1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/Ewerton-Bruno12/cadastro-de-contatos.git
   ```
2. **Configurar o banco de dados:**
   Abra o arquivo `src/main/resources/application.properties` (ou `.yml`) e ajuste as credenciais do seu MySQL (usuário e senha):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DO_SEU_BANCO
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
3. **Entrar na pasta do projeto:**
   ```bash
   cd cadastro-de-contatos
   ```
4. **Executar a aplicação via Maven:**
   ```bash
   ./mvnw spring-boot:run
   ```
