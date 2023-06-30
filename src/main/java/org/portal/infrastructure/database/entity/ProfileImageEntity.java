package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "profileImageId")
@ToString(of = {"imageName"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile_image")
public class ProfileImageEntity {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="profile_image_id")
            private Integer profileImageId;

            @Column(name="image_name")
            private String imageName;

            @Column (name="image")
            private byte [] image;

            @OneToOne(fetch = FetchType.LAZY,mappedBy = "profileImage")
            private DeveloperProfileEntity developerProfile;

}
