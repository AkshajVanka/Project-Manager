package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserFrame extends JFrame
{

    JButton signUp,login;
    JMenu menu;
    JMenuBar menuBar;
    JMenuItem menuItemHelp;
    JPanel p1;

    public UserFrame()
    {
        initializeComponents();
        addComponentsToFrame();
        addListenerInterfaces();
    }

    private void initializeMenuBar()
    {
        menuBar=new JMenuBar();
        menu=new JMenu("Options");
        menuItemHelp=new JMenuItem("Help...");

        menu.add(menuItemHelp);
        menuBar.add(menu);
    }

    private void initializeComponents()
    {
        initializeMenuBar();
        signUp=new JButton("Sign Up");
        login=new JButton("Log In");

        p1=new JPanel();
        p1.setLayout(new GridLayout(3,1));
    }

    private void addComponentsToFrame()
    {
        setJMenuBar(menuBar);
        setLayout(new FlowLayout());
        p1.add(signUp);
        p1.add(new JLabel());
        p1.add(login);
        add(p1);
    }

    private void addListenerInterfaces()
    {

        menuItemHelp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(UserFrame.this,"Enter your Login credentials in order to access project Manager!");
            }
        });

        signUp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                SignUpFrame signUpFrame=new SignUpFrame();
                signUpFrame.setSize(1200,1000);
                signUpFrame.setVisible(true);
                signUpFrame.setName("Project Manager");
                dispose();
            }
        });

        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LoginFrame loginFrame=new LoginFrame();
                loginFrame.setSize(1200,1000);
                loginFrame.setVisible(true);
                loginFrame.setName("Project Manager");
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
