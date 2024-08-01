package org.castixz.municipality_importer.batch;

import org.castixz.municipality_importer.enums.TaskType;
import org.castixz.municipality_importer.tasks.BatchTask;

interface BatchTaskFactory {

    BatchTask getBatchJob(TaskType taskType);
}
