package your.group.id.gs.modulemetier1.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.vertigo.ui.core.ViewContext;
import io.vertigo.ui.core.ViewContextKey;
import io.vertigo.ui.impl.springmvc.controller.AbstractVSpringMvcController;
import your.group.id.gs.modulemetier1.domain.Movie;
import your.group.id.gs.modulemetier1.services.MovieServices;

@Controller
@RequestMapping("/movies")
public class MovieListController extends AbstractVSpringMvcController {

    private static final ViewContextKey<Movie> moviesKey = ViewContextKey.of("movies");

    @Inject
    private MovieServices movieServices;

    @GetMapping("/")
    public void initContext(final ViewContext viewContext) {
        viewContext.publishDtList(moviesKey, movieServices.getAllMovies());
        toModeReadOnly();
    }

}