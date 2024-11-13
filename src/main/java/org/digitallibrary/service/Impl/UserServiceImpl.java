package org.digitallibrary.service.Impl;

import org.digitallibrary.advice.exception.RecordNotFoundException;
import org.digitallibrary.dto.LoginRequest;
import org.digitallibrary.model.User;
import org.digitallibrary.repository.UserRepository;
import org.digitallibrary.security.JwtService;
import org.digitallibrary.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public abstract class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public UserServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
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
}
