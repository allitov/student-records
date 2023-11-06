package com.allitov.studentrecords.beans;

import com.allitov.studentrecords.data.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
public abstract class AbstractStudentManager implements StudentManager {

    @Value("${app.saving-file.path}")
    private String savingFilePath;

    protected final Collection<Student> students;

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public Optional<Student> saveStudent(Student student) {
        return students.add(student) ? Optional.of(student) : Optional.empty();
    }

    @Override
    public Optional<Student> removeStudentById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(uuid)) {
                iterator.remove();
                return Optional.of(student);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean removeAllStudents() {
        students.clear();

        return true;
    }

    @Override
    public void serializeData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savingFilePath))) {
            for (Student student : students) {
                String studentData = String.format("%s;%s;%s;%d%n",
                        student.getId(), student.getLastName(),
                        student.getFirstName(), student.getAge());
                writer.append(studentData);
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время сохранения данных в файл.");
        }
    }
}
