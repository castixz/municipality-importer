package org.castixz.municipalityimporter.tasks;

import org.castixz.municipalityimporter.enums.TaskResult;

interface TaskRunner {

    TaskResult run(Task job);
}
