<%@ page import="com.csw.dao.DAOFactory" %>
<%@ page import="com.csw.domain.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="com.csw.domain.Student" %>
<%@ page import="com.csw.domain.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<script>
    onload = function () {
        <%
            if(request.getAttribute("result")!=null){
                String result = (String)request.getAttribute("result");
                request.removeAttribute("result");
        %>
        alert("<%=result%>");
        <%
            }
        %>
    }
</script>
<body>
<%
    List<Teacher> teachers = DAOFactory.getUserDaoInstance().selectTeacher();
    List<Student> students = DAOFactory.getUserDaoInstance().selectStudent();
    List<Course> courses = DAOFactory.getUserDaoInstance().selectCourse();
%>
<p>
    <h1>教师信息列表</h1>
<h4><a href="/stu67/userAddTeacher.jsp">添加教师</a></h4>
<table width="400px" cellspacing="0px" border="1px">
    <tr>
        <td>工号</td>
        <td>姓名</td>
        <td>密码</td>
        <td colspan="2">操作</td>
    </tr>
    <%
    for(Teacher teacher : teachers){%>
        <tr>
            <td><%=teacher.getTid()%></td>
            <td><%=teacher.getTname()%></td>
            <td><%=teacher.getPassword()%></td>
            <td>
                <form action="/stu67/userUpdateTeacher.jsp" method="get">
                    <input type="hidden" name="update" value="<%=teacher.getTid()%>">
                    <input type="submit" value="修改">
                </form>
            </td>
            <td>
                <form action="/stu67/userDeleteTeacher.jsp" method="get">
                    <input type="hidden" name="delete" value="<%=teacher.getTid()%>">
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    <%
    }%>
</table>
</p>
<p>
<h1>学生信息列表</h1>
<h4><a href="/stu67/userAddStudent.jsp">添加学生</a></h4>
<table width="400px" cellspacing="0px" border="1px">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>密码</td>
        <td colspan="2">操作</td>
    </tr>
    <%
        for(Student student : students){%>
    <tr>
        <td><%=student.getSid()%></td>
        <td><%=student.getSname()%></td>
        <td><%=student.getPassword()%></td>
        <td>
            <form action="/stu67/userUpdateStudent.jsp" method="get">
                <input type="hidden" name="update" value="<%=student.getSid()%>">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="/stu67/userDeleteStudent.jsp" method="get">
                <input type="hidden" name="delete" value="<%=student.getSid()%>">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    <%
        }%>
</table>
</p>
<p>
<h1>课程信息列表</h1>
<h4><a href="/stu67/userAddCourse.jsp">添加课程</a></h4>
<table width="400px" cellspacing="0px" border="1px">
    <tr>
        <td>编号</td>
        <td>课程名</td>
        <td colspan="2">操作</td>
    </tr>
    <%
        for(Course course : courses){%>
    <tr>
        <td><%=course.getCid()%></td>
        <td><%=course.getCname()%></td>
        <td>
            <form action="/stu67/userUpdateCourse.jsp" method="get">
                <input type="hidden" name="update" value="<%=course.getCid()%>">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="/stu67/userDeleteCourse.jsp" method="get">
                <input type="hidden" name="delete" value="<%=course.getCid()%>">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    <%
        }%>
</table>
</p>
</body>
</html>
