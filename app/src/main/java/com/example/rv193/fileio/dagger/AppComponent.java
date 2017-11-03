package com.example.rv193.fileio.dagger;

import com.example.rv193.fileio.FileReaderWriter;
import com.example.rv193.fileio.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rv193 on 11/3/2017.
 */

@Singleton
@Component(modules = {
        FileModule.class, AppModule.class
})
public interface AppComponent {

    void inject(MainActivity target);
}
