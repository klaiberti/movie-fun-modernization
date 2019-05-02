package org.superbiz.moviefun.moviesapi;

import java.util.Objects;

public class MovieInfo {

    private Long id;
    private String director;
    private String title;
    private Integer year;
    private String genre;
    private Integer rating;

    public MovieInfo() {
    }

    public MovieInfo(String title, String director, String genre, int rating, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return id == movieInfo.id &&
                year == movieInfo.year &&
                rating == movieInfo.rating &&
                director.equals(movieInfo.director) &&
                title.equals(movieInfo.title) &&
                genre.equals(movieInfo.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, director, title, year, genre, rating);
    }

    public Long getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getRating() {
        return rating;
    }
}
