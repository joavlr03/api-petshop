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

```bash
docker run -d --name mysql --rm \
-e MYSQL_ROOT_PASSWORD=root_pwd \
-e MYSQL_USER=new_user \
-e MYSQL_PASSWORD=my_pwd \
-p 3306:3306 \
mysql
````
#☕ Maven (Build da aplicação)

O Maven é responsável por compilar, gerenciar dependências e executar a aplicação Spring Boot.

````
mvn clean install
````

````
mvn spring-boot:run
````

# 🗄️ Conectando ao Banco de Dados no DBeaver

## ⚠️ Pré-requisito

Antes de conectar no DBeaver, certifique-se de que:

- O Docker está em execução
- O container MySQL está rodando
- A porta `3306` está exposta corretamente

### Login 

````
USER=root_pwd
PASSWORD=my_pwd
