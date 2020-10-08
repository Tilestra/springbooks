package by.klukvina.springbooks.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Slf4j
@Controller
public class IndexController {
    private static final Logger log =  Logger.getLogger(IndexController.class.getName());
    @Value("${welcome.message}")
    private String message;

    @GetMapping()
    public ModelAndView index(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        log.info("/, /index - GET");
        return modelAndView;
    }
}
