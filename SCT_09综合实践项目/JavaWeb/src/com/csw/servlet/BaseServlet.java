package com.csw.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String mark=req.getParameter("mark");
		if(mark==null||"".equals(mark)) {
			System.out.println("mark²»ÄÜÎª¿Õ");
			return;
		}
		Class c = this.getClass();
		try {
			Method m = c.getMethod(mark, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
