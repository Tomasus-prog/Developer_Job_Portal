package org.portal.infrastructure.configurationtest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan (basePackages = "org.example.persistanceLayerTest")
@Import(PersistenceJpaConfiguration.class)
public class ApplicationConfiguration {

}
