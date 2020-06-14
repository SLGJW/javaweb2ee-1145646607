package com.csw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.csw.bean.Student;
import com.csw.utils.MyUtils;

public class StudentDao {
	/**
	 * 添加学生信息
	 * @param s
	 * @return
	 */
	public int insertStudent(Student s) {
		String sql = "insert into student(sname,sex,shobbies,sclass,edu,birthday) values(?,?,?,?,?,?)";
		Object[] objs = {s.getSname(),s.getSex(),s.getShobbies(),s.getSclass(),s.getEdu(),s.getBirthday()};
		int i = 0;
		try {
			i = MyUtils.qr.update(sql,objs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 查询所有学生信息
	 * @return
	 */
	public List<Student> queryAllStudent(){
		String sql="select * from student";
		List<Student> l=null;
		try {
			l = MyUtils.qr.query(sql, new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	/**
	 * 查询学生信息通过sid
	 * @param sid
	 * @return
	 */
	public Student queryStudentBySid(String sid) {
		String sql = "select * from student where sid = ?";
		Student s = null;
		try {
			s = MyUtils.qr.query(sql, new BeanHandler<>(Student.class),Integer.parseInt(sid));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	/**
	 * 修改学生信息
	 * @param sid
	 * @return
	 */
	public int updateStudent(Student s) {
		String sql = "update student set sname = ?,sex = ?,sclass = ?,shobbies = ?,edu = ?,birthday = ? where sid = ?";
		Object[] objs = {s.getSname(),s.getSex(),s.getSclass(),s.getShobbies(),s.getEdu(),s.getBirthday(),s.getSid()};
		int i=0;
		try {
			i = MyUtils.qr.update(sql, objs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 删除学生
	 * @param sid
	 * @return
	 */
	public int deleteStudent(String sid) {
		String sql="delete from student where sid=?";
		int i=0;
		try {
			i = MyUtils.qr.update(sql, Integer.parseInt(sid));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
