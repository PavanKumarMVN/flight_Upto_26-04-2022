package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserService;
import com.model.User;

@RestController
public class UserController {
	
@Autowired
UserService service;

@PostMapping("/adduser")
public ResponseEntity<?> addUser(@RequestBody User user) {
service.add(user);
return ResponseEntity.status(HttpStatus.OK).body("User added succesfully");
}

@DeleteMapping("/deleteuser/{id}")
public ResponseEntity<?> deleteUser(@PathVariable int id) throws DeleteException {
User user =service.find(id);
if(user==null) {
throw new DeleteException(id);
}
service.delete(id);
return ResponseEntity.ok("User deleted succesfully");
}

@PostMapping("/addregistereduser")
public ResponseEntity<?> addRegisteredUser(@RequestBody User user) {
service.add(user);
return ResponseEntity.status(HttpStatus.OK).body("User added succesfully");
}

@PatchMapping("/updateUser")
public ResponseEntity<?> updateUser(@RequestBody User user) 
{
	
	User u1=service.find(user.getId());
		if(u1==null) {
			throw new UpdateException();
		}
		service.update(user);
		return ResponseEntity.ok("User Updated Successfully");
		
	}
	
}

