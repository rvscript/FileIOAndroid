package com.example.rv193.fileio.dagger;

import android.content.Context;

import com.example.rv193.fileio.FileReaderWriter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rv193 on 11/3/2017.
 */
@Module
public class FileModule {
    @Singleton
    FileReaderWriter provideFRW(Context context){
        return new FileReaderWriter();
    }
}
