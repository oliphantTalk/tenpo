package com.tenpo.tenpo.api.session;

import com.tenpo.tenpo.controller.validation.IsValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginRq {

    @NotNull
    @NotEmpty
    @IsValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

}
