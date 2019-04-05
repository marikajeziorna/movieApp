package pl.javastart.myapp.movie.actor;

public class ActorService {

    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    void save(Actor actor) {
        actorRepository.save(actor);
    }

}
