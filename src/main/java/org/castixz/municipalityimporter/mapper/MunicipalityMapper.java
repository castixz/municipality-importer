package org.castixz.municipalityimporter.mapper;


import org.castixz.municipalityimporter.dao.MunicipalityDAO;
import org.castixz.municipalityimporter.dto.MunicipalityDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MunicipalityMapper {

    MunicipalityDAO toDAO(MunicipalityDTO municipalityDTO);
}
