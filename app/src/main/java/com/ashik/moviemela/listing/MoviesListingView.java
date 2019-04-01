package com.ashik.moviemela.listing;

import com.ashik.moviemela.Movie;

import java.util.List;

interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie);
}
