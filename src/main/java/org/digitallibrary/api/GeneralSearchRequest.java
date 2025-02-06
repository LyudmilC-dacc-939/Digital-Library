package org.digitallibrary.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.digitallibrary.model.Book;
import org.digitallibrary.security.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@Getter
@Setter
@Slf4j
public class GeneralSearchRequest {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    public Book fetchGeneralSearch(String searchQuery) throws IOException {
        final HttpURLConnection connection = getHttpURLConnection(searchQuery);
        connection.setRequestProperty("Authorization", "Bearer " + getJwtToken());
        System.out.println(applicationConfiguration.getCurrentUserEmail());
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(responseStream, Book.class);
        } else {
            log.error("GET Request for fetchGeneralSearch: " + responseCode);
            throw new IOException("GET request failed. Response Code: " + responseCode);
        }
    }

    private HttpURLConnection getHttpURLConnection(String searchQuery) throws IOException {
        String formattedStringInput = searchQuery.trim().replaceAll("\\s", "+");
        String urlString = String.format("https://openlibrary.org/search.json?q=%s", formattedStringInput);

        HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
        connection.setRequestMethod("GET");

        // Using the injected userEmail in the User-Agent header
        connection.setRequestProperty
                ("User-Agent", "Digital Library/v1.1.0-alpha (" + applicationConfiguration.getCurrentUserEmail() + ")");
        connection.setRequestProperty("accept", "application/json");
        return connection;
    }

    private String getJwtToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getCredentials() instanceof String) {
            return (String) authentication.getCredentials();
        }
        return "";
    }
}
