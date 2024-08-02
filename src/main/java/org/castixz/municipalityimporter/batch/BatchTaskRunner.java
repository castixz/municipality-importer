package org.castixz.municipalityimporter.batch;

import org.castixz.municipalityimporter.enums.TaskResult;
import org.castixz.municipalityimporter.tasks.BatchTask;

interface BatchTaskRunner {

    TaskResult run(BatchTask job);
}
