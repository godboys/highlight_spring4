<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SSE Demo</title>
</head>
    <body>
    <div id="msgFrompPush"></div>
        <script type="text/javascript" src="<c:url value="/assets/js/jQuery.js"/>"></script>
        <script type="text/javascript">
            if (!!window.EventSource) { //1 EventSource对象只有新式的浏览器才有（Chrome、Firefox）等，EventSource是SSE的客户端
                var source = new EventSource('push');
                s='';
                source.addEventListener('message', function(e) {//2 添加SSE客户端监听，在此获得服务器端推送的消息
                    s+=e.data+"<br/>";
                    $("#msgFrompPush").html(s);
                });
                source.addEventListener('open', function(e) {
                    console.log("连接打开.");
                }, false);
                source.addEventListener('error', function(e) {
                    if (e.readyState == EventSource.CLOSED) {
                        console.log("连接关闭");
                    } else {
                        console.log(e.readyState);
                    }
                }, false);
            } else {
                console.log("你的浏览器不支持SSE");
            }
        </script>
    </body>
</html>
<%--此处也许读者会奇怪，为什么页面不放在Maven标准的 src/main/webapp/WEB-INF下，
此处这样建的主要目的是让大 家熟悉Spring Boot的页面习惯的放置方式，Spring Boot的页面 就放置在src/main/resources下。--%>
