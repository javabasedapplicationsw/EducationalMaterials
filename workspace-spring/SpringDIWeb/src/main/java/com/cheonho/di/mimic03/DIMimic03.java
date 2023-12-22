package com.cheonho.di.mimic03;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

@Component class Car {}
@Component class Truck extends Car {}
@Component class SportsCar extends Car {}
//@Component 
class Engine {}

class AppContext {
	Map map;		//객체 저장소 
	
	public AppContext() {
		map = new HashMap();
		doComponentScan();
	}

	private void doComponentScan() {

		try {
			//1. 패키지내의 클래스 목록을 가져오기 
			ClassLoader classLoader = AppContext.class.getClassLoader();
			ClassPath classPath = ClassPath.from(classLoader);		
			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.cheonho.di.mimic03");
			
			//2. 반복문으로 클래스를 하나씩 읽어와서 @Component이 붙어 있는지 확인 
			for(ClassPath.ClassInfo classInfo : set) {
				Class clazz = classInfo.load();
				
				//3. @Component가 붙어있으면 객체를 생성해서 map에 저장 
				Component component = (Component) clazz.getAnnotation(Component.class);
				if(component != null) {
					String id = StringUtils.uncapitalize(classInfo.getSimpleName());
					map.put(id, clazz.newInstance());
				}
				
			}
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getBean(String key) {
		return map.get(key);
	}
}

public class DIMimic03 {
	public static void main(String[] args) {
		AppContext ac = new AppContext();
		Car car = (Car) ac.getBean("car");
		Engine engine = (Engine) ac.getBean("engine");
		
		System.out.println("car = " + car);
		System.out.println("engine = " + engine);
	}
}




















