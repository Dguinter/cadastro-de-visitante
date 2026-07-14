# Sistema de Evento - Cadastro, Listagem e Sorteio
# Desenvolvido por Daniel Guinter.

## 📌 Descrição
Aplicação desenvolvida em **Spring Boot + Thymeleaf** para gerenciar visitantes e brindes em eventos.
Permite:
- Cadastro de visitantes
- Listagem de visitantes e brindes
- Sorteio de visitante + brinde
- Impressão simulada de crachá com QR Code

---

## 🛠️ Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Banco de dados H2 (em memória ou servidor TCP)
- Maven

---

## 🚀 Fluxo Seguro de Desenvolvimento
Para evitar erros de dependência ou tabelas inexistentes, siga esta ordem:

1. **Entidades**  
   - `Visitante` e `Brinde` com `@Entity` e `@Table`.

2. **Repositórios**  
   - `VisitanteRepository` e `BrindeRepository`.

3. **Serviços**  
   - `VisitanteService`, `BrindeService`, `SorteioService`.

4. **Controllers**  
   - `VisitanteController`, `BrindeController`, `SorteioController`, `HomeController`.

5. **Templates Thymeleaf**  
   - `formulario.html`, `visitantes/lista.html`, `brindes/lista.html`, `sorteio.html`, `index.html`.

6. **Dados de inicialização (`data.sql`)**  
   - 122 visitantes e 50 brindes.

7. **Testes e validação**  
   - Executar `mvn spring-boot:run` e validar no H2 Console.

---

## 📂 Estrutura de pacotes
- `com.evento.model` → entidades
- `com.evento.repository` → repositórios
- `com.evento.service` → serviços
- `com.evento.controller` → controllers
- `src/main/resources/templates` → páginas Thymeleaf
- `src/main/resources/data.sql` → dados iniciais

---

## 📋 Regras de negócio
- Cada visitante possui: **nome, telefone, email, empresa**.
- Cada brinde possui: **nome, descrição**.
- O sorteio seleciona **um visitante e um brinde aleatoriamente**.
- Após cadastro, é exibida mensagem de sucesso e simulação de crachá com QR Code.
- O sistema deve permitir múltiplos cadastros e sorteios sem reiniciar.

---

## ⚙️ Execução
1. Compile o projeto:


---

## 📖 Dicas de uso
- `/visitantes` → formulário de cadastro
- `/visitantes/lista` → lista de visitantes
- `/brindes/lista` → lista de brindes
- `/sorteio` → sorteio de visitante + brinde
- `/h2-console` → console do banco H2

---

## ✅ Boas práticas
- Sempre versionar o `data.sql`.
- Usar `spring.jpa.hibernate.ddl-auto=update` para evitar erros de tabela.
- Documentar novos endpoints no README.
- Testar cada funcionalidade antes de distribuir o executável.

