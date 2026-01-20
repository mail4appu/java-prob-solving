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
<h2><spring:message code="header.message"/></h2>
<%-- Displaying all the errors
<form:errors path="student1.*"></form:errors> --%>
<form action="submit" method="POST"  enctype = "multipart/form-data">
<%-- <form:form method="post" modelAttribute="student1" action="submit"> --%>

<table>
<tr>
 <td><spring:message code="enter.student.name"></spring:message></td>
 <%-- <td><form:input path="studentName" /></td> --%>
 <td><input type="text" name="studentName"/></td>
 <td><form:errors path="student1.studentName" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.student.hobby"></spring:message></td>
<%--  <td><form:input path="studentHobby" /></td> --%>
<td><input type="text" name="studentHobby"/></td>
 <td><form:errors path="student1.studentHobby" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.student.mob"></spring:message></td>
 <td><input type="text" name="mobileNumber"></td>
 <td><form:errors path="student1.mobileNumber" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.student.dob"></spring:message></td>
 <td><input type="text" name="dob"></td>
 <td><form:errors path="dob" cssClass="error"></form:errors></td>
</tr>

<tr>
 <td><spring:message code="enter.student.doj"></spring:message></td>
 <td><input type="text" name="doj"></td>
 <td><form:errors path="doj" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="select.student.skill"></spring:message></td>
 <td><select name="skills" multiple="multiple">
     <option value="Maths">Maths</option>
     <option value="Science">Science</option>
     
     <option value="English">English</option></select>
  </td>
  <td><form:errors path="skills" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.country"></spring:message></td>
 <td><input type="text" name="stdAddress.country"></td>
 <td><form:errors path="student1.stdAddress.country" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.city"></spring:message></td>
 <td><input type="text" name="stdAddress.city"></td>
 <td><form:errors path="student1.stdAddress.city" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.street"></spring:message></td>
 <td><input type="text" name="stdAddress.street"></td>
 <td><form:errors path="student1.stdAddress.street" cssClass="error" ></form:errors></td>
</tr>
<tr>
 <td><spring:message code="enter.pincode"></spring:message></td>
 <td><input type="text" name="stdAddress.pinCode"></td>
 <td><form:errors path="student1.stdAddress.pinCode" cssClass="error"></form:errors></td>
</tr>
<tr>
 <td><spring:message code="upload.pic"></spring:message></td>
 <td><input type="file" name="stdPic"></td>
 <td><form:errors path="student1.stdPic" cssClass="error"></form:errors></td>
</tr>


</table>
<input type="submit" value="Please Click here to Submit the Details"/>
</form>
<%-- </form:form> --%>
</body>

</html>