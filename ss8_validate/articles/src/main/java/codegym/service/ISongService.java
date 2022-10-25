package codegym.service;

import codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    void save(Song song);
    Song findById(int id);
    void update(Song song);
}
