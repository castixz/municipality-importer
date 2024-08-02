package org.castixz.municipalityimporter.batch;

import lombok.extern.slf4j.Slf4j;
import org.castixz.municipalityimporter.enums.TaskResult;
import org.castixz.municipalityimporter.tasks.BatchTask;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class BatchTaskRunnerImpl implements BatchTaskRunner {

    @Override
    public TaskResult run(BatchTask job) {
        log.info("Triggering execution of task");
        var result = job.execute();
        log.info("Task has been executed");
        return result;
    }
}
