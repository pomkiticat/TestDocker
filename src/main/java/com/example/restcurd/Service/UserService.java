package com.example.restcurd.Service;

import com.example.restcurd.Exception.ResourceNotFoundException;
import com.example.restcurd.Repository.UserRepository;
import com.example.restcurd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private static Integer newId=10;

    @Autowired
    private UserRepository repository;

    public List<User> getUserAll() {
        List<User> userList = repository.findAll();

        return userList;

    }

    public User getUser(Integer id) {
        Optional<User> user = repository.findById(id);

        return user.get();
    }

    public String saveUser(User user) {
        String result = "";
        try {
            if(user.getId()==0){
                user.setId(newId++);
                newId=newId++;
            }
            repository.save(user);
            result = "Success";
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "fail";
        }
        return result;
    }

    public String updateUser(Integer id, User user) {
        String result = "";
        User record = null;
        //Integer id=user.getId();
        Optional<User> userRecord = repository.findById(id);
        if (userRecord != null) {
            record = userRecord.get();
            try {
                repository.save(user);
                result = "Success update";
            } catch (Exception ex) {
                ex.printStackTrace();
                result = "fail update";
            }
        } else {
            result = "No user found";
        }
        return result;
    }

    public String deleteUser(Integer id) {
        String result = "";
        Optional<User> userRecord = repository.findById(id);
        User record = userRecord.get();

        if (userRecord != null) {
            record = userRecord.get();


            try {
                repository.delete(record);

                result = "Delete successful";
            } catch (Exception ex) {
                result = "Delete fail";
            }
        } else {
            result = "No user found";
        }


        return result;
    }
}
