package com.csw.service;

import java.util.List;

import com.csw.bean.Student;
import com.csw.dao.StudentDao;

public class StudentService {
	private StudentDao sd=new StudentDao();
	/**
	 * 增加学生
	 * @param s
	 * @return
	 */
	public int insertStudent(Student s) {
		return sd.insertStudent(s);
	}
	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Student> queryAllStudent(){
		return sd.queryAllStudent();
	}
	/**
	 * 通过sid查询学生信息
	 * @param sid
	 * @return
	 */
	public Student queryStudentBySid(String sid) {
		return sd.queryStudentBySid(sid);
	}
	/**
	 * 修改学生信息
	 * @param sid
	 * @return
	 */
	public int updateStudent(Student s) {
		return sd.updateStudent(s);
	}
	/**
	 * 删除学生
	 * @param sid
	 * @return
	 */
	public int deleteStudent(String sid) {
		
		return sd.deleteStudent(sid);
	}
}
