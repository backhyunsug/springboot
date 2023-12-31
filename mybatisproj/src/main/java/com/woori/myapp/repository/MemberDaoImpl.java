package com.woori.myapp.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.MemberDto;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public boolean idCheck(MemberDto dto) {
		//selectOne - 스칼라쿼리, 데이터값 하나 가져올때 
		int cnt = sm.selectOne("Member_idcheck", dto);
		if( cnt==0)
			return true; //사용가능하다
		return false;
	}

	@Override
	public void insert(MemberDto dto) {
		//insert, delete, update 함수 셋다 동일한 일을 한다 
		sm.insert("Member_insert", dto);
		
	}

	@Override
	public MemberDto logon_proc(MemberDto dto) {
		//null 값 아니면 dto가 온다 
		//null 일때는 아이디가 존재안함 
		//null 이 아닐때 다시 판단을 해야 한다 
		return sm.selectOne("Member_logon", dto);
	}

}





