package day04;
//for的演示
public class ForDemo {
	public static void main(String[] args) {
		
		int sum = 0;
		for(int num=1;num<=100;num++){
			//累加1到100的和，只要个位不得3的
			if(num%10!=3){
				sum += num;
			}
		}
		System.out.println("sum="+sum);
		
		
		
		/*
		int sum = 0;
		for(int num=1;num<=100;num++){
			//累加1到100的和，跳过个位为3的
			if(num%10==3){
				continue;
			}
			sum += num;
		}
		System.out.println("sum="+sum);
		*/
		/*
		 * sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 
		 * num=4 sum=1+2+4
		 * ...
		 * num=13
		 * num=23
		 * num=33
		 * num=43
		 * ...
		 * num=93
		 */
		
		
		
		
		
		
		
		/*
		int sum = 0;
		int num = 1;
		for(;num<=100;num++){
			sum += num;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0;
		for(int num=1;num<=100;){
			sum += num;
			num++;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		for(;;){ //死循环
			System.out.println("我要学习...");
		}
		*/
		
		/*
		for(int i=1,j=6;i<6;i+=2,j-=2){
		}
		*/
		/*
		 * i=1,j=6 true
		 * i=3,j=4 true
		 * i=5,j=2 true
		 * i=7,j=0 false
		 */
		
		
		
		
		
		
		/*
		//累加:1+2+3+4+5+...+99+100=?
		int sum = 0; //和
		for(int num=1;num<=100;num++){
			sum += num;
		}
		System.out.println("sum="+sum);
		*/
		/*
		 *       sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 sum=1+2+3
		 * num=4 sum=1+2+3+4
		 * ...
		 * num=100 sum=1+2+3+4+...+100
		 * num=101
		 */
		
		
		
		
		
		
		
		
		
		
		/*
		for(int times=0;times<10;times++){
			System.out.println("行动是成功的阶梯");
		}
		System.out.println("over");
		
		for(int num=1;num<=9;num++){
			System.out.println(num+"*9="+num*9);
		}
		System.out.println("over");
		*/
	}
}














