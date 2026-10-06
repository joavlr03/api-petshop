# 📦 Execução da API com Docker

## ⚠️ Pré-requisito

Para utilizar esta API corretamente, é **obrigatório ter o Docker em execução**, pois o sistema depende de um container com banco de dados MySQL.

---

## 🐳 Importância do Docker

O Docker é responsável por criar e gerenciar o ambiente do banco de dados de forma isolada e padronizada. Isso garante que a aplicação funcione sem a necessidade de instalação manual do MySQL na máquina local.

Sem o container ativo, a API não consegue se conectar ao banco de dados, o que impede seu funcionamento.

---

## 🚀 Como executar o Docker

Antes de iniciar a aplicação, execute o container do MySQL com o seguinte comando:

## MySQL
```bash
docker run -d --name mysql --rm \
-e MYSQL_ROOT_PASSWORD=root_pwd \
-e MYSQL_USER=new_user \
-e MYSQL_PASSWORD=my_pwd \
-p 3306:3306 \
mysql
````
## SQL Server
docker run -d \
    --name sqlserver \
    --rm \
    -e MSSQL_SA_PASSWORD=1q2w3e4R@ \
    -e "ACCEPT_EULA=Y" \
    -p 1433:1433 \
    mcr.microsoft.com/mssql/server:latest 

    
#☕ Maven (Build da aplicação)

O Maven é responsável por compilar, gerenciar dependências e executar a aplicação Spring Boot.

````
mvn clean install
````

````
mvn spring-boot:run
````

## No Powershell
````
.\mvnw spring-boot:run
````

# 🗄️ Conectando ao Banco de Dados no DBeaver

## ⚠️ Pré-requisito

Antes de conectar no DBeaver, certifique-se de que:

- O Docker está em execução
- O container SQL Server está rodando
- A porta `1433` está exposta corretamente

### Login 

````
USER=sa
PASSWORD=1q2w3e4R@
````


