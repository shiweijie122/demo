package oo.day04;
//J型类
public class J extends Tetromino {
	J(){
		this(0,0);
	}
	J(int row,int col){
		cells[0] = new Cell(row,col);
		cells[1] = new Cell(row+1,col);
		cells[2] = new Cell(row+2,col-1);
		cells[3] = new Cell(row+2,col);
	}

	void print(){ //输出四个格子的行列号
		System.out.println("I am a J:");
		super.print();
	}
}











