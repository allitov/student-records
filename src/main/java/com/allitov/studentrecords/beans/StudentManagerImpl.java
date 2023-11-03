package com.allitov.studentrecords.beans;

import com.allitov.studentrecords.data.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentManagerImpl implements StudentManager {

    private final Set<Student> students = new HashSet<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean saveStudent(Student student) {
        return students.add(student);
    }

    @Override
    public boolean removeStudentById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return false;
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(uuid)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeAllStudents() {
        students.clear();

        return true;
    }
}
