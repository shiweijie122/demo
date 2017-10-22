1:����һ����ͼ������20�Ų��ŵ�Ա����Ϣ���ֶ�:empno,ename,sal,job,deptno
create or replace view emp5_swj
as
select empno,ename,sal,job,deptno
from emp_shiweijie
where deptno=20

select * from emp5_swj


2:����һ������seq_emp_no,��10��ʼ������Ϊ10
create sequence seq_emp5_swj_no
start with 10
increment by 10

3:��дSQL���鿴seq_emp_no���е���һ������
select seq_emp5_swj_no.nextval from dual

4:��дSQL���鿴seq_emp_no���еĵ�ǰ����
select seq_emp5_swj_no.currval from dual

5:Ϊemp���ename�ֶ��������:idx_emp_ename 
create index idx_emp_shiweijie_ename on emp_shiweijie(ename)

drop index idx_emp_shiweijie_ename
6:Ϊemp���LOWER(ename)�ֶ��������:idx_emp_lower_ename
create index idx_emp_shiweijie_ename on emp_shiweijie(lower(ename))


7:Ϊemp���sal,comm��Ӷ�������
drop index idx_emp_shiweijie_job_sal
create index idx_emp_shiweijie_job_sal on emp_shiweijie(job,sal)

8:����myemployee���ֶ�:
  id NUMBER(4),
  nameVARCHAR2(20),
  birthday DATE,
  telephone VARCHAR2(11)
  scoreNUMBER(9,2)
  ����id��Ϊ������nameҪ����Ϊ��,telephone��ҪΨһ,scoreֵ����>=0
  
create table myemployee_swj(
id number(4) primary key,
name varchar2(20) not null,
birthday date,
telephone varchar2(11) unique,
score number(9,2)
)
alter table myemployee_swj add constraint employee_swj_score_check check(score>=0)