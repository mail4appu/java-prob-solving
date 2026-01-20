<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script type="text/javascript">
function showAlert(){
	var txt="<spring:message code="alert.msg"/>";
	window.alert(txt);
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="page.title"></spring:message> </title>
<body onload="showAlert()" >
	
	<c:out value="${result}"></c:out>
	<h2><c:out value="${message}"></c:out></h2>
	<%-- <h2>
	    <c:out value="${pageContext.request.locale.language}"></c:out> <br> 
	 	<spring:message code="greeting.text"></spring:message>
	 	
	</h2> --%>
	<table>
	<tr><td>${student1.studentName}*************</td></tr>
	<tr><td>${student1.password}*************</td></tr>
	<tr><td>${student1.mobileNumber}</td></tr>
	<tr><td>${student1.studentHobby}</td></tr>
	<tr><td>${student1.dob}</td></tr>
	<tr><td>${student1.doj}</td></tr>
	<tr><td>${student1.skills}</td></tr>
	<tr><td>${student1.stdAddress.country}</td></tr>
	<tr><td>${student1.stdAddress.city}</td></tr>
	<tr><td>${student1.stdAddress.street}</td></tr>
	<tr><td>${student1.stdAddress.pinCode}</td></tr>
	<tr><td><img src="${student1.photo}"/></td></tr>

	</table>
</body>
</html>
