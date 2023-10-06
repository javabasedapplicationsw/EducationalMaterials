package kr.co.himedia.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//Class c = Class.forName("java.lang.string");
		
		//Class c = Class.forName("java.lang.String");
		
		Class c = Class.forName("kr.co.himedia.object.Student");
		
		Constructor<String>[] cons = c.getConstructors();
		for(Constructor con : cons)
			System.out.println(con);
		
		System.out.println();
		
		Method[] methods = c.getMethods();
		for(Method method : methods)
			System.out.println(method);
	}
}














