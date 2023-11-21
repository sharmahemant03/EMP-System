package com.employee.system.controller;

import com.employee.system.entity.Employee;
import com.employee.system.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/check")
    public String  check(){
        return "check";
    }

    @GetMapping("/home")
    public String home(Model m){

        List<Employee> emp=service.getAllEmployee();
        m.addAttribute("emp",emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm(){
        return "addemp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e) {  //after e in this line add the content written in brackets(, HttpSession session)

        System.out.println(e);
        service.addEmp(e);
//        session.setAttribute("msg", "Employee Added Successfully..");
        return "redirect:/home";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m){
        Employee e=service.getEmployeeById(id);
        m.addAttribute("emp",e);
        return "edit";

    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e){
        service.addEmp(e);
//        session.setAttribute("msg","Employee Data Updated Successfully..");


        return "redirect:/home";

    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        service.deleteEmp(id);
//        session.setAttribute("msg","Employee Deleted Successfully..");
        return "redirect:/home";
    }



}
