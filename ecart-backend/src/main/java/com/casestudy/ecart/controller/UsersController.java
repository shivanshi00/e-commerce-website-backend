package com.casestudy.ecart.controller;

import com.casestudy.ecart.Repository.UserRepository;
import com.casestudy.ecart.models.Users;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    UserRepository p1;
    @GetMapping("/validateUser")
    public String validateuser()
    {
        return "\"user validated\"";
    }
    @PostMapping("/addUsers")
    public Users addUsers(@Valid @RequestBody Users user)
    {
        return p1.save(user);
    }
    @GetMapping("/getUsers")
    public List<Users> getusers()
    {
        return p1.findAll();
    }
}
