package com.example.atosrm.presentation.fr.show_full_info_person

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.atosrm.domain.utils.decodeBitmap
import com.example.atosrm.presentation.MainActivityViewModel

class ShowPersonInfoViewModel(
    val mainViewModel: MainActivityViewModel,
    val navController: NavController
): ViewModel() {



    var personName by mutableStateOf(mainViewModel.personToShow?.fullInfo)
    var personSkills by mutableStateOf(mainViewModel.personToShow?.skills)
    var personFullInfo by mutableStateOf(mainViewModel.personToShow?.fullInfo )
    var personAvatar by mutableStateOf(mainViewModel.personToShow?.avatar?.decodeBitmap())


    fun initPerson() {
        personName = mainViewModel.personToShow!!.fullName
        personSkills = mainViewModel.personToShow!!.skills
        personFullInfo = mainViewModel.personToShow!!.fullInfo
        personAvatar = mainViewModel.personToShow!!.avatar.decodeBitmap()
    }
}