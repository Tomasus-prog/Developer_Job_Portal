package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "jobAdSkillId")
@ToString(of = {"level"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_ad_skill")
public class JobAdSkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_ad_skill_id")
    private Integer jobAdSkillId;

    @Column(name = "level")
    private String level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_ad_id")
    private JobAdEntity jobAd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_set_id")
    private SkillSetEntity skillSet;



}
