package org.wordy.alcotron.data.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import org.wordy.alcotron.data.tables.Action;

import java.util.List;

@Dao
public interface ActionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Action action);

    @Update
    void update(Action action);

    @Query("Select name from `action`")
    LiveData<List<String>> getAllActions();

    @Query("Select max(id) from `action`")
    int getMaxId();

}
