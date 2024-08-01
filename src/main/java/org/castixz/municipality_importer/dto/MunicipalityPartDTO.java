package org.castixz.municipality_importer.dto;

import lombok.Builder;

@Builder
public record MunicipalityPartDTO(
        String code,
        String name,
        String mainMunicipality) {
}
