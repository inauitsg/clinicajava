insert into tb_especialidade(especialidade) values ('oftalmologia');
insert into tb_especialidade(especialidade) values ('pediatria');
insert into tb_especialidade(especialidade) values ('psiquiatria');
insert into tb_especialidade(especialidade) values ('ortopedia');

insert into tb_medico(nome, crm, telefone, dias, especialidade_id, created_At) values ('Maria dos Santos Souza','1234','3333333','sexta', 1, NOW());

insert into tb_usuario(nome, email, senha)values('maria','maria@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into tb_usuario(nome, email, senha)values('joana','joana@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into tb_usuario(nome, email, senha)values('Antonia','antonia@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

insert into tb_role(authority)values('ROLE_ADMIN');
insert into tb_role(authority)values('ROLE_USUARIO');

insert into tb_usuario_role(usuario_id, role_id)values(1,1);
insert into tb_usuario_role(usuario_id, role_id)values(2,2);