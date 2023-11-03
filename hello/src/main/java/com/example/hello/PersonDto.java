package com.example.hello;

//Dto - Data transfer object 
//테이블에 데이터를 넣거나 가져오거나한다. 보통은 하나의 테이블당 하나의 Dto를 만든다
//join의 경우는 join 이 되는 항목을 다 가져와야 한다. 그래서 여려개의 테이블로부터 
//Dto 가 만들어진다. read-only 접미어로 VO를	붙인다. readonly -vo를 붙이고 
//읽고쓰기용으로 사용하는 클래스의 경우에는 DTO를 붙인다. 
//그러나 대부분의경우는 DTO붙입시다 그럼 DTO붙이면 되고 VO붙입시다 VO붙입시다
public class PersonDto {
	private int id=1;
	private String name="";
	private String phone="";
	private String email="";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//생성자만들때 주의사항- 매개변수가 있는 생성자를 만들면 시스템이 만들던기본생성자를 
	//안만든다. 어디선가 개체 생성을 할때 PersonDto dto = new PersonDto();
	public PersonDto(int id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public PersonDto() {
		super();//부모생성자 호출한다 
	}
	
	
	
	
	
}
