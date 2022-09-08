package com.pydog.thymedemo.web;

import com.pydog.thymedemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @PostConstruct
    private void loadData() {
        this.employees = List.of(
                new Employee(1, "Dmitry", "Borisenko", "dmitry@mailserver.com"),
                new Employee(1, "Emma", "Smith", "emma@mailserver.com"),
                new Employee(1, "Robert", "Burton", "rob@mailserver.com")
        );
    }
}
