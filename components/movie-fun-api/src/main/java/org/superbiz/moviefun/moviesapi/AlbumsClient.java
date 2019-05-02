package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class AlbumsClient {

    private static final Logger logger = LoggerFactory.getLogger(AlbumsClient.class);
    private final RestOperations restOperations;
    private final String url;

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(RestOperations restOperations, String url) {
        this.restOperations = restOperations;
        this.url = url;
    }

    public void addAlbum(AlbumInfo album) {
        logger.debug("Creating AlbumInfo with title {}, and year {}", album.getTitle(), album.getYear());
        restOperations.postForEntity(url, album, String.class);
    }

    public AlbumInfo find(long id) {
        return restOperations.getForEntity(url + "/" + id, AlbumInfo.class).getBody();
    }

    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(url ,
                HttpMethod.GET,
                null,
                albumListType).getBody();
    }

//
//    public void deleteAlbum(AlbumInfo album) {
//        restOperations.delete(url + "/" + album.getId());
//    }
//
//    public void updateAlbum(AlbumInfo album) {
//        restOperations.put(url + "/" + album.getId(), album);
//    }
}
