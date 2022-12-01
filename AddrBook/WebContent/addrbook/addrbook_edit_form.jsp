<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook/addrbook_error.jsp" import="com.addrbook.model.*" %>
    
<jsp:useBean id="gb" scope="request" class="com.addrbook.model.AddrDto"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="addrbook.css" type="text/css" media="screen"/>
<meta charset="UTF-8">
<title>주소록:수정화면</title>
</head>
<body>
	<div align="center">
		<h2>주소록:수정화면</h2>
		<hr>
		[<a href=index.jsp>주소록 목록으로</a>]<p>
		<form name=form1 method="post" action="addrbook_control.jsp">
			<input type=hidden name="ab_id" value="<%=gb.getAb_id() %>">
			<input type=hidden name="action" value="update">
			
			<table border=1>
				<tr>
					<th>이 름</th>
					<td><input type=text name=ab_name value="<%=gb.getAb_name() %>">
				</td>
				<tr>
					<th>email</th>
					<td><input type=email name=ab_email value="<%=gb.getAb_email() %>">
				</td>
				<tr>
					<th>전화번호</th>
					<td><input type=tel name=ab_tel value="<%=gb.getAb_tel() %>">
				</td>
				<tr>
					<th>생 일</th>
					<td><input type=date name=ab_birth value="<%=gb.getAb_birth() %>">
				</td>
				<tr>
					<th>회 사</th>
					<td><input type=text name=ab_comdept value="<%=gb.getAb_comdept() %>">
				</td>
				<tr>
					<th>메 모</th>
					<td><input type=text name=ab_memo value="<%=gb.getAb_memo() %>">
				</td>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="저장">
						<input type="reset" value="취소">
						<input type="button" value ="삭제" onclick="delcheck()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function delcheck() {
			result = confirm("정말로 삭제하시겠습니까?");
			
			if(result){
				document.form1.action.value="delete";
				document.form1.submit();
			}else{
				return;
			}
		}
	</script>
</body>
</html>