package org.castixz.municipality_importer.repository;

import org.castixz.municipality_importer.dao.MunicipalityPartDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityPartRepository extends JpaRepository<MunicipalityPartDAO, Integer> {
}
