package oo.day04;
//格子类
public class Cell {
	int row; //行号
	int col; //列号
	Cell(int row,int col){
		this.row = row;
		this.col = col;
	}
	Cell(int n){
		this(n,n); //调用构造方法
	}
	Cell(){
		this(0,0);
	}
	
	void drop(){ //下落1格
		this.row++;
	}
	void moveLeft(int n){ //左移n格
		this.col-=n;
	}
	String getCellInfo(){ //获取行号和列号
		return row+","+col;
	}

	void drop(int n){ //下落n格
		row+=n;
	}
	void moveLeft(){ //左移1格
		col--;
	}
}












