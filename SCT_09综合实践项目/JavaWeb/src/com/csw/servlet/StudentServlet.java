package com.csw.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csw.bean.Student;
import com.csw.service.StudentService;
import com.csw.utils.MyUtils;

@WebServlet("/studentServlet")
public class StudentServlet extends BaseServlet {
	private StudentService ss=new StudentService();
	/**
	 * 添加的方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收表单的参数
		String sname = req.getParameter("sname");
		String edu = req.getParameter("edu");
		String sclass = req.getParameter("sclass");
		
		//age 和sex 需要转成int
		String sex = req.getParameter("sex");
		//字符串转Date
		String birthday = req.getParameter("birthday");
		//string数组转string
		String[] shobby = req.getParameterValues("shobbies");
		Date bri = MyUtils.stringToDate(birthday);
		String hobby = MyUtils.arrayToString(shobby);
		//封装到实体类
		Student s = new Student(sname, Integer.parseInt(sex),  hobby,sclass, bri,edu );
		int i = ss.insertStudent(s);
		if (i > 0) {
			//查询所有用户信息
			req.getRequestDispatcher("studentServlet?mark=queryAllStudent").forward(req, resp);
		}else {
			
			System.out.println("添加失败");
		}
		
	}
		
	/**
	 * 查询所有学生信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		List<Student> l = ss.queryAllStudent();
		if(l!=null) {
			req.setAttribute("l", l);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}else {
			System.out.println("查询失败");
		}
	}
	/**
	 * 修改的回显  通过sid查询该条学生信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryStudentBySid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//接收参数sid
		String sid = req.getParameter("sid");
		Student s = ss.queryStudentBySid(sid);
		if (s != null) {
			//把s放到request作用域中
			req.setAttribute("s", s);
			//转发跳转到修改页面 updateStudent.jsp
			req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
		}
	}
	/**
	 * 修改学生信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//接收前端的参数
		String sname = req.getParameter("sname");
		String edu = req.getParameter("edu");
		String sclass = req.getParameter("sclass");
		String sid = req.getParameter("sid");
		//sex 需要转成int
		String sex = req.getParameter("sex");
		//字符串转Date
		String birthday = req.getParameter("birthday");
		//string数组转string
		String[] shobby = req.getParameterValues("shobbies");
		Date bir = MyUtils.stringToDate(birthday);
		String hobby = MyUtils.arrayToString(shobby);
		//封装到实体类
		Student s = new Student(Integer.parseInt(sid),sname, Integer.parseInt(sex), hobby,sclass,  bir, edu);
		//调用service层的方法
		int i = ss.updateStudent(s);
		if (i > 0) {
			//更新成功
			req.getRequestDispatcher("studentServlet?mark=queryAllStudent").forward(req, resp);
		} else {
			System.out.println("更新失败");
		}
	}
	
	/**
	 * 删除学生
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("sid");
		int i=ss.deleteStudent(sid);
		if(i>0) {
			req.getRequestDispatcher("studentServlet?mark=queryAllStudent").forward(req, resp);
		}else {
			System.out.println("删除失败");
		}
	}
}
