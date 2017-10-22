
SELECT * FROM DEPT_SHIWEIJIE;
SELECT * FROM EMP_SHIWEIJIE

1.查看工资高于2000的员工
SELECT * FROM emp_shiweijie WHERE sal>2000

2.查看不是“clerk”职位的员工
SELECT * FROM emp_shiweijie WHERE job!='CLERK'

3.查看工资在1000-2500之间的员工
SELECT * FROM emp_shiweijie WHERE sal BETWEEN 1000 AND 2500

4.查看名字是以K结尾的员工
SELECT * FROM emp_shiweijie WHERE ename LIKE '%K'

5.查看20，30部门的员工
SELECT * FROM emp_shiweijie WHERE deptno IN(20,30)

6.查看奖金为null的员工
SELECT * FROM emp_shiweijie WHERE COMM IS NULL

7.查看年薪高于20000的员工
SELECT * FROM emp_shiweijie WHERE sal*12>20000

8.查看公司共有多少种职位
SELECT COUNT(JOB) FROM emp_shiweijie 

9.按部门号从小到大排序查看员工
SELECT * FROM emp_shiweijie ORDER BY deptno ASC

10.查看每个部门的最高，最低，平均，总和的工资
SELECT MAX(sal),MIN(sal),AVG(sal),SUM(sal) FROM emp_shiweijie GROUP BY deptno

11.查看平均工资高于2000的部门的最低薪水
SELECT MIN(sal) FROM emp_shiweijie GROUP BY deptno HAVING AVG(sal)>2000

12.查看所有员工及所在部门信息，若该员工没有部门，则部门信息以null显示
SELECT ename,deptno FROM emp_shiweijie 

13.查看在NEW YORK工作的员工
SELECT e.ename,d.loc FROM emp_shiweijie e JOIN dept_shiweijie d ON e.deptno=d.deptno AND loc='BEW YORK'

14.查看ALLEN的上司是谁
SELECT m.ename manager FROM emp_shiweijie e JOIN emp_shiweijie m ON e.mgr=m.empno AND e.ename='ALLEN'

15.查看SMITH上司在哪个城市工作
SELECT d.loc FROM emp_shiweijie e,emp_shiweijie m,dept_shiweijie d WHERE e.deptno=d.deptno AND e.mgr=m.empno AND e.ename='SMITH'

16.查看平均工资高于2000的那些部门名字以及所在城市
SELECT e.deptno,d.loc FROM (SELECT ee.deptno FROM emp_shiweijie ee GROUP BY ee.deptno HAVING AVG(sal)>2000) e,dept_shiweijie d WHERE  e.deptno=d.deptno  

17查看在NEWYORK工作的员工有多少人
SELECT COUNT(e.ename) FROM emp_shiweijie e,dept_shiweijie d WHERE e.deptno=d.deptno AND loc='BEW YORK'

18.查看在DALLAS工作的员工的平均工资是多少
SELECT AVG(sal) FROM emp_shiweijie e,dept_shiweijie d WHERE e.deptno=d.deptno AND loc='DALLAS'