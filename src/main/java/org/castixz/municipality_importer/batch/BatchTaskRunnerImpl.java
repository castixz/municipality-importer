package org.castixz.municipality_importer.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class BatchTaskRunnerImpl implements BatchTaskRunner {

    @Override
    public void run(BatchTask job) {
        log.info("Triggering execution of task");
        job.execute();
        log.info("Task has been executed");
    }
}
