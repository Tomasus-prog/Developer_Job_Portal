package org.portal.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "userTypeId")
@ToString(of = {"userTypeName"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_type")
public class UserTypeEntity{

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="user_type_id")
            private Integer userTypeId;

            @Column(name="user_type_name")
            private String userTypeName;

            @OneToMany(fetch = FetchType.LAZY,mappedBy = "userType")
            private Set<UserAccountEntity> userAccounts;

}
