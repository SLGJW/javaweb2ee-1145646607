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

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = MyUtil.toInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String password = request.getParameter("password");
        Student s = new Student(sid,sname,password);
        try {
            boolean flag = DAOFactory.getUserDaoInstance().insertStudent(s);
            if(flag){
                request.setAttribute("result", "��ӳɹ���");
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }else {
                request.setAttribute("result", "���ʧ�ܣ�");
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
