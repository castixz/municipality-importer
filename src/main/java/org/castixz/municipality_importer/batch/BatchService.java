package org.castixz.municipality_importer.batch;

import org.castixz.municipality_importer.enums.TaskType;

public interface BatchService {

    void runJobByJobType(TaskType taskType);
}
