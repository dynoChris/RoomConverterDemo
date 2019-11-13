package com.oliverstudio.roomconverterdemo.di.modules;

import androidx.room.Room;


import com.oliverstudio.roomconverterdemo.App;
import com.oliverstudio.roomconverterdemo.data.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase() {
        return Room.databaseBuilder(App.getAppComponent().getContext(), AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

}