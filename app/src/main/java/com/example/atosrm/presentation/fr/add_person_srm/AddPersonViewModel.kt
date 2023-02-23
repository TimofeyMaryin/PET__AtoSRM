package com.example.atosrm.presentation.fr.add_person_srm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.atosrm.R
import com.example.atosrm.domain.model.TextFieldModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddPersonViewModel @Inject constructor(): ViewModel(){
    var personName by mutableStateOf("")
    var personSkills by mutableStateOf("")
    var personInfo by mutableStateOf("")
    var shortInfo by mutableStateOf("")

    var shortInfoMutableList = mutableListOf<String>()


    val textFieldInfo = mutableListOf(
        TextFieldModel(personName, R.string.place_holder_name, R.string.description_name) { personName += it; Log.e("AddPersonViewModel", "PersonName: $personName") },
        TextFieldModel(personSkills, R.string.place_holder_skills, R.string.description_skills) { personSkills = it },
        TextFieldModel(personInfo, R.string.place_holder_about_person, R.string.description_about_person) { personInfo = it },
        TextFieldModel(shortInfo, R.string.place_holder_short_info, R.string.description_short_info) { shortInfo = it }
    )

    fun addInfoToList() {
        shortInfoMutableList.add(shortInfo)
        shortInfo = ""
    }

    fun deleteShortInfoItem(index: Int) = shortInfoMutableList.removeAt(index)

}


