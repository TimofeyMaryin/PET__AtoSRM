package com.example.atosrm.domain.use_cases.person_srm

import android.app.Application
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMImpl

object EditPersonUseCase {

    suspend fun execute(application: Application, person: PersonSRM) = PersonSRMImpl(application = application).insertPerson(person = person)

}