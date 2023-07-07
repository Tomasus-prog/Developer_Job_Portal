package org.portal.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.portal.business.dao.CompanyDAO;
import org.portal.domain.Company;
import org.portal.infrastructure.database.entity.CompanyEntity;
import org.portal.infrastructure.database.repository.jpa.CompanyJpaRepository;
import org.portal.infrastructure.database.repository.mapper.CompanyEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CompanyRepository implements CompanyDAO {
    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyEntityMapper companyEntityMapper;

    @Override
    public Company saveCompanyProfile(Company profile) {
        CompanyEntity toSave = companyEntityMapper.mapToEntity(profile);
        CompanyEntity saved = companyJpaRepository.saveAndFlush(toSave);
        return companyEntityMapper.mapFromEntity(saved);
    }
}
