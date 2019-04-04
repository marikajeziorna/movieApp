package pl.javastart.myapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTargetAudience(TargetAudience targetAudience);

}
