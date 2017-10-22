package oo.day03;
//T型与J型的测试类
public class TJTest {
	public static void main(String[] args) {
		Tetromino o1 = new T(2,5); //向上造型
		printWall(o1); //先造型后传值
		
		J o2 = new J(1,4);
		printWall(o2); //传值同时造型
	}
	
	//打墙+打T形
	public static void printWall(Tetromino t){
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				//效率低、扩展性好
				boolean flag = true; //1.假设打-
				for(int k=0;k<t.cells.length;k++){
					if(i==t.cells[k].row && j==t.cells[k].col){
						flag = false; //2.修改为打*
						break;
					}
				}
				if(flag){ //3.判断得结论
					System.out.print("- ");
				}else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	
}















