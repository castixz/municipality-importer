package org.castixz.municipalityimporter.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.castixz.municipalityimporter.enums.TaskResult;
import org.castixz.municipalityimporter.enums.TaskType;
import org.castixz.municipalityimporter.exceptions.TaskExecutionFailed;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskFactory taskFactory;

    private final TaskRunner taskRunner;

    @Override
    public void runJobByJobType(TaskType taskType) {
        var batchTask = taskFactory.getBatchTask(taskType);
        var result = taskRunner.run(batchTask);
        if (TaskResult.FAIL == result) throw new TaskExecutionFailed("Task has failed");
    }
}
