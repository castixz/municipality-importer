package org.castixz.municipality_importer.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.castixz.municipality_importer.enums.TaskType;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BatchServiceImpl implements BatchService {

    private final BatchTaskFactory batchTaskFactory;

    private final BatchTaskRunner batchTaskRunner;

    @Override
    public void runJobByJobType(TaskType taskType) {
        log.info("Fetching job for jobType: {}", taskType.toString());
        var batchJob = batchTaskFactory.getBatchJob(taskType);
        batchTaskRunner.run(batchJob);
    }
}
