package org.portal.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.portal.business.dao.CompanyDAO;
import org.portal.domain.Company;
import org.portal.domain.DataFixtures;
import org.portal.domain.UserAccount;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith({MockitoExtension.class})
class CreateCompanyProfileServiceTest {

    @InjectMocks
    CreateCompanyProfileService createCompanyProfileService;
    @Mock
    CreateUserAccountService createUserAccountService;
    @Mock
    CompanyDAO companyDAO;

    @Test
    void create() {
        //Given
        UserAccount userAccount = DataFixtures.someUserAccount1();
        Company company = DataFixtures.someCompanyProfile();

        Mockito.when(createUserAccountService.logNewUser(any(UserAccount.class))).thenReturn(userAccount);
        Mockito.when(companyDAO.saveCompanyProfile(company)).thenReturn(company);

        Company result = createCompanyProfileService.create(userAccount, company);

        Assertions.assertEquals(company,result);

    }
}