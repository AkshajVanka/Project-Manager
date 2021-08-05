package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProjectMainFrame extends JFrame
{

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemHelp;
    JButton viewTables,insertIntoTables;
    JLabel welcome;
    JPanel pnl;

    public ProjectMainFrame()
    {
        initializeComponenets();
        addComponentsToFrame();
        addActionListeners();
    }

    public void initializeMenuBar()
    {
        menuBar=new JMenuBar();
        menu=new JMenu("Options");
        menuItemHelp=new JMenuItem("Help...");

        menu.add(menuItemHelp);
        menuBar.add(menu);
    }

    public void initializeComponenets()
    {
        initializeMenuBar();
        viewTables=new JButton("Display Tables!!");
        insertIntoTables=new JButton("Inert new values!!");
        welcome=new JLabel("Welcome the Project Manager!!           Select One:");
        pnl=new JPanel();
        pnl.setLayout(new GridLayout(1,4));
    }

    public void addComponentsToFrame()
    {
        setJMenuBar(menuBar);

        pnl.add(viewTables);
        pnl.add(new JLabel());
        pnl.add(new JLabel());
        pnl.add(insertIntoTables);

        add(welcome);
        add(new JLabel());
        add(pnl);
    }

    public void addActionListeners()
    {

        menuItemHelp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(ProjectMainFrame.this,"Select between displaying the values in the tables and inserting new data into them");
            }
        });

        viewTables.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DisplayFrame displayFrame=new DisplayFrame();
                displayFrame.setSize(1200,1000);
                displayFrame.setName("Project Manager");
                displayFrame.setVisible(true);
                dispose();
            }
        });

        insertIntoTables.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                InsertFrame insertFrame=new InsertFrame();
                insertFrame.setSize(1200,1000);
                insertFrame.setName("Project Manager");
                insertFrame.setVisible(true);
                dispose();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }

}