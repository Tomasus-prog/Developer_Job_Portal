package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "developerSkillId")
@ToString(of = {"skillLevel"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "developer_skill")
public class DeveloperSkillEntity {


            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="developer_skill_id")
            private Integer developerSkillId;

            private Integer skillLevel;


            @ManyToOne (fetch = FetchType.LAZY)
            @JoinColumn (name = "developer_profile_id")
            private DeveloperProfileEntity developerProfile;

            @ManyToOne (fetch = FetchType.LAZY)
            @JoinColumn (name = "skill_set_id")
            private SkillSetEntity skillSet;


}
