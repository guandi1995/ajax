<%--
  Created by IntelliJ IDEA.
  User: dguan
  Date: 6/9/2021
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info</title>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<%--    页面跳转--%>
    <script>
        $().ready(function (){
            $("#addBtn").click(function (){
                window.location.href="/WEB04/view/studentInsert.jsp";
            })
        })
    </script>
</head>
<body>
<input type="button" value="Insert Student" id="addBtn">
<table style="border: 1px;width: 100%">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>gender</td>
        <td>majorId</td>
        <td>operations</td>
    </tr>
    <tbody id="father"></tbody>
</table>

<script>

    loadPage();

    //fetch student
    function loadPage(){
        $.ajax({
            url:"/WEB04/usr/fetchStudent",
            data:{},
            type:"post",
            dataType:"json",
            success:function (dataInfo){
                $("#father").html("");
                console.log(dataInfo);
                for (var i=0; i<dataInfo.length; i++){
                    var student = dataInfo[i];
                    var html = "<tr> " +
                        "<td>"+ student.stuid+"</td> " +
                        "<td>"+ student.stuname+"</td> " +
                        "<td>"+ student.age+"</td> " +
                        "<td>"+ student.gender+"</td> " +
                        "<td>"+ student.major_id+"</td> " +
                        "<td><input type='button' value='detele', onclick='clickHandler("+student.stuid+")'></td> " +
                        "</tr>";
                    $("#father").append(html);
                }
            }
        })
    }

    //delete student
    function clickHandler(stuid) {
        $.ajax({
            url: "/WEB04/usr/deleteStudent",
            data: {stuid:stuid},
            type: "post",
            dataType: "json",
            success:function (dataInfo){
                if (dataInfo.status){
                    console.log(dataInfo.message);
                    loadPage();
                }
                else
                    console.log(dataInfo.message);
            }
        })
    }
</script>
</body>
</html>
