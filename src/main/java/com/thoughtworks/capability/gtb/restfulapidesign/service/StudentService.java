package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.IdDuplicate;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.IdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public List<Student> getAllStudents(String gender){
        if (gender == null){
            return studentRepository.getStudentList();
        }
        List<Student> studentListByGender=new ArrayList<>();
        for (Student stu:studentRepository.getStudentList()){
            if (stu.getGender().toString().equals(gender)){
                studentListByGender.add(stu);
            }
        }
        return studentListByGender;
    }

    public void addStudent(Student student) throws IdDuplicate {
        Integer id = student.getId();
        for (Student stu:studentRepository.getStudentList()){
            if (id==stu.getId()){
                throw new IdDuplicate("id cannot be repeated");
            }
        }
        studentRepository.getStudentList().add(student);
    }

    public void deleteStudent(Integer id){
        int count = 0;
        int length = studentRepository.getStudentList().size();
        for (Student stu:studentRepository.getStudentList()) {
            if (stu.getId() == id) {
                studentRepository.getStudentList().remove(stu);
                break;
            }
            count++;
        }
        if (count == length) {
            throw new IdNotFoundException("student id is not exit");
        }
    }

    public Student getStudentById(Integer id){
        for (Student stu:studentRepository.getStudentList()){
            if (stu.getId() == id){
                return stu;
            }
        }
        throw new IdNotFoundException("student id is not exit");
    }

    public Student updateStudent(Integer id, Student student) {
        for(Student stu:studentRepository.getStudentList()){
            if(stu.getId() == id){
                stu.setGender(student.getGender());
                stu.setName(student.getName());
                stu.setNote(student.getNote());
                return stu;
            }
        }
        throw new IdNotFoundException("student id is not exit");
    }


}
