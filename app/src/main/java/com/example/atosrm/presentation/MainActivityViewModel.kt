package com.example.atosrm.presentation

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMDao
import com.example.atosrm.data.person_srm.PersonSRMImpl
import com.example.atosrm.data.person_srm.PersonSRMRepo
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class MainActivityViewModel (
    private val navController: NavController,
    private val application: Application,
    private val dao: PersonSRMDao,
    private val addPersonViewModel: AddPersonViewModel,
): ViewModel() {

    var isOpenNonMainMenuEl by mutableStateOf(false)
    var currentNavBackState by mutableStateOf(LIST_FRAGMENT)

    suspend fun fabButtonAction(){
        if (!isOpenNonMainMenuEl) {
            _fab_action_in_main_screens()
        } else {
            _fab_action_when_create_person()
        }
    }

    private fun _fab_action_in_main_screens() {
        navController.navigate(ADD_PERSON_FRAGMENT)
        isOpenNonMainMenuEl = true
        currentNavBackState = ADD_PERSON_FRAGMENT
    }

    private suspend fun _fab_action_when_create_person() {
        Toast.makeText(application, "Person is created", Toast.LENGTH_SHORT).show()
        if (validateInfo()) {
            dao.insertPerson(
                person = PersonSRM(
                    fullName = addPersonViewModel.personName,
                    skills = addPersonViewModel.personSkills,
                    shortInfo = addPersonViewModel.shortInfoMutableList,
                    fullInfo = addPersonViewModel.personInfo,
                    avatar = addPersonViewModel.personAvatar
                )
            )

        }
    }

    private fun validateInfo(): Boolean {
        return addPersonViewModel.personName.isNotEmpty() &&
                addPersonViewModel.personSkills.isNotEmpty() &&
                addPersonViewModel.personInfo.isNotEmpty() &&
                addPersonViewModel.shortInfoMutableList.size != 0 &&
                addPersonViewModel.personAvatar.isNotEmpty()
    }


}