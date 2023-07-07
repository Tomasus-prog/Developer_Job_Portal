package org.portal.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.portal.business.dao.UserAccountDAO;
import org.portal.domain.UserAccount;
import org.portal.infrastructure.database.entity.UserAccountEntity;
import org.portal.infrastructure.database.repository.jpa.UserAccountJpaRepository;
import org.portal.infrastructure.database.repository.mapper.UserAccountEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserAccountRepository implements UserAccountDAO {

    private final UserAccountJpaRepository userAccountJpaRepository;
    private final UserAccountEntityMapper userAccountEntityMapper;


    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        UserAccountEntity toSave = userAccountEntityMapper.mapToEntity(userAccount);
        UserAccountEntity saved = userAccountJpaRepository.saveAndFlush(toSave);
        return userAccountEntityMapper.mapFromEntity(saved) ;
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userAccountJpaRepository.findByEmail(email);
    }


}
