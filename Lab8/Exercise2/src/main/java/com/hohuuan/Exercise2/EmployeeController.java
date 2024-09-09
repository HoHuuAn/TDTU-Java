package com.hohuuan.Exercise2;

import com.hohuuan.Exercise2.model.Employee;
import com.hohuuan.Exercise2.model.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository database;

    @GetMapping("")
    public String index(Model model){
        List<Employee> list = new ArrayList<>();
        database.findAll().forEach(list::add);

        model.addAttribute("employees", list);
        return "employee/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/add";
    }

    @PostMapping("/add")
    public String add(@Valid Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "employee/add";
        }

        database.save(employee);
        redirectAttributes.addFlashAttribute("flashMessage", "Employee added successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Employee employee = database.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id: " + id));
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("employee") @Valid Employee updatedEmployee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        Employee employee = database.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id: " + id));
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setPhone(updatedEmployee.getPhone());
        database.save(employee);
        redirectAttributes.addFlashAttribute("flashMessage", "Employee updated successfully!");
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        database.deleteById(id);
        redirectAttributes.addFlashAttribute("flashMessage", "Employee deleted successfully!");
        return "redirect:/employees";
    }


}
