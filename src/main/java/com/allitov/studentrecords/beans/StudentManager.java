package com.allitov.studentrecords.beans;

import com.allitov.studentrecords.data.Student;

import java.util.List;
import java.util.Optional;

public interface StudentManager {

    List<Student> getAllStudents();

    Optional<Student> saveStudent(Student student);

    Optional<Student> removeStudentById(String id);

    boolean removeAllStudents();

    void serializeData();
}
