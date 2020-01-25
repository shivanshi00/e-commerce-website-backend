package com.casestudy.ecart.controller;

import com.casestudy.ecart.Repository.UserRepository;
import com.casestudy.ecart.models.Users;
import com.casestudy.ecart.service.CurrentUserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class MyProfileController {
    @Autowired
    CurrentUserService c;
    @Autowired
    UserRepository u;
    @GetMapping("/get")
    public Optional<Users> getData(Principal principal)
    {
        return c.getUserProfile(principal);
    }
   @PutMapping("/update")
    public Users update(@Valid @RequestBody Users users)
    {
    users.setActive(1);
    u.save(users);
        return users;
    }
}
