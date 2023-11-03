package com.allitov.studentrecords.ui;

import com.allitov.studentrecords.beans.StudentManager;
import com.allitov.studentrecords.data.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class StudentRecordsUI {

    private final StudentManager studentManager;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @ShellMethod(key = "p")
    public String printAllStudents() {
        List<Student> result = studentManager.getAllStudents();

        return result.isEmpty() ? "Список пуст." :
                result.stream().map(Student::toString).collect(Collectors.joining(LINE_SEPARATOR));
    }

    @ShellMethod(key = "a")
    public String addStudent(@ShellOption(value = "ln") String lastName,
                             @ShellOption(value = "fn") String firstName,
                             int age) {
        Student student = Student.builder()
                .id(UUID.randomUUID())
                .lastName(lastName)
                .firstName(firstName)
                .age(age)
                .build();
        boolean result = studentManager.saveStudent(student);

        return result ? "Данные сохранены." : "Такая запись уже есть.";
    }

    @ShellMethod(key = "d")
    public String deleteStudentById(String id) {
        boolean result = studentManager.removeStudentById(id);

        return result ? "Запись удалена." : "Запись не найдена.";
    }

    @ShellMethod(key = "da")
    public String deleteAllStudents() {
        boolean result = studentManager.removeAllStudents();

        return result ? "Все записи удалены." : "Что-то пошло не так.";
    }

    @ShellMethod(key = "e")
    public void exit() {
        System.exit(0);
    }
}
