package by.klukvina.springbooks.controller;

import by.klukvina.springbooks.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Slf4j
@Controller
public class EditFilmController {
    private static final Logger log =  Logger.getLogger(EditFilmController.class.getName());
    @GetMapping("/editFilm/{id}")
    public ModelAndView editProject(@PathVariable int id){
        Project project = FilmController.getProjectList().stream().filter(x->x.getId()==id).findFirst().get();
        ModelAndView modelAndView = new ModelAndView("editFilm");
        modelAndView.addObject("film", project);
        log.info("/editFilm - GET");
        return modelAndView;
    }

    @PostMapping("/editFilm")
    public ModelAndView saveEditProject(@ModelAttribute("film") Project project){
        FilmController.getProjectList().get(project.getId()).setName(project.getName());
        FilmController.getProjectList().get(project.getId()).setCreationDate(project.getCreationDate());
        FilmController.getProjectList().get(project.getId()).setFinishDate(project.getFinishDate());
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/film");
        log.info("/editFilm - POST");
        return modelAndView;
    }
}
