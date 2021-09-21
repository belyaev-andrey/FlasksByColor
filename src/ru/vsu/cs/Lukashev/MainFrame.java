package ru.vsu.cs.Lukashev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame
{
    private MainPanel mainPanel;
    private Color colorContainer;


    public MainFrame( ) throws HeadlessException
    {
        super("Flasks by Color");
        mainPanel=new MainPanel();

        this.add(mainPanel);
        this.setSize(1300,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
