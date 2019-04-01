package com.ashik.moviemela.favorites;

import com.ashik.moviemela.Movie;

import java.util.List;


public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
