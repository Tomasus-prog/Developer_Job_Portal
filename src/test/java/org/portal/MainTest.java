package org.portal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.portal.infrastructure.configurationtest.ApplicationConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@Testcontainers
@SpringJUnitConfig(classes = {ApplicationConfiguration.class})
class MainTest {
    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15.0");
    @DynamicPropertySource
    static void postgreSqlProperties (DynamicPropertyRegistry registry){
        registry.add("jdbc.url", postgreSQLContainer::getJdbcUrl);
        registry.add("jdbc.user", postgreSQLContainer::getUsername);
        registry.add("jdbc.pass", postgreSQLContainer::getPassword);
    }
    @Test
    void main() {

    }
}