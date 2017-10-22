SELECT SYSDATE FROM dual;

SQL语句：结构化查询语句
使用SQL与数据库“沟通”，完成相应的数据库操作。
SQL有一套标准，所有DBMS都支持该标准
SQL语句本身不区分大小写，但应当将关键字与非关键字用大小写区分来增加可读性。
SQL语句分为：DDL，DML，TCL，DQL，DCL
DDL语句：数据定义语句，用来维护数据库对象

CREATE TABLE employee_swj(
  id NUMBER(4),
  name VARCHAR2(20),
  gender CHAR(1),
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)

查看表结构
DESC table_name
DESC employee_swj

删除表：
DROP TABLE table_name
DROP TABLE employee_shiweijie

数据库中所有数据类型的默认值都是NULL，
可是使用DEFAULT为指定字段单独定义默认值。

对于字符串的直接量，在数据库中是用单引号括起来的
并且字符串的值是区分大小写的！
CREATE TABLE employee_shiweijie(
  id NUMBER(4),
  name VARCHAR2(20),
  gender CHAR(1) DEFAULT'M',
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR(30) DEFAULT'CLERK',
  deptno NUMBER(2)
)

DESC employee_shiweijie

NOT NULL 定义的字段不能为空

CREATE TABLE employee_shiweijie(
  id NUMBER(4),
  name VARCHAR2(20) NOT NULL,
  gender CHAR(1) DEFAULT'M',
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30) DEFAULT'CLERK',
  deptno  NUMBER(2)
)
DESC employee_shiweijie


修改表
1：修改表名
2：修改表结构

修改表名：
RENAME old_name TO nwe_name
将employee_shiweijie改名为myemp_shiwejie
RENAME employee_shiweijie TO myemp_shiweijie

DESC myemp_shiweijie

修改表结构：
1：添加新字段
ALTER TABLE myemp_shiweijie ADD ( hiredate DATE )

2:修改现有字段
可以修改字段的类型，长度，添加默认值或NOT NULL 约束。
需要注意，尽量在表中没有数据的时候进行修改，
否则尽量不要修改类型，修改长度时尽量增加而不是减少，
否则可能由于已有数据不满足修改条件而导致修改字段失败。
ALTER TABLE myemp_shiweijie MODIFY ( job VARCHAR2(40) DEFAULT'CLERK' )
DESC myemp_shiweijie

删除字段
ALTER TABLE myemp_shiweijie DROP ( hiredate )
DESC myemp_shiweijie


DML 语句：数据操作语句
用于增删改表中数据，DML是伴随TCL（事物控制）

INSERT 语句
用于向表中插入新数据
INSERT INTO myemp_shiweijie (id,name,salary,deptno) VALUES (1,'jack',5000,10)

查询表
SELECT * FROM myemp_shiweijie

插入数据时忽略字段则是全列插入：
INSERT INTO myemp_shiweijie VALUES (2,'TOM','F',SYSDATE,5000,'CLERK',10)

插入日期类型数据时使用TO_DATE函数
INSERT INTO myemp_shiweijie (id,name,gender,birth,salary,job,deptno) VALUES (3,'史维杰','M',TO_DATE('1992-08-02','YYYY-MM-DD'),5000,'CLERK',10)

修改表中数据时通常要添加WHERE条件，这样只会将表中满足条件的记录进行修改，
若不添加条件则是表中所有记录都修改！

UPDATE 语句：修改表中数据
将TOM的工资改为8000
UPDATE myemp_shiweijie SET salary=8000,deptno=30 WHERE name='TOM'

删除数据的时候通常也要添加过滤条件来删除满足条件的记录，
不添加条件则是清空表操作（TRUNCATE TABLE myemp_shiweijie不能回滚，块删除，速度快）

DELETE 语句：删除表中数据
DELETE FROM myemp_shiweijie WHERE name='jack' 

