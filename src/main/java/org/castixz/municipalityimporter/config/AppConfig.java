package org.castixz.municipalityimporter.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.castixz.municipalityimporter.enums.TaskType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class AppConfig {
    private TaskType taskType;
}
