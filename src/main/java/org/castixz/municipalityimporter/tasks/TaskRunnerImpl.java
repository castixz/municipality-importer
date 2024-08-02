package org.castixz.municipalityimporter.tasks;

import lombok.extern.slf4j.Slf4j;
import org.castixz.municipalityimporter.enums.TaskResult;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class TaskRunnerImpl implements TaskRunner {

    @Override
    public TaskResult run(Task job) {
        log.info("Triggering execution of task");
        var result = job.execute();
        log.info("Task has been executed");
        return result;
    }
}
