package com.example.atosrm.data

import android.app.Application
import androidx.room.*
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMDao
import com.example.atosrm.data.person_srm.ShortInfoConverters


@Database(
    entities = [
        PersonSRM::class
    ],
    version = 9
)
@TypeConverters(ShortInfoConverters::class)
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
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }

            INSTANCE = instance

            return INSTANCE!!
        }
    }

}