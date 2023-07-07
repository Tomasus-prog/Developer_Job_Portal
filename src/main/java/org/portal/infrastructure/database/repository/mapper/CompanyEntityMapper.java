package org.portal.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.portal.domain.Company;
import org.portal.infrastructure.database.entity.CompanyEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyEntityMapper {

    Company mapFromEntity(CompanyEntity companyEntity);

    CompanyEntity mapToEntity(Company company);
}
