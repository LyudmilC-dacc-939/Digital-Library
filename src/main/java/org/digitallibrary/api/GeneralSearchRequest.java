package org.digitallibrary.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.digitallibrary.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class GeneralSearchRequest {

    //@Value("${user.email}")
    @Setter
    private String userEmail;

    public Book fetchGeneralSearch(String searchQuery) throws IOException {
        final HttpURLConnection connection = getHttpURLConnection(searchQuery);
        System.out.println(userEmail);
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(responseStream, Book.class);
        } else {
            throw new IOException("GET request failed. Response Code: " + responseCode);
        }
    }

    private HttpURLConnection getHttpURLConnection(String searchQuery) throws IOException {
        String formattedStringInput = searchQuery.trim().replaceAll("\\s", "+");
        String urlString = String.format("https://openlibrary.org/search.json?q=%s", formattedStringInput);

        HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
        connection.setRequestMethod("GET");

        // Using the injected userEmail in the User-Agent header
        connection.setRequestProperty("User-Agent", "Digital Library/v1.1.0-alpha (" + userEmail + ")");
        connection.setRequestProperty("accept", "application/json");
        return connection;
    }
}
