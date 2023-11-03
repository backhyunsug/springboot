package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class IndexController {

	// http://www.daum.net ==>  http://127.0.0.1:9000
	@GetMapping("/")
	public String index(Model model) {
		//model 객체가 컨트롤러로부터 => html 값을 전달하는 객체이다. 
		System.out.println("********");
		model.addAttribute("myname", "홍길동"); //해쉬맵처럼
		//request.setAttribute 로 사용했다. 
		return "index";  //templates/index.html을 호출한다 
	}
	
	//http://127.0.0.1:9000/add?x=5&y=9
	@GetMapping("/add")
	public String add(Model model, int x, int y )
	{
		int result = x+y;
		
		model.addAttribute("x", x);   // {{x}}
		model.addAttribute("y", y);   // {{y}}
		model.addAttribute("result", result);
		
		return "add_result";  //templates/add_result.html 파일로 보낸다. 
	}
	
	//입력용 html문서를 화면의 띄운다.
	@GetMapping("/input")
	public String input() {
		return "input";
	}
	
	//변수를 int x, int y   class Data{int x, int y}  Data d
	//결과를 처리할 url처리 
	//input.html   <input name="x"
	@GetMapping("/output")
	public String output(Model model, int x, int y, int z ) {
		
		model.addAttribute("x", x);//model 객체 => Controller -> view로 값을 전달하는 객체
		model.addAttribute("y", y);
		model.addAttribute("z", z);
		
		return "output";
	}
}












