package codegym.reposiroty;

import codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongReposiroty extends JpaRepository<Song, Integer> {
    Page<Song> findAll(Pageable pageable) ;
    Song findById(int id);
}
