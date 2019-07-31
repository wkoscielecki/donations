package pl.koscielecki.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.koscielecki.app.Repository.UserRepository;
import pl.koscielecki.app.Security.CurrentUser;
import pl.koscielecki.app.Service.UserService;
import pl.koscielecki.app.Validation.RegisterValidator;
import pl.koscielecki.app.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/users")
@SessionAttributes({"currentUser"})
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;



    @GetMapping(value = "/add")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/add")
    public String add(@Valid User user, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser, HttpServletRequest request){
        User userExist = userRepository.findByEmail(user.getEmail());

        new RegisterValidator().validateEmailExist(userExist, result);

        new RegisterValidator().validate(user, result);

        if (result.hasErrors()) {
            return "register";

        }else{

            userService.saveUser(user);

        }
        return "login";
    }
    @RequestMapping("/all")
    public String allUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }
//    @RequestMapping("/edit/{id}")
//    public String editUser(@PathVariable (name = "id") Long id){
//
//    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable (name = "id") Long id){
        userService.delete(id);
        return "redirect: user/list";
    }
}
