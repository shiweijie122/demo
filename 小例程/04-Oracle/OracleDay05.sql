视图
视图也是数据库对象之一
视图又称虚表，即：当做表用，但并非一张真实存在的表。视图仅对应的是一个查询语句的结果集。

create view v_emp_shiweijie_10
as
select empno,ename,job,sal,deptno
from emp_shiweijie
where deptno=10

视图对应的子查询中select子句里指定的字段如果含有函数或者表达式，
那么必须为这个字段添加别名。
create or replace view v_emp_shiweijie_10
as
select empno id,ename name,job,sal,deptno
from emp_shiweijie
where deptno=10

视图根据对应的子查询分为：
简单视图与复杂视图
简单视图：对应的子查询不包含函数，表达式，分组，去重，关联查询等操作

复杂视图：对应的子查询中包含函数，表达式，分组，去重，关联查询等操作
其中含有关联查询的视图也称为：连接视图

简单视图可以进行DML操作，但是复杂视图不允许进行DML操作。

对视图进行DML操作就是对视图数据来源的基础表进行的操作
insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,10)

select * from v_emp_shiweijie_10;
select * from emp_shiweijie

update v_emp_shiweijie_10
set sal=4000
where id=1001

delete from v_emp_shiweijie_10
where id=1001

对视图进行不当的DML操作，会污染基础表数据。即：通过视图对基础表操作后的记录视图对其并不可见（不可控）
insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,20)

update v_emp_shiweijie_10
set deptno=20

delete 操作不存在污染情况
delete from v_emp_shiweijie_10
where deptno=20

为视图添加检查选项，可以避免对基表产生污染。
检查选项要求对视图进行DML操作后视图必须对该记录可见
create or replace view v_emp_shiweijie_10
as
select empno id,ename name,job,sal,deptno
from emp_shiweijie
where deptno=10
with check option

insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,20)

update v_emp_shiweijie_10 set deptno=20

为视图添加只读选项，那么视图不允许进行DML操作
create or replace view v_emp_shiweijie_10
as
select empno id,ename name,job,sal,deptno
from emp_shiweijie
where deptno=10
with read only

insert into v_emp_shiweijie_10 (id,name,job,sal,deptno) values (1001,'JACK','CLERK',3000,20)


常用数据字典：
select object_name,object_type 
from user_objects
where object_name like '%SHIWEIJIE'

select view_name,text from user_views where view_name like '%SHIWEIJIE'

select table_name from user_tables where table_name like '%SHIWEIJIE'


复杂视图：创建一个部门工资信息的视图
部门编号，名称，所在地，最高，最低，平均，工资总和
create or replace view v_emp_shiweijie_all
as
select d.deptno,d.dname,d.loc,max(e.sal) max_sal,min(e.sal) min_sal,avg(e.sal) avg_sal,sum(e.sal) sum_sal
from emp_shiweijie e join dept_shiweijie d on e.deptno=d.deptno
group by d.deptno,d.dname,d.loc

select * from v_emp_shiweijie_all

查看谁高于自己所在部门的平均工资？
select e.ename,e.sal,e.deptno
from emp_shiweijie e join v_emp_shiweijie_all ve on e.deptno=ve.deptno
and e.sal>avg_sal

删除视图：
drop view v_emp_shiweijie_all
删除视图本身并不会影响基表数据




序列
序列也是数据库对象之一
作用是生成一系列数字，一般用作为某张表的主键字段提供值
create sequence seq_emp_shiweijie_id
start with 1
increment by 1

序列支持两个伪列，用于获取序列的数字
nextval:获取序列的下一个数字，调用该伪列会导致序列发生步进，且序列是不能回退的。

currval:获取序列当前数字(最后通过nextval生成的数字）。
        需要注意，新一次创建的序列至少要执行一次nextval后才可以使用currval

select seq_emp_shiweijie_id.nextval from dual

select seq_emp_shiweijie_id.currval from dual

insert into emp_shiweijie (empno,ename,job,sal,deptno) values (seq_emp_shiweijie_id.nextval,'JACK','CLERK',3000,10)
select * from emp_shiweijie

删除序列
drop sequence seq_emp_shiweijie_id


uuid:另一种主键机制
32位不重复主键
select sys_guid() from dual


索引
索引是数据库对象之一
索引是为了提高查询效率的一种机制
经常出现在过滤条件中个的字段，或者排序中的字段，去重的字段，就可以为其添加一个索引以提高查询的效率。
索引的实际创建和使用是数据库自行完成的

在emp_shiweijie表的ename列上建立索引
create index idx_emp_shiweijie_ename on emp_shiweijie(ename)
select * from emp_shiweijie

当ename经常出现在where中，或者排序或者去重时就可以为其添加这样的索引，
使用的时候数据库就会自行应用，无需再select中体现索引：
select * from emp_shiweijie where ename='SMITH'
上面的查询就会应用索引了

模糊查询like是不会应用索引的

创建复合索引
create index idx_emp_shiweijie_job_sal on emp_shiweijie(job,sal)

select * from emp_shiweijie order by job,sal

创建基于函数的索引
create index emp_shiweijie_ename_upper_idx on emp_shiweijie(upper(ename))

select * from emp_shiweijie where upper(ename)='KING'

修改和删除索引
alter index idx_emp_shiweijie_ename rebuild

drop index idx_emp_shiweijie_ename 

为提升查询效率，创建和使用索引的原则：
为经常出现在WHERE子句中的列创建索引
为经常出现在ORDER BY、DISTINCT后面的字段建立索引。如果建立的是复合索引，索引的字段顺序要和这些关键字后面的字段顺序一致
为经常作为表的连接条件的列上创建索引
不要在经常做DML操作的表上建立索引
不要在小表上建立索引
限制表上的索引数目，索引并不是越多越好
删除很少被使用的、不合理的索引


约束
非空约束
建表是添加非空约束
create table employees_shiweijie(
eid number(6),
name varchar2(30) not null,
salary number(7,2),
hiredate date constraint emp_shiweijie_hiredate_nn not null
)

修改表时添加非空约束
alter table employees_shiweijie modify (eid number(6) not null)

取消非空约束
alter table employees_shiweijie modify (eid number(6) null)

desc employees_shiweijie


唯一性约束
唯一性约束要求该字段的值每条记录都不允许重复，null除外
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

添加唯一性约束
alter table employees1_shiweijie add constraint emp_shiweijie_name_uk unique(name); 


主键约束
create table emp2_shiweijie(
eid number(6) primary key,
name varchar2(30),
email varchar2(50),
salary number(7,2),
hiredate date
)

insert into employees2_shiweijie (eid,name,salary) values (1,'JACK',)

检查约束
alter table employees2_shiweijie add constraint emp2_shiweijie_salary_check check(salary>2000)

desc emp2_shiweijie
select * from employees1_shiweijie
delete employees1_shiweijie  

