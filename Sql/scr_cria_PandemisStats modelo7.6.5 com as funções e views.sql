--CRIAÇÃO
--create database pandemicstats;

create table Cidade (
	  codcid numeric(10, 0) not null, 
	  nomcid varchar(60) not null, 
	  codest_codest numeric(5, 0) not null, 
	  primary key (codcid));
 
comment on table Cidade is 'Tabela de cidades';
comment on column Cidade.codcid is 'Código da cidade';
comment on column Cidade.nomcid is 'Nome da cidade.';


create table Comorbidade (
	  codcom numeric(10, 0) not null, 
	  com    varchar(300) not null, 
	  primary key (codcom));
 
comment on table Comorbidade is 'Tabela de comorbidades';
comment on column Comorbidade.codcom is 'Código da comorbidade';
comment on column Comorbidade.com is 'Comorbidades e sua descrição se necessário.';


create table Empresa (
	  nomemp    varchar(100) not null, 
	  cnpjemp   numeric(14, 0) not null, 
	  nomfanemp varchar(100), 
	  telemp1   varchar(20) not null, 
	  telemp2   varchar(20), 
	  emaemp    varchar(30) unique, 
	  ramemp    varchar(60) not null, 
	  cpfusu_cpfusu    numeric(11, 0) not null, 
	  valemp    date default CURRENT_DATE not null, 
	  primary key (cnpjemp));
 
comment on table Empresa is 'Tabela de  empresas';
comment on column Empresa.nomemp is 'Nome da empresa';
comment on column Empresa.cnpjemp is 'CNPJ da Empresa';
comment on column Empresa.nomfanemp is 'Nome fantasia da empresa';
comment on column Empresa.telemp1 is 'Telefone 1 da empresa';
comment on column Empresa.telemp2 is 'Telefone 2 da empresa';
comment on column Empresa.emaemp is 'Email da empresa';
comment on column Empresa.ramemp is 'Ramo da empresa';
comment on column Empresa.valemp is 'Data de inserção da empresa no sistema';


create table Endereco (
	  codend  numeric(10, 0) not null, 
	  cep     numeric(8, 0) not null, 
	  rua     varchar(60) not null, 
	  num     varchar(10) not null, 
	  codcid_codcid  numeric(10, 0) not null, 
	  cpfusu_cpfusu  numeric(11, 0), 
	  cnpjemp_cnpjemp numeric(14, 0), 
	  primary key (codend));
 
comment on table Endereco is 'Tabela de endereços';
comment on column Endereco.codend is 'Código do endereço';
comment on column Endereco.cep is 'Número do CEP.';
comment on column Endereco.rua is 'Nome da rua.';
comment on column Endereco.num is 'Número da casa/prédio';


create table Estado (
	  codest numeric(5, 0) not null, 
	  nomest varchar(60) not null, 
	  codpai_codpai numeric(3, 0) not null, 
	  primary key (codest));
 
comment on table Estado is 'Tabela de estados';
comment on column Estado.codest is 'Código do estado';


create table Medico (
	  crmmed varchar(30) not null, 
	  cpfusu_cpfusu numeric(11, 0) not null, 
	  primary key (crmmed));
 
comment on table Medico is 'Tabela de medicos';
comment on column Medico.crmmed is 'CRM do médico';


create table Monitoramento_paciente (
	  codmon numeric(10, 0) not null, 
	  datmon date default CURRENT_DATE not null, 
	  intsin char(1) not null check(intsin in('P','M','C','S')), 
	  codsin_codsin numeric(10, 0) not null, 
	  codpac_codpac numeric(10, 0) not null, 
	  primary key (codmon));
 
comment on table Monitoramento_paciente is 'Tabela de vinculação monitoramento paciente.';
comment on column Monitoramento_paciente.codmon is 'Código do monitoramento';
comment on column Monitoramento_paciente.datmon is 'Data do monitoramento';
comment on column Monitoramento_paciente.intsin is 'Intensidade dos sintomas:
S - Sem sintomas;
P - Pouco;
M- Moderado;
C - Constante.';


create table Paciente (
	  pespac    numeric(5, 2) not null, 
	  grurispac char(1) not null check(in grurispac ('S','N')), 
	  sitpac    varchar(20) not null check(sitpac in('INTERNADO','ISOLAMENTO','BEM')), 
	  cpfusu_cpfusu    numeric(11, 0) not null, 
	  codpac    numeric(10, 0) not null, 
	  primary key (codpac));
 
comment on table Paciente is 'Tabela de pacientes';
comment on column Paciente.pespac is 'Peso do paciente.';
comment on column Paciente.grurispac is 'Paciente é do grupo de risco:
S- Sim;
N- Não;';
comment on column Paciente.sitpac is 'Situação do paciente:
Internado;
Isolamento;
Bem.';


create table Paciente_Comorbidade (
	  codcom_codcom    numeric(10, 0) not null, 
	  codpaccom numeric(10, 0) not null, 
	  codpac_codpac    numeric(10, 0) not null, 
	  primary key (codpaccom));
comment on table Paciente_Comorbidade is 'Tabela de vinculação paciente comorbidade';
comment on column Paciente_Comorbidade.codpaccom is 'Chave primaria da tabela, existe devido problemas de compatibilidade com o Hibernate';

create table Pais (
	  nompai varchar(60) not null unique, 
	  codpai numeric(3, 0) not null, 
	  primary key (codpai));
 
 
comment on table Pais is 'Tabela de paises.';
comment on column Pais.nompai is 'Nome do país.';
comment on column Pais.codpai is 'Chave primária código do páis.';


create table Sintoma (
	  codsin numeric(10, 0) not null, 
	  nomsin varchar(60) not null, 
	  primary key (codsin));
 
comment on table Sintoma is 'Cadastro de sintomas';
comment on column Sintoma.codsin is 'Código do sintoma.';
comment on column Sintoma.nomsin is 'Nomer do sintoma.';


create table Solicitacao (
	  codsol numeric(10, 0) not null, 
	  dessol varchar(300) not null, 
	  anasol bool default 'False' not null, 
	  cpfusu_cpfusu numeric(11, 0) not null, 
	  datsol date default CURRENT_DATE not null, 
	  primary key (codsol));
 
comment on table Solicitacao is 'Tabela de solicitações';
comment on column Solicitacao.dessol is 'Solicitação em si';
comment on column Solicitacao.anasol is 'Valor booleano que indica se a solicitação foi analisada pelo Administrador ou não:';
comment on column Solicitacao.datsol is 'Data da solicitação';


create table Teste_covid (
	  codtes    numeric(10, 0) not null, 
	  dattes    date not null check(CURRENT_DATE), 
	  covpactes char(1) not null check(covpactes in ('P','N')), 
	  codpac_codpac    numeric(10, 0) not null, 
	  primary key (codtes));
 
comment on table Teste_covid is 'Tabela de testes de covid';
comment on column Teste_covid.codtes is 'Código do teste de covid.';
comment on column Teste_covid.dattes is 'Data do teste.';
comment on column Teste_covid.covpactes is 'Resultado do teste para covid do paciente:
P-positivo
N-negativo';


create table Usuario (
	  nomusu    varchar(100) not null, 
	  senusu    varchar(20) not null, 
	  cpfusu    numeric(11, 0) not null, 
	  datnasusu date not null, 
	  sexusu    char(1) not null check(sexusu in('M','F')), 
	  telusu    varchar(20) not null, 
	  emausu    varchar(30) not null unique, 
	  cnpjemp_cnpjemp   numeric(14, 0), 
	  valusu    date default CURRENT_DATE not null, 
	  primary key (cpfusu));
	 
comment on table Usuario is 'Tabela de usuários';
comment on column Usuario.nomusu is 'Nome do usuário';
comment on column Usuario.senusu is 'Senha do usuário';
comment on column Usuario.cpfusu is 'CPF do usuario.';
comment on column Usuario.datnasusu is 'Data de nascimento do usuario.';
comment on column Usuario.sexusu is 'Sexo do usuario:
M- Masculino
F- Feminino';
comment on column Usuario.telusu is 'Telefone do usuario.';
comment on column Usuario.emausu is 'Email do usuario';
comment on column Usuario.valusu is 'Data de cadastro do usuário no sistema';


create table Vacina (
	  codvac numeric(10, 0) not null, 
	  datvac date default CURRRENT_DATE not null, 
	  dosvac int4 not null, 
	  fabvac varchar(30), 
	  crmmed_crmmed varchar(30), 
	  codpac_codpac numeric(10, 0) not null, 
	  primary key (codvac));
 
comment on table Vacina is 'Tabela de vacinas';
comment on column Vacina.codvac is 'Chave primária da tabela vacina';
comment on column Vacina.datvac is 'Data da vacinação';
comment on column Vacina.dosvac is 'Dose da vacina';
comment on column Vacina.fabvac is 'Fabricante da vacina';



alter table Estado add constraint FKEstado513581 foreign key (codpai_codpai) references Pais (codpai);
alter table Cidade add constraint FKCidade186903 foreign key (codest_codest) references Estado (codest);
alter table Endereco add constraint FKEndereco686664 foreign key (codcid_codcid) references Cidade (codcid);
alter table Monitoramento_paciente add constraint FKMonitorame117070 foreign key (codsin_codsin) references Sintoma (codsin);
alter table Usuario add constraint FKUsuario505260 foreign key (cnpjemp_cnpjemp) references Empresa (cnpjemp);
alter table Paciente_Comorbidade add constraint FKPaciente_C231517 foreign key (codcom_codcom) references Comorbidade (codcom);
alter table Vacina add constraint FKVacina513270 foreign key (crmmed_crmmed) references Medico (crmmed);
alter table Endereco add constraint FKEndereco297822 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Empresa add constraint FKEmpresa623740 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Monitoramento_paciente add constraint FKMonitorame60853 foreign key (codpac_codpac) references Paciente (codpac);
alter table Teste_covid add constraint FKTeste_covi573629 foreign key (codpac_codpac) references Paciente (codpac);
alter table Paciente_Comorbidade add constraint FKPaciente_C581063 foreign key (codpac_codpac) references Paciente (codpac);
alter table Vacina add constraint FKVacina372667 foreign key (codpac_codpac) references Paciente (codpac);
alter table Paciente add constraint FKPaciente585103 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Medico add constraint FKMedico428695 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Endereco add constraint FKEndereco640457 foreign key (cnpjemp_cpfusu) references Empresa (cnpjemp);
alter table Solicitacao add constraint FKSolicitaca988784 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);


--CRIAÇÃO DAS FUNÇÕES, VIEWS E TRIGGERS


--Tipo de  resposta cidade-covid 
create type tp_cid_covid as 
(
	nomusu varchar(100),
	sexusu char(1),
	nomemp varchar(100)
);

--Funcao cidade-covid 
create or replace function cidade_covid(codigo numeric(6,0))
returns setof tp_cid_covid
as
$body$
begin
	return query select u.nomusu, u.sexusu, e.nomemp from usuario u 
			inner join empresa e on u.cnpjemp_cnpjemp = e.cnpjemp
			inner join endereco en on en.cpfusu_cpfusu = u.cpfusu
			inner join cidade c on en.codcid_codcid = c.codcid
			inner join paciente p on p.cpfusu_cpfusu = u.cpfusu
			where (p.sitpac = 'ISOLAMENTO' or p.sitpac = 'INTERNADO') and (c.codcid = codigo);
end
$body$
language plpgsql;


--Tipo de resposta empresa-covid 
create type tp_emp_covid as 
(
	nomusu varchar(100),
	sexusu char(1),
	nomcid varchar(60)
);


--Funcao empresa-covid 
create or replace function empresa_covid(cnpj numeric(14,0))
returns setof tp_emp_covid
as
$body$
begin
	return query select u.nomusu, u.sexusu, c.nomcid from usuario u 
			inner join empresa e on u.cnpjemp_cnpjemp = e.cnpjemp
			inner join endereco en on en.cpfusu_cpfusu = u.cpfusu
			inner join cidade c on en.codcid_codcid = c.codcid
			inner join paciente p on p.cpfusu_cpfusu = u.cpfusu
			where (p.sitpac = 'ISOLAMENTO' or p.sitpac = 'INTERNADO') and (e.cnpjemp = cnpj);
end
$body$
language plpgsql;

--Funcao primeria-dose-cidade 
create or replace function p_dose_cidade(codigo numeric(6,0))
returns numeric
as
$body$
declare
	conta NUMERIC := 0;
begin
	select count(*) into conta from vacina v
	inner join paciente p on p.codpac = v.codpac_codpac
	inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
	inner join endereco en on en.cpfusu_cpfusu = u.cpfusu
	inner join cidade c on c.codcid = en.codcid_codcid 
	where ((c.codcid = codigo) and (v.dosvac = '1'));
return conta; 
end
$body$
language plpgsql;

--Funcao segunda-dose-cidade 
create or replace function s_dose_cidade(codigo numeric(6,0))
returns numeric
as
$body$
declare
	conta NUMERIC := 0;
begin
	select count(*) into conta from vacina v
	inner join paciente p on p.codpac = v.codpac_codpac
	inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
	inner join endereco en on en.cpfusu_cpfusu = u.cpfusu
	inner join cidade c on c.codcid = en.codcid_codcid 
	where ((c.codcid = codigo) and (v.dosvac = '2'));
return conta; 
end
$body$
language plpgsql;

--Funcao trigger-dose-vacina 
create or replace function controla_dosvac()
returns trigger
as
$body$
begin
	if (new.dosvac > 2) or (new.dosvac < 1) then
		raise exception 'Dose invalida';
	end if;
	return new;		
end
$body$
language plpgsql;

--Trigger-dose-vacina 
create trigger vacina_dosvac_before_tg
before insert or update
on vacina
for each row
execute procedure controla_dosvac();

--Funcao trigger-data-vacina 
create or replace function controla_datvac()
returns trigger
as
$body$
begin
	if (new.datvac > (current_date)) then
		raise exception 'Data invalida';
	end if;
	return new;		
end
$body$
language plpgsql;

--Trigger-data-vacina 
create trigger vacina_datvac_before_tg
before insert
on vacina
for each row
execute procedure controla_datvac();

--Funcao trigger-sitpac-paciente-covpactes-testecovid 
create or replace function controla_sitpac()
returns trigger
as
$body$
begin
	if (new.covpactes = 'P') then
		update paciente set sitpac = 'ISOLAMENTO' where paciente.codpac = new.codpac_codpac;
	end if;
	return new;		
end
$body$
language plpgsql;


--Trigger-sitpac-paciente-covpactes-testecovid 
create trigger testecovid_after_tg
after insert or update
on teste_covid
for each row
execute procedure controla_sitpac();

--View conta-medicos 
create view vw_conta_medicos as
select count(*) from medico;

--View conta-empresas 
create view vw_conta_empresas as
select count(*) from empresa;

--View conta-pacientes 
create view vw_conta_pacientes as
select count(*) from paciente;

--View conta-usuarios
create view vw_conta_usuarios as
select count(*) from usuario;

--Procedure cria usuario
create or replace procedure create_user(email varchar(30), senha varchar(20))
as
$body$
begin
	execute format('create user %I with password ''%s''', email, senha);
end
$body$
language plpgsql;

--Grupo empresa
create group g_empresa;
--Grupo paciente
create group g_paciente;
--Grupo medico
create group g_medico;
--Grupo administrador
create group g_administrador;
--Grupo usuario
create group g_usuario;

--Grant usuarios
grant select, insert, update, delete
on usuario, endereco
to g_usuario;

grant select
on pais, estado, cidade, comorbidade
to g_usuario;

grant insert
on solicitacao, paciente, paciente_comorbidade, medico, empresa
to g_usuario;

--Grant empresas
grant select, insert, update, delete
on empresa
to g_empresa;

grant select
on paciente, vacina, teste_covid
to g_empresa;

--Grant pacientes
grant select, insert, update
on teste_covid, monitoramento_paciente, vacina
to g_paciente;

grant delete
on paciente, paciente_comorbidade
to g_paciente;

--Grant administrador
grant select, insert, update, delete
on all tables in schema public
to g_administrador;

--Procedure grant empresa
create or replace procedure grant_empresa(email varchar(30))
as
$body$
begin
	execute format('grant g_empresa to %I', email);
end
$body$
language plpgsql;

--Procedure grant paciente
create or replace procedure grant_paciente(email varchar(30))
as
$body$
begin
	execute format('grant g_paciente to %I', email);
end
$body$
language plpgsql;

--Procedure grant medico
create or replace procedure grant_medico(email varchar(30))
as
$body$
begin
	execute format('grant g_medico to %I', email);
end
$body$
language plpgsql;

--Procedure grant administrador
create or replace procedure grant_administrador(email varchar(30))
as
$body$
begin
	execute format('grant g_administrador to %I', email);
end
$body$
language plpgsql;

--Procedure grant usuario
create or replace procedure grant_usuario(email varchar(30))
as
$body$
begin
	execute format('grant g_usuario to %I', email);
end
$body$
language plpgsql;

--Procedure drop usuario
create or replace procedure drop_user(email varchar(30))
as
$body$
begin
	execute format('drop role %I', email);
end
$body$
language plpgsql;

--Procedure troca senha
create or replace procedure alter_password(email varchar(30), senha varchar(30))
as
$body$
begin
	execute format('alter role %I with password ''%s''', email, senha);
end
$body$
language plpgsql;

--Procedure troca email
create or replace procedure alter_email(email varchar(30), newemail varchar(30))
as
$body$
begin
	execute format('alter role %I rename to %L', email, newemail);
end
$body$
language plpgsql;

--Procedure revoke group
create or replace procedure revoke_group(email varchar(30), grupo varchar(20))
as
$body$
begin
	execute format('revoke %I FROM %L', email, grupo);
end
$body$
language plpgsql;

--VIEWS ANTIGAS

/*1) Relacione o código e nome de
pacientes com idades entre 40 e 50
anos, que apresentaram tosse.
Relacione a consulta em ordem
descendente de código; OK
2) Relacione o nome do paciente,
nome da cidade de residência de
pacientes do sexo masculino,
residentes nos municípios de
Maravilha, Descanso, Pinhalzinho,
Chapecó e Itapiranga que
apresentaram sintomas e não foram
positivados com covid. Relacione o
relatório pelo nome da cidade
descendente e o nome do paciente
ascendente;  OK
3) Relacione o código da cidade,
nome da cidade, quantidade de casos
suspeitos de covid para todas as
cidades. Ordene o relatório da cidade
com menos casos suspeitos para a
cidade com mais casos suspeitos; OK
4) Relacione a idade do paciente e
quantidade de casos positivos de
covid por idade, registrados em dias
pares de 2020. Ordene o relatório pela
idade com mais casos para a idade
com menos casos.*/


create view vw_select1 as 
select p.codpac, u.nomusu from paciente p 
inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
inner join monitoramento_paciente mp on mp.codpac_codpac = p.codpac 
inner join sintoma s on mp.codsin_codsin = s.codsin 
where s.nomsin ilike '%tosse%' and 
(extract(year from current_timestamp) - extract(year from u.datnasusu)>=40) and 
(extract(year from current_timestamp) - extract(year from u.datnasusu)<=50)
order by p.codpac desc;


create view vw_select2 as
select u.nomusu, c.nomcid from paciente p 
inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
inner join endereco e on e.cpfusu_cpfusu = u.cpfusu
inner join cidade c on c.codcid = e.codcid_codcid 
inner join teste_covid tc on tc.codpac_codpac = p.codpac 
inner join monitoramento_paciente mp on mp.codpac_codpac = p.codpac 
where (tc.covpactes = 'N') and (mp.codsin_codsin not null) and (u.sexusu = 'M') and (c.nomcid in('Maravilha', 'Descanso', 'Pinhalzinho', 'Chapecó', 'Itapiranga'))
order by c.nomcid desc, u.nomusu;


create view vw_select3 as 
select c.codcid, c.nomcid, count(distinct(mp.codpac_codpac)) as conta from cidade c 
left join endereco e on e.codcid_codcid = c.codcid 
left join usuario u on u.cpfusu = e.cpfusu_cpfusu 
left join paciente p on p.cpfusu_cpfusu = u.cpfusu 
left join monitoramento_paciente mp on mp.codpac_codpac = p.codpac 
group by c.codcid
order by conta;


create view vw_select4 as
select to_char(age(u.datnasusu),'YY') as idade, count(*) as casos from paciente p
inner join teste_covid tc on tc.codpac_codpac = p.codpac 
inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
where tc.covpactes ='P' and ((extract(DAY from tc.dattes)::Integer)%2)=0
group by idade
order by casos desc;


