package org.digitallibrary.mainframe;

import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import java.awt.FlowLayout;

@Component
public class MainFrame extends JFrame {
    public MainCoordinator mainCoordinator;
    public MainDataProvider mainDataProvider;

    public MainFrame() {
        super("The Archive");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new FlowLayout());
        mainDataProvider = new MainDataProvider();
        mainCoordinator = new MainCoordinator(this, this.mainDataProvider);
        mainCoordinator.moveToDefaultPanel();
        validate();
    }
}
