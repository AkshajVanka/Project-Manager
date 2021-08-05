package com.company;

import com.company.ProjectManager.DataSource;

public class Main
{

    public static void main(String[] args)
    {
        DataSource dataSource=new DataSource();
        dataSource.open();
        dataSource.create();
        dataSource.close();

        UserFrame userFrame=new UserFrame();
        userFrame.setName("Project Manager");
        userFrame.setSize(1200,1000);
        userFrame.setVisible(true);
    }

}