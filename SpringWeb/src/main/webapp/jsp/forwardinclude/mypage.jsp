<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.i18n.properties-min-1.0.9.js"></script>

<script type="text/javascript" src="<c:url value="page.js" />">
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="page.title"></spring:message> </title>
</head>

<body>

	<!-- Placing the dynamic value in the place holder  -->
	<form name="myform" action="getResult" method="post">
		<spring:message code="enter.first.number"  htmlEscape="false" />
		<input type="text" name="number1" /><br>
		<spring:message code="enter.second.number" />
		<input type="text" name="number2" /><br>
		<jsp:useBean id="now" class="java.util.Date"/>
		<spring:message code="current.date"/><fmt:formatDate type="date"  value="${todate}" /><br>
		<spring:message code="current.time"/><fmt:formatDate type="time" value="${now}" /><br>
		<input type="submit" value="<spring:message code="get.result"/>" >
		<spring:message code="greeting.text"/>
		<a href="result" title="testing">visit this</a>
		<c:out value="${contrlmsg}"></c:out>

	</form>
</body>
  <%-- <script type="text/javascript" src="/loadLocale>
<%@ include file="../../page.js" %>
</script> --%>
</html>