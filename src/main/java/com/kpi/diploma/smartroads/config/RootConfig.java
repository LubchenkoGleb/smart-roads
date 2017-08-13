package com.kpi.diploma.smartroads.config;

import com.kpi.diploma.smartroads.config.db.UserCascadeSaveEL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class RootConfig {
    @Bean
    public UserCascadeSaveEL userCascadingMongoEventListener() {
        return new UserCascadeSaveEL();
    }
}
