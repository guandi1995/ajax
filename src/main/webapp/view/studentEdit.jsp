<%--
  Created by IntelliJ IDEA.
  User: dguan
  Date: 6/15/2021
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student Info</title>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<form id="editStuForm">
    <input type="text" name="stuid" id="stuid" placeholder="student id" readonly><br>
    <input type="text" name="stuname" id="stuname" placeholder="student name"><br>
    <input type="text" name="age" id="age" placeholder="student age"><br>
    <input type="text" name="gender" id="gender" placeholder="student gender"><br>
    <input type="text" name="major_id" id="major_id" placeholder="student major id"><br>
    <input type="button" value="update" onclick="EditStudent()"><br>
</form>
<script>
    //接收param路径中的stuid参数
    var stuid = "${param.stuid}";

    loadEditPage();

    //load edit page, fetch student by id
    function loadEditPage(){
        $.ajax({
            url:"/WEB04/usr/fetchStudentById",
            data:{stuid: stuid},
            type:"post",
            dataType:"json",
            success:function (dataInfo){
                //根据json返回的数据进行回显
                $("#stuid").val(dataInfo.stuid);
                $("#stuname").val(dataInfo.stuname);
                $("#age").val(dataInfo.age);
                $("#gender").val(dataInfo.gender);
                $("#major_id").val(dataInfo.major_id);
            }
        })
    }
    // edit student
    function EditStudent(){
        $.ajax({
            url:"/WEB04/usr/updateStudent",
            data:$("#editStuForm").serialize(),//使用表单序列化传递参数
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
