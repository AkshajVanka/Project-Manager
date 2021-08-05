package com.company;

import com.company.ProjectMainFrame;
import com.company.ProjectManager.DataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame
{

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemHelp;
    JLabel labelUsername,labelPassword;
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton login;
    JPanel pnl;

    DataSource dataSource;

    public LoginFrame()
    {
        initializeComponenets();
        addComponentsToFrame();
        addActionListeners();
        dataSource=new DataSource();
        dataSource.open();
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
        labelUsername=new JLabel("Username : ");
        labelPassword=new JLabel("Password : ");
        tfUsername=new JTextField();
        pfPassword=new JPasswordField();
        login=new JButton("Log In!");
        pnl=new JPanel();
        pnl.setLayout(new GridLayout(5,3));
    }

    public void addComponentsToFrame()
    {
        setJMenuBar(menuBar);
        setLayout(new FlowLayout());

        pnl.add(labelUsername);
        pnl.add(new JLabel());
        pnl.add(tfUsername);

        pnl.add(new JLabel());
        pnl.add(new JLabel());
        pnl.add(new JLabel());

        pnl.add(labelPassword);
        pnl.add(new JLabel());
        pnl.add(pfPassword);

        pnl.add(new JLabel());
        pnl.add(new JLabel());
        pnl.add(new JLabel());

        pnl.add(new JLabel());
        pnl.add(login);

        add(pnl);

    }

    public void addActionListeners()
    {

        menuItemHelp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(LoginFrame.this,"Enter your Login credentials in order to create a new User!");
            }
        });

        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username=tfUsername.getText();
                String password=pfPassword.getText();
                boolean loginValid=dataSource.loginUser(username,password);
                if(loginValid==true)
                {
                    dataSource.close();
                    ProjectMainFrame projectMainFrame=new ProjectMainFrame();
                    projectMainFrame.setSize(1200,1000);
                    projectMainFrame.setName("Project Manager");
                    projectMainFrame.setLayout(new FlowLayout());
                    projectMainFrame.setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(LoginFrame.this, "In-valid Credentials");
                    tfUsername.setText("");
                    pfPassword.setText("");
                }
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
