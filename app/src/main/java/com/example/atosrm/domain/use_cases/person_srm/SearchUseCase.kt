package com.example.atosrm.domain.use_cases.person_srm

import android.app.Application
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMImpl

object SearchUseCase {

    suspend fun execute(application: Application, searchRequest: String): MutableList<PersonSRM> = PersonSRMImpl(application = application).searchUser(search = searchRequest)

}