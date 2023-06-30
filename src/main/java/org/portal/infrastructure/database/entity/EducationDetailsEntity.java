package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "educationId")
@ToString(of = {"schoolName", "studyDirection"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education_details")
public class EducationDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Integer educationId;

    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "study_direction")
    private String studyDirection;
    @Column(name = "level_education")
    private String levelEducation;
    @Column(name = "completion_date")
    private String completionDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_profile_id")
    private DeveloperProfileEntity developerProfile;


}
