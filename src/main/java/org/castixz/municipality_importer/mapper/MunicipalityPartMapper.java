package org.castixz.municipality_importer.mapper;


import org.castixz.municipality_importer.dao.MunicipalityPartDAO;
import org.castixz.municipality_importer.dto.MunicipalityPartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MunicipalityPartMapper {

    @Mapping(target = "mainMunicipality", ignore = true)
    MunicipalityPartDAO toDAO(MunicipalityPartDTO municipalityPartDTO);
}
