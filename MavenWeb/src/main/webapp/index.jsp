<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "callback", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("isInternal=true&user=Appu");
}
</script>
</head>
<body>
<form name="firstForm"  action="">
<a href="https://graph.facebook.com/oauth/authorize?client_id=215439618868845&redirect_uri=http://localhost:8080/springweb">login with facebook</a>
<br>

<a href="https://api.twitter.com/oauth/authorize?oauth_token=QuP0xQAAAAAAY2vAAAABV60_6xE">login with twitter</a>

<br>
<a href="javascript:loadDoc();">Load</a>
<div  id="demo" style="height:50;width:50;border: 1px solid blue;float:none">
After loading content from backend
</div>
<input type"text" name="username" id="userName"/>
<input type"password" name="password" id="password"/>
<input type="submit" name="submit"/>
</form>

</body>
</html>