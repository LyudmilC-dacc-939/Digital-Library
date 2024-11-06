package org.digitallibrary.runner;

import org.digitallibrary.model.User;
import org.digitallibrary.model.enums.UserRole;
import org.digitallibrary.repository.UserRepository;
import org.digitallibrary.service.CsvReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Order(1)
public class AdminUserRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CsvReaderService csvReaderService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<String[]> userFromCsv = csvReaderService.readAdminDetailsFromCsv("docs/adminAsset.csv");
        createAdminUser(userFromCsv);
    }

    private void createAdminUser(List<String[]> usersFromCSV) throws Exception {

        for (String[] userData : usersFromCSV) {

            User newUser_Admin = new User();
            newUser_Admin.setUsername(String.valueOf(userData[0]));
            newUser_Admin.setFirstName(String.valueOf(userData[1]));
            newUser_Admin.setLastName(String.valueOf(userData[2]));
            newUser_Admin.setEmailAddress(String.valueOf(userData[3]));
            newUser_Admin.setPassword(passwordEncoder.encode(userData[4].trim())); // Encode the password
            newUser_Admin.setUserRole(UserRole.valueOf(userData[5]));
            newUser_Admin.setDateCreated(Instant.now());

            if (userRepository.findByUsername(newUser_Admin.getUsername()).isEmpty()) {
                userRepository.save(newUser_Admin);
            }
        }
    }
}
