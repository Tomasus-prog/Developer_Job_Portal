package org.portal.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.portal.domain.Company;
import org.portal.domain.UserAccount;
import org.portal.infrastructure.database.entity.CompanyEntity;
import org.portal.infrastructure.database.entity.UserAccountEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserAccountEntityMapper {

    UserAccountEntity mapToEntity(UserAccount userAccount);

    UserAccount mapFromEntity(UserAccountEntity entity);
}
