package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("")
    public String showForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @RequestMapping("/add")
    public String addDonation(@Valid Donation donation, BindingResult result) {
        if(result.hasErrors()){
            return "form";
        }
        donationService.save(donation);
        return "form-confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.findAll();
    }

}
