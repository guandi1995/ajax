<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<script src="/WEB04/resources/jquery2.1.4.min.js"></script>
<script>
    $.ajax({
        url:"",//ajax请求的URL路径
        data:{},//传递给后台的data
        type:"post/get",//请求的type
        dataType:"text/json",//响应的data type
        async:true,//是否是异步
        success:function (dataInfo){
            //成功后的响应函数，dataInfo是服务器返回的数据
        }
    })
</script>
</body>
</html>