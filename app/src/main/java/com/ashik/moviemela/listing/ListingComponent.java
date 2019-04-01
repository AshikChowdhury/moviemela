package com.ashik.moviemela.listing;

import com.ashik.moviemela.listing.sorting.SortingDialogFragment;
import com.ashik.moviemela.listing.sorting.SortingModule;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent
{
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
