package pl.javastart.myapp.movie.actor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.myapp.movie.Movie;
import pl.javastart.myapp.movie.MovieRepository;

import java.util.Optional;

@Controller
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

        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        Movie movie = movieOptional.orElse(null);
        actor.setMovie(movie);
        actor.setNameActor(name);

        actorService.save(actor);

        return "redirect:/film/" + movieId;
    }

    @GetMapping("/deletactor/{id}")
    public String deleteComment(@PathVariable Long id){
        Long movieId = actorService.findMovieIdForActorId(id);
        actorService.delete(id);
        return "redirect:/film/" + movieId;
    }
}
