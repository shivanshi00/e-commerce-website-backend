package com.casestudy.ecart.service;

        import com.casestudy.ecart.Repository.UserRepository;
        import com.casestudy.ecart.models.Users;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.security.Principal;
        import java.util.Optional;
@Service
public class CurrentUserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<Users> CurrentUser(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username);
    }

    public Long getUserrId(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get().getId();
    }

    public String getUserRole(Principal principal) {
        return  userRepository.findByUsername(principal.getName()).get().getRole();
    }

    public Optional<Users> getUserProfile(Principal principal) {
        return userRepository.findByUsername(principal.getName());
    }

    public void checkDetails(Users user, Principal principal) {

    }
}

