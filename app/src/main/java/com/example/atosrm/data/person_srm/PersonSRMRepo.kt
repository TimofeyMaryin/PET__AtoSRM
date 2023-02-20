package com.example.atosrm.data.person_srm

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface PersonSRMRepo {

    suspend fun getAllUser(): MutableList<PersonSRM>
    suspend fun searchUser(search: String): MutableList<PersonSRM>
    suspend fun insertPerson(person: PersonSRM)
    suspend fun getUserById(id: Long): PersonSRM

}