select * from emp_shiweijie

1:查看与CLARK相同职位的员工
select ename,job from emp_shiweijie where job=(select job from emp_shiweijie where ename='CLARK')

2:查看低于公司平均工资的员工
select ename,sal from emp_shiweijie where sal<(select avg(sal) from emp_shiweijie)

3:查看与ALLEN同部门的员工
select ename,deptno from emp_shiweijie where deptno=(select deptno from emp_shiweijie where ename='ALLEN')

4:查看平均工资低于20号部门平均工资的部门平均工资
select deptno,avg(sal) from emp_shiweijie group by deptno having avg(sal)<(select avg(sal) from emp_shiweijie where deptno=20)

5:查看低于自己所在部门平均工资的员工
select e.ename,e.sal,e.deptno,a.avg_sal 
from emp_shiweijie e join (select deptno,round(avg(sal),0) avg_sal from emp_shiweijie group by deptno) a 
on e.deptno=a.deptno 
where sal<a.avg_sal

6:查看公司工资排名的第1-5名
select * from (select rownum rn,e.* from (select * from emp_shiweijie order by sal desc) e where rownum<=5) where rn>=1

7:查看CLERK职位的人数和其他职位的总人数各多少?
select count(*),
       decode(job,
              'CLERK','CLERK',
              'OTHER')
from emp_shiweijie
group by decode(job,
               'CLERK','CLERK',
               'OTHER')
      

8:查看每个职位的工资排名
select ename,job,sal,deptno,
       row_number() over(
       partition by job
       order by sal desc
       ) rank
from emp_shiweijie       

9:查看每个职位的工资排名，若工资一致，排名一致
select ename,job,sal,deptno,
       rank() over(
       partition by job
       order by sal desc
       ) rank
from emp_shiweijie       

10:查看每个职位的工资排名，若工资一致，排名一致，不跳名次。
select ename,job,sal,deptno,
       dense_rank() over(
       partition by job
       order by sal desc
       ) rank
from emp_shiweijie       

11:分别查看:同部门同职位，同职位，以及所有员工的工资总和
select deptno,job,sum(sal)
from emp_shiweijie
group by
   rollup(deptno,job)
order by deptno,job   

12:分别查看:同部门同职位，同职位，同部门以及所有员工的工资总和
select deptno,job,sum(sal)
from emp_shiweijie
group by
  cube(deptno,job)
order by deptno,job  

13:分别查看同部门同职位和同职位的员工的工资总和
select deptno,job,sum(sal)
from emp_shiweijie
group by
  grouping sets((deptno,job),job)
order by deptno,job

14:查看公司最高工资的员工的名字以及所在部门名称
select e.ename,sal,d.dname
from emp_shiweijie e join dept_shiweijie d
on e.deptno=d.deptno
and sal=(select max(sal) from emp_shiweijie)

15:查看每个部门的最高工资的员工名字
select e.ename
from emp_shiweijie e,(select deptno,max(sal) max_sal from emp_shiweijie group by deptno) t
where e.deptno=t.deptno and e.sal=t.max_sal


16:查看有下属的员工信息
select m.ename
from emp_shiweijie m 
where exists(select * from emp_shiweijie e where e.mgr=m.empno)

