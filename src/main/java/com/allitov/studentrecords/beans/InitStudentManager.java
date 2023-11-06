package com.allitov.studentrecords.beans;

import com.allitov.studentrecords.data.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.UUID;

public class InitStudentManager extends AbstractStudentManager {

    @Value("${app.loading-file.path}")
    private String loadingFilePath;

    public InitStudentManager() {
        super(new HashSet<>());
    }

    @PostConstruct
    private void deserializeData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(loadingFilePath))) {
            while (reader.ready()) {
                String contactData = reader.readLine();
                String[] data = contactData.split(";");
                if (data.length != 4) {
                    continue;
                }

                UUID uuid;
                int age;
                try {
                    uuid = UUID.fromString(data[0]);
                    age = Integer.parseInt(data[3]);
                } catch (IllegalArgumentException e) {
                    continue;
                }

                Student student = Student.builder()
                        .id(uuid)
                        .lastName(data[1])
                        .firstName(data[2])
                        .age(age)
                        .build();
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла.");
        }
    }
}
