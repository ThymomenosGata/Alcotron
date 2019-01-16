package org.wordy.alcotron.data.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.alcotron.data.tables.I_Never;

import java.util.List;

@Dao
public interface I_NeverDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(I_Never i_never);

    @Update
    void update(I_Never i_never);

    @Query("Select name from i_never")
    LiveData<List<String>> getAllNever();

}
