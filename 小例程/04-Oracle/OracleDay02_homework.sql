1:��ѯemp�������ݣ��г�һ�У�����Ϊ������ְλ
  ��ʾ��ʽ��ename:job
SELECT CONCAT(CONCAT(ename,':'),job) FROM emp_shiweijie

2:�鿴ÿ��Ա��ְλ���ַ�����
SELECT ename,job,LENGTH(job) FROM emp_shiweijie

3:������Ա����������Сд��ʽ��������ĸ��д��ʽ
   ��ѯ��������һ��ΪСд��ʽ���ڶ���Ϊ����ĸ��д
SELECT LOWER(ename),INITCAP(ename) FROM emp_shiweijie   

4:���ַ���'aaaaaabaaaaa'���������ߵ�aȥ��
SELECT TRIM('a' FROM 'aaaaaabaaaaa') FROM dual

5:��ʾÿ��Ա�������֣�Ҫ����ʾ10λ����һ�������Ч�����ڶ���    �Ҷ���Ч��
SELECT LPAD(ename,10,' '),RPAD(ename,10,' ') FROM emp_shiweijie

6:��ȡ�ַ���'DOCTOR WHO'�е�'WHO'
SELECT SUBSTR('DOCTOR WHO',-3) FROM dual

7:�鿴'DOCTOR WHO'��'WHO'��λ��
SELECT INSTR('DOCTOR WHO','WHO',1,1) FROM dual

8:�ֱ�鿴55.789�������뱣��С�����2λ������λ��ʮλ���
   ���֣���ʾ�����С�
SELECT ROUND(55.789,2),ROUND(55.789,0),ROUND(55.789,-1) FROM dual   
   
9:�ֱ�鿴55.789��ȡ����С�����2λ������λ��ʮλ���
   ���֣���ʾ�����С�
SELECT TRUNC(55.789,2),TRUNC(55.789,0),TRUNC(55.789,-1) FROM dual   
   
10���鿴ÿ��Ա�����ʰ�λ���µ�����?
SELECT ename,sal,MOD(sal,100) FROM emp_shiweijie

11:�鿴ÿ��Ա������ְ������һ�������죬����С��������ȡ����
SELECT ename,ROUND((SYSDATE-hiredate),0) FROM emp_shiweijie

12:�鿴��2008-08-08�ŵ�����Ϊֹһ�������˶�����?
SELECT ROUND((SYSDATE-TO_DATE('2008-08-08','YYYY-MM-DD')),0) FROM dual

13:��ÿ��Ա����ְʱ��������:
     1981��12��3��
     ����ʽ��ʾ
SELECT TO_CHAR(hiredate,'YYYY"��"MM"��"DD"��"') FROM emp_shiweijie

14���鿴ÿ��Ա����ְ�����µ��µ�������?
SELECT LAST_DAY(hiredate) FROM emp_shiweijie

15:�鿴ÿ��Ա��ת������(��ְ��3����)
SELECT ADD_MONTHS(hiredate,3) FROM emp_shiweijie

16���鿴ÿ��Ա����ְ���񹲶��ٸ���?
SELECT ROUND((MONTHS_BETWEEN(SYSDATE,hiredate)),2) FROM emp_shiweijie

17:�鿴�����쿪ʼһ���ڵ�����������?
SELECT NEXT_DAY(SYSDATE,1) FROM dual

18:�鿴82���Ժ���ְ��Ա������ְ���ڣ�82����ǰ�İ���
     1982��01��01����ʾ����ʽ����DD-MON-RR(Ĭ�ϸ�ʽ)
SELECT hiredate FROM emp_shiweijie WHERE EXTRACT(YEAR FROM hiredate)>1982;
SELECT TO_CHAR(hiredate,'YYYY"��"MM"��"DD"��"') FROM emp_shiweijie WHERE EXTRACT(YEAR FROM hiredate)<1982

19:�鿴ÿ��Ա������ְ���?
SELECT ename,EXTRACT(YEAR FROM hiredate) FROM emp_shiweijie

20:��ʾÿ��Ա����������(���ʼӽ���)������ΪNULL��ֻ������
SELECT ename,sal,comm,sal+NVL(comm,0) FROM emp_shiweijie

21:ʹ��NVL2ʵ��20�������
SELECT ename,sal,comm,sal+NVL2(comm,comm,0) FROM emp_shiweijie
SELECT * FROM emp_shiweijie
