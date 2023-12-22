package com.cheonho.di.mimic05;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.google.common.reflect.ClassPath;

@Component class Car {
	@Autowired
	//@Resource
	Engine engine;
	@Autowired
	//@Resource
	Door door;
	
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", door=" + door + "]";
	}		
}
@Component class Truck extends Car {}
@Component class SportsCar extends Car {}
@Component 
class Engine {}
@Component class Door {}

class AppContext {
	Map map;		//객체 저장소 
	
	public AppContext() {
		map = new HashMap();
		doComponentScan();
		doAutowired();
		doResource();
	}
	
	private void doResource() {
		//map에 저장된 객체의 instance variable중에 @Autowired가 붙어 있으면
		for(Object bean : map.values()) {
			for(Field fld : bean.getClass().getDeclaredFields()) {
				//map에서  instance variable의 타입에 맞는 객체를 연결 (객체의 주소를 iv에 저장)
				if(fld.getAnnotation(Resource.class) != null)	//byName
					try {
						fld.set(bean, getBean(fld.getName()));  //car.engine = engine
					} catch (Exception e) {
						e.printStackTrace();
					} 
			}
		}
		
	}

	private void doAutowired() {
		//map에 저장된 객체의 instance variable중에 @Autowired가 붙어 있으면
		for(Object bean : map.values()) {
			for(Field fld : bean.getClass().getDeclaredFields()) {
				//map에서  instance variable의 타입에 맞는 객체를 연결 (객체의 주소를 iv에 저장)
				if(fld.getAnnotation(Autowired.class) != null)	//byType
					try {
						fld.set(bean, getBean(fld.getType()));  //car.engine = engine
					} catch (Exception e) {
						e.printStackTrace();
					} 
			}
		}
		
	}

	private void doComponentScan() {

		try {
			//1. 패키지내의 클래스 목록을 가져오기 
			ClassLoader classLoader = AppContext.class.getClassLoader();
			ClassPath classPath = ClassPath.from(classLoader);		
			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.cheonho.di.mimic05");
			
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
	
	public Object getBean(String key) {		//이름으로 찾기
		return map.get(key);
	}
	
	public Object getBean(Class clazz) {	//타입으로 찾기
		 for(Object obj : map.values()) {
			 if(clazz.isInstance(obj))		// obj instanceof clazz
				 return obj;
		 }
		 return null;
	}	
}

public class DIMimic05 {

	public static void main(String[] args) {
		AppContext ac = new AppContext();
		Car car =  (Car) ac.getBean("car");					//by Name으로 객체를 검색
		Engine engine = (Engine) ac.getBean("engine");		//by Name으로 객체를 검색
		Door door = (Door) ac.getBean(Door.class);			//by Type으로 객체를 검색 
		
		//수동으로 객체를 연결
//		car.engine = engine;
//		car.door = door;
		
		System.out.println("car = " + car);
		System.out.println("engine = " + engine);
		System.out.println("door = " + door);
	}
}
























