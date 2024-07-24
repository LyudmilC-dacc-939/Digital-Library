package mainframe;

import api.Docs;
import api.GeneralSearchRequest;
import helper.MessageWindow;
import model.Book;
import model.User;
import repository.UserDatabase;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class MainDataProvider {
    private ArrayList<User> users = UserDatabase.fetchUsers();
    private DefaultTableModel booksTableModel;
    private ArrayList<Book> books;
    private Book book;
    private List<Docs> docs;

    public MainDataProvider(ArrayList<User> users,
                            DefaultTableModel booksTableModel,
                            ArrayList<Book> books,
                            Book book) {
        this.users = users;
        this.booksTableModel = booksTableModel;
        this.books = books;
        this.book = book;
    }

    public MainDataProvider() {
    }

    public boolean loginUser(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    //todo fix code below
    public MainDataProvider setBooksTableModel(DefaultTableModel booksTableModel) {

        this.booksTableModel = booksTableModel;
        return this;
    }

    public void fetchBooks(String query) {
        try {
            Book response = GeneralSearchRequest.fetchGeneralSearch(query);
            docs = new ArrayList<>(response.getDocs());
            loadBooksModel();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            docs = new ArrayList<>();
            loadBooksModel();
            MessageWindow.popUpErrorMessage();
        }
    }

    //todo fix book.getDocs logic
    public void loadBooksModel() {
        booksTableModel.setRowCount(0);
        for (Docs doc : book.getDocs()) {
            addBookRow(doc);
        }
    }

    public void searchQuery(String searchedBook) {
        booksTableModel.setRowCount(0);
        for (Docs doc : book.getDocs()) {
            if (book.getQ().toLowerCase().equals(searchedBook.toLowerCase())) {
                addBookRow(doc);
            }
        }
    }

    private void addBookRow(Docs docs) {
        String[] row = new String[4];
        row[0] = docs.getTitle();
        row[1] = docs.getAuthor_name();
        row[2] = String.valueOf(docs.getPublish_date());
        row[3] = String.valueOf(docs.getSubject());
        booksTableModel.addRow(row);
    }

    public Book getBookByIndex(int index) {
        return books.get(index);
    }
}
