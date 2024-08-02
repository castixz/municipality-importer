package org.castixz.municipalityimporter.dto;

import lombok.Builder;

@Builder
public record MunicipalityDTO (
    String code,
    String name){
}
