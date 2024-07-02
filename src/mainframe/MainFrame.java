package mainframe;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainCoordinator mainCoordinator;
    public MainDataProvider mainDataProvider;

    public MainFrame() {
        super("The Archive");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new FlowLayout());
        mainDataProvider = new MainDataProvider();
        mainCoordinator = new MainCoordinator(this);
        mainCoordinator.moveToDefaultPanel();
        validate();
    }
}
