package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "userAccountId")
@ToString(of = {"email","phone"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_account")
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_id")
    private Integer userAccountId;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id")
    private UserTypeEntity userType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userAccount")
    private CompanyEntity company;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userAccount")
    private DeveloperProfileEntity developerProfile;

}
