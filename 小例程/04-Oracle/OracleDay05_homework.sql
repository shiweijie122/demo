1:创建一个视图，包含20号部门的员工信息，字段:empno,ename,sal,job,deptno
create or replace view emp5_swj
as
select empno,ename,sal,job,deptno
from emp_shiweijie
where deptno=20

select * from emp5_swj


2:创建一个序列seq_emp_no,从10开始，步进为10
create sequence seq_emp5_swj_no
start with 10
increment by 10

3:编写SQL语句查看seq_emp_no序列的下一个数字
select seq_emp5_swj_no.nextval from dual

4:编写SQL语句查看seq_emp_no序列的当前数字
select seq_emp5_swj_no.currval from dual

5:为emp表的ename字段添加索引:idx_emp_ename 
create index idx_emp_shiweijie_ename on emp_shiweijie(ename)

drop index idx_emp_shiweijie_ename
6:为emp表的LOWER(ename)字段添加索引:idx_emp_lower_ename
create index idx_emp_shiweijie_ename on emp_shiweijie(lower(ename))


7:为emp表的sal,comm添加多列索引
drop index idx_emp_shiweijie_job_sal
create index idx_emp_shiweijie_job_sal on emp_shiweijie(job,sal)

8:创建myemployee表，字段:
  id NUMBER(4),
  nameVARCHAR2(20),
  birthday DATE,
  telephone VARCHAR2(11)
  scoreNUMBER(9,2)
  其中id作为主键，name要求不能为空,telephone需要唯一,score值必须>=0
  
create table myemployee_swj(
id number(4) primary key,
name varchar2(20) not null,
birthday date,
telephone varchar2(11) unique,
score number(9,2)
)
alter table myemployee_swj add constraint employee_swj_score_check check(score>=0)