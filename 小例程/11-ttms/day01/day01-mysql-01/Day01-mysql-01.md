# MySQL 是什么?
  
1. 软件(输入,存储,处理,输出)
2. 基于C/S架构(client,server,tcp/ip)
3. 关系型数据库管理系统(RDBMS):数据及数据之间的关系

# MySQL 应用场景及相关版本?


1. 中小型企业数据的存储及管理
2. 互联网企业数据的存储及管理

   >相关版本:商业版,社区版

   目前我们使用的是MySQL社区版(5.1.7)


# MySQL 安装与卸载?(自学)

# MySQL 登录与退出?

  登录:mysql -u root -p  (只能应用于本机数据库)
  退出:quit

  扩展(访问远端数据): mysql -u 'tedu'@'192.168.100.102' -p
  扩展(查看数据库状态):status

# MySQL 数据库操作?
  查看当前用户下数据库? 
  show databases;
  创建数据库
  create database jsd1704;
  create database jsd1704  character set utf8;

  打开数据库
  use jsd1704

  删除数据库
  drop database jsd1707;

  > 在查看或操作数据库中的表时首先应先打开数据库.
  > 如何查看当前正在使用的数据库? select database()
  
   
# MySQL 数据表操作?
  
  创建表：
  create table student(
     id int primary key auto_increment,
     name varchar(50) not null
     
  );
　 删除表:
  drop table student;

# MySQL 数据操作?

  查询表中数据
  select * from student;
  插入数据
  insert into student values (.....)
  修改数据
　　update student set name='AAAAA' where id=1;
  删除数据
　　delete from student where id=1;

  ..........

# MySQL 中帮助文档？

　记住:? (等价于help)




