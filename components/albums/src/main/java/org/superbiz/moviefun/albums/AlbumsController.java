package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final AlbumsRepository albumsRepository;
    private static final Logger logger = LoggerFactory.getLogger(AlbumsController.class);

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @GetMapping
    public List<Album> getAllAlbums() {
        logger.error("FETCHING ALBUMS");
        return albumsRepository.getAlbums();
    }

    @GetMapping("/{id}")
    public Album find(@PathVariable Long id) {
        logger.error("FETCHING ALBUM WITH ID {}", id);
        return albumsRepository.find(id);
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        logger.error(album.toString());
        logger.error("ADDING ALBUM {}", album.getTitle());
        albumsRepository.addAlbum(album);
    }
}
