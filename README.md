# api-irrigacao
![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.8.1-C71A36.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=duhhdm_api-irrigacao&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=duhhdm_api-irrigacao)

## Descrição

A API de Irrigação é um projeto em Java que automatiza o controle de sistemas de irrigação. Este sistema ajuda a otimizar o uso de recursos hídricos, gerenciando o momento e a quantidade de água utilizada em campos de plantio.

A aplicação é construída usando o framework Spring e utiliza o SonarCloud para a verificação da qualidade do código, além de integrar com o Azure WebApp para implantações contínuas.

## Índice

- [Tecnologias](#tecnologias)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Como Executar](#como-executar)
- [Testes](#testes)
- [Qualidade de Código (SonarCloud)](#qualidade-de-código-sonarcloud)
- [Build e Deploy](#build-e-deploy)

## Tecnologias

- **Java 21**: Linguagem principal de desenvolvimento.
- **Spring Framework**: Utilizado para desenvolvimento da API REST.
- **Maven**: Gerenciamento de dependências e construção do projeto.
- **SonarCloud**: Ferramenta para análise da qualidade do código.
- **Docker**: Usado para empacotamento da aplicação em contêineres.
- **Azure WebApp**: Plataforma de hospedagem usada para implantar a API.

## Configuração do Ambiente

Para configurar o ambiente de desenvolvimento local, siga os passos abaixo:

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/duhhdm/api-irrigacao.git
2. **Instale o Java 21 Certifique-se de ter o JDK 21 instalado no seu sistema:**
   ```bash
   java -version
3. **Instale o Maven Verifique se o Maven está instalado e configurado corretamente:**
   ```bash
   mvn -version

## Como Executar

1. **Compilar o projeto Use o Maven para compilar o projeto:**
    ```bash
    mvn clean install
2. **Executar a aplicação Após a compilação, execute a API com o comando:**
    ```bash
    mvn spring-boot:run

## Testes

1. **Para rodar os testes unitários do projeto, utilize o seguinte comando:**
    ```bash
   mvn test

## Qualidade de Código (SonarCloud)
ste projeto utiliza o SonarCloud para monitorar a qualidade do código. Todas as análises de cobertura de código, vulnerabilidades, e manutenibilidade podem ser acessadas no SonarCloud.

**Status do Quality Gate:**
1. Para rodar uma análise localmente antes de enviar suas alterações, execute:
    ```bash
   mvn sonar:sonar \
    -Dsonar.projectKey=duhhdm_api-irrigacao \
    -Dsonar.organization=duhhdm-1 \
    -Dsonar.host.url=https://sonarcloud.io \
    -Dsonar.login=<SEU_TOKEN_SONAR>

## Build e Deploy

Este projeto utiliza GitHub Actions para CI/CD. O pipeline é configurado para:

Analisar a qualidade de código via SonarCloud.
Executar o build do projeto usando Docker.
Fazer o deploy da imagem Docker para o Azure WebApp.


#### Branch Feature
para toda branch **feature/*** ao executar o push é executado um teste e se sucesso é criado um Pull Request para **develop**

#### Branch integration
quando finalizamos todo o desenvolvimento e testes realizamos Pull Request para branch **integration** é executado a pipe com os steps:

:test_tube: test

:hammer: build 

:construction: Deploy no ambiente de develop

#### Branch master
Ao executar o push é realizado os steps:

:hammer: build

:construction: Deploy no ambiente de PRD

