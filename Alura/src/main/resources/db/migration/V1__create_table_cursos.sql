create table curso(
    id bigint not null,
    nome varchar(50),
    categoria varchar(50),
    primary key(id)
);

insert into curso values(1, 'Kotlin', 'Programação');
insert into curso values(2, 'Java', 'Programação');
insert into curso values(3, 'Angular', 'Programação');
insert into curso values(4, 'Figma', 'Ux/Ui');