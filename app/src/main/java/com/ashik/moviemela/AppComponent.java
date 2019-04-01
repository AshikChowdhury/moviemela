package com.ashik.moviemela;

import com.ashik.moviemela.details.DetailsComponent;
import com.ashik.moviemela.details.DetailsModule;
import com.ashik.moviemela.favorites.FavoritesModule;
import com.ashik.moviemela.listing.ListingComponent;
import com.ashik.moviemela.listing.ListingModule;
import com.ashik.moviemela.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
