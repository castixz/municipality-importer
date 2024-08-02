package org.castixz.municipalityimporter.tasks;

import org.castixz.municipalityimporter.enums.TaskType;

interface TaskFactory {

    Task getBatchTask(TaskType taskType);
}
