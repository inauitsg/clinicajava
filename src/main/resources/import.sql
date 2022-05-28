insert into especialidade(especialidade) values ('oftalmo');
insert into especialidade(especialidade) values ('pediatra');
insert into especialidade(especialidade) values ('psiquiatra');
insert into especialidade(especialidade) values ('ortopedista');

insert into tb_medico(nome, crm, telefone, dias, especialidade_id, created_At)values('maria','1234','3333333','sexta', 1, NOW());