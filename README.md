# RomesCorp Java Exception Handling

Este projeto contém cinco classes Java que simulam cenários reais das empresas do conglomerado **RomesCorp**, com foco em tratamento de exceções e estrutura orientada a objetos.

## 📁 Estrutura do Projeto

Cada classe representa uma empresa e possui ao menos uma exceção personalizada e validações robustas.

| Empresa         | Classe                  | Função Principal                                   |
|-----------------|-------------------------|----------------------------------------------------|
| RomesBank       | `TransacaoBancaria`     | Transferência entre contas com validação de saldo |
| RomesCyberSec   | `Firewall`              | Controle de acesso de IPs com blacklist           |
| RomesStore      | `Estoque`               | Controle de entrada e saída de produtos           |
| RomesMart       | `CadastroCliente`       | Cadastro de clientes com validação de e-mail      |
| Romes Lanches   | `Pedido`                | Cálculo de pedidos com verificação de itens       |

---

## 💡 Funcionalidades

- Criação e lançamento de **exceções personalizadas**
- Validação de entradas com `IllegalArgumentException`
- Uso de `try/catch` para tratamento seguro de erros
- Comentários no código explicando decisões técnicas
- Testes simples via `main()` em cada classe

---

## ✍️ Autor

Desenvolvido por Pedro Vinícius Rocha Xavier
Este projeto foi criado com fins didáticos para estudos sobre tratamento de exceções em Java.
