package pl.koscielecki.app.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.koscielecki.app.Security.CurrentUser;
import pl.koscielecki.app.model.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser == null) {
            model.addAttribute("user", new User());
            return "login";
        } else {
            return "redirect:/index";
        }
    }
}
