package com.example.lionortiger;

import android.app.Application;
import com.parse.Parse;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qYAzSWM07sz8fElMf3LupZvkVOsXF6VdfexSk0sB")
                // if defined
                .clientKey("ZJzRo2s8rw7sb8zt5sWQQrVjRpEM998XK6mZmeop")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
