package com.allitov.studentrecords.config;

import com.allitov.studentrecords.beans.InitStudentManager;
import com.allitov.studentrecords.beans.StudentManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("init")
public class InitAppConfig {

    @Bean
    public StudentManager studentManager() {
        return new InitStudentManager();
    }
}
