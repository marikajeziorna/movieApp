package pl.javastart.myapp.movie;

import org.springframework.format.annotation.DateTimeFormat;
import pl.javastart.myapp.movie.actor.Actor;
import pl.javastart.myapp.movie.comment.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie {

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    @OrderBy("addedTime desc")
    public List<Comment> comments;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    public List<Actor> actors;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate premiereDate;
    private long budget;
    @Enumerated(EnumType.STRING)
    private TargetAudience targetAudience;

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
