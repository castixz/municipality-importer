package org.castixz.municipalityimporter.batch;

import org.castixz.municipalityimporter.enums.TaskType;
import org.castixz.municipalityimporter.tasks.BatchTask;

interface BatchTaskFactory {

    BatchTask getBatchTask(TaskType taskType);
}
