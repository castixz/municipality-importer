package org.castixz.municipality_importer;

import lombok.extern.slf4j.Slf4j;
import org.castixz.municipality_importer.batch.BatchService;
import org.castixz.municipality_importer.config.AppConfig;
import org.castixz.municipality_importer.repository.MunicipalityPartRepository;
import org.castixz.municipality_importer.repository.MunicipalityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class MunicipalityImporter {


	public static void main(String[] args) {
		var ctx = SpringApplication.run(MunicipalityImporter.class, args);
		var appConfig = ctx.getBean(AppConfig.class);
		var batchService = ctx.getBean(BatchService.class);
		log.info("Starting batch service with following task type: {}", appConfig.getTaskType().toString());
		batchService.runJobByJobType(appConfig.getTaskType());
		log.info("Done - the program will be terminated");
		System.exit(0);
	}

	@Bean
	CommandLineRunner commandLineRunner(MunicipalityPartRepository municipalityPartRepository, MunicipalityRepository municipalityRepository) {
		return args -> {
			log.info("Deleting all records from DB");
			municipalityPartRepository.deleteAll();
			municipalityRepository.deleteAll();
		};
	}

}
