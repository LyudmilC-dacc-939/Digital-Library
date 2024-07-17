package mainframe;

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
            APIResponse response = APIService.fetchJobs(location, industry, tag);
            jobs = new ArrayList<Job>(response.getJobs());
            loadBooksModel();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            jobs = new ArrayList<>();
            loadBooksModel();
            MessageWindow.popUpErrorMessage("Please enter a valid tag!");
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

    private void addBookRow(Book book) {
        String[] row = new String[3];
        row[0] = job.getCompanyName();
        row[1] = job.getJobTitle();
        row[2] = job.getJobGeo();
        jobsTableModel.addRow(row);
    }

    public Job getJobByIndex(int index) {
        return jobs.get(index);
    }
}
