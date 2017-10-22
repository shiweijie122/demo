DQL 语句：数据查询语言
用来查询数据库中的数据

DQL必须包含两个子句，分别是
SELECT 子句：指定要查询的字段
            可指定具体的字段，函数，表达式
FROM 子句：指定数据来源

SELECT empno,ename,job,sal FROM emp_shiweijie
SELECT ename,sal,sal*12 FROM emp_shiweijie


字符串函数
1：CONCAT(char1,char2)
连接char1与char2
SELECT CONCAT(ename,sal) FROM emp_shiweijie
SELECT CONCAT(CONCAT(ename,':'),sal) FROM emp_shiweijie
使用"||"也可以拼接字符串，更方便
SELECT ename||','||job||':'||sal FROM emp_shiweijie

2:LENGTH(CHAR)
返回指定字符串的长度
SELECT ename,LENGTH(ename) FROM emp_shiweijie
查看名字是5个字母的员工？
SELECT ename FROM emp_shiweijie WHERE LENGTH(ename)=5


dual:伪表，实际上不存在的表，当查询的内容与任何表中数据无关时，可以在FROM子句中使用伪表，伪表只会查询出一条记录

3：UPPER,LOWER,INITCAP
将给定字符串中的字母转换为全大写，全小写和首字母大写
INITCAP 中的字符串可以用空格分隔多个单词，那么每个单词首字母都会大写
SELECT UPPER('helloworld'),LOWER('HELLOWORLD'),INITCAP('HELLO WORLD') FROM dual

查看scott员工的信息？
SELECT ename,sal,job,deptno FROM emp_shiweijie WHERE ename=UPPER('scott')

4:TRIM,LERIM,RTRIM
去除字符串两端，左端，右端的指定字符
SELECT TRIM('e' FROM 'eeelisteee') FROM dual
SELECT LTRIM('eeelistee','e') FROM dual
SELECT RTRIM('eeelistee','e') FROM dual
SELECT LTRIM('asddadaddalistesa','asd') FROM dual

5:LPAD,RPAD
补位函数
LPAD(char1,n,char2)
将char1长度变为n位，若不足，则左面补充若干char2字符以达到该位数。超过则截取char1.
SELECT ename,LPAD(sal,6,'$') FROM emp_shiweijie
SELECT ename,LPAD(sal,6,' ') FROM emp_shiweijie
SELECT ename,LPAD(sal,3,'$') FROM emp_shiweijie

6:SUBSTR(char,m[,n])
截取char字符串，从m处开始，连续截取n个字符
n可以不指定，不指定则是截取到末尾，若n超过实际可截取长度，也是到末尾。数据库中下标都是从1开始的。
m可以是负数，若是负数则是从倒数位置开始截取
SELECT SUBSTR('thinking in java',10,2) FROM dual
SELECT SUBSTR('thinking in java',-7,2) FROM dual

7：INSTR(char1,char2,m,n)
查看char2在char1中的位置
m表示从第几个字符开始检索，n表示第几次出现，m，n都可以不指定，不指定则为1
SELECT INSTR('thinking in java','in',4,2) FROM dual


数值函数
1：ROUND(m[,n])
对m进行四舍五入，保留小数点后n位。
n为0或不指定则是保留到整数位，若为负数则是保留十位以上的数字
SELECT ROUND(45.678,2) FROM dual
SELECT ROUND(45.678,0) FROM dual
SELECT ROUND(45.678,-1) FROM dual

2:TRUNC函数：截取字符串
参数含义与ROUND一致
SELECT TRUNC(45.678,2) FROM dual

3:MOD(m,n):求余
若n为0则直接返回m
SELECT ename,sal,MOD(sal,1000) FROM emp_shiweijie

4:CEIL(n),FLOOR(n)
向上取整与向下取整
SELECT CEIL(45.678),FLOOR(45.678) FROM dual


日期相关关键字
SYSDATE,SYSTIMESTAMP
对应数据库内部函数，返回当前系统时间。
DATE默认只显示：DD-MON-RR
时间戳内容会多一些
SELECT SYSDATE FROM dual
SELECT SYSTIMESTAMP FROM dual

INSERT INTO emp_shiweijie (empno,ename,sal,job,deptno,hiredate) VALUES (1001,'JACK',2000,'CLERK',10,SYSDATE)
SELECT hiredate FROM emp_shiweijie

日期转换函数
1：TO_DATE()
将一个字符串按照指定的日期格式解析为DATE
日期格式字符串中除了字母，符号外的其他字符都要用双引号括起来。
SELECT TO_DATE('2008-08-08 20:08:08','YYYY-MM-DD HH24:MI:SS') FROM dual
SELECT TO_DATE('2008年08月08日','YYYY"年"MM"月"DD"日"') FROM dual

日期可以进行计算，两个日期相减，差为相差的天数。
对一个日期加减一个数字等于加减天数。
日期可以比较大小，最晚的越大

查看每个员工入职到今天一共多少天了？
SELECT ename,SYSDATE-hiredate FROM emp_shiweijie
到现在我活的天数
SELECT SYSDATE-TO_DATE('1992-08-02','YYYY-MM-DD') FROM DUAL

2:TO_CHAR():常用来将日期转换为字符串
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL

RR,YY 在TO_DATE中将一个两位数字年解析为实际的日期时，判定实际的标准不同
YY按照当前系统时间世纪作为世纪解析，RR会自行判定。
SELECT TO_CHAR(TO_DATE('17-08-08','RR-MM-DD'),'YYYY-MM-DD') FROM DUAL
SELECT SYSDATE FROM DUAL

日期相关函数
1：LAST_DAY(date)
返回给定日期所在月的月底日期
SELECT LAST_DAY(SYSDATE) FROM DUAL

2：ADD_MONTHS(date,i)
对给定日期加减月
SELECT SYSDATE+1 FROM DUAL
SELECT ADD_MONTHS(SYSDATE,1) FROM DUAL

3:MONTHS_BETWEEN(date1,date2)
计算两个日期之间相差的月
SELECT ename,MONTHS_BETWEEN(SYSDATE,hiredate) FROM emp_shiweijie

4:NEXT_DAY(date,i)
返回给定日期第二天开始一周内指定周几对应的日期 (1为星期日，7为星期六)
SELECT NEXT_DAY(SYSDATE,5) FROM DUAL

5：LEAST,GREATEST
求最小值与最大值
不仅日期类型可用，其他可以比较大小的数据类型都可以使用这两个函数。
函数要求至少传入一个参数，所有参数数据类型要一致。
SELECT LEAST(SYSDATE,TO_DATE('2018-08-08','YYYY-MM-DD'),SYSDATE-1) FROM DUAL

6：EXTRACT() 获取一个日期中指定时间单位对应的值
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL

查看1981年入职的员工？
SELECT ename,hiredate FROM emp_shiweijie WHERE EXTRACT(YEAR FROM hiredate)=1981


插入NULL值
CREATE TABLE student_shiweijie(
  id NUMBER(4),
  name CHAR(20),
  gender CHAR(1)
);
INSERT INTO student_shiweijie VALUES (1000,'李莫愁','F');
INSERT INTO student_shiweijie VALUES (1001,'林平之',NULL);
INSERT INTO student_shiweijie (id,name)VALUES (1002,'张无忌');
SELECT * FROM student_shiweijie
DELETE FROM student_shiweijie

2:更新NULL
将李莫愁性别改为NULL
UPDATE student_shiweijie SET gender=NULL WHERE name='李莫愁'

判断一个字段是否为空，不能用"="，而要用IS NULL和IS NOT NULL

3:删除性别为NULL的人
DELETE FROM student_shiweijie WHERE gender is null

NULL的运算
NULL与字符串连接等于什么也没做
NULL与数字运算结果还是NULL


空值函数
1：NVL(arg1,arg2)
将NULL值替换为非NULL值
当arg1为NULL时，函数返回arg2
当arg1不为NULL时，返回arg1
SELECT ename,sal,comm,sal+NVL(comm,0) FROM emp_shiweijie

查看每个员工的绩效情况。即：有绩效的显示为"有绩效",为NULL的则显示为"没有绩效"
2：NVL2(arg1,arg2,arg3)
当arg1不为NULL，函数返回arg2
当arg1为NULL，函数返回arg3
SELECT ename,comm,NVL2(comm,'有绩效','没有绩效') FROM emp_shiweijie