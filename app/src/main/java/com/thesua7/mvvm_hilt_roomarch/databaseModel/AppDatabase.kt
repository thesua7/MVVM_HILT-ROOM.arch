package com.thesua7.mvvm_hilt_roomarch.databaseModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase :RoomDatabase() {

    abstract fun getDao() :AppDao

    companion object{
        private var dbInstance : AppDatabase? = null;


        fun getDBInstance(context: Context) : AppDatabase{
            if(dbInstance==null){
                dbInstance = Room.databaseBuilder<AppDatabase>(context.applicationContext,AppDatabase::class.java,"MyDb"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return dbInstance!!;
        }
    }

}