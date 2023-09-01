# API para Gerenciamento de Estoque com Spring Framework

API desenvolvida com Spring Boot, Spring Data Jpa, Spring Web, Lombok e Bean Validation para gerenciamento do estoque de uma loja. Banco de dados PostgreSQL utilizado para armazenamento de dados.

## PRODUTOS
### Atributos:
- **ID** (Long) - Especificações: Gerado automaticamente
- **Nome** (String) - Especificações: Não pode ser nulo, vazio ou em branco
- **Categoria** (String) - Especificações: Não pode ser nulo, vazio ou em branco
- **Descrição** (String) - Especificações: Não pode ser nulo, vazio ou em branco
- **Valor** (BigDecimal) - Especificações: Não pode ser igual ou menor que zero
- **Quantidade** (Integer) - Especificações: Não pode ser menor que zero
### Requisições:
- **Post:** permite o cadastro de novos produtos com nome, categoria, descrição, valor e quantidade em estoque.
- **Get:** permite exibir todos os produtos cadastrados, um produto através de seu nome ou um produto através de seu ID.
- **Put:** permite alterar nome, categoria, descrição, valor e/ou quantidade de um produto.
- **Delete**: permite a exclusão de um produto através de seu ID.

## MOVIMENTAÇÕES
### Atributos:
- **ID** (Long) - Especificações: Gerado automaticamente
- **Produto** (Produto) - Especificações: Referencia um produto cadastrado através de seu ID
- **Tipo** (String) - Especificações: Descreve o tipo de movimentação (entrada ou saída)
- **Quantidade Movimentada** (Integer) - Especificações: Quantidade a ser acrescida (entrada) ou retirada (saída). Não é possível retirar uma quantidade maior que a disponível do produto indicado
- **Quantidade Final** (Integer) - Especificações: Quantidade disponível do produto após a movimentação
- **Data** (Date) - Especificações: data da movimentação, gerada automaticamente
- **Status** (String) - Especificações: Status da movimentação (Não realizada / Realizada)

### Requisições:
- **Post:** permite o cadastro de uma nova movimentação. Caso o tipo especificado seja inválido ou a quantidade de saída seja maior que a disponível do produto, exibe um erro e a movimentação é registrada com o Status "Não realizada". **Observação:** caso seja inserido um ID inválido para identificar o produto, exibe um erro que não foi tratado.
- **Get:** permite exibir todo o histórico de movimentações ou exibir uma movimentação através de seu ID.
- **Put e Delete:** não foram implementadas, pois a ideia é que haja um histórico confiável de todas as movimentações bem sucedidas ou não.

### TESTES E DOCUMENTAÇÃO COM SWAGGER
- Não foram implementados.
