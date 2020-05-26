package com.csw.dao;

import com.csw.domain.Course;
import com.csw.domain.Student;
import com.csw.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    //��¼����
    public Teacher doLogin(Teacher teacher) throws Exception;
    //��ѯĳ��ʦ���̵����пγ�
    public List<Course> findTeachCourses(Teacher teacher) throws Exception;
    //��ѯĳ��ʦ���̵����пγ��Լ�ѡ��ÿγ̵�ѧ��
    public Map<Course,List<Student>> findTeachStudents(Teacher teacher) throws Exception;
}
