<%--
  Created by IntelliJ IDEA.
  User: dguan
  Date: 6/12/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert or Update Student Info</title>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<form id="insertStuForm">
    <input type="text" name="stuid" placeholder="student id"><br>
    <input type="text" name="stuname" placeholder="student name"><br>
    <input type="text" name="age" placeholder="student age"><br>
    <input type="text" name="gender" placeholder="student gender"><br>
    <input type="text" name="major_id" placeholder="student major id"><br>
    <input type="button" value="insert" onclick="clickHandler()"><br>
</form>
<script>
    // insert student
    function clickHandler(){
        $.ajax({
            url:"/WEB04/usr/insertStudent",
            data:$("#insertStuForm").serialize(),//使用表单序列化传递参数
            type:"post",
            dataType:"json",
            success:function (dataInfo){
                //添加成功后，跳转到studentList.jsp查询页面
                console.log(dataInfo);
                if (dataInfo.status)
                    window.location.href="/WEB04/view/studentList.jsp"
                else
                    alert(dataInfo.message)
            }
        })
    }
</script>
</body>
</html>
