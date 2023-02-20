package com.example.atosrm.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMDao


@Database(
    entities = [
        PersonSRM::class
    ],
    version = 1
)
abstract class ApplicationDataBase: RoomDatabase() {

    abstract fun personSRMDao(): PersonSRMDao


    companion object {
        @Volatile var INSTANCE: ApplicationDataBase? = null

        fun getInstance(application: Application): ApplicationDataBase {
            var instance = INSTANCE
            synchronized(this) {
                if (instance == null){
                    instance = Room.databaseBuilder(
                        application,
                        ApplicationDataBase::class.java,
                        "person.dp"
                    ).allowMainThreadQueries().build()
                }
            }

            INSTANCE = instance

            return INSTANCE!!
        }
    }

}