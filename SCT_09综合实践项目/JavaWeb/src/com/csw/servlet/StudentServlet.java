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
	 * ��ӵķ���
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ձ��Ĳ���
		String sname = req.getParameter("sname");
		String edu = req.getParameter("edu");
		String sclass = req.getParameter("sclass");
		
		//age ��sex ��Ҫת��int
		String sex = req.getParameter("sex");
		//�ַ���תDate
		String birthday = req.getParameter("birthday");
		//string����תstring
		String[] shobby = req.getParameterValues("shobbies");
		Date bri = MyUtils.stringToDate(birthday);
		String hobby = MyUtils.arrayToString(shobby);
		//��װ��ʵ����
		Student s = new Student(sname, Integer.parseInt(sex),  hobby,sclass, bri,edu );
		int i = ss.insertStudent(s);
		if (i > 0) {
			//��ѯ�����û���Ϣ
			req.getRequestDispatcher("studentServlet?mark=queryAllStudent").forward(req, resp);
		}else {
			
			System.out.println("���ʧ��");
		}
		
	}
		
	/**
	 * ��ѯ����ѧ����Ϣ
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
			System.out.println("��ѯʧ��");
		}
	}
	/**
	 * �޸ĵĻ���  ͨ��sid��ѯ����ѧ����Ϣ
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryStudentBySid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//���ղ���sid
		String sid = req.getParameter("sid");
		Student s = ss.queryStudentBySid(sid);
		if (s != null) {
			//��s�ŵ�request��������
			req.setAttribute("s", s);
			//ת����ת���޸�ҳ�� updateStudent.jsp
			req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
		}
	}
	/**
	 * �޸�ѧ����Ϣ
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//����ǰ�˵Ĳ���
		String sname = req.getParameter("sname");
		String edu = req.getParameter("edu");
		String sclass = req.getParameter("sclass");
		String sid = req.getParameter("sid");
		//sex ��Ҫת��int
		String sex = req.getParameter("sex");
		//�ַ���תDate
		String birthday = req.getParameter("birthday");
		//string����תstring
		String[] shobby = req.getParameterValues("shobbies");
		Date bir = MyUtils.stringToDate(birthday);
		String hobby = MyUtils.arrayToString(shobby);
		//��װ��ʵ����
		Student s = new Student(Integer.parseInt(sid),sname, Integer.parseInt(sex), hobby,sclass,  bir, edu);
		//����service��ķ���
		int i = ss.updateStudent(s);
		if (i > 0) {
			//���³ɹ�
			req.getRequestDispatcher("studentServlet?mark=queryAllStudent").forward(req, resp);
		} else {
			System.out.println("����ʧ��");
		}
	}
	
	/**
	 * ɾ��ѧ��
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
			System.out.println("ɾ��ʧ��");
		}
	}
}
