package your.group.id.gs.modulemetier1.services;

import javax.inject.Inject;

import io.vertigo.commons.transaction.Transactional;
import io.vertigo.core.node.component.Component;
import io.vertigo.datamodel.criteria.Criterions;
import io.vertigo.datamodel.structure.model.DtList;
import io.vertigo.datamodel.structure.model.DtListState;
import io.vertigo.core.lang.Assertion;
import your.group.id.gs.modulemetier1.dao.MovieDAO;
import your.group.id.gs.modulemetier1.domain.Movie;

@Transactional
public class MovieServices implements Component {

    @Inject
    private MovieDAO movieDAO;

    public Movie getMovieById(final Long movId) {
        Assertion.check().isNotNull(movId);
        //---
        return movieDAO.get(movId);
    }

    public DtList<Movie> getAllMovies() {
        return movieDAO.findAll(Criterions.alwaysTrue(), DtListState.of(100));
    }

    public Movie save(final Movie movie) {
        Assertion.check().isNotNull(movie);
        //---
        return movieDAO.save(movie);
    }
}
