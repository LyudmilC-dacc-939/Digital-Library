package org.digitallibrary.mainframe;

import lombok.Setter;
import org.digitallibrary.advice.exception.RecordNotFoundException;
import org.digitallibrary.api.GeneralSearchRequest;
import org.digitallibrary.helper.MessageWindow;
import org.digitallibrary.model.Book;
import org.digitallibrary.model.OldUser;
import org.digitallibrary.model.User;
import org.digitallibrary.repository.UserDatabase;
import org.digitallibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import javax.naming.InvalidNameException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

@Component
public class MainDataProvider {
    private List<OldUser> oldUsers = UserDatabase.fetchUsers();
    @Setter
    private DefaultTableModel booksTableModel;
    private ArrayList<Book> books;
    private Book book;

    @Autowired
    private GeneralSearchRequest generalSearchRequest;

    @Autowired
    private UserRepository userRepository;

    public MainDataProvider(ArrayList<OldUser> oldUsers,
                            DefaultTableModel booksTableModel,
                            ArrayList<Book> books,
                            Book book) {
        this.oldUsers = oldUsers;
        this.booksTableModel = booksTableModel;
        this.books = books;
        this.book = book;
    }

    public MainDataProvider() {
    }

    public boolean loginUser(String username, String password) {
        for (OldUser oldUser : this.oldUsers) {
            if (oldUser.getUsername().equals(username) && oldUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void fetchBooks(String query) {
        try {
            this.book = generalSearchRequest.fetchGeneralSearch(query);

            if (this.book != null && this.book.getDocs() != null) {
                loadBooksModel();
            } else {
                System.err.println("Error: Book or Docs are null.");
                MessageWindow.popUpErrorMessage();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            MessageWindow.popUpErrorMessage();
        }
    }

    public void loadBooksModel() {
        if (book == null || book.getDocs() == null) {
            System.err.println("Error: Book or Docs are null.");
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

    public void searchQuery(String searchedBook) {
        booksTableModel.setRowCount(0);
        String formattedInput = searchedBook.trim().toLowerCase();

        for (Book.Doc doc : book.getDocs()) {
            // Check if title or author matches the search query
            if (doc.getTitle().toLowerCase().contains(formattedInput) ||
                    (doc.getAuthor_name() != null &&
                            doc.getAuthor_name().stream().anyMatch(author -> author.toLowerCase().contains(formattedInput)))) {
                addBookRow(doc);
            }
        }
    }

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

    public Book getBookByIndex(int index) {
        return books.get(index);
    }

    public String getUserEmail(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new RecordNotFoundException(String.format("User with username: %s not found", username)));
        return user.getEmailAddress();
    }
}
