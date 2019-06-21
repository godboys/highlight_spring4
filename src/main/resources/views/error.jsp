<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        ${errorMessage}
    </body>
</html>
<%--此处也许读者会奇怪，为什么页面不放在Maven标准的 src/main/webapp/WEB-INF下，
此处这样建的主要目的是让大 家熟悉Spring Boot的页面习惯的放置方式，Spring Boot的页面 就放置在src/main/resources下。--%>
