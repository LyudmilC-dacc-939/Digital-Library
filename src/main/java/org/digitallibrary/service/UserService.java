package org.digitallibrary.service;

import org.digitallibrary.dto.LoginRequest;

public interface UserService {

    String loginUser(LoginRequest loginRequest);
}