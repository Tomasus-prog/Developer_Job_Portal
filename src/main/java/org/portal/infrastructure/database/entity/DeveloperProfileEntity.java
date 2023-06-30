package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "developerProfileId")
@ToString(of = {"name","surname","dateOfBirth","profileStatus"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "developer_profile")
public class DeveloperProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_profile_id")
    private Integer developerProfileId;
    @Column(name ="name" )
    private String name;
    @Column(name ="surname" )
    private String surname;
    @Column(name ="gender" )
    private String gender;
    @Column(name ="date_of_birth" )
    private LocalDate dateOfBirth;

    @Column(name ="profile_status" )
    private Boolean profileStatus;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id")
    private UserAccountEntity userAccount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "profile_image_id")
    private ProfileImageEntity profileImage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "developerProfile")
    private Set<ExperienceDetailsEntity> experienceDetailsEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "developerProfile")
    private Set<EducationDetailsEntity> educationDetailsEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "developerProfile")
    private Set<DeveloperSkillEntity> developerSkills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "developerProfile")
    private Set<DeveloperProfileActivityEntity> developerActivities;

}


