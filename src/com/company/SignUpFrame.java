package com.company;

import com.company.ProjectManager.DataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignUpFrame extends JFrame
{

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemHelp;
    JLabel labelUsername,labelPassword;
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton signUp;
    JPanel pnl;

    DataSource dataSource;

    public SignUpFrame()
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
        signUp=new JButton("Sign Up!");
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
        pnl.add(signUp);

        add(pnl);

    }

    public void addActionListeners()
    {

        menuItemHelp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(SignUpFrame.this,"Enter your Login credentials in order to create a new User!");
            }
        });

        signUp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username=tfUsername.getText();
                String password=pfPassword.getText();
                boolean userFound=dataSource.signUpUser(username,password);
                if(userFound==true)
                {
                    JOptionPane.showMessageDialog(SignUpFrame.this, "In-valid Input / User already exists!");
                    tfUsername.setText("");
                    pfPassword.setText("");
                }
                else
                {
                    dataSource.close();
                    UserFrame userFrame = new UserFrame();
                    userFrame.setName("Project Manager");
                    userFrame.setSize(1200, 1000);
                    userFrame.setVisible(true);
                    dispose();
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
