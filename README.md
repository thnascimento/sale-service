# sale-service

<p>
Projeto dedicado a cadastrar e analisar vendas, clientes e vendedores.<br />
Teclonogias utilizadas: Java 11, Spring Webflux, Spring Boot e MongoDB.<br />
Build tool: Gradle
</p>

## Rodando o projeto
<p> 
Para rodarmos o projeto, precisaremos utilizar o Docker para baixar uma imagem de MongoDB, utilizando o comando: <br />
<strong>docker pull mongo</strong> <br /><br />
Em seguida, é necessário utilizar o seguinte comando para gerar e inicializar um container a partir desta imagem: <br />
<strong>docker run --name sale-service-db -p 17017:27017 -d mongo </strong> <br /><br />
Então precisaremos ir até o diretório raiz do projeto e executar o build da aplicação através do Gradle Wrapper (lembrando que o projeto precisa do Java 11): <br />
<strong>./gradlew clean build </strong> <br /><br />
Finalmente, podemos executar o comando que iniciará nossa aplicação: <br />
<strong>./gradlew bootRun </strong> <br /><br />
  
Obs: se acontecer algum erro de certificado, é porque está faltando configurar o local do certificado Java da maquina. É possível resolver este problema criando um arquivo chamado "gradle.properties" na pasta raiz do projeto e adicionando a seguinte configuração nele: <br />
<strong>systemProp.javax.net.ssl.trustStore="caminho_do_certificado_java"</strong> <br /> <br />
Exemplo: 
<strong>systemProp.javax.net.ssl.trustStore=/usr/lib/jvm/java-11-openjdk-amd64/jre/lib/security/cacerts</strong> 
<br />
<br />
<br />
</p>

## Testando o projeto
### Inicializando o banco de dados
<p>
Para inserir os registros para testar a aplicação, basta realizar uma requisição 
HTTP utilizando o método POST no endpoint: <strong>http://localhost:8080/sales/v1/initialize</strong>
</p>
<p>
É possível verificar os dados que foram inseridos através dos endpoints: <br />
<strong>[GET] http://localhost:8080/sales/v1/customers</strong><br />
<strong>[GET] http://localhost:8080/sales/v1/salesmen</strong><br />
<strong>[GET] http://localhost:8080/sales/v1/sales</strong><br />
</p>

### Executando a análise dos dados

<p>
É possível executar a análise dos dados através do endpoint: <br />
<strong>[GET] http://localhost:8080/sales/v1/analyze</strong>
<br />
<br />
<br />
</p>

## Demais funcionalidades
### Cadastrando vendas
<p>
É possível cadastrar novas vendas: <br />
</p>

```json
Cadastrar venda: 
POST: http://localhost:8080/sales/v1/sales

{
  "salesmanName": "João",
  "items": [
      {
        "id" : 1,
       	"quantity" : 1,
       	"price" : 10.2
      }
  ]
}
```

### Utilizando filtros para buscar vendas
<p>
Além de buscar todas as vendas de uma vez, também é possível buscar vendas pelo id ou por período de data de criação, para isto basta utilizar o mesmo endpoint GET apresentado anteriormente utilizando parametros de busca.  <br />
Exemplos:  <br />
<strong>[GET] http://localhost:8080/sales/v1/sales?id=5e0e72e807796c09d9655548</strong> <br />
<strong>[GET] http://localhost:8080/sales/v1/sales?initial_date=2020-01-04&final_date=2020-02-01</strong> <br />
<br />
</p>

### Cadastrando clientes
<p>
É possível cadastrar novos clientes: <br />
</p>

```json
Cadastrar cliente: 
POST: http://localhost:8080/sales/v1/customers

{
   "cnpj" : "04142782000154",
   "name": "Maria",
   "businessArea": "rural"
}
```

<br />

### Cadastrando vendedores
<p>
É possível cadastrar novos vendedores: <br />
</p>

```json
Cadastrar vendedor: 
POST: http://localhost:8080/sales/v1/salesmen

{
   "cpf" : "96260020007",
   "name": "Bob",
   "salary" : 1040.0
}
```
