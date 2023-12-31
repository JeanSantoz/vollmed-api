create table Medicos (

    id Serial not null,
    ativo boolean not null,
    nome varchar(100) not null,
    email varchar(100) not null,
    telefone varchar(20) not null,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100) not null,
    numero varchar(100) not null,
    uf varchar(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);

update Medicos set ativo = true;