package com.company;

import com.company.ProjectManager.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class DisplayFrame extends JFrame
{

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemHelp;
    JLabel select,lblSortOrder;
    JTextField tfSortOrder;
    JTextArea taOutput;
    JButton btnProjects,btnStudents,btnProfessors,btnWorksOn,btnSupervises,btnManages;
    JPanel p1,p2,p3,p4;

    DataSource dataSource;

    public DisplayFrame()
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
        btnProjects=new JButton("Projects");
        btnStudents=new JButton("Students");
        btnProfessors=new JButton("Professors");
        btnWorksOn=new JButton("Assigned Projects");
        btnSupervises=new JButton("Supervised Projects");
        btnManages=new JButton("Professors Managing");

        taOutput=new JTextArea("");
        taOutput.setSize(300,900);

        select=new JLabel("SELECT");
        lblSortOrder=new JLabel("Sort Order : ");

        tfSortOrder=new JTextField(Integer.toString(dataSource.ORDER_BY_ASC),20);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3));
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p3=new JPanel();
        p3.setLayout(new FlowLayout());
        p4=new JPanel();

        setLayout(new GridLayout(4,1));
    }

    public void addComponentsToFrame()
    {
        setJMenuBar(menuBar);

        p1.add(new JLabel());
        p1.add(select);

        p2.add(btnStudents);
        p2.add(btnProjects);
        p2.add(btnProfessors);
        p2.add(btnWorksOn);
        p2.add(btnSupervises);
        p2.add(btnManages);

        p3.add(new JLabel());
        p3.add(lblSortOrder);
        p3.add(tfSortOrder);

        p4.add(taOutput);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
    }

    public void addActionListeners()
    {
        menuItemHelp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(DisplayFrame.this,"Select the table,also based on your requirement you can set the sorting order to either NONE(0) or DESC(2) or ASC(for any other number)");
            }
        });

        btnStudents.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                taOutput.setText("");
                List<Students> studentsList=dataSource.queryStudents(Integer.parseInt(tfSortOrder.getText()));
                if(studentsList.isEmpty())
                    JOptionPane.showMessageDialog(DisplayFrame.this,"NO STUDENTS!!");
                else
                    for(Students student:studentsList)
                        taOutput.append("Student ID : "+student.getStudent_id()+",Student Name : "+student.getStudent_name()+",Age : "+student.getAge()+"\n");
            }
        });

        btnProjects.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                taOutput.setText("");
                List<Projects> projectsList = dataSource.queryProjects(Integer.parseInt(tfSortOrder.getText()));
                if (projectsList.isEmpty())
                    JOptionPane.showMessageDialog(DisplayFrame.this, "NO PROJECTS!!");
                else
                    for (Projects project : projectsList)
                        taOutput.append("Project ID : " + project.getProject_id() + ",Project Name : " + project.getProject_name() +
                                ",Starting Date : " + project.getProject_starting_date().toString() + ",Ending date : " + project.getProject_end_date().toString()+"\n");
            }
        });

        btnProfessors.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                taOutput.setText("");
                List<Professors> professorsList = dataSource.queryProfessors(Integer.parseInt(tfSortOrder.getText()));
                if (professorsList.isEmpty())
                    JOptionPane.showMessageDialog(DisplayFrame.this, "NO PROFESSORS!!");
                else
                    for (Professors professor : professorsList)
                        taOutput.append("Professor ID : "+professor.getProfessor_id()+",Professor Name : "+professor.getProfessor_name()+",Department Name : "+professor.getDeptname()+"\n");
            }
        });

        btnWorksOn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                taOutput.setText("");
                List<WorksOn> worksOnList=dataSource.queryWorksOn(Integer.parseInt(tfSortOrder.getText()));
                if(worksOnList.isEmpty())
                    JOptionPane.showMessageDialog(DisplayFrame.this,"None of the Projects are assigned to any Students!!");
                else
                    for(WorksOn worksOn:worksOnList)
                        taOutput.append("Student ID : "+worksOn.getStudentID()+",Student Name : "+worksOn.getStudentName()+ ",Project ID : "+worksOn.getProjectID()+",Project Name : "+worksOn.getProjectName()+"\n");
            }
        });

        btnSupervises.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                taOutput.setText("");
                List<Supervises> SupervisesList=dataSource.querySupervises(Integer.parseInt(tfSortOrder.getText()));
                if(SupervisesList.isEmpty())
                    JOptionPane.showMessageDialog(DisplayFrame.this,"None of the Professors are supervising any of the Students!!");
                else
                    for(Supervises Supervises:SupervisesList)
                        taOutput.append("Student ID : "+Supervises.getStudentID()+",Student Name : "+Supervises.getStudentName()+ ",Professor ID : "+Supervises.getProfessorID()+",Professor Name : "+Supervises.getProfessorName()+"\n");
            }
        });

        btnManages.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                taOutput.setText("");
                List<Manages> ManagesList=dataSource.queryManages(Integer.parseInt(tfSortOrder.getText()));
                if(ManagesList.isEmpty())
                    JOptionPane.showMessageDialog(DisplayFrame.this,"None of the Projects are managed by any Professors!!");
                else
                    for(Manages Manages:ManagesList)
                        taOutput.append("Project ID : "+Manages.getProjectID()+",Project Name : "+Manages.getProjectName()+ ",Professor ID : "+Manages.getProfessorID()+",Professor Name : "+Manages.getProfessorName()+"\n");
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