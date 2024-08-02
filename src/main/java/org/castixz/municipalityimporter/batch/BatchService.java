package org.castixz.municipalityimporter.batch;

import org.castixz.municipalityimporter.enums.TaskType;

public interface BatchService {

    void runJobByJobType(TaskType taskType);
}
