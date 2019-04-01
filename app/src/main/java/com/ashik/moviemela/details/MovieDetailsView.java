package com.ashik.moviemela.details;

import com.ashik.moviemela.Movie;
import com.ashik.moviemela.Review;
import com.ashik.moviemela.Video;

import java.util.List;

interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
