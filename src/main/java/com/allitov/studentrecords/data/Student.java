package com.allitov.studentrecords.data;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Student {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final int age;

    public String toString() {
        return String.format("Студент %s: %s %s; Возвраст: %d", id.toString(), lastName, firstName, age);
    }
}
