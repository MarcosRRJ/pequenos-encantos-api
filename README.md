# Pequenos Encantos API

Backend do MVP da Pequenos Encantos, uma loja virtual de moda infantil focada em validar vendas com baixo custo e operação simples com fornecedores parceiros.

## Stack inicial

- Java 21
- Spring Boot 3
- Maven
- PostgreSQL
- Flyway
- Docker Compose

## Como subir o PostgreSQL

Na raiz do projeto, execute:

```bash
docker compose up -d
```

O banco será criado com as seguintes credenciais:

- Database: `pequenos_encantos`
- Usuário: `pequenos`
- Senha: `pequenos123`
- Porta local: `5432`

## Como rodar a aplicação

Com o PostgreSQL em execução e Maven instalado localmente, rode:

```bash
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Endpoints iniciais

### Saúde

```http
GET /api/health
```

Resposta esperada:

```json
{
  "status": "UP",
  "service": "pequenos-encantos-api"
}
```

### Fornecedores

```http
POST /api/suppliers
GET /api/suppliers
GET /api/suppliers/{id}
PUT /api/suppliers/{id}
DELETE /api/suppliers/{id}
```

O `DELETE` faz soft delete, marcando o fornecedor como inativo. A listagem retorna apenas fornecedores ativos.

## Exemplo de JSON para criar fornecedor

```json
{
  "name": "Fornecedor Encanto Kids",
  "whatsapp": "11999999999",
  "city": "São Paulo",
  "state": "SP",
  "averageShipDays": 3,
  "shipsToCustomer": true,
  "acceptsExchange": false,
  "defectPolicy": "Troca por defeito em até 7 dias após o recebimento.",
  "notes": "Bom mix de vestidos infantis."
}
```

Exemplo com `curl`:

```bash
curl -X POST http://localhost:8080/api/suppliers \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Fornecedor Encanto Kids",
    "whatsapp": "11999999999",
    "city": "São Paulo",
    "state": "SP",
    "averageShipDays": 3,
    "shipsToCustomer": true,
    "acceptsExchange": false,
    "defectPolicy": "Troca por defeito em até 7 dias após o recebimento.",
    "notes": "Bom mix de vestidos infantis."
  }'
```

## Próximos passos sugeridos para o MVP

1. Criar o módulo de produtos com variações por tamanho/cor.
2. Modelar estoque simples por variação e fornecedor.
3. Adicionar cálculo de preço e margem usando `BigDecimal`.
4. Criar pedido simples e geração de mensagem para o fornecedor via WhatsApp.
