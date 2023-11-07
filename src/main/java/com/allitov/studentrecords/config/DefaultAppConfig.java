package com.allitov.studentrecords.config;

import com.allitov.studentrecords.beans.DefaultStudentManager;
import com.allitov.studentrecords.beans.StudentManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefaultAppConfig {

    @Bean
    public StudentManager studentManager() {
        return new DefaultStudentManager();
    }
}
