package com.company.ProjectManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource
{
    public static final String DB_NAME="PROJECT.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\Akshaj\\Documents\\College Work\\2-2\\DBMS\\DBMSProject\\"+DB_NAME;

    public static final String TABLE_PROJECTS="projects";
    public static final String TABLE_STUDENTS="students";
    public static final String TABLE_PROFESSROS="professors";
    public static final String TABLE_WORKSON="workson";
    public static final String TABLE_SUPERVISES="supervises";
    public static final String TABLE_MANAGES="manages";
    public static final String TABLE_USERS="users";

    public static final String COLUMN_PROJECT_ID="project_id";
    public static final String COLUMN_PROJECT_NAME="project_name";
    public static final String COLUMN_PROJECT_STARTING_DATE="starting_date";
    public static final String COLUMN_PROJECT_END_DATE="end_date";

    public static final String COLUMN_STUDENT_ID="student_id";
    public static final String COLUMN_STUDENT_NAME="student_name";
    public static final String COLUMN_STUDENT_AGE="age";

    public static final String COLUMN_PROFESSOR_ID="professor_id";
    public static final String COLUMN_PROFESSOR_NAME="professor_name";
    public static final String COLUMN_PROFESSOR_DEPT_NAME="dept_name";

    public static final String COLUMN_WORKSON_PROJECT_ID="project_id";
    public static final String COLUMN_WORKSON_STUDENT_ID="student_id";

    public static final String COLUMN_SUPERVISES_PROFESSOR_ID="professor_id";
    public static final String COLUMN_SUPERVISES_STUDENT_ID="student_id";

    public static final String COLUMN_MANAGES_PROJECT_ID="project_id";
    public static final String COLUMN_MANAGES_PROFESSOR_ID="professor_id";

    public static final String COLUMN_USERS_USERNAME="username";
    public static final String COLUMN_USERS_PASSWORD="password";

    public static final int ORDER_BY_NONE=0;
    public static final int ORDER_BY_ASC=1;
    public static final int ORDER_BY_DESC=2;

    public static final String CREATE_TABLE_PROJECTS=
            "CREATE TABLE IF NOT EXISTS "+TABLE_PROJECTS+
                    "("+COLUMN_PROJECT_ID+" INT PRIMARY KEY,"+
                    COLUMN_PROJECT_NAME+" TEXT NOT NULL,"+
                    COLUMN_PROJECT_STARTING_DATE+" DATE,"+
                    COLUMN_PROJECT_END_DATE+" DATE)";
    public static final String CREATE_TABLE_STUDENTS=
            "CREATE TABLE IF NOT EXISTS "+TABLE_STUDENTS+
                    "("+COLUMN_STUDENT_ID+" INT PRIMARY KEY,"+
                    COLUMN_STUDENT_NAME+" TEXT NOT NULL,"+
                    COLUMN_STUDENT_AGE+" INT NOT NULL)";
    public static final String CREATE_TABLE_PROFESSORS=
            "CREATE TABLE IF NOT EXISTS "+TABLE_PROFESSROS+
                    "("+COLUMN_PROFESSOR_ID+" INT PRIMARY KEY,"+
                    COLUMN_PROFESSOR_NAME+" TEXT NOT NULL,"+
                    COLUMN_PROFESSOR_DEPT_NAME+" TEXT NOT NULL)";
    public static final String CREATE_TABLE_WORKSON=
            "CREATE TABLE IF NOT EXISTS "+TABLE_WORKSON+
                    "("+COLUMN_WORKSON_PROJECT_ID+" INT,"+
                    COLUMN_WORKSON_STUDENT_ID+" INT,"+
                    "FOREIGN KEY("+COLUMN_WORKSON_PROJECT_ID+") REFERENCES "+TABLE_PROJECTS+","+
                    "FOREIGN KEY("+COLUMN_WORKSON_STUDENT_ID+") REFERENCES "+TABLE_STUDENTS+","+
                    "PRIMARY KEY("+COLUMN_WORKSON_PROJECT_ID+","+COLUMN_WORKSON_STUDENT_ID+"))";
    public static final String CREATE_TABLE_SUPERVISES=
            "CREATE TABLE IF NOT EXISTS "+TABLE_SUPERVISES+
                    "("+COLUMN_SUPERVISES_PROFESSOR_ID+" INT,"+
                    COLUMN_SUPERVISES_STUDENT_ID+" INT,"+
                    "FOREIGN KEY("+COLUMN_SUPERVISES_PROFESSOR_ID+") REFERENCES "+TABLE_PROFESSROS+","+
                    "FOREIGN KEY("+COLUMN_SUPERVISES_STUDENT_ID+") REFERENCES "+TABLE_STUDENTS+","+
                    "PRIMARY KEY("+COLUMN_SUPERVISES_PROFESSOR_ID+","+COLUMN_SUPERVISES_STUDENT_ID+"))";
    public static final String CREATE_TABLE_MANAGES=
            "CREATE TABLE IF NOT EXISTS "+TABLE_MANAGES+
                    "("+COLUMN_MANAGES_PROJECT_ID+" INT,"+
                    COLUMN_MANAGES_PROFESSOR_ID+" INT,"+
                    "FOREIGN KEY("+COLUMN_MANAGES_PROJECT_ID+") REFERENCES "+TABLE_PROJECTS+","+
                    "FOREIGN KEY("+COLUMN_MANAGES_PROFESSOR_ID+") REFERENCES "+TABLE_PROFESSROS+","+
                    "PRIMARY KEY("+COLUMN_MANAGES_PROJECT_ID+","+COLUMN_MANAGES_PROFESSOR_ID+"))";
    public static final String CREATE_TABLE_USERS=
            "CREATE TABLE IF NOT EXISTS "+TABLE_USERS+"("+
                    COLUMN_USERS_USERNAME+" TEXT NOT NULL,"+
                    COLUMN_USERS_PASSWORD+" TEXT NOT NULL,"+
                    "PRIMARY KEY("+COLUMN_USERS_USERNAME+"))";

    public static final String QUERY_PROJECTS=
            "SELECT * FROM "+TABLE_PROJECTS;
    public static final String QUERY_PROFESSORS=
            "SELECT * FROM "+TABLE_PROFESSROS;
    public static final String QUERY_STUDENTS=
            "SELECT * FROM "+TABLE_STUDENTS;

    public static final String QUERY_WORKSON=
            "SELECT "+TABLE_STUDENTS+"."+COLUMN_STUDENT_ID+","+TABLE_STUDENTS+"."+COLUMN_STUDENT_NAME+","+TABLE_PROJECTS+"."+COLUMN_PROJECT_ID+","+TABLE_PROJECTS+"."+COLUMN_PROJECT_NAME+
                    " FROM "+TABLE_STUDENTS+
                    " INNER JOIN "+TABLE_WORKSON+" ON "+ TABLE_STUDENTS+"."+COLUMN_STUDENT_ID+"="+TABLE_WORKSON+"."+COLUMN_WORKSON_STUDENT_ID+
                    " INNER JOIN "+TABLE_PROJECTS+" ON "+TABLE_WORKSON+"."+COLUMN_WORKSON_PROJECT_ID+"="+TABLE_PROJECTS+"."+COLUMN_PROJECT_ID;
    public static final String QUERY_SUPERVISES=
            "SELECT "+TABLE_STUDENTS+"."+COLUMN_STUDENT_ID+","+TABLE_STUDENTS+"."+COLUMN_STUDENT_NAME+","+TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_ID+","+TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_NAME+
                    " FROM "+TABLE_STUDENTS+
                    " INNER JOIN "+TABLE_SUPERVISES+" ON "+TABLE_STUDENTS+"."+COLUMN_STUDENT_ID+"="+TABLE_SUPERVISES+"."+COLUMN_SUPERVISES_STUDENT_ID+
                    " INNER JOIN "+TABLE_PROFESSROS+" ON "+TABLE_SUPERVISES+"."+COLUMN_SUPERVISES_PROFESSOR_ID+"="+TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_ID;
    public static final String QUERY_MANAGES=
            "SELECT "+TABLE_PROJECTS+"."+COLUMN_PROJECT_ID+","+TABLE_PROJECTS+"."+COLUMN_PROJECT_NAME+","+TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_ID+","+TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_NAME+
                    " FROM "+TABLE_PROJECTS+
                    " INNER JOIN "+TABLE_MANAGES+" ON "+TABLE_PROJECTS+"."+COLUMN_PROJECT_ID+"="+TABLE_MANAGES+"."+COLUMN_MANAGES_PROJECT_ID+
                    " INNER JOIN "+TABLE_PROFESSROS+" ON "+TABLE_MANAGES+"."+COLUMN_MANAGES_PROFESSOR_ID+"="+TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_ID;

    public static final String INSERT_INTO_PROJECTS=
            "INSERT INTO "+TABLE_PROJECTS+" VALUES(?,?,?,?)";
    public static final String  INSERT_INTO_STUDENTS=
            "INSERT INTO "+TABLE_STUDENTS+" VALUES(?,?,?)";
    public static final String INSERT_INTO_PROFESSORS=
            "INSERT INTO "+TABLE_PROFESSROS+" VALUES(?,?,?)";
    public static final String INSERT_INTO_WORKSON=
            "INSERT INTO "+TABLE_WORKSON+" VALUES(?,?)";
    public static final String INSERT_INTO_SUPERVISES=
            "INSERT INTO "+TABLE_SUPERVISES+" VALUES(?,?)";
    public static final String INSERT_INTO_MANAGES=
            "INSERT INTO "+TABLE_MANAGES+" VALUES(?,?)";
    public static final String INSERT_INTO_USERS=
            "INSERT INTO "+TABLE_USERS+" VALUES(?,?)";

    public static final String QUERY_SEARCH_USER=
            "SELECT COUNT(*) FROM "+TABLE_USERS+
                    " WHERE "+COLUMN_USERS_USERNAME+"= ";

    private Connection conn;

    public boolean open()
    {
        try
        {
            conn= DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }

    public boolean close()
    {
        try
        {
            if(conn!=null)
                conn.close();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

    }

    public boolean create()
    {
        try(Statement statement=conn.createStatement())
        {
            statement.execute(CREATE_TABLE_USERS);
            statement.execute(CREATE_TABLE_PROJECTS);
            statement.execute(CREATE_TABLE_STUDENTS);
            statement.execute(CREATE_TABLE_PROFESSORS);
            statement.execute(CREATE_TABLE_WORKSON);
            statement.execute(CREATE_TABLE_SUPERVISES);
            statement.execute(CREATE_TABLE_MANAGES);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }

    public List<Projects> queryProjects(int sortOrder)
    {

        StringBuilder sb=new StringBuilder(QUERY_PROJECTS);
        if(sortOrder!=ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_PROJECT_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder==ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            List<Projects> projectsList=new ArrayList<>();
            while(res.next())
            {
                Projects project=new Projects();
                project.setProject_id(res.getInt(COLUMN_PROJECT_ID));
                project.setProject_name(res.getString(COLUMN_PROJECT_NAME));
                project.setProject_starting_date(res.getString(COLUMN_PROJECT_STARTING_DATE));
                project.setProject_end_date(res.getString(COLUMN_PROJECT_END_DATE));

                projectsList.add(project);
            }
            return projectsList;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<Students> queryStudents(int sortOrder)
    {

        StringBuilder sb=new StringBuilder(QUERY_STUDENTS);
        if(sortOrder!=ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_STUDENT_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder==ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            List<Students> studentsList=new ArrayList<>();
            while(res.next())
            {
                Students student=new Students();
                student.setStudent_id(res.getInt(COLUMN_STUDENT_ID));
                student.setStudent_name(res.getString(COLUMN_STUDENT_NAME));
                student.setAge(res.getInt(COLUMN_STUDENT_AGE));

                studentsList.add(student);
            }
            return studentsList;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<Professors> queryProfessors(int sortOrder)
    {

        StringBuilder sb=new StringBuilder(QUERY_PROFESSORS);
        if(sortOrder!=ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_PROFESSOR_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder==ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            List<Professors> professorsList=new ArrayList<>();
            while(res.next())
            {
                Professors professor=new Professors();
                professor.setProfessor_id(res.getInt(COLUMN_PROFESSOR_ID));
                professor.setProfessor_name(res.getString(COLUMN_PROFESSOR_NAME));
                professor.setDeptname(res.getString(COLUMN_PROFESSOR_DEPT_NAME));

                professorsList.add(professor);
            }
            return professorsList;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<WorksOn> queryWorksOn(int sortOrder)
    {
        StringBuilder sb=new StringBuilder(QUERY_WORKSON);
        if(sortOrder!=ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(TABLE_STUDENTS+"."+COLUMN_STUDENT_NAME);
            sb.append(",");
            sb.append(TABLE_PROJECTS+"."+COLUMN_PROJECT_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder==ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            List<WorksOn> worksOnList=new ArrayList<>();
            while(res.next())
            {
                WorksOn worksOn=new WorksOn();
                worksOn.setProjectID(res.getInt(3));
                worksOn.setStudentID(res.getInt(1));
                worksOn.setStudentName(res.getString(2));
                worksOn.setProjectName(res.getString(4));

                worksOnList.add(worksOn);
            }
            return worksOnList;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<Supervises> querySupervises(int sortOrder)
    {
        StringBuilder sb=new StringBuilder(QUERY_SUPERVISES);
        if(sortOrder!=ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(TABLE_STUDENTS+"."+COLUMN_STUDENT_NAME);
            sb.append(",");
            sb.append(TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder==ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            List<Supervises> supervisesList = new ArrayList<>();
            while (res.next())
            {
                Supervises supervises = new Supervises();
                supervises.setStudentID(res.getInt(1));
                supervises.setStudentName(res.getString(2));
                supervises.setProfessorID(res.getInt(3));
                supervises.setProfessorName(res.getString(4));

                supervisesList.add(supervises);
            }
            return supervisesList;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public List<Manages> queryManages(int sortOrder)
    {
        StringBuilder sb=new StringBuilder(QUERY_MANAGES);
        if(sortOrder!=ORDER_BY_NONE)
        {
            sb.append(" ORDER BY ");
            sb.append(TABLE_PROJECTS+"."+COLUMN_PROJECT_NAME);
            sb.append(",");
            sb.append(TABLE_PROFESSROS+"."+COLUMN_PROFESSOR_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder==ORDER_BY_DESC)
                sb.append("DESC");
            else
                sb.append("ASC");
        }
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            List<Manages> managesList=new ArrayList<>();
            while(res.next())
            {
                Manages manages=new Manages();
                manages.setProjectID(res.getInt(1));
                manages.setProjectName(res.getString(2));
                manages.setProfessorID(res.getInt(3));
                manages.setProfessorName(res.getString(4));

                managesList.add(manages);
            }
            return managesList;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertIntoStudents(int id,String name,int age) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement(INSERT_INTO_STUDENTS,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,age);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected!=1)
            throw new SQLException("Couldn't create new student field!");
        return true;
    }

    public boolean insertIntoProjects(int id,String name,String starting_date,String end_date) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement(INSERT_INTO_PROJECTS,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,starting_date);
        preparedStatement.setString(4,end_date);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected!=1)
        {
            throw new SQLException("Couldn't create new project field!");
        }
        return true;
    }

    public boolean insertIntoProfessors(int id,String name,String deptName) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement(INSERT_INTO_PROFESSORS,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,deptName);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected!=1)
        {
            throw new SQLException("Couldn't create new professor field!");
        }
        return true;
    }

    public boolean insertIntoWorksOn(int projectID,int studentID) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement(INSERT_INTO_WORKSON,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,projectID);
        preparedStatement.setInt(2,studentID);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected!=1)
        {
            throw new SQLException("Couldn't create new works on field!");
        }
        return true;
    }

    public boolean insertIntoSupervises(int professorID,int studentID) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement(INSERT_INTO_SUPERVISES,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,professorID);
        preparedStatement.setInt(2,studentID);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected!=1)
        {
            throw new SQLException("Couldn't create new supervising field!");
        }
        return true;
    }

    public boolean insertIntoManages(int projectID,int professorID) throws SQLException
    {
        PreparedStatement preparedStatement=conn.prepareStatement(INSERT_INTO_MANAGES,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,projectID);
        preparedStatement.setInt(2,professorID);
        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected!=1)
        {
            throw new SQLException("Couldn't create new managing field!");
        }
        return true;
    }

    public boolean signUpUser(String username,String password)
    {
        StringBuilder sb=new StringBuilder(QUERY_SEARCH_USER);
        sb.append("'"+username+"'");
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            int count=res.getInt(1);
            if(count==1)
                return true;
            else {
                PreparedStatement insertUser=conn.prepareStatement(INSERT_INTO_USERS);
                insertUser.setString(1,username);
                insertUser.setString(2,password);
                int rowsAffected=insertUser.executeUpdate();
                if(rowsAffected==1)
                    return false;
                else
                    return true;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e+"\n");
            return true;
        }
    }

    public boolean loginUser(String username,String password)
    {
        StringBuilder sb=new StringBuilder(QUERY_SEARCH_USER);
        sb.append("'"+username+"' AND "+COLUMN_USERS_PASSWORD+"='"+password+"'");
        try(Statement statement=conn.createStatement();
            ResultSet res=statement.executeQuery(sb.toString()))
        {
            int count=res.getInt(1);
            if(count==1)
                return true;
            return false;
        }
        catch(SQLException e)
        {
            System .out.println(e);
            return false;
        }
    }

}