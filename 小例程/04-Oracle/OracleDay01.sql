SELECT SYSDATE FROM dual;

SQL��䣺�ṹ����ѯ���
ʹ��SQL�����ݿ⡰��ͨ���������Ӧ�����ݿ������
SQL��һ�ױ�׼������DBMS��֧�ָñ�׼
SQL��䱾�����ִ�Сд����Ӧ�����ؼ�����ǹؼ����ô�Сд���������ӿɶ��ԡ�
SQL����Ϊ��DDL��DML��TCL��DQL��DCL
DDL��䣺���ݶ�����䣬����ά�����ݿ����

CREATE TABLE employee_swj(
  id NUMBER(4),
  name VARCHAR2(20),
  gender CHAR(1),
  birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
)

�鿴��ṹ
DESC table_name
DESC employee_swj

ɾ����
DROP TABLE table_name
DROP TABLE employee_shiweijie

���ݿ��������������͵�Ĭ��ֵ����NULL��
����ʹ��DEFAULTΪָ���ֶε�������Ĭ��ֵ��

�����ַ�����ֱ�����������ݿ������õ�������������
�����ַ�����ֵ�����ִ�Сд�ģ�
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

NOT NULL ������ֶβ���Ϊ��

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


�޸ı�
1���޸ı���
2���޸ı�ṹ

�޸ı�����
RENAME old_name TO nwe_name
��employee_shiweijie����Ϊmyemp_shiwejie
RENAME employee_shiweijie TO myemp_shiweijie

DESC myemp_shiweijie

�޸ı�ṹ��
1��������ֶ�
ALTER TABLE myemp_shiweijie ADD ( hiredate DATE )

2:�޸������ֶ�
�����޸��ֶε����ͣ����ȣ����Ĭ��ֵ��NOT NULL Լ����
��Ҫע�⣬�����ڱ���û�����ݵ�ʱ������޸ģ�
��������Ҫ�޸����ͣ��޸ĳ���ʱ�������Ӷ����Ǽ��٣�
������������������ݲ������޸������������޸��ֶ�ʧ�ܡ�
ALTER TABLE myemp_shiweijie MODIFY ( job VARCHAR2(40) DEFAULT'CLERK' )
DESC myemp_shiweijie

ɾ���ֶ�
ALTER TABLE myemp_shiweijie DROP ( hiredate )
DESC myemp_shiweijie


DML ��䣺���ݲ������
������ɾ�ı������ݣ�DML�ǰ���TCL��������ƣ�

INSERT ���
��������в���������
INSERT INTO myemp_shiweijie (id,name,salary,deptno) VALUES (1,'jack',5000,10)

��ѯ��
SELECT * FROM myemp_shiweijie

��������ʱ�����ֶ�����ȫ�в��룺
INSERT INTO myemp_shiweijie VALUES (2,'TOM','F',SYSDATE,5000,'CLERK',10)

����������������ʱʹ��TO_DATE����
INSERT INTO myemp_shiweijie (id,name,gender,birth,salary,job,deptno) VALUES (3,'ʷά��','M',TO_DATE('1992-08-02','YYYY-MM-DD'),5000,'CLERK',10)

�޸ı�������ʱͨ��Ҫ���WHERE����������ֻ�Ὣ�������������ļ�¼�����޸ģ�
��������������Ǳ������м�¼���޸ģ�

UPDATE ��䣺�޸ı�������
��TOM�Ĺ��ʸ�Ϊ8000
UPDATE myemp_shiweijie SET salary=8000,deptno=30 WHERE name='TOM'

ɾ�����ݵ�ʱ��ͨ��ҲҪ��ӹ���������ɾ�����������ļ�¼��
���������������ձ������TRUNCATE TABLE myemp_shiweijie���ܻع�����ɾ�����ٶȿ죩

DELETE ��䣺ɾ����������
DELETE FROM myemp_shiweijie WHERE name='jack' 

