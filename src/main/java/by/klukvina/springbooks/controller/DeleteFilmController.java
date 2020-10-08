package by.klukvina.springbooks.controller;

import by.klukvina.springbooks.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Slf4j
@Controller
public class DeleteFilmController {
    private static final Logger log =  Logger.getLogger(DeleteFilmController.class.getName());
    @GetMapping("/deletefilm/{id}")
    public ModelAndView deleteProject(@PathVariable int id){

        Project project = FilmController.getProjectList().stream().filter(x->x.getId()==id).findFirst().get();
        FilmController.getProjectList().remove(project);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/film");
        log.info("/deletefilm - GET(DELETE)");
        return modelAndView;
    }

}
