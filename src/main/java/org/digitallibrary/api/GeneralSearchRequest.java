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

    public String buildApiUrl(String query, String searchType) {
        String baseUrl = "https://openlibrary.org/search.json?";
        String formattedQuery = query.trim().replaceAll("\\s", "+");

        switch (searchType) {
            case "Title":
                return baseUrl + "q=" + formattedQuery;
            case "Author":
                return baseUrl + "author=" + formattedQuery;
            case "Subject":
                return baseUrl + "subject=" + formattedQuery;
            default:
                return baseUrl + "q=" + formattedQuery;
        }
    }

    /**
     * Builds and returns an HttpURLConnection for the given search query.
     */
    private HttpURLConnection getHttpURLConnection(String apiUrl) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        connection.setRequestProperty(
                "User-Agent", "Digital Library/v1.1.0-alpha (" + applicationConfiguration.getCurrentUserEmail() + ")");
        connection.setRequestProperty("accept", "application/json");
        return connection;
    }

    /**
     * Fetches and parses book data from the Open Library Search API.
     */
    public Book fetchGeneralSearch(String query, String searchType) throws IOException {
        String apiUrl = buildApiUrl(query, searchType);

        HttpURLConnection connection = getHttpURLConnection(apiUrl);
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseStream, Book.class);
        } else {
            log.error("GET Request for fetchGeneralSearch: " + connection.getResponseCode());
            throw new IOException("GET request failed. Response Code: " + connection.getResponseCode());
        }
    }

    private String getJwtToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getCredentials() instanceof String) {
            return (String) authentication.getCredentials();
        }
        return "";
    }
}
