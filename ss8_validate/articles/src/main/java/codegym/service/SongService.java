package codegym.service;

import codegym.model.Song;
import codegym.reposiroty.ISongReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongReposiroty iSongReposiroty ;
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongReposiroty.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        iSongReposiroty.save(song);
    }

    @Override
    public Song findById(int id) {
        return iSongReposiroty.findById(id);
    }

    @Override
    public void update(Song song) {
        iSongReposiroty.save(song);
    }
}
