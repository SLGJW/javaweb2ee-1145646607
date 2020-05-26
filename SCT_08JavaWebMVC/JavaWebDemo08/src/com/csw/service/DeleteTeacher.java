package com.csw.service;

import com.csw.dao.DAOFactory;
import com.csw.domain.Teacher;
import com.csw.util.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteteacher")
public class DeleteTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Tid = request.getParameter("tid");
        int tid = MyUtil.toInt(Tid);
        try {
            Teacher t = MyUtil.getTeacher(tid);
            boolean flag = DAOFactory.getUserDaoInstance().deleteTeacher(t);
            System.out.println(flag);
            if(flag==true){
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
