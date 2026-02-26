create table service_order(
    id varchar(36) not null primary key,
    description varchar(200) not null,
    client_name varchar(40) not null,
    opening_date DATE,
    status varchar(30) not null,
    valor DECIMAL(10, 2) not null
);