/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author  Jayagoda N.M.  -  IT17184304
 */
public class QueryDB {
    static int columnCount;
    public static final String SQL_STATEMENT = "select * from lecturer";
    public static void main(String[] args) throws SQLException{
        Connection connection = DriverManager.getConnection(CreateDB.JDBC_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        
        int columnCount = resultSetMetaData.getColumnCount();
        
        for (int i = 1; i <= columnCount ; i++) {
            String colName = resultSetMetaData.getColumnName(i);
            System.out.print(colName+ "\t | " );
        }
        System.out.println();
        
        while(resultSet.next()){
            String lecturer_firstname = resultSet.getString(1);
            String lecturer_lastname = resultSet.getString(2);
            String emp_id = resultSet.getString(3);
            String faculty = resultSet.getString("faculty");
            String department = resultSet.getString("department");
            String building = resultSet.getString("building");
            int level = resultSet.getInt("level");
            String rank = resultSet.getString("rank");
            
            System.out.print(lecturer_firstname + "\t");
            System.out.print("   " + lecturer_lastname + "\t");
            System.out.print("   " + emp_id + "\t");
            System.out.print("   " + faculty + "\t");
            System.out.print("   " + department + "\t");
            System.out.print("   " + building + "\t");
            System.out.print("   " + level + "\t");
            System.out.println("   " + rank + "\t");
        }


//        resultSet = statement.executeQuery("SELECT COUNT(*) FROM lecturer");
//        // get the number of rows from the result set
//        resultSet.next();
//        int rowCount = resultSet.getInt(1);
//        System.out.println(rowCount);
        
        resultSet.close();
        statement.close();
        connection.close();
    }
}
