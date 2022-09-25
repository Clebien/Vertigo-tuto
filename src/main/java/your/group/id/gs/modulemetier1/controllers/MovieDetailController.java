package your.group.id.gs.modulemetier1.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.vertigo.ui.core.ViewContext;
import io.vertigo.ui.core.ViewContextKey;
import io.vertigo.ui.impl.springmvc.argumentresolvers.ViewAttribute;
import io.vertigo.ui.impl.springmvc.controller.AbstractVSpringMvcController;
import your.group.id.gs.modulemetier1.services.MovieServices;
import your.group.id.gs.modulemetier1.domain.Movie;

@Controller
@RequestMapping("/movie")
public class MovieDetailController extends AbstractVSpringMvcController {

    private static final ViewContextKey<Movie> movieKey = ViewContextKey.of("movie");

    @Inject
    private MovieServices movieServices;

    @GetMapping("/{movId}")
    public void initContext(final ViewContext viewContext, @PathVariable("movId") final Long movId) {
        viewContext.publishDto(movieKey, movieServices.getMovieById(movId));
        toModeReadOnly();
    }

    @GetMapping("/new")
    public void initContext(final ViewContext viewContext) {
        viewContext.publishDto(movieKey, new Movie());
        toModeCreate();
    }

    @PostMapping("/_edit")
    public void doEdit() {
        toModeEdit();
    }

    @PostMapping("/_save")
    public String doSave(@ViewAttribute("movie") final Movie movie) {
        movieServices.save(movie);
        return "redirect:/movie/" + movie.getMovId();
    }

}