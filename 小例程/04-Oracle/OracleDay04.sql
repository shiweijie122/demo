�Ӳ�ѯ
�Ӳ�ѯ��һ����ѯ��䣬ֻ������Ƕ��������SQL��䵱�еģ�Ϊ���SQL����ṩ����ʹ�á�

�鿴���ʸ���CLARK���ʵ�Ա����
select ename,sal 
from emp_shiweijie 
where sal>(select sal from emp_shiweijie where ename='CLARK') 

�鿴��BLAKEְͬλ��Ա����
select ename,job 
from emp_shiweijie 
where ename<>'BLAKE' and job=(select job from emp_shiweijie where ename='BLAKE') 

�鿴���ʸ��ڹ�˾ƽ�����ʵ�Ա����
select ename,sal from emp_shiweijie where sal>(select AVG(sal) from emp_shiweijie)

�鿴��˾��߹���Ա������Ϣ��
select ename,sal,job,deptno
from emp_shiweijie
where sal=(select max(sal) from emp_shiweijie )

DDL,DML��Ҳ����ʹ���Ӳ�ѯ
DDL��ʹ���Ӳ�ѯ�����Խ��Ӳ�ѯ�Ľ��������һ�ű���ٴ�������
create table employee_shiweijie
as
select e.empno,e.ename,e.job,e.sal,d.deptno,d.dname,d.loc
from emp_shiweijie e full outer join dept_shiweijie d
on e.deptno=d.deptno

DML��ʹ���Ӳ�ѯ
��SMITH���ڲ�������Ա�������ϸ�10%
update emp_shiweijie
set sal=sal*1.1
where deptno=(select deptno from emp_shiweijie where ename='SMITH')

�Ӳ�ѯ���ݲ�ѯ�������Ϊ��
���е��У����е��У����ж����Ӳ�ѯ
���е��е��Ӳ�ѯ�����ڹ��������У�
�������Ӳ�ѯͨ������һ�ű�ʹ�á�

���ڶ��е����Ӳ�ѯ���ڹ���������
��Ϊ�ж���Ҫ���in,any,allȥʹ��

�鿴��ְλ��SALESMANͬ���ŵ�����ְλԱ����
select ename,job,deptno
from emp_shiweijie
where deptno in(select deptno from emp_shiweijie where job='SALESMAN') and job<>'SALESMAN'

�鿴��ְλ��CKERK��SALESMAN���ʶ��ߵ�Ա����
select ename,job,deptno
from emp_shiweijie
where sal>all(select sal from emp_shiweijie where job in('CLERK','SALESMAN'))

exists�ؼ���
exists������Ӳ�ѯ��ֻҪ�Ӳ�ѯ���Բ�ѯ������һ����¼��exists��Ϊ�档
not exists �����෴�ж�

�鿴��Ա���Ĳ��ţ�
select deptno,dname 
from dept_shiweijie d
where exists(select * from emp_shiweijie e where d.deptno=e.deptno)

�鿴˭���쵼��
select m.empno,m.ename,m.job
from emp_shiweijie m
where exists(select * from emp_shiweijie e where e.mgr=m.empno)

��ѯ�г����нˮ���ڲ���30�����нˮ�Ĳ�����Ϣ��
select min(sal),deptno
from emp_shiweijie
group by deptno
having min(sal)>(select min(sal) from emp_shiweijie where deptno=30)

�鿴�����Լ����ڲ���ƽ�����ʵ�Ա����
select ename,sal,e.deptno,avg_sal
from emp_shiweijie e,(select avg(sal) avg_sal,deptno from emp_shiweijie group by deptno) t
where e.deptno=t.deptno and sal>avg_sal

select e.ename,e.sal,(select d.deptno from dept_shiweijie d where d.deptno=e.deptno) deptno
from emp_shiweijie e


��ҳ��ѯ
��ҳ��ѯ���Ƿֶβ�ѯ���ݣ���һ����ѯ�����Բ�ѯ����������ʱ��ͨ����Ҫ�÷�ҳ��ʽ���в�ѯ��
��Ϊ��������ᵼ��ϵͳ��Ӧ�ٶȱ�������Դ���Ĵ��Ҵ󲿷������Ҳ����Ҫ��ô���������ݡ�
��ҳ��ѯ��ͬ�����ݿⶼ���ṩʵ�֣��������ڱ�׼SQL��û���﷨�涨�����з�ҳ����Ƿ��ԡ�

Oracle��ʹ��rownum��Ϊ��ҳ�Ļ���
rownum��һ��α�У������������κα��У�����ÿ�ű����Բ�ѯ���ֶΣ������ֶε�ֵ�ǰ����ѯ�Ĺ����ж�̬���ɵģ�
����ÿ�����Դӱ��в�ѯ��һ����¼����ôrownum�ֶξͻ�Ϊ���м�¼���кţ���1��ʼ���е���

��ѯ��6��10�еļ�¼
select *
from (select rownum rn,empno,ename,job from emp_shiweijie)
where rn between 6 and 10

�鿴����������6-10
select *
from(select rownum rn,e.* from (select empno,ename,job,sal from emp_shiweijie order by sal desc) e where rownum<=10 )
where rn>=6

��Χ��ʽ��
pageSize:ÿҳ��ʾ����Ŀ��
page��ҳ��

start=(page-1)*pageSize+1
end=pageSize*page

����ְͬλ��Ա���ֱ��ǹ��ʣ�
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

ͳ����������MANAGER,ANALYST����һ�飬����ְλԱ��������һ�飬�ֱ�ͳ��������
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
              
decode�ڷ����ѯ�е�Ӧ��
select deptno,dname,loc
from dept_shiweijie
order by decode(dname,'OPERATIONS',1,'ACCOUNTING',2,'SALES',3)

������
���������ԶԽ��������ָ���ֶη��飬Ȼ�����ڰ���ָ���ֶ�����
��Ϊÿ���ÿ����¼���кš�

row_number():��������������Ψһ������
�鿴ÿ�����ŵĹ���������
select ename,sal,deptno,
       row_number() over(
       partition by deptno
       order by sal desc
       ) rank
from emp_shiweijie 

rank():�������ڲ�����Ҳ��Ψһ������
select ename,sal,deptno,
       rank() over(
       partition by deptno
       order by sal desc
       ) rank
from emp_shiweijie

dense_rank:����������������Ψһ������
select ename,sal,deptno,
       dense_rank() over(
       partition by deptno
       order by sal desc
       ) rank
from emp_shiweijie


���ϲ���

union���������Զ�ȥ���ϲ�����ظ���¼
select ename,job,sal from emp_shiweijie where job='MANAGER'
union
select ename,job,sal from emp_shiweijie where sal>2500;

union all��������������е������У������ظ�����
select ename,job,sal from emp_shiweijie where job='MANAGER'
union all
select ename,job,sal from emp_shiweijie where sal>2500

intersect:�����������������Ľ�����ֻ��ͬʱ����������������е����ݣ��ű���ʾ���.ʹ��intersect��������Ľ�������Ե�һ�е��������������С�
select ename,job,sal from emp_shiweijie where job='MANAGER'
intersect
select ename,job,sal from emp_shiweijie where sal>2500

minus������ȡ����������Ĳ��ֻ���ڵ�һ��������д��ڣ��ڵڶ���������в����ڵ����ݣ����ܹ�����ʾ������Ҳ���ǽ����һ��ȥ��������Ľ��
select ename,job,sal from emp_shiweijie where job='MANAGER'
minus
select ename,job,sal from emp_shiweijie where sal>2500


����һǧ������
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

�߼����麯����
1��rollup()
group by rollup(a,b,c)
��ͬ��
group by a,b,c
union all
group by a,b
union all
group by a
union all
ȫ��

select year_id,month_id,day_id,sum(sales_value)
from sales_shiweijie
group by
  rollup(year_id,month_id,day_id)
order by year_id,month_id,day_id

2:cube()
ÿ����������Ϸֱ����һ�η��飬Ȼ������
select year_id,month_id,day_id,sum(sales_value)
from sales_shiweijie
group by
  cube(year_id,month_id,day_id)
order by year_id,month_id,day_id

3:grouping sets
ÿ������Ϊһ�ַ��鷽ʽ��Ȼ����Щ����ͳ�ƵĽ������һ���������

�鿴ÿ����ÿ�µĽ������
select year_id,month_id,sum(sales_value)
from sales_shiweijie
group by 
   grouping sets((year_id,month_id),(year_id))
order by year_id,month_id


