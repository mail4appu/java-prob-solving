<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.i18n.properties-min-1.0.9.js"></script>
<title>Insert title here</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    }
</style>
</head>
<body>
<h2><spring:message code="courses.header.message"/></h2>
<form:form method="post" modelAttribute="student"  action="tutorials" enctype = "multipart/form-data" >

<table>
<tr>
<td><spring:message code="select.course"/></td>
<td><select name="courses" multiple="multiple">
         <option value="C">C</option>
         <option value="C++">C++</option>

         <option value="JAVA">JAVA</option>
         <option value="Python">Python</option>
         </select></td>
<td><form:errors path="courses" cssClass="error"></form:errors></td>
</tr>
</table>
<input type="submit" value="Submit your subscription"/>
</form:form>
</body>

</html>