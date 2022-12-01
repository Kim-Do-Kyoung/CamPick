package com.addrbook.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addrbook.model.AddrDto;

public interface InsertService {
	public boolean execute(HttpServletRequest request, HttpServletResponse response);
}
