package pl.koscielecki.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.koscielecki.app.Repository.UserRepository;
import pl.koscielecki.app.model.User;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user){

        userRepository.save(user);
        return user;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
