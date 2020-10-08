package by.klukvina.springbooks.controller;

import by.klukvina.springbooks.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Controller
public class FilmController {
    private static final Logger log =  Logger.getLogger(FilmController.class.getName());
    private static List<Project> projectList=new ArrayList<>();

    static{
        projectList.add(new Project(1, "Titanic", "2000-04-04", null));
        projectList.add(new Project(2, "InterStellar", "2012-04-07", null));
    }

    public static List<Project> getProjectList() {
        return projectList;
    }

    @GetMapping(value = "/film")
    public ModelAndView getAllProjects(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("film");
        model.addAttribute("film", projectList);
        log.info("/film - GET");
        return modelAndView;
    }


}
