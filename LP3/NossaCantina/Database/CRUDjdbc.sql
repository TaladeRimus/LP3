CREATE TABLE cliente(
idCliente serial PRIMARY KEY,
nome varchar(50),
email varchar(100),
saldo numeric
);

drop table cliente cascade

select * from cliente

UPDATE CLIENTE SET saldo = 500 WHERE nome = 'ClienteTeste'


CREATE TABLE funcionario(
idFuncionario serial PRIMARY KEY,
nome varchar(50),
email varchar(100)
);

drop table funcionario cascade

select * from funcionario where nome = 'FuncTeste'

insert into funcionario ( nome, email ) values ('FuncTeste', 'teste@func.com')

CREATE TABLE produto(
idProduto serial PRIMARY KEY,
nome varchar(50),
categoria varchar(50),
preco decimal(10,2),
qtd numeric
);

select * from produto




create table login(
codLogin serial primary key,
codCliente integer,
codFuncionario integer,
usuario varchar(30) NOT NULL,
senha varchar(30) NOT NULL
);

select * from login
select * from login where login.codCliente = 1



CREATE TABLE venda(
idVenda serial PRIMARY KEY,
dVenda date DEFAULT now()::date,
idProdutoFK integer,
idClienteFK integer,
idFuncionarioFK integer,
CONSTRAINT idClienteFK FOREIGN KEY ( idClienteFK  ) REFERENCES cliente ( IdCliente ),
CONSTRAINT idFuncionarioFK FOREIGN KEY ( idFuncionarioFK ) REFERENCES funcionario ( IdFuncionario ),
CONSTRAINT idProdutoFK FOREIGN KEY ( idProdutoFK ) REFERENCES produto (idProduto)
);

select * from venda

INSERT INTO VENDA (idProdutoFK, idClienteFK, idFuncionarioFK) values(3,1, 1)

drop table venda







