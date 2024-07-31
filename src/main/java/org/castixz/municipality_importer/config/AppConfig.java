package org.castixz.municipality_importer.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.castixz.municipality_importer.enums.TaskType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class AppConfig {
    private TaskType taskType;
}
