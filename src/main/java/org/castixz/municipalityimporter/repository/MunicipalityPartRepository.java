package org.castixz.municipalityimporter.repository;

import org.castixz.municipalityimporter.dao.MunicipalityPartDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityPartRepository extends JpaRepository<MunicipalityPartDAO, Integer> {
}
