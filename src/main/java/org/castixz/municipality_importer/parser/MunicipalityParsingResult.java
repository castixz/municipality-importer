package org.castixz.municipality_importer.parser;

import org.castixz.municipality_importer.dto.MunicipalityDTO;
import org.castixz.municipality_importer.dto.MunicipalityPartDTO;

import java.util.List;

public record MunicipalityParsingResult(List<MunicipalityDTO> municipalityDTOList,
                                        List<MunicipalityPartDTO> municipalityPartDTOList) {
}
