package org.digitallibrary.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotNull(message = "First name cannot be null!")
    @Size(min = 2, max = 255, message = "First name must be between {min} and {max} characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null!")
    @Size(min = 2, max = 255, message = "Last name must be between {min} and {max} characters")
    private String lastName;

    @NotNull(message = "Email cannot be null!")
    @Size(min = 5, max = 255, message = "Mail must be between {min} and {max} characters")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid Email")
    private String email;

    @NotNull(message = "Username cannot be null!")
    @Size(min = 5, max = 25, message = "Username must be between {min} and {max} characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])\\S+$\n",
            message = "Invalid username")
    private String username;

    @NotNull(message = "Password cannot be null!")
    @Size(min = 8, max = 30, message = "User's password must be between {min} and {max} symbols")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,}$",
            message = "The user’s password must consist at least one numeric, one lowercase, one uppercase and one special characters")
    private String password;

    @NotNull(message = "Repeated password cannot be null!")
    @Size(min = 8, max = 30, message = "Repeated password must be between {min} and {max} symbols")
    private String repeatPassword;
}
