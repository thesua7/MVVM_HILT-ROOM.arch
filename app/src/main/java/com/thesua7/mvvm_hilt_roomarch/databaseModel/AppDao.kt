package com.thesua7.mvvm_hilt_roomarch.databaseModel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("Select * from user order by id desc")
    fun getRecords() : List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)
}