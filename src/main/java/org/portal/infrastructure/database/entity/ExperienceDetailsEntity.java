package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "experienceId")
@ToString(of = {"jobPosition", "employerName","endDate"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experience_details")
public class ExperienceDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private Integer experienceId;

    @Column(name = "job_position")
    private String jobPosition;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_profile_id")
    private DeveloperProfileEntity developerProfile;


}
