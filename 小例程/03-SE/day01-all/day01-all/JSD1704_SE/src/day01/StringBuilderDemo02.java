package day01;
/**
 * Stringbuilder API 演示 
 */
public class StringBuilderDemo02 {
	public static void main(String[] args) {
		StringBuilder buf = 
			new StringBuilder();
		/**
		 * 利用StringBuilder API编辑字符串
		 */
		buf.append("李洪鹤");
		buf.append("是");
		buf.append("一位诗人！");
		buf.insert(4, "现代主义");
		buf.delete(8, 8+2);
		buf.replace(1, 1+2, "老湿");
		System.out.println(buf);
	}
}






