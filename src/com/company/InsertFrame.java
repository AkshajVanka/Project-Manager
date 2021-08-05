package com.company;

import com.company.ProjectManager.DataSource;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class InsertFrame extends JFrame
{

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemHelp;
    JLabel select;
    JButton btnProjects,btnStudents,btnProfessors,btnWorksOn,btnSupervises,btnManages;
    JButton iProject,iStudent,iProfessor,iWorksOn,iSupervises,iManages;

    JLabel lblStudentID,lblProjectID,lblProfessorID,
            lblStudentName,lblProjectName,lblProfessorName,
            lblStartingDate,lblEndDate,
            lblAge,
            lblDeptName,lblinserted;

    JTextField tfStudentID,tfStudentName,tfAge,
                tfProjectID,tfProjectName,tfStartingDate,tfEndDate,
                tfProfessorID,tfProfessorName,tfDeptName;

    JPanel p1,p2,p3,p4,p5,p[];

    DataSource dataSource;

    public InsertFrame()
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

        select=new JLabel("SELECT");
        btnProjects=new JButton("Projects");
        btnStudents=new JButton("Students");
        btnProfessors=new JButton("Professors");
        btnWorksOn=new JButton("WorksOn");
        btnSupervises=new JButton("Supervises");
        btnManages=new JButton("Manages");

        iProject=new JButton("Insert");
        iStudent=new JButton("Insert");
        iProfessor=new JButton("Insert");
        iWorksOn=new JButton("Insert");
        iSupervises=new JButton("Insert");
        iManages=new JButton("Insert");

        lblStudentID=new JLabel("Student ID : ");
        lblStudentName=new JLabel("Student Name : ");
        lblAge=new JLabel("Age : ");
        lblProjectID=new JLabel("Project ID : ");
        lblProjectName=new JLabel("Project Name : ");
        lblStartingDate=new JLabel("Starting Date : ");
        lblEndDate=new JLabel("End Data : ");
        lblProfessorID=new JLabel("Professor ID");
        lblProfessorName=new JLabel("Professor Name : ");
        lblDeptName=new JLabel("Department Name : ");
        lblinserted=new JLabel("");

        tfStudentID=new JTextField("",20);
        tfStudentName=new JTextField("",20);
        tfAge=new JTextField("",20);
        tfProjectID=new JTextField("",20);
        tfProjectName=new JTextField("",20);
        tfStartingDate=new JTextField("",20);
        tfEndDate=new JTextField("",20);
        tfProfessorID=new JTextField("",20);
        tfProfessorName=new JTextField("",20);
        tfDeptName=new JTextField("",20);

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1));
        p4=new JPanel();
        p4.setLayout(new FlowLayout());
        p5=new JPanel();
        p=new JPanel[4];
        for(int i=0;i<4;i++) {
            p[i] = new JPanel();
            p[i].setLayout(new FlowLayout());
        }

        setLayout(new GridLayout(5,1));
    }

    public void addComponentsToFrame()
    {
        setJMenuBar(menuBar);
        p1.add(select);

        p2.add(btnStudents);
        p2.add(btnProjects);
        p2.add(btnProfessors);
        p2.add(btnWorksOn);
        p2.add(btnSupervises);
        p2.add(btnManages);

        p5.add(lblinserted);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
    }

    public void clearText()
    {
        tfStudentID.setText("");
        tfStudentName.setText("");
        tfAge.setText("");
        tfProjectID.setText("");
        tfProjectName.setText("");
        tfStartingDate.setText("");
        tfEndDate.setText("");
        tfProfessorID.setText("");
        tfProfessorName.setText("");
        tfDeptName.setText("");
        lblinserted.setText("");
    }

    public void addActionListeners()
    {

        menuItemHelp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(InsertFrame.this,"Select the table and then enter Valid Inputs");
            }
        });

        btnStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();
                p3.removeAll();
                p3.setLayout(new GridLayout(3,1));

                for(int i=0;i<4;i++)
                    p[i].removeAll();

                p[0].add(lblStudentID);
                p[0].add(tfStudentID);
                p3.add(p[0]);

                p[1].add(lblStudentName);
                p[1].add(tfStudentName);
                p3.add(p[1]);

                p[2].add(lblAge);
                p[2].add(tfAge);
                p3.add(p[2]);

                p4.removeAll();
                p4.add(iStudent);

                revalidate();
                repaint();
            }
        });

        btnProjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();
                p3.removeAll();
                p3.setLayout(new GridLayout(4,1));

                for(int i=0;i<4;i++)
                    p[i].removeAll();

                p[0].add(lblProjectID);
                p[0].add(tfProjectID);
                p3.add(p[0]);

                p[1].add(lblProjectName);
                p[1].add(tfProjectName);
                p3.add(p[1]);

                p[2].add(lblStartingDate);
                p[2].add(tfStartingDate);
                p3.add(p[2]);

                p[3].add(lblEndDate);
                p[3].add(tfEndDate);
                p3.add(p[3]);

                p4.removeAll();
                p4.add(iProject);

                revalidate();
                repaint();
            }
        });

        btnProfessors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();
                p3.removeAll();
                p3.setLayout(new GridLayout(3,1));

                for(int i=0;i<4;i++)
                    p[i].removeAll();

                p[0].add(lblProfessorID);
                p[0].add(tfProfessorID);
                p3.add(p[0]);

                p[1].add(lblProfessorName);
                p[1].add(tfProfessorName);
                p3.add(p[1]);

                p[2].add(lblDeptName);
                p[2].add(tfDeptName);
                p3.add(p[2]);

                p4.removeAll();
                p4.add(iProfessor);

                revalidate();
                repaint();
            }
        });

        btnWorksOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();
                p3.removeAll();
                p3.setLayout(new GridLayout(2,1));

                for(int i=0;i<4;i++)
                    p[i].removeAll();

                p[0].add(lblStudentID);
                p[0].add(tfStudentID);
                p3.add(p[0]);

                p[1].add(lblProjectID);
                p[1].add(tfProjectID);
                p3.add(p[1]);

                p4.removeAll();
                p4.add(iWorksOn);

                revalidate();
                repaint();
            }
        });

        btnSupervises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();
                p3.removeAll();
                p3.setLayout(new GridLayout(2,1));

                for(int i=0;i<4;i++)
                    p[i].removeAll();

                p[0].add(lblStudentID);
                p[0].add(tfStudentID);
                p3.add(p[0]);

                p[1].add(lblProfessorID);
                p[1].add(tfProfessorID);
                p3.add(p[1]);

                p4.removeAll();
                p4.add(iSupervises);

                revalidate();
                repaint();
            }
        });

        btnManages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();

                p3.removeAll();
                p3.setLayout(new GridLayout(2,1));

                for(int i=0;i<4;i++)
                    p[i].removeAll();

                p[0].add(lblProjectID);
                p[0].add(tfProjectID);
                p3.add(p[0]);

                p[1].add(lblProfessorID);
                p[1].add(tfProfessorID);
                p3.add(p[1]);

                p4.removeAll();
                p4.add(iManages);

                revalidate();
                repaint();
            }
        });

        iStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=tfStudentName.getText();
                int id= Integer.parseInt(tfStudentID.getText());
                int age=Integer.parseInt(tfAge.getText());
                boolean inserted=false;
                try {
                    inserted=dataSource.insertIntoStudents(id,name,age);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
                if(inserted==true)
                    lblinserted.setText("NEW ROW INSERTED!!");
                else
                    lblinserted.setText("IN-VALID INPUT!!");
                revalidate();
                repaint();
            }
        });

        iProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfProjectName.getText();
                int id = Integer.parseInt(tfProjectID.getText());
                String startingDate=tfStartingDate.getText();
                String endDate=tfEndDate.getText();
                boolean inserted = false;
                try {
                    inserted = dataSource.insertIntoProjects(id, name, startingDate,endDate);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
                if (inserted == true)
                    lblinserted.setText("NEW ROW INSERTED!!");
                else
                    lblinserted.setText("IN-VALID INPUT!!");
                revalidate();
                repaint();
            }
        });
        iProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfProfessorName.getText();
                int id = Integer.parseInt(tfProfessorID.getText());
                String deptName = tfDeptName.getText();
                boolean inserted = false;
                try {
                    inserted = dataSource.insertIntoProfessors(id, name, deptName);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
                if (inserted == true)
                    lblinserted.setText("NEW ROW INSERTED!!");
                else
                    lblinserted.setText("IN-VALID INPUT!!");
                revalidate();
                repaint();
            }
        });

        iWorksOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sid = Integer.parseInt(tfStudentID.getText());
                int pid=Integer.parseInt(tfProjectID.getText());
                boolean inserted = false;
                try {
                    inserted = dataSource.insertIntoWorksOn(pid,sid);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
                if (inserted == true)
                    lblinserted.setText("NEW ROW INSERTED!!");
                else
                    lblinserted.setText("IN-VALID INPUT!!");
                revalidate();
                repaint();
            }
        });
        iSupervises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sid = Integer.parseInt(tfStudentID.getText());
                int pid=Integer.parseInt(tfProfessorID.getText());
                boolean inserted = false;
                try {
                    inserted = dataSource.insertIntoSupervises(pid,sid);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
                if (inserted == true)
                    lblinserted.setText("NEW ROW INSERTED!!");
                else
                    lblinserted.setText("IN-VALID INPUT!!");
                revalidate();
                repaint();
            }
        });

        iManages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int profid = Integer.parseInt(tfProfessorID.getText());
                int pid=Integer.parseInt(tfProjectID.getText());
                boolean inserted = false;
                try {
                    inserted = dataSource.insertIntoManages(pid,profid);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
                if (inserted == true)
                    lblinserted.setText("NEW ROW INSERTED!!");
                else
                    lblinserted.setText("IN-VALID INPUT!!");
                revalidate();
                repaint();
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