package org.portal.infrastructure.database.repository.jpa;

import org.portal.domain.UserAccount;
import org.portal.infrastructure.database.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountJpaRepository extends JpaRepository <UserAccountEntity,Integer> {

    Optional<UserAccount> findByEmail(String email);
}
