package org.digitallibrary.mainframe;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.digitallibrary.advice.exception.RecordNotFoundException;
import org.digitallibrary.api.GeneralSearchRequest;

import org.digitallibrary.model.Book;
import org.digitallibrary.model.User;
import org.digitallibrary.repository.UserRepository;
import org.digitallibrary.security.JwtService;
import org.digitallibrary.service.Impl.CurrentUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
@Data
@RequiredArgsConstructor
@Slf4j
public class MainDataProvider {

    private DefaultTableModel booksTableModel;
    private ArrayList<Book> books;
    private Book book;

    @Autowired
    private GeneralSearchRequest generalSearchRequest;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    CurrentUserImpl currentUserImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String jwtToken;

    private UserDetails currentUserDetails;

    //todo: The login method from defaultPanel must be moved in the MainDataProvider
    // in the place of the method below?
    public boolean loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }

    public void logoutUser() {
        SecurityContextHolder.clearContext();
    }

    public boolean isTokenValid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getCredentials() instanceof String)) {
            return false; // No token found
        }

        String jwtToken = (String) authentication.getCredentials();
        return jwtService.isValid(jwtToken, (UserDetails) authentication.getPrincipal());
    }

    public void fetchBooks(String query, String searchType) throws IOException {
        this.book = generalSearchRequest.fetchGeneralSearch(query, searchType);

        if (this.book != null && this.book.getDocs() != null) {
            loadBooksModel();
        } else {
            System.err.println("Error: Book or Docs are null.");
        }
    }

    public void loadBooksModel() {
        if (book == null || book.getDocs() == null) {
            log.error("Error: Book or Docs are null.");
            return;
        }

        booksTableModel.setRowCount(0);
        for (Book.Doc doc : book.getDocs()) {
            booksTableModel.addRow(new Object[]{
                    doc.getTitle(),
                    doc.getAuthor_name() != null ? String.join(", ", doc.getAuthor_name()) : "Unknown",
                    doc.getFirst_publish_year(),
                    doc.getEdition_count()
            });
        }
    }

    //todo: for now I will keep this method even though its not called anywhere...
    private void addBookRow(Book.Doc doc) {
        String[] row = new String[4];

        row[0] = doc.getTitle() != null ? doc.getTitle() : "Unknown Title";
        row[1] = (doc.getAuthor_name() != null && !doc.getAuthor_name().isEmpty())
                ? String.join(", ", doc.getAuthor_name())
                : "Unknown Author";
        row[2] = doc.getFirst_publish_year() != 0 ? String.valueOf(doc.getFirst_publish_year()) : "Unknown Year";
        row[3] = doc.getEdition_count() != 0 ? String.valueOf(doc.getEdition_count()) : "Unknown Edition Count";

        booksTableModel.addRow(row);
    }
}
