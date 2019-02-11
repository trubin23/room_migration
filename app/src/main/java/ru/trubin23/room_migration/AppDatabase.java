package ru.trubin23.room_migration;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
}