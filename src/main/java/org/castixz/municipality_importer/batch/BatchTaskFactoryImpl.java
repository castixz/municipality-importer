package org.castixz.municipality_importer.batch;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.castixz.municipality_importer.enums.TaskType;
import org.castixz.municipality_importer.tasks.BatchTask;
import org.castixz.municipality_importer.tasks.ImportMunicipalityTask;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
class BatchTaskFactoryImpl implements BatchTaskFactory {

    private final Map<TaskType, BatchTask> REGISTERED_JOBS = new HashMap<>();

    private final ApplicationContext applicationContext;

    @Override
    public BatchTask getBatchJob(TaskType taskType) {
        return REGISTERED_JOBS.get(taskType);
    }

    @PostConstruct
    private void register(){
        REGISTERED_JOBS.put(TaskType.MUNICIPALITY_IMPORT, applicationContext.getBean(ImportMunicipalityTask.class));
    }

}
