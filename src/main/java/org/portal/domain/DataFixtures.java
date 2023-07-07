package org.portal.domain;

import org.portal.infrastructure.database.entity.UserType;

public class DataFixtures {


    public static UserAccount someUserAccount1() {
        return UserAccount.builder()
                .email("milo@@gmail.com")
                .phone("+32 898 932 938")
                .password("Milo1202")
                .userType(String.valueOf(UserType.RECRUITER)).build();
    }

    static UserAccount someUserAccount2() {
        return UserAccount.builder()
                .email("lila@@gmail.com")
                .phone("+33 233 332 362")
                .password("Lilu20293")
                .userType(String.valueOf(UserType.JOB_SEEKER)).build();
    }

    public static Company someCompanyProfile() {
        return Company.builder()
                .userAccountEmail(someUserAccount1().getEmail())
                .companyName("Toyota")
                .size(140)
                .website("www.toyota.com")
                .industry("Factory")
                .description("It's long story").build();
    }
}


