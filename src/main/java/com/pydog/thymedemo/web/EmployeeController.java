package com.pydog.thymedemo.web;

import com.pydog.thymedemo.entity.Employee;
import com.pydog.thymedemo.repository.EmployeeRepository;
import com.pydog.thymedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "list-employees";
    }

    @GetMapping("/employeeFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/employeeFormForUpdate")
    public String showFormForUpdate(Model model, @RequestParam("employeeId") int id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employeeForm";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
