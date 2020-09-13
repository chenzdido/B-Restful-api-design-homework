package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> studentList = new ArrayList<Student>(){{
        add(new Student(1, "沈乐棋", Gender.MALE, null));
        add(new Student(2, "徐慧慧", Gender.FEMALE, null));
        add(new Student(3, "陈思聪", Gender.MALE, null));
        add(new Student(4, "王江林", Gender.MALE, null));
        add(new Student(5, "王登宇", Gender.MALE, null));
        add(new Student(6, "杨思雨", Gender.FEMALE, null));
        add(new Student(7, "江雨舟", Gender.MALE, null));
        add(new Student(8, "廖燊", Gender.MALE, null));
        add(new Student(9, "胡晓", Gender.FEMALE, null));
        add(new Student(10, "但杰", Gender.MALE, null));
        add(new Student(11, "盖迈达", Gender.MALE, null));
        add(new Student(12, "肖美琦", Gender.FEMALE, null));
        add(new Student(13, "黄云洁", Gender.FEMALE, null));
        add(new Student(14, "齐瑾浩", Gender.MALE, null));
        add(new Student(15, "刘亮亮", Gender.MALE, null));
        add(new Student(16, "肖逸凡", Gender.MALE, null));
        add(new Student(17, "王作文", Gender.MALE, null));
        add(new Student(18, "郭瑞凌", Gender.MALE, null));
        add(new Student(19, "李明豪", Gender.MALE, null));
        add(new Student(20, "党泽", Gender.MALE, null));
        add(new Student(21, "肖伊佐", Gender.MALE, null));
        add(new Student(22, "贠晨曦", Gender.FEMALE, null));
        add(new Student(23, "李康宁", Gender.MALE, null));
        add(new Student(24, "马庆", Gender.MALE, null));
        add(new Student(25, "商婕", Gender.FEMALE, null));
        add(new Student(26, "余榕", Gender.FEMALE, null));
        add(new Student(27, "谌哲", Gender.FEMALE, null));
        add(new Student(28, "董翔锐", Gender.MALE, null));
        add(new Student(29, "陈泰宇", Gender.MALE, null));
        add(new Student(30, "赵允齐", Gender.MALE, null));
        add(new Student(31, "张柯", Gender.MALE, null));
        add(new Student(32, "廖文强", Gender.MALE, null));
        add(new Student(33, "刘轲", Gender.MALE, null));
        add(new Student(34, "廖浚斌", Gender.MALE, null));
        add(new Student(35, "凌凤仪", Gender.FEMALE, null));
    }};

    public List<Student> getAllStudents(){
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void deleteStudent(Integer id){
        for(Student stu:studentList){
            if(stu.getId()==id){
                studentList.remove(stu);
                break;
            }
        }
    }
}
