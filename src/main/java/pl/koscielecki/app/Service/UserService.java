package pl.koscielecki.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.koscielecki.app.Repository.RoleRepository;
import pl.koscielecki.app.Repository.UserRepository;
import pl.koscielecki.app.model.Role;
import pl.koscielecki.app.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole=roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        return user;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
