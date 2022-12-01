package com.addrbook.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addrbook.model.AddrDao;
import com.addrbook.model.AddrDto;

public class ListServicempl implements ListService{
	private AddrDao addrDao;
	
	public ListServicempl() {
//		addrDao = AddrDao.getInstance(); //싱글톤 인스턴스 가지고오는
	}
	@Override
	public ArrayList<AddrDto> execute(HttpServletRequest request, HttpServletResponse response) {
		return addrDao.getDBList(); 
	}

}
