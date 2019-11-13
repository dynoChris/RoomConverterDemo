package com.oliverstudio.roomconverterdemo.di;


import android.content.Context;

import com.oliverstudio.roomconverterdemo.MainActivity;
import com.oliverstudio.roomconverterdemo.di.modules.ContextModule;
import com.oliverstudio.roomconverterdemo.di.modules.RoomModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, RoomModule.class})
public interface AppComponent {

    Context getContext();

    void inject(MainActivity activity);

}
