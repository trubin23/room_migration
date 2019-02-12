package ru.trubin23.room_migration;

import android.app.Application;
import android.arch.persistence.room.Room;

import static ru.trubin23.room_migration.AppDatabase.MIGRATION_1_2;
import static ru.trubin23.room_migration.AppDatabase.MIGRATION_2_3;

public class App extends Application {

    private static App INSTANCE;

    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database")
                .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
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
