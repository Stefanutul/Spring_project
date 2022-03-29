package com.example.EmployeeSystem.Controller;


import com.example.EmployeeSystem.Entity.Contestant;
import com.example.EmployeeSystem.Entity.Employee;
import com.example.EmployeeSystem.Entity.User;
import com.example.EmployeeSystem.Repository.UserRepo;
import com.example.EmployeeSystem.Service.ContestantService;
import com.example.EmployeeSystem.Service.CustomUserDetailsService;
import com.example.EmployeeSystem.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmpController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmpService service;

    @Autowired
    private ContestantService contestantService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @GetMapping("/")
    public String welcomePage(Model m) {

        List<Employee>  emp = service.getAllEmployees();
        m.addAttribute("emp",emp);

        return "welcome";
    }

    @GetMapping("/index")
    public String indexPage(Model m) {

        List<Employee>  emp = service.getAllEmployees();
        m.addAttribute("emp",emp);

        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/add_emp")
    public String addEmployeeForm() {
        return "add_emp";
    }

    @GetMapping("/manage_contestants")
    public String contestantPage(Model m) {

        List<Contestant> contestants = contestantService.getAllContestants();
        m.addAttribute("contestant", contestants);

        return "manage_contestants";
    }

    @GetMapping("/manage_users")
    public String userPage(Model m) {

        List<User> users = customUserDetailsService.getAllUsers();
        m.addAttribute("user", users);

        return "manage_users";
    }




        @PostMapping("/register")
    public  String empRegister(@ModelAttribute Employee e , HttpSession session){
        System.out.println(e);

        service.addEmp(e);
        session.setAttribute("msg" ,"Employee added successfully...");

      return "redirect:/index";
    }

    @PostMapping("/apply")
    public String applyForJob(@ModelAttribute Contestant cont , HttpSession session){

        contestantService.addContestant(cont);
        session.setAttribute("msg" ,"You have successfully applied for this job...");

        return "redirect:/users";
    }


    @GetMapping("/promote")
    public String showPromotionForm(Model model) {
        model.addAttribute("user", new User());

        return "promote";
    }


    @GetMapping("/signup_form")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping("/loginEmp")
    public String showEmployeeLogin(Model model) {
        return "loginEmp";
    }



    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }



    @RequestMapping("/loginEmp")
    public ModelAndView login() {
        return new ModelAndView("loginEmp");
    }

    @RequestMapping("/employee_details")
    public ModelAndView Employee_details() {
        return new ModelAndView("employee_details");
    }


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model m){

        Employee e = service.getEmployeeById(id);

        m.addAttribute("emp" , e);

        return "edit";
    }




    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable int id , Model m){

        User user = customUserDetailsService.getUserById(id);

        m.addAttribute("user" , user);

        return "editUser";
    }



    @GetMapping("/editApp/{id}")
    public String editApplication(@PathVariable int id , Model m ){

        Contestant contestant = contestantService.getContestantById(id);

        m.addAttribute("contestant" , contestant);
        contestantService.deleteContestant(id);

        return "promote";
    }


//    @PostMapping("/updateDescription")
//    public String updateEmployee(@ModelAttribute User user , HttpSession session){
//        use
//        session.setAttribute("msg" ," Employee data updated ...");
//        return "redirect:/index";
//    }


    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee e , HttpSession session){
        service.addEmp(e);
        session.setAttribute("msg" ," Employee data updated ...");
        return "redirect:/index";
    }

    @RequestMapping("/updateDescription")
    public String updateDescription(@ModelAttribute User user , HttpSession session ){
        customUserDetailsService.addDescription(user);
        session.setAttribute("msg" ," Employee description updated ...");
        return "redirect:/employee_details";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user , HttpSession session){
        customUserDetailsService.addUser(user);
        session.setAttribute("msg" ," User data updated ...");
        return "redirect:/manage_users";
    }

    @PostMapping("/updateContestant")
    public String updateContestant(@ModelAttribute Employee e   , HttpSession session){
        service.addEmp(e);
        session.setAttribute("msg" ," Promoted ...");
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public  String deleteEmployee(@PathVariable int id  , HttpSession session){
        service.deleteEmployee(id);
        session.setAttribute("msg" ," Employee deleted ...");
        return"redirect:/index";
    }

    @GetMapping("/deleteContestant/{id}")
    public  String deleteContestant(@PathVariable int id  , HttpSession session){
        contestantService.deleteContestant(id);
        session.setAttribute("msg" ," Application deleted ...");
        return"redirect:/manage_contestants";
    }


    @GetMapping("/deleteUser/{id}")
    public  String deleteUser(@PathVariable int id  , HttpSession session){
        customUserDetailsService.deleteUser(id);
        session.setAttribute("msg" ," User deleted ...");
        return"redirect:/manage_users";
    }


    @RequestMapping(value = "/position", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserPosition(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return currentUser.getPosition();
    }
}





