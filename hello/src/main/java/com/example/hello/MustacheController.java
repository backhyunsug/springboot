package com.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//View엔진과 연동하려면 
@Controller 
public class MustacheController {

	
	//함수들이 String 으로 리턴 => View엔진에 있는 파일과 연동이 된다.
	@GetMapping("/mustache1")
	public String mustache1() {
		
		return "mustache1";  //templates mustache1.mustache
		//설정파일(application.properties)에서 나는 머스티치 엔진을 사용할거고 
		//파일확장자가 html => mustache 로 받아들이겠다. 
	}
	
	//  /myname => myname.html 
}
