package org.portal.business.dao;

import org.portal.domain.Company;
import org.portal.domain.UserAccount;

import java.util.Optional;

public interface UserAccountDAO {


    UserAccount saveUserAccount(UserAccount userAccount);


    Optional<UserAccount> findByEmail(String email);


}
