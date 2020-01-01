# sale-service

<p>
Projeto dedicado a cadastrar e analisar vendas, clientes e vendedores.<br />
Teclonogias utilizadas: Spring Webflux, Spring Boot e MongoDB.<br />
Build tool: Gradle
</p>

## Rodando o projeto
<p> lembrar do certificado <br /></p>

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
</p>
