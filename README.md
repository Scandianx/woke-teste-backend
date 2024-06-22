# Woke Backend

## Requisitos

- JDK 17+
- Gradle

## Como executar

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute `.\gradlew clean build`
4. Execute `./gradlew bootRun`
5. Acesse `http://localhost:8080` para ver a aplicação rodando
6. Antes de iniciar o frontend é preciso inicializar o banco de dados (mockado na memória) com um registro de usuário

## Endpoints

- `POST /api/register`: Registra um novo usuário
- `POST /api/login`: Autentica um usuário
- `GET /api/users/{id}`: Retorna as informações de um usuário
- `GET /api/sendUserData`: Envia as informações de um usuário para outras empresas (requere token)

## Segurança

- Para testar o envio de dados para empresas, use o token `valid-token` no header `Authorization`

## Arquitetura

- Optei por uma arquitetura monolítica nesta aplicação por ser apenas uma prova de conceito. O uso de microserviços, embora benéfico para grandes sistemas distribuídos, adicionaria uma complexidade desnecessária a um projeto de pequena escala como este. A simplicidade de uma arquitetura monolítica permite um desenvolvimento mais rápido e uma manutenção mais fácil, o que é ideal para o propósito atual. 

## Observações

- Esta é minha primeira vez trabalhando em um projeto com Kotlin, e achei a sintaxe bastante interessante e intuitiva. Ter uma experiência com Spring Boot utilizando Java facilitou demais o processo de aprendizagem.
- Como este é um projeto de teste utilizando um banco de dados H2 em memória, optei por não codificar a senha dos usuários. Em um ambiente de produção, a segurança seria uma prioridade e todas as senhas seriam devidamente codificadas.
