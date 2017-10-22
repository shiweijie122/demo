package cn.tedu.demo;
/**
 * 统计某个int数组中元素出现的次数
 * @author adminitartor
 *
 */
public class CountAryEle {
	public static void main(String[] args) {
		int[] dest = {0,1,2,3,1,2,8,9,0,3};
		int[] ary = new int[10];
		
		for(int i:dest){
			ary[i]++;
		}
		
		for(int j=0;j<ary.length;j++){
			System.out.println("元素"+j
					+"出现的次数是:"+ary[j]);
		}
	}
}
