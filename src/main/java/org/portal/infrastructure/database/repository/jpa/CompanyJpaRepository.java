package org.portal.infrastructure.database.repository.jpa;

import org.portal.infrastructure.database.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository <CompanyEntity,Integer> {

}
