<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学生信息</title>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	
	<h1>修改页面</h1>
	
	
	<form action="studentServlet">
		<input type="hidden" name="mark" value="updateStudent">
		<input type="hidden" name="sid" value="${s.sid }">
		姓名:<input type="text" name="sname" value="${s.sname }"><br>
		
		性别:<input type="radio" name="sex" value="1"  
				<c:if test="${s.sex == 1 }">checked</c:if>
			>男
			<input type="radio" name="sex" value="0"
				<c:if test="${s.sex == 0 }">checked</c:if>
			>女<br>
		
		班级:<input type="text" name="sclass" value="${s.sclass }"><br>
		
		爱好:<input type="checkbox" name="shobbies" value="唱歌"
			 
			<c:if test="${fn:contains(s.shobbies,'唱歌') }">checked</c:if>
		>唱歌
		
		<input type="checkbox" name="shobbies" value="打篮球"
			<c:if test="${fn:contains(s.shobbies,'打篮球') }">checked</c:if>
		>打篮球
		
		<input type="checkbox" name="shobbies" value="打台球"
			<c:if test="${fn:contains(s.shobbies,'打台球') }">checked</c:if>
		>打台球
		<input type="checkbox" name="shobbies" value="看书"
			<c:if test="${fn:contains(s.shobbies,'看书') }">checked</c:if>
		>看书<br>
		学历:<select name="edu">
		
			<option value="初中"  <c:if test="${s.edu== '初中' }">selected</c:if> >初中</option>
			<option value="高中"  <c:if test="${s.edu== '高中' }">selected</c:if>>高中</option>
			<option value="专科"  <c:if test="${s.edu== '专科' }">selected</c:if>>专科</option>
			<option value="本科"  <c:if test="${s.edu== '本科' }">selected</c:if>>本科</option>
		</select><br>
		
		生日:<input name="birthday"
		 value="<fmt:formatDate value="${s.birthday }" 
		 pattern="yyyy-MM-dd"/>" class="Wdate" type="text" 
		 onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"> <br>
		<input type="submit" value="确认修改"> 
	</form>
</body>
</html>