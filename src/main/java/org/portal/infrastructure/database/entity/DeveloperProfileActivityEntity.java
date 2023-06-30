package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@EqualsAndHashCode(of = "developerProfileActivityId")
@ToString(of = {"statusEmployment","dateEmployment"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "developer_profile_activity")
public class DeveloperProfileActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_profile_activity_id")
    private Integer developerProfileActivityId;
    @Column(name ="status_employment" )
    private String statusEmployment;
    @Column(name ="date_employment" )
    private LocalDate dateEmployment;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name= "company_id")
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_profile_id")
    private DeveloperProfileEntity developerProfile;

}
