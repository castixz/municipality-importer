package org.castixz.municipalityimporter.dto;

import lombok.Builder;

@Builder
public record MunicipalityPartDTO(
        String code,
        String name,
        String mainMunicipality) {
}
