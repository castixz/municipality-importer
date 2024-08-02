package org.castixz.municipalityimporter.repository;

import org.castixz.municipalityimporter.dao.MunicipalityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<MunicipalityDAO, Integer> {

    MunicipalityDAO findByCode(String code);
}
