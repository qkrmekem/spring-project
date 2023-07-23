package com.qkrmekem.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        if (authenticationService.authenticate(name, password)) {
            modelMap.addAttribute("name", name);
            modelMap.addAttribute("password", password);
            return "welcome";
        }
        modelMap.addAttribute("error", "윺효하지 않은 정보입니다. 다시 입력해주세요");
        return "login";
    }
}
