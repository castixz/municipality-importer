package org.castixz.municipality_importer.repository;

import org.castixz.municipality_importer.dao.MunicipalityDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<MunicipalityDAO, Integer> {

    MunicipalityDAO findByCode(String code);
}
