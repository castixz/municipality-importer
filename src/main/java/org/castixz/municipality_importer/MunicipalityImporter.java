package org.castixz.municipality_importer;

import org.castixz.municipality_importer.batch.BatchService;
import org.castixz.municipality_importer.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MunicipalityImporter {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(MunicipalityImporter.class, args);
		var appConfig = ctx.getBean(AppConfig.class);
		var batchService = ctx.getBean(BatchService.class);
		batchService.runJobByJobType(appConfig.getTaskType());
		System.exit(0);
	}

}
