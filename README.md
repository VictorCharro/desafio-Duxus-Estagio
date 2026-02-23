# Desafio Técnico – Duxus Estágio

## Sobre o Projeto

Implementação do desafio técnico para a vaga de estágio na Duxus. O sistema realiza o processamento de dados para escalação de times semanais, com foco na implementação das regras de negócio e validação via testes unitários.

---

## O que foi implementado

### Tratamento de Dados (`ApiService`)

Todos os métodos do `ApiService` foram implementados:

| Método | Descrição |
|---|---|
| `timeDaData` | Retorna o time escalado em uma data específica |
| `integranteMaisUsado` | Retorna o integrante presente no maior número de times no período |
| `integrantesDoTimeMaisComum` | Retorna os nomes dos integrantes do time mais escalado no período |
| `funcaoMaisComum` | Retorna a função mais frequente nos times do período |
| `franquiaMaisFamosa` | Retorna a franquia mais comum nos times do período |
| `contagemPorFranquia` | Retorna a contagem de cada franquia no período |
| `contagemPorFuncao` | Retorna a contagem de cada função no período |

**Destaques da implementação:**
- Todos os métodos tratam corretamente `dataInicial` e `dataFinal` nulos (sem filtro de período)
- Lógica de filtragem por intervalo centralizada no método privado `dentroDoIntervalo`, evitando repetição de código
- Todos os testes unitários fornecidos passam com sucesso

### API de Cadastro (`ApiController`)

Endpoints de CRUD implementados:

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/adicionar-integrante` | Cadastra um novo integrante |
| `GET` | `/api/listar-integrantes` | Lista todos os integrantes |
| `GET` | `/api/listar-integrantes/{id}` | Busca integrante por ID |
| `POST` | `/api/adicionar-time` | Cadastra um novo time com composição |
| `GET` | `/api/listar-times` | Lista todos os times |
| `GET` | `/api/listar-times/{id}` | Busca time por ID |
| `DELETE` | `/api/deletar-time/{id}` | Remove um time |

### API de Processamento de Dados

Endpoints para processar e exportar os dados:

| Método | Endpoint | Parâmetros |
|---|---|---|
| `GET` | `/api/time-da-data` | `data` |
| `GET` | `/api/integrante-mais-usado` | `dataInicial` *(opcional)*, `dataFinal` *(opcional)* |
| `GET` | `/api/integrantes-time-mais-comum` | `dataInicial` *(opcional)*, `dataFinal` *(opcional)* |
| `GET` | `/api/funcao-mais-comum` | `dataInicial` *(opcional)*, `dataFinal` *(opcional)* |
| `GET` | `/api/franquia-mais-famosa` | `dataInicial` *(opcional)*, `dataFinal` *(opcional)* |
| `GET` | `/api/contagem-por-franquia` | `dataInicial` *(opcional)*, `dataFinal` *(opcional)* |
| `GET` | `/api/contagem-por-funcao` | `dataInicial` *(opcional)*, `dataFinal` *(opcional)* |

**Exemplo de uso:**
```
GET /api/time-da-data?data=1995-01-01
GET /api/integrante-mais-usado?dataInicial=1993-01-01&dataFinal=1995-01-01
GET /api/contagem-por-franquia
```

---

## Tecnologias

- **Java** com **Spring Boot**
- **JUnit** — testes unitários
- **Maven** — gerenciamento de dependências e build
- **H2** — banco de dados em memória

---

##  Pré-requisitos

- [Java JDK 8](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)

Verifique com:
```bash
java -version
mvn -version
```

---

## Como rodar o projeto

### 1. Clone o repositório
```bash
git clone https://github.com/VictorCharro/desafio-Duxus-Estagio.git
cd desafio-Duxus-Estagio
```

### 2. Execute a aplicação
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

---

## Como testar a implementação

A implementação é validada pelos testes unitários. Para executá-los:

```bash
mvn test
```

O resultado será exibido no terminal indicando quais testes passaram.

> ✅ Todos os testes fornecidos passam após a implementação.

---

## 📁 Estrutura do Projeto

```
src/
├── main/
│   └── java/br/com/duxusdesafio/
│       ├── controller/  # ApiController — endpoints REST
│       ├── model/       # Integrante, Time, ComposicaoTime
│       ├── repository/  # Interfaces JPA
│       └── service/     # ApiService — regras de negócio
└── test/
    └── java/            # Testes JUnit do ApiService
```

---

## Decisões de Implementação

- **`dentroDoIntervalo`** — método privado criado para centralizar a lógica de filtro por período, reutilizado em todos os métodos do service
- **Datas nulas** — quando `dataInicial` ou `dataFinal` são `null`, o filtro é ignorado e todos os times são considerados
- **Tratamento de erros** — buscas por ID utilizam `.orElseThrow()` para retornar mensagem clara quando o recurso não existe