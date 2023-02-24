package com.example.atosrm.domain.use_cases.person_srm

import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMDao

object AddPersonUseCase {

    suspend fun execute(
        person: PersonSRM,
        dao: PersonSRMDao
    ) {
        dao.insertPerson(person = person)
    }

}