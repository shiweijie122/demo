��ͼ
��ͼҲ�����ݿ����֮һ
��ͼ�ֳ���������������ã�������һ����ʵ���ڵı���ͼ����Ӧ����һ����ѯ���Ľ������

create view v_emp_shiweijie_10
as
select empno,ename,job,sal,deptno
from emp_shiweijie
where deptno=10

��ͼ��Ӧ���Ӳ�ѯ��select�Ӿ���ָ�����ֶ�������к������߱��ʽ��
��ô����Ϊ����ֶ���ӱ�����
create or replace view v_emp_shiweijie_10
as
select empno id,ename name,job,sal,deptno
from emp_shiweijie
where deptno=10

��ͼ���ݶ�Ӧ���Ӳ�ѯ��Ϊ��
����ͼ�븴����ͼ
����ͼ����Ӧ���Ӳ�ѯ���������������ʽ�����飬ȥ�أ�������ѯ�Ȳ���

������ͼ����Ӧ���Ӳ�ѯ�а������������ʽ�����飬ȥ�أ�������ѯ�Ȳ���
���к��й�����ѯ����ͼҲ��Ϊ��������ͼ

����ͼ���Խ���DML���������Ǹ�����ͼ���������DML������

����ͼ����DML�������Ƕ���ͼ������Դ�Ļ�������еĲ���
insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,10)

select * from v_emp_shiweijie_10;
select * from emp_shiweijie

update v_emp_shiweijie_10
set sal=4000
where id=1001

delete from v_emp_shiweijie_10
where id=1001

����ͼ���в�����DML����������Ⱦ���������ݡ�����ͨ����ͼ�Ի����������ļ�¼��ͼ���䲢���ɼ������ɿأ�
insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,20)

update v_emp_shiweijie_10
set deptno=20

delete ������������Ⱦ���
delete from v_emp_shiweijie_10
where deptno=20

Ϊ��ͼ��Ӽ��ѡ����Ա���Ի��������Ⱦ��
���ѡ��Ҫ�����ͼ����DML��������ͼ����Ըü�¼�ɼ�
create or replace view v_emp_shiweijie_10
as
select empno id,ename name,job,sal,deptno
from emp_shiweijie
where deptno=10
with check option

insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,20)

update v_emp_shiweijie_10 set deptno=20

Ϊ��ͼ���ֻ��ѡ���ô��ͼ���������DML����
create or replace view v_emp_shiweijie_10
as
select empno id,ename name,job,sal,deptno
from emp_shiweijie
where deptno=10
with read only

insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,20)


���������ֵ䣺
select object_name,object_type 
from user_objects
where object_name like '%SHIWEIJIE'

select view_name,text from user_views where view_name like '%SHIWEIJIE'

select table_name from user_tables where table_name like '%SHIWEIJIE'


������ͼ������һ�����Ź�����Ϣ����ͼ
���ű�ţ����ƣ����ڵأ���ߣ���ͣ�ƽ���������ܺ�
create or replace view v_emp_shiweijie_all
as
select d.deptno,d.dname,d.loc,max(e.sal) max_sal,min(e.sal) min_sal,avg(e.sal) avg_sal,sum(e.sal) sum_sal
from emp_shiweijie e join dept_shiweijie d on e.deptno=d.deptno
group by d.deptno,d.dname,d.loc

select * from v_emp_shiweijie_all

�鿴˭�����Լ����ڲ��ŵ�ƽ�����ʣ�
select e.ename,e.sal,e.deptno
from emp_shiweijie e join v_emp_shiweijie_all ve on e.deptno=ve.deptno
and e.sal>avg_sal

ɾ����ͼ��
drop view v_emp_shiweijie_all
ɾ����ͼ��������Ӱ���������




����
����Ҳ�����ݿ����֮һ
����������һϵ�����֣�һ������Ϊĳ�ű�������ֶ��ṩֵ
create sequence seq_emp_shiweijie_id
start with 1
increment by 1

����֧������α�У����ڻ�ȡ���е�����
nextval:��ȡ���е���һ�����֣����ø�α�лᵼ�����з����������������ǲ��ܻ��˵ġ�

currval:��ȡ���е�ǰ����(���ͨ��nextval���ɵ����֣���
        ��Ҫע�⣬��һ�δ�������������Ҫִ��һ��nextval��ſ���ʹ��currval

select seq_emp_shiweijie_id.nextval from dual

select seq_emp_shiweijie_id.currval from dual

insert into emp_shiweijie (empno,ename,job,sal,deptno) values (seq_emp_shiweijie_id.nextval,'JACK','CLERK',3000,10)
select * from emp_shiweijie

ɾ������
drop sequence seq_emp_shiweijie_id


uuid:��һ����������
32λ���ظ�����
select sys_guid() from dual


����
���������ݿ����֮һ
������Ϊ����߲�ѯЧ�ʵ�һ�ֻ���
���������ڹ��������и����ֶΣ����������е��ֶΣ�ȥ�ص��ֶΣ��Ϳ���Ϊ�����һ����������߲�ѯ��Ч�ʡ�
������ʵ�ʴ�����ʹ�������ݿ�������ɵ�

��emp_shiweijie���ename���Ͻ�������
create index idx_emp_shiweijie_ename on emp_shiweijie(ename)
select * from emp_shiweijie

��ename����������where�У������������ȥ��ʱ�Ϳ���Ϊ�����������������
ʹ�õ�ʱ�����ݿ�ͻ�����Ӧ�ã�������select������������
select * from emp_shiweijie where ename='SMITH'
����Ĳ�ѯ�ͻ�Ӧ��������

ģ����ѯlike�ǲ���Ӧ��������

������������
create index idx_emp_shiweijie_job_sal on emp_shiweijie(job,sal)

select * from emp_shiweijie order by job,sal

�������ں���������
create index emp_shiweijie_ename_upper_idx on emp_shiweijie(upper(ename))

select * from emp_shiweijie where upper(ename)='KING'

�޸ĺ�ɾ������
alter index idx_emp_shiweijie_ename rebuild

drop index idx_emp_shiweijie_ename 

Ϊ������ѯЧ�ʣ�������ʹ��������ԭ��
Ϊ����������WHERE�Ӿ��е��д�������
Ϊ����������ORDER BY��DISTINCT������ֶν�������������������Ǹ����������������ֶ�˳��Ҫ����Щ�ؼ��ֺ�����ֶ�˳��һ��
Ϊ������Ϊ����������������ϴ�������
��Ҫ�ھ�����DML�����ı��Ͻ�������
��Ҫ��С���Ͻ�������
���Ʊ��ϵ�������Ŀ������������Խ��Խ��
ɾ�����ٱ�ʹ�õġ������������


Լ��
�ǿ�Լ��
��������ӷǿ�Լ��
create table employees_shiweijie(
eid number(6),
name varchar2(30) not null,
salary number(7,2),
hiredate date constraint emp_shiweijie_hiredate_nn not null
)

�޸ı�ʱ��ӷǿ�Լ��
alter table employees_shiweijie modify (eid number(6) not null)

ȡ���ǿ�Լ��
alter table employees_shiweijie modify (eid number(6) null)

desc employees_shiweijie


Ψһ��Լ��
Ψһ��Լ��Ҫ����ֶε�ֵÿ����¼���������ظ���null����
create table employees1_shiweijie(
eid number(6) unique,
name varchar2(30),
email varchar2(50),
salary number(7,2),
hiredate date,
constraint emp_shiweijie_email_uk unique(email)
);

insert into employees1_shiweijie (eid,name,email) values (1,'JACK','JACK@163.COM')
insert into employees1_shiweijie (eid,name,email) values (NULL,'JACK',NULL)

���Ψһ��Լ��
alter table employees1_shiweijie add constraint emp_shiweijie_name_uk unique(name); 


����Լ��
create table emp2_shiweijie(
eid number(6) primary key,
name varchar2(30),
email varchar2(50),
salary number(7,2),
hiredate date
)

insert into employees2_shiweijie (eid,name,salary) values (1,'JACK',)

���Լ��
alter table employees2_shiweijie add constraint emp2_shiweijie_salary_check check(salary>2000)

desc emp2_shiweijie
select * from employees1_shiweijie
delete employees1_shiweijie  

