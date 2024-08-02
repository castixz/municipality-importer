package org.castixz.municipalityimporter.parser;

import org.castixz.municipalityimporter.dto.MunicipalityDTO;
import org.castixz.municipalityimporter.dto.MunicipalityPartDTO;

import java.util.List;

public record MunicipalityParsingResult(List<MunicipalityDTO> municipalityDTOList,
                                        List<MunicipalityPartDTO> municipalityPartDTOList) {
}
