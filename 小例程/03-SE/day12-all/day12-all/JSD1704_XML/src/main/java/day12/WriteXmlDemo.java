package day12;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM生成XML文档
 * @author adminitartor
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		List<Emp> empList 
			= new ArrayList<Emp>();
		
		empList.add(new Emp(1,"张三",22,"男",5000));
		empList.add(new Emp(2,"李四",23,"女",6000));
		empList.add(new Emp(3,"王五",24,"男",7000));
		empList.add(new Emp(4,"赵六",25,"女",8000));
		empList.add(new Emp(5,"钱七",26,"男",9000));
		
		/*
		 * 使用DOM生成XML文档的大致步骤
		 * 1:创建Document对象
		 * 2:向Document对象中添加根元素
		 * 3:按照XML文档应有的结构从根元素
		 *   开始逐级添加子元素
		 * 4:创建XmlWriter
		 * 5:通过XmlWriter将Document对象写出
		 *   来形成XML文档
		 * 6:关闭XmlWriter    
		 */
		try {
			//1
			Document doc = DocumentHelper.createDocument();
			
			/*
			 * 2
			 * Document提供添加根元素的方法
			 * Element addElement(String name)
			 * 添加指定名字的根元素.并将它以Element
			 * 形式返回,以便继续对根元素操作.
			 * 需要注意,该方法只能调用一次,因为一个
			 * 文档中只能有一个根元素.
			 */
			Element root = doc.addElement("list");
			
			//3
			for(Emp emp : empList){
				//将每个Emp员工信息作为<emp>插入到根元素
				/*
				 * Element提供了用于追加信息的相关方法
				 * 
				 * Element addElement(String name)
				 * 向当前元素中追加指定名字的子元素,并将其
				 * 返回.
				 * 
				 * Element addText(String text)
				 * 向当前元素中添加文本信息
				 * 
				 * Element addAttribute(String name,String value)
				 * 向当前元素中追加指定名字及对应值的属性
				 */
				Element empEle = root.addElement("emp");
				//添加<name>
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");
				
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				
				empEle.addAttribute("id", emp.getId()+"");
			}
			
			//4
			FileOutputStream fos
				= new FileOutputStream("myemp.xml");
			XMLWriter writer = new XMLWriter(
				fos,OutputFormat.createPrettyPrint()
			);
			
			//5
			writer.write(doc);
			System.out.println("写出完毕!");
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}







