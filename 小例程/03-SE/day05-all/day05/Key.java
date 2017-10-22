package day05;
/**
 * 作为HashMap中key元素的类若重写equals
 * 方法时的注意事项:
 * 文档有介绍,当需要重写一个类的equals方法时
 * 就应当连同重写hashcode方法.
 * 不妥善重写这两个方法可能会降低HashMap的查询
 * 性能.
 * 重写原则:
 * 1:成对重写,即:重写equals就重写hashcode
 * 2:一致性:当两个对象equals比较为true时,那么
 *   hashcode方法返回的数字必须相等.
 *   反过来虽然不是必须的,但是也尽量满足当两个
 *   对象hashcode值相等时,equals比较也为true.
 *   否则会在HashMap中出现链表,影响查询性能.
 * 3:稳定性:当一个对象参与equals比较的属性没有
 *   发生过变化的前提下,多次调用该对象的hashcode
 *   方法返回的数字必须相同.  
 * 
 * 
 * @author adminitartor
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}








