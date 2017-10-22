package day12;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPath检索XML文档数据
 * @author adminitartor
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			
			
			String xPath 
				= "/list/emp[salary>7000 and gender='女']/name";
			List<Element> list 
				= doc.selectNodes(xPath);
			for(Element e : list){
				System.out.println(e.getText());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



