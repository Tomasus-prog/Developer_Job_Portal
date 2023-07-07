package org.portal.domain;

import lombok.*;

@Value
@With
@Builder
@EqualsAndHashCode(of = {"surname", "dateOfBirth"})
@ToString(of = {"name", "surname",  "profileStatus"})
public class DeveloperProfile {

    String userAccountEmail;
    String name;
    String surname;
    String gender;
    String dateOfBirth;
    String profileStatus;

}
