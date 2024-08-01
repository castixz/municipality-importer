package org.castixz.municipality_importer.parser;

import lombok.Getter;
import org.castixz.municipality_importer.dto.MunicipalityDTO;
import org.castixz.municipality_importer.dto.MunicipalityPartDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class MunicipalityParsingResultManager {
        private final List<MunicipalityDTO> municipalities = new ArrayList<>();
        private final List<MunicipalityPartDTO> municipalityParts = new ArrayList<>();

        public void addMunicipality(MunicipalityDTO municipality){
            municipalities.add(municipality);
        }

        public void addMunicipalityPart(MunicipalityPartDTO municipalityPart){
            municipalityParts.add(municipalityPart);
        }

        public MunicipalityParsingResult getResult(){
            return new MunicipalityParsingResult(municipalities,municipalityParts);
        }
}
