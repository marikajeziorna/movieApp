package pl.javastart.myapp.movie.comment;

import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    void save(Comment comment) {
        commentRepository.save(comment);
    }
}
