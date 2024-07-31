package org.castixz.municipality_importer.batch;

import org.castixz.municipality_importer.enums.TaskType;

interface BatchTaskFactory {

    BatchTask getBatchJob(TaskType taskType);
}
