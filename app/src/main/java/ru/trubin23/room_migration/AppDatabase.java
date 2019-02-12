package ru.trubin23.room_migration;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

@Database(entities = {Employee.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE employee ADD COLUMN birthday INTEGER DEFAULT 0 NOT NULL");
        }
    };
}