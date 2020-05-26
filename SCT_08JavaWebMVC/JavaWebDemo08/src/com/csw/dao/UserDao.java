package com.csw.dao;

import com.csw.domain.Course;
import com.csw.domain.Student;
import com.csw.domain.Teacher;
import com.csw.domain.User;

import java.util.List;

public interface UserDao {
    //��¼��֤
    public User doLogin(User user) throws Exception;
    //ѧ����Ϣ��CRUD
    public boolean insertStudent(Student student) throws Exception;
    public boolean deleteStudent(Student student) throws Exception;
    public boolean updateStudent(Student student) throws Exception;
    public List<Student> selectStudent() throws Exception;
    //��ʦ��Ϣ��CRUD
    public boolean insertTeacher(Teacher teacher) throws Exception;
    public boolean deleteTeacher(Teacher teacher) throws Exception;
    public boolean updateTeacher(Teacher teacher) throws Exception;
    public List<Teacher> selectTeacher() throws Exception;
    //�γ���Ϣ��CRUD
    public boolean insertCourse(Course coursen) throws Exception;
    public boolean deleteCourse(Course course) throws Exception;
    public boolean updateCourse(Course course,int oldcid) throws Exception;
    public List<Course> selectCourse() throws Exception;
}
