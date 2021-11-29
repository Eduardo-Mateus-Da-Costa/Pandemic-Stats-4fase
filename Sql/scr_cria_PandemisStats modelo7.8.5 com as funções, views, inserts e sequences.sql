--CRIA��O
--create database pandemicstats;

create table Cidade (
	  codcid numeric(10, 0) not null, 
	  nomcid varchar(60) not null, 
	  codest_codest numeric(5, 0) not null, 
	  primary key (codcid));
 
comment on table Cidade is 'Tabela de cidades';
comment on column Cidade.codcid is 'C�digo da cidade';
comment on column Cidade.nomcid is 'Nome da cidade.';


create table Comorbidade (
	  codcom numeric(10, 0) not null, 
	  com    varchar(300) not null, 
	  primary key (codcom));
 
comment on table Comorbidade is 'Tabela de comorbidades';
comment on column Comorbidade.codcom is 'C�digo da comorbidade';
comment on column Comorbidade.com is 'Comorbidades e sua descri��o se necess�rio.';


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
	  cep     numeric(8, 0) not null, 
	  rua     varchar(60) not null, 
	  num     varchar(10) not null, 
	  codcid_codcid  numeric(10, 0) not null, 
	  primary key (cnpjemp));
 
comment on table Empresa is 'Tabela de  empresas';
comment on column Empresa.nomemp is 'Nome da empresa';
comment on column Empresa.cnpjemp is 'CNPJ da Empresa';
comment on column Empresa.nomfanemp is 'Nome fantasia da empresa';
comment on column Empresa.telemp1 is 'Telefone 1 da empresa';
comment on column Empresa.telemp2 is 'Telefone 2 da empresa';
comment on column Empresa.emaemp is 'Email da empresa';
comment on column Empresa.ramemp is 'Ramo da empresa';
comment on column Empresa.valemp is 'Data de inser��o da empresa no sistema';
comment on column Empresa.cep is 'N�mero do CEP.';
comment on column Empresa.rua is 'Nome da rua.';
comment on column Empresa.num is 'N�mero da casa/pr�dio';


create table Estado (
	  codest numeric(5, 0) not null, 
	  nomest varchar(60) not null, 
	  codpai_codpai numeric(3, 0) not null, 
	  primary key (codest));
 
comment on table Estado is 'Tabela de estados';
comment on column Estado.codest is 'C�digo do estado';


create table Medico (
	  crmmed varchar(30) not null, 
	  cpfusu_cpfusu numeric(11, 0) not null unique, 
	  primary key (crmmed));
 
comment on table Medico is 'Tabela de medicos';
comment on column Medico.crmmed is 'CRM do m�dico';


create table Monitoramento_paciente (
	  codmon numeric(10, 0) not null, 
	  datmon date default CURRENT_DATE not null, 
	  intsin char(1) not null check(intsin in('P','M','C','S')), 
	  codsin_codsin numeric(10, 0) not null, 
	  codpac_codpac numeric(10, 0) not null, 
	  primary key (codmon));
 
comment on table Monitoramento_paciente is 'Tabela de vincula��o monitoramento paciente.';
comment on column Monitoramento_paciente.codmon is 'C�digo do monitoramento';
comment on column Monitoramento_paciente.datmon is 'Data do monitoramento';
comment on column Monitoramento_paciente.intsin is 'Intensidade dos sintomas:
S - Sem sintomas;
P - Pouco;
M- Moderado;
C - Constante.';


create table Paciente (
	  pespac    numeric(5, 2) not null, 
	  grurispac char(1) not null check(grurispac in('S','N')), 
	  sitpac    varchar(20) not null check(sitpac in('INTERNADO','ISOLAMENTO','BEM')), 
	  cpfusu_cpfusu    numeric(11, 0) not null unique, 
	  codpac    numeric(10, 0) not null, 
	  primary key (codpac));
 
comment on table Paciente is 'Tabela de pacientes';
comment on column Paciente.pespac is 'Peso do paciente.';
comment on column Paciente.grurispac is 'Paciente � do grupo de risco:
S- Sim;
N- N�o;';
comment on column Paciente.sitpac is 'Situa��o do paciente:
Internado;
Isolamento;
Bem.';


create table Paciente_Comorbidade (
	  codcom_codcom    numeric(10, 0) not null, 
	  codpaccom numeric(10, 0) not null, 
	  codpac_codpac    numeric(10, 0) not null, 
	  primary key (codpaccom));
comment on table Paciente_Comorbidade is 'Tabela de vincula��o paciente comorbidade';
comment on column Paciente_Comorbidade.codpaccom is 'Chave primaria da tabela, existe devido problemas de compatibilidade com o Hibernate';

create table Pais (
	  nompai varchar(60) not null unique, 
	  codpai numeric(3, 0) not null, 
	  primary key (codpai));
 
 
comment on table Pais is 'Tabela de paises.';
comment on column Pais.nompai is 'Nome do pa�s.';
comment on column Pais.codpai is 'Chave prim�ria c�digo do p�is.';


create table Sintoma (
	  codsin numeric(10, 0) not null, 
	  nomsin varchar(60) not null, 
	  primary key (codsin));
 
comment on table Sintoma is 'Cadastro de sintomas';
comment on column Sintoma.codsin is 'C�digo do sintoma.';
comment on column Sintoma.nomsin is 'Nomer do sintoma.';


create table Solicitacao (
	  codsol numeric(10, 0) not null, 
	  dessol varchar(300) not null, 
	  anasol bool default 'False' not null, 
	  cpfusu_cpfusu numeric(11, 0) not null, 
	  datsol date default CURRENT_DATE not null, 
	  primary key (codsol));
 
comment on table Solicitacao is 'Tabela de solicita��es';
comment on column Solicitacao.dessol is 'Solicita��o em si';
comment on column Solicitacao.anasol is 'Valor booleano que indica se a solicita��o foi analisada pelo Administrador ou n�o:';
comment on column Solicitacao.datsol is 'Data da solicita��o';


create table Teste_covid (
	  codtes    numeric(10, 0) not null, 
	  dattes    date not null default CURRENT_DATE, 
	  covpactes char(1) not null check(covpactes in ('P','N')), 
	  codpac_codpac    numeric(10, 0) not null, 
	  primary key (codtes));
 
comment on table Teste_covid is 'Tabela de testes de covid';
comment on column Teste_covid.codtes is 'C�digo do teste de covid.';
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
	  valusu    date not null default CURRENT_DATE, 
	  cep     numeric(8, 0) not null, 
	  rua     varchar(60) not null, 
	  num     varchar(10) not null, 
	  codcid_codcid  numeric(10, 0) not null, 
	  primary key (cpfusu));
	 
comment on table Usuario is 'Tabela de usu�rios';
comment on column Usuario.nomusu is 'Nome do usu�rio';
comment on column Usuario.senusu is 'Senha do usu�rio';
comment on column Usuario.cpfusu is 'CPF do usuario.';
comment on column Usuario.datnasusu is 'Data de nascimento do usuario.';
comment on column Usuario.sexusu is 'Sexo do usuario:
M- Masculino
F- Feminino';
comment on column Usuario.telusu is 'Telefone do usuario.';
comment on column Usuario.emausu is 'Email do usuario';
comment on column Usuario.valusu is 'Data de cadastro do usu�rio no sistema';
comment on column Usuario.cep is 'N�mero do CEP.';
comment on column Usuario.rua is 'Nome da rua.';
comment on column Usuario.num is 'N�mero da casa/pr�dio';


create table Vacina (
	  codvac numeric(10, 0) not null, 
	  datvac date  not null default CURRENT_DATE, 
	  dosvac int4 not null, 
	  fabvac varchar(30), 
	  crmmed_crmmed varchar(30) not null, 
	  codpac_codpac numeric(10, 0) not null, 
	  primary key (codvac));
 
comment on table Vacina is 'Tabela de vacinas';
comment on column Vacina.codvac is 'Chave prim�ria da tabela vacina';
comment on column Vacina.datvac is 'Data da vacina��o';
comment on column Vacina.dosvac is 'Dose da vacina';
comment on column Vacina.fabvac is 'Fabricante da vacina';



alter table Estado add constraint FKEstado513581 foreign key (codpai_codpai) references Pais (codpai);
alter table Cidade add constraint FKCidade186903 foreign key (codest_codest) references Estado (codest);
alter table Usuario add constraint FKUsuario686664 foreign key (codcid_codcid) references Cidade (codcid);
alter table Monitoramento_paciente add constraint FKMonitorame117070 foreign key (codsin_codsin) references Sintoma (codsin);
alter table Usuario add constraint FKUsuario505260 foreign key (cnpjemp_cnpjemp) references Empresa (cnpjemp);
alter table Paciente_Comorbidade add constraint FKPaciente_C231517 foreign key (codcom_codcom) references Comorbidade (codcom);
alter table Vacina add constraint FKVacina513270 foreign key (crmmed_crmmed) references Medico (crmmed);
alter table Empresa add constraint FKEmpresa297822 foreign key (codcid_codcid) references Cidade (codcid);
alter table Empresa add constraint FKEmpresa623740 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Monitoramento_paciente add constraint FKMonitorame60853 foreign key (codpac_codpac) references Paciente (codpac);
alter table Teste_covid add constraint FKTeste_covi573629 foreign key (codpac_codpac) references Paciente (codpac);
alter table Paciente_Comorbidade add constraint FKPaciente_C581063 foreign key (codpac_codpac) references Paciente (codpac);
alter table Vacina add constraint FKVacina372667 foreign key (codpac_codpac) references Paciente (codpac);
alter table Paciente add constraint FKPaciente585103 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Medico add constraint FKMedico428695 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);
alter table Solicitacao add constraint FKSolicitaca988784 foreign key (cpfusu_cpfusu) references Usuario (cpfusu);


--CRIA��O DAS SEQUENCES

create sequence public.seq_paciente
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_cidade
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_comorbidade
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_estado
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_monitoramento_paciente
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_paciente_comorbidade
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_pais
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_sintoma
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_solicitacao
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;


create sequence public.seq_teste_covid
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;

create sequence public.seq_vacina
	increment by 1
	minvalue 1
	maxvalue 9223372036854775807
	start 1
	cache 1
	no cycle;


--CRIA��O DAS FUN��ES, VIEWS E TRIGGERS


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
			inner join paciente p on p.cpfusu_cpfusu = u.cpfusu
			where (p.sitpac = 'ISOLAMENTO' or p.sitpac = 'INTERNADO') and (u.codcid_codcid = codigo);
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
			inner join cidade c on u.codcid_codcid = c.codcid
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
	where ((u.codcid_codcid = codigo) and (v.dosvac = '1'));
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
	where ((u.codcid_codcid = codigo) and (v.dosvac = '2'));
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


--Funcao trigger-controla-unicidade-comorbidade 
create or replace function controla_comorbidade()
returns trigger
as
$body$
declare 
	codcom numeric := 0;
begin
	select count(pc.codcom_codcom) into codcom from paciente_comorbidade pc
	where pc.codpac_codpac = new.codpac_codpac and pc.codcom_codcom = new.codcom_codcom;
    if (codcom > 0) then
        raise exception 'J� cadastrado';
    end if;
    return new;
end
$body$
language plpgsql;

--Trigger-controla-unicidade-comorbidade 
create trigger paciente_comorbidade_before_tg
before insert or update
on paciente_comorbidade
for each row
execute procedure controla_comorbidade();


--Funcao trigger-controla-paciente-empresa
create or replace function controla_paciente_empresa()
returns trigger
as
$body$
declare 
	cod numeric;
begin
	select u.cnpjemp_cnpjemp into cod from usuario u
	where u.cpfusu = new.cpfusu_cpfusu;
    if (cod is null) then
        raise exception 'Usu�rio n�o vinculado a empresa';
    end if;
    return new;
end
$body$
language plpgsql;

--Trigger-controla-paciente-empresa
create trigger paciente_empresa_before_tg
before insert or update
on paciente
for each row
execute procedure controla_paciente_empresa();

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
on usuario
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

/*1) Relacione o c�digo e nome de
pacientes com idades entre 40 e 50
anos, que apresentaram tosse.
Relacione a consulta em ordem
descendente de c�digo; OK
2) Relacione o nome do paciente,
nome da cidade de resid�ncia de
pacientes do sexo masculino,
residentes nos munic�pios de
Maravilha, Descanso, Pinhalzinho,
Chapec� e Itapiranga que
apresentaram sintomas e n�o foram
positivados com covid. Relacione o
relat�rio pelo nome da cidade
descendente e o nome do paciente
ascendente;  OK
3) Relacione o c�digo da cidade,
nome da cidade, quantidade de casos
suspeitos de covid para todas as
cidades. Ordene o relat�rio da cidade
com menos casos suspeitos para a
cidade com mais casos suspeitos; OK
4) Relacione a idade do paciente e
quantidade de casos positivos de
covid por idade, registrados em dias
pares de 2020. Ordene o relat�rio pela
idade com mais casos para a idade
com menos casos. OK*/


create view vw_select1 as 
select p.codpac, u.nomusu from paciente p 
inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
inner join monitoramento_paciente mp on mp.codpac_codpac = p.codpac 
where (mp.codsin_codsin = 3) and 
(extract(year from current_timestamp) - extract(year from u.datnasusu)>=40) and 
(extract(year from current_timestamp) - extract(year from u.datnasusu)<=50)
order by p.codpac desc;


create view vw_select2 as
select u.nomusu, c.nomcid from paciente p 
inner join usuario u on u.cpfusu = p.cpfusu_cpfusu 
inner join cidade c on c.codcid = u.codcid_codcid 
inner join teste_covid tc on tc.codpac_codpac = p.codpac 
inner join monitoramento_paciente mp on mp.codpac_codpac = p.codpac 
where (tc.covpactes = 'N') and (mp.codsin_codsin notnull) and (u.sexusu = 'M') and (c.nomcid in('Maravilha', 'Descanso', 'Pinhalzinho', 'Chapec�', 'Itapiranga'))
order by c.nomcid desc, u.nomusu;


create view vw_select3 as 
select c.codcid, c.nomcid, count(distinct(mp.codpac_codpac)) as conta from cidade c 
left join usuario u on u.codcid_codcid = c.codcid 
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



--INSERTS

Insert into pais (codpai ,nompai) values
  (1,'Afeganist�o'),
  (2,'�frica do Sul'),
  (3,'�land, Ilhas'),
  (4,'Alb�nia'),
  (5,'Alemanha'),
  (6,'Andorra'),
  (7,'Angola'),
  (8,'Anguilla'),
  (9,'Ant�rtida'),
  (10,'Antigua e Barbuda'),
  (11,'Antilhas Holandesas'),
  (12,'Ar�bia Saudita'),
  (13,'Arg�lia'),
  (14,'Argentina'),
  (15,'Arm�nia'),
  (16,'Aruba'),
  (17,'Austr�lia'),
  (18,'�ustria'),
  (19,'Azerbaij�o'),
  (20,'Bahamas'),
  (21,'Bahrain'),
  (22,'Bangladesh'),
  (23,'Barbados'),
  (24,'B�lgica'),
  (25,'Belize'),
  (26,'Benin'),
  (27,'Bermuda'),
  (28,'Bielo-R�ssia'),
  (29,'Bol�via'),
  (30,'B�snia-Herzegovina'),
  (31,'Botswana'),
  (32,'Bouvet, Ilha'),
  (33,'Brasil'),
  (34,'Brunei'),
  (35,'Bulg�ria'),
  (36,'Burkina Faso'),
  (37,'Burundi'),
  (38,'But�o'),
  (39,'Cabo Verde'),
  (40,'Cambodja'),
  (41,'Camar�es'),
  (42,'Canad�'),
  (43,'Cayman, Ilhas'),
  (44,'Cazaquist�o'),
  (45,'Centro-africana, Rep�blica'),
  (46,'Chade'),
  (47,'Checa, Rep�blica'),
  (48,'Chile'),
  (49,'China'),
  (50,'Chipre'),
  (51,'Christmas, Ilha'),
  (52,'Cocos, Ilhas'),
  (53,'Col�mbia'),
  (54,'Comores'),
  (55,'Congo, Rep�blica do'),
  (56,'Congo, Rep�blica Democr�tica do antigo Zaire'),
  (57,'Cook, Ilhas'),
  (58,'Coreia do Sul'),
  (59,'Coreia, Rep�blica Democr�tica da Coreia do Norte'),
  (60,'Costa do Marfim'),
  (61,'Costa Rica'),
  (62,'Cro�cia'),
  (63,'Cuba'),
  (64,'Dinamarca'),
  (65,'Djibouti'),
  (66,'Dominica'),
  (67,'Dominicana, Rep�blica'),
  (68,'Egipto'),
  (69,'El Salvador'),
  (70,'Emiratos �rabes Unidos'),
  (71,'Equador'),
  (72,'Eritreia'),
  (73,'Eslov�quia'),
  (74,'Eslov�nia'),
  (75,'Espanha'),
  (76,'Estados Unidos da Am�rica'),
  (77,'Est�nia'),
  (78,'Eti�pia'),
  (79,'Faroe, Ilhas'),
  (80,'Fiji'),
  (81,'Filipinas'),
  (82,'Finl�ndia'),
  (83,'Fran�a'),
  (84,'Gab�o'),
  (85,'G�mbia'),
  (86,'Gana'),
  (87,'Ge�rgia'),
  (88,'Ge�rgia do Sul e Sandwich do Sul, Ilhas'),
  (89,'Gibraltar'),
  (90,'Gr�cia'),
  (91,'Grenada'),
  (92,'Groenl�ndia'),
  (93,'Guadeloupe'),
  (94,'Guam'),
  (95,'Guatemala'),
  (96,'Guernsey'),
  (97,'Guiana'),
  (98,'Guiana Francesa'),
  (99,'Guin�-Bissau'),
  (100,'Guin�-Conacri'),
  (101,'Guin� Equatorial'),
  (102,'Haiti'),
  (103,'Heard e Ilhas McDonald, Ilha'),
  (104,'Honduras'),
  (105,'Hong Kong'),
  (106,'Hungria'),
  (107,'I�men'),
  (108,'�ndia'),
  (109,'Indon�sia'),
  (110,'Iraque'),
  (111,'Ir�o'),
  (112,'Irlanda'),
  (113,'Isl�ndia'),
  (114,'Israel'),
  (115,'It�lia'),
  (116,'Jamaica'),
  (117,'Jap�o'),
  (118,'Jersey'),
  (119,'Jord�nia'),
  (120,'Kiribati'),
  (121,'Kuwait'),
  (122,'Laos'),
  (123,'Lesoto'),
  (124,'Let�nia'),
  (125,'L�bano'),
  (126,'Lib�ria'),
  (127,'L�bia'),
  (128,'Liechtenstein'),
  (129,'Litu�nia'),
  (130,'Luxemburgo'),
  (131,'Macau'),
  (132,'Maced�nia'),
  (133,'Madag�scar'),
  (134,'Mal�sia'),
  (135,'Malawi'),
  (136,'Maldivas'),
  (137,'Mali'),
  (138,'Malta'),
  (139,'Malvinas, Ilhas Falkland'),
  (140,'Man, Ilha de'),
  (141,'Marianas Setentrionais'),
  (142,'Marrocos'),
  (143,'Marshall, Ilhas'),
  (144,'Martinica'),
  (145,'Maur�cia'),
  (146,'Maurit�nia'),
  (147,'Mayotte'),
  (148,'Menores Distantes dos Estados Unidos, Ilhas'),
  (149,'M�xico'),
  (150,'Myanmar, antiga Birm�nia'),
  (151,'Micron�sia, Estados Federados da'),
  (152,'Mo�ambique'),
  (153,'Mold�via'),
  (154,'M�naco'),
  (155,'Mong�lia'),
  (156,'Montenegro'),
  (157,'Montserrat'),
  (158,'Nam�bia'),
  (159,'Nauru'),
  (160,'Nepal'),
  (161,'Nicar�gua'),
  (162,'N�ger'),
  (163,'Nig�ria'),
  (164,'Niue'),
  (165,'Norfolk, Ilha'),
  (166,'Noruega'),
  (167,'Nova Caled�nia'),
  (168,'Nova Zel�ndia, Aotearoa'),
  (169,'Oman'),
  (170,'Pa�ses Baixos, Holanda'),
  (171,'Palau'),
  (172,'Palestina'),
  (173,'Panam�'),
  (174,'Papua-Nova Guin�'),
  (175,'Paquist�o'),
  (176,'Paraguai'),
  (177,'Peru'),
  (178,'Pitcairn'),
  (179,'Polin�sia Francesa'),
  (180,'Pol�nia'),
  (181,'Porto Rico'),
  (182,'Portugal'),
  (183,'Qatar'),
  (184,'Qu�nia'),
  (185,'Quirguist�o'),
  (186,'Reino Unido da Gr�-Bretanha e Irlanda do Norte'),
  (187,'Reuni�o, Ilha'),
  (188,'Rom�nia'),
  (189,'Ruanda'),
  (190,'R�ssia'),
  (191,'Saara Ocidental'),
  (192,'Samoa Americana'),
  (193,'Samoa, Samoa Ocidental'),
  (194,'Saint Pierre et Miquelon'),
  (195,'Salom�o, Ilhas'),
  (196,'S�o Crist�v�o e N�vis, Saint Kitts e Nevis'),
  (197,'San Marino'),
  (198,'S�o Tom� e Pr�ncipe'),
  (199,'S�o Vicente e Granadinas'),
  (200,'Santa Helena'),
  (201,'Santa L�cia'),
  (202,'Senegal'),
  (203,'Serra Leoa'),
  (204,'S�rvia'),
  (205,'Seychelles'),
  (206,'Singapura'),
  (207,'S�ria'),
  (208,'Som�lia'),
  (209,'Sri Lanka'),
  (210,'Suazil�ndia'),
  (211,'Sud�o'),
  (212,'Su�cia'),
  (213,'Su��a'),
  (214,'Suriname'),
  (215,'Svalbard e Jan Mayen'),
  (216,'Tail�ndia'),
  (217,'Taiwan'),
  (218,'Tajiquist�o'),
  (219,'Tanz�nia'),
  (220,'Terras Austrais e Ant�rticas Francesas, TAAF'),
  (221,'Territ�rio Brit�nico do Oceano �ndico'),
  (223,'Timor-Leste'),
  (224,'Togo'),
  (225,'Toquelau'),
  (226,'Tonga'),
  (227,'Trindade e Tobago'),
  (228,'Tun�sia'),
  (229,'Turks e Caicos'),
  (230,'Turquemenist�o'),
  (231,'Turquia'),
  (232,'Tuvalu'),
  (233,'Ucr�nia'),
  (234,'Uganda'),
  (235,'Uruguai'),
  (236,'Usbequist�o'),
  (237,'Vanuatu'),
  (238,'Vaticano'),
  (239,'Venezuela'),
  (240,'Vietname'),
  (241,'Virgens Americanas, Ilhas'),
  (242,'Virgens Brit�nicas, Ilhas'),
  (243,'Wallis e Futuna'),
  (244,'Z�mbia'),
  (245,'Zimbabue'),
  (246,'Outro');
				  
  insert into estado(codest, nomest, codpai_codpai) values
  (1,'Acre', 33), 
  (2, 'Alagoas', 33),  
  (3, 'Amazonas', 33),
  (4, 'Amap�', 33),
  (5, 'Bahia', 33),
  (6, 'Cear�', 33),
  (7, 'Distrito Federal', 33),
  (8, 'Esp�rito Santo', 33),
  (9, 'Goi�s', 33),
  (10, 'Maranh�o', 33),
  (11, 'Minas Gerais', 33),
  (12, 'Mato Grosso do Sul', 33),
  (13, 'Mato Grosso', 33),
  (14, 'Par�', 33),
  (15, 'Para�ba', 33),
  (16, 'Pernambuco', 33),
  (17, 'Piau�', 33),
  (18, 'Paran�', 33),
  (19, 'Rio de Janeiro', 33),
  (20, 'Rio Grande do Norte', 33),
  (21, 'Rond�nia', 33),
  (22, 'Roraima', 33),
  (23, 'Rio Grande do Sul', 33),
  (24, 'Santa Catarina', 33),
  (25, 'Sergipe', 33),
  (26,'S�o Paulo', 33),
  (27, 'Tocantins', 33),
  (28, 'Outro', 33);
  
insert into cidade(codcid, nomcid, codest_codest) values
  (1,'S�o Jos� do Cedro', 24),  
  (2, 'S�o Miguel do Oeste', 24),  
  (3, 'Guaraciaba', 24),
  (4, 'Maravilha', 24),
  (5, 'Descanso', 24),
  (6, 'Dion�sio Cerqueira', 24),
  (7, 'Florian�polis', 24),
  (8, 'Chapec�', 24),
  (9, 'Lages', 24),
  (10, 'Balne�rio Cambori�', 24),
  (11, 'Outro', 24);	 
						  
						  
insert into sintoma(codsin, nomsin) values
 (1, 'Febre'),
 (2, 'Espirros e secre��o nasal'),
 (3, 'Tosse seca'),
 (4, 'Dor no corpo'),
 (5, 'Dor de cabe�a'),
 (6, 'Dor ou irrita��o na garganta'),
 (7, 'Dificuldade respirat�ria'),
 (8, 'Diarreia'),
 (9, 'Perda de paladar e/ou olfato'),
 (10, 'Outros sintomas'),
 (11, 'Oximetria ou Satura��o de oxig�nio por ox�metro');
						 
insert into comorbidade(codcom, com) values
 (1, 'Idade igual ou superior a 60 anos'),
 (2, 'Tabagismo'),
 (3, 'Obesidade'),
 (4, 'Miocardiopatias de diferentes etiologias (insufici�ncia card�aca, miocardiopatia isqu�mica etc.)'),
 (5, 'Hipertens�o arterial'),
 (6, 'Pneumopatias graves ou descompensados (asma moderada/grave, DPOC)'),
 (7, 'Imunodepress�o e imunossupress�o'),
 (8, 'Doen�as renais cr�nicas em est�gio avan�ado (graus 3, 4 e 5)'),
 (9, 'Diabetes melito, conforme ju�zo cl�nico'),
 (10, 'Doen�as cromoss�micas com estado de fragilidade imunol�gica'),
 (11, 'Neoplasia maligna (exceto c�ncer n�o melan�tico de pele)'),
 (12, 'Algumas doen�as hematol�gicas (incluindo anemia falciforme e talassemia)'),
 (13, 'Gesta��o');
			

--Usuario
insert into usuario(cpfusu, cep, emausu, nomusu, num, senusu, rua, telusu, codcid_codcid, datnasusu, sexusu) 
select id, (id+10), 'usuario.'||id||'@gmail.com', 'Usuario '||id, 'Num '||id, 'Senha'||id, 'Rua'||id, cast((id+1000) as varchar), id, cast('2020-05-20' as date)+id,  
case when mod(id, 2)=0 then 'M' else 'F' end
from generate_series(1, 11) as t(id);

--Empresa
insert into empresa(cnpjemp, cep, emaemp, nomemp, num, ramemp, rua, telemp1, codcid_codcid, cpfusu_cpfusu) 
select id, (id+10), 'empresa.'||id||'@gmail.com', 'Empresa '||id, 'Num '||id, 'Ramo'||id, 'Rua'||id, cast((id+1000) as varchar), id, id 
from generate_series(1, 11) as t(id);

insert into empresa(cnpjemp, cep, emaemp, nomemp, num, ramemp, rua, telemp1, codcid_codcid, cpfusu_cpfusu) 
select id, (id+10), 'empresa.'||id||'@gmail.com', 'Empresa '||id, 'Num '||id, 'Ramo'||id, 'Rua'||id, cast((id+1000) as varchar), (id-11), (id-11) 
from generate_series(12, 22) as t(id);

--Usuario
insert into usuario(cpfusu, cep, emausu, nomusu, num, senusu, rua, telusu, codcid_codcid, cnpjemp_cnpjemp, datnasusu, sexusu) 
select id, (id+10), 'usuario.'||id||'@gmail.com', 'Usuario '||id, 'Num '||id, 'Senha'||id, 'Rua'||id, cast((id+1000) as varchar), (id-11), id, cast('2020-05-20' as date)+id,  
case when mod(id, 2)=0 then 'M' else 'F' end
from generate_series(12, 22) as t(id);

--Paciente
insert into paciente(codpac, grurispac, pespac, sitpac, cpfusu_cpfusu) 
select nextval('seq_paciente'), case when mod(id, 2)=0 then 'S' else 'N' end, (30.5+id), case when mod(id, 2)=0 then 'BEM' else 'ISOLAMENTO' end, id
from generate_series(12, 22) as t(id);

--Teste covid
insert into teste_covid(codtes, covpactes, codpac_codpac) 
select nextval('seq_teste_covid'), case when mod(id, 2)=0 then 'P' else 'N' end, id
from generate_series(1, 11) as t(id);

--Monitoramento Paciente
insert into monitoramento_paciente(codmon, intsin, codpac_codpac, codsin_codsin) 
select nextval('seq_monitoramento_paciente'), case when mod(id, 2)=0 then 'P' else 'M' end, id, id
from generate_series(1, 11) as t(id);

insert into monitoramento_paciente(codmon, intsin, codpac_codpac, codsin_codsin) 
select nextval('seq_monitoramento_paciente'), case when mod(id, 2)=0 then 'C' else 'S' end, id-11, id-11
from generate_series(12, 22) as t(id);

--Paciente Comorbidade
insert into paciente_comorbidade(codpaccom, codpac_codpac, codcom_codcom) 
select nextval('seq_paciente_comorbidade'), id, id
from generate_series(1, 11) as t(id);

--Medico
insert into medico(crmmed, cpfusu_cpfusu) 
select id, id
from generate_series(1, 22) as t(id);

--Vacina
insert into vacina(codvac, dosvac, codpac_codpac, crmmed_crmmed) 
select nextval('seq_vacina'), case when mod(id, 2)=0 then 1 else 2 end , id, cast(id as varchar)
from generate_series(1, 11) as t(id);

--Solicitacao
insert into solicitacao(codsol, dessol, cpfusu_cpfusu) 
select nextval('seq_solicitacao'), 'Desci��o'||id, id
from generate_series(1, 22) as t(id);

