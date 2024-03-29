package com.ashik.moviemela.details;

import com.ashik.moviemela.Review;
import com.ashik.moviemela.Video;

import java.util.List;

import io.reactivex.Observable;


public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
