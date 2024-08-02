package org.castixz.municipalityimporter.tasks;

import org.castixz.municipalityimporter.enums.TaskResult;

interface Task {

    TaskResult execute();
}
