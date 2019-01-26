package javathon16.Controllers;

import javathon16.Models.Company;
import javathon16.Repositories.CompanyRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        companyRepository.save(new Company(1, "coffy", 5));}
    @GetMapping("/api/company/getbyid")
    public Company getCompanyById ( @RequestParam(value = "id" )int id){
        return companyRepository.findById(id).get();
    }
    @PostMapping("/api/company/add")
    public String addcompany(@RequestParam (value = "name") String name,
                             @RequestParam ( value = "id") int id,
                             @RequestParam (value ="maxBonus" ) int maxBonus) {
        companyRepository.save(new Company(id, name, maxBonus));
        System.out.println(companyRepository.findById(1));
        return "qqq";
    }
}
