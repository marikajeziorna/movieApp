package pl.javastart.myapp.movie.actor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.myapp.movie.Movie;
import pl.javastart.myapp.movie.MovieRepository;

import java.util.Optional;

public class ActorController {

    private ActorService actorService;
    private MovieRepository movieRepository;

    public ActorController(ActorService actorService, MovieRepository movieRepository) {
        this.actorService = actorService;
        this.movieRepository = movieRepository;
    }


    @PostMapping("/addactor")
    public String addActor(@RequestParam Long movieId,
                            @RequestParam String name) {

        Actor actor = new Actor();
        actor.setName(name);

        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        Movie movie = movieOptional.orElse(null);
        actor.setMovie(movie);

        actorService.save(actor);

        return "redirect:/film/" + movieId;
    }

}
