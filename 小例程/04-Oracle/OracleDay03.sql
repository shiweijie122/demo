DQL语句:查询语句
在SELECT子句中若使用函数或者表达式,那么
在查询的结果集中对应的该字段的名字就是
这个函数或者表达式,缺点是:不直观
这时候可以为这样的字段添加别名.

SELECT ename,sal*12 sal
FROM emp

若希望别名区分大小写或者含有空格,那么
可以使用双引号将别名括起来
SELECT ename,sal+NVL(comm,0) "sal"
FROM emp


AND,OR可以用来连接多个条件,OR的优先级
是低于AND的,可以使用括号提高优先级.
SELECT ename, sal, job 
FROM emp 
WHERE sal > 1000 
AND (job = 'SALESMAN'
OR job = 'CLERK')



LIKE关键字
LIKE用于模糊匹配字符串,支持两个
通配符:
%:0-多个字符
_:一个字符
查看名字第二个字母是A的员工
SELECT ename,sal,job
FROM emp
WHERE ename LIKE '_A%'


IN(list),NOT IN(list)
判断在列表中或不在列表中
IN,NOT IN常用在子查询的判断中

查看职位是MANAGER或CLERK的员工?
SELECT ename,job,sal
FROM emp
WHERE job IN ('MANAGER','CLERK')


BETWEEN...AND...
判断在一个区间范围内

查看工资在1500到3000之间的员工?
SELECT ename,sal,job
FROM emp
WHERE sal BETWEEN 1500 AND 3000


ANY(list),ALL(list)
结合>,>=,<,<=使用
>ANY(list):大于列表其中之一(大于最小)
>ALL(list):大于列表所有(大于最大)
<ANY(list):小于列表其中之一(小于最大)
<ALL(list):小于列表所有(小于最小)

ANY,ALL的列表通常不会指定确定值,而是用在
子查询中

SELECT empno, ename, job,sal
FROM emp
WHERE sal > ANY(3500,4000,4500)


DISTINCT关键字:去除指定字段值一样
的重复记录行

查看公司的职位有哪些?
SELECT DISTINCT job FROM emp

多列去重:多个字段值的组合没有重复记录
SELECT DISTINCT job,deptno 
FROM emp

ORDER BY子句:排序结果集
ORDER BY允许对结果集按照指定的字段
值进行升序或者降序排列.

查看公司工资的排名:
SELECT ename,sal,job
FROM emp
ORDER BY sal DESC


SELECT ename,sal,job
FROM emp
WHERE deptno=20
ORDER BY sal DESC

多字段排序,排序是有优先级的,首先
按照第一个字段排序,当第一个字段值
有相同的记录时,按照第二个字段排序,
以此类推.
SELECT ename,deptno,sal
FROM emp
ORDER BY deptno DESC,sal DESC

排序的字段中若含有NULL值,NULL被认作为
最大值
SELECT ename,comm
FROM emp
ORDER BY comm


聚合函数,又称为:多行函数,分组函数
作用是进行统计的
其中有四个针对值的统计:
MAX,MIN,AVG,SUM
以及一个对记录数的统计:
COUNT

查看公司工资的最大,最小,总和,平均值?
SELECT 
 MAX(sal),MIN(sal),
 SUM(sal),AVG(sal)
FROM emp

查看公司共多少人?
SELECT COUNT(ename) FROM emp

聚合函数忽略NULL值
SELECT COUNT(comm) FROM emp

SELECT COUNT(*) FROM emp
SELECT COUNT(1) FROM emp

SELECT AVG(NVL(comm,0)) 
FROM emp


GROUP BY子句:分组
分组是为了配合聚合函数进行更细致
的统计工作,分组允许我们将查询的记录
按照指定的字段值一样的记录看做一组
配合聚合函数对每组数据分别统计结果

查看每个部门的最高工资?
SELECT MAX(sal),deptno
FROM emp
GROUP BY deptno

当SELECT中含有聚合函数时,那么凡不在
聚合函数中的单独字段必须出现在GROUP BY
子句中否则查询报错.

查看每个部门的员工人数?
SELECT COUNT(*),deptno
FROM emp
GROUP BY deptno

多字段分组,是按照这些字段值组合一样
的记录进行分组.

查看同部门同职位的员工分别多少人?
SELECT COUNT(*),deptno,job
FROM emp
GROUP BY deptno,job


查看部门的平均工资,前提是该部门的
平均工资要高于2000
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno

上述SQL会抛出异常,因为WHERE中是
不能使用聚合函数作为过滤条件的,原因
在于过滤的时机不对.
WHERE是在检索表中数据时逐行进行过滤
的,将满足条件的记录查询出来生成结果集.
聚合函数是用来统计结果集中的数据的,所以
要先将数据查询出来才可以进行,为此用聚合
函数的结果过滤是在WHERE之后进行的.

HAVING子句:用来过滤分组
HAVING子句必须跟在GROUP BY后面
根据指定的条件将不满足的分组去除.

查看部门的平均工资,前提是该部门的
平均工资要高于2000
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

查看平均工资高于2000的部门的最高工资是多少?
SELECT MAX(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

关联查询
从多张表中关联查询数据,即:查询的结果集
中的字段可能来自多张表.关联查询的重点
是关联条件,数据库是根据关联条件将各个表
中的记录联系在一起的.

查看每个员工以及其所在部门的名称?
SELECT ename,dname
FROM emp,dept
WHERE emp.deptno=dept.deptno

不满足连接条件的记录会被忽略,所以
SCOTT查询不到.


连接条件要与过滤条件同时成立.
查看在NEW YORK工作的员工?
SELECT ename,dname,loc
FROM emp,dept
WHERE emp.deptno=dept.deptno
AND loc='NEW YORK'


为表添加别名可以简化SQL语句复杂度
当查询的字段在关联的表中都有同名字段时,
必须用表名或者表别名来指定该字段所属表.
SELECT e.ename,e.deptno,d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno

关联查询中若不指定连接条件,或者
连接条件无效时会产生笛卡尔积,这
通常是一个无意义的结果集,记录数
是关联表记录数的乘积.

SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d

查看名字中含有A字母的员工所在的
城市是哪里?
SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.ename LIKE '%A%'

N张表关联查询,至少要有N-1个连接条件.

内连接
内连接也用来实现关联查询
SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno

SELECT XXXX
FROM A a,B b,C c
WHERE a.xx=b.xx 
AND b.xx=c.xx

SELECT XXXX
FROM A a JOIN B b
ON a.xx=b.xx 
JOIN C c
ON b.xx=c.xx


查看名字中含有A字母的员工所在的
城市是哪里?
SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE e.ename LIKE '%A%'

外连接
外连接在进行关联查询时除了可以将满足
连接条件的记录查询出来之外,还可以将
不满足连接条件的记录也查询出来.
外连接分为:左外连接,右外连接,全外连接
左外连接:以JOIN左侧表作为驱动表(所有
数据都要显示的表),那么当驱动表中某条
记录不满足连接条件时来则右侧表中的字段
全部取值为NULL.

SELECT e.ename,d.dname
FROM emp e 
 LEFT|RIGHT|FULL OUTER JOIN 
     dept d
ON e.deptno=d.deptno

SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno(+)

自连接
自连接就是当前表的一条记录对应
当前表自己的多条记录.
自连接是用来保存数据属性相同但是
又存在上下级关系的树状结构时使用.

查看每个员工以及其上司的名字?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno(+)








