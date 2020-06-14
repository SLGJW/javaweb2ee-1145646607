package com.csw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csw.service.UserService;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
	UserService us=new UserService();
	/**
	 * �û���¼
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loginUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int i=us.loginUser(username,password);
		if(i==1) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "�û������������");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
