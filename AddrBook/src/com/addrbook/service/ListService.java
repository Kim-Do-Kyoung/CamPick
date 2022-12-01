package com.addrbook.service;

import com.addrbook.model.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ListService {
	public ArrayList<AddrDto> execute(HttpServletRequest request, HttpServletResponse response); 
}
