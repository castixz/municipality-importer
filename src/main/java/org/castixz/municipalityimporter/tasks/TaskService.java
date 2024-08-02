package org.castixz.municipalityimporter.tasks;

import org.castixz.municipalityimporter.enums.TaskType;

public interface TaskService {

    void runJobByJobType(TaskType taskType);
}
