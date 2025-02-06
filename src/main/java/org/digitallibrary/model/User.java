package org.digitallibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.digitallibrary.model.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

@Entity(name = "USERS")
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, updatable = false)
    @Size(min = 6, max = 25, message = "Username must be between {min} and {max} characters")
    private String username;

    @Column(name = "first_name")
    @Size(min = 2, max = 40, message = "First name must be between {min} and {max} characters")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 60, message = "Last name must be between {min} and {max} characters")
    private String lastName;

    @Column(name = "email", nullable = false)
    @Size(min = 11, max = 100, message = "Email address must be between {min} and {max} characters")
    private String emailAddress;

    @Column(name = "password", nullable = false)
    @Size(min = 8, message = "User's password must be at least {min} characters long")
    private String password;

    private Instant dateCreated;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
