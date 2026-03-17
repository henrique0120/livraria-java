
# 📚 Sistema de Controle de Empréstimos - Livraria Escolar

## 📌 Descrição

Sistema desenvolvido em Java com Spring Boot para controle de empréstimos de uma biblioteca escolar de pequeno porte.

Permite o gerenciamento de alunos, responsáveis, livros e exemplares, com possibilidade de expansão futura para empréstimos e multas.

O sistema possui uma interface web amigável utilizando **Thymeleaf**, com navegação via menu inicial.

---

## 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Thymeleaf
* MySQL
* Maven

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

* JDK 17 ou superior
* Maven
* MySQL Server
* IDE (recomendado: IntelliJ ou VS Code)

---

## 🗄️ Configuração do Banco de Dados

1. Acesse o MySQL
2. Crie o banco de dados:

```sql
CREATE DATABASE livraria;
````

3. Execute o script de criação das tabelas (fornecido no projeto)

---

## 🔐 Configuração da Aplicação

No arquivo:

```
src/main/resources/application.properties
```

Configure suas credenciais do banco:

```properties
spring.datasource.url=jdbc:mysql://localhost:SUA_PORTA/livraria
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## ▶️ Como Executar o Projeto

### Opção 1 — Pela IDE

1. Abra o projeto
2. Localize a classe:

```
LivrariaApplication.java
```

3. Execute (Run)

---

### Opção 2 — Pelo terminal

Na raiz do projeto:

```bash
mvn spring-boot:run
```

---

## 🌐 Acesso ao Sistema

Após iniciar, acesse no navegador:

```
http://localhost:8080
```

### Menu Principal

O menu inicial possui cards para acesso rápido às funcionalidades:

* 📚 **Alunos** → Cadastro e listagem de alunos
* 👨‍👩‍👧 **Responsáveis** → Cadastro e listagem de responsáveis
* 📖 **Livros / Exemplares** → Cadastro e listagem de exemplares (livros e exemplares habilitados com cor marrom)
* 💰 **Multas** → Futuro módulo (desabilitado no momento)

---

## ✅ Funcionalidades Atuais

* Cadastro de alunos
* Cadastro de responsáveis
* Associação entre aluno e responsável
* Cadastro de exemplares de livros
* Validação de RA único
* Validação de CPF único
* Exibição de erros na interface
* Navegação entre telas com botão "Voltar" e links rápidos
* Menu principal com cards coloridos para facilitar acesso às seções

---

## 🔄 Funcionalidades Futuras

* Cadastro detalhado de livros
* Empréstimos
* Controle de atrasos
* Multas automáticas
* Relatórios analíticos

---

## 📌 Observações

* O projeto roda localmente (localhost)
* Não possui autenticação (escopo acadêmico)
* Estrutura simples com foco em aprendizado
* Interface responsiva com destaque visual para cada módulo

---

## 💡 Dica

Sempre execute:

```bash
mvn clean install
```

antes de rodar o projeto, para garantir que todas as dependências estão corretas.



✅ **Principais atualizações adicionadas:**
- Inclusão de **Livros / Exemplares** habilitados no menu principal (cor marrom).  
- Menção aos **botões de voltar** nas telas de cadastro de alunos, responsáveis e exemplares.  
- Atualização das funcionalidades atuais para refletir o **cadastro de exemplares**.  
- Explicação visual do **menu com cards coloridos**.

Se quiser, posso também **adicionar imagens das telas** no README para deixá-lo mais intuitivo e visual.  

Quer que eu faça isso?

