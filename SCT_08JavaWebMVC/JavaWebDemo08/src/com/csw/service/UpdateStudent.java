package com.csw.service;

import com.csw.dao.DAOFactory;
import com.csw.domain.Student;
import com.csw.util.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Sid = request.getParameter("sid");
        int sid = MyUtil.toInt(Sid);
        String sname = request.getParameter("sname");
        String password = request.getParameter("password");
        try {
            Student student = new Student(sid,sname,password);
            boolean flag = DAOFactory.getUserDaoInstance().updateStudent(student);
            if(flag){
                request.setAttribute("result", "�޸ĳɹ���");
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }else {
                request.setAttribute("result", "�޸�ʧ�ܣ�");
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
