package org.castixz.municipalityimporter.parser;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.castixz.municipalityimporter.dto.MunicipalityDTO;
import org.castixz.municipalityimporter.dto.MunicipalityPartDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Slf4j
public class MunicipalityParsingResultManager {
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
