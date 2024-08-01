package org.castixz.municipality_importer.parser;

import lombok.Getter;
import org.castixz.municipality_importer.dto.MunicipalityDTO;
import org.castixz.municipality_importer.dto.MunicipalityPartDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class MunicipalityParsingResultManager {
    private static final Logger log = LoggerFactory.getLogger(MunicipalityParsingResultManager.class);
    private final List<MunicipalityDTO> municipalities = new ArrayList<>();
        private final List<MunicipalityPartDTO> municipalityParts = new ArrayList<>();

        public void addMunicipality(MunicipalityDTO municipality){
            municipalities.add(municipality);
        }

        public void addMunicipalityPart(MunicipalityPartDTO municipalityPart){
            log.debug("Adding municipality part with code: {}",municipalityPart.code());
            municipalityParts.add(municipalityPart);
        }

        public MunicipalityParsingResult getResult(){
            log.info("Returning parsing result to the client. Parsing result has {} municipalities and {} municipality parts"
            , municipalities.size(), municipalityParts.size());
            return new MunicipalityParsingResult(municipalities,municipalityParts);
        }
}
