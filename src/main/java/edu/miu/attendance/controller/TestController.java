package edu.miu.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        boolean error_status = (error != null?true:false);
        System.out.println("Error: "+error);
        model.addAttribute("loginError",error_status);
        return "login";
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

}
