package com.csw.dao;

import com.csw.domain.Course;
import com.csw.domain.Student;
import com.csw.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //��ѯĳѧ����ѡ�����пγ���Ϣ���ÿγ̶�Ӧ�Ľ�ʦ
    public Map<Course,Teacher> findCandT(Student student) throws Exception;
    //��֤��¼
    public Student doLogin(Student student) throws Exception;
    //ѡ��
    public boolean chooseCourse(int sid,int cid) throws Exception;
    //ȡ��ѡ��
    public boolean cancelCourse(int sid,int cid) throws Exception;
    //��ѯĳѧ��δѡ������пγ̼��ÿγ̶�Ӧ�Ľ�ʦ
    public List<Object[]> findNot(int sid) throws Exception;
}
