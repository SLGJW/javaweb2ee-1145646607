package com.csw.service;

import com.csw.dao.DAOFactory;
import com.csw.domain.Course;
import com.csw.domain.Teacher;
import com.csw.util.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletecourse")
public class DeleteCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cid = request.getParameter("cid");
        int cid = MyUtil.toInt(Cid);
        try {
            Course c = MyUtil.getCourse(cid);
            boolean flag = DAOFactory.getUserDaoInstance().deleteCourse(c);
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
