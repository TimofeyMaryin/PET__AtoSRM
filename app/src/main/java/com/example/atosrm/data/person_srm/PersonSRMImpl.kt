package com.example.atosrm.data.person_srm

import android.app.Application
import com.example.atosrm.data.ApplicationDataBase

class PersonSRMImpl(private val application: Application): PersonSRMRepo {
    override suspend fun getAllUser(): MutableList<PersonSRM> = ApplicationDataBase.getInstance(application = application).personSRMDao().getAllUser()
    override suspend fun searchUser(search: String): MutableList<PersonSRM> = ApplicationDataBase.getInstance(application = application).personSRMDao().searchUser(search = search)
    override suspend fun insertPerson(person: PersonSRM) = ApplicationDataBase.getInstance(application = application).personSRMDao().insertPerson(person = person)
    override suspend fun getUserById(id: Long): PersonSRM = ApplicationDataBase.getInstance(application = application).personSRMDao().getUserById(id = id)
}