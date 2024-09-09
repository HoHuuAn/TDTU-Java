package com.hohuuan.Exercise1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController implements ErrorController {
    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String contactSubmit(@RequestParam String name, @RequestParam String email, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "contact-submit";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about(){
        return "About this site";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = "/{path:[^\\.]*}")
    public String error(HttpServletRequest req, Model model){
        int code = (int) req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String url = (String) req.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        model.addAttribute("code", code);
        model.addAttribute("url", url);

        return "error";
    }
}
