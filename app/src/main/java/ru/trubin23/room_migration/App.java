package ru.trubin23.room_migration;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    private static App INSTANCE;

    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public static App getInstance() {
        return INSTANCE;
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}
