package org.castixz.municipalityimporter.tasks;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.castixz.municipalityimporter.enums.TaskType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
class TaskFactoryImpl implements TaskFactory {

    private final Map<TaskType, Task> REGISTERED_TASKS = new HashMap<>();

    private final ApplicationContext applicationContext;

    @Override
    public Task getBatchTask(TaskType taskType) {
        log.info("Retuning task: {}", taskType.toString());
        return REGISTERED_TASKS.get(taskType);
    }

    @PostConstruct
    private void register(){
        log.debug("Registering tasks started");
        REGISTERED_TASKS.put(TaskType.MUNICIPALITY_IMPORT, applicationContext.getBean(ImportMunicipalityTask.class));
        log.debug("Registering tasks finished");
    }

}
