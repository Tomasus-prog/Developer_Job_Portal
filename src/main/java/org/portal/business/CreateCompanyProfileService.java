package org.portal.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.portal.business.dao.CompanyDAO;
import org.portal.business.dao.UserAccountDAO;
import org.portal.domain.Company;
import org.portal.domain.UserAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class CreateCompanyProfileService {

    CompanyDAO companyDAO;
    UserAccountDAO userAccountDAO;
    CreateUserAccountService userAccountService;

    @Transactional
    public Company create (UserAccount registeredUser, Company company){

        UserAccount userAccount = userAccountService.logNewUser(registeredUser);
        String givenEmail = userAccount.getEmail();
        Company profile = Company.builder()
                .userAccountEmail(givenEmail)
                .companyName(company.getCompanyName())
                .size(company.getSize())
                .description(company.getDescription())
                .website(company.getWebsite())
                .industry(company.getIndustry())
                .build();

        return companyDAO.saveCompanyProfile(profile);
    }

}
