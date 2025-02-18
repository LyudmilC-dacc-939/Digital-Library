package org.digitallibrary.service;

import org.digitallibrary.dto.LoginRequest;
import org.digitallibrary.dto.RegisterRequest;
import org.digitallibrary.model.User;

public interface UserService {

    String loginUser(LoginRequest loginRequest);

    User findByEmail(String email);

    void registerUser(RegisterRequest registerRequest);
}