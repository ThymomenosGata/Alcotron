package org.wordy.alcotron.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.wordy.alcotron.data.Dao.ActionDao;
import org.wordy.alcotron.data.Dao.I_NeverDao;
import org.wordy.alcotron.data.Dao.TruthDao;
import org.wordy.alcotron.data.tables.Action;
import org.wordy.alcotron.data.tables.I_Never;
import org.wordy.alcotron.data.tables.Truth;


@Database(
        entities = {
                Action.class,
                I_Never.class,
                Truth.class

        }, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    private static DataBase INSTANCE;

    public abstract I_NeverDao i_neverDao();

    public abstract ActionDao actionDao();

    public abstract TruthDao truthDao();

    public static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataBase.class, "org.wordy.alcotron.admin.database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
