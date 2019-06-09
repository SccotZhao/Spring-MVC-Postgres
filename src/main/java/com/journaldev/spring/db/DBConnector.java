package com.journaldev.spring.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.journaldev.spring.model.User;
 
/**
 *
 * @author postgresqltutorial.com
 */

@Component
public class DBConnector{
 
    private final String url = "jdbc:postgresql://localhost:5432/guru99";
    private final String user = "postgres";
    private final String password = "root";
 

    public List<User> getUsers(String name){
        List<User> result = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT address FROM public.company where address="+ name);
            while (resultSet.next()) {
            	User user = new User();
            		user.setAddress( resultSet.getString("address"));
                result.add(user);
            }
            
            return result;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
}