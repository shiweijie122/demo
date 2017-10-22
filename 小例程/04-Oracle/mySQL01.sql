CREATE TABLE emp_shiweijie(
  empno INT(4),
  ename VARCHAR(10),
  job VARCHAR(9),
  mgr INT(4),
  hiredate DATE,
  sal DOUBLE(7,2),
  comm DOUBLE(7,2),
  deptno INT(2)
)

SELECT * FROM emp_shiweijie

INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,deptno) VALUES (7369,'SMITH','CLERK',7902,DATE('1980-12-17'),800,20);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7499,'ALLEN','SALESMAN',7698,DATE('1981-2-20'),1600.00,300.00,30);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7521,'WARD','SALESMAN',7698,DATE('1981-2-22'),1250.00,500.00,30);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,deptno) VALUES (7566,'JONES','MANAGER',7839,DATE('1981-4-2'),2976.00,20);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7654,'MARTIN','SALESMAN',7698,DATE('1981-9-28'),1250.00,1400.00,30);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7698,'BLAKE','MANAGER',7839,DATE('1981-5-1'),2850.00,NULL,30);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7782,'CLARK','MANAGER',7839,DATE('1981-6-9'),2450.00,NULL,10);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7788,'SCOTT','ANALYST',7566,DATE('1987-4-19'),3000.00,NULL,20);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7839,'KING','PRESIDENT',NULL,DATE('1981-11-17'),5000.00,NULL,10);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7844,'TURNER','SALESMAN',7698,DATE('1981-9-8'),1500.00,0.00,30);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7876,'ADAMS','CLERK',7788,DATE('1987-5-23'),1100.00,NULL,20);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7900,'JAMES','CLERK',7788,DATE('1981-12-3'),950.00,NULL,30);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7902,'FORD','ANALYST',7566,DATE('1981-2-20'),3000.00,NULL,20);
INSERT INTO emp_shiweijie (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (7934,'MILLER','CLERK',7782,DATE('1982-1-23'),1300.00,NULL,10)

COMMIT;

CREATE TABLE dept_shiweijie(
  deptno INT(2),
  dname VARCHAR(14),
  loc VARCHAR(13)
)

INSERT INTO dept_shiweijie (deptno,dname,loc) VALUES (10,'ACCOUNTING','BEW YORK');
INSERT INTO dept_shiweijie (deptno,dname,loc) VALUES (20,'RESEARCH','DALLAS');
INSERT INTO dept_shiweijie (deptno,dname,loc) VALUES (30,'SALES','CHICAGO');
INSERT INTO dept_shiweijie (deptno,dname,loc) VALUES (40,'OPERATIONS','BOSTON')
COMMIT;

SELECT * FROM DEPT_SHIWEIJIE;
SELECT * FROM emp_shiweijie;

INSERT INTO emp_shiweijie (ename,job,sal) VALUES ('shiweijie','coder',8000.0);


DELETE FROM emp_shiweijie WHERE ename='shiweijie'

