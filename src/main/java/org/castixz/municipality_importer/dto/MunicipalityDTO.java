package org.castixz.municipality_importer.dto;

import lombok.Builder;

@Builder
public record MunicipalityDTO (
    String code,
    String name){
}
