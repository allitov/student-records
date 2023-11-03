package com.allitov.studentrecords.beans;

import com.allitov.studentrecords.data.Student;

import java.util.List;

public interface StudentManager {

    List<Student> getAllStudents();

    boolean saveStudent(Student student);

    boolean removeStudentById(String id);

    boolean removeAllStudents();
}
