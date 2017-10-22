package day12;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文档
 * @author adminitartor
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 使用DOM解析XML的大致步骤:
		 * 1:创建SAXReader
		 * 2:使用SAXReader读取XML文档并生成
		 *   Document对象
		 *   这一步就是DOM解析耗时好资源的地方
		 *   因为要求先将XML文档所有内容读取
		 *   完毕(耗时),并将内容加载到内存中以
		 *   Document对象表示(耗资源)
		 * 3:通过Document获取根元素
		 * 4:根据文档结构从根元素开始逐级获取
		 *   子元素,以达到遍历XML文档数据的目的
		 */
		try {
			//1
			SAXReader reader = new SAXReader();
			//2
			Document doc = reader.read(
				new File("emplist.xml")
			);
			//3 获取根元素
			Element root = doc.getRootElement();
			/*
			 * Element的每一个实例用于表示XML
			 * 文档中的一个元素(一对标签)
			 * Element提供了获取元素信息的相关
			 * 方法:
			 * String getName()
			 * 获取元素的名字
			 * 
			 * Element element(String name)
			 * 获取当前元素中指定名字的子元素
			 * 
			 * List elements()
			 * 获取当前元素中所有子元素
			 * 
			 * List elements(String name)
			 * 获取当前元素中所有同名子元素
			 * 
			 * String getText()
			 * 获取当前元素中的文本信息
			 * 
			 * String elementText(String name)
			 * 获取当前标签中指定名字子标签中间
			 * 的文本信息
			 * 
			 * Attribute attribute(String name)
			 * 获取当前元素中指定名字的属性
			 * 
			 * 
			 */
//			String name = root.getName();
//			System.out.println(name);
			
			/*
			 * 将<list>标签中的所有<emp>标签
			 * 中的员工信息转换为若干Emp实例并
			 * 存入集合
			 */
			List<Element> eleList = root.elements();
			List<Emp> empList = new ArrayList<Emp>();
			
			for(Element empEle : eleList){
				//获取name
				Element nameEle = empEle.element("name");
				String name = nameEle.getText();
				System.out.println(name);
				
				//获取age
				int age = Integer.parseInt(
					empEle.elementText("age")
				);
				
				String gender 
					= empEle.elementText("gender");
				
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				//获取id属性
				Attribute attr = empEle.attribute("id");
//				attr.getName();//获取属性名
				int id = Integer.parseInt(
					attr.getValue()//获取属性值
				);
				
				Emp emp = new Emp(id, name, age, gender, salary);
				empList.add(emp);
			}
			
			System.out.println("解析完毕!");
			for(Emp e : empList){
				System.out.println(e);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}









