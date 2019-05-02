package org.superbiz.moviefun.moviesapi;

import java.util.Objects;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class AlbumInfo {

    private Long id;

    private String artist;
    private String title;
    private Integer year;
    private Integer rating;

    public AlbumInfo() { }

    public AlbumInfo(String artist, String title, Integer year, Integer rating) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumInfo albumInfo = (AlbumInfo) o;
        return id.equals(albumInfo.id) &&
                artist.equals(albumInfo.artist) &&
                title.equals(albumInfo.title) &&
                year.equals(albumInfo.year) &&
                rating.equals(albumInfo.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, title, year, rating);
    }
}
