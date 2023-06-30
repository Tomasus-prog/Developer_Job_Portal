package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "jobAdId")
@ToString(of = {"title", "datePosted",})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_ad")
public class JobAdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_ad_id")
    private Integer jobAdId;

    @Column(name = "title")
    private String title;
    @Column(name = "date_posted")
    private String datePosted;
    @Column(name = "location")
    private String location;
    @Column(name = "work_remote")
    private String workRemote;
    @Column(name = "salary")
    private String salary;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_type_id")
    private JobTypeEntity jobType;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "jobAd")
    private Set<JobAdSkillEntity> jobAdSkills;

}
