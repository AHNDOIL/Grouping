package com.AHNDOIL.Grouping.controller;

import com.AHNDOIL.Grouping.infra.AuthenticationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final AuthenticationFacade authenticationFacade;

    public HomeController(@Autowired AuthenticationFacade authenticationFacade){
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping
    public String home(){ //loging으로 접속한 사람 확인
        try{
            logger.info("Connected user: {}",
                    authenticationFacade.getUserName());
        }catch (NullPointerException e){
            logger.info("No user logged in");
        }
        return "index";
    }
}
