package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "skillSetId")
@ToString(of = {"name",})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill_set")
public class SkillSetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_set_id")
    private Integer skillSetId;

    @Column(name = "name")
    private String name;


    @OneToMany (fetch = FetchType.LAZY, mappedBy = "skillSet")
    private Set<DeveloperSkillEntity> developerSkills;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "skillSet")
    private Set<JobAdSkillEntity> jobAdSkills;
}
