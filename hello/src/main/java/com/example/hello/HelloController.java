package com.example.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Controller  - view 엔진이있다. jsp나 mustache나 또는 thymeleaf 라도
 *               View엔진과 모델을 연결하기 위해 사용한다  
 * RestController -> 결과값을 브라우저에 출력한다. 
 *               restful api server구축용, view엔진하고 상관없다. 
 *  POJO - Plain Old and Java Object(기존에 사용하던 자바클래스를
 *  그대로 사용한다.) 어노테이션                 
 */
@RestController 
public class HelloController {
	//함수를 만들고 이 함수를 웹의 url과 연동하고 싶다
	//GetMapping("url"), PostMapping, RequestMapping
	@GetMapping("/")
	public String hello() {
		return "Hello Spring boot";
	}
	
	//ctrl-shift-o : 한번에 여러개 import시 
	//http://127/.0.0.1:9000/userinfo 
	@GetMapping("/userinfo")
	public HashMap<String, Object> getUserInfo()
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Tom");
		map.put("age", 23);
		map.put("phone", "010-0000-0001");
		
		return map;
	}
	
	//[{"name":"홍길동","age":22} ....] , 임꺽정 12  장길산 23 
	//http://127/.0.0.1:9000/person 

	@GetMapping("/person")
	public List<HashMap<String, Object>> getPerson()
	{
		//List - 추상클래스, 인터페이스 객체를 못만든다.  ArrayList:클래스, 객체 생성가능
		//Map(추상클래스) - 객체생성못함,      HashMap:클래스
		//List<String> list = new ArrayList<String>();
		List<HashMap<String, Object>> list 
		            = new ArrayList<HashMap<String, Object>>();
	
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "홍길동");
		map.put("age", 22);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "임꺽정");
		map.put("age", 12);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "장길산");
		map.put("age", 12);
		list.add(map);
		
		return list; 
	}
	
	@GetMapping("/person2")
	public List<PersonDto> getPerson2()
	{
		List<PersonDto> list = new ArrayList<PersonDto>();
		list.add( new PersonDto(1, "홍길동", "010-0000-0000", "hong@aa.com"));
		list.add( new PersonDto(2, "임꺽정", "010-0000-0001", "lim@aa.com"));
		list.add( new PersonDto(3, "장길산", "010-0000-0002", "jang@aa.com"));
		
		return list;
	}	
}










