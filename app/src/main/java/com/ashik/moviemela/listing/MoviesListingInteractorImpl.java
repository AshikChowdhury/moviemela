package com.ashik.moviemela.listing;

import android.support.annotation.NonNull;
import com.ashik.moviemela.Movie;
import com.ashik.moviemela.MoviesWraper;
import com.ashik.moviemela.favorites.FavoritesInteractor;
import com.ashik.moviemela.listing.sorting.SortType;
import com.ashik.moviemela.listing.sorting.SortingOptionStore;
import com.ashik.moviemela.network.TmdbWebService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;

class MoviesListingInteractorImpl implements MoviesListingInteractor {
    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final int NEWEST_MIN_VOTE_COUNT = 50;

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
    }


    @Override
    public boolean isPaginationSupported() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        return selectedOption != SortType.FAVORITES.getValue();
    }

    @Override
    public Observable<List<Movie>> fetchMovies(int page) {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            return tmdbWebService.popularMovies(page).map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies(page).map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.NEWEST.getValue()) {
            Calendar cal = Calendar.getInstance();
            String maxReleaseDate = dateFormat.format(cal.getTime());
            return tmdbWebService.newestMovies(maxReleaseDate, NEWEST_MIN_VOTE_COUNT).map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(favoritesInteractor.getFavorites());
        }
    }

    @Override
    public Observable<List<Movie>> searchMovie(@NonNull String searchQuery) {
        return tmdbWebService.searchMovies(searchQuery).map(MoviesWraper::getMovieList);
    }

}
