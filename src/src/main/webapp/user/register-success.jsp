<%@ page import="com.example.t2009m1java.entity.Account" %><%
   Account account =(Account)request.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">

    <div class="w3-panel w3-green">
        <h2 class="w3-opacity">Register success</h2>
    </div>
    <div>Username: <%= account.getUsername()%></div>
    <div>Fullname: <%= account.getFullName()%></div>
</div>

</body>
</html>
