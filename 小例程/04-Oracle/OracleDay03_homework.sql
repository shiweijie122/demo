
SELECT * FROM DEPT_SHIWEIJIE;
SELECT * FROM EMP_SHIWEIJIE

1.�鿴���ʸ���2000��Ա��
SELECT * FROM emp_shiweijie WHERE sal>2000

2.�鿴���ǡ�clerk��ְλ��Ա��
SELECT * FROM emp_shiweijie WHERE job!='CLERK'

3.�鿴������1000-2500֮���Ա��
SELECT * FROM emp_shiweijie WHERE sal BETWEEN 1000 AND 2500

4.�鿴��������K��β��Ա��
SELECT * FROM emp_shiweijie WHERE ename LIKE '%K'

5.�鿴20��30���ŵ�Ա��
SELECT * FROM emp_shiweijie WHERE deptno IN(20,30)

6.�鿴����Ϊnull��Ա��
SELECT * FROM emp_shiweijie WHERE COMM IS NULL

7.�鿴��н����20000��Ա��
SELECT * FROM emp_shiweijie WHERE sal*12>20000

8.�鿴��˾���ж�����ְλ
SELECT COUNT(JOB) FROM emp_shiweijie 

9.�����źŴ�С��������鿴Ա��
SELECT * FROM emp_shiweijie ORDER BY deptno ASC

10.�鿴ÿ�����ŵ���ߣ���ͣ�ƽ�����ܺ͵Ĺ���
SELECT MAX(sal),MIN(sal),AVG(sal),SUM(sal) FROM emp_shiweijie GROUP BY deptno

11.�鿴ƽ�����ʸ���2000�Ĳ��ŵ����нˮ
SELECT MIN(sal) FROM emp_shiweijie GROUP BY deptno HAVING AVG(sal)>2000

12.�鿴����Ա�������ڲ�����Ϣ������Ա��û�в��ţ�������Ϣ��null��ʾ
SELECT ename,deptno FROM emp_shiweijie 

13.�鿴��NEW YORK������Ա��
SELECT e.ename,d.loc FROM emp_shiweijie e JOIN dept_shiweijie d ON e.deptno=d.deptno AND loc='BEW YORK'

14.�鿴ALLEN����˾��˭
SELECT m.ename manager FROM emp_shiweijie e JOIN emp_shiweijie m ON e.mgr=m.empno AND e.ename='ALLEN'

15.�鿴SMITH��˾���ĸ����й���
SELECT d.loc FROM emp_shiweijie e,emp_shiweijie m,dept_shiweijie d WHERE e.deptno=d.deptno AND e.mgr=m.empno AND e.ename='SMITH'

16.�鿴ƽ�����ʸ���2000����Щ���������Լ����ڳ���
SELECT e.deptno,d.loc FROM (SELECT ee.deptno FROM emp_shiweijie ee GROUP BY ee.deptno HAVING AVG(sal)>2000) e,dept_shiweijie d WHERE  e.deptno=d.deptno  

17�鿴��NEWYORK������Ա���ж�����
SELECT COUNT(e.ename) FROM emp_shiweijie e,dept_shiweijie d WHERE e.deptno=d.deptno AND loc='BEW YORK'

18.�鿴��DALLAS������Ա����ƽ�������Ƕ���
SELECT AVG(sal) FROM emp_shiweijie e,dept_shiweijie d WHERE e.deptno=d.deptno AND loc='DALLAS'