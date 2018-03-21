package com.zignut.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.zignut.dao.AddressDao;
import com.zignut.model.AddressModel;

/**
 * Created by dbhavsar on 04-12-2017.
 */

@Database(entities = {AddressModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    private static AppDatabase INSTANCE_MAIN;

    public abstract AddressDao addressModelDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "ZignutsDB")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    //.allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static AppDatabase getAppDatabaseMainThread(Context context) {
        if (INSTANCE_MAIN == null) {
            INSTANCE_MAIN = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "LetsTripItDB")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE_MAIN;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
