package org.portal.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperUserAccountDTO {

    private String email;
    private String password;
    private String rePassword;
    private String phone;

}
