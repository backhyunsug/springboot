package com.example.hello;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveController {

	//add?x=5&y=7
	@GetMapping("/add")
	public String add(int x, int y)
	{
		int result = x+y;
		return String.format("%d + %d = %d", x, y, result);
	}
	
	//add2/5/7
	@GetMapping("/add2/{x}/{y}")
	public String add2(@PathVariable("x")int x, @PathVariable("y")int y)
	{
		int result = x+y;
		return String.format("%d + %d = %d", x, y, result);
	}
	
	//문제1. gugu/4
	//문제2. gugu2?dan=4
	
	@GetMapping("/gugu/{dan}")
	public String gugu(@PathVariable("dan")int dan)
	{
		
		//String s = "a" + "b" + "c"
		StringBuffer buffer = new StringBuffer();
		for(int i=1; i<=9; i++)
		{
			buffer.append(String.format("%d X %d = %d<br/>", dan, i, dan*i) );
		}
		return buffer.toString();
	}
	
	@GetMapping("/gugu2")
	public String gugu2(int dan)
	{
		
		//String s = "a" + "b" + "c"
		StringBuffer buffer = new StringBuffer();
		for(int i=1; i<=9; i++)
		{
			buffer.append(String.format("%d X %d = %d<br/>", dan, i, dan*i) );
		}
		return buffer.toString();
	}
	/*
	 * 
	 * 멀티스레드 - 프로세스를 작은 조각으로 만든다. (각 조각이 스레드가 될 수 있다)
	 * 자바의 경우에는 Thread  라는 클래스를 상소받거나 Runnable 인터페이스를 구현하 
	 * 는 경우가 있다. 네트워크를 사용하거나 용량이 엄청 큰파일을 읽거나 디비데이터를 처리할때 
	 * 스레드를 사용한다. 멀티스레드는 하나의 프로세를 쪼개서 사용한다 
	 * 그래서 동일한 자원(변수)에 동시에 접근하는 문제 동시성문제 동기화문제
	 * 스레드 안정성 , 동기화를 지원해야 한다.   동기원지원안한다. - 스레드 안정성이 떨어진다. 
	 * 그래서 그런 클래스는 사용을 피하자. StringBuffer가 더 좋다 
	 * HashTable => HashMap 
	 * 
	 * */
	
	/*
	 *  x-www-form-urlencoded : form태그에 post 방식으로 보낼때
	 *  form-data : form 태그에 post , enctype="multipart/form-data" 
	 *              파일태그가 작동을 하고 spring 에서는 request객체가 아니고 
	 *              별도이 multipartrequest객체가 따로 있다 
	 *  raw - jso형식 
	 */
	
	@PostMapping("/add_post")
	public String add_post( int x, int y)
	{
		return String.format("%d + %d = %d", x, y, x+y);
	}
	
	//post방식은 html페이지를 만들어서 post 전송을 하거나 별도의 툴 도움을 받아야 한다 
	//curl :윈도우, 리눅스 둘다 가능하다. 엄청긴문장으로 
	//postman, insomnia 

	@PostMapping("/add_json")//자바스크립틔 fetch, axios  라이브러리 
	public String add_json( @RequestBody HashMap<String, String>map)
	{
		int x = Integer.parseInt(map.get("x"));
		int y = Integer.parseInt(map.get("x"));
		
		return String.format("%d + %d = %d", x, y, x+y);
	}
	
	@PostMapping("/score_json")//자바스크립틔 fetch, axios  라이브러리 
	public HashMap<String, Object> score_json( @RequestBody HashMap<String, String>map)
	{
		HashMap<String, Object> resultMap= new HashMap<String, Object>();
		
		resultMap.put("name", map.get("name"));
		resultMap.put("kor", map.get("kor"));
		resultMap.put("eng", map.get("eng"));
		resultMap.put("math", map.get("math"));
		
		int total = Integer.parseInt(map.get("kor")) 
				     + Integer.parseInt(map.get("eng"))
				     + Integer.parseInt(map.get("math"));
		int avg = total/3;
		
		resultMap.put("total", total);
		resultMap.put("avg", avg);
			
		return resultMap;
	}
	
	@PostMapping("/trade_json")//자바스크립틔 fetch, axios  라이브러리 
	public HashMap<String, Object> trade_json( @RequestBody HashMap<String, Object>map)
	{
		String trade_id = map.get("trade_id").toString();
		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> list = 
				(List<HashMap<String, Object>>)map.get("trade");
		int total=0;
		for(int i=0; i<list.size(); i++)
		{
			total += Integer.parseInt(list.get(i).get("payment").toString()); 
			System.out.println(list.get(i).get("payment"));
		}
		
		map.put("sum", total);
		return map;
	}
	 
}





