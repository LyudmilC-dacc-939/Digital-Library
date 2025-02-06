package org.digitallibrary.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotNull(message = "Username or email cannot be null")
    private String usernameOrEmail;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 30, message = "User’s password must be between {min} and {max} symbols")
    private String password;
}
