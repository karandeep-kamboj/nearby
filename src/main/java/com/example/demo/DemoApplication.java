package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
 
    @Override
	public void run(String... args) throws Exception {
    	try {
    		
    		String sql = "create table if not exists User (name varchar(255),email varchar(255),password varchar(255),phone varchar(255),address varchar(255))";
            
            int result = jdbcTemplate.update(sql);
             
            if (result > 0) {
                System.out.println("User table has been Created");
            }
    	}
        catch(Exception e)
        {
        	System.out.println("Error in creating user table");
        }    
    }

}
