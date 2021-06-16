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
    <select name="major_id" id="major_id">

    </select><br>
    <input type="button" value="insert" onclick="insertStudent()"><br>
</form>
<script>
    // insert student
    function insertStudent(){
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

    //select options for major_id and major_code
    $.ajax({
        url:"/WEB04/usr/fetchMajor",
        data:{},
        type:"post",
        dataType:"json",
        success:function (dataInfo){
            console.log(dataInfo);
            $("#major_id").append("<option value=''>---please select---</option>")
            for (var i = 0; i < dataInfo.length; i++){
                var list = dataInfo[i];
                $("#major_id").append("<option value='"+list.major_Id+"'>"+list.major_code+"</option>");
            }
        }
    })
</script>
</body>
</html>
