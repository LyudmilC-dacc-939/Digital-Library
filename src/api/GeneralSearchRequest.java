package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeneralSearchRequest {
       public static Book fetchGeneralSearch(String searchQuery) throws IOException {
            String urlString = String.format(
                    "https://openlibrary.org/search.json?q=%s&fields=key,title,author_name,editions,editions.key,editions.title,editions.ebook_access,editions.language",
                    searchQuery.trim());

            URL url = new URL(urlString.toLowerCase());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    // Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestMethod("GET");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(responseStream, Book.class);
        }
}
