package org.castixz.municipalityimporter.batch;

import org.castixz.municipalityimporter.tasks.BatchTask;

interface BatchTaskRunner {

    void run(BatchTask job);
}
