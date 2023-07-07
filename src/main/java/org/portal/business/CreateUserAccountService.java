package org.portal.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.portal.business.dao.UserAccountDAO;
import org.portal.domain.UserAccount;
import org.portal.infrastructure.database.entity.UserType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class CreateUserAccountService {
        private final UserAccountDAO userAccountDAO;

    @Transactional
    public UserAccount logNewUser(UserAccount userAccount) {
        UserAccount newUserAccount = null;
        if (checkUserIfExists(userAccount.getEmail())) {
            log.info("Try with other email");
        } else {
            newUserAccount = userAccount.getUserType().equals("RECRUITER") ?
                    processRegistryAsEmployer(userAccount) :
                    processRegistryAsDeveloper(userAccount);
        }
        return newUserAccount;
    }


    private boolean checkUserIfExists(String email) {
        Optional<UserAccount> userExisting = userAccountDAO.findByEmail(email);
        if(userExisting.isPresent()) {
            throw new RuntimeException("This email is already exists, please give another one");
        }else {
            return false;
        }
    }

    private UserAccount processRegistryAsEmployer(UserAccount userAccount) {
        UserAccount newCompanyUser = UserAccount.builder()
                .email(userAccount.getEmail())
                .phone(userAccount.getPhone())
                .password(userAccount.getPassword())
                .userType(UserType.RECRUITER.toString()).build();
        return userAccountDAO.saveUserAccount(newCompanyUser);
    }

    private UserAccount processRegistryAsDeveloper(UserAccount userAccount) {
        UserAccount newDeveloperUser = UserAccount.builder()
                .email(userAccount.getEmail())
                .phone(userAccount.getPhone())
                .password(userAccount.getPassword())
                .userType(UserType.JOB_SEEKER.toString()).build();
        return userAccountDAO.saveUserAccount(newDeveloperUser);
    }


}
