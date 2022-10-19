package kz.narxoz.javaee.finalSpring.controllers;


import kz.narxoz.javaee.finalSpring.model.Employee;
import kz.narxoz.javaee.finalSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping(value = "/")
    public String indexPage(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }


    @GetMapping(value = "/add")
    public String addPage() {
        return "add";
    }


    @PostMapping(value = "/addEmployee")
    public String addEmployee(@RequestParam(name = "firstname") String firstname,
                              @RequestParam(name = "lastname") String lastname,
                              @RequestParam(name = "age") int age,
                              @RequestParam(name = "phonenumber") long phonenumber,
                              @RequestParam(name = "address") String address,
                              @RequestParam(name = "position") String position,
                              @RequestParam(name = "salary") int salary) {

        Employee employee = new Employee();
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setAge(age);
        employee.setPhonenumber(phonenumber);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setSalary(salary);

        employeeRepository.save(employee);
        return "redirect:/";

    }


    @GetMapping(value = "/details{id}")
    public String details(@PathVariable(name = "id") Long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "details";
    }


    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "lastname") String lastname,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "phonenumber") long phonenumber,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "position") String position,
            @RequestParam(name = "salary") int salary) {

        Employee employee  = employeeRepository.findById(id).orElse(null);

        if(employee!=null){
            employee.setFirstname(firstname);
            employee.setLastname(lastname);
            employee.setAge(age);
            employee.setPhonenumber(phonenumber);
            employee.setAddress(address);
            employee.setPosition(position);
            employee.setSalary(salary);
            employeeRepository.save(employee);
            return "redirect:/";
        }
        return "redirect:/";
    }


    @PostMapping(value = "/deleteEmployee")
    public String deleteEmployee(
            @RequestParam(name = "id") Long id  ) {

        Employee employee  = employeeRepository.findById(id).orElse(null);

        if(employee!=null){
            employeeRepository.delete(employee);
            return "redirect:/";
        }



        return "redirect:/";

    }


}
