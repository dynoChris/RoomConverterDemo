package com.oliverstudio.roomconverterdemo;

import android.app.Application;

import com.oliverstudio.roomconverterdemo.di.AppComponent;
import com.oliverstudio.roomconverterdemo.di.DaggerAppComponent;
import com.oliverstudio.roomconverterdemo.di.modules.ContextModule;

public class App extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

}
