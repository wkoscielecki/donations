package pl.koscielecki.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.koscielecki.app.Service.CityService;
import pl.koscielecki.app.model.City;

import javax.validation.Valid;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping("/cityList")
    public String allCities(Model model) {
        model.addAttribute("cities", cityService.all());
        return "city/list";
    }
    @GetMapping("/addCity")
    public String addCity(Model model){
        model.addAttribute("city", new City());
        return "city/form";
    }
    @PostMapping("/addCity")
    public String save(@Valid City city, BindingResult result){
        if (result.hasErrors()) {
            return "/city/form";
        }
        cityService.save(city);
        return "redirect:/cityList";
    }
    @GetMapping("/editCity/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("city",cityService.findById(id));
        return "city/edit";

    }
    @PostMapping("/editCity")
    public String edit(@Valid City city, BindingResult result) {
        if (result.hasErrors()) {
            return "/city/edit";
        }
        cityService.save(city);
        return "redirect:/cityList";
    }
    @RequestMapping("/deleteCity/{id}")
    public String deleteCity(@PathVariable(name = "id") Long id){
        cityService.delete(id);
        return "redirect:/cityList";
    }
}
