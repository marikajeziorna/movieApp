package pl.javastart.myapp.movie.comment;

import org.springframework.stereotype.Service;
import pl.javastart.myapp.movie.Movie;

import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    void save(Comment comment) {
        commentRepository.save(comment);
    }

    void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public Long findMovieIdForCommentId(Long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment comment = optionalComment.orElse(null);
        Movie movie = comment.getMovie();
        return movie.getId();
    }
}
