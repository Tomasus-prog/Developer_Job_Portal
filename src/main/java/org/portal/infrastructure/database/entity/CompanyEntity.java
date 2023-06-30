package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "companyId")
@ToString(of = {"companyName","size","industry"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "size")
    private Integer size;
    @Column(name = "website")
    private String website;
    @Column(name = "industry")
    private String industry;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccountEntity userAccount;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "company")
    private Set<JobAdEntity> jobAds;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "company")
    private Set<DeveloperProfileActivityEntity> developerProfileActivities;


}
