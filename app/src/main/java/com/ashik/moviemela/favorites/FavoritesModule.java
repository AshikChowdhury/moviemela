package com.ashik.moviemela.favorites;

import com.ashik.moviemela.AppModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(includes = AppModule.class)
public class FavoritesModule
{
    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store)
    {
        return new FavoritesInteractorImpl(store);
    }
}
