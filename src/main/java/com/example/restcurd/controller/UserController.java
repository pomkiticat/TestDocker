package com.example.restcurd.controller;


import com.example.restcurd.Service.UserService;
import com.example.restcurd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/api/v1")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetchUserAll")
    public List<User> getUSerAll(){
        System.out.println("fetchUser f");
        List<User> users=userService.getUserAll();

        return users;
    }

    @GetMapping("/fetchAnyUser/{id}")
    public User getUserById(@PathVariable Integer id){
        User user=userService.getUser(id);
        return user;
    }

    @PostMapping("/saveUser")
    public  String saveUser(@RequestBody(required = false) User user){
        return userService.saveUser(user);
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable(value = "id") Integer id,@RequestBody(required = false) User user){
        System.out.println("ll");
      String result=userService.updateUser(id,user);
      return  result;

    }

    @DeleteMapping("/deleleUser/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer id) {

        String result= userService.deleteUser(id);

        if (result.equals("Delete successful")) {
            return ResponseEntity.noContent().build();
        }else {

            return ResponseEntity.notFound().build();
        }
    }
}
