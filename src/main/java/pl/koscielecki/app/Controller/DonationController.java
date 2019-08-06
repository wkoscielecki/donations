package pl.koscielecki.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.koscielecki.app.Service.DonationService;

@Controller
public class DonationController {

    @Autowired
    DonationService donationService;

    @RequestMapping("/form")
    public String form(){
        return "donations/step1";
    }

   @RequestMapping("/step2")
    public String step2(){
        return "donations/step2";
    }

    @RequestMapping("/step3")
    public String step3(){
        return "donations/step3";
    }

    @RequestMapping("/step4")
    public String step4(){
        return "donations/step4";
    }

    @RequestMapping("/step5")
    public String step5(){
        return "donations/step5";
    }

    @RequestMapping("/step6")
    public String step6(){
        return "donations/step6";
    }

    @RequestMapping("/step7")
    public String step7(){
        return "donations/step7";
    }

    @RequestMapping("/allDonations")
    public String all(Model model){
        model.addAttribute("donations",donationService.findAll());
        return "donations/list";
    }
}
