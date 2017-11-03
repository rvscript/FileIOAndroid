package com.example.rv193.fileio.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rv193 on 11/3/2017.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this .application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
