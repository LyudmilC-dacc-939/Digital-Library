package mainframe;

import api.Docs;
import api.GeneralSearchResponse;
import helper.MessageWindow;
import model.Book;
import model.User;
import repository.UserDatabase;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MainDataProvider {
    private ArrayList<User> users = UserDatabase.fetchUsers();
    private DefaultTableModel booksTableModel;
    private ArrayList<Book> books;

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

    public void fetchJobs(String location, String industry, String tag) {
        try {
            GeneralSearchResponse response = GeneralSearchResponse.fetchJobs(location, industry, tag);
            books = new ArrayList<Book>(response.getJobs());
            loadBooksModel();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            books = new ArrayList<>();
            loadBooksModel();
            MessageWindow.popUpErrorMessage();
        }
    }

    public void loadBooksModel() {

        booksTableModel.setRowCount(0);//за да изчисти таблицата всеки път след викането и, а не да дублира
        for (Book book : books) {
            addBookRow(book);
        }
    }

    public void searchJob(String searchedUser) {
        jobsTableModel.setRowCount(0);
        for (Job job : jobs) {
            if (job.getJobTitle().toLowerCase().contains(searchedUser.toLowerCase())) {
                addBookRow(job);
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
