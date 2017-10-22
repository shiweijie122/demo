select * from emp_shiweijie

1:�鿴��CLARK��ְͬλ��Ա��
select ename,job from emp_shiweijie where job=(select job from emp_shiweijie where ename='CLARK')

2:�鿴���ڹ�˾ƽ�����ʵ�Ա��
select ename,sal from emp_shiweijie where sal<(select avg(sal) from emp_shiweijie)

3:�鿴��ALLENͬ���ŵ�Ա��
select ename,deptno from emp_shiweijie where deptno=(select deptno from emp_shiweijie where ename='ALLEN')

4:�鿴ƽ�����ʵ���20�Ų���ƽ�����ʵĲ���ƽ������
select deptno,avg(sal) from emp_shiweijie group by deptno having avg(sal)<(select avg(sal) from emp_shiweijie where deptno=20)

5:�鿴�����Լ����ڲ���ƽ�����ʵ�Ա��
select e.ename,e.sal,e.deptno,a.avg_sal 
from emp_shiweijie e join (select deptno,round(avg(sal),0) avg_sal from emp_shiweijie group by deptno) a 
on e.deptno=a.deptno 
where sal<a.avg_sal

6:�鿴��˾���������ĵ�1-5��
select * from (select rownum rn,e.* from (select * from emp_shiweijie order by sal desc) e where rownum<=5) where rn>=1

7:�鿴CLERKְλ������������ְλ��������������?
select count(*),
       decode(job,
              'CLERK','CLERK',
              'OTHER')
from emp_shiweijie
group by decode(job,
               'CLERK','CLERK',
               'OTHER')
      

8:�鿴ÿ��ְλ�Ĺ�������
select ename,job,sal,deptno,
       row_number() over(
       partition by job
       order by sal desc
       ) rank
from emp_shiweijie       

9:�鿴ÿ��ְλ�Ĺ���������������һ�£�����һ��
select ename,job,sal,deptno,
       rank() over(
       partition by job
       order by sal desc
       ) rank
from emp_shiweijie       

10:�鿴ÿ��ְλ�Ĺ���������������һ�£�����һ�£��������Ρ�
select ename,job,sal,deptno,
       dense_rank() over(
       partition by job
       order by sal desc
       ) rank
from emp_shiweijie       

11:�ֱ�鿴:ͬ����ְͬλ��ְͬλ���Լ�����Ա���Ĺ����ܺ�
select deptno,job,sum(sal)
from emp_shiweijie
group by
   rollup(deptno,job)
order by deptno,job   

12:�ֱ�鿴:ͬ����ְͬλ��ְͬλ��ͬ�����Լ�����Ա���Ĺ����ܺ�
select deptno,job,sum(sal)
from emp_shiweijie
group by
  cube(deptno,job)
order by deptno,job  

13:�ֱ�鿴ͬ����ְͬλ��ְͬλ��Ա���Ĺ����ܺ�
select deptno,job,sum(sal)
from emp_shiweijie
group by
  grouping sets((deptno,job),job)
order by deptno,job

14:�鿴��˾��߹��ʵ�Ա���������Լ����ڲ�������
select e.ename,sal,d.dname
from emp_shiweijie e join dept_shiweijie d
on e.deptno=d.deptno
and sal=(select max(sal) from emp_shiweijie)

15:�鿴ÿ�����ŵ���߹��ʵ�Ա������
select e.ename
from emp_shiweijie e,(select deptno,max(sal) max_sal from emp_shiweijie group by deptno) t
where e.deptno=t.deptno and e.sal=t.max_sal


16:�鿴��������Ա����Ϣ
select m.ename
from emp_shiweijie m 
where exists(select * from emp_shiweijie e where e.mgr=m.empno)

