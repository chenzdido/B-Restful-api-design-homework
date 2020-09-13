package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.StudentList;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.IdDuplicate;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.IdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentList studentList = new StudentList();
    public List<Student> getAllStudents(){
        return studentList.getStudentList();
    }

    public void addStudent(Student student) throws IdDuplicate {
        Integer id = student.getId();
        for(Student stu:studentList.getStudentList()){
            if(id==stu.getId()){
                throw new IdDuplicate("id cannot be repeated");
            }
        }
        studentList.getStudentList().add(student);
    }

    public void deleteStudent(Integer id){
        int count = 0;
        int length=studentList.getStudentList().size();
        for(Student stu:studentList.getStudentList()) {
            if (stu.getId() == id) {
                studentList.getStudentList().remove(stu);
                break;
            }
            count++;
        }
        if(count==length) {
            throw new IdNotFoundException("student id is not exit");
        }
    }

    public Student getStudentById(Integer id){
        for(Student stu:studentList.getStudentList()){
            if(stu.getId()==id){
                return stu;
            }
        }
        throw new IdNotFoundException("student id is not exit");
    }

    public Student updateStudent(Integer id, Student student) {
        for(Student stu:studentList.getStudentList()){
            if(stu.getId()==id){
                stu.setGender(student.getGender());
                stu.setName(student.getName());
                stu.setNote(student.getNote());
                return stu;
            }
        }
        throw new IdNotFoundException("student id is not exit");
    }

    public List<Student> getStudentsByGender(String gender) {
        List<Student> studentListByGender=new ArrayList<>();
        for(Student stu:studentList.getStudentList()){
            if(stu.getGender().toString().equals(gender)){
                studentListByGender.add(stu);
            }
        }
        return studentListByGender;
    }
}
