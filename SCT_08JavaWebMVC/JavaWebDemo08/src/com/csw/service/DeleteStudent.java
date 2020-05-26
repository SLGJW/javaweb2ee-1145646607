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

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Sid = request.getParameter("sid");
        int sid = MyUtil.toInt(Sid);
        try {
            Student s = MyUtil.getStudent(sid);
            boolean flag = DAOFactory.getUserDaoInstance().deleteStudent(s);
            if(flag){
                request.setAttribute("result", "É¾³ý³É¹¦£¡");
                request.getRequestDispatcher("user.jsp").forward(request, response);
            }else {
                request.setAttribute("result", "É¾³ýÊ§°Ü£¡");
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
