DQL ��䣺���ݲ�ѯ����
������ѯ���ݿ��е�����

DQL������������Ӿ䣬�ֱ���
SELECT �Ӿ䣺ָ��Ҫ��ѯ���ֶ�
            ��ָ��������ֶΣ����������ʽ
FROM �Ӿ䣺ָ��������Դ

SELECT empno,ename,job,sal FROM emp_shiweijie
SELECT ename,sal,sal*12 FROM emp_shiweijie


�ַ�������
1��CONCAT(char1,char2)
����char1��char2
SELECT CONCAT(ename,sal) FROM emp_shiweijie
SELECT CONCAT(CONCAT(ename,':'),sal) FROM emp_shiweijie
ʹ��"||"Ҳ����ƴ���ַ�����������
SELECT ename||','||job||':'||sal FROM emp_shiweijie

2:LENGTH(CHAR)
����ָ���ַ����ĳ���
SELECT ename,LENGTH(ename) FROM emp_shiweijie
�鿴������5����ĸ��Ա����
SELECT ename FROM emp_shiweijie WHERE LENGTH(ename)=5


dual:α��ʵ���ϲ����ڵı�����ѯ���������κα��������޹�ʱ��������FROM�Ӿ���ʹ��α��α��ֻ���ѯ��һ����¼

3��UPPER,LOWER,INITCAP
�������ַ����е���ĸת��Ϊȫ��д��ȫСд������ĸ��д
INITCAP �е��ַ��������ÿո�ָ�������ʣ���ôÿ����������ĸ�����д
SELECT UPPER('helloworld'),LOWER('HELLOWORLD'),INITCAP('HELLO WORLD') FROM dual

�鿴scottԱ������Ϣ��
SELECT ename,sal,job,deptno FROM emp_shiweijie WHERE ename=UPPER('scott')

4:TRIM,LERIM,RTRIM
ȥ���ַ������ˣ���ˣ��Ҷ˵�ָ���ַ�
SELECT TRIM('e' FROM 'eeelisteee') FROM dual
SELECT LTRIM('eeelistee','e') FROM dual
SELECT RTRIM('eeelistee','e') FROM dual
SELECT LTRIM('asddadaddalistesa','asd') FROM dual

5:LPAD,RPAD
��λ����
LPAD(char1,n,char2)
��char1���ȱ�Ϊnλ�������㣬�����油������char2�ַ��Դﵽ��λ�����������ȡchar1.
SELECT ename,LPAD(sal,6,'$') FROM emp_shiweijie
SELECT ename,LPAD(sal,6,' ') FROM emp_shiweijie
SELECT ename,LPAD(sal,3,'$') FROM emp_shiweijie

6:SUBSTR(char,m[,n])
��ȡchar�ַ�������m����ʼ��������ȡn���ַ�
n���Բ�ָ������ָ�����ǽ�ȡ��ĩβ����n����ʵ�ʿɽ�ȡ���ȣ�Ҳ�ǵ�ĩβ�����ݿ����±궼�Ǵ�1��ʼ�ġ�
m�����Ǹ��������Ǹ������Ǵӵ���λ�ÿ�ʼ��ȡ
SELECT SUBSTR('thinking in java',10,2) FROM dual
SELECT SUBSTR('thinking in java',-7,2) FROM dual

7��INSTR(char1,char2,m,n)
�鿴char2��char1�е�λ��
m��ʾ�ӵڼ����ַ���ʼ������n��ʾ�ڼ��γ��֣�m��n�����Բ�ָ������ָ����Ϊ1
SELECT INSTR('thinking in java','in',4,2) FROM dual


��ֵ����
1��ROUND(m[,n])
��m�����������룬����С�����nλ��
nΪ0��ָ�����Ǳ���������λ����Ϊ�������Ǳ���ʮλ���ϵ�����
SELECT ROUND(45.678,2) FROM dual
SELECT ROUND(45.678,0) FROM dual
SELECT ROUND(45.678,-1) FROM dual

2:TRUNC��������ȡ�ַ���
����������ROUNDһ��
SELECT TRUNC(45.678,2) FROM dual

3:MOD(m,n):����
��nΪ0��ֱ�ӷ���m
SELECT ename,sal,MOD(sal,1000) FROM emp_shiweijie

4:CEIL(n),FLOOR(n)
����ȡ��������ȡ��
SELECT CEIL(45.678),FLOOR(45.678) FROM dual


������عؼ���
SYSDATE,SYSTIMESTAMP
��Ӧ���ݿ��ڲ����������ص�ǰϵͳʱ�䡣
DATEĬ��ֻ��ʾ��DD-MON-RR
ʱ������ݻ��һЩ
SELECT SYSDATE FROM dual
SELECT SYSTIMESTAMP FROM dual

INSERT INTO emp_shiweijie (empno,ename,sal,job,deptno,hiredate) VALUES (1001,'JACK',2000,'CLERK',10,SYSDATE)
SELECT hiredate FROM emp_shiweijie

����ת������
1��TO_DATE()
��һ���ַ�������ָ�������ڸ�ʽ����ΪDATE
���ڸ�ʽ�ַ����г�����ĸ��������������ַ���Ҫ��˫������������
SELECT TO_DATE('2008-08-08 20:08:08','YYYY-MM-DD HH24:MI:SS') FROM dual
SELECT TO_DATE('2008��08��08��','YYYY"��"MM"��"DD"��"') FROM dual

���ڿ��Խ��м��㣬���������������Ϊ����������
��һ�����ڼӼ�һ�����ֵ��ڼӼ�������
���ڿ��ԱȽϴ�С�������Խ��

�鿴ÿ��Ա����ְ������һ���������ˣ�
SELECT ename,SYSDATE-hiredate FROM emp_shiweijie
�������һ������
SELECT SYSDATE-TO_DATE('1992-08-02','YYYY-MM-DD') FROM DUAL

2:TO_CHAR():������������ת��Ϊ�ַ���
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL

RR,YY ��TO_DATE�н�һ����λ���������Ϊʵ�ʵ�����ʱ���ж�ʵ�ʵı�׼��ͬ
YY���յ�ǰϵͳʱ��������Ϊ���ͽ�����RR�������ж���
SELECT TO_CHAR(TO_DATE('17-08-08','RR-MM-DD'),'YYYY-MM-DD') FROM DUAL
SELECT SYSDATE FROM DUAL

������غ���
1��LAST_DAY(date)
���ظ������������µ��µ�����
SELECT LAST_DAY(SYSDATE) FROM DUAL

2��ADD_MONTHS(date,i)
�Ը������ڼӼ���
SELECT SYSDATE+1 FROM DUAL
SELECT ADD_MONTHS(SYSDATE,1) FROM DUAL

3:MONTHS_BETWEEN(date1,date2)
������������֮��������
SELECT ename,MONTHS_BETWEEN(SYSDATE,hiredate) FROM emp_shiweijie

4:NEXT_DAY(date,i)
���ظ������ڵڶ��쿪ʼһ����ָ���ܼ���Ӧ������ (1Ϊ�����գ�7Ϊ������)
SELECT NEXT_DAY(SYSDATE,5) FROM DUAL

5��LEAST,GREATEST
����Сֵ�����ֵ
�����������Ϳ��ã��������ԱȽϴ�С���������Ͷ�����ʹ��������������
����Ҫ�����ٴ���һ�����������в�����������Ҫһ�¡�
SELECT LEAST(SYSDATE,TO_DATE('2018-08-08','YYYY-MM-DD'),SYSDATE-1) FROM DUAL

6��EXTRACT() ��ȡһ��������ָ��ʱ�䵥λ��Ӧ��ֵ
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL

�鿴1981����ְ��Ա����
SELECT ename,hiredate FROM emp_shiweijie WHERE EXTRACT(YEAR FROM hiredate)=1981


����NULLֵ
CREATE TABLE student_shiweijie(
  id NUMBER(4),
  name CHAR(20),
  gender CHAR(1)
);
INSERT INTO student_shiweijie VALUES (1000,'��Ī��','F');
INSERT INTO student_shiweijie VALUES (1001,'��ƽ֮',NULL);
INSERT INTO student_shiweijie (id,name)VALUES (1002,'���޼�');
SELECT * FROM student_shiweijie
DELETE FROM student_shiweijie

2:����NULL
����Ī���Ա��ΪNULL
UPDATE student_shiweijie SET gender=NULL WHERE name='��Ī��'

�ж�һ���ֶ��Ƿ�Ϊ�գ�������"="����Ҫ��IS NULL��IS NOT NULL

3:ɾ���Ա�ΪNULL����
DELETE FROM student_shiweijie WHERE gender is null

NULL������
NULL���ַ������ӵ���ʲôҲû��
NULL����������������NULL


��ֵ����
1��NVL(arg1,arg2)
��NULLֵ�滻Ϊ��NULLֵ
��arg1ΪNULLʱ����������arg2
��arg1��ΪNULLʱ������arg1
SELECT ename,sal,comm,sal+NVL(comm,0) FROM emp_shiweijie

�鿴ÿ��Ա���ļ�Ч����������м�Ч����ʾΪ"�м�Ч",ΪNULL������ʾΪ"û�м�Ч"
2��NVL2(arg1,arg2,arg3)
��arg1��ΪNULL����������arg2
��arg1ΪNULL����������arg3
SELECT ename,comm,NVL2(comm,'�м�Ч','û�м�Ч') FROM emp_shiweijie