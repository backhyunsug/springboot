package com.woori.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.woori.myapp.dto.PersonDto;

//Controller -> 직접 Dao 컨택가능 
//           -> 테이블이 3개 이상 
//           -> 트랜잭션 처리를 하고자 할때 트랜잭션 처리를 컨트롤러에서 하게 되면 컨트롤러가 하는 일이 너무 많다
//           컨트롤러 => 서비스(트랜잭션처리등등 제반의 복잡한 가공작업) => 각각의 Dao 
//          1 컨트롤러 => 여러개의 서비스 => 각각의 서비스가 여러개의 Dao를 소유한다. 
@Repository
public class PersonDaoImpl implements PersonDao{

	List<PersonDto> perList=new ArrayList<PersonDto>();
	public PersonDaoImpl()
	{
		perList.add(new PersonDto(1, "홍길동", "010-0000-0001", "hong@ddd.com"));
		perList.add(new PersonDto(2, "임꺽정", "010-0000-0002", "lim@ddd.com"));
		perList.add(new PersonDto(3, "장길산", "010-0000-0003", "jang@ddd.com"));
		perList.add(new PersonDto(4, "일지매", "010-0000-0004", "lli@ddd.com"));
		perList.add(new PersonDto(5, "홍경래", "010-0000-0005", "hkl@ddd.com"));
	}
	
	@Override
	public List<PersonDto> getList() {
		
		return perList; //********************************************
	}

	@Override
	public void insert(PersonDto dto) {
		this.perList.add( dto );
	}

	@Override
	public PersonDto getView(int id) {
		
		return perList.get(id-1);
	}

}




