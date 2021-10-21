package ru.vsu.cs.Lukashev;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public MainFrame( ) throws HeadlessException
    {
        super("Flasks by Color");
        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
        this.setSize(1300,1000);
        this.setBackground(Color.decode("#0f7367"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        System.out.println("that's from frame");
    }
}
