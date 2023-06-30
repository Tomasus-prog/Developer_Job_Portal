package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "jobTypeId")
@ToString(of = {"jobTypeName"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_type")
public class JobTypeEntity {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="job_type_id")
            private Integer jobTypeId;

            @Column(name="job_type_name")
            private String jobTypeName;

            @OneToMany (fetch = FetchType.LAZY, mappedBy = "jobType")
            private Set<JobAdEntity> jobAds;

}
