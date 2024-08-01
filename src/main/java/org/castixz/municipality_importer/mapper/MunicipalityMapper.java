package org.castixz.municipality_importer.mapper;


import org.castixz.municipality_importer.dao.MunicipalityDAO;
import org.castixz.municipality_importer.dto.MunicipalityDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MunicipalityMapper {

    MunicipalityDAO toDAO(MunicipalityDTO municipalityDTO);
}
