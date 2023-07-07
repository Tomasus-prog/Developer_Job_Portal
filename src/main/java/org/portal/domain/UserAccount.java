package org.portal.domain;

import lombok.*;

@Value
@With
@Builder
@EqualsAndHashCode(of = {"email", "phone"})
@ToString(of = {"email", "phone", "userType"})
public class UserAccount {

    String email;
    String phone;
    String password;
    String userType;

    public Boolean checkTypeOfUser() {
        return userType.equals("RECRUITER");
    }
}
