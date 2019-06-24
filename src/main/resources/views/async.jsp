<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>servlet async support</title>
</head>
    <body>
        // 此处的代码使用的是jQuery的Ajax请求，所以没有浏览器兼容性问题。
        <script type="text/javascript" src="assets/js/jQuery.js"></script>
        <script type="text/javascript">
            deferred();//1 页面打开就向后台发送请求
            function deferred(){
                $.get('defer',function(data){
                    console.log(data); //2 在控制台输出服务端推送的数据
                    deferred(); //3 一次请求完成后再向后台发送请求
                });
            }
        </script>
    </body>
</html>
<%--此处也许读者会奇怪，为什么页面不放在Maven标准的 src/main/webapp/WEB-INF下，
此处这样建的主要目的是让大 家熟悉Spring Boot的页面习惯的放置方式，Spring Boot的页面 就放置在src/main/resources下。--%>
