<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp" import="java.util.*,com.addrbook.model.*"%>
<jsp:useBean id="datas" scope="request" class="java.util.ArrayList"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="addrbook/addrbook.css" type="text/css" media="screen"/>
<meta charset="UTF-8">
<title>주소록:목록화면</title>
</head>
<body>
	<div align="center">
		<h2>주소록:목록화면</h2>
		<hr>
		<form>
			<a href="addrbook/addrbook_form.jsp">주소록 등록</a><p>
			
			<table border=1>
				<tr bgcolor="#99CCFF">
					<th>번호</th><th>이 름</th><th>전화번호</th><th>생 일</th>
					<th>회 사</th><th>메 모</th>
				</tr>
					<%
					for(AddrDto  ab : (ArrayList<AddrDto>)datas){
					%>
				<tr>
					<td><a href="javascript:check(<%=ab.getAb_id()%>)"><%=ab.getAb_id()%></a>
					
					<td><%=ab.getAb_name() %></td>
					<td><%=ab.getAb_tel() %></td>
					<td><%=ab.getAb_birth() %></td>
					<td><%=ab.getAb_comdept() %></td>
					<td><%=ab.getAb_memo() %></td>
				</tr>
					<%
						}
					%>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function check(ab_id) {
			pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
			document.location.href = "/AddrBook/edit.do?&ab_id="+ab_id+"&upasswd="+pwd;
		}
	</script>
</body>
</html>