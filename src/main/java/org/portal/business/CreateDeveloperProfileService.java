package org.portal.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.portal.business.dao.DeveloperProfileDAO;
import org.portal.business.dao.UserAccountDAO;
import org.portal.domain.DeveloperProfile;
import org.portal.domain.UserAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class CreateDeveloperProfileService {

    DeveloperProfileDAO developerProfileDAO;
    UserAccountDAO userAccountDAO;
    CreateUserAccountService userAccountService;

    @Transactional
    public DeveloperProfile create (UserAccount registeredUser, DeveloperProfile developerProfile){

        UserAccount userAccount = userAccountService.logNewUser(registeredUser);
        String givenEmail = userAccount.getEmail();
        DeveloperProfile profile = DeveloperProfile.builder()
                .userAccountEmail(givenEmail)
                .name(developerProfile.getName())
                .surname(developerProfile.getSurname())
                .dateOfBirth(developerProfile.getDateOfBirth())
                .gender(developerProfile.getGender())
                .profileStatus(developerProfile.getProfileStatus())
                .build();

        return developerProfileDAO.saveDeveloperProfile(profile);
    }

}
