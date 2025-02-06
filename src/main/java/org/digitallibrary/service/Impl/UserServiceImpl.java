package org.digitallibrary.service.Impl;

import jakarta.validation.ConstraintViolationException;
import org.digitallibrary.advice.exception.RecordNotFoundException;
import org.digitallibrary.dto.LoginRequest;
import org.digitallibrary.dto.RegisterRequest;
import org.digitallibrary.model.User;
import org.digitallibrary.model.enums.UserRole;
import org.digitallibrary.repository.UserRepository;
import org.digitallibrary.security.JwtService;
import org.digitallibrary.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public abstract class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           JwtService jwtService,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));
        userRepository.findByUsernameOrEmailAddress(loginRequest.getUsernameOrEmail(), loginRequest.getUsernameOrEmail())
                .orElseThrow(() -> new RecordNotFoundException("Wrong user credentials, please try again"));
        var user = (User) authentication.getPrincipal();
        return jwtService.generateJwtToken(user);
    }

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new ConstraintViolationException("Username is already taken!", null);
        }
        User user = new User();

        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmailAddress(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setUserRole(UserRole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setDateCreated(Instant.now());
    }
}
