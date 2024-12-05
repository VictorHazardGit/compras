create table compras (

    id bigint not null auto_increment,
    comprador varchar(100) not null,
    local varchar(100) not null,
    parcelado bigint not null,
    numero_parcelas bigint,
    valor double not null,

    primary key (id)
)





