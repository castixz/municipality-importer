package org.castixz.municipalityimporter.tasks;

import org.castixz.municipalityimporter.enums.TaskResult;

public interface BatchTask {

    TaskResult execute();
}
