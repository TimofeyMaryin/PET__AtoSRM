package com.example.atosrm.presentation

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
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
import com.example.atosrm.domain.use_cases.person_srm.AddPersonUseCase
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel
import com.example.atosrm.presentation.navigation.ADD_PERSON_FRAGMENT
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT
import com.example.atosrm.presentation.navigation.SHOW_PERSONAL_FRAGMENT
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.ByteArrayOutputStream
import javax.inject.Inject


class MainActivityViewModel (
    private val navController: NavController,
    private val application: Application,
    val dao: PersonSRMDao,
    private val addPersonViewModel: AddPersonViewModel,
): ViewModel() {

    var isOpenNonMainMenuEl by mutableStateOf(false)
    var currentNavBackState by mutableStateOf(LIST_FRAGMENT)

    var personToShow by mutableStateOf<PersonSRM?>(null)
        private set

    suspend fun fabButtonAction(context: Context){
        if (!isOpenNonMainMenuEl) {
            _fab_action_in_main_screens()
        } else {
            _fab_action_when_create_person(context = context)
        }
    }

    private fun _fab_action_in_main_screens() {
        navController.navigate(ADD_PERSON_FRAGMENT)
        isOpenNonMainMenuEl = true
        currentNavBackState = ADD_PERSON_FRAGMENT
    }

    private suspend fun _fab_action_when_create_person(context: Context) {
        Toast.makeText(application, "Person is created", Toast.LENGTH_SHORT).show()
        if (validateInfo()) {

            AddPersonUseCase.execute(
                person = PersonSRM(
                    fullName = addPersonViewModel.personName,
                    skills = addPersonViewModel.personSkills,
                    shortInfo = addPersonViewModel.shortInfoMutableList,
                    fullInfo = addPersonViewModel.personInfo,
                    avatar = saveImage(addPersonViewModel.personAvatar!!),
                ),
                dao = dao,
            )
            navController.popBackStack()
            addPersonViewModel.cleanTextField()
            currentNavBackState = LIST_FRAGMENT
            isOpenNonMainMenuEl = !isOpenNonMainMenuEl
            Log.e("_fab_action_when_create_person", "count peroson: ${dao.getAllUser().size}", )
        }
    }

    private fun validateInfo(): Boolean {
        return addPersonViewModel.personName.isNotEmpty() &&
                addPersonViewModel.personSkills.isNotEmpty() &&
                addPersonViewModel.personInfo.isNotEmpty() &&
                addPersonViewModel.shortInfoMutableList.size != 0
    }

    private fun saveImage(bitmap: Bitmap): ByteArray {
        val data = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, data)

        return data.toByteArray()
    }


    fun showPersonFullInfo(personSRM: PersonSRM) {
        currentNavBackState = SHOW_PERSONAL_FRAGMENT
        personToShow = personSRM
        navController.navigate(SHOW_PERSONAL_FRAGMENT)
    }



}