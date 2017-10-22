package oo.day04;
//四格拼板
public class Tetromino {
	Cell[] cells; //格子数组
	Tetromino(){
		cells = new Cell[4]; //创建格子数组对象
	}
	
	void drop(){ //下落
		for(int i=0;i<cells.length;i++){
			cells[i].row++;
		}
	}
	void moveLeft(){ //左移
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){ //右移
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){ //输出四个格子的行列号
		for(int i=0;i<cells.length;i++){
			String str = cells[i].getCellInfo();
			System.out.println(str);
		}
	}
	
}


















