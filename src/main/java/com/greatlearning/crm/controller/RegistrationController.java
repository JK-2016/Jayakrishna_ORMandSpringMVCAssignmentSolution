package com.greatlearning.crm.controller;


import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
@Component
//@RequestMapping("/list-customers")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    public RegistrationController(RegistrationService registratonService){
        this.registrationService = registratonService;
    }

    /****************/
    @RequestMapping("/")
    public String redirectPage() {
        return "redirect:/list";
    }
    @RequestMapping("/showCustomerForm")
    public ModelAndView showCustomerForm(){
        return new ModelAndView("customer-form","command",new Customer());
    }
    @RequestMapping(value="/registerCustomer",method = RequestMethod.POST)
    public ModelAndView registerCustomer(@ModelAttribute("student") Customer theCustomer){
        //write code to save  object

        System.out.println(theCustomer.getId()+" "+ theCustomer.getFname()+
                " "+ theCustomer.getLname()+" " + theCustomer.getEmail());
        registrationService.registerCustomer(theCustomer);
        System.out.println("Student registered Successfully");
        //return new ModelAndView("empform","command",emp);
        return new ModelAndView("redirect:/list");
    }
    /*************************************/

//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//    public String showStudentForm(Model theModel){
//        Student theStudent = new Student();
//       theModel.addAttribute("student",theStudent);
//        return "student-form";
////        theModel.addAttribute("message",
////                "Hello World and Welcome to Spring MVC!");
//        //return "student-form";
//       //return "Student";
//    }
    @GetMapping("/list")
    public String getAllRegisteredCustomers(Model theModel){
        List<Customer> theCustomers = registrationService.getRegisteredCustomers();
        theModel.addAttribute("students", theCustomers);
        System.out.println("All registered students: \n"+ theCustomers.toString());
        return "list-customers";
    }
    @RequestMapping(value="/delete")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView deleteCustomerById(@RequestParam("studentId") int theId){
        registrationService.deleteCustomer(theId);
        Model theModel = new RedirectAttributesModelMap();
        System.out.println("The student with Id "+theId+" is deleted successfully");
        return new ModelAndView("redirect:/list");
    }


//    @RequestMapping(value="/updateForm")
//    public String updateStudent(@PathVariable int id, Model m){
//        Emp emp=dao.getEmpById(id);
//        m.addAttribute("command",emp);
//        return "empeditform";
//    }
    @RequestMapping(value="/updateForm")
    public String updateCustomer(@RequestParam("studentId") int theId, Model theModel) {
        Customer theCustomer = registrationService.getCustomer(theId);
        System.out.println("The details of student with id "+theId+" are updated from ");
        System.out.println(theCustomer.toString());
        theModel.addAttribute("command", theCustomer);
        return "edit-customer-form";
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Customer customer){
        registrationService.updateCustomerDetails(customer.getId(), customer);
        System.out.println("to :"+ customer.toString());
        return ("redirect:/list");
    }
//    @RequestMapping(value="/homePage")
//    public String showHomePage() {
//        return "index";
//    }



}
