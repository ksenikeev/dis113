package semestrii.gui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import semestrii.gui.model.Country;
import semestrii.gui.services.CountryService;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/country/shownative") //?pagesize=10&pagenumber=3
    public String getCountryByPageNative(Model model,
               @RequestParam Integer pagesize, @RequestParam Integer pagenumber) {
        List<Country> lst = service.getAllByPageNative(pagesize, pagenumber, "name");
        model.addAttribute("countryes", lst);
        return "countryes";
    }

    @GetMapping("/country/show") //?pagesize=10&pagenumber=3
    public String getCountryByPage(Model model,
                                   @RequestParam Integer pagesize, @RequestParam Integer pagenumber) {
        List<Country> lst = service.getAllByPage(pagesize, pagenumber);
        model.addAttribute("countryes", lst);
        return "countryes";
    }
}
