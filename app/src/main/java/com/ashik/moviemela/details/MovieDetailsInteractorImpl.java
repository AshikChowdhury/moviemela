package com.ashik.moviemela.details;

import com.ashik.moviemela.Review;
import com.ashik.moviemela.ReviewsWrapper;
import com.ashik.moviemela.Video;
import com.ashik.moviemela.VideoWrapper;
import com.ashik.moviemela.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;


class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
