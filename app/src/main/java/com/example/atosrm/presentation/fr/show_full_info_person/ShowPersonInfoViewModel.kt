package com.example.atosrm.presentation.fr.show_full_info_person

import android.app.Person
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.domain.utils.decodeBitmap
import com.example.atosrm.domain.utils.saveImage
import com.example.atosrm.presentation.MainActivityViewModel
import com.example.atosrm.presentation.navigation.EDIT_PERSON_INFO
import com.example.atosrm.presentation.navigation.LIST_FRAGMENT

class ShowPersonInfoViewModel(
    val mainViewModel: MainActivityViewModel,
    val navController: NavController
): ViewModel() {


    var personAvatarUri by mutableStateOf<Uri?>(null)
    var personAvatarBitmap by mutableStateOf<Bitmap?>(null)

    var personName by mutableStateOf(mainViewModel.personToShow?.fullInfo)
    var personSkills by mutableStateOf(mainViewModel.personToShow?.skills)
    var personFullInfo by mutableStateOf(mainViewModel.personToShow?.fullInfo )
    var personAvatar by mutableStateOf(mainViewModel.personToShow?.avatar)


    fun initPerson() {
        personName = mainViewModel.personToShow!!.fullName
        personSkills = mainViewModel.personToShow!!.skills
        personFullInfo = mainViewModel.personToShow!!.fullInfo
        personAvatar = mainViewModel.personToShow!!.avatar
    }

    suspend fun editPerson() {
        mainViewModel.dao.updatePerson(
            person = PersonSRM(
                id = mainViewModel.personToShow!!.id,
                fullName = personName!!,
                skills = personSkills!!,
                fullInfo = personFullInfo!!,
                avatar = saveImage(personAvatarBitmap!!),
                shortInfo = mainViewModel.personToShow!!.shortInfo
            )
        )

        mainViewModel.navController.navigate(LIST_FRAGMENT) {
            popUpTo(EDIT_PERSON_INFO) {
                inclusive = true
            }
        }
    }
}