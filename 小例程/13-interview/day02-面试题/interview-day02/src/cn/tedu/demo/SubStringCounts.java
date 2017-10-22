package cn.tedu.demo;

public class SubStringCounts {
	public static void main(String[] args) {
		String str = "adfdasfdeasdfeasdfdfasfdasd";
		String child = "as";
		//统计子串在父串中出现的次数
		int start = 0;
		int counts = 0;
		
		while(str.indexOf(child, start)!=-1){
			int i = str.indexOf(child,start);
			counts++;
			start = i + child.length();
		}
		System.out.println("子串出现的次数是:"+counts);
	}
}
