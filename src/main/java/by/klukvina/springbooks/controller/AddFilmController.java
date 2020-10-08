package by.klukvina.springbooks.controller;

import by.klukvina.springbooks.forms.ProjectForm;
import by.klukvina.springbooks.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Slf4j
@Controller
public class AddFilmController {
    private static final Logger log =  Logger.getLogger(AddFilmController.class.getName());

    @Value("${error.message}")
    private String error;

    @GetMapping(value = "/addfilm")
    public ModelAndView showAddProjectPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addFilm");
        ProjectForm projectForm = new ProjectForm();
        model.addAttribute("filmForm", projectForm);
        log.info("/addFilm - GET");
        return modelAndView;
    }

    @PostMapping(value = "/addfilm")
    public ModelAndView savePerson(Model model, //
                                   @ModelAttribute("filmForm") ProjectForm projectForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("film");
        String name=projectForm.getName();
        String date=projectForm.getCreationDate();
        if (name != null && name.length() > 0 //
                && date != null ) {
            Project newProject = new Project();
            newProject.setId(FilmController.getProjectList().get(FilmController.getProjectList().size()-1).getId()+1);
            newProject.setName(name);
            newProject.setCreationDate(date);
            FilmController.getProjectList().add(newProject);
            model.addAttribute("film", FilmController.getProjectList());
            log.info("/addFilm - POST");
            return modelAndView;
        }
        model.addAttribute("error", error);
        modelAndView.setViewName("addFilm");
        log.info("/addfilm - POST ERROR");
        return modelAndView;
    }
}
