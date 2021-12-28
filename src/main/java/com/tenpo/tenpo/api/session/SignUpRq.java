package com.tenpo.tenpo.api.session;

import com.tenpo.tenpo.controller.validation.IsValidEmail;
import com.tenpo.tenpo.controller.validation.IsPasswordMatching;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@IsPasswordMatching
public class SignUpRq {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @IsValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @Min(18)
    @Max(100)
    private Integer age;

    @NotNull
    @NotEmpty
    private LocalDate birthDate;

    @NotNull
    @NotEmpty
    private String password;
    private String passwordConfirmation;

}