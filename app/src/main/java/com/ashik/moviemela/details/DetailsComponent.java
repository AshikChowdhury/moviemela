package com.ashik.moviemela.details;

import dagger.Subcomponent;


@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent
{
    void inject(MovieDetailsFragment target);
}
