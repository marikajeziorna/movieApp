package pl.javastart.myapp.movie.actor;

import org.springframework.stereotype.Service;
import pl.javastart.myapp.movie.Movie;

import java.util.Optional;

@Service
public class ActorService {

    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    void save(Actor actor) {
        actorRepository.save(actor);
    }

    void delete(Long id) {
        actorRepository.deleteById(id);
    }

    public Long findMovieIdForActorId(Long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        Actor actor = optionalActor.orElse(null);
        Movie actorN = actor.getMovie();
        return actorN.getId();
    }
}
