#JAVA基础部分-选择题

#### (单选)1.在Java语言中，字符串“Java程序员”在内存中所占用的字节数是：（）。

A.10

B.7

C.13

D.14


####2. (单选)下列表达式中，可以得到精确结果的是（）。
A.double d1 = 3.0 - 2.6;

B.double d4 = 2.5 * 1.5;

C.double d2 = 30/300;

D.double d3 = 1/2 + 0.5;


#### 3.(多选)所谓“水仙花”数是一个整数等于各位数字立方的和，例如：153 = 1*1*1+5*5*5+3*3*3，下面的程序用于输出2~1000内的水仙花数：  

	for (int n = 2; n <= 1000; n++) { 
        空白处  
        if (s == n) { 
        	System.out.println(n); 
        } 
    }  
 下列选项中，空白处可以填入的代码是：（）。
A.int s = 0, &emsp;n1 = n; &emsp;while (n1 > 0) { int t = n1 % 10;&emsp; s += t * t * t; &emsp;n1 /= 10; }

B.int s = 0,&emsp; n1 = n; &emsp;while (n1 > 0) { int t = n1 / 10;&emsp;s+= t * t * t; &emsp;n1 %= 10; }

C.int s = 0; &emsp;for(int n1 = n; n1>0;&emsp; n1 /= 10) { int t = n1%10;&emsp; s += t \* t \* t; }

D.int s = 0;&emsp; for(int n1 = n;&emsp; n1>0; &emsp;n1 %= 10) { int t = n1 / 10;&emsp; s += t \* t \* t; }


#### 4.下列语句序列执行后，k 的值是 (       )
      int  x=6, y=10, k=5;
      switch( x % y )
      {
           case 0:  k=x*y;
           case 6:  k=x/y;
           case 12:  k=x-y;
           default:  k=x*y-x;
      }

A.60

B.5

C.0

D.54

#### 5.设 a = 8，则表达式  a >>> 2 的值是： （无符号右移动）(      )

A.1

B.2

C.3

D.4


#### 6.下列程序
	class Test{
    	public static void main(String[] args){
        	doSomething(1);
            doSomething(1,2);
        }
        //insert code here
    }

在程序中插入下列哪一行代码可以编译通过：
A static void doSomething(int[] args){}

B static void doSomething(int... args){}

C static coid doSomething(int...args,int x){}

D static void doSomething(int x,int...args){}


#简答题

#### 1.现有一个长度为20的数组，数组内的数字0-9之间的任意数字，统计出数组中每个元素出现的次数？

####现有一个字符串"fdasafdasfdasa",现统计出子串"as"出现的次数.




#### 2.请描述冒泡排序算法的基本思想。


#### 3.一个数组中只有0，1两种数字，进行排序，0全部在前，1全部在后

#OOP部分

####1.(单选)关于下列代码说法正确的是： 

    public class A {
        private int counter = 0; 
        public static int getInstanceCount() { 
        	return counter; 
        } 
        public A() { 
        	counter++; 
        } 
        public static void main(String[] args) { 
            A a1 = new A(); 
            A a2 = new A(); 
            A a3 = new A();
            System.out.println(A.getInstanceCount()); 
        } 
    }

A.该类编译失败

B.输出：1

C.输出：3

D.输出：0


#### 2.试图编译和运行以下代码，将获得什么结果(JAVA)

	class Base {
		int i = 99;
		public void amethod() {
	        System.out.println("Base.amethod()");
	    }
	    Base() {
	    	amethod();
	    }
	}
	public class RType extends Base {
		int i = -1;
	    public static void main(String argv[]){
	    	Base b = new RType();
	    	System.out.print(b.i+"\t");
	    	b.amethod();
			RType r = (RType)b;
	    	System.out.print(r.i+"\t");
	    }
	    public void amethod(){
	        System.out.print("RType.amethod()"+"\t");
	    }
	}

A RType.amethod	-1	RType.amethod	-1

B RType.amethod	99	RType.amethod	-1

C 99 RType.amethod	99

D 编译时错误(Compile time error)


#### 3、下边程序运行的结果是？ (        )
    class Base {
     Base() { System.out.print("Base"); }
    }
    public class Alpha extends Base {
       public static void main( String[] args ) {
            new Alpha();
            new Base();
      }
     }

A.Base

B.BaseBase

C.程序编译失败.

D.程序运行但没有任何输出


#### 4.指出下列程序运行的结果
     public class Example{
         String str=new String("good");
         char[]ch={'a','b','c'};
         public static void main(String args[]){
             Example ex=new Example();
             ex.change(ex.str,ex.ch);
             System.out.print(ex.str+" and ");
             System.out.print(ex.ch);
         }
         public void change(String str,char ch[]){
             str="test ok";
             ch[0]='g';
         }
     }
A.good and abc

B.good and gbc

C.test ok and abc

D.test ok and gbc


#OOP部分-简答题


#### 1.抽象类和接口的区别

#### 2.静态变量和实例变量的区别？

#### 3.String s = new String("xyz");创建了几个String Object ？

#### 4．字符串连接时为什么推荐使用StringBuffer而不是直接用String+String的方式，请简述原因？

#### 5.final, finally, finalize的区别。

####6.线程

继承Thread类 
	如果某个类继承了Thread类,那么此时这个类就是一个线程类,如果要创建此类的线程对象  A extends Thread
	A a = new A();
	a.start()
		

实现Runnable接口
	如果某个类实现了Runnable接口,此时这个类不是线程类,这个类中只有将线程要执行的任务写好了
	
	如果此时用用线程来执行这个任务
	A implements Runnable
	A a = new A();
	//创建一个线程对象指向该任务
	Thread th = new Thread(Runnable r,name);
	th.start()

生命周期:5种状态
	
新建,就绪,运行,阻塞,死亡

多线程并发问题:

脏数据:污染了数据
-前提条件:多个线程访问同一个对象

如何避免脏数据的产生:线程同步 - synchronized

可以用来修饰方法,代码块:本质是给对象加锁

如果修饰方法:给调用方法的对象(this)加锁

如果修饰代码块:
	sychronized(要加锁的对象){}
	一般情况下,加锁的对象都为this

线程间的通信 - 线程间要交流

生产者消费者

Object类下的几个方法来实现了线程间的通信
	
wait() :一定出现在sychronized的方法中

notify()  notifyAll()

线程池:

Excutors.newFixedThreadPool(int nThread) - ExcutorService 

execute()

ThreadLocal:将数据绑定到当前线程上,那么在整个线程过程中都可以使用该数据

IO流:
RandomAccessFile:随机访问流(任意访问流)

特殊之处:

1.这个流既可以读文件,也可以写文件

2.可以定位到文件的任意位置,而且可以获取当前的偏移量

RandomAccessFile(File dest,String mode)

read()   write() - 按照字节

seek(long pos)

getFilePointer() - long


#数据库部分-选择题


####1.当在执行过程中，如果QUANTITY的值是空的话，哪个语句将显示一个0？

A.SELECT id_number,100/quantity FROM inventory;

B.SELECT id_number,NVL(100/quantity,0) FROM inventory;

C.SELECT id_number,NULL(100/quantity,0) FROM inventory;

D.SELECT id_number,TO_CHAR(100/quantity,0) FROM inventory;


####2.分析下面SQL语句，在什么情况下引起这个语句失败？STUDEN表结构：ID NUMBER(9) FIRST_NAME VARCHAR2(25) LAST_NAME VARCHAR2(25)
    SELECT * FROM student WHERE id=
    (SELECT id FROM student WHERE UPPER(first_name)='KATE' AND UPPER(last_name)='HENRY');

A.在数据表中没有学生的名字是Kate Henry

B.数据表中学生的名字叫Kate的多于一个

C.数据表中的学生的名字叫Kate Henry的多于一个

D.FIRST_NAME和LAST_NAME的值在数据库中是小写的


####3.分析下面的SQL语句，这个语句为什么会出现一个错误？

	CREATE TABLE sale_items(id_number NUMBER(9),description VARCHAR(25))
	 AS SELECT id_number,description FROM inventory WHERE quantity>500;
A.一个子句丢失

B.一个关键字丢失

C.where子句不能应用在创建表上

D.数据类型在新表中不需要被定义


#### 4.在SQL语言中，关于主键描述正确的是（）（多选）
A 只能包含一列

B 可以包含两列

C 可以包含一列或者多列

D 以上都不正确


#数据库简答题

####1.写SQL语句显示员工表中工资超过平均工资的员工。

####2.假如订单表orders用来存储订单信息，cid代表客户编号，money代表单次订购额，现要查询每个客户的订购次数和每个客户的订购总金额？

#### 统计单笔消费超过50元的用户总共的消费次数以及消费总金额,总金额>2000

####3. 表PERSONNEL 的结构如下:
    ID NUMBER(9)
    NAME VARCHAR2(25)
    MANAGER_ID NUMBER(9)

在这里, 部门的管理者也看作是雇员，写出SQL语句查询每个雇员的姓名以及管理者的姓名


#### 4.ORACLE数据库有哪几种约束类型？


#### 5.请分别写出mysql与oracle的分页查询语句（查询第3-第7条数据）


####6.写一个查询，来查询出挣到佣金(comm)的雇员姓名ename,部门名称，和部门所处的位置loc。（有employ表和dept表）

####7.写一个查询，查出在名字里面有一个"A"的所有雇员姓名ename和其所在的部门loc的名称。

####8．显示所有薪金高于各自部门平均薪金的人？

####9.查询平均成绩大于60分的同学的学号和平均成绩；


#Servlet部分 

####1.JSP九大内置对象，Servlet域对象以及各自的作用范围


####2.说出Servlet的生命周期？


####5.请简述mvc架构。同时说明在自己熟悉的架构中mvc分别对应什么？

#框架部分

####1.请描述一下spring MVC工作原理。


####2.Spring的核心是什么？

