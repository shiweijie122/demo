package day03;
//分支结构的演示
public class IfDemo {
	public static void main(String[] args) {
		int num = 2;
		switch(num){ //byte,short,int,char
		case 1: //if(num==1)
			System.out.println(111);
			break;
		case 2: //以此为入口
			System.out.println(222);
			break; //跳出switch
		case 3:
			System.out.println(333);
			break;
		default: //所有case都未匹配时执行
			System.out.println(666);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int num = 5;
		if(num%2==0){
			System.out.println(num+"是个偶数");
		}
		System.out.println("over");
		*/
	}
}















