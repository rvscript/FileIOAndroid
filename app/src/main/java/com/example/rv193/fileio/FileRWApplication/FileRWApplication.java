package com.example.rv193.fileio.FileRWApplication;

import android.app.Application;

import com.example.rv193.fileio.dagger.AppComponent;
import com.example.rv193.fileio.dagger.AppModule;
import com.example.rv193.fileio.dagger.DaggerAppComponent;

/**
 * Created by rv193 on 11/3/2017.
 */

public class FileRWApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(FileRWApplication application){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
