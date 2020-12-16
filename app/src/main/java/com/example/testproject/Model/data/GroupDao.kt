package com.example.testproject.Model.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGroup(group: Group)

    @Update
    suspend fun updateGroup(group: Group)

    @Delete
    suspend fun deleteGroup(group: Group)

    @Query("DELETE FROM group_table")
    suspend fun deleteAllGroups()

    @Query("SELECT * FROM group_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Group>>
}