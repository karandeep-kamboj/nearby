package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Coupen;
import com.example.demo.model.User;

@RestController
public class MyController {
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	@PostMapping(value="/registerUser")
    ResponseEntity<String> registerUser(@RequestBody User user){
    	try {
	    		String sql = "SELECT count(*) FROM USER WHERE email = '"+user.getEmail()+"'";
	    		Integer ct = jdbcTemplate.queryForObject(sql, Integer.class);
	    		if(ct>0) {
	    			return ResponseEntity.status(400).body("email already exist");
	    		}
	    		
	    		    
	    		sql = "insert into user values(?,?,?,?,?)";
	            jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getAddress());
	             
	            return ResponseEntity.ok("User Successfully Created");
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return ResponseEntity.status(404).body("Unable to create user");
    	}
    }
	
	@PostMapping(value="/loginUser")
    ResponseEntity<String> loginUser(@RequestBody User user){
    	try {
	    		String sql = "SELECT count(*) FROM USER WHERE email = '"+user.getEmail()+"'";
	    		Integer ct = jdbcTemplate.queryForObject(sql, Integer.class);
	    		if(ct>0) {
	    			return ResponseEntity.ok("Login Success");
	    		}
	    		else {
	    			return ResponseEntity.status(404).body("Wrong Email and Password");
	    		}
	    	
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    		return ResponseEntity.status(400).body("Unable to login");
    	}
    }
	
	
	
	
//    @GetMapping(value = "/getCoupens")
//    ResponseEntity<List<Coupen> > getCoupens(){
//    	
//    	String sql = "insert into table1 values(1,2)";
//        
//        int result = jdbcTemplate.update(sql);
//         
//        if (result > 0) {
//            System.out.println("table Created");
//        }
//    	return ResponseEntity.ok(coupenList);
//    }
//       
//    @PostMapping(value="/addCoupen")
//    ResponseEntity<String> addUser(@RequestBody Coupen coupen){
//    	try {
//    		this.coupenList.add(coupen);
//    		return ResponseEntity.ok("User has been added successfully");
//    	}
//    	catch(Exception e)
//    	{
//    		return ResponseEntity.status(404).body("Unable to add Coupen");
//    	}
//    }
//    
//    @GetMapping(value = "/getCart")
//    ResponseEntity<List<Coupen> > getCart(){
//    	System.out.println("GET CARTTTTTT");
//    	return ResponseEntity.ok(cartList);
//    }
//    
//    @PostMapping(value="/addCoupenToCart")
//    ResponseEntity<String> addCoupenToCart(@RequestBody Coupen coupen){
//    	try {
//    		this.cartList.add(coupen);
//    		return ResponseEntity.ok("User has been added successfully");
//    	}
//    	catch(Exception e)
//    	{
//    		return ResponseEntity.status(404).body("Unable to add Coupen");
//    	}
//    }
//    
//
//
//    @GetMapping(value="/user/{id}/friend")
//    String func(@PathVariable int id, @RequestParam(value = "search")String search,@RequestParam(value = "age")int age) {
//        return "id is " + id+"search is "+search+" age is "+age;
//    }
//
//    @PutMapping("/put")
//    public  ResponseEntity<String> put(@RequestBody String req) {
//        return ResponseEntity.ok(req);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> delete(@RequestBody String req) {
//        return ResponseEntity.status(400).body(req);
//    }
}
