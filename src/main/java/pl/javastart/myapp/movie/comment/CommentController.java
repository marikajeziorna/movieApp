package pl.javastart.myapp.movie.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.myapp.movie.Movie;
import pl.javastart.myapp.movie.MovieRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class CommentController {

    private CommentService commentService;
    private MovieRepository movieRepository;

    public CommentController(CommentService commentService,
                             MovieRepository movieRepository) {
        this.commentService = commentService;
        this.movieRepository = movieRepository;
    }

    @PostMapping("/addcomment")
    public String addComment(@RequestParam Long movieId,
                             @RequestParam String content, @RequestParam String author) {

        Comment comment = new Comment();
        comment.setAddedTime(LocalDateTime.now());
        comment.setContent(content);
        Optional<Movie> optional = movieRepository.findById(movieId);
        Movie movie = optional.orElse(null);
        comment.setMovie(movie);
        comment.setAuthor(author);

        commentService.save(comment);

        return "redirect:/film/" + movieId;
    }

    @GetMapping("/deletecomment/{id}")
    public String deleteComment(@PathVariable Long id){
        Long movieId = commentService.findMovieIdForCommentId(id);
        commentService.delete(id);
        return "redirect:/film/" + movieId;
    }
}
