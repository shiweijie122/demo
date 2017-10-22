package oo.day02;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
		Cell c1 = new Cell();
		Cell c2 = new Cell(3);
		Cell c3 = new Cell(2,5);
		
		
		/*
		Cell c = new Cell();
		c.row = 2;
		c.col = 5;
		c.drop(); //下落1格
		c.drop(3); //下落3格
		c.moveLeft(); //左移1格
		c.moveLeft(2); //左移2格
		printWall(c);
		*/
	}
	
	//打墙+打格
	public static void printWall(Cell cc){
		for(int i=0;i<20;i++){ //行
			for(int j=0;j<10;j++){ //列
				if(i==cc.row && j==cc.col){ //行列匹配
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println(); //换行
		}
	}
	
}













