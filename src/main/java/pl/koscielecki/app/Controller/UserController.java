package pl.koscielecki.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.koscielecki.app.Repository.UserRepository;
import pl.koscielecki.app.Service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/all")
    public String allUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }
}
