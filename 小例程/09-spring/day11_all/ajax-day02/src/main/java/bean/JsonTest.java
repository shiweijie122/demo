package bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	/**
	 * 如何将java对象转换成json字符串。
	 * @throws JsonProcessingException 
	 */
	public static void test1() 
			throws JsonProcessingException{
		Stock s = new Stock();
		s.setCode("600877");
		s.setName("中国嘉陵");
		s.setPrice(5);
		//使用jackson　api来做转换。
		ObjectMapper om = 
				new ObjectMapper();
		String str = 
				om.writeValueAsString(s);
		System.out.println(str);
		
	}
	
	/**
	 * 如何将多个对象组成的集合或者数组
	 * 转换成json字符串
	 * @throws JsonProcessingException 
	 */
	public static void test2() throws JsonProcessingException{
		List<Stock> stocks = 
			new ArrayList<Stock>();
		for(int i = 0; i < 3; i ++){
			Stock s = new Stock();
			s.setCode("60087" + i);
			s.setName("中国嘉陵" + i);
			s.setPrice(5 + i);
			stocks.add(s);
		}
		//使用jackson api来转换
		ObjectMapper om = 
			new ObjectMapper();
		String str = 
			om.writeValueAsString(stocks);
		System.out.println(str);
	}
	
	public static void main(String[] args) throws JsonProcessingException {
			test2();
	}
	

}
