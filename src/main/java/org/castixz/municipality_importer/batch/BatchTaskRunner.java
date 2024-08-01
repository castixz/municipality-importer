package org.castixz.municipality_importer.batch;

import org.castixz.municipality_importer.tasks.BatchTask;

interface BatchTaskRunner {

    void run(BatchTask job);
}
