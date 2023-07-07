package org.portal.domain;

import lombok.*;

@Value
@With
@Builder
@EqualsAndHashCode(of = {"companyName", "website"})
@ToString(of = {"companyName", "size", "website", "industry"})
public class Company {

    String userAccountEmail;
    String companyName;
    Integer size;
    String website;
    String industry;
    String description;

}
