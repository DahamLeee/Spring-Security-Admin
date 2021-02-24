package com.atsens.corespringsecurity.config;

import com.atsens.corespringsecurity.repository.ResourcesRepository;
import com.atsens.corespringsecurity.service.SecurityResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository) {
        SecurityResourceService SecurityResourceService = new SecurityResourceService(resourcesRepository);
        return SecurityResourceService;
    }

}
