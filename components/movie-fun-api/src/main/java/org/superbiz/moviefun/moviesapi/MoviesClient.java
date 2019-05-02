package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class MoviesClient {

    private static final Logger logger = LoggerFactory.getLogger(MoviesClient.class);
    private final RestOperations restOperations;
    private final String url;

    private static ParameterizedTypeReference<List<MovieInfo>> movieListType = new ParameterizedTypeReference<List<MovieInfo>>() {
    };

    public MoviesClient(RestOperations restTemplate, String url) {
        this.restOperations = restTemplate;
        this.url = url;
    }

    public void addMovie(MovieInfo movie) {
        logger.debug("Creating MovieInfo with title {}, and year {}", movie.getTitle(), movie.getYear());
        restOperations.postForEntity(url, movie, String.class);
    }


    public void updateMovie(MovieInfo movie) {
        restOperations.put(url + "/" + movie.getId(), movie);
    }


    public void deleteMovie(MovieInfo movie) {
        restOperations.delete(url + "/" + movie.getId());
    }


    public void deleteMovieId(long id) {
        restOperations.delete(url + "/" +id);
    }

    public List<MovieInfo> getMovies() {
        return restOperations.exchange(url,
                HttpMethod.GET,
                null,
                movieListType).getBody();
    }

    public List<MovieInfo> findAll(int firstResult, int maxResults) {
        List<MovieInfo> movies = restOperations.exchange(url + "/find",
                HttpMethod.GET,
                null,
                movieListType).getBody();

        return movies.subList(firstResult, firstResult + maxResults);
    }


    public int countAll() {
        return restOperations.exchange(url,
                HttpMethod.GET,
                null,
                movieListType).getBody().size();
    }

    public int count(String field, String searchTerm) {
        return restOperations.getForEntity(url + "/count?field="+field+"&search="+searchTerm, Integer.class).getBody();
    }

    public List<MovieInfo> findRange(String field, String searchTerm, int firstResult, int maxResults) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "/find")
                .queryParam("field", field)
                .queryParam("key", searchTerm)
                .queryParam("start", firstResult)
                .queryParam("pageSize", maxResults);

        return restOperations.exchange(builder.toUriString(), HttpMethod.GET, null, movieListType).getBody();
    }

}
