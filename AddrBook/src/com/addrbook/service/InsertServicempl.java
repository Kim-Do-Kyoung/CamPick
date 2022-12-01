package com.addrbook.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addrbook.model.AddrDao;
import com.addrbook.model.AddrDto;

public class InsertServicempl implements InsertService{
	private AddrDao addrDao;
	
	public InsertServicempl(){
		
	}
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		return addrDao.insertDB((AddrDto)request.getAttribute("insAddr"));
	}
	
}
