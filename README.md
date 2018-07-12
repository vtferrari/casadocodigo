# Alterado para Spring-Boot
## Ambiente 

 Aplicação foi testada com JRE8 
 
## H2

O projeto usa H2 que é um banco de dados em memória

## Compilação

 Basta usar o comando:

	mvn clean compile package
	
## Execução
    
  Basta usar o comando:
    
    mvn spring-boot:run 
 
  ou
 
    mvn spring-boot:run -Dspring.profiles.active={profile}
    
  ou
  
    java -jar path/do/jar/app.war [opções] 

## Profile DEV, DEFAULT

O projeto sobe automaticamente ativando o profile "Default". Configurado pelo proprio spring boot

Para não usar o profile "default" passar a flag -Dspring.profiles.active={profile} como argumento do start da applicação

	 "-Dspring.profiles.active=dev"

## URL e Inicialização

Ao rodar o projeto acesse:

	http://localhost:8080/casadocodigo
	
Execute a "URL Mágica" para cadastrar produtos e um usuario padrão (Login: admin@casadocodigo.com.br, Senha: 123456).

Por ser banco de dados em memoria é necessario executar todas as vezes esta URL
## Trocar o banco

Se preferir usar um outro banco relacional, altere a classe ```JPAConfiguration``` ou configure um novo profile

## SQL para geração das tables
```SQL
drop table if exists Produto;
drop table if exists Produto_precos;
drop table if exists Usuario_Role;
drop table if exists Role;
drop table if exists Usuario;
create table Produto (id integer not null auto_increment, dataLancamento datetime, descricao varchar(255), paginas integer not null, sumarioPath varchar(255), titulo varchar(255), primary key (id));
create table Produto_precos (Produto_id integer not null, tipo integer, valor decimal(19,2));
create table Role (nome varchar(255) not null, primary key (nome));
create table Usuario (email varchar(255) not null, nome varchar(255), senha varchar(255), primary key (email));
create table Usuario_Role (email varchar(255) not null, role_nome varchar(255) not null);
alter table Produto_precos add constraint FK_hl4xdmygc7v2x607r4rbs6x3a foreign key (Produto_id) references Produto (id);
alter table Usuario_Role add constraint FK_5nbp4m2sk65w2mq9rfn680cx2 foreign key (role_nome) references Role (nome);
alter table Usuario_Role add constraint FK_4w45e3buitnd4f3ok8jdlrqkh foreign key (email) references Usuario (email);
```
