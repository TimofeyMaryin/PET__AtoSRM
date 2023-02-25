package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.presentation.MainActivityViewModel

class ShowPersonInfoViewModel(
    val mainViewModel: MainActivityViewModel,
    val navController: NavController
): ViewModel() {
    // Отвечяает за то, какую инфу надо изменять
    var typeEditInfo by mutableStateOf("")

    var valueEditInfo by mutableStateOf(getEditInfo())
    private val oldPerson by lazy { mainViewModel.personToShow!! }

    suspend fun editInfo() {
        mainViewModel.dao.insertPerson(
            person = mainViewModel.personToShow!!.copy(
                fullInfo = oldPerson.fullInfo,
                skills = oldPerson.skills,
                shortInfo = oldPerson.shortInfo,
                fullName = oldPerson.fullName,
                avatar = oldPerson.avatar
            )
        )
    }


    private fun getEditInfo(): String {
        return when(typeEditInfo) {
            "skills" -> { mainViewModel.personToShow!!.skills }
            "about" -> { mainViewModel.personToShow!!.fullInfo }
            "avatar" -> { "Avatar" }
            "tags" -> { "Tags" }
            else -> { "Nuh" }
        }
    }



}