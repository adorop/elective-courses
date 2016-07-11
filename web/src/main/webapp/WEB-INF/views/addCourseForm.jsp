<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add course</title>
</head>
<body>
<sf:form modelAttribute="course" method="post">
  Title:        <sf:input path="title"/>
                <sf:errors path="title"/>
  <br>
  Description:  <sf:textarea path="description"/><br>
  <input type="submit" value="Add course">
</sf:form>
</body>
</html>
