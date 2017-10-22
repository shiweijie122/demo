子查询
子查询是一条查询语句，只是它是嵌套在其它SQL语句当中的，为外层SQL语句提供数据使用。

查看工资高于CLARK工资的员工？
select ename,sal 
from emp_shiweijie 
where sal>(select sal from emp_shiweijie where ename='CLARK') 

查看和BLAKE同职位的员工？
select ename,job 
from emp_shiweijie 
where ename<>'BLAKE' and job=(select job from emp_shiweijie where ename='BLAKE') 

查看工资高于公司平均工资的员工？
select ename,sal from emp_shiweijie where sal>(select AVG(sal) from emp_shiweijie)

查看公司最高工资员工的信息？
select ename,sal,job,deptno
from emp_shiweijie
where sal=(select max(sal) from emp_shiweijie )

DDL,DML中也可以使用子查询
DDL中使用子查询，可以将子查询的结果集当做一张表快速创建出来
create table employee_shiweijie
as
select e.empno,e.ename,e.job,e.sal,d.deptno,d.dname,d.loc
from emp_shiweijie e full outer join dept_shiweijie d
on e.deptno=d.deptno

DML中使用子查询
将SMITH所在部门所有员工工资上浮10%
update emp_shiweijie
set sal=sal*1.1
where deptno=(select deptno from emp_shiweijie where ename='SMITH')

子查询根据查询结果集分为：
单行单列，多行单列，多行多列子查询
其中单列的子查询常用在过滤条件中，
而多列子查询通常当做一张表使用。

对于多行单列子查询用在过滤条件中
作为判断是要配合in,any,all去使用

查看与职位是SALESMAN同部门的其他职位员工？
select ename,job,deptno
from emp_shiweijie
where deptno in(select deptno from emp_shiweijie where job='SALESMAN') and job<>'SALESMAN'

查看比职位是CKERK和SALESMAN工资都高的员工？
select ename,job,deptno
from emp_shiweijie
where sal>all(select sal from emp_shiweijie where job in('CLERK','SALESMAN'))

exists关键字
exists后面跟子查询，只要子查询可以查询出至少一条记录，exists则为真。
not exists 则是相反判断

查看有员工的部门？
select deptno,dname 
from dept_shiweijie d
where exists(select * from emp_shiweijie e where d.deptno=e.deptno)

查看谁是领导？
select m.empno,m.ename,m.job
from emp_shiweijie m
where exists(select * from emp_shiweijie e where e.mgr=m.empno)

查询列出最低薪水高于部门30的最低薪水的部门信息？
select min(sal),deptno
from emp_shiweijie
group by deptno
having min(sal)>(select min(sal) from emp_shiweijie where deptno=30)

查看高于自己所在部门平均工资的员工？
select ename,sal,e.deptno,avg_sal
from emp_shiweijie e,(select avg(sal) avg_sal,deptno from emp_shiweijie group by deptno) t
where e.deptno=t.deptno and sal>avg_sal

select e.ename,e.sal,(select d.deptno from dept_shiweijie d where d.deptno=e.deptno) deptno
from emp_shiweijie e


分页查询
分页查询就是分段查询数据，当一个查询语句可以查询出大量数据时，通常就要用分页方式进行查询，
因为数据量大会导致系统响应速度变慢，资源消耗大，且大部分情况下也不需要那么大量的数据。
分页查询不同的数据库都有提供实现，但是由于标准SQL中没有语法规定，所有分页语句是方言。

Oracle中使用rownum作为分页的机制
rownum是一个伪列，它不存在于任何表中，但是每张表都可以查询该字段，而该字段的值是伴随查询的过程中动态生成的，
即：每当可以从表中查询出一条记录，那么rownum字段就会为该行记录编行号，从1开始逐行递增

查询第6到10行的记录
select *
from (select rownum rn,empno,ename,job from emp_shiweijie)
where rn between 6 and 10

查看工资排名的6-10
select *
from(select rownum rn,e.* from (select empno,ename,job,sal from emp_shiweijie order by sal desc) e where rownum<=10 )
where rn>=6

范围公式：
pageSize:每页显示的条目数
page：页数

start=(page-1)*pageSize+1
end=pageSize*page

给不同职位的员工分别涨工资？
select ename,job,sal,
       decode(job,
              'MANAGER',sal*1.2,
              'ANALYST',sal*1.1,
              'SALESMAN',sal*1.05,
              sal ) bonus
from emp_shiweijie

select ename,job,sal,
       case job when 'MANAGER' then sal*1.2
                when 'ANALYST' then sal*1.1
                when 'SALESMAN' then sal*1.05
                else sal end
       bonus
from emp_shiweijie       

统计人数，将MANAGER,ANALYST看做一组，其他职位员工看做另一组，分别统计人数？
select count(*),
       decode(job,
              'MANAGER','VIP',
              'ANALYST','VIP',
              'OTHER')
from emp_shiweijie
group by decode(job,
              'MANAGER','VIP',
              'ANALYST','VIP',
              'OTHER')
              
decode在分组查询中的应用
select deptno,dname,loc
from dept_shiweijie
order by decode(dname,'OPERATIONS',1,'ACCOUNTING',2,'SALES',3)

排序函数
排序函数可以对结果集按照指定字段分组，然后组内按照指定字段排序，
并为每组的每条记录编行号。

row_number():生成组内连续且唯一的数字
查看每个部门的工资排名：
select ename,sal,deptno,
       row_number() over(
       partition by deptno
       order by sal desc
       ) rank
from emp_shiweijie 

rank():生成组内不连续也不唯一的数字
select ename,sal,deptno,
       rank() over(
       partition by deptno
       order by sal desc
       ) rank
from emp_shiweijie

dense_rank:生成组内连续但不唯一的数字
select ename,sal,deptno,
       dense_rank() over(
       partition by deptno
       order by sal desc
       ) rank
from emp_shiweijie


集合操作

union操作符会自动去掉合并后的重复记录
select ename,job,sal from emp_shiweijie where job='MANAGER'
union
select ename,job,sal from emp_shiweijie where sal>2500;

union all返回两个结果集中的所有行，包括重复的行
select ename,job,sal from emp_shiweijie where job='MANAGER'
union all
select ename,job,sal from emp_shiweijie where sal>2500

intersect:函数获得两个结果集的交集，只有同时存在于两个结果集中的数据，才被显示输出.使用intersect操作符后的结果集会以第一列的数据作升序排列。
select ename,job,sal from emp_shiweijie where job='MANAGER'
intersect
select ename,job,sal from emp_shiweijie where sal>2500

minus函数获取两个结果集的差集。只有在第一个结果集中存在，在第二个结果集中不存在的数据，才能够被显示出来。也就是结果集一减去结果集二的结果
select ename,job,sal from emp_shiweijie where job='MANAGER'
minus
select ename,job,sal from emp_shiweijie where sal>2500


插入一千条数据
create table sales_shiweijie(
year_id number not null,
month_id number not null,
day_id number not null,
sales_value number(10,2) not null
);
insert into sales_shiweijie
select trunc(dbms_random.value(2010,2012)) as year_id,
       trunc(dbms_random.value(1,13)) as month_id,
       trunc(dbms_random.value(1,32)) as day_id,
       round(dbms_random.value(1,100),2) as sales_value
from dual
connect by level <=1000;

高级分组函数：
1：rollup()
group by rollup(a,b,c)
等同于
group by a,b,c
union all
group by a,b
union all
group by a
union all
全表

select year_id,month_id,day_id,sum(sales_value)
from sales_shiweijie
group by
  rollup(year_id,month_id,day_id)
order by year_id,month_id,day_id

2:cube()
每个参数的组合分别进行一次分组，然后将所有
select year_id,month_id,day_id,sum(sales_value)
from sales_shiweijie
group by
  cube(year_id,month_id,day_id)
order by year_id,month_id,day_id

3:grouping sets
每个参数为一种分组方式，然后将这些分组统计的结果并在一个结果集中

查看每天与每月的结果集中
select year_id,month_id,sum(sales_value)
from sales_shiweijie
group by 
   grouping sets((year_id,month_id),(year_id))
order by year_id,month_id


