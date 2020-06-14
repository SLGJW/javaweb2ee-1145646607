package com.csw.service;

import java.util.List;

import com.csw.bean.Student;
import com.csw.dao.StudentDao;

public class StudentService {
	private StudentDao sd=new StudentDao();
	/**
	 * ����ѧ��
	 * @param s
	 * @return
	 */
	public int insertStudent(Student s) {
		return sd.insertStudent(s);
	}
	/**
	 * ��ѯ����ѧ����Ϣ
	 * @return
	 */
	public List<Student> queryAllStudent(){
		return sd.queryAllStudent();
	}
	/**
	 * ͨ��sid��ѯѧ����Ϣ
	 * @param sid
	 * @return
	 */
	public Student queryStudentBySid(String sid) {
		return sd.queryStudentBySid(sid);
	}
	/**
	 * �޸�ѧ����Ϣ
	 * @param sid
	 * @return
	 */
	public int updateStudent(Student s) {
		return sd.updateStudent(s);
	}
	/**
	 * ɾ��ѧ��
	 * @param sid
	 * @return
	 */
	public int deleteStudent(String sid) {
		
		return sd.deleteStudent(sid);
	}
}
