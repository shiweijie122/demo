DQL���:��ѯ���
��SELECT�Ӿ�����ʹ�ú������߱��ʽ,��ô
�ڲ�ѯ�Ľ�����ж�Ӧ�ĸ��ֶε����־���
����������߱��ʽ,ȱ����:��ֱ��
��ʱ�����Ϊ�������ֶ���ӱ���.

SELECT ename,sal*12 sal
FROM emp

��ϣ���������ִ�Сд���ߺ��пո�,��ô
����ʹ��˫���Ž�����������
SELECT ename,sal+NVL(comm,0) "sal"
FROM emp


AND,OR�����������Ӷ������,OR�����ȼ�
�ǵ���AND��,����ʹ������������ȼ�.
SELECT ename, sal, job 
FROM emp 
WHERE sal > 1000 
AND (job = 'SALESMAN'
OR job = 'CLERK')



LIKE�ؼ���
LIKE����ģ��ƥ���ַ���,֧������
ͨ���:
%:0-����ַ�
_:һ���ַ�
�鿴���ֵڶ�����ĸ��A��Ա��
SELECT ename,sal,job
FROM emp
WHERE ename LIKE '_A%'


IN(list),NOT IN(list)
�ж����б��л����б���
IN,NOT IN�������Ӳ�ѯ���ж���

�鿴ְλ��MANAGER��CLERK��Ա��?
SELECT ename,job,sal
FROM emp
WHERE job IN ('MANAGER','CLERK')


BETWEEN...AND...
�ж���һ�����䷶Χ��

�鿴������1500��3000֮���Ա��?
SELECT ename,sal,job
FROM emp
WHERE sal BETWEEN 1500 AND 3000


ANY(list),ALL(list)
���>,>=,<,<=ʹ��
>ANY(list):�����б�����֮һ(������С)
>ALL(list):�����б�����(�������)
<ANY(list):С���б�����֮һ(С�����)
<ALL(list):С���б�����(С����С)

ANY,ALL���б�ͨ������ָ��ȷ��ֵ,��������
�Ӳ�ѯ��

SELECT empno, ename, job,sal
FROM emp
WHERE sal > ANY(3500,4000,4500)


DISTINCT�ؼ���:ȥ��ָ���ֶ�ֵһ��
���ظ���¼��

�鿴��˾��ְλ����Щ?
SELECT DISTINCT job FROM emp

����ȥ��:����ֶ�ֵ�����û���ظ���¼
SELECT DISTINCT job,deptno 
FROM emp

ORDER BY�Ӿ�:��������
ORDER BY����Խ��������ָ�����ֶ�
ֵ����������߽�������.

�鿴��˾���ʵ�����:
SELECT ename,sal,job
FROM emp
ORDER BY sal DESC


SELECT ename,sal,job
FROM emp
WHERE deptno=20
ORDER BY sal DESC

���ֶ�����,�����������ȼ���,����
���յ�һ���ֶ�����,����һ���ֶ�ֵ
����ͬ�ļ�¼ʱ,���յڶ����ֶ�����,
�Դ�����.
SELECT ename,deptno,sal
FROM emp
ORDER BY deptno DESC,sal DESC

������ֶ���������NULLֵ,NULL������Ϊ
���ֵ
SELECT ename,comm
FROM emp
ORDER BY comm


�ۺϺ���,�ֳ�Ϊ:���к���,���麯��
�����ǽ���ͳ�Ƶ�
�������ĸ����ֵ��ͳ��:
MAX,MIN,AVG,SUM
�Լ�һ���Լ�¼����ͳ��:
COUNT

�鿴��˾���ʵ����,��С,�ܺ�,ƽ��ֵ?
SELECT 
 MAX(sal),MIN(sal),
 SUM(sal),AVG(sal)
FROM emp

�鿴��˾��������?
SELECT COUNT(ename) FROM emp

�ۺϺ�������NULLֵ
SELECT COUNT(comm) FROM emp

SELECT COUNT(*) FROM emp
SELECT COUNT(1) FROM emp

SELECT AVG(NVL(comm,0)) 
FROM emp


GROUP BY�Ӿ�:����
������Ϊ����ϾۺϺ������и�ϸ��
��ͳ�ƹ���,�����������ǽ���ѯ�ļ�¼
����ָ�����ֶ�ֵһ���ļ�¼����һ��
��ϾۺϺ�����ÿ�����ݷֱ�ͳ�ƽ��

�鿴ÿ�����ŵ���߹���?
SELECT MAX(sal),deptno
FROM emp
GROUP BY deptno

��SELECT�к��оۺϺ���ʱ,��ô������
�ۺϺ����еĵ����ֶα��������GROUP BY
�Ӿ��з����ѯ����.

�鿴ÿ�����ŵ�Ա������?
SELECT COUNT(*),deptno
FROM emp
GROUP BY deptno

���ֶη���,�ǰ�����Щ�ֶ�ֵ���һ��
�ļ�¼���з���.

�鿴ͬ����ְͬλ��Ա���ֱ������?
SELECT COUNT(*),deptno,job
FROM emp
GROUP BY deptno,job


�鿴���ŵ�ƽ������,ǰ���Ǹò��ŵ�
ƽ������Ҫ����2000
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno

����SQL���׳��쳣,��ΪWHERE����
����ʹ�þۺϺ�����Ϊ����������,ԭ��
���ڹ��˵�ʱ������.
WHERE���ڼ�����������ʱ���н��й���
��,�����������ļ�¼��ѯ�������ɽ����.
�ۺϺ���������ͳ�ƽ�����е����ݵ�,����
Ҫ�Ƚ����ݲ�ѯ�����ſ��Խ���,Ϊ���þۺ�
�����Ľ����������WHERE֮����е�.

HAVING�Ӿ�:�������˷���
HAVING�Ӿ�������GROUP BY����
����ָ����������������ķ���ȥ��.

�鿴���ŵ�ƽ������,ǰ���Ǹò��ŵ�
ƽ������Ҫ����2000
SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

�鿴ƽ�����ʸ���2000�Ĳ��ŵ���߹����Ƕ���?
SELECT MAX(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

������ѯ
�Ӷ��ű��й�����ѯ����,��:��ѯ�Ľ����
�е��ֶο������Զ��ű�.������ѯ���ص�
�ǹ�������,���ݿ��Ǹ��ݹ���������������
�еļ�¼��ϵ��һ���.

�鿴ÿ��Ա���Լ������ڲ��ŵ�����?
SELECT ename,dname
FROM emp,dept
WHERE emp.deptno=dept.deptno

���������������ļ�¼�ᱻ����,����
SCOTT��ѯ����.


��������Ҫ���������ͬʱ����.
�鿴��NEW YORK������Ա��?
SELECT ename,dname,loc
FROM emp,dept
WHERE emp.deptno=dept.deptno
AND loc='NEW YORK'


Ϊ����ӱ������Լ�SQL��临�Ӷ�
����ѯ���ֶ��ڹ����ı��ж���ͬ���ֶ�ʱ,
�����ñ������߱������ָ�����ֶ�������.
SELECT e.ename,e.deptno,d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno

������ѯ������ָ����������,����
����������Чʱ������ѿ�����,��
ͨ����һ��������Ľ����,��¼��
�ǹ������¼���ĳ˻�.

SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d

�鿴�����к���A��ĸ��Ա�����ڵ�
����������?
SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.ename LIKE '%A%'

N�ű������ѯ,����Ҫ��N-1����������.

������
������Ҳ����ʵ�ֹ�����ѯ
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


�鿴�����к���A��ĸ��Ա�����ڵ�
����������?
SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE e.ename LIKE '%A%'

������
�������ڽ��й�����ѯʱ���˿��Խ�����
���������ļ�¼��ѯ����֮��,�����Խ�
���������������ļ�¼Ҳ��ѯ����.
�����ӷ�Ϊ:��������,��������,ȫ������
��������:��JOIN������Ϊ������(����
���ݶ�Ҫ��ʾ�ı�),��ô����������ĳ��
��¼��������������ʱ�����Ҳ���е��ֶ�
ȫ��ȡֵΪNULL.

SELECT e.ename,d.dname
FROM emp e 
 LEFT|RIGHT|FULL OUTER JOIN 
     dept d
ON e.deptno=d.deptno

SELECT e.ename,e.deptno,
       d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno(+)

������
�����Ӿ��ǵ�ǰ���һ����¼��Ӧ
��ǰ���Լ��Ķ�����¼.
��������������������������ͬ����
�ִ������¼���ϵ����״�ṹʱʹ��.

�鿴ÿ��Ա���Լ�����˾������?
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno(+)








