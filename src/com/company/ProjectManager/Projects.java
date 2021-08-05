package com.company.ProjectManager;

import java.util.Date;

public class Projects
{
    private int project_id;
    private String project_name;
    private String project_starting_date;
    private String project_end_date;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_starting_date() {
        return project_starting_date;
    }

    public void setProject_starting_date(String project_starting_date) {
        this.project_starting_date = project_starting_date;
    }

    public String getProject_end_date() {
        return project_end_date;
    }

    public void setProject_end_date(String project_end_date) {
        this.project_end_date = project_end_date;
    }
}
