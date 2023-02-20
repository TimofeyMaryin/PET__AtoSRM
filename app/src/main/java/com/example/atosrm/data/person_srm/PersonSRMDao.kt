package com.example.atosrm.data.person_srm

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface PersonSRMDao {

    @Query("select * from person")
    suspend fun getAllUser(): MutableList<PersonSRM>

    @Query("SELECT * FROM person WHERE full_name LIKE :search")
    suspend fun searchUser(search: String): MutableList<PersonSRM>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPerson(person: PersonSRM)

    @Query("SELECT * FROM person WHERE id LIKE :id")
    suspend fun getUserById(id: Long): PersonSRM

}