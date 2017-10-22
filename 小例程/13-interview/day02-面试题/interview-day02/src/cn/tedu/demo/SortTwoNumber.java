package cn.tedu.demo;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * 将一个只有0和1组成的数组进行排序,实现0在前,
 * 1在后
 * @author adminitartor
 *
 */
public class SortTwoNumber {
	public static void main(String[] args) throws FileNotFoundException {
		int[] ary = {0,1,1,0,0,0,1,1,0,1,0,1};
		int index = 0;
		
		for(int i=0;i<ary.length;i++){
			if(ary[i]==0){
				ary[i] = 1;
				ary[index++] = 0;
			}
		}
	
		System.out.println(Arrays.toString(ary));
	}

}
