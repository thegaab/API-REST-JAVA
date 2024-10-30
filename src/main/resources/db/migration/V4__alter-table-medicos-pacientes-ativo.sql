alter table medicos add ativo tinyint;
alter table pacientes add ativo tinyint;
update medicos set ativo = 1;
update pacientes set ativo = 1;
update medicos set ativo = not null;
update pacientes set ativo = not null;