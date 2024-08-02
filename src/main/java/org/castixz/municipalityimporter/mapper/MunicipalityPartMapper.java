package org.castixz.municipalityimporter.mapper;


import org.castixz.municipalityimporter.dao.MunicipalityPartDAO;
import org.castixz.municipalityimporter.dto.MunicipalityPartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MunicipalityPartMapper {

    @Mapping(target = "mainMunicipality", ignore = true)
    MunicipalityPartDAO toDAO(MunicipalityPartDTO municipalityPartDTO);
}
