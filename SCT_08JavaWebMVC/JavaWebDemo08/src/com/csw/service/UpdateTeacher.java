package com.csw.service;

import com.csw.dao.DAOFactory;
import com.csw.domain.Student;
import com.csw.domain.Teacher;
import com.csw.util.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateteacher")
public class UpdateTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Tid = request.getParameter("tid");
        int tid = MyUtil.toInt(Tid);
        String tname = request.getParameter("tname");
        String password = request.getParameter("password");
        try {
            Teacher teacher = new Teacher(tid,tname,password);
            boolean flag = DAOFactory.getUserDaoInstance().updateTeacher(teacher);
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
