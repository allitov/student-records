package com.allitov.studentrecords.beans;

import java.util.HashSet;

public class DefaultStudentManager extends AbstractStudentManager {

    public DefaultStudentManager() {
        super(new HashSet<>());
    }
}
